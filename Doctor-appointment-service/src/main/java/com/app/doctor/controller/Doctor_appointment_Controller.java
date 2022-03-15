package com.app.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.app.doctor.service.AppointmentService;

import java.util.*;

import com.app.doctor.entity.*;
import com.app.doctor.exception.FieldEmptyException;
import com.app.doctor.exception.NoDoctorsException;

@RestController
@CrossOrigin
@RequestMapping(path = "DA/appointment")
public class Doctor_appointment_Controller {
	
	@Autowired
	private AppointmentService appointmentService;
	
	/*
	 * This method takes two parameters as input endTime and startTime sends that to service layer
	 * @Param endTime
	 * @Param starTime
	 */
	
	@PostMapping(path="/getDoctorsByInputTime")
	public ResponseEntity<Object>  getDoctorsByInputTime(@RequestBody Required require) throws NoDoctorsException
	{
		ResponseEntity<Object> response =null;
		try {
		List<Object>  result=appointmentService.getDoctorsByUserRequired(require);
		response=new ResponseEntity<Object>(result,HttpStatus.OK);
		return response;
		}catch(NoDoctorsException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,"No Doctors Available");
		}

	}
	/*
	 * This method is created based on the assumption of storing the appointment details after fetching the doctor details
	 */
	
	@PostMapping(path = "/addAppointment")
	public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) throws FieldEmptyException {
		ResponseEntity<Appointment> response = null;
		if (appointmentService.addAppointment(appointment)) {
			response = new ResponseEntity<Appointment>(appointment, HttpStatus.CREATED);
		}
		return response;
	}	

}
