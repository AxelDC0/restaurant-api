package com.restaurant.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.restaurant.bean.Reservation;
import com.restaurant.service.ReservationService;
import com.restaurant.service.ReservationServiceImpl;

import io.muserver.RouteHandler;

public class ReservationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	private final ReservationService reservationService;

	public ReservationController() {
		this.reservationService = new ReservationServiceImpl();
	}

	public RouteHandler getAllReservations() {
		return (request, response, pathParams) -> {
			try {
				List<Reservation> reservations = reservationService.getAllReservations();
				response.contentType("application/json");
				response.status(201);
				response.write(Reservation.toJson(reservations));
			} catch (Exception e) {
				LOGGER.error("Error viewing reservations", e);
				response.status(500);
			}
		};
	}

	public RouteHandler addReservation() {
		return (request, response, pathParams) -> {
			try {
				Reservation reservation = Reservation.fromJson(request.readBodyAsString());
				System.out.println(reservation);
				reservation = reservationService.addReservation(reservation);
				System.out.println(reservation);
				response.contentType("application/json");
				response.status(201);
				response.write(Reservation.toJson(reservation));
			} catch (Exception e) {
				LOGGER.error("Error adding the reservation", e);
				response.status(500);
			}
		};
	}

}
