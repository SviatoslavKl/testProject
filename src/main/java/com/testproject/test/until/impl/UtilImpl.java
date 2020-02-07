package com.testproject.test.until.impl;

import com.testproject.test.config.CalendlyConfig;
import com.testproject.test.until.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UtilImpl implements Util {

    private final CalendlyConfig calendlyConfig;

    public HttpHeaders getHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-TOKEN", calendlyConfig.getApiKey());
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return httpHeaders;
    }
}
