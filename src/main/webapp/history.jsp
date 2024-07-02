<%@page import="reservation.model.Reservation"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reservation History</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <% 
        List<Reservation> history = (List<Reservation>) request.getAttribute("history");
        if (history == null || history.isEmpty()) {
    %>
    <h1>Reservation History</h1>
    <p>No reservations available</p>
    <% } else { %>
    <h1>Reservation History</h1>
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
            <% for (Reservation reservation : history) { %>
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
</body>
</html>
