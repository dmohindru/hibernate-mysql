package dev.dmohindru.springdata.clinicalsapi.controllers;


import dev.dmohindru.springdata.clinicalsapi.entities.ClinicalData;
import dev.dmohindru.springdata.clinicalsapi.entities.Patient;
import dev.dmohindru.springdata.clinicalsapi.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {

    private PatientRepository patientRepository;
    Map<String, String> filter = new HashMap<>();

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

    @RequestMapping(value="/patients/analyze/{id}", method = RequestMethod.GET)
    public Patient analyze(@PathVariable("id") Long id) {
        Patient patient = patientRepository.findById(id).get();
        List<ClinicalData> clinicalData = patient.getClinicalData();
        List<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);
        for (ClinicalData eachEntry: duplicateClinicalData) {
            if (filter.containsKey(eachEntry.getComponentName())) {
                clinicalData.remove(eachEntry);
                continue;
            }
            else {
                filter.put(eachEntry.getComponentName(), null);
            }
            if (eachEntry.getComponentName().equals("hw")) {
                String []heightAndWeight = eachEntry.getComponentValue().split("/");
                if (heightAndWeight != null && heightAndWeight.length > 1) {
                    float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
                    float bmi = Float.parseFloat(heightAndWeight[1]) / (heightInMeters * heightInMeters);
                    ClinicalData bmiData = new ClinicalData();
                    bmiData.setComponentName("bmi");
                    bmiData.setComponentValue(Float.toString(bmi));
                    clinicalData.add(bmiData);
                }
            }
        }
        filter.clear();
        return patient;
    }

}
