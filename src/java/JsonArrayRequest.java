/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Enamul
 */
@WebServlet(urlPatterns = {"/JsonArrayRequest"})
public class JsonArrayRequest extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //begin get data from databse or other source
        List<Model> list = new ArrayList<>();
        Model model = new Model();
        model.setId("101");
        model.setName("Enamul Haque");
        list.add(model);
        
          Model model1 = new Model();
          model1.setId("102");
          model1.setName("Md Mohsin");
          list.add(model1);
         //End get data from databse or other source
        try {

            JSONArray ja = new JSONArray();
            for (Model m : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", m.getId());
                jSONObject.put("name", m.getName());
                ja.add(jSONObject);
            }
            System.out.println(" json ja = " + ja);
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(ja.toString());
            response.getWriter().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

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
