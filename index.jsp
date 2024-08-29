<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Luxury Leisure Hotel - Home</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: url("sit.jpg") no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            color: #fff;
        }
        header {
            background-color:#fff;
            
            padding: 20px;
            text-align: center;
        }
        h1 {
            font-size: 3em;
            margin: 0;
            color:#000;
        }
        h2 {
            font-size: 1.5em;
            color: #000;
            margin-top: 0;
        }
        .container {
            text-align: center;
            margin-top: 10%;
        }
        .content-box {
            background-color:#fff;
            padding: 30px;
            border-radius: 10px;
            display: inline-block;
        }
        .container label {
            color:#000;
            font-size: 1.2em;
            margin-bottom: 10px;
            display: block;
        }
        .container button {
            padding: 10px 20px;
            font-size: 1em;
            color:#f0f0f0;
            background-color:#28a745;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 10px;
        }
        .container button:hover {
            background-color:#28a745;
        }
    </style>
    <script>
        function redirectToLogin() {
            // moving from home page to login page
            window.location.href = "Login.jsp";
        }
        function redirectToRegister() {
            // moving from home page to register page
            window.location.href = "Register.jsp";
        }
    </script>
</head>
<body>
    <header>
        <h1>Luxury Leisure Hotel</h1>
    </header>
    <div class="container">
        <div class="content-box">
            <h2>Experience Luxury and Comfort at its Best</h2>
            <label>New user?</label>
            <button onclick="redirectToRegister()">Register</button>
            <label>Already have an account?</label>
            <button onclick="redirectToLogin()">Log In</button>
        </div>
    </div>
</body>
</html>
