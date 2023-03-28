package com.restaurant.bean;

import java.util.List;

import com.google.gson.Gson;

public class Reservation {
	private Long reservationId;
	private String clientName;
	private Long clientPhoneNumber;
	private String reservationDateTime;
	private String zone;
	private Integer numPeople;

	public Reservation() {
	}

	public Reservation(Long reservationId, String clientName) {
		this.reservationId = reservationId;
		this.clientName = clientName;
	}

	public Reservation(Long reservationId, String clientName, Long clientPhoneNumber, String reservationDateTime,
			String zone, Integer numPeople) {
		this.reservationId = reservationId;
		this.clientName = clientName;
		this.clientPhoneNumber = clientPhoneNumber;
		this.reservationDateTime = reservationDateTime;
		this.zone = zone;
		this.numPeople = numPeople;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Long getClientPhoneNumber() {
		return clientPhoneNumber;
	}

	public void setClientPhoneNumber(Long clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}

	public String getReservationDateTime() {
		return reservationDateTime;
	}

	public void setReservationDateTime(String reservationDateTime) {
		this.reservationDateTime = reservationDateTime;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public Integer getNumPeople() {
		return numPeople;
	}

	public void setNumPeople(Integer numPeople) {
		this.numPeople = numPeople;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", clientName=" + clientName + ", clientPhoneNumber="
				+ clientPhoneNumber + ", reservationDateTime=" + reservationDateTime + ", zone=" + zone + ", numPeople="
				+ numPeople + "]";
	}

	public static String toJson(Reservation reservation) {
		Gson gson = new Gson();
		return gson.toJson(reservation);
	}

	public static String toJson(List<Reservation> reservations) {
		Gson gson = new Gson();
		return gson.toJson(reservations);
	}

	public static Reservation fromJson(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Reservation.class);
	}

}
