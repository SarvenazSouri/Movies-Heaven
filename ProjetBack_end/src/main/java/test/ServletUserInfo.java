/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import clients.*;
import films.Films;
import films.ManagerFilms;
import java.io.BufferedReader;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author isi
 */
public class ServletUserInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("application/json");
        
        String pathInfo = request.getPathInfo();
        // Determine the endpoint based on the path
        if (pathInfo == null) {
            response.getWriter().write("No endpoint specified");
        } else if (pathInfo.equals("/donneUser")) {
            donne_utilisateur(request, response);
        } else if (pathInfo.equals("/listeFilm")) {
            list_films(request, response);
        }else if (pathInfo.equals("/filmLouer")) {
            louer_films(request, response);
        }else if (pathInfo.equals("/createUser")) {
            create_user(request, response);
        } else {
            response.getWriter().write("Unknown endpoint: " + pathInfo);
        }
    }
    private void create_user(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        BufferedReader reader = request.getReader();
        StringBuilder jsonBuffer = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
                jsonBuffer.append(line);
        }
        
        JSONObject jsonObject = new JSONObject(jsonBuffer.toString());
        
        String email = jsonObject.getString("email");
        String pws = jsonObject.getString("password");

        // Check if the user already exists
        Clients existingUser = ClientManager.trouver_utilisateur(email, pws);
        if (!existingUser.equals(new Clients())) {
            response.setStatus(HttpServletResponse.SC_CONFLICT); 
        } else {
            // Create a new user
            ClientManager.createUser(email, pws);
        }
}

    private void donne_utilisateur(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        StringBuilder jsonBuffer = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
                jsonBuffer.append(line);
        }
        
        JSONObject jsonObject = new JSONObject(jsonBuffer.toString());
        
        String email = jsonObject.getString("email");
        String pws = jsonObject.getString("password");
        Clients sampleObject = ClientManager.trouver_utilisateur(email,pws);
        if(sampleObject.equals(new Clients())){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }else{
           Gson gson = new Gson();
            String json = gson.toJson(sampleObject);
            response.getWriter().write(json);
            processRequest(request, response); 
        }
    }
    
    private void list_films(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Films> sampleObject = ManagerFilms.recup_film();
        Gson gson = new Gson();
        String json = gson.toJson(sampleObject);
        response.getWriter().write(json);
        processRequest(request, response);
    
    }

    private void louer_films(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        StringBuilder jsonBuffer = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
                jsonBuffer.append(line);
        }
        
        JSONObject jsonObject = new JSONObject(jsonBuffer.toString());
        
        String id_film = jsonObject.getString("id_film");
        String id_client = jsonObject.getString("id_client");
        boolean louer = ManagerFilms.film_louer(id_film, id_client);
        request.setAttribute("confirmationLouer", louer);
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
