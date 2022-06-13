package nl.ns.task.jokefinder.route;

import nl.ns.task.jokefinder.domain.model.Root;
import nl.ns.task.jokefinder.exception.GenericExceptionHandler;
import nl.ns.task.jokefinder.mapper.JokesMessagesExchangeMapper;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        .setHeader(Exchange.HTTP_QUERY, simple("type=single&amount=16"))
        .to("https://v2.jokeapi.dev/joke/Any?bridgeEndpoint=true")
        .id("getJokesRouteEndpoint")
        .unmarshal().json(JsonLibrary.Jackson, Root.class)
        .bean(JokesMessagesExchangeMapper.BEAN, JokesMessagesExchangeMapper.TO_DOMAIN_METHOD)
        .id("afterdomain")
        .bean(JokesMessagesExchangeMapper.BEAN, JokesMessagesExchangeMapper.TO_Response_Object_METHOD)
        .id("mintNumberPortingCancelRouteEndpoint");


  }

}
