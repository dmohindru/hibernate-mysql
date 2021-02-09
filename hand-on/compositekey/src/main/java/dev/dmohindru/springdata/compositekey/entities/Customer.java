package dev.dmohindru.springdata.compositekey.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Customer {

    @EmbeddedId
    private CustomerId customerId;
    private String name;


    public CustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
