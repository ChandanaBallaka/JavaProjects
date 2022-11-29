package com.evaluation;

import java.util.List;

public class Doctor
{
    private String doctorName;
    private int doctorId;
    private int phoneNo;
    private String doctorGender;

    public Doctor(String doctorName, int doctorId, int phoneNo, String doctorGender)
    {
        this.doctorName = doctorName;
        this.doctorId = doctorId;
        this.phoneNo = phoneNo;
        this.doctorGender = doctorGender;
    }

    public String getDoctorName()
    {
        return doctorName;
    }

    public void setDoctorName(String doctorName)
    {
        this.doctorName = doctorName;
    }

    public int getDoctorId()
    {
        return doctorId;
    }

    public void setDoctorId(int doctorId)
    {
        this.doctorId = doctorId;
    }

    public int getPhoneNo()
    {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo)
    {
        this.phoneNo = phoneNo;
    }

    public String getDoctorGender()
    {
        return doctorGender;
    }

    public void setDoctorGender(String doctorGender)
    {
        this.doctorGender = doctorGender;
    }
}
