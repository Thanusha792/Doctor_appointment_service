package com.app.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.doctor.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

}
