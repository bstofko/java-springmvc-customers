<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        a:link {
            color: blue;
            background-color: transparent;
            text-decoration: none;
        }

        a:visited {
            color: purple;
            background-color: transparent;
            text-decoration: none;
        }

        a:hover {
            color: red;
            background-color: transparent;
            text-decoration: underline;
        }

        a:active {
            color: yellow;
            background-color: transparent;
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h2>Please click the corresponding link to perform the stated operation:</h2><br>

<form action="http://localhost:8080/customerForm">
    <input type="submit" value="Add Customer">
</form><br>
<form action="http://localhost:8080/emailForm">
    <input type="submit" value="Send Email">
</form><br>

<div style="text-align:center">
    <br><br><input type="button" value="Close this window" onclick="self.close()">
</div>
</body>
</html>
