

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoService1
 */
@WebServlet("/do1")
public class DoService1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		OrderService orderdesk = OrderService.getObj();
		Str str = new Str();
		result = result+str.header;
		String param = request.getParameter("cashier");
		
		try {
			
			
					int cashierId = Integer.valueOf(param);
				Cashier cashier = orderdesk.cashiers().stream().filter(x -> x.getId() == cashierId).findAny()
						.orElse(null);
				orderdesk.close(cashier);
				if (cashier != null) {
					result = result +"cashier: " + cashier + "complete his order";
				} else {
					result = result +"Unknown cashier: " + param + " or queue is empty";
				}
			
			
				
			
		} catch (Exception e) {
			result = "Invalid cashier ID: " + param;
		}
		
		result = result+str.down;
//		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
