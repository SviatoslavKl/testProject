package com.testproject.test.controller;

import com.testproject.test.model.CalendlyEntity;
import com.testproject.test.service.CalendlyService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/calendly")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalendlyController {

    private final CalendlyService calendlyService;

    @ApiOperation(value = "Pull events from calendly")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List is successfully pulled"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized")
    })
    @GetMapping(value = "/pull")
    public List<CalendlyEntity> pull() {
        return calendlyService.pullCalendlyEvents();
    }

    @ApiOperation(value = "list of calendly")
    @GetMapping(value = "")
    protected Page<CalendlyEntity> list(
            @ApiParam(name = "type", value = "type of event") @RequestParam(required = false) String type,
            @ApiParam(name = "name", value = "event name") @RequestParam(required = false) String name,
            @ApiParam(name = "active", value = "status of event") @RequestParam(required = false) Boolean active,
            Pageable pageable
    ) {
        return calendlyService.getEvents(type, name, active, pageable);
    }
}
