package com.example.sms;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    private double amount;
    private Date date;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    public Payment() {}
    public Payment(Student student, double amount) {
        this.student = student;
        this.amount = amount;
        this.date = new Date();
    }

    // Getters & Setters
    public int getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public Date getDate() { return date; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}
