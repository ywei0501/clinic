package edu.angy.entity;
import java.sql.Date;

public class PatientRecord {
	private Integer patientId;
	private Integer RecordId;
	private String Name;
	private String DiseaseType;
	private Date df;
	
	
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		patientId = patientId;
	}
	//-------getter/setter--------------
	public Integer getRecordId() {
		return RecordId;
	}
	public void setRecordId(Integer recordId) {
		RecordId = recordId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDiseaseType() {
		return DiseaseType;
	}
	public void setDiseaseType(String diseaseType) {
		DiseaseType = diseaseType;
	}
	public Date getDf() {
		return df;
	}
	public void setDf(Date df) {
		this.df = df;
	}
	

}

