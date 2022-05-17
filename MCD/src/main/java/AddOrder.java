

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AddOrder
 */
@WebServlet("/add_order")
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		String phone = request.getParameter("phone");
		String phoneId = phone.replace("+", "");
		
		
		
		Str str = new Str();
		result = result+str.header;
		
		OrderService orderdesk = OrderService.getObj();
		Order order = orderdesk.addOrder(phoneId);
		result = result+ "" + order +" is added";
		
		result = result+str.down;
		
		response.getWriter().write(result);
		
		String path = "/index.html";
		ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
       requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
