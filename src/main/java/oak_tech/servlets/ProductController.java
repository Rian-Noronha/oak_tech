package oak_tech.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import oak_tech.dao.DAOProductRepository;
import oak_tech.model.Product;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/ProductController", "/main", "/insert", "/select", "/update", "/delete" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOProductRepository daoProductRepository = new DAOProductRepository();
	Product product = new Product();

	public ProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		if (action.equals("/main")) {
			products(request, response);
		} else if (action.equals("/insert")) {
			newProduct(request, response);
		} else if (action.equals("/select")) {
			listProducts(request, response);
		} else if (action.equals("/update")) {
			editProduct(request, response);
		} else if (action.equals("/delete")) {
			deleteProduct(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}


	protected void products(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Product> products = daoProductRepository.listProducts();
			request.setAttribute("products", products);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("product.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		product.setName(request.getParameter("name"));
		product.setDescription(request.getParameter("description"));
		product.setValue(Float.parseFloat(request.getParameter("value")));
		product.setAvailable(Boolean.parseBoolean(request.getParameter("available")));

		daoProductRepository.saveProduct(product);

		response.sendRedirect("main");

	}

	public void listProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String id = request.getParameter("id");
			product = daoProductRepository.findProduct(Long.parseLong(id));

			request.setAttribute("id", product.getId());
			request.setAttribute("name", product.getName());
			request.setAttribute("description", product.getDescription());
			request.setAttribute("value", product.getValue());
			request.setAttribute("available", product.isAvailable());

			RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void editProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		product.setId(Long.parseLong(request.getParameter("id")));
		product.setName(request.getParameter("name"));
		product.setDescription(request.getParameter("description"));
		product.setValue(Float.parseFloat(request.getParameter("value")));
		product.setAvailable(Boolean.parseBoolean(request.getParameter("available")));

		daoProductRepository.updateProduct(product);
		response.sendRedirect("main");

	}

	public void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		daoProductRepository.deleteProduct(Long.parseLong(request.getParameter("id")));
		response.sendRedirect("main");
	}

}
