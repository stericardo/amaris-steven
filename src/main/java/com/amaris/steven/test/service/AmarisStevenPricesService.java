package com.amaris.steven.test.service;

import com.amaris.steven.test.entity.Prices;

import java.time.LocalDateTime;
import java.util.List;

public interface AmarisStevenPricesService {

    List<Prices> findAll();

    List<Prices> findAllByRangeDatesProductAndBrand(final LocalDateTime startDate, final LocalDateTime endDate, final int productId,
                                                    final int brandId);

}
