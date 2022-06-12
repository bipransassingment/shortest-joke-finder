package nl.ns.task.jokefinder.exception;

public class BlankDataReturnedFromServerException extends Exception {

        private static final long serialVersionUID = 1L;

        public BlankDataReturnedFromServerException(String message) {
            super(message);
        }

    }