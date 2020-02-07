package com.testproject.test.service;

import com.testproject.test.model.CalendlyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CalendlyService {
    List<CalendlyEntity> pullCalendlyEvents();
    Page<CalendlyEntity> getEvents(String type, String name, Boolean active, Pageable pageable);
    List<CalendlyEntity> saveCalendlyEvents(List<CalendlyEntity> calendlyEntityEventsList);
}
