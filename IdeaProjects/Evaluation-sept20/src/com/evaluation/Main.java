package com.evaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        HelpDesk helpdesk = new HelpDesk();

        Department department = new Department("ICU");

        Ward ward = new Ward(1, "General ward");

        List<MedicalReports> reports = new ArrayList<>();
        List<Patient> patientList = new ArrayList<>();
        List<Ward> wardList = new ArrayList<>();

        Scanner input = new Scanner(System.in);        //for integer input
        Scanner input2 = new Scanner(System.in);        //for String input

        int choice;

        do
        {
            System.out.println("Enter your choice\n1.Department\n2.Help Desk\n3.Ward\n4.billing\n5.Exit");
            choice = input.nextInt();
            int choice2;

            String wish = "";

            do
            {
                switch (choice)
                {
                    case 1:
                        System.out.println("Enter your choice\n1.Add doctors\n2.View Doctor's information\n3.View Patient's information");
                        choice2 = input.nextInt();

                        switch (choice2)
                        {
                            case 1:
                                department.addDoctors();
                                break;

                            case 2:
                                department.viewDoctor();
                                break;

                            case 3:
                                department.viewPatient();
                                break;
                        }

                        System.out.println("Do you wish to continue? press yes to proceed");
                        wish = input2.next();
                        break;

                    case 2:
                        System.out.println("Enter your choice\n1.Patient Registration\n2.Patient Appointment\n3.Search Patient\n4.Transfer patient records\n5.View wards");
                        choice2 = input.nextInt();

                        switch (choice2)
                        {
                            case 1:
                                helpdesk.patientRegistration();
                                break;

                            case 2:
                                helpdesk.patientAppointment();
                                break;

                            case 3:
                                helpdesk.searchPatientRecords();
                                break;

                            case 4:
                                helpdesk.transferPatientRecord(reports);
                                break;

                            case 5:
                                helpdesk.viewWard(wardList);
                                break;
                        }

                        System.out.println("Do you wish to continue? press yes to proceed");
                        wish = input2.next();
                        break;

                    case 3:
                        System.out.println("Register the patients to be admitted to ward");
                        ward.admittedPatientRegistration();
                        break;

                    case 4:
                        helpdesk.billing(patientList);
                        break;
                }

            } while (wish.equalsIgnoreCase("yes"));

        } while (choice != 5);
    }
}
