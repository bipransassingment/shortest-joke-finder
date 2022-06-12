package nl.ns.task.jokefinder.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import nl.ns.task.jokefinder.domain.model.Jokes;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Joke
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-09T22:50:41.334025300+02:00[Europe/Berlin]")

public class Joke   {
  @JsonProperty("randomJoke")
  private String randomJoke;

  @JsonProperty("id")
  private Integer id;


  public Joke randomJoke(String randomJoke) {
    this.randomJoke = randomJoke;
    return this;
  }

  /**
   * randomJoke
   * @return randomJoke
  */
  @ApiModelProperty(value = "randomJoke")


  public String getRandomJoke() {
    return randomJoke;
  }

  public void setRandomJoke(String randomJoke) {
    this.randomJoke = randomJoke;
  }

  public Joke id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * id
   * @return id
  */
  @ApiModelProperty(value = "id")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Joke joke = (Joke) o;
    return Objects.equals(this.randomJoke, joke.randomJoke) &&
        Objects.equals(this.id, joke.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(randomJoke, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Joke {\n");
    
    sb.append("    randomJoke: ").append(toIndentedString(randomJoke)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

