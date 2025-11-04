package com.example.sms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentDAO studentDAO = context.getBean(StudentDAO.class);
        FeeService feeService = context.getBean(FeeService.class);

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running) {
            System.out.println("\n--- Online Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Pay Fee");
            System.out.println("4. Refund Fee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Student Name: ");
                    String name = sc.next();
                    System.out.print("Course Name: ");
                    String courseName = sc.next();
                    System.out.print("Duration: ");
                    String duration = sc.next();
                    System.out.print("Balance: ");
                    double balance = sc.nextDouble();

                    Course course = new Course(courseName, duration);
                    Student student = new Student(name, course, balance);

                    studentDAO.saveStudent(student);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    Student s = studentDAO.getStudent(id);
                    if(s != null) {
                        System.out.println("Student: " + s.getName() + ", Course: " + s.getCourse().getCourseName() + ", Balance: " + s.getBalance());
                    } else {
                        System.out.println("Student not found");
                    }
                    break;

                case 3:
                    System.out.print("Student ID: ");
                    int payId = sc.nextInt();
                    System.out.print("Amount to pay: ");
                    double amt = sc.nextDouble();
                    try { feeService.payFee(payId, amt); }
                    catch(Exception e) { System.out.println(e.getMessage()); }
                    break;

                case 4:
                    System.out.print("Student ID: ");
                    int refId = sc.nextInt();
                    System.out.print("Amount to refund: ");
                    double refundAmt = sc.nextDouble();
                    try { feeService.refundFee(refId, refundAmt); }
                    catch(Exception e) { System.out.println(e.getMessage()); }
                    break;

                case 5:
                    running = false;
                    break;
            }
        }

        sc.close();
        context.close();
    }
}
