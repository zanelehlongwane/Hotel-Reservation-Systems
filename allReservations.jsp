<%-- 
    Document   : upComingBooking.jsp
    Created on : 27 Jun 2024, 02:59:08
    Author     : user
--%>

<%@page import="java.util.List"%>
<%@page import="reservation.model.Reservation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upcoming Bookings</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 90%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h3 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        a.back-button {
            display: inline-block;
            margin-bottom: 20px;
            color: #fff;
            background-color: #4CAF50;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        a.back-button:hover {
            background-color: #45a049;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        a.action-button {
            color: #fff;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 4px;
            margin-right: 5px;
        }
        a.edit-button {
            background-color: #4CAF50;
        }
        a.edit-button:hover {
            background-color: #45a049;
        }
        a.cancel-button {
            background-color: #f44336;
        }
        a.cancel-button:hover {
            background-color: #e53935;
        }
    </style>
</head>
<body>
    <div class="container">
        <a href="adminDashboard.jsp" class="back-button">Back</a>

        <% 
            List<Reservation> allReservations = (List<Reservation>) request.getAttribute("allReservations");
            if (allReservations == null || allReservations.isEmpty()) { 
        %>
            <p>No reservations available</p>
        <% } else { %>
            <h3>All Reservations:</h3>
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
                        <th colspan="2">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Reservation reservation : allReservations) { %>
                    <tr>
                        <td><%=reservation.getResId()%></td>
                        <td><%=reservation.getUserId()%></td>
                        <td><%=reservation.getRoomId()%></td>
                        <td><%=reservation.getCheckInDate()%></td>
                        <td><%=reservation.getCheckOutDate()%></td>
                        <td><%=reservation.getReservationStatus()%></td>
                        <td><%=reservation.getDiningOptionId()%></td>
                        <td>
                            <a href="editReservation.jsp?resId=<%=reservation.getResId()%>" 
                               class="action-button edit-button" 
                               onclick="return confirm('Are you sure you want to edit this reservation?');">Edit</a>
                        </td>
                        <td>
                            <a href="cancelReservation.jsp?resId=<%=reservation.getResId()%>" 
                               class="action-button cancel-button" 
                               onclick="return confirm('Are you sure you want to cancel this reservation?');">Cancel</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>
         <input type="hidden" name="user_id" value="${sessionScope.id}">
            <input type="hidden" name="check_in_date" value="${sessionScope.checkInDate}">
            <input type="hidden" name="check_out_date" value="${sessionScope.checkOutDate}">
            <input type="hidden" name="room_type" value="${sessionScope.roomType}">
            <input type="hidden" name="num_people" value="${sessionScope.numPeople}">
    </div>
</body>
</html>
