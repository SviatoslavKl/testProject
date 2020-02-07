package com.testproject.test.mapper;

import com.testproject.test.model.CalendlyEntity;
import com.testproject.test.view.CalendlyView;
import org.springframework.stereotype.Component;

@Component
public class CalendlyEventsMapper {

    public CalendlyEntity toEventsModel(CalendlyView.Data event) {
        return CalendlyEntity.builder()
                .type(event.getType())
                .name(event.getAttributes().getName())
                .description(event.getAttributes().getDescription())
                .duration(event.getAttributes().getDuration())
                .slug(event.getAttributes().getSlug())
                .color(event.getAttributes().getColor())
                .active(event.getAttributes().getActive())
                .createdAt(event.getAttributes().getCreatedAt().getTimeInMillis())
                .updatedAt(event.getAttributes().getUpdatedAt().getTimeInMillis())
                .url(event.getAttributes().getUrl())
                .build();
    }
}
