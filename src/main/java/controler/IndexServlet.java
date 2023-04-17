package controler;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dao.PacienteDao;
import Entidades.Paciente;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PacienteDao dao;

	public IndexServlet() {
	}

	////////////////////////////////////////////////
	/// Method
	////////////////////////////////////////////////
	public void init() throws ServletException {
		dao = new PacienteDao();
	}

	////////////////////////////////////////////////
	/// Method - Override
	////////////////////////////////////////////////
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showViewForm(request, response);
				break;
			case "/insert":
				insert(request, response);
				break;
			case "/delete":
				delete(request, response);
				break;
			case "/edit":
				showEdit(request, response);
				break;
			case "/update":
				update(request, response);
				break;
				
			case "/list":
				list(request, response);
				break;
			default:
				showViewForm(request, response);
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	private void showEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		if (dao == null) {
			this.init();
		}
		Paciente c =  dao.find(id);
		PacienteDao eDao = new PacienteDao();
		List<Paciente> list = eDao.list();
		request.setAttribute("list", list);
		request.setAttribute("Paciente", c);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Paciente.jsp");
		dispatcher.forward(request, response);
	}

	////////////////////////////////////////////////
	/// Method
	////////////////////////////////////////////////
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String eleccion = request.getParameter("eleccion");
		if (dao == null) {
			init();
		}
		System.out.println(eleccion);

		List<Paciente> list = (eleccion != null) ? dao.list(eleccion) : dao.list();
		request.setAttribute("listCandidato", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("PacienteList.jsp");
		dispatcher.forward(request, response);
	}

	private void showViewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PacienteDao eDao = new PacienteDao();
		List<Paciente> list = eDao.list();
		request.setAttribute("listPaciente", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("paciente.jsp");
		dispatcher.forward(request, response);
	}
	
	

	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ParseException {
		
		String id = request.getParameter("id");
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
	    String fechanacimiento= request.getParameter("fechanacimiento");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String peso = request.getParameter("peso");
		String estatura = request.getParameter("estatura");
		 
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(fechanacimiento);  
	    System.out.println(fechanacimiento+"\t"+date1);
		
		System.out.println(id);
		System.out.println(documento);
		System.out.println(nombre);
		System.out.println(apellido);
	
	

		Paciente c = new Paciente(Integer.parseInt(id), documento, nombre, apellido,email,genero, date1,telefono,direccion,Double.parseDouble(peso),
			Double.parseDouble(estatura));
		if (dao == null) {
			init();
		}
		dao.insert(c);
		System.out.println("Insert");
		response.sendRedirect("list");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, ParseException {
		String id = request.getParameter("id");
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
	    String fechanacimiento= request.getParameter("fechanacimiento");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String peso = request.getParameter("peso");
		String estatura = request.getParameter("estatura");
		
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(fechanacimiento);  
	    System.out.println(fechanacimiento+"\t"+date1);
		Paciente Pa = new Paciente(Integer.parseInt(id), documento, nombre, apellido,email,genero, date1,telefono,direccion,Double.parseDouble(peso),
				Double.parseDouble(estatura));
		if (dao == null) {
			this.init();
		}
		dao.update(Pa);
		response.sendRedirect("list");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String id = request.getParameter("id");
		if (dao == null) {
			this.init();
		}
		dao.delete(Integer.parseInt(id));
		response.sendRedirect("list");
	}

	

}