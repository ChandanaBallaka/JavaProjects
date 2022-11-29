package com.evaluation;

public class AdmittedPatient extends Patient
{

    private int dayCount;
    private String insuranceDetails;

    public AdmittedPatient()
    {
    }

    public AdmittedPatient(String patientName, String patientGender, int patientAge, int phoneNumber, int dayCount, String insuranceDetails)
    {
        super(patientName, patientGender, patientAge, phoneNumber);
        this.dayCount = dayCount;
        this.insuranceDetails = insuranceDetails;
    }
}
