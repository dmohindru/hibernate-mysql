package dev.dmohindru.springdata.clinicalsapi.repos;

import dev.dmohindru.springdata.clinicalsapi.entities.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Long> {
}
