/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.enums.PassengerEnum;
import model.enums.SeatEnum;
import model.enums.SeatTypeEnum;
import model.manager.SeatManager;
import model.entities.SeatPK;

/**
 * Alba Airways application M813-TMA02-ChooseSeat
 *
 * @author james chalmers Open University F6418079
 */
@WebServlet(name = "BookingServlet", urlPatterns = {"/BookingServlet"})
public class BookingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    SeatManager seatManager;

    private int seatNumber;
    private int aircraftId = 101;
    private SeatTypeEnum seatType;
    private String msg = "";
    private String url = "";
    private String returnVal;
    SeatPK seatPK;

    /*
     * Creates a new instance of CustomerManager
     */
    @Override
    public void init() throws ServletException {
        seatManager = new SeatManager();
        seatPK = new SeatPK();//?????????

    }



    public void chooseSeat(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {

        if (seatManager.checkNotFullyBooked()) {

            url = "/indexRevA.jsp";
            String passenger = request.getParameter("Passenger");
            boolean isSeatBooked = false;
            if (seatManager.getSeats()[seatNumber] == true) {
                msg = "This seat is already booked. Please choose another seat.";
                request.setAttribute("msg", msg);
                url = "/booked.jsp";
            } else {
                setSeatPK(seatNumber, aircraftId);
                seatManager.assignSeat(seatNumber, seatType);
                isSeatBooked = true;
                returnVal = "style=\"color:red\"";
                request.setAttribute("returnVal", returnVal);
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
                        request.setAttribute("seatNumber", seatNumber);
                        request.setAttribute("seatType", seatType);
                    }
                    request.setAttribute("msg", msg);
                    request.setAttribute("seats", Arrays.toString(seatManager.getSeats()));

                }

                url = "/message.jsp";
            }
            try (FileOutputStream fos = new FileOutputStream("C:\\Users\\user\\Documents\\seats.ser");
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(seatManager.getSeats());
                oos.flush();
                oos.close();
            } catch (IOException e) {
                e.getMessage();
            }
        } else {
            msg = "The Flight is fully booked. Please choose another Flight.";
            request.setAttribute("msg", msg);
            url = "/booked.jsp";
        }
    }

    public void setSeatPK(int seatNumber, int aircraftId) {
        seatPK.setSeatNumber(seatNumber);
        seatPK.setAircraftId(aircraftId);
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

            if (submit.equals("seat00F")) {
                seatNumber = 0;
                seatType = SeatTypeEnum.FIRSTCLASS;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat01F")) {
                seatNumber = 1;
                seatType = SeatTypeEnum.FIRSTCLASS;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat02F")) {
                seatNumber = 2;
                seatType = SeatTypeEnum.FIRSTCLASS;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat03F")) {
                seatNumber = 3;
                seatType = SeatTypeEnum.FIRSTCLASS;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat04F")) {
                seatNumber = 4;
                seatType = SeatTypeEnum.FIRSTCLASS;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat05F")) {
                seatNumber = 5;
                seatType = SeatTypeEnum.FIRSTCLASS;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat06F")) {
                seatNumber = 6;
                seatType = SeatTypeEnum.FIRSTCLASS;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat07F")) {
                seatNumber = 7;
                seatType = SeatTypeEnum.FIRSTCLASS;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat08F")) {
                seatNumber = 8;
                seatType = SeatTypeEnum.FIRSTCLASS;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat09F")) {
                seatNumber = 9;
                seatType = SeatTypeEnum.FIRSTCLASS;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat10F")) {
                seatNumber = 10;
                seatType = SeatTypeEnum.FIRSTCLASS;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat11F")) {
                seatNumber = 11;
                seatType = SeatTypeEnum.FIRSTCLASS;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat12E")) {
                seatNumber = 12;
                seatType = SeatTypeEnum.ECONOMY;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat13E")) {
                seatNumber = 13;
                seatType = SeatTypeEnum.ECONOMY;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat14E")) {
                seatNumber = 14;
                seatType = SeatTypeEnum.ECONOMY;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat15E")) {
                seatNumber = 15;
                seatType = SeatTypeEnum.ECONOMY;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat16E")) {
                seatNumber = 16;
                seatType = SeatTypeEnum.ECONOMY;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat17E")) {
                seatNumber = 17;
                seatType = SeatTypeEnum.ECONOMY;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat18E")) {
                seatNumber = 18;
                seatType = SeatTypeEnum.ECONOMY;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat19E")) {
                seatNumber = 19;
                seatType = SeatTypeEnum.ECONOMY;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat20E")) {
                seatNumber = 20;
                seatType = SeatTypeEnum.ECONOMY;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat21E")) {
                seatNumber = 21;
                seatType = SeatTypeEnum.ECONOMY;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat22E")) {
                seatNumber = 22;
                seatType = SeatTypeEnum.ECONOMY;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seat23E")) {
                seatNumber = 23;
                seatType = SeatTypeEnum.ECONOMY;
                //setSeatPK(seatNumber, aircraftId);
                chooseSeat(request, response);
            } else if (submit.equals("seats")) {
                url = "/indexRevA.jsp";
            }
        }
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
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
