# restaurant-api
This is a project to create and view the reservations for a restaurant. 

It contains two user stories:

User Story 1: As a customer I want to be able to request a booking at this restaurant.
User Story 2: As the restaurant owner I want to be able to see all bookings for a particular day.

This project creates two endpoints, one for each user story. It could be run in local.

For reservation you can use this URL when running in local http://localhost:8080/restaurant/addReservation, with this body
{
    "clientName": "Axel Dolores Cruz",
    "clientPhoneNumber": 5573297858,
    "reservationDateTime": "2023-05-19 20:00",
    "zone": "1st floor",
    "numPeople": 2
}

To view all the reservations the URL is http://localhost:8080/restaurant/getAllReservations
