package dev.arias.huapaya.ms_sale_listener.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.arias.huapaya.ms_sale_listener.model.Sale;

@Repository
public interface SaleRepository extends MongoRepository<Sale, String> {

}
