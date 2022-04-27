package com.amaris.steven.test.response;

import com.amaris.steven.test.entity.Prices;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class HttpPricesResponse extends HttpBaseResponse{

    private List<PricesResponse> pricesResponse;

    public HttpPricesResponse(String text, List<Prices> prices, HttpStatus httpStatus) {
        super(text, httpStatus);

        if(prices != null) {
            this.pricesResponse = new ArrayList<>();
            prices.stream().forEach( price -> {
                PricesResponse singlePricesResponse = new PricesResponse(price);
                pricesResponse.add(singlePricesResponse);
            });
        }
    }

    public List<PricesResponse> getPricesResponse() {
        return pricesResponse;
    }
}
