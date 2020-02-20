package com.example.testingexamples;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@JsonDeserialize(builder = SomeLargeProdPojo.SomeLargeProdPojoBuilder.class)
@JsonPropertyOrder({"name", "sex", "address", "phone", "mobile_phone", "shoe_size", "age"})
@Data
@Builder(builderClassName = "SomeLargeProdPojoBuilder")
public class SomeLargeProdPojo {

    private String name;
    private String sex;
    private String address;
    private String phone;
    private String mobilePhone;
    private String shoeSize;

    @JsonIgnore
    private String age;

    @JsonPOJOBuilder(withPrefix = "")
    public static class SomeLargeProdPojoBuilder {}
}
