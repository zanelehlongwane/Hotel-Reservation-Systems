/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package reservation.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import reservation.dao.ReservationDao;
import reservation.dao.ReservationDaoImpl;
import reservation.dining.dao.DiningOptionDao;
import reservation.dining.dao.DiningOptionDaoImpl;
import reservation.dining.model.DiningOption;
import reservation.model.Reservation;
import reservation.model.reservationStatus;
import reservation.service.ReservationService;
import reservation.service.ReservationServiceImpl;
import user.model.User;

/**
 *
 * @author user
 */
@WebServlet(name = "ReservationByDate", urlPatterns = {"/ReservationByDate"})
public class ReservationByDate extends HttpServlet {

    private final ReservationDao reservationDao = new ReservationDaoImpl();
    private final DiningOptionDao diningOptionDao = new DiningOptionDaoImpl();
    private final ReservationService reservationService = new ReservationServiceImpl(reservationDao, diningOptionDao);
    private final User users = new User();
    
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userIdStr = request.getParameter("userId");
        String checkInDateStr = request.getParameter("checkInDate");
        String checkOutDateStr = request.getParameter("checkOutDate");
        
        

            String act = request.getParameter("submit");
            if (act != null) {
                switch (act) {
                    case "Search":
                    {
                        try {
                            handleSearch(request, response, userIdStr, checkInDateStr, checkOutDateStr);
                        } catch (SQLException ex) {
                            Logger.getLogger(ReservationByDate.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;

         
                   
                    case "upComing":
                    {
                        try {
                            handleUpcoming(request, response, users);
                        } catch (SQLException ex) {
                            Logger.getLogger(ReservationByDate.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;

                    case "History":
                    {
                        try {
                            handleHistory(request, response, users);
                        } catch (SQLException ex) {
                            Logger.getLogger(ReservationByDate.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;

                    
                    case "View all Reservations":
                    {
                        try {
                            handleViewAllReservations(request, response);
                        } catch (SQLException ex) {
                            Logger.getLogger(ReservationByDate.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;

                }
            }

    }

    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userIdStr = request.getParameter("userId");
        String checkInDateStr = request.getParameter("checkInDate");
        String checkOutDateStr = request.getParameter("checkOutDate");
        String reservationIdStr = request.getParameter("reservationId");
        String hotelIdStr = request.getParameter("hotelId");
        String roomIdStr = request.getParameter("roomId");
        String diningOptionIdStr = request.getParameter("diningOptionId");
        String reservationStatusStr = request.getParameter("reservationStatus");

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute("hotelId", hotelIdStr);
            
        }

        try {
            int userId = userIdStr != null && !userIdStr.isEmpty() ? Integer.parseInt(userIdStr) : 0;
            int resId = reservationIdStr != null && !reservationIdStr.isEmpty() ? Integer.parseInt(reservationIdStr) : 0;
            int hotelId = hotelIdStr != null && !hotelIdStr.isEmpty() ? Integer.parseInt(hotelIdStr) : 0;
            int roomId = roomIdStr != null && !roomIdStr.isEmpty() ? Integer.parseInt(roomIdStr) : 0;
            int dine = diningOptionIdStr != null && !diningOptionIdStr.isEmpty() ? Integer.parseInt(diningOptionIdStr) : 0;
            LocalDate checkInDate = checkInDateStr != null && !checkInDateStr.isEmpty() ? LocalDate.parse(checkInDateStr) : null;
            LocalDate checkOutDate = checkOutDateStr != null && !checkOutDateStr.isEmpty() ? LocalDate.parse(checkOutDateStr) : null;
            reservationStatus status = reservationStatusStr != null && !reservationStatusStr.isEmpty() ? reservationStatus.valueOf(reservationStatusStr) : null;

            String action = request.getParameter("submit");
            if (action != null) {
                switch (action) {
                    case "Search":
                        handleSearch(request, response, userIdStr, checkInDateStr, checkOutDateStr);
                        break;
                    case "View DiningOptions":
                        handleViewDiningOptions(request, response);
                        break;
                    case "Create":
                        handleCreate(request, response, userId, hotelId, roomId, checkInDate, checkOutDate, status, dine);
                        break;
                    case "upComing":
                        handleUpcoming(request, response, users);
                        break;
                    case "History":
                        handleHistory(request, response, users);
                        break;
                    case "Cancel":
                        handleCancel(request, response, userId);
                        break;
                    case "View all Reservations":
                        handleViewAllReservations(request, response);
                        break;
                    case "Edit":
                        handleEdit(request, response, resId, userId, roomId, checkInDate, checkOutDate, status, dine);
                        break;
                    case "Go back":
                        request.getRequestDispatcher("displayRoomsAvailable.jsp").forward(request, response);
                        break;
                    default:
                        throw new ServletException("Unknown action: " + action);
                }
            } else {
                throw new ServletException("Submit parameter is missing");
            }
        } catch (NumberFormatException | SQLException e) {
            Logger.getLogger(ReservationByDate.class.getName()).log(Level.SEVERE, null, e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input: " + e.getMessage());
        }
    }

    private void handleSearch(HttpServletRequest request, HttpServletResponse response, String userIdStr, String checkInDateStr, String checkOutDateStr) throws ServletException, IOException, SQLException {
        List<Reservation> reservations = null;
        int userId = 0;

        if (userIdStr != null && !userIdStr.isEmpty()) {
            userId = Integer.parseInt(userIdStr);
            reservations = reservationService.getReservationsByUserId(userId);
        } else if (checkInDateStr != null && !checkInDateStr.isEmpty() && checkOutDateStr != null && !checkOutDateStr.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate checkInDate = LocalDate.parse(checkInDateStr,formatter);
            LocalDate checkOutDate = LocalDate.parse(checkOutDateStr,formatter);
            reservations = reservationService.getReservationByDate(checkInDate, checkOutDate);
        }

        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("getByDateOrID.jsp").forward(request, response);
    }

    private void handleViewDiningOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<DiningOption> dining = reservationService.getAllDiningOptions();
        request.setAttribute("dining", dining);
        request.getRequestDispatcher("diningOption.jsp").forward(request, response);
    }

    private void handleCreate(HttpServletRequest request, HttpServletResponse response, int userId, int hotelId, int roomId, LocalDate checkInDate, LocalDate checkOutDate, reservationStatus status, int dine) throws ServletException, IOException, SQLException {
        Reservation reservation = new Reservation(userId, hotelId, roomId, checkInDate, checkOutDate, status, dine);

        if (reservationService.createReservation(reservation)) {
            long daysBetween = ChronoUnit.DAYS.between(checkInDate,checkOutDate);
            double price = daysBetween*250.00+200;
            request.setAttribute("message", "You have successfully reserved a room, Please continue with payment of  R"+ price);
            request.getRequestDispatcher("paymentForm.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Couldn't reserve");
            request.getRequestDispatcher("createReservation.jsp").forward(request, response);
        }
    }

    private void handleUpcoming(HttpServletRequest request, HttpServletResponse response, User users) throws ServletException, IOException, SQLException {
        List<Reservation> upComing;
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        System.out.println("user id"+ user.getId());
        if (users.getId() == 45) {
            upComing = reservationService.getUpcomingBooking();
            request.setAttribute("upComing", upComing);
            request.getRequestDispatcher("upComingBooking.jsp").forward(request, response);
        } else {
            //int userId = Integer.parseInt(request.getParameter(user.getId()));
            upComing = reservationService.trackReservation(user.getId());
            request.setAttribute("upComing", upComing);
            request.getRequestDispatcher("getByDateOrID.jsp").forward(request, response);
        }
    }

    private void handleHistory(HttpServletRequest request, HttpServletResponse response, User users) throws ServletException, IOException, SQLException {
        List<Reservation> history;
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        System.out.println("user id"+ user.getId());
        if (user.getId() == 45) {
            history = reservationService.getHistory();
            request.setAttribute("history", history);
            request.getRequestDispatcher("history.jsp").forward(request, response);
        } else {
            //int userId = Integer.parseInt(request.getParameter("userId"));
            history = reservationService.getHistoryByUser(user.getId());
            request.setAttribute("history", history);
            request.getRequestDispatcher("getByDateOrID.jsp").forward(request, response);
        }
    }

    private void handleCancel(HttpServletRequest request, HttpServletResponse response, int userId) throws ServletException, IOException, SQLException {
        String message;
        
        if (reservationService.cancelBooking(userId)) {
            message = "Reservation canceled successfully.";
        } else {
            message = "Failed to cancel reservation.";
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("cancelReservation.jsp").forward(request, response);
    }

    private void handleViewAllReservations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Reservation> allReservations = reservationService.allRes();
        request.setAttribute("allReservations", allReservations);
        request.getRequestDispatcher("allReservations.jsp").forward(request, response);
    }

    private void handleEdit(HttpServletRequest request, HttpServletResponse response, int resId, int userId, int roomId, LocalDate checkInDate, LocalDate checkOutDate, reservationStatus status, int dine) throws ServletException, IOException, SQLException {
        Reservation reservation = new Reservation(resId, userId, roomId, checkInDate, checkOutDate, status, dine);
        HttpSession session = request.getSession(false);
        request.setAttribute("reservation", reservation);
        String message;
        
        if (reservationService.EditBooking(reservation)) {
            message = "Reservation updated successfully.";
        } else {
            message = "Failed to update reservation.";
        }
        request.setAttribute("message", message);
        request.setAttribute("reservation", reservation);
        request.getRequestDispatcher("editReservation.jsp").forward(request, response);
    }

}
