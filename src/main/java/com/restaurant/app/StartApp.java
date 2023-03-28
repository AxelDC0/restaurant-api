package com.restaurant.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.restaurant.controller.ReservationController;

import io.muserver.Method;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;

public class StartApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(StartApp.class);

	public static void main(String[] args) {
		ReservationController restaurantController = new ReservationController();
		MuServer server = MuServerBuilder.httpServer().withHttpPort(8080)
				.addHandler(Method.GET, "/restaurant/getAllReservations", restaurantController.getAllReservations())
				.addHandler(Method.POST, "/restaurant/addReservation", restaurantController.addReservation()).start();
		LOGGER.info("Server started at port {}", server);
	}
}
