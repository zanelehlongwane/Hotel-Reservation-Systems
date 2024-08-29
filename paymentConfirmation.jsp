<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment Confirmation</title>
    <style>
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
        .message {
            text-align: center;
            font-size: 18px;
            margin-top: 20px;
        }
        .success {
            color: #4CAF50;
        }
        .failure {
            color: #f44336;
        }
        p {
            text-align: center;
            margin-top: 10px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Payment Confirmation</h2>
        <div class="message">
            <p>${message}</p>
            <c:if test="${paymentStatus == 'success'}">
                <p class="success">Your payment was successful! Thank you for your purchase.</p>
            </c:if>
            
        </div>
    </div>
</body>
</html>
