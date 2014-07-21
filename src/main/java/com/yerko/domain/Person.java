package com.yerko.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class Person extends ResourceSupport {
    private final String name;
    private final String lastName;

    @JsonCreator
    public Person(
            @JsonProperty("name")String name,
            @JsonProperty("lastName")String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }
}
