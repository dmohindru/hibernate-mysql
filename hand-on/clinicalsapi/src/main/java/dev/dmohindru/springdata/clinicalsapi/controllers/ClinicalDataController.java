package dev.dmohindru.springdata.clinicalsapi.controllers;

import dev.dmohindru.springdata.clinicalsapi.dto.ClinicalDataRequest;
import dev.dmohindru.springdata.clinicalsapi.entities.ClinicalData;
import dev.dmohindru.springdata.clinicalsapi.entities.Patient;
import dev.dmohindru.springdata.clinicalsapi.repos.ClinicalDataRepository;
import dev.dmohindru.springdata.clinicalsapi.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {

    private ClinicalDataRepository clinicalDataRepository;
    private PatientRepository patientRepository;

    @Autowired
    ClinicalDataController(ClinicalDataRepository clinicalDataRepository, PatientRepository patientRepository) {
        this.clinicalDataRepository = clinicalDataRepository;
        this.patientRepository = patientRepository;
    }


    @RequestMapping(value="/clinicals", method = RequestMethod.POST)
    public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest clinicalDataRequest) {
        Patient patient = patientRepository.findById(clinicalDataRequest.getPatientId()).get();
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(clinicalDataRequest.getComponentName());
        clinicalData.setComponentValue(clinicalDataRequest.getComponentValue());
        clinicalData.setPatient(patient);
        clinicalDataRepository.save(clinicalData);
        return clinicalData;
    }

}
