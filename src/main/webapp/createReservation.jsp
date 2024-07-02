<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.List"%>
<%@page import="room.model.Room"%>
<%@page import="user.model.User"%>
<%@page import="java.time.LocalDate"%>
<%@page import="reservation.dining.model.DiningOption"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Reservation</title>
    <style>
        /* Your CSS styles here */
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
    </style>
    <div>
        
    </div>
</head>
<body>
    <h2>Create Reservation</h2>
    
       
        <% 
            Integer userId = (Integer) request.getSession(false).getAttribute("user_id");
            Integer roomId = Integer.valueOf(request.getParameter("room_id"));
            Integer hotelId = Integer.valueOf(request.getParameter("hotel_id"));
            LocalDate checkInDate = (LocalDate) request.getSession(false).getAttribute("checkInDate");
            LocalDate checkOutDate = (LocalDate) request.getSession(false).getAttribute("checkOutDate");
            
            // Format the dates to a string that can be used in the input fields
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedCheckInDate = checkInDate != null ? checkInDate.format(formatter) : "";
            String formattedCheckOutDate = checkOutDate != null ? checkOutDate.format(formatter) : ""; 
        %>
       <form action="ReservationByDate" method="post"> 
        <!-- Automatically filled fields from session or request parameters -->
        <label for="user_id">User ID:</label>
        <input type="text" id="user_id" name="userId" value="<%=userId%>" readonly><br><br>
        
        <label for="hotelId">Hotel ID:</label>
        <input type="text" id="hotelId" name="hotelId" value="<%=hotelId%>" readonly><br><br>
        
        <label for="room_id">Room ID:</label>
        <input type="text" id="room_id" name="roomId" value="<%=roomId%>" readonly><br><br>
        
        <label for="check_in_date">Check-in Date:</label>
        <input type="text" id="check_in_date" name="checkInDate" value="<%=formattedCheckInDate%>" readonly><br><br>
        
        <label for="check_out_date">Check-out Date:</label>
        <input type="text" id="check_out_date" name="checkOutDate" value="<%=formattedCheckOutDate%>" readonly><br><br>
        
        <label for="reservationStatus">Reservation Status:</label>
        <select id="reservationStatus" name="reservationStatus">
            <option value="confirmed">Confirmed</option>
            <option value="canceled" disabled>Cancelled</option>
        </select><br><br>

        <label for="dining_option_id">Select Dining Option:</label>
        <input type ="text" id ="diningOptionId" >
        <br><br>
        
        <!-- Submit button -->
        <input name ="submit" type="submit" value="Create">
        <input name ="submit" type="submit" value="View DiningOptions">
        <input name ="submit" type="submit" value="Go back">
    </form>
</body>
</html>
