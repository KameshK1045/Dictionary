package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import apiexample.APIExcercise;

/**
 * Servlet implementation class Dictionary
 */
@WebServlet("/Dictionary")
public class Dictionary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dictionary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject jsonobj = null;
		String word  = request.getParameter("word");
		APIExcercise api = new APIExcercise();
		String str = api.dictionary(word);
		JSONParser parser = new JSONParser();
		try {
			jsonobj = (JSONObject) parser.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		response.getWriter().append(jsonobj.toString());
	}

}
