<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
Result: <br>
Last Name: ${lastName} <br>
First Name ${firstName} <br>
Email: ${email} <br>
Address: ${address} <br>
City: ${city} <br>
State: ${state} <br>
Zip Code: ${zip} <br>
<br>
Added to DB successfully.<br><br>

<form action="http://localhost:8080/customerForm">
    <input type="submit" value="Return">
</form><br>

<div style="text-align:center">
    <br><br><input type="button" value="Close this window" onclick="self.close()">
</div>
</body>
</html>