/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Booking;
import entities.Flight;
import entities.Seat;
import model.enums.PassengerEnum;
import model.enums.SeatEnum;
import model.enums.SeatTypeEnum;
import database.SeatDB;
import entities.SeatPK;
import java.sql.SQLException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Alba Airways application M813-TMA02-ChooseSeat
 *
 * @author james chalmers Open University F6418079
 */
@WebServlet(name = "SeatingServlet", urlPatterns = {"/SeatingServlet"})
public class SeatingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    SeatDB seatDB;
    SeatTypeEnum seatType;
//    SeatEnum seatEnum;

    SeatPK seatPK = new SeatPK();

    @Override
    public void init() throws ServletException {
        seatDB = new SeatDB();
    }

    public String chooseSeat(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException, SQLException {
        String msg = "";
        String url = "";
        int firstClassCounter = 0;

        int seatNumber = (int) request.getAttribute("seatNumber");
        String passenger = request.getParameter("Passenger");

        seatPK = new SeatPK();
        seatPK.setFlightId(3);
        seatPK.setSeatNo(seatNumber);
        /* For Debugging: */
        seatDB.getSeatingLayout(seatPK.getFlightId());
        if (firstClassCounter < 12) {

            if (seatDB.getSeatingLayout(seatPK.getFlightId())[seatNumber] == false) {
                seatDB.getSeatingLayout(seatPK.getFlightId())[seatNumber] = true;
                Seat seat = assignSeat(seatNumber);
                request.setAttribute("seat", seat);
                firstClassCounter++;

                msg = "Your Seat Booking:";

                for (SeatEnum seatEnum : SeatEnum.values()) {
                    if (seatNumber == seatEnum.ordinal()) {
                        if (passenger.equals(PassengerEnum.ADULT.toString())) {
                            double seatCost = SeatEnum.valueOf(seatEnum.toString()).getAdultFare();
                            request.setAttribute("seatCost", seatCost);
                        } else if (passenger.equals(PassengerEnum.CHILD.toString())) {
                            double seatCost = SeatEnum.valueOf(seatEnum.toString()).getChildFare();
                            request.setAttribute("seatCost", seatCost);
                        } else if (passenger.equals(PassengerEnum.INFANT.toString())) {
                            double seatCost = SeatEnum.valueOf(seatEnum.toString()).getInfantFare();
                            request.setAttribute("seatCost", seatCost);
                        }
                        request.setAttribute("passengerType", passenger);
                        request.setAttribute("seatNumber", seatNumber + 1);
                        request.setAttribute("seatType", seatType);
                    }
                    request.setAttribute("msg", msg);
                    request.setAttribute("seats", Arrays.toString(seatDB.getSeats()));

                }
                url = "/message.jsp";

            } else if (seatDB.getSeatingLayout(seatPK.getFlightId())[seatNumber] == true) {
                msg = "This seat is already booked. Please choose another seat.";
                request.setAttribute("msg", msg);
                url = "/booked.jsp";
            } else if (seatDB.selectSeatById(seatPK).equals(request.getAttribute("seat"))) {// NOT NEEDED??
                msg = "This seat is already booked. Please choose another seat.";
                request.setAttribute("msg", msg);
                url = "/booked.jsp";
            }

        } else {
            msg = "All the First Class seats have been used up.";
            request.setAttribute("msg", msg);
            url = "/booked.jsp";//?????
        }

        return url;
    }

    public Seat assignSeat(int seatNumber) throws ClassNotFoundException, SQLException {
        Seat seat = new Seat();

        int id = 2;
        Booking bookingId = new Booking(id);
        //Flight flight = seat.getFlight();
        seatPK.setFlightId(3);
        seatPK.setSeatNo(seatNumber);
        seat.setBookingId(bookingId);

        seatNumber = seatPK.getSeatNo();
        seatDB.getSeatingLayout(seatPK.getFlightId())[seatNumber] = true;
        Double seatPrice = null;
        SeatDB.addSeat(seatPK, seatPrice, bookingId);
        return seat;
    }

    public String allocateEconomySeat(HttpServletRequest request, HttpServletResponse response, String seatType) throws ServletException, IOException, ClassNotFoundException, SQLException {
        String passenger = request.getParameter("Passenger");
        int economyCounter = 0;
        String msg = "";
        String url = "";

        int seatNumber;

        if (economyCounter < 12) {

            //If there are vacant seats, randomly select one etc...
            Random random = new Random();
            int economySeat = random.nextInt(23 - 12 + 1) + 12;
            seatNumber = economySeat;
            request.setAttribute("seatNumber", seatNumber + 1);
            seatDB.getSeatingLayout(seatPK.getFlightId())[seatNumber] = true;
            Double seatPrice = null;
            Seat seat = assignSeat(seatNumber);

            if (seatDB.getSeatingLayout(seatPK.getFlightId())[seatNumber] == false) {
                seatDB.getSeatingLayout(seatPK.getFlightId())[seatNumber] = true;
                economyCounter++;
                request.setAttribute("seat", seat);
                int id = 2;
                Booking bookingId = new Booking(id);
                //SeatPK seatPK = new SeatPK();
                Flight flight = seat.getFlight();
                seatPK.setFlightId(3);
                seatPK.setSeatNo(seatNumber);
                seat.setBookingId(bookingId);
                msg = "Your Economy Class Seat Booking:";

            }
            for (SeatEnum seatEnum : SeatEnum.values()) {
                if (seatNumber == seatEnum.ordinal()) {
                    if (passenger.equals(PassengerEnum.ADULT.toString())) {
                        double seatCost = SeatEnum.valueOf(seatEnum.toString()).getAdultFare();
                        request.setAttribute("seatCost", seatCost);
                    } else if (passenger.equals(PassengerEnum.CHILD.toString())) {
                        double seatCost = SeatEnum.valueOf(seatEnum.toString()).getChildFare();
                        request.setAttribute("seatCost", seatCost);
                    } else if (passenger.equals(PassengerEnum.INFANT.toString())) {
                        double seatCost = SeatEnum.valueOf(seatEnum.toString()).getInfantFare();
                        request.setAttribute("seatCost", seatCost);
                    }
                    request.setAttribute("passengerType", passenger);
                    request.setAttribute("seatNumber", seatNumber + 1);
                    request.setAttribute("seatType", seatType);
                }

                request.setAttribute("msg", msg);
            }
            url = "/message.jsp";
        } else {
            msg = "All the Economy seats have been used up.";
            request.setAttribute("msg", msg);
            url = "/booked.jsp";

        }
        return url;

    }

    public String showSeats(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        boolean[] seatingLayout = seatDB.getSeatingLayout(seatPK.getFlightId());
        String url = "/indexRevB.jsp";
        return url;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        int seatNumber;
        request.setAttribute("seats", Arrays.toString(seatDB.getSeatingLayout(seatPK.getFlightId())));
        String url = "";
        String submit = request.getParameter("submit");
        if (submit != null && submit.length() > 0) {

            switch (submit) {
                case "seat01F":
                    seatNumber = 0;
                    request.setAttribute("seatNumber", seatNumber);
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    url = chooseSeat(request, response);
                    break;
                case "seat02F":
                    seatNumber = 1;
                    request.setAttribute("seatNumber", seatNumber);
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    url = chooseSeat(request, response);
                    break;
                case "seat03F":
                    seatNumber = 2;
                    request.setAttribute("seatNumber", seatNumber);
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    url = chooseSeat(request, response);
                    break;
                case "seat04F":
                    seatNumber = 3;
                    request.setAttribute("seatNumber", seatNumber);
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    url = chooseSeat(request, response);
                    break;
                case "seat05F":
                    seatNumber = 4;
                    request.setAttribute("seatNumber", seatNumber);
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    url = chooseSeat(request, response);
                    break;
                case "seat06F":
                    seatNumber = 5;
                    request.setAttribute("seatNumber", seatNumber);
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    url = chooseSeat(request, response);
                    break;
                case "seat07F":
                    seatNumber = 6;
                    request.setAttribute("seatNumber", seatNumber);
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    url = chooseSeat(request, response);
                    break;
                case "seat08F":
                    seatNumber = 7;
                    request.setAttribute("seatNumber", seatNumber);
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    url = chooseSeat(request, response);
                    break;
                case "seat09F":
                    seatNumber = 8;
                    request.setAttribute("seatNumber", seatNumber);
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    url = chooseSeat(request, response);
                    break;
                case "seat10F":
                    seatNumber = 9;
                    request.setAttribute("seatNumber", seatNumber);
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    url = chooseSeat(request, response);
                    break;
                case "seat11F":
                    seatNumber = 10;
                    request.setAttribute("seatNumber", seatNumber);
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    url = chooseSeat(request, response);
                    break;
                case "seat12F":
                    seatNumber = 11;
                    request.setAttribute("seatNumber", seatNumber);
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    url = chooseSeat(request, response);
                    break;
                case "seat13E":
//                    seatNumber = 12;
//                    seatType = SeatTypeEnum.ECONOMY;
                    url = "/indexRevB.jsp";
                    break;
                case "seat14E":
//                    seatNumber = 13;
//                    seatType = SeatTypeEnum.ECONOMY;
                    url = "/indexRevB.jsp";
                    break;
                case "seat15E":
//                    seatNumber = 14;
//                    seatType = SeatTypeEnum.ECONOMY;
                    url = "/indexRevB.jsp";
                    break;
                case "seat16E":
//                    seatNumber = 15;
//                    seatType = SeatTypeEnum.ECONOMY;
                    url = "/indexRevB.jsp";
                    break;
                case "seat17E":
//                    seatNumber = 16;
//                    seatType = SeatTypeEnum.ECONOMY;
                    url = "/indexRevB.jsp";
                    break;
                case "seat18E":
//                    seatNumber = 17;
//                    seatType = SeatTypeEnum.ECONOMY;
                    url = "/indexRevB.jsp";
                    break;
                case "seat19E":
//                    seatNumber = 18;
//                    seatType = SeatTypeEnum.ECONOMY;
                    url = "/indexRevB.jsp";
                    break;
                case "seat20E":
//                    seatNumber = 19;
//                    seatType = SeatTypeEnum.ECONOMY;
                    url = "/indexRevB.jsp";
                    break;
                case "seat21E":
//                    seatNumber = 20;
//                    seatType = SeatTypeEnum.ECONOMY;
                    url = "/indexRevB.jsp";
                    break;
                case "seat22E":
//                    seatNumber = 21;
//                    seatType = SeatTypeEnum.ECONOMY;
                    url = "/indexRevB.jsp";
                    break;
                case "seat23E":
//                    seatNumber = 22;
//                    seatType = SeatTypeEnum.ECONOMY;
                    url = "/indexRevB.jsp";
                    break;
                case "seat24E":
//                    seatNumber = 23;
//                    seatType = SeatTypeEnum.ECONOMY;
                    url = "/indexRevB.jsp";
                    break;
                case "seats":
                    url = showSeats(request, response);
                    break;
                case "Economy":
                    seatType = SeatTypeEnum.ECONOMY;
                    url = allocateEconomySeat(request, response, seatType.toString());
                    break;
                default:
                    break;
            }
//            return;
        }
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("application/json;charset=utf-8");

            JSONObject json = new JSONObject();
            JSONArray array = new JSONArray();
            JSONObject member = new JSONObject();

            //member.put("arrayData", seatDB.getSeats());
            member.put("arrayData", seatDB.getSeatingLayout(seatPK.getFlightId()));
            array.add(member);

            json.put("jsonArray", array);

            PrintWriter pw = response.getWriter();
            pw.print(json.toString());
        } catch (IOException e) {
            e.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(SeatingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SeatingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
