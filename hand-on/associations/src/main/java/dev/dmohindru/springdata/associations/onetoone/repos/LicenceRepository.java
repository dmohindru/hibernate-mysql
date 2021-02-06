package dev.dmohindru.springdata.associations.onetoone.repos;

import dev.dmohindru.springdata.associations.onetoone.entities.Licence;
import org.springframework.data.repository.CrudRepository;

public interface LicenceRepository extends CrudRepository<Licence, Long> {
}
