<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: "Lato", sans-serif;
}
 .button {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            outline: none;
            color: #fff;
            background-color: #4CAF50;
            border: none;
            border-radius: 15px;
            box-shadow: 0 9px #999;
            margin-top: 10px;
            margin-left: 100px;
        }
        .button:hover {background-color: #3e8e41}
        .button:active {
            background-color: #3e8e41;
            box-shadow: 0 5px #666;
            transform: translateY(4px);
        }

.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
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
</style>
</head>
<body>

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="userDashboard.jsp">Dashboard</a>
       <a href="getByDateOrID.jsp">Filter Reservations</a>
        <a href="selectRoom.jsp">Create New Reservation</a>
        <a href="editReservation.jsp">Edit Reservations</a>
        <a href="cancelReservation.jsp">Cancel Reservation</a>
        
</div>

<h2>Welcome to Luxury Leisure Hotel(LLH)</h2>
<p>Manage your booking reservation here and also view information on up Coming Reservations</p>
<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; View Options</span>
<div class="form-container">
            <form action="ReservationByDate" method="get">
                <input class="button" type="submit" name="submit" value="History">
                <input class="button" type="submit" name="submit" value="upComing">
                <input class="button" type="submit" name="submit" value="View all Reservations">
              
                <input class="button" type="submit" name="submit" value="Cancel">
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
