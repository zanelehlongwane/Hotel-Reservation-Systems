<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="reservation.model.Reservation"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search Reservations</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 8px;
            width: 80%;
            max-width: 800px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin: 10px 0 5px;
            color: #555;
        }
        input[type="text"], input[type="date"], select {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Search Reservations</h2>
        
        
        <form action="ReservationByDate" method="post">
            <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId"><br><br>
            
            <label for="checkInDate">Check-in Date:</label>
            <input type="date" id="checkInDate" name="checkInDate"><br><br>
            
            <label for="checkOutDate">Check-out Date:</label>
            <input type="date" id="checkOutDate"  name="checkOutDate"><br><br>
            
            <input type="submit" name ="submit" value="Search">
            <input type="submit" name="submit" value="History">
            <input type="submit" name="submit" value="upComing">
        </form>
        
        <% 
            
            List<Reservation> reservations = (List<Reservation>) request.getAttribute("reservations");
            
            if(reservations == null || reservations.isEmpty()){%>
            
            <%}else
        {%>

        
            <h3>Search Results:</h3>
            <table border ="1">
                <tr>
                    <th>Reservation ID</th>
                    <th>User ID</th>
                    <th>Room ID</th>
                    <th>Check-in Date</th>
                    <th>Check-out Date</th>
                    <th>Status</th>
                    <th>Dining Option ID</th>
                </tr>
                <tbody
               <% for(Reservation reservation:reservations){%>
                    <tr>
                        <td><%=reservation.getResId()%></td>
                        <td><%=reservation.getUserId()%></td>
                        <td><%=reservation.getRoomId()%></td>
                        
                        <td><%=reservation.getCheckInDate()%></td>
                        <td><%=reservation.getCheckOutDate()%></td>
                        <td><%=reservation.getReservationStatus()%></td>
                        <td><%=reservation.getDiningOptionId()%></td>
                    </tr>
                <%}%>
                </tbody>
            </table>
       <%}%>
       
       <% 
            List<Reservation> history = (List<Reservation>) request.getAttribute("history");
            if(history == null || history.isEmpty()){%>
            
            <%}else
        {%>

        
            <h3>History:</h3>
            <table border ="1">
                <tr>
                    <th>Reservation ID</th>
                    <th>User ID</th>
                    <th>Room ID</th>
                    <th>Check-in Date</th>
                    <th>Check-out Date</th>
                    <th>Status</th>
                    <th>Dining Option ID</th>
                </tr>
                <tbody
               <% for(Reservation reservation: history){%>
                    <tr>
                        <td><%=reservation.getResId()%></td>
                        <td><%=reservation.getUserId()%></td>
                        <td><%=reservation.getRoomId()%></td>
                        <td><%=reservation.getCheckInDate()%></td>
                        <td><%=reservation.getCheckOutDate()%></td>
                        <td><%=reservation.getReservationStatus()%></td>
                        <td><%=reservation.getDiningOptionId()%></td>
                    </tr>
                <%}%>
                </tbody>
            </table>
       <%}%>
       <% 
            List<Reservation> upComing = (List<Reservation>) request.getAttribute("upComing");
            if(upComing == null || upComing.isEmpty()){%>
            
            <%}else
        {%>

        
            <h3>Search Results:</h3>
            <table border ="1">
                <tr>
                    <th>Reservation ID</th>
                    <th>User ID</th>
                    <th>Room ID</th>
                    <th>Check-in Date</th>
                    <th>Check-out Date</th>
                    <th>Status</th>
                    <th>Dining Option ID</th>
                </tr>
                <tbody
               <% for(Reservation reservation:upComing){%>
                    <tr>
                        <td><%=reservation.getResId()%></td>
                        <td><%=reservation.getUserId()%></td>
                        <td><%=reservation.getRoomId()%></td>
                        <td><%=reservation.getCheckInDate()%></td>
                        <td><%=reservation.getCheckOutDate()%></td>
                        <td><%=reservation.getReservationStatus()%></td>
                        <td><%=reservation.getDiningOptionId()%></td>
                    </tr>
                <%}%>
                </tbody>
            </table>
       <%}%>
    </div>
</body>
</html>
