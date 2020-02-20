package com.example.testingexamples;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@JsonDeserialize(builder = SomeProdPojo.SomeProdPojoBuilder.class)
@JsonPropertyOrder({"foo_bar", "super_foo_bar"})
@Data
@Builder(builderClassName = "SomeProdPojoBuilder")
public class SomeProdPojo {

    private String superFooBar;
    private String fooBar;

    @JsonIgnore
    private String barFoo;

    @JsonPOJOBuilder(withPrefix = "")
    public static class SomeProdPojoBuilder {}
}
