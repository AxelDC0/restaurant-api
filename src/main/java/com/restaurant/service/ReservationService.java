package com.restaurant.service;

import java.util.List;

import com.restaurant.bean.Reservation;

public interface ReservationService {
	public List<Reservation> getAllReservations();

	public Reservation addReservation(Reservation reservation);
}
