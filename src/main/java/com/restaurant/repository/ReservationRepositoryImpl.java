package com.restaurant.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.bean.Reservation;

public class ReservationRepositoryImpl implements ReservationRepository {

	private static final String FILENAME = "repository.json";
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRepositoryImpl.class);

	private ObjectMapper objectMapper;
	private File file;

	public ReservationRepositoryImpl() throws IOException {
		objectMapper = new ObjectMapper();
		file = new File(this.getClass().getClassLoader().getResource(FILENAME).getFile());
		if (!file.exists()) {
			file.createNewFile();
			LOGGER.info("repository.json was successfully created");
			return;
		}
		LOGGER.info("repository.json was successfully found");
	}

	@Override
	public List<Reservation> getAllReservations() throws IOException {
		List<Reservation> reservations = new ArrayList<>();
		reservations = objectMapper.readValue(file, new TypeReference<List<Reservation>>() {
		});
		LOGGER.info("repository.json was successfully read");
		return reservations;
	}

	@Override
	public Reservation addReservation(Reservation reservation) throws IOException {
		List<Reservation> reservations = getAllReservations();
		if (reservations.isEmpty()) {
			reservation.setReservationId(1L);
		} else {
			reservation.setReservationId(reservations.stream().map(reserv -> reserv.getReservationId())
					.sorted((x, y) -> y.compareTo(x)).findFirst().orElse(1L));
		}
		reservations.add(reservation);
		objectMapper.writeValue(file, reservations);
		LOGGER.info("repository.json was successfully modified");
		return reservation;
	}

}
