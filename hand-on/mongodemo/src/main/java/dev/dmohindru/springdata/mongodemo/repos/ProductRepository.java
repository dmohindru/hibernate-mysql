package dev.dmohindru.springdata.mongodemo.repos;

import dev.dmohindru.springdata.mongodemo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
