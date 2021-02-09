package dev.dmohindru.springdata.patientscheduling.repos;

import dev.dmohindru.springdata.patientscheduling.entities.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
