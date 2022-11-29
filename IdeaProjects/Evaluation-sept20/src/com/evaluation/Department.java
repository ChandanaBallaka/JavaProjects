package com.evaluation;

import java.util.List;
import java.util.Scanner;

public class Department
{
    String deptName;
    List<Patient> patientList;
    List<Doctor> doctorList;

    Scanner input = new Scanner(System.in);        //for integer input
    Scanner input2 = new Scanner(System.in);        //for String input

    public Department()
    {
    }

    public Department(String deptName)
    {
        this.deptName = deptName;
    }

    void addDoctors()
    {
        System.out.println("Enter the number of doctors to be added");
        int count = input.nextInt();
        for (int i = 0; i < count; i++)
        {
            System.out.println("Enter the doctor name, id, phone number and gender");
            String doctorName = input2.nextLine();
            int id = input.nextInt();
            int phoneNumber = input.nextInt();
            String gender = input2.nextLine();
            doctorList.add(new Doctor(doctorName, id, phoneNumber, gender));

        }
    }

    void viewDoctor()
    {
        for (int i = 0; i < doctorList.size(); i++)
        {
            System.out.println("Doctor's name:" + " " + doctorList.get(i).getDoctorName() + " " + "Doctor's Id" + doctorList.get(i).getDoctorId() + " " + "Doctor's gender:" + doctorList.get(i).getDoctorGender() + " " + "Doctor's phone number:" + doctorList.get(i).getPhoneNo());
        }
    }

    void viewPatient()
    {
        for (int i = 0; i < patientList.size(); i++)
        {
            System.out.println("Patient's name:" + " " + patientList.get(i).getPatientName() + " " + "Patient's Id" + " " + patientList.get(i).getPatientId() + " " + "Patient's gender:" + " " + patientList.get(i).getPatientGender() + " " + "Patient's age:" + " " + patientList.get(i).getPatientAge() + " " + patientList.get(i).getPhoneNumber());
        }
    }
}
