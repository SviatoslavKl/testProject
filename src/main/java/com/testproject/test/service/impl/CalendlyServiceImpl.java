package com.testproject.test.service.impl;

import com.google.common.collect.Lists;
import com.testproject.test.config.CalendlyConfig;
import com.testproject.test.mapper.CalendlyEventsMapper;
import com.testproject.test.model.CalendlyEntity;
import com.testproject.test.repository.CalendlyRepository;
import com.testproject.test.service.CalendlyService;
import com.testproject.test.until.Util;
import com.testproject.test.view.CalendlyView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalendlyServiceImpl implements CalendlyService {

    private final CalendlyConfig calendlyConfig;
    private final CalendlyRepository calendlyRepository;
    private final CalendlyEventsMapper calendlyEventsMapper;
    private final Util util;

    @Override
    public List<CalendlyEntity> pullCalendlyEvents(){
        return getEventsFromCalendly();
    }

    @Override
    public Page<CalendlyEntity> getEvents(String type, String name, Boolean active, Pageable pageable){
        return calendlyRepository.findAllBy(type, name, active, pageable);
    }

    @Override
    public List<CalendlyEntity> saveCalendlyEvents(List<CalendlyEntity> calendlyEntityEventsList){
        return Lists.newArrayList(calendlyRepository.saveAll(calendlyEntityEventsList));
    }

    private List<CalendlyEntity> getEventsFromCalendly(){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity httpEntity = new HttpEntity(util.getHeaders());
        String url =  calendlyConfig.getEventsUrl();
        ResponseEntity responseEntity = restTemplate
                .exchange(
                        url,
                        HttpMethod.GET,
                        httpEntity,
                        CalendlyView.class
                );
        CalendlyView calendlyView = (CalendlyView) responseEntity.getBody();

        Assert.notEmpty(Objects.requireNonNull(calendlyView).getData(), "Response is empty");
        return saveCalendlyEvents(
                calendlyView.getData().stream()
                .map(calendlyEventsMapper::toEventsModel)
                .collect(Collectors.toList())
        );
    }
}
