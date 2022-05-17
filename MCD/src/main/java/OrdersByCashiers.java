

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class OrdersByCashiers
 */
@WebServlet("/orders_by_cashiers")
public class OrdersByCashiers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		Str str = new Str();
		result = result+str.header;
		OrderService orderdesk = OrderService.getObj();
		String param = request.getParameter("cashier");
		try {
			int cashierId = Integer.valueOf(param);
			Cashier cashier = orderdesk.cashiers().stream().filter(x -> x.getId() == cashierId).findAny()
					.orElse(null);
		
			result =result + orderdesk.orders(cashier).toString();
		} catch (Exception e) {
			result =result + "Unknown cashier: " + param;
		}
		
		
		result = result+str.down;
		//response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
