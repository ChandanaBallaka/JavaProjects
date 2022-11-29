package com.evaluation;

import java.util.*;
import java.util.List;

public class HelpDesk
{
    List<Patient> patientList;

    Map<String, List<Patient>> map = new HashMap<>();
    Map<String, List<MedicalReports>> map2 = new HashMap<>();

    Scanner input = new Scanner(System.in);        //for integer input
    Scanner input2 = new Scanner(System.in);        //for String input

    public HelpDesk()
    {
    }

    void patientRegistration()
    {
        System.out.println("Enter the name of the patient");
        String name = input2.nextLine();
        System.out.println("Enter the gender of the patient");
        String gender = input2.nextLine();
        System.out.println("Enter the age of the patient");
        int age = input.nextInt();
        System.out.println("Enter the phone number of the patient");
        int phoneNumber = input.nextInt();
        patientList.add(new Patient(name, gender, age, phoneNumber));
    }

    void patientAppointment()
    {
        System.out.println("Enter the name of the doctor that patient wants to consult");
        String doctorName = input2.nextLine();
        System.out.println("Enter the number of patient to be appointed");
        int count = input.nextInt();
        for (int i = 0; i < count; i++)
        {
            System.out.println("Enter the patient's Id, patient's name, patient's gender, patient's age and patient's phoneNumber");
            int id = input.nextInt();
            String name = input2.nextLine();
            String gender = input2.nextLine();
            int age = input.nextInt();
            int phoneNumber = input.nextInt();
            patientList.add(new Patient(id, name, gender, age, phoneNumber));
        }
        map.put(doctorName, patientList);
    }

    void searchPatientRecords()
    {
        System.out.println("Enter the id of the patient that you want to search");
        int id = input.nextInt();
        try
        {
            for (int i = 0; i < patientList.size(); i++)
            {
                if (id != patientList.get(i).getPatientId())
                {
                    throw new PatientNotFound("Patient you are looking for is not in the list");
                }
                else
                {
                    System.out.println("******Patient's information*******");
                    System.out.println(patientList.get(i).getPatientName() + " " + patientList.get(i).getPatientGender() + " " + patientList.get(i).getPatientAge() + " " + patientList.get(i).getPhoneNumber());
                    break;
                }
            }
        }
        catch (PatientNotFound  e)
        {
            System.out.println("Exception caught" + e);
        }
    }

    void transferPatientRecord(List<MedicalReports> reports)
    {
        System.out.println("Enter the name of the doctor");
        String doctorName = input2.nextLine();
        System.out.println("Enter the number of patient to be transferred (Maximum patients per day is 20)");
        int count = input.nextInt();
        if (count > 20)
        {
            System.out.println("Patient entry denied");
        }
        else
        {
            for (int i = 0; i < count; i++)
            {
                System.out.println("Enter the patient's Id, patient's name, patient's gender, patient's age and patient's phoneNumber");
                int id = input.nextInt();
                String name = input2.nextLine();
                String gender = input2.nextLine();
                int age = input.nextInt();
                int phoneNumber = input.nextInt();
                patientList.add(new Patient(id, name, gender, age, phoneNumber));
            }
            map2.put(doctorName, reports);
        }

    }

    void viewWard(List<Ward> wardList)
    {
        for (int i = 0; i < wardList.size(); i++)
        {
            System.out.println("Ward number:" + " " + wardList.get(i).getWardNo() + " " + "Ward name:" + wardList.get(i).getWardName() + " " + "Information of the patients admitted in the ward" + " " + wardList.get(i).getAdmittedPatientList());
        }
    }

    void billing(List<Patient> p)
    {
        System.out.println("Enter the patient name, patient gender, patient age  and patient phone number");
        String name = input2.nextLine();
        String gender = input2.nextLine();
        int id = input.nextInt();
        int phoneNumber = input.nextInt();
        p.add(new Patient(name,gender,id,phoneNumber));
        System.out.println("Enter the amount to be paid");
        float amount = input.nextFloat();

    }


}
