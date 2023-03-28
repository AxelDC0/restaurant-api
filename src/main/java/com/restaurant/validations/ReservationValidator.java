package com.restaurant.validations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.restaurant.bean.Reservation;
import com.restaurant.exception.RestaurantException;

public class ReservationValidator {

	public static void validateReservation(Reservation reservation) throws RestaurantException {
		if (reservation.getClientName().isEmpty()) {
			throw new RestaurantException("Invalid client name");
		}
		if (reservation.getNumPeople() < 1) {
			throw new RestaurantException("Invalid number of people");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(reservation.getReservationDateTime(), formatter);
		if (dateTime.isBefore(LocalDateTime.now())) {
			throw new RestaurantException("Invalid reservation date and time");
		}
	}

}
