package dev.dmohindru.springdata.patientscheduling.repos;

import dev.dmohindru.springdata.patientscheduling.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
