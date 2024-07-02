package room.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import room.dao.roomDao;
import room.model.Room;
import room.model.RoomType;
import room.service.RoomService;
import room.service.RoomServiceImpl;

@WebServlet("/CheckAvailabilityController")
public class CheckAvailabilityController extends HttpServlet {
    private Room room = new Room();
    private roomDao roomDao;
    private final RoomService roomService = new RoomServiceImpl(roomDao);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        int numPeople = Integer.parseInt(request.getParameter("num_people"));
        LocalDate checkInDate = LocalDate.parse(request.getParameter("check_in_date"));
        LocalDate checkOutDate = LocalDate.parse(request.getParameter("check_out_date"));
        RoomType roomType = RoomType.valueOf(request.getParameter("room_type"));
         
       // int roomId = Integer.parseInt(request.getParameter("room_id"));
        
        //int userId = Integer.parseInt(request.getParameter("id")); // Ensure this is not empty or null

         // Set the userId in session

        switch (request.getParameter("submit")) {
            case "Check Availability":
                
                
                HttpSession session = request.getSession(false);
                    
  
                   
                session.getAttribute("user_id");
                session.getAttribute("email");
                session.setAttribute("room", room);
                
                session.setAttribute("numPeople", numPeople);
                session.setAttribute("checkInDate", checkInDate);
                session.setAttribute("checkOutDate", checkOutDate);
                session.setAttribute("roomType", roomType);

                try {
                    List<Room> availableRooms = roomService.getAvailableRooms(checkInDate, checkOutDate, roomType, numPeople);
                    request.setAttribute("availableRooms", availableRooms);
                    request.getRequestDispatcher("displayRoomsAvailable.jsp").forward(request, response);
                } catch (SQLException e) {
                   // display your internal server error.
                }
                break;

            case "Proceed to Reservation":
               
                request.getRequestDispatcher("createReservation.jsp").forward(request, response);
                break;
        }
    }
}
