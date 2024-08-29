<%@page import="room.model.Room"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Select Room</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image:  url(bed.jpg);
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: lavender;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .container {
            width: 80%;
            margin: auto;
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
        }
        h2 {
            text-align: center;
        }
        .btn-container {
            text-align: center;
            margin: 20px 0;
        }
        .btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            text-decoration: none;
            border-radius: 5px;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Select Room</h2>
        <% 
            List<Room> availableRooms = (List<Room>) request.getAttribute("availableRooms"); 
        %>
        <form action="CheckAvailabilityController" method="post">
            <table>
                <tr>
                    <th>Room ID</th>
                    <th>Room Type</th>
                    <th>Rate</th>
                    <th>Occupancy Limit</th>
                    <th>Description</th>
                    <th>Hotel Id</th>
                    <th>Select</th>
                </tr>
                <c:forEach var="room" items="${availableRooms}">
                    <tr>
                        <td>${room.id}</td>
                        <td>${room.roomType}</td>
                        <td>${room.rate}</td>
                        <td>${room.occupancyLimit}</td>
                        <td>${room.description}</td>
                        <td>${room.hotelId}</td>
                        <td>
                            <input type="radio" name="room_id" value="${room.id}" required>
                            <input type="hidden" name="hotel_id" value="${room.hotelId}">
                        </td>
                    </tr> 
                </c:forEach>
            </table>
            <!-- Hidden fields to pass previous form data to the next step -->
            <input type="hidden" name="user_id" value="${sessionScope.id}">
            <input type="hidden" name="check_in_date" value="${sessionScope.checkInDate}">
            <input type="hidden" name="check_out_date" value="${sessionScope.checkOutDate}">
            <input type="hidden" name="room_type" value="${sessionScope.roomType}">
            <input type="hidden" name="num_people" value="${sessionScope.numPeople}">
            
            <div class="btn-container">
                <input class="btn" name="submit" type="submit" value="Proceed to Reservation">
            </div>
        </form>
    </div>
</body>
</html>
