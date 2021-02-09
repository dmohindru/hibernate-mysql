package dev.dmohindru.springdata.patientscheduling.repos;

import dev.dmohindru.springdata.patientscheduling.entities.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
