<%-- 
    Document   : message
    Created on : 11-Jul-2017, 12:21:39
    Author     : james chalmers Open University F6418079
    Project    : Alba Airways application M813-TMA02-ChooseSeat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Info: <%= request.getAttribute("msg")%></h3>
        <h3>Seat Number: <%= request.getAttribute("seatNumber")%></h3>
        <h3>Seat Type: <%= request.getAttribute("seatType")%></h3>
        <h3>Passenger Type: <%= request.getAttribute("passengerType")%></h3>
        <h3>Fare: <%= request.getAttribute("seatCost")%></h3>
        <table>
            <tr>
                <!-- COMMENT HTML WITH THIS -->
                <td><p>Back to previous page</p></td>
                <td><input type="button" value="back" onclick="location.href = document.referrer; return false;" style="width:75px" /></td>
            </tr>
            <td>
            <tr>
                <!-- COMMENT HTML WITH THIS -->
                <td><form name="Seats" action="SeatingServlet" method="POST"> <p>Seating Layout</p></td>
                <td><input type="submit" value="seats" name="submit" style="width:75px" /></td></form>
            </tr>
        </table>
    </body>
</html>
