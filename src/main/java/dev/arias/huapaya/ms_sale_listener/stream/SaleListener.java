package dev.arias.huapaya.ms_sale_listener.stream;

import java.time.LocalDateTime;
import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.arias.huapaya.ms_sale_listener.model.Sale;
import dev.arias.huapaya.ms_sale_listener.persistence.repository.SaleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@AllArgsConstructor
@Slf4j
public class SaleListener {

    private final SaleRepository saleRepository;

    private final ObjectMapper objectMapper;

    @Bean
    public Consumer<String> consumerStream() {
        log.info("Sale Listener");
        return sale -> {
            try {
                Sale saleJson = this.objectMapper.readValue(sale, Sale.class);

                Sale newSale = Sale.builder()
                        .id(saleJson.getId())
                        .document(saleJson.getDocument())
                        .paymentCondition(saleJson.getPaymentCondition())
                        .paymentStatus(saleJson.getPaymentStatus())
                        .pettyCash(saleJson.getPettyCash())
                        .deliveryStatus(saleJson.getDeliveryStatus())
                        .client(saleJson.getClient())
                        .store(saleJson.getStore())
                        .serie(saleJson.getSerie())
                        .issued(saleJson.getIssued())
                        .operationDate(saleJson.getOperationDate())
                        .deliveryDate(saleJson.getDeliveryDate())
                        .expirationDate(saleJson.getExpirationDate())
                        .observation(saleJson.getObservation())
                        .saleDetails(saleJson.getSaleDetails())
                        .freeAmount(saleJson.getFreeAmount())
                        .exemptAmount(saleJson.getExemptAmount())
                        .taxableAmount(saleJson.getTaxableAmount())
                        .taxAmount(saleJson.getTaxAmount())
                        .subTotal(saleJson.getSubTotal())
                        .discount(saleJson.getDiscount())
                        .saleAmount(saleJson.getSaleAmount())
                        .created_at(LocalDateTime.now())
                        .updated_at(LocalDateTime.now())
                        .status(true)
                        .build();
                this.saleRepository.save(newSale);
            } catch (JsonProcessingException e) {
                log.error("Error JSON: ", e.getMessage());
            } catch (Exception e) {
                log.error("Error DB: " + e.getMessage());
            }
        };
    }

}
