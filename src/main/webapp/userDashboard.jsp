<%@page import="java.time.LocalDate"%>
<%@ page import="reservation.model.Reservation" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        body {
            font-family: "Lato", sans-serif;
  background: url("bed.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  margin: 0;
  padding: 0;
  background-color: #f4f4f4;/* Black font color */
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: rgba(255, 255, 255, 0.9);
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h1, h2 {
            text-align: center;
            color: #000; /* Black font color */
        }
        h2 {
            border-bottom: 2px solid #ddd;
            padding-bottom: 10px;
            margin-bottom: 20px;
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
        .navbar {
            background-color: #000; /* Black navbar */
            overflow: hidden;
            margin-bottom: 20px;
        }
        .navbar a, .navbar form {
            float: left;
            display: block;
            color:#000; /* White font color */
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            font-size: 18px; /* Font size for navbar items */
        }
        .navbar form {
            float: left;
        }
        .navbar input[type="submit"] {
            border: none;
            background: #1E90FF; /* Royal blue buttons */
            color: #fff;
            cursor: pointer;
            padding: 14px 20px;
            font-size: 18px; /* Same font size as navbar items */
        }
        .navbar a:hover, .navbar input[type="submit"]:hover {
            background-color: #ddd;
            color: black;
        }
        .sidenav {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color:#111;
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
        }
        .sidenav a {
            padding: 8px 8px 8px 32px;
            text-decoration: none;
            font-size: 25px;
            color: #818181;
            display: block;
            transition: 0.3s;
        }
        .sidenav a:hover {
            color: #f1f1f1;
        }
        .sidenav .closebtn {
            position: absolute;
            top: 0;
            right: 25px;
            font-size: 36px;
            margin-left: 50px;
        }
        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }
        p {
            font-size: 16px; /* Font size for paragraph text */
            line-height: 1.6; /* Line height for better readability */
            margin-bottom: 20px; /* Spacing between paragraphs */
        }
    </style>
</head>
<body>
    

    <div class="container">
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a href="userDashboard.jsp">Dashboard</a>
            <a href="index.jsp">Logout</a>
            <a href="selectRoom.jsp">Book a Room</a>
            <a href="getByDateOrID.jsp">View Reservations</a>
            
        </div>
        <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; View Options</span>
        <h2>Welcome to Luxury Leisure Hotel (LLH)</h2>
        <p>Manage your booking reservations here and also view information on upcoming ones.</p>
        

        <h1>User Dashboard</h1>
        <h2>Today's Date: <%= LocalDate.now() %></h2>
        
        <form action="ReservationByDate" method="post">
            <label>Do you want to cancel Reservation?</label>
                <input type="submit" name="submit" value="Cancel">
            </form>
    </div>

    <script>
        function openNav() {
            document.getElementById("mySidenav").style.width = "250px";
        }

        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
        }
    </script>
</body>
</html>
