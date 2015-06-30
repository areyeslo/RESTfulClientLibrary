package RESTful.client.getBooks;
import RESTful.client.model.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.Arrays;
import java.util.List;

/**
 * Servlet implementation class GetBooksByYear
 */
@WebServlet("/GetBooksByYear")
public class GetBooksByYear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBooksByYear() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**This method has to be consumed by insert.
	 * This method has to invoke to monitor using the "Policy" database.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter printWriter = response.getWriter();
				
		String year= request.getParameter("year");
		
		Client client= Client.create();
		WebResource webResource= client.resource("http://localhost:8080/library/webapi/books/year/" + year);
		
		ClientResponse rs=webResource.accept(
				           MediaType.APPLICATION_JSON_TYPE,
				           MediaType.APPLICATION_XML_TYPE).
				           get(ClientResponse.class);
		
		/*Transform json to java object*/
		String jsonBooks=rs.getEntity(String.class);		
		Gson gson = new Gson();
		Books[] booksA = gson.fromJson(jsonBooks, Books[].class);
		List<Books> books = Arrays.asList(booksA);
		
		for(Books book : books) {
            System.out.println(book.getName()+", "+book.getAuthor()+", "+book.getAuthor()+", "+ book.getYear());
        }
		
		/*Display book list in the servlet*/
		printWriter.println("<h1>Books by Year</h1>");
        
        if (books.isEmpty()){
        	printWriter.println("<html><body>Sorry, we did not have any book for the year "+ year +"<br>");
        }else{
        	printWriter.println("<html><body>The list of books for year "+year+" are: <br>");
            printWriter.println("<ul>");
            for(Books book : books) {
                printWriter.println("<li>"+"Name: "+book.getName()+"<br>"+"Author: "+book.getAuthor()+"<br>"+"Publisher: "+book.getPublisher()+"<br>"+ "Year: "+book.getYear()+"<br></li><br>");
            }
        }
        printWriter.println("</body></html>");
        printWriter.print("<a href=\"getBooksByYear.jsp\">Back</a>");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
