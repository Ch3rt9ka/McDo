

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class OrdersByStatus
 */
@WebServlet("/orders_by_status")
public class OrdersByStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "";
		Str str = new Str();
		result = result+str.header;
		OrderService orderdesk = OrderService.getObj();
		String param = request.getParameter("status");
		try {
			Order.Status status = Order.Status.valueOf(param);
			result = result +orderdesk.orders(status).toString();
		} catch (Exception e) {
			result = result+"Unknown status : " + param;
		}
		result = result+str.down;
		response.getWriter().write(result);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
