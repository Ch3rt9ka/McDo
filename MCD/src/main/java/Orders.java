

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Orders
 */
@WebServlet("/orders")
public class Orders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		Str str = new Str();
				result = result +str.header;
		OrderService orderdesk = OrderService.getObj();
		for (Order.Status status : Order.Status.values()) {
			result = result + orderdesk.orders(status);
		}
		
	
		result = result +str.downw;
		response.getWriter().write(result);
		
		
		
		
		
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
