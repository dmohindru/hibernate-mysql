package dev.dmohindru.springdata.clinicalsapi.controllers;


import dev.dmohindru.springdata.clinicalsapi.entities.Patient;
import dev.dmohindru.springdata.clinicalsapi.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    private PatientRepository patientRepository;

    @Autowired
    PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @RequestMapping(value="/patients", method = RequestMethod.GET)
    public List<Patient> getPatients() {
        return patientRepository.findAll();

    }

    @RequestMapping(value="/patients/{id}")
    public Patient getPatient(@PathVariable("id") Long id) {
        return patientRepository.findById(id).get();
    }

    @RequestMapping(value="/patients", method = RequestMethod.POST)
    public Patient savePatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }
}
