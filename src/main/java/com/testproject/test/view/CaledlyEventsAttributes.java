package com.testproject.test.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class CaledlyEventsAttributes {
    private String name;
    private String description;
    private Integer duration;
    private String slug;
    private String color;
    private Boolean active;
    @JsonProperty("created_at")
    private Calendar createdAt;
    @JsonProperty("updated_at")
    private Calendar updatedAt;
    private String url;
}
