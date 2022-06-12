package nl.ns.task.jokefinder.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * HttpResponseTestSpec
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-09T22:50:41.334025300+02:00[Europe/Berlin]")

public class HttpResponseTestSpec   {
  @JsonProperty("statusCode")
  private Integer statusCode;

  @JsonProperty("delay")
  private Integer delay;

  @JsonProperty("chunkedDelay")
  private Integer chunkedDelay;

  @JsonProperty("code")
  private String code;

  @JsonProperty("reason")
  private String reason;

  public HttpResponseTestSpec statusCode(Integer statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * http status code for simulating codes 40x and 50x from the backend
   * @return statusCode
  */
  @ApiModelProperty(value = "http status code for simulating codes 40x and 50x from the backend")


  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public HttpResponseTestSpec delay(Integer delay) {
    this.delay = delay;
    return this;
  }

  /**
   * delay to be added to the response time
   * @return delay
  */
  @ApiModelProperty(value = "delay to be added to the response time")


  public Integer getDelay() {
    return delay;
  }

  public void setDelay(Integer delay) {
    this.delay = delay;
  }

  public HttpResponseTestSpec chunkedDelay(Integer chunkedDelay) {
    this.chunkedDelay = chunkedDelay;
    return this;
  }

  /**
   * delay to be added to the response time
   * @return chunkedDelay
  */
  @ApiModelProperty(value = "delay to be added to the response time")


  public Integer getChunkedDelay() {
    return chunkedDelay;
  }

  public void setChunkedDelay(Integer chunkedDelay) {
    this.chunkedDelay = chunkedDelay;
  }

  public HttpResponseTestSpec code(String code) {
    this.code = code;
    return this;
  }

  /**
   * error code from backend
   * @return code
  */
  @ApiModelProperty(value = "error code from backend")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public HttpResponseTestSpec reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * error reason from backend
   * @return reason
  */
  @ApiModelProperty(value = "error reason from backend")


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HttpResponseTestSpec httpResponseTestSpec = (HttpResponseTestSpec) o;
    return Objects.equals(this.statusCode, httpResponseTestSpec.statusCode) &&
        Objects.equals(this.delay, httpResponseTestSpec.delay) &&
        Objects.equals(this.chunkedDelay, httpResponseTestSpec.chunkedDelay) &&
        Objects.equals(this.code, httpResponseTestSpec.code) &&
        Objects.equals(this.reason, httpResponseTestSpec.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, delay, chunkedDelay, code, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HttpResponseTestSpec {\n");
    
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    delay: ").append(toIndentedString(delay)).append("\n");
    sb.append("    chunkedDelay: ").append(toIndentedString(chunkedDelay)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

