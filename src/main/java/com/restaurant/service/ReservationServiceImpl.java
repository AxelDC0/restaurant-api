package com.restaurant.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.restaurant.bean.Reservation;
import com.restaurant.repository.ReservationRepository;
import com.restaurant.repository.ReservationRepositoryImpl;
import com.restaurant.validations.ReservationValidator;

public class ReservationServiceImpl implements ReservationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRepositoryImpl.class);
	private ReservationRepository reservationRepository;

	public ReservationServiceImpl() {
		try {
			this.reservationRepository = new ReservationRepositoryImpl();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	public List<Reservation> getAllReservations() {
		try {
			return this.reservationRepository.getAllReservations();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
			return new ArrayList<Reservation>();
		}
	}

	public Reservation addReservation(Reservation reservation) {
		try {
			ReservationValidator.validateReservation(reservation);
			return reservationRepository.addReservation(reservation);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return new Reservation(-1L, "It was NOT able to add the reservation. Try again.");
	}

}
