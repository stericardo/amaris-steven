package com.amaris.steven.test.service.impl;

import com.amaris.steven.test.entity.Prices;
import com.amaris.steven.test.exception.BrandNotFoundException;
import com.amaris.steven.test.exception.ProductNotFoundException;
import com.amaris.steven.test.repository.AmarisStevenPricesRepository;
import com.amaris.steven.test.service.AmarisStevenPricesService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class AmarisStevenPricesServiceImpl implements AmarisStevenPricesService {

    private AmarisStevenPricesRepository amarisStevenPricesRepository;

    public AmarisStevenPricesServiceImpl(AmarisStevenPricesRepository amarisStevenPricesRepository) {
        this.amarisStevenPricesRepository = amarisStevenPricesRepository;
    }

    @Override
    public List<Prices> findAll() {
        return amarisStevenPricesRepository.findAll();
    }

    @Override
    public List<Prices> findAllByRangeDatesProductAndBrand(final LocalDateTime startDate, final LocalDateTime endDate,
                                                           final int productId, final int brandId) {
        if (startDate == null || endDate == null) {
            return Collections.emptyList();
        }

        List<Prices> pricesList = amarisStevenPricesRepository.findAllByBrandId(brandId);
        if (pricesList == null || pricesList.isEmpty()) {
            throw new BrandNotFoundException("Brand not found " + brandId);
        }

        pricesList = amarisStevenPricesRepository.findAllByProductId(productId);
        if (pricesList == null || pricesList.isEmpty()) {
            throw new ProductNotFoundException("Product not found " + productId);
        }

        return amarisStevenPricesRepository
            .findAllByStartDateGreaterThanEqualAndEndDateLessThanEqualAndProductIdAndBrandId(startDate, endDate,
                productId, brandId);
    }

}
