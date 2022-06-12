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
 * Error
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-06-09T22:50:41.334025300+02:00[Europe/Berlin]")

public class Error   {
  @JsonProperty("method")
  private String method;

  @JsonProperty("uri")
  private String uri;

  @JsonProperty("query")
  private String query;

  @JsonProperty("contentType")
  private String contentType;

  @JsonProperty("statusCode")
  private String statusCode;

  @JsonProperty("statusMessage")
  private String statusMessage;

  @JsonProperty("errorMessage")
  private String errorMessage;

  @JsonProperty("apiErrorCode")
  private String apiErrorCode;

  @JsonProperty("apiErrorReason")
  private String apiErrorReason;

  public Error method(String method) {
    this.method = method;
    return this;
  }

  /**
   * http method used.
   * @return method
  */
  @ApiModelProperty(value = "http method used.")


  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public Error uri(String uri) {
    this.uri = uri;
    return this;
  }

  /**
   * url of the request been done.
   * @return uri
  */
  @ApiModelProperty(value = "url of the request been done.")


  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public Error query(String query) {
    this.query = query;
    return this;
  }

  /**
   * query parameters sent
   * @return query
  */
  @ApiModelProperty(value = "query parameters sent")


  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public Error contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * content type
   * @return contentType
  */
  @ApiModelProperty(value = "content type")


  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public Error statusCode(String statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * http status code.
   * @return statusCode
  */
  @ApiModelProperty(value = "http status code.")


  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public Error statusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
    return this;
  }

  /**
   * message
   * @return statusMessage
  */
  @ApiModelProperty(value = "message")


  public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }

  public Error errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * (optional) error message.
   * @return errorMessage
  */
  @ApiModelProperty(value = "(optional) error message.")


  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public Error apiErrorCode(String apiErrorCode) {
    this.apiErrorCode = apiErrorCode;
    return this;
  }

  /**
   * error code
   * @return apiErrorCode
  */
  @ApiModelProperty(value = "error code")


  public String getApiErrorCode() {
    return apiErrorCode;
  }

  public void setApiErrorCode(String apiErrorCode) {
    this.apiErrorCode = apiErrorCode;
  }

  public Error apiErrorReason(String apiErrorReason) {
    this.apiErrorReason = apiErrorReason;
    return this;
  }

  /**
   * error reason code.
   * @return apiErrorReason
  */
  @ApiModelProperty(value = "error reason code.")


  public String getApiErrorReason() {
    return apiErrorReason;
  }

  public void setApiErrorReason(String apiErrorReason) {
    this.apiErrorReason = apiErrorReason;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.method, error.method) &&
        Objects.equals(this.uri, error.uri) &&
        Objects.equals(this.query, error.query) &&
        Objects.equals(this.contentType, error.contentType) &&
        Objects.equals(this.statusCode, error.statusCode) &&
        Objects.equals(this.statusMessage, error.statusMessage) &&
        Objects.equals(this.errorMessage, error.errorMessage) &&
        Objects.equals(this.apiErrorCode, error.apiErrorCode) &&
        Objects.equals(this.apiErrorReason, error.apiErrorReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, uri, query, contentType, statusCode, statusMessage, errorMessage, apiErrorCode, apiErrorReason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusMessage: ").append(toIndentedString(statusMessage)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    apiErrorCode: ").append(toIndentedString(apiErrorCode)).append("\n");
    sb.append("    apiErrorReason: ").append(toIndentedString(apiErrorReason)).append("\n");
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

