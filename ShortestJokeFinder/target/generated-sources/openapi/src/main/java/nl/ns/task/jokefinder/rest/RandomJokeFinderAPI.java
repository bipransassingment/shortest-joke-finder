package nl.ns.task.jokefinder.rest;

import javax.annotation.Generated;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Generated from OpenApi specification by Camel REST DSL generator.
 */
@Generated("org.apache.camel.generator.openapi.PathGenerator")
@Component
public final class RandomJokeFinderAPI extends RouteBuilder {
    /**
     * Defines Apache Camel routes using REST DSL fluent API.
     */
    public void configure() {

        restConfiguration().component("servlet").contextPath("/").clientRequestValidation(true);

        rest()
            .get("/random-joke-finder/v1/joke")
                .id("getRandomJoke")
                .description("This API is used to Retrieve random shortest joke.\n")
                .produces("application/json")
                .to("direct:getRandomJoke");

    }
}
