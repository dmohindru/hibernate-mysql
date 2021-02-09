package dev.dmohindru.springdata.patientscheduling;

import dev.dmohindru.springdata.patientscheduling.entities.Appointment;
import dev.dmohindru.springdata.patientscheduling.entities.Doctor;
import dev.dmohindru.springdata.patientscheduling.entities.Insurance;
import dev.dmohindru.springdata.patientscheduling.entities.Patient;
import dev.dmohindru.springdata.patientscheduling.repos.AppointmentRepository;
import dev.dmohindru.springdata.patientscheduling.repos.DoctorRepository;
import dev.dmohindru.springdata.patientscheduling.repos.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class PatitentschedulingApplicationTests {

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Test
	void testCreateDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("Bharat");
		doctor.setLastName("Tippirady");
		doctor.setSpeciality("All");
		doctorRepository.save(doctor);

	}

	@Test
	public void testCreatePatient() {
		// Create Patient object
		Patient patient = new Patient();
		patient.setFirstName("Dug");
		patient.setLastName("Bailey");
		patient.setPhone("123456");

		// Create Insurance object
		Insurance insurance = new Insurance();
		insurance.setProviderName("Blue cross");
		insurance.setCopay(20d);

		// Create Doctors list
		Doctor doctor = doctorRepository.findById(1L).get();
		List<Doctor> doctors = Arrays.asList(doctor);

		patient.setInsurance(insurance);
		patient.setDoctors(doctors);

		// save patient
		patientRepository.save(patient);


	}

	@Test
	public void testCreateRepository() {

		Appointment appointment = new Appointment();
		Timestamp timestamp = new Timestamp(new Date().getTime());
		appointment.setAppointmentTime(timestamp);
		appointment.setReason("I have a problem");

		appointment.setStarted(true);

		Patient patient = patientRepository.findById(1L).get();
		Doctor doctor = doctorRepository.findById(1L).get();

		appointment.setPatient(patient);
		appointment.setDoctor(doctor);

		appointmentRepository.save(appointment);

	}

}
