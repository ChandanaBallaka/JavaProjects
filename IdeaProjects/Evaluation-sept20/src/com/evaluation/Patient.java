package com.evaluation;

public class Patient
{
    private int patientId;
    private String patientName;
    private String patientGender;
    private int patientAge;
    private int phoneNumber;

    public Patient()
    {
    }

    public Patient(int patientId, String patientName, String patientGender, int patientAge, int phoneNumber)
    {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.phoneNumber = phoneNumber;
    }

    public Patient(String patientName, String patientGender, int patientAge, int phoneNumber)
    {
        this.patientName = patientName;
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.phoneNumber = phoneNumber;
    }

    public int getPatientId()
    {
        return patientId;
    }

    public void setPatientId(int patientId)
    {
        this.patientId = patientId;
    }

    public String getPatientName()
    {
        return patientName;
    }

    public void setPatientName(String patientName)
    {
        this.patientName = patientName;
    }

    public String getPatientGender()
    {
        return patientGender;
    }

    public void setPatientGender(String patientGender)
    {
        this.patientGender = patientGender;
    }

    public int getPatientAge()
    {
        return patientAge;
    }

    public void setPatientAge(int patientAge)
    {
        this.patientAge = patientAge;
    }

    public int getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

}
