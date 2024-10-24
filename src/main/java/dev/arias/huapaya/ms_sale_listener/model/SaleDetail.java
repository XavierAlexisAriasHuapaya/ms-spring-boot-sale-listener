package dev.arias.huapaya.ms_sale_listener.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetail implements Serializable {

    @Id
    private String id;

    private Long product;

    private Long typeAffectation;

    private Long quantity;

    private BigDecimal salePrice;

    private BigDecimal discount;

    private BigDecimal totalAmount;

    private Boolean procentageDiscount;

}
