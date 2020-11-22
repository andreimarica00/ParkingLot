
package com.park.parkinglot.servlet;

import com.park.parkinglot.common.CarDetails;
import com.park.parkinglot.common.UserDetails;
import com.parkinglot.ejb.CarBean;
import com.parkinglot.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditCar", urlPatterns = {"/EditCar"})
public class EditCar extends HttpServlet {

    @Inject
    UserBean userBean;
    
    @Inject
    CarBean carBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditCar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditCar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<UserDetails> users = userBean.getAllUsers();
        request.setAttribute("users", users);
        
        int carId = Integer.parseInt(request.getParameter("id"));
        CarDetails car = carBean.findById(carId);
        request.setAttribute("car", car);
        
        request.getRequestDispatcher("/WEB-INF/pages/editCar.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String licensePlate = request.getParameter("license_plate");
        String parkingSpot = request.getParameter("parking_spot");
        Integer userId = Integer.parseInt(request.getParameter("owner_id"));
        Integer carId = Integer.parseInt(request.getParameter("car_id"));
        
        carBean.updateCar(carId, licensePlate, parkingSpot, userId);
        
        response.sendRedirect(request.getContextPath() + "/Cars"); 
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
