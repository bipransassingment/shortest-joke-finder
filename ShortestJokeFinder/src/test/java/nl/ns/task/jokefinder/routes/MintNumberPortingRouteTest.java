package nl.ns.task.jokefinder.routes;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import javax.annotation.Nullable;
import nl.ns.task.jokefinder.domain.model.Root;
import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.shaded.okhttp3.MediaType;
import org.testcontainers.shaded.okhttp3.RequestBody;
import org.testcontainers.shaded.okio.BufferedSink;

/**
 * Unit Test for Porting Route.
 * 
 * @author bbasu
 *
 */

class MintNumberPortingRouteTest extends
    UnitTest {

  @Autowired
  ObjectMapper objectMapper;

  @Produce(value = "direct:getRandomJoke")
  protected ProducerTemplate cancelProducerTemplate;


  @EndpointInject("mock:result")
  protected MockEndpoint resultEndpoint;

  @EndpointInject(value = "mock:afterdomain")
  protected MockEndpoint mockNumberPortingCancelEndpoint;

  @Autowired
  CamelContext camelContext;

  @Configuration
  static class TestConfig {

  }


  private Map<String, Object> headers;



  @BeforeEach
  public void setup() throws Exception {


    AdviceWith.adviceWith(camelContext, "routeRandomJokeRoute", a -> {
      a.weaveAddLast().to("mock:result");
      a.weaveById("afterdomain").replace().to("mock:afterdomain");
      a.weaveById("mintNumberPortingCancelRouteEndpoint").replace().to("mock:mintNumberPortingCancelRouteEndpoint");
    });

    // add a new endpoint to the end of errorHandlerDirectComponent to read the errors
    AdviceWith.adviceWith(camelContext, "errorHandlerDirectComponent",
        a -> a.weaveAddLast().to("mock:error"));

  }


  @Test
  void given_ValidMintCancelMessage_When_PortingRouteCalled_Then_ResultIsOk()
      throws Exception {


    RequestBody requestBody =
        new RequestBody() {
          @Nullable
          @Override
          public MediaType contentType() {
            return null;
          }

          @Override
          public void writeTo(BufferedSink bufferedSink) throws IOException {

          }
        };

    mockNumberPortingCancelEndpoint.whenAnyExchangeReceived(exchange -> {
      exchange.getIn().setBody(new Root());
    });

    cancelProducerTemplate.sendBodyAndHeaders(requestBody,
        headers);

    mockNumberPortingCancelEndpoint.expectedMessageCount(1);


    mockNumberPortingCancelEndpoint.assertIsSatisfied();

  }

}
