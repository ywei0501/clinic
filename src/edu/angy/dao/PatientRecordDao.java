package edu.angy.dao;

import edu.angy.entity.PatientRecordQueryResult;

public interface PatientRecordDao {
        PatientRecordQueryResult obtainCurrentPatientRecordData(Integer patientId);
}
