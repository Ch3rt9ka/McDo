

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddCashier
 */
@WebServlet("/add_cashier")
public class AddCashier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		Str str = new Str();
		result = result+str.header;
		
		OrderService orderdesk = OrderService.getObj();
		Cashier cashier = orderdesk.addCashier();
		result = result +"" + cashier+" is added";
		
		result = result+str.down;
		
		response.getWriter().write(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
