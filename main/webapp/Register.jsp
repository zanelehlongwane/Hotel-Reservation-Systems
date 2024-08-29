<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
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
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 280px;
            text-align: center;
        }
        h1 {
            color: #333;
        }
        h2 {
            color: #555;
            margin-bottom: 20px;
        }
        input[type="text"], input[type="email"], input[type="password"], select {
            width: calc(100% - 20px);
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin: 10px 0;
            border: none;
            border-radius: 4px;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .message {
            color: red;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <% String message = (String) request.getAttribute("message"); 
           if (message != null) { %>
            <div class="message"><%= message %></div>
        <% } %>
        <h2>Register</h2>
        <form method="post" action="UserServlet">
            <input name="username" type="text" placeholder="Username" required><br>
            <input name="email" type="email" placeholder="Email" required><br>
            <input name="password" type="password" placeholder="Password" required><br>
            <input name="phone_number" type="text" placeholder="Phone Number" required><br>
            <select id="role" name="role">
                <option value="ADMIN" disabled>Manager/Staff (Disabled)</option>
                <option value="GUEST">Guest</option>
            </select><br>
            <input name="submit" type="submit" value="Register">
            <input name="submit" type="submit" value="Back">
        </form>
    </div>
</body>
</html>
