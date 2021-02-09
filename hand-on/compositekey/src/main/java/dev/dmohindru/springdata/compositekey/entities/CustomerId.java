package dev.dmohindru.springdata.compositekey.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CustomerId implements Serializable {
    private int id;
    private String email;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
