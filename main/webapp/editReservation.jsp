<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate"%>
<%@page import="reservation.model.Reservation"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Reservation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        form {
            margin-top: 20px;
        }
        label {
            display: block;
            margin-bottom: 10px;
            color: #555;
        }
        input[type="text"],
        input[type="date"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 15px;
            box-shadow: 0 9px #999;
        }
        input[type="submit"]:hover {
            background-color: #3e8e41;
        }
        p {
            text-align: center;
            margin-top: 10px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Update Reservation</h2>
        <form action="UpdateReservationController" method="post">
            <input type="hidden" name="reservationId" value="${reservation.resId}">
            
            <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId" value="${reservation.userId}" required><br><br>

            <label for="roomId">Room ID:</label>
            <input type="text" id="roomId" name="roomId" value="${reservation.roomId}" required><br><br>

            <label for="checkInDate">Check-in Date:</label>
            <input type="date" id="checkInDate" name="checkInDate" value="${reservation.checkInDate}" required><br><br>

            <label for="checkOutDate">Check-out Date:</label>
            <input type="date" id="checkOutDate" name="checkOutDate" value="${reservation.checkOutDate}" required><br><br>

            <label for="status">Status:</label>
            <select id="status" name="status">
                <option value="CONFIRMED" ${reservation.status == 'CONFIRMED' ? 'selected' : ''}>Confirmed</option>
                <option value="CANCELED" ${reservation.status == 'CANCELED' ? 'selected' : ''}>Cancelled</option>
            </select><br><br>

            <label for="diningOptionId">Dining Option ID:</label>
            <input type="text" id="diningOptionId" name="diningOptionId" value="${reservation.diningOptionId}"><br><br>

            <input type="submit" value="Edit">
        </form>

        <c:if test="${not empty message}">
            <p>${message}</p>
        </c:if>
    </div>
</body>
</html>
