package nl.ns.task.jokefinder.exception;


/**
 * Custom Exception class.
 */
public class BlankDataReturnedFromServerException extends Exception {

  private static final long serialVersionUID = 1L;

  public BlankDataReturnedFromServerException(String message) {
    super(message);
  }
}