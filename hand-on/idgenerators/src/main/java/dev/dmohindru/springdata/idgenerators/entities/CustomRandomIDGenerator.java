package dev.dmohindru.springdata.idgenerators.entities;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class CustomRandomIDGenerator  implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor si, Object obj) throws HibernateException {
        Random random = null;
        int id = 0;
        random = new Random();
        id = random.nextInt(100000);

        return (long) id;
    }
}
