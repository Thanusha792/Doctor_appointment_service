package com.app.doctor.service;

import javax.transaction.Transactional;

import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.doctor.controller.Doctor_appointment_Controller;
import com.app.doctor.entity.Appointment;
import com.app.doctor.entity.Required;
import com.app.doctor.exception.FieldEmptyException;
import com.app.doctor.exception.NoDoctorsException;
import com.app.doctor.repository.AppointmentRepository;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService{
	
	Logger logger= LoggerFactory.getLogger(Doctor_appointment_Controller.class);
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	/*
	 * This method takes appointment object as a input and creates a appointment object in database. 
	 */
	
	@Override
	@Transactional
	public boolean addAppointment(Appointment appointment) throws FieldEmptyException{
		
		boolean result = false;
		if (appointment.getAppointmentId()!=-1 && !appointment.getDoctorName().isEmpty()) {
			 String name = appointment.getDoctorName();
			String regex = "^[A-Za-z ]+";
			if (name.matches(regex)) {
				appointment = appointmentRepository.save(appointment);
				result = true;
					return result;
			}
			logger.error("incorrect details");
		}
		throw new FieldEmptyException("Some Fields are empty");
	}
	
	/*
	 * This method returns list of doctors by taking endTime and startTie as input parameter
     * @Param endTime;
     * @Param startTime
	 */
	@Override
	@Transactional
	public List<Object> getDoctorsByUserRequired(Required require) throws NoDoctorsException {
		RestTemplate restTemplate= new RestTemplate();
		List<Object> response = restTemplate.getForObject("http://localhost:8082/DA/availibility/findDoctors/"+require.getstartTime()+"/"+require.getendTime(),List.class);
		if(!response.isEmpty())
		return response;
		
		logger.error("No doctors available");
		throw new NoDoctorsException("No doctors available");
		
	}
}
