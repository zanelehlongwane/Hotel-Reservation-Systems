<%@page import="user.model.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Room Selection</title>
    <style>
        body {
            font-family: Arial, sans-serif;
           background-image:  url(bed.jpg);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 400px;
            width: 100%;
        }
        .inner-container {
            margin: auto;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        label {
            margin-bottom: 5px;
            color: #555;
            text-align: left;
            width: 100%;
        }
        input[type="text"],
        input[type="date"],
        select {
            margin-bottom: 15px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: calc(100% - 22px);
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .message {
            background-color: #f8d7da;
            color: #721c24;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #f5c6cb;
            border-radius: 5px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="inner-container">
            <%
                User user = (User)request.getSession(false).getAttribute("user");
                Integer userId = (Integer)request.getSession(false).getAttribute("user_id");
                Integer roomId = (Integer)request.getSession(false).getAttribute("room_id");
                String message = (String) request.getAttribute("message");
                if (message != null) {
            %>
            <div class="message"><%= message %></div>
            <% } %>
            <h2>Select Room Type and Dates</h2>
            <form action="CheckAvailabilityController" method="post">
                <label for="num_people">Number of people:</label>
                <input type="text" id="num_people" name="num_people" required>

                <label for="check_in_date">Check-in Date:</label>
                <input type="date" id="check_in_date" name="check_in_date" required>

                <label for="check_out_date">Check-out Date:</label>
                <input type="date" id="check_out_date" name="check_out_date" required>

                <label for="room_type">Room Type:</label>
                <select id="room_type" name="room_type" required>
                    <option value="SINGLE">Single</option>
                    <option value="DOUBLE">Double</option>
                    <option value="SUITE">Suite</option>
                    <option value="EXECUTIVE">Executive</option>
                </select>

                <input name="submit" type="submit" value="Check Availability">
            </form>
        </div>
    </div>
</body>
</html>
