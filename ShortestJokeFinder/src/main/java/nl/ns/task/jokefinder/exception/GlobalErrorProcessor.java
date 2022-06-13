package nl.ns.task.jokefinder.exception;

import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import nl.ns.task.jokefinder.model.Error;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.bean.validator.BeanValidationException;
import org.apache.camel.http.base.HttpOperationFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Error processor.
 *
 * @author ekaraosmanoglu
 */

@Component
public class GlobalErrorProcessor implements Processor {

  /**
   * The logger.
   */
  private static final Logger LOGGER =
      LoggerFactory.getLogger(GlobalErrorProcessor.class);

  /**
   * Format for error messages.
   */
  private static final String ERROR_MESSAGE_FORMAT = "{} {}";

  @Override
  public void process(Exchange exchange) throws Exception {

    Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);

    LOGGER.error(ERROR_MESSAGE_FORMAT, "error :", cause.getLocalizedMessage());

    var error = new Error();

    if (cause instanceof BlankDataReturnedFromServerException) {

      error.setStatusCode("404");
      error.setErrorMessage("Server Returned Blank Data");

      exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, error.getStatusCode());


    } else if (cause instanceof HttpOperationFailedException) {

      error.setStatusCode("" + ((HttpOperationFailedException) cause).getStatusCode());
      error.setErrorMessage("Backend server error.");

      exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, error.getStatusCode());


    } else if (cause instanceof ValueInstantiationException) {

      error.setStatusCode("400");
      error.setErrorMessage(((ValueInstantiationException) cause)
          .getLocalizedMessage());

      exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 400);

    } else if (cause instanceof BeanValidationException) {

      error.setStatusCode("400");
      error.setErrorMessage(cause.getLocalizedMessage());

      exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 400);


    } else if (cause instanceof org.apache.http.conn.HttpHostConnectException) {

      error.setStatusCode("500");
      error.setErrorMessage("Cannot connect to backend.");

      exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 500);
    } else {
      exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 500);
    }

    exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/json");
    exchange.getIn().setBody(error);


  }
}
