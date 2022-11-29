package com.test;

import java.util.*;

public class CourseRegistrationSystem {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        //Course c = new Course();

        List<Course> course = new ArrayList<>();
        course.add(new Course("CS",12));

        Map<String, List<Course>> map = new HashMap<>();
        Map<String, List<Course>> map1 = new HashMap<>();

        Student student = new Student();

        Faculty faculty = new Faculty();

        Administrator administrator = new Administrator();

        int choice;

        do {
            System.out.println("Enter your choice\n 1.Administrator 2.Student 3.Faculty ");
            choice = input.nextInt();
            int choice2;

            String option = "";
            do {
                switch (choice) {
                    case 1:
                        System.out.println("Enter your choice\n 1.Add course 2.remove course 3.view");
                        choice2 = input.nextInt();

                        switch (choice2) {
                            case 1:
                                administrator.addCourse(course);
                                break;
                            case 2:
                                administrator.deleteCourse(course);
                                break;
                            case 3:
                                administrator.viewCourse(course);
                                break;
                        }

                        System.out.println("Do you wish to continue\n");
                        option = input2.next();

                    case 2:
                        System.out.println("Enter your choice\n 1.Register\n2.View course");
                        choice2 = input.nextInt();

                        switch (choice2) {
                            case 1:
                                System.out.println("Enter the your name");
                                String studentName = input2.nextLine();
                                System.out.println("U can register upto 5 courses");
                                System.out.println("Enter the number of courses");
                                int n = input.nextInt();
                                for (int i = 0; i < n; i++) {
                                    System.out.println("Enter the name of courses");
                                    String courseTitle = input2.nextLine();
                                    System.out.println("Enter the code of the course");
                                    int courseCode = input2.nextInt();
                                    course.add(new Course(courseTitle, courseCode));
                                }
                                //System.out.println("Registered for the course" + map,courseTitle);

                                map.put(studentName, course);

                                student.registerCourse();
                                break;

                            case 2:
                                student.viewCourse(course);

                                break;
                        }
                        System.out.println("Do you wish to continue\n");
                        option = input2.next();
                    case 3:
                        System.out.println("Enter your choice\n 1.Register\n2.View course");
                        choice2 = input.nextInt();
                        switch (choice2) {
                            case 1:
                                System.out.println("Enter your name");
                                String facultyName = input2.nextLine();
                                System.out.println("U can register upto 3 courses");
                                System.out.println("Enter the number of courses");
                                int n = input.nextInt();
                                for (int i = 0; i < n; i++) {
                                    System.out.println("Enter the name of the courses");
                                    String courseTitle = input2.nextLine();
                                    System.out.println("Enter the code of the courses");
                                    int courseCode = input2.nextInt();
                                    course.add(new Course(courseTitle, courseCode));
                                }
                                map.put(facultyName, course);
                                faculty.registerCourse();
                                break;

                            case 2:
                                faculty.viewCourse(course);
                                break;
                        }
                        System.out.println("Do you wish to continue\n");
                        option = input2.next();
                }
            } while (option.equalsIgnoreCase("y"));
        } while (choice != 4);

    }
}
