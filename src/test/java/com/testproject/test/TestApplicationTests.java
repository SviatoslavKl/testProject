package com.testproject.test;

import com.testproject.test.model.CalendlyEntity;
import com.testproject.test.service.CalendlyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class TestApplicationTests {

    private final CalendlyService calendlyService;

    @Test
    void testIfEventsExistInCalendly() {
        List<CalendlyEntity> calendlyEntityList = calendlyService.pullCalendlyEvents();
        assertNotNull(calendlyEntityList);
    }

    @Test
    void testCalendlyEventsInDb() {
        List<CalendlyEntity> calendlyEntityList = calendlyService.getEvents(null, null, null, Pageable.unpaged()).getContent();
        assertNotNull(calendlyEntityList);
    }

    @Test
    void testCalendlyEntityValues() {
        CalendlyEntity calendlyEntity = CalendlyEntity.builder()
                .type("Type")
                .name("name")
                .description("description")
                .duration(30)
                .slug("slug")
                .color("red")
                .active(true)
                .createdAt(Calendar.getInstance().getTimeInMillis())
                .updatedAt(Calendar.getInstance().getTimeInMillis())
                .url("http://test")
                .build();

        // validate the input
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<CalendlyEntity>> violations = validator.validate(calendlyEntity);
        assertTrue(violations.isEmpty());
    }
}
