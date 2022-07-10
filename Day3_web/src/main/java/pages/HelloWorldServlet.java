package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//trace life cycle of srvlet managed by web container
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//override init method

	@Override
	public void init() throws ServletException {
		System.out.println("in init : invoked by "+Thread.currentThread());
	}

	@Override
	public void destroy() {
			System.out.println("in destroy : invoked by "+Thread.currentThread());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doGet : invoked by "+Thread.currentThread());
		//objective : send dynamic response to the client 
		//1.set response content type.
		resp.setContentType("text/html");
		//2.attaach buffered 
		try(PrintWriter pw = resp.getWriter()){
			pw.print("<h5>Welcome 2 servlets"+LocalDateTime.now()+"</h5>");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
}
