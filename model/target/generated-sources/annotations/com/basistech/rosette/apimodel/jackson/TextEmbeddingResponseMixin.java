package com.basistech.rosette.apimodel.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonTypeName("TextEmbeddingResponse")
@JsonDeserialize(
    builder = com.basistech.rosette.apimodel.TextEmbeddingResponse.TextEmbeddingResponseBuilder.class
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class TextEmbeddingResponseMixin {
  @JsonPOJOBuilder(
      withPrefix = ""
  )
  public abstract class TextEmbeddingResponseMixinBuilder {
  }
}
