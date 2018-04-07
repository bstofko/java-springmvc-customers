<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <title>Generate Email</title>
</head>
<body>

<h2>Send Email Report:</h2>
This action will send an email of all customers in the database, separated in two sections by TX customers and
non-TX customers.<br><br>
<form:form method="POST" action="/sendEmail" modelAttribute="email">

  <table>
    <tr>
      <td><form:label path="recipient">Recipient</form:label></td>
      <td><form:input path="recipient"/>(Ex. someone@someone.com)</td>
    </tr>
    <tr>
      <td><form:label path="sender">Sender</form:label></td>
      <td><form:input path="sender"/>(Ex. someone@someone.com)</td>
    </tr>
    <tr>
      <td><form:label path="subject">Subject</form:label></td>
      <td><form:input path="subject"/>(Ex. This is an email subject.)</td>
    </tr>
    <tr>
      <td><form:label path="smtpHost">SMTP Host</form:label></td>
      <td><form:input path="smtpHost"/>(Ex. exchange.microsoft.com:25)</td>
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
