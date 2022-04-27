package com.amaris.steven.test.response;

import com.amaris.steven.test.entity.Prices;
import org.springframework.http.HttpStatus;

public class HttpPriceResponse extends HttpBaseResponse{

    private PricesResponse pricesResponse;

    public HttpPriceResponse(String text, Prices prices, HttpStatus httpStatus) {
        super(text, httpStatus);
        if(prices != null) {
            this.pricesResponse = new PricesResponse(prices);
        }
    }

    public PricesResponse getPricesResponse() {
        return pricesResponse;
    }
}
