package nl.ns.task.jokefinder.routes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import nl.ns.task.jokefinder.exception.GenericExceptionHandler;
import nl.ns.task.jokefinder.mapper.JokesMessagesExchangeMapper;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.EnableRouteCoverage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

/**
 * Unit Tester For Camel Routes.
 */
@CamelSpringBootTest
@PropertySource(ignoreResourceNotFound = false, value = {"classpath:application-test.properties"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import({GenericExceptionHandler.class, JokesMessagesExchangeMapper.class,
})



@EnableRouteCoverage
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
abstract class UnitTest {

  /**
   * //@param file
   * 
   * @return
   * @throws IOException
   */
  String readFromFile(String filePath) throws IOException {

    File file = new ClassPathResource(filePath).getFile();

    return new String(Files.readAllBytes(file.toPath()));

  }


}
