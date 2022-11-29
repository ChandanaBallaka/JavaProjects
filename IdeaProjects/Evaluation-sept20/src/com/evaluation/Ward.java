package com.evaluation;

import java.util.List;
import java.util.Scanner;

public class Ward
{
    private int wardNo;
    private String wardName;
    List<AdmittedPatient> admittedPatientList;
    Scanner input = new Scanner(System.in);        //for integer input
    Scanner input2 = new Scanner(System.in);        //for String input


    public Ward()
    {
    }

    public Ward(int wardNo, String wardName)
    {
        this.wardNo = wardNo;
        this.wardName = wardName;
    }

    public int getWardNo()
    {
        return wardNo;
    }

    public void setWardNo(int wardNo)
    {
        this.wardNo = wardNo;
    }

    public String getWardName()
    {
        return wardName;
    }

    public void setWardName(String wardName)
    {
        this.wardName = wardName;
    }

    public List<AdmittedPatient> getAdmittedPatientList()
    {
        return admittedPatientList;
    }

    public void setAdmittedPatientList(List<AdmittedPatient> admittedPatientList)
    {
        this.admittedPatientList = admittedPatientList;
    }

    void admittedPatientRegistration()
    {
        System.out.println("Enter the name of the patient");
        String name = input2.nextLine();
        System.out.println("Enter the gender of the patient");
        String gender = input2.nextLine();
        System.out.println("Enter the age of the patient");
        int age = input.nextInt();
        System.out.println("Enter the phone number of the patient");
        int phoneNumber = input.nextInt();
        System.out.println("Enter the number of days to be admitted");
        int day = input.nextInt();
        System.out.println("Enter your insurance details");
        String insurance = input2.nextLine();
        admittedPatientList.add(new AdmittedPatient(name, gender, age, phoneNumber, day, insurance));
    }
}
