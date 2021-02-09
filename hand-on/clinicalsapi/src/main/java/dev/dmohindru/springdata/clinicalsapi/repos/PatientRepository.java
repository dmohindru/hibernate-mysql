package dev.dmohindru.springdata.clinicalsapi.repos;

import dev.dmohindru.springdata.clinicalsapi.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
