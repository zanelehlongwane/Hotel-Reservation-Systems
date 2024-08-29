/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import reservation.model.Reservation;
import room.model.Room;

/**
 *
 * @author user
 */
@WebServlet("/GenerateInvoiceServlet")
public class GenerateInvoiceServlet extends HttpServlet {
    private Room room = new Room();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"invoice.csv\"");
        Reservation reservation = (Reservation) request.getSession().getAttribute("reservation");
        
        // Construct CSV content
        StringBuilder csvContent = new StringBuilder();
        csvContent.append("Reservation ID,User ID,Hotel ID,Room ID,Check-In Date,Check-Out Date,Total Amount\n");
        csvContent.append(reservation.getResId()).append(",")
                  .append(reservation.getUserId()).append(",")
                  .append(reservation.getHotelId()).append(",")
                  .append(reservation.getRoomId()).append(",")
                  .append(reservation.getCheckInDate()).append(",")
                  .append(reservation.getCheckOutDate()).append(",")
                  .append(reservation.getDiningOptionId()).append("\n");
        
        
        
        // Write CSV content to response
        try (PrintWriter writer = response.getWriter()) {
            writer.write(csvContent.toString());
        } catch (IOException e) {
            throw new ServletException("Error writing CSV response", e);
        }
    }
}
