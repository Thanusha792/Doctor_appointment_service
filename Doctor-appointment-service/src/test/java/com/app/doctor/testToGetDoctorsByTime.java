package com.app.doctor;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.doctor.entity.Required;
import com.app.doctor.service.AppointmentService;


@SpringBootTest
public class testToGetDoctorsByTime {

	@Autowired
	private AppointmentService appointmentService;
	
	@Test
	void testTogetDoctorsDetails() {
		
		Required require=new Required();
		require.setendTime("string");
		require.setstartTime("string");
		List<Object>  object=appointmentService.getDoctorsByUserRequired(require);
		assertNotNull(object);
	}
	

}
