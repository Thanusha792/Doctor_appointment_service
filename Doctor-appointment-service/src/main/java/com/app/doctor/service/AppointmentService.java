package com.app.doctor.service;

import java.util.List;

import org.aspectj.apache.bcel.classfile.Module.Require;

import com.app.doctor.entity.Appointment;
import com.app.doctor.entity.Required;
import com.app.doctor.exception.FieldEmptyException;
import com.app.doctor.exception.NoDoctorsException;

public interface AppointmentService {
	public boolean addAppointment(Appointment appointment) throws FieldEmptyException;
	public List<Object> getDoctorsByUserRequired(Required require) throws NoDoctorsException ;
}
