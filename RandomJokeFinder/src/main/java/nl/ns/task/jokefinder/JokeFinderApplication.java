package nl.ns.task.jokefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * JokeFinder microservice to handle JokeFinderApplication related functionality.
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(
    basePackages = {"nl.ns.task.camel", "nl.ns.task.jokefinder"})
public class JokeFinderApplication {

  /**
   * A main method to start this application.
   */
  public static void main(String[] args) {
    SpringApplication.run(JokeFinderApplication.class, args);
  }

}
