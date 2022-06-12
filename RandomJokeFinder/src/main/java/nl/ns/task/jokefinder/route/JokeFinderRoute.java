package nl.ns.task.jokefinder.route;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import nl.ns.task.jokefinder.domain.model.Jokes;
import nl.ns.task.jokefinder.domain.model.Root;
import nl.ns.task.jokefinder.exception.GenericExceptionHandler;
import nl.ns.task.jokefinder.mapper.JokesMessagesExchangeMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Post Cancel Route.
 *
 * @author bbasu
 */
@Component
public class JokeFinderRoute extends RouteBuilder {

  Logger logger = LoggerFactory.getLogger(JokeFinderRoute.class);

  @Autowired
  GenericExceptionHandler genericExceptionHandler;


  @Override
  public void configure() throws Exception {

    errorHandler(genericExceptionHandler.appErrorHandler());

    from("direct:getRandomJoke").id("routeRandomJokeRoute")
        .bean(JokesMessagesExchangeMapper.BEAN,JokesMessagesExchangeMapper.TO_DOMAIN_METHOD)
        .id("afterdomain")
        .bean(JokesMessagesExchangeMapper.BEAN,JokesMessagesExchangeMapper.TO_Response_Object_METHOD)
        .id("mintNumberPortingCancelRouteEndpoint");


  }

}
