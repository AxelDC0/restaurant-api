package com.restaurant.repository;

import java.io.IOException;
import java.util.List;

import com.restaurant.bean.Reservation;

public interface ReservationRepository {
	public List<Reservation> getAllReservations() throws IOException ;

	public Reservation addReservation(Reservation reservation) throws IOException ;

}
