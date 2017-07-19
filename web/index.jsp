<%-- 
    Document   : index
    Created on : 11-Jul-2017, 11:37:31
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
        <div>                
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
                        <td><form name="chooseSeat00" action="BookingServlet" method="GET">
                                <input type="submit" value="seat00F" name="submit" id="seat00F" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat00F" value=""/></form></td>
                        <td><form name="chooseSeat03" action="BookingServlet" method="GET">
                                <input type="submit" value="seat03F" name="submit" id="seat03F" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat03F" value=""/></form></td>
                        <td><form name="chooseSeat06" action="BookingServlet" method="GET">
                                <input type="submit" value="seat06F" name="submit" id="seat06F" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat06F" value=""/></form></td>
                        <td><form name="chooseSeat09" action="BookingServlet" method="GET">
                                <input type="submit" value="seat09F" name="submit" id="seat09F" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat09F" value=""/></form></td>
                        <td><form name="chooseSeat12" action="BookingServlet" method="GET">
                                <input type="submit" value="seat12E" name="submit" id="seat12E" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat12E" value=""/></form></td>
                        <td><form name="chooseSeat15" action="BookingServlet" method="GET">
                                <input type="submit" value="seat15E" name="submit" id="seat15E" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat15E" value=""/></form></td>
                        <td><form name="chooseSeat18" action="BookingServlet" method="GET">
                                <input type="submit" value="seat18E" name="submit" id="seat18E" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat18E" value=""/></form></td>
                        <td><form name="chooseSeat21" action="BookingServlet" method="GET">
                                <input type="submit" value="seat21E" name="submit" id="seat21E" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat21E" value=""/></form></td>
                    </tr>
                    <tr>
                        <td><form name="chooseSeat02" action="BookingServlet" method="GET">
                                <input type="submit" value="seat01F" name="submit" id="seat01F" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat01F" value=""/></form></td>
                        <td><form name="chooseSeat05" action="BookingServlet" method="GET">
                                <input type="submit" value="seat04F" name="submit" id="seat04F" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat04F" value=""/></form></td>
                        <td><form name="chooseSeat08" action="BookingServlet" method="GET">
                                <input type="submit" value="seat07F" name="submit" id="seat07F" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat07F" value=""/></form></td>
                        <td><form name="chooseSeat11" action="BookingServlet" method="GET">
                                <input type="submit" value="seat10F" name="submit" id="seat10F" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat10F" value=""/></form></td>
                        <td><form name="chooseSeat14" action="BookingServlet" method="GET">
                                <input type="submit" value="seat13E" name="submit" id="seat13E" style="<%=request.getAttribute("returnVal")%>" />
                                <input type="hidden" name="" id="seat13E" value=""/></form></td>
                        <td><form name="chooseSeat17" action="BookingServlet" method="GET">
                                <input type="submit" value="seat16E" name="submit" id="seat16E" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat16E" value=""/></form></td>
                        <td><form name="chooseSeat20" action="BookingServlet" method="GET">
                                <input type="submit" value="seat19E" name="submit" id="seat19E" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat19E" value=""/></form></td>
                        <td><form name="chooseSeat23" action="BookingServlet" method="GET">
                                <input type="submit" value="seat22E" name="submit" id="seat22E" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat22E" value=""/></form></td>
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
                        <td><form name="chooseSeat03" action="BookingServlet" method="GET">
                                <input type="submit" value="seat02F" name="submit" id="seat02F" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat02F" value=""/></form></td>
                        <td><form name="chooseSeat06" action="BookingServlet" method="GET">
                                <input type="submit" value="seat05F" name="submit" id="seat05F" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat05F" value=""/></form></td>
                        <td><form name="chooseSeat09" action="BookingServlet" method="GET">
                                <input type="submit" value="seat08F" name="submit" id="seat08F" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat08F" value=""/></form></td>
                        <td><form name="chooseSeat12" action="BookingServlet" method="GET">
                                <input type="submit" value="seat11F" name="submit" id="seat11F" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat11F" value=""/></form></td>
                        <td><form name="chooseSeat15" action="BookingServlet" method="GET">
                                <input type="submit" value="seat14E" name="submit" id="seat14E" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat14E" value=""/></form></td>
                        <td><form name="chooseSeat18" action="BookingServlet" method="GET">
                                <input type="submit" value="seat17E" name="submit" id="seat17E" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat17E" value=""/></form></td>
                        <td><form name="chooseSeat21" action="BookingServlet" method="GET">
                                <input type="submit" value="seat20E" name="submit" id="seat20E" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat20E" value=""/></form></td>
                        <td><form name="chooseSeat24" action="BookingServlet" method="GET">
                                <input type="submit" value="seat23E" name="submit" id="seat23E" style="<%=request.getAttribute("returnVal")%>"/>
                                <input type="hidden" name="" id="seat23E" value=""/></form></td>
                    </tr>
                <script type="text/javascript">
                    if (seatIsBooked)
                    {
                        e = document.getElementById(seatNumber.valueOf());
                        if (null !== e)
                        {
                            e.style.color = "Red";
                        }
                    }
                </script>
                </tbody>
            </table><br />
        </div>
    </body>
</html>
