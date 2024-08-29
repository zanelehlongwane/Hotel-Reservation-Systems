<%@page import="reservation.model.Reservation"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="room.model.Room"%>
<%@page import="user.model.User"%>
<%@page import="reservation.dining.model.DiningOption"%>

    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reservations</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 80%;
            margin: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 8px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
     <% 
            DiningOption diningOption = (DiningOption) request.getSession(false).getAttribute("diningOptions");
            User user = (User) request.getSession(false).getAttribute("user");
            Room room = (Room) request.getSession(false).getAttribute("room");
            Integer roomId = (Integer) request.getSession(false).getAttribute("roomId");
            Integer hotelId = (Integer) request.getSession(false).getAttribute("hotelId");
            LocalDate checkInDate = (LocalDate) request.getSession(false).getAttribute("checkInDate");
            LocalDate checkOutDate = (LocalDate) request.getSession(false).getAttribute("checkOutDate");
            List<DiningOption> diningOptions = (List<DiningOption>) request.getAttribute("diningOptions");
            
            // Format the dates to a string that can be used in the input fields
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedCheckInDate = checkInDate != null ? checkInDate.format(formatter) : "";
            String formattedCheckOutDate = checkOutDate != null ? checkOutDate.format(formatter) : "";
             List<Reservation> reservations =(List<Reservation>)request.getSession(false).getAttribute("reservations");
        %>
    <div class="container">
        <h2>Reservations</h2>
        <table>
            <thead>
                <tr>
                    <th>Reservation ID</th>
                    <th>User ID</th>
                    <th>Room ID</th>
                    <th>Check-In Date</th>
                    <th>Check-Out Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="reservation" items="${reservations}">
                    <tr>
                        <td>${reservation.id}</td>
                        <td>${reservation.userId}</td>
                        <td>${reservation.roomId}</td>
                        <td>${reservation.checkInDate}</td>
                        <td>${reservation.checkOutDate}</td>
                        <td>${reservation.status}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>

