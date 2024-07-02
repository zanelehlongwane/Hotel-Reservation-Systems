<%-- 
    Document   : upComingBooking.jsp
    Created on : 27 Jun 2024, 02:59:08
    Author     : user
--%>

<%@page import="java.util.List"%>
<%@page import="reservation.model.Reservation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upcoming Booking</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 900px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        h3 {
            color: #333;
            text-align: center;
            margin-top: 0;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .navigation {
            margin-top: 20px;
            text-align: center;
        }
        .navigation a {
            padding: 10px 20px;
            text-decoration: none;
            color: #333;
            background-color: #f2f2f2;
            border-radius: 4px;
            margin-right: 10px;
        }
        .navigation a:hover {
            background-color: #e0e0e0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h3>Upcoming Bookings</h3>
        
        <div class="navigation">
            <a href="createReservation.jsp">Back</a>
            <a href="upComingByUser.jsp">Filter by User</a>
        </div>
        
        <% 
            List<Reservation> upComing = (List<Reservation>) request.getAttribute("upComing");
            if(upComing == null || upComing.isEmpty()) {
        %>
            <p>No reservations available</p>
        <% } else { %>
            <table>
                <thead>
                    <tr>
                        <th>Reservation ID</th>
                        <th>User ID</th>
                        <th>Room ID</th>
                        <th>Check-in Date</th>
                        <th>Check-out Date</th>
                        <th>Status</th>
                        <th>Dining Option ID</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(Reservation reservation : upComing) { %>
                        <tr>
                            <td><%= reservation.getResId() %></td>
                            <td><%= reservation.getUserId() %></td>
                            <td><%= reservation.getRoomId() %></td>
                            <td><%= reservation.getCheckInDate() %></td>
                            <td><%= reservation.getCheckOutDate() %></td>
                            <td><%= reservation.getReservationStatus() %></td>
                            <td><%= reservation.getDiningOptionId() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>
    </div>
</body>
</html>
