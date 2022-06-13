package nl.ns.task.jokefinder.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import nl.ns.task.jokefinder.domain.model.Jokes;
import nl.ns.task.jokefinder.domain.model.Root;
import nl.ns.task.jokefinder.exception.BlankDataReturnedFromServerException;
import nl.ns.task.jokefinder.model.Joke;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * NumberPortingCancelMessageExchangeMapper.
 */
@Component(JokesMessagesExchangeMapper.BEAN)
public class JokesMessagesExchangeMapper {

  /**
   * Component name for bean component.
   */
  public static final String BEAN = "jokesMessagesExchangeMapper";
  public static final String TO_DOMAIN_METHOD =
      "jokesMessageInfraToDomainJokesMessageConverter";
  public static final String TO_Response_Object_METHOD =
      "domainJokesMessageToResponseObjectConverter";

  /**
   * Maps CancelMessage domain object to coinMessage Infra object.
   *
   * @param exchange The Camel Exchange object
   */
  public void jokesMessageInfraToDomainJokesMessageConverter(Exchange exchange)
      throws JsonProcessingException {

    var response = (Root) exchange.getIn().getBody();
    List<Jokes> response2 =
        response.getJokes().stream()
            .filter(jokes -> (jokes.getFlags().isSexist() ==true || jokes.getFlags().isExplicit() ==true))
            .collect(Collectors.toList());
    response.getJokes().removeAll(response2);

    Optional<Jokes> smallestJoke = response.getJokes().stream()
        .sorted( (i1, i2) -> {
          if(i1.getJoke().length() > i2.getJoke().length())
            return 1;
          else return -1;
        } )
        .collect(Collectors.toList())
        .stream().findFirst();
    System.out.println("Response " + smallestJoke.get().getJoke());
    exchange.getIn().setBody(smallestJoke);
  }

  /**
   * Maps CancelMessage domain object to coinMessage Infra object.
   *
   * @param exchange The Camel Exchange object
   */
  public void domainJokesMessageToResponseObjectConverter(Exchange exchange)
      throws JsonProcessingException, BlankDataReturnedFromServerException {

    Optional<Jokes> message = (Optional<Jokes>) exchange.getIn().getBody();

    if (message.get().getId()==0 || message.get().getJoke() == "") {
      throw new BlankDataReturnedFromServerException("Cannot order: kaboom");
    }

    Joke message1 = new Joke();
    message1.setId(message.get().getId());
    message1.setRandomJoke(message.get().getJoke());
    exchange.getIn().setBody(message1);
  }
}
