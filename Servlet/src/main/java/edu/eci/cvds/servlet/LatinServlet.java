package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.eci.cvds.servlet.Service;
import edu.eci.cvds.servlet.model.Todo;
import java.util.List;
import java.util.ArrayList;
@WebServlet(
    urlPatterns = "/latin"
)
public class LatinServlet extends HttpServlet{
    static final long serialVersionUID = 35L;
	private List<Todo> todos = new ArrayList<Todo>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
       String ids = optId.isPresent() && !optId.get().isEmpty() ? optId.get() : "";
	   int id = Integer.parseInt(ids);
	   Todo todo = Service.getTodo(id);
	   todos.add(todo);
       resp.setStatus(HttpServletResponse.SC_OK);
       responseWriter.write(Service.todosToHTMLTable(todos));
       responseWriter.flush();
   }
}