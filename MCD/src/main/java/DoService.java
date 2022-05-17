

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DoService
 */
@WebServlet("/do")
public class DoService extends HttpServlet {
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
				cashier = orderdesk.Do(cashier);
				if (cashier != null) {
					result = result +"" + cashier+" serve order in queue";
				} else {
					result = result+"Unknown cashier: " + param + " or queue is empty";
				}
			
			
				
			
		} catch (Exception e) {
			result = "Invalid cashier ID: " + param;
		}
		//response.setContentType("text/plain;charset=UTF-8");
		
		result = result+str.down;
		response.getWriter().write(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
