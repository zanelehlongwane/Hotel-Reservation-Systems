<%@page import="user.model.User"%>
<%@page import="reservation.dining.model.DiningOption"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LLH Dining Options</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .navbar {
            background-color: #333;
            overflow: hidden;
        }
        .navbar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
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
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .message {
            text-align: center;
            color: red;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="navbar">    
        <a href="createReservation.jsp">Return to Reservation Form</a>
    </div>
    <div class="container">
        <h1>LLH Dining Options</h1>
        <%
            User user = (User) request.getSession(false).getAttribute("user");
            List<DiningOption> dining = (List<DiningOption>) request.getAttribute("dining");
            if (dining == null || dining.isEmpty()) {
        %>
            <p class="message">No dining options are available</p>
        <%
            } else {
        %>
        <form method="post" action="ReservationByDate">
            <table>
                <tr>
                    <th>Dining Id</th>
                    <th>Hotel Id</th>
                    <th>Option Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Availability Status</th>
                </tr>
                <% for (DiningOption dine : dining) { %>    
                    <tr>
                        <td><%= dine.getResId() %></td>
                        <td><%= dine.getHotelId() %></td>
                        <td><%= dine.getOptionName() %></td>
                        <td><%= dine.getDescription() %></td>
                        <td><%= dine.getPrice() %></td>
                        <td><%= dine.getFoodAvalability() %></td>
                    </tr>
                <% } %>
            </table>
        </form>
        <%
            }
        %>
    </div>
</body>
</html>
