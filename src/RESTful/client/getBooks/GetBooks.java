package RESTful.client.getBooks;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import RESTful.client.model.Books;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class GetBooks
 */
@WebServlet("/GetBooks")
public class GetBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter printWriter = response.getWriter();
		
		Client client= Client.create();
		WebResource webResource= client.resource("http://localhost:8080/library/webapi/books");
		
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
            System.out.println(book.getId()+" "+book.getName()+", "+book.getAuthor()+", "+book.getAuthor()+", "+ book.getYear());
        }
		
		/*Display book list in the servlet*/
		printWriter.println("<h1>List of books in the Library</h1>");
        
        if (books.isEmpty()){
        	printWriter.println("<html><body>Sorry, we did not have any book in the library"+"<br>");
        }else{
        	printWriter.println("<html><body>The complete list of books: <br>");
            printWriter.println("<ul>");
            for(Books book : books) {
                printWriter.println("<li>"+"ID: "+book.getId()+"<br>"+"Name: "+book.getName()+"<br>"+"Author: "+book.getAuthor()+"<br>"+"Publisher: "+book.getPublisher()+"<br>"+ "Year: "+book.getYear()+"<br></li><br>");
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
