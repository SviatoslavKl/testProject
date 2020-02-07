package com.testproject.test.view;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CalendlyView {
    private List<Data> data;

    @Getter
    @Setter
    public static class Data {
        private String type;
        private String id;
        private CaledlyEventsAttributes attributes;
    }
}
