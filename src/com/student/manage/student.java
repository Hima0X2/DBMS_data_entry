package com.student.manage;

public class student {
private String roll;
private String name,number;
private String gpa;
public student(String roll, String number, String name, String gpa) {
	super();
	this.roll = roll;
	this.number = number;
	this.name = name;
	this.gpa = gpa;
}
public student() {
	super();
	// TODO Auto-generated constructor stub
}
public student(String number, String name, String gpa) {
	super();
	this.number = number;
	this.name = name;
	this.gpa = gpa;
}
@Override
public String toString() {
	return "student [roll=" + roll + ", name=" + name + ", number=" + number + ", gpa=" + gpa + "]";
}
public String getRoll() {
	return roll;
}
public void setRoll(String roll) {
	this.roll = roll;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGpa() {
	return gpa;
}
public void setGpa(String gpa) {
	this.gpa = gpa;
}

}
