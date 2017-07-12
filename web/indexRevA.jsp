<%-- 
    Document   : index
    Created on : 11-Jul-2017, 11:37:31
    Author     : james chalmers Open University F6418079
    Alba Airways application M813-TMA02-ChooseSeat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div> 
            <form name="chooseSeat" action="BookingServlet" method="GET">
                <table cellpadding="0" cellspacing="0" border="0" id="table" class="sortable">
                    <thead>
                        <tr>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <input type="submit" value="seat00F" name="submit" id="seat00F" onclick="seatIsBooked"/></td>
                            <td>
                                <input type="submit" value="seat03F" name="submit" id="seat03F"/></td>
                            <td>
                                <input type="submit" value="seat06F" name="submit" id="seat06F"/></td>
                            <td>
                                <input type="submit" value="seat09F" name="submit" id="seat09F"/></td>
                            <td>
                                <input type="submit" value="seat12E" name="submit" id="seat12E"/></td>
                            <td>
                                <input type="submit" value="seat15E" name="submit" id="seat15E"/></td>
                            <td>
                                <input type="submit" value="seat18E" name="submit" id="seat18E"/></td>
                            <td>
                                <input type="submit" value="seat21E" name="submit" id="seat21E"/></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" value="seat01F" name="submit" id="seat01F"/></td>
                            <td>
                                <input type="submit" value="seat04F" name="submit" id="seat04F"/></td>
                            <td>
                                <input type="submit" value="seat07F" name="submit" id="seat07F"/></td>
                            <td>
                                <input type="submit" value="seat10F" name="submit" id="seat10F"/></td>
                            <td>
                                <input type="submit" value="seat13E" name="submit" id="seat13E"/></td>
                            <td>
                                <input type="submit" value="seat16E" name="submit" id="seat16E"/></td>
                            <td>
                                <input type="submit" value="seat19E" name="submit" id="seat19E"/></td>
                            <td>
                                <input type="submit" value="seat22E" name="submit" id="seat22E"/></td>
                        </tr>
                        <tr>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                            <th><h3></h3></th>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" value="seat02F" name="submit" id="seat02F"/></td>
                            <td>
                                <input type="submit" value="seat05F" name="submit" id="seat05F"/></td>
                            <td>
                                <input type="submit" value="seat08F" name="submit" id="seat08F"/></td>
                            <td>
                                <input type="submit" value="seat11F" name="submit" id="seat11F"/></td>
                            <td>
                                <input type="submit" value="seat14E" name="submit" id="seat14E"/></td>
                            <td>
                                <input type="submit" value="seat17E" name="submit" id="seat17E"/></td>
                            <td>
                                <input type="submit" value="seat20E" name="submit" id="seat20E"/></td>
                            <td>
                                <input type="submit" value="seat23E" name="submit" id="seat23E"/></td>
                        </tr>
                    </tbody>
                </table><br />
                <input type="radio" value="ADULT" name="Passenger" checked="checked"/><p>Adult</p>
                <input type="radio" value="CHILD" name="Passenger" /><p>Child</p>
                <input type="radio" value="INFANT" name="Passenger" /><p>Infant</p>
            </form>
        </div>
    </body>
</html>
