package com.example.testingexamples;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.core.io.Resource;

import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.util.FileCopyUtils.copyToString;

@JsonTest
public class JsonParsingTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Value("someLargeProdPojo.json")
    private Resource someLargeProdPojoJsonFile;

    @Test
    void ObjectMapperConfig_Serialize_CamelCaseToSnakeCase() throws Exception {
        SomeTestPojo pojo = new SomeTestPojo();
        pojo.setFooBar("some value");
        assertThat(objectMapper.writeValueAsString(pojo)).isEqualTo("{\"foo_bar\":\"some value\"}");
    }

    @Test
    void ObjectMapperConfig_Deserialize_SnakeCaseToCamelCase() throws Exception {
        SomeTestPojo pojo = objectMapper.readValue("{\"foo_bar\":\"some value\"}", SomeTestPojo.class);
        assertThat(pojo.getFooBar()).isEqualTo("some value");
    }

    @Test
    void SomeProdPojo_Serialize_IgnoresBarFoo() throws Exception {
        SomeProdPojo pojo = SomeProdPojo.builder().fooBar("foobar value").superFooBar("superfoobar value").barFoo("barfoo value").build();
        assertThat(objectMapper.writeValueAsString(pojo)).isEqualTo("{\"foo_bar\":\"foobar value\",\"super_foo_bar\":\"superfoobar value\"}");
    }

    @Test
    void SomeLargeProdPojo_SerializeAllFields_IgnoresAge() throws Exception {
        SomeLargeProdPojo pojo = SomeLargeProdPojo.builder()
                .address("addressVal")
                .age("ageVal")
                .mobilePhone("mobilePhoneVal")
                .name("nameVal")
                .sex("sexVal")
                .shoeSize("shoeSizeVal")
                .phone("phoneVal")
            .build();

        String expected = trim(copyToString(new InputStreamReader(someLargeProdPojoJsonFile.getInputStream())));

        assertThat(trim(objectMapper.writeValueAsString(pojo))).isEqualTo(expected);
    }

    @Test
    void SomeLargeProdPojo_Deserialize_AgeNull() throws Exception {
        SomeLargeProdPojo expectedPojo = SomeLargeProdPojo.builder()
                .address("addressVal")
                .age(null)
                .mobilePhone("mobilePhoneVal")
                .name("nameVal")
                .sex("sexVal")
                .shoeSize("shoeSizeVal")
                .phone("phoneVal")
                .build();

        String json = trim(copyToString(new InputStreamReader(someLargeProdPojoJsonFile.getInputStream())));

        assertThat(objectMapper.readValue(json, SomeLargeProdPojo.class)).isEqualToComparingFieldByField(expectedPojo);
    }

    private String trim(String str) {
        return str.replaceAll("\\s|\n", "");
    }

}
