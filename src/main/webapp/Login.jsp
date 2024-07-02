<%@page import="user.model.User"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 5px;
            color: #555;
        }
        input[type="email"],
        input[type="password"] {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        input[type="submit"] {
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color:#4CAF50;
        }
        .message {
            text-align: center;
            color: red;
            margin-bottom: 15px;
        }
        .back-button {
            background-color:#333;
        }
        input[type="submit"].back-button:hover {
            background-color: #444;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Log In</h1>
        <%
             User user = (User)request.getSession(false).getAttribute("user");
            Integer userId = (Integer)request.getSession(false).getAttribute("user_id");
            Integer roomId = (Integer)request.getSession(false).getAttribute("room_id");
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
        <div class="message"><%= message %></div>
        <% } %>
        <form  action="UserServlet" method="post">
            <label for="email">Email:</label>
            <input id="email" name="email" type="email" >
            
            <label for="password">Password:</label>
            <input id="password" name="password" type="password" ><br><br>
            
            <input name="submit" type="submit" value="login"><br>
            <input name="submit" type="submit" value="Back" class="back-button">
        </form>
        
        
    </div>
</body>
</html>
