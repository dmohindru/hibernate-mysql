package dev.dmohindru.springdata.hibernateinheritance.entities;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("ch")
@Table(name="bankcheck")
@PrimaryKeyJoinColumn(name="id")
public class Cheque extends Payment{
    private String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
