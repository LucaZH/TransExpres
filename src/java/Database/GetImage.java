/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Database;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author luca
 */
@WebServlet(name = "GetImage",urlPatterns = {"/GetImage"})
public class GetImage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetImage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetImage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Database db = new Database();
        Connection con = db.Connect();
        Statement stmt = null;
        ResultSet rs;

        InputStream sImage;
        try {
            String id = request.getParameter("id");
            stmt = con.createStatement();
            String strSql = "select image_auto,type from automobile where id =" + id;
            rs = stmt.executeQuery(strSql);
            
            byte[] bytearray = new byte[1048576];
            int size;

            if (rs.next()) {
                sImage = rs.getBinaryStream("image_auto");
                String type= rs.getString("type");
//                System.out.println(sImage);
                response.reset();
                response.setContentType("image/jpeg");
                while ((size = sImage.read(bytearray)) != -1) {
                    response.getOutputStream().
                            write(bytearray, 0, size);
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("error ========");
            System.out.println(e);
        
        }
    }


}
