<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
    <title>Add Customer</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<h2>Add New Customer:</h2>
<form:form method="POST" action="/addCustomer" modelAttribute="customer">

    <table>
        <tr>
            <td><form:label path="lastName">Last Name</form:label></td>
            <td><form:input path="lastName"/>(Ex. Doe)</td>
        </tr>
        <tr>
            <td><form:label path="firstName">First Name</form:label></td>
            <td><form:input path="firstName"/>(Ex. John)</td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"/>(Ex. someone@someone.com)</td>
        </tr>
        <tr>
            <td><form:label path="address">Address</form:label></td>
            <td><form:input path="address"/>(Ex. 1234 Broadway St.)</td>
        </tr>
        <tr>
            <td><form:label path="city">City</form:label></td>
            <td><form:input path="city"/>(Ex. San Antonio)</td>
        </tr>
        <tr>
            <td><form:label path="state">State</form:label></td>
            <td><form:input path="state"/>(Ex. TX)</td>
        </tr>
        <tr>
            <td><form:label path="zip">Zip Code</form:label></td>
            <td><form:input path="zip"/>(Ex. 78204)</td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
                <input type="reset" value="Reset"/>
            </td>
        </tr>
    </table>

</form:form>
<form action="http://localhost:8080/assignment2">
    <input type="submit" value="HOME">
</form>

<div style="text-align:center">
    <br><br><input type="button" value="Close this window" onclick="self.close()">
</div>

</body>
</html>
