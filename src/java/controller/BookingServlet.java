/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.SeatDB;
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
import model.manager.SeatManager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Alba Airways application M813-TMA02-ChooseSeat
 *
 * @author james chalmers Open University F6418079
 */
@WebServlet(name = "BookingServlet", urlPatterns = {"/BookingServlet"})
public class BookingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    SeatManager seatManager;
    SeatTypeEnum seatType;
    
    private int seatNumber;
    
    private String msg = "";
    private String url = "";
    private int economyCounter;
    private int firstClassCounter;

    /*
     * Creates a new instance of SeatManager
     */
    @Override
    public void init() throws ServletException {
        seatManager = new SeatManager();
    }

    public void chooseSeat(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {

//        if (seatManager.areAllSeatsBooked(seatManager.getSeats())) {
        String passenger = request.getParameter("Passenger");
        if (seatManager.getSeats()[seatNumber] == true) {
//        if (seatManager.getAllSeatBookings()[seatNumber].equals(true)) {   
            msg = "This seat is already booked. Please choose another seat.";
            request.setAttribute("msg", msg);
            url = "/booked.jsp";
        } else {

            if (seatType == SeatTypeEnum.FIRSTCLASS) {

                if (firstClassCounter < 12) {

                    this.assignSeat(seatNumber, seatType.toString());
                    firstClassCounter++;
                } else {
                    msg = "All the Economy seats have been used up.";
                    request.setAttribute("msg", msg);
                    url = "/booked.jsp";
                }
            }

            msg = "Your Seat Booking.";

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
                request.setAttribute("seats", Arrays.toString(seatManager.getSeats()));

            }

            url = "/message.jsp";
        }
//        } else {
//            msg = "The Flight is fully booked. Please choose another Flight.";
//            request.setAttribute("msg", msg);
//            url = "/booked.jsp";
//        }
        //url = "/indexRevB.jsp";
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    public boolean[] assignSeat(int seatNumber, String seatType) throws ClassNotFoundException {
        Seat seat = new Seat();
        Booking booking = seat.getBooking();
        Flight flight = seat.getFlight();
        seatManager.getSeats()[seatNumber] = true;
        SeatDB.addSeat(seatNumber, seatType, booking, flight);
        return seatManager.getSeats();
    }

    public boolean[] allocateEconomySeat(HttpServletRequest request, HttpServletResponse response, String seatType) throws ServletException, IOException, ClassNotFoundException {
        String passenger = request.getParameter("Passenger");
        Seat seat = new Seat();
        Booking booking = seat.getBooking();
        Flight flight = seat.getFlight();
        
        if (economyCounter < 12) {
//                    //If there are vacant seats, randomly select one etc...
            Random random = new Random();
            int economySeat = random.nextInt(23 - 12 + 1) + 12;
            seatNumber = economySeat;
//                if (seatManager.getSeats()[seatNumber] == false) {
//                    seatManager.getSeats()[seatNumber] = true;
//                    economyCounter++;
//                    if (economyCounter >= 12) {
//                        break;
//                    }
//                }
            if (seatManager.getSeats()[seatNumber] == false) {
                seatManager.getSeats()[seatNumber] = true;
                economyCounter++;
                SeatDB.addSeat(seatNumber, seatType, booking, flight);
                msg = "Your Economy Class Seat Booking.";
                request.setAttribute("msg", msg);
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
                    url = "/message.jsp";

                }
            }

        } else {
            msg = "All the Economy seats have been used up.";
            request.setAttribute("msg", msg);
            url = "/booked.jsp";

        }
        //url = "/indexRevB.jsp";
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        return seatManager.getSeats();

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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {

        request.setAttribute("seats", Arrays.toString(seatManager.getSeats()));

        String submit = request.getParameter("submit");
        if (submit != null && submit.length() > 0) {

            switch (submit) {
                case "seat01F":
                    seatNumber = 0;
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    this.chooseSeat(request, response);
                    break;
                case "seat02F":
                    seatNumber = 1;
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    this.chooseSeat(request, response);
                    break;
                case "seat03F":
                    seatNumber = 2;
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    this.chooseSeat(request, response);
                    break;
                case "seat04F":
                    seatNumber = 3;
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    this.chooseSeat(request, response);
                    break;
                case "seat05F":
                    seatNumber = 4;
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    this.chooseSeat(request, response);
                    break;
                case "seat06F":
                    seatNumber = 5;
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    this.chooseSeat(request, response);
                    break;
                case "seat07F":
                    seatNumber = 6;
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    this.chooseSeat(request, response);
                    break;
                case "seat08F":
                    seatNumber = 7;
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    this.chooseSeat(request, response);
                    break;
                case "seat09F":
                    seatNumber = 8;
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    this.chooseSeat(request, response);
                    break;
                case "seat10F":
                    seatNumber = 9;
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    this.chooseSeat(request, response);
                    break;
                case "seat11F":
                    seatNumber = 10;
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    this.chooseSeat(request, response);
                    break;
                case "seat12F":
                    seatNumber = 11;
                    seatType = SeatTypeEnum.FIRSTCLASS;
                    chooseSeat(request, response);
                    break;
//                case "seat13E":
//                    seatNumber = 12;
//                    seatType = SeatTypeEnum.ECONOMY;
//                    this.chooseSeat(request, response);
//                    break;
//                case "seat14E":
//                    seatNumber = 13;
//                    seatType = SeatTypeEnum.ECONOMY;
//                    this.chooseSeat(request, response);
//                    break;
//                case "seat15E":
//                    seatNumber = 14;
//                    seatType = SeatTypeEnum.ECONOMY;
//                    this.chooseSeat(request, response);
//                    break;
//                case "seat16E":
//                    seatNumber = 15;
//                    seatType = SeatTypeEnum.ECONOMY;
//                    this.chooseSeat(request, response);
//                    break;
//                case "seat17E":
//                    seatNumber = 16;
//                    seatType = SeatTypeEnum.ECONOMY;
//                    this.chooseSeat(request, response);
//                    break;
//                case "seat18E":
//                    seatNumber = 17;
//                    seatType = SeatTypeEnum.ECONOMY;
//                    this.chooseSeat(request, response);
//                    break;
//                case "seat19E":
//                    seatNumber = 18;
//                    seatType = SeatTypeEnum.ECONOMY;
//                    this.chooseSeat(request, response);
//                    break;
//                case "seat20E":
//                    seatNumber = 19;
//                    seatType = SeatTypeEnum.ECONOMY;
//                    this.chooseSeat(request, response);
//                    break;
//                case "seat21E":
//                    seatNumber = 20;
//                    seatType = SeatTypeEnum.ECONOMY;
//                    this.chooseSeat(request, response);
//                    break;
//                case "seat22E":
//                    seatNumber = 21;
//                    seatType = SeatTypeEnum.ECONOMY;
//                    this.chooseSeat(request, response);
//                    break;
//                case "seat23E":
//                    seatNumber = 22;
//                    seatType = SeatTypeEnum.ECONOMY;
//                    this.chooseSeat(request, response);
//                    break;
//                case "seat24E":
//                    seatNumber = 23;
//                    seatType = SeatTypeEnum.ECONOMY;
//                    this.chooseSeat(request, response);
//                    break;
                case "seats":
                    url = "/indexRevB.jsp";
                    break;
                case "Economy":
                    seatType = SeatTypeEnum.ECONOMY;
                    this.allocateEconomySeat(request, response, seatType.toString());
                    url = "/indexRevB.jsp";
                    break;
                default:
                    break;
            }
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

            member.put("arrayData", seatManager.getSeats());
            array.add(member);

            json.put("jsonArray", array);

            PrintWriter pw = response.getWriter();
            pw.print(json.toString());
        } catch (IOException e) {
            e.getMessage();
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
