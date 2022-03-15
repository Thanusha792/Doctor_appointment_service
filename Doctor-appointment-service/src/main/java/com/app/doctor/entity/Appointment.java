package com.app.doctor.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="Appointment")
public class Appointment {
	

	@Id
	@Column(name = "appointmentId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int appointmentId;
	
	private int doctorId;
	
	private String doctorName;
	
	private String appointmentTime;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public Appointment(int appointmentId, int doctorId, String doctorName, String appointmentTime) {
		super();
		this.appointmentId = appointmentId;
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.appointmentTime = appointmentTime;
	}

	
}
