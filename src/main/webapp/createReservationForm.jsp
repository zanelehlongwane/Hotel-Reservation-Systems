<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Reservation</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color:#ff44;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center; /* Center align contents */
        }
        .navbar {
            background-color: #333;
            overflow: hidden;
            text-align: center; /* Center align navbar links */
        }
        .navbar a {
            display: inline-block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            transition: background-color 0.3s;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        form {
            display: inline-block; /* Ensure form is centered */
            text-align: left; /* Align form elements to the left */
        }
        label {
            display: block; /* Ensure labels appear on separate lines */
            margin-bottom: 10px; /* Add spacing between labels */
        }
        input[type="text"],
        input[type="date"],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        
    </style>
</head>
<body>
    <div class="navbar">
        <a href="selectRoom.jsp">Continue to reservation</a>
        <a href="adminDashboard.jsp">Back to menu</a>
        <a href="index.jsp">LogOut</a>
    </div>
    <!--<div class="container">
        <h1>Create New Reservation</h1>
        <form action="AdminController" method="post">
            <input type="hidden" name="action" value="create">
            
            <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId" required><br><br>
            
            <label for="roomId">Room ID:</label>
            <input type="text" id="roomId" name="roomId" required><br><br>
            
            <label for="checkInDate">Check-In Date:</label>
            <input type="date" id="checkInDate" name="checkInDate" required><br><br>
            
            <label for="checkOutDate">Check-Out Date:</label>
            <input type="date" id="checkOutDate" name="checkOutDate" required><br><br>
            
            <label for="reservationStatus">Status:</label>
            <select id="reservationStatus" name="reservationStatus" required>
                <option value="CONFIRMED">Confirmed</option>
                <option value="CANCELLED">Cancelled</option>
            </select><br><br>
            
            <label for="diningOptionId">Dining Option ID:</label>
            <input type="text" id="diningOptionId" name="diningOptionId" required><br><br>
            
            <input type="submit" value="Create Reservation">
        </form>
    </div>-->
</body>
</html>
