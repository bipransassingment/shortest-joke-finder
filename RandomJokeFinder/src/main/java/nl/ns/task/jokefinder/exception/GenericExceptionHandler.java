package nl.ns.task.jokefinder.exception;

import org.apache.camel.builder.DeadLetterChannelBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Global Error Handler.
 *
 * @author bbasu
 */
@Component
public class GenericExceptionHandler extends RouteBuilder {

  /**
   * The creates a new deadletter exception.
   */
  @Bean
  public DeadLetterChannelBuilder appErrorHandler() {
    var deadLetterChannelBuilder = new DeadLetterChannelBuilder();
    deadLetterChannelBuilder.setDeadLetterUri("direct:error");
    deadLetterChannelBuilder.logHandled(false);
    // deadLetterChannelBuilder.setRedeliveryPolicy(new RedeliveryPolicy().disableRedelivery());
    deadLetterChannelBuilder.useOriginalMessage();
    return deadLetterChannelBuilder;
  }

  /**
   * <b>Called on initialization to build the routes using the fluent builder syntax.</b>
   * <p/>
   * This is a central method for RouteBuilder implementations to implement the routes using the
   * Java fluent builder syntax.
   *
   * @throws Exception can be thrown during configuration
   */
  @Override
  public void configure() throws Exception {

    from("direct:error").routeId("errorHandlerDirectComponent")
        .process(new GlobalErrorProcessor());
  }
}
