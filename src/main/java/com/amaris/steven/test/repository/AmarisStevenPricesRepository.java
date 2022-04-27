package com.amaris.steven.test.repository;

import com.amaris.steven.test.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AmarisStevenPricesRepository extends JpaRepository<Prices, Long> {

    List<Prices> findAllByStartDateGreaterThanEqualAndEndDateLessThanEqualAndProductIdAndBrandId(LocalDateTime startDate,
                                                                                                 LocalDateTime endDate,
                                                                                                 int productId,
                                                                                                 int brandId);

    List<Prices> findAllByProductId(int productId);

    List<Prices> findAllByBrandId(int brandId);

}
