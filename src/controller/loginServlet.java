package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.ServletUtils;
import model.User;
import model.LoginHelper;
import model.Score;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		User thisUser = new User(username, password);
		LoginHelper dao = new LoginHelper();
		boolean loginn = dao.login(username, password);
		if(loginn == false) {
			String errorMsg = "Invalid Username or Password";
			request.setAttribute("errorMessage", errorMsg);
			System.out.println(errorMsg);
			System.out.println("NO");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		if(loginn == true) {
			
			ServletUtils.storeUser(request.getSession(), thisUser);
			System.out.println(request.getSession());
			getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
		}
		
	}

}
