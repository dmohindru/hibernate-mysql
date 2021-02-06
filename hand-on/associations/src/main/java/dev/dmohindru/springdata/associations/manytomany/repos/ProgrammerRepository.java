package dev.dmohindru.springdata.associations.manytomany.repos;

import dev.dmohindru.springdata.associations.manytomany.entities.Programmer;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRepository extends CrudRepository<Programmer, Long> {
}
