package com.amaris.steven.test.controller;

import com.amaris.steven.test.entity.Prices;
import com.amaris.steven.test.request.PricesRequest;
import com.amaris.steven.test.response.HttpBaseResponse;
import com.amaris.steven.test.response.HttpPricesResponse;
import com.amaris.steven.test.service.AmarisStevenPricesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("prices")
public class AmarisStevenPricesController {

    Logger logger = LoggerFactory.getLogger(AmarisStevenPricesController.class);

    private AmarisStevenPricesService amarisStevenPricesService;


    @Autowired
    public AmarisStevenPricesController(AmarisStevenPricesService amarisStevenPricesService) {
        this.amarisStevenPricesService = amarisStevenPricesService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpBaseResponse getAllUsers() {
        List<Prices> pricesList = amarisStevenPricesService.findAll();
        return new HttpPricesResponse("All Prices", pricesList, HttpStatus.OK);
    }

    @PostMapping(value = "/byProductBrandAndDates", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpBaseResponse getAllUsers(@Valid @RequestBody PricesRequest pricesRequest) {
        LocalDateTime startDateLocalDateTime = LocalDateTime.parse(pricesRequest.getStartDate(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime endDateLocalDateTime = LocalDateTime.parse(pricesRequest.getEndDate(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        List<Prices> pricesList = amarisStevenPricesService.findAllByRangeDatesProductAndBrand(startDateLocalDateTime,
            endDateLocalDateTime, pricesRequest.getProduct(), pricesRequest.getBrand());
        return new HttpPricesResponse("All Prices", pricesList, HttpStatus.OK);
    }

}
