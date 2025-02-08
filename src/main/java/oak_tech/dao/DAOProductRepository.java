package oak_tech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oak_tech.config.SingleConnectionDataBase;
import oak_tech.model.Product;

public class DAOProductRepository {

	private Connection connection;

	public DAOProductRepository() {
		this.connection = SingleConnectionDataBase.getConnection();
	}

	public void saveProduct(Product product) {

		try {
			String sql = "INSERT INTO product (name, description, value, available) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setFloat(3, product.getValue());
			preparedStatement.setBoolean(4, product.isAvailable());
			preparedStatement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public List<Product> listProducts() throws Exception {

		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product ORDER BY value ASC";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		ResultSet result = preparedStatement.executeQuery();

		while (result.next()) {
			Product product = new Product();
			product.setId(result.getLong("id"));
			product.setName(result.getString("name"));
			product.setDescription(result.getString("description"));
			product.setValue(result.getFloat("value"));
			product.setAvailable(result.getBoolean("available"));

			products.add(product);
		}

		return products;

	}

	public Product findProduct(Long id) throws Exception {
		Product product = new Product();
		String sql = "SELECT * FROM product WHERE id = " + id;

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet result = preparedStatement.executeQuery();

		while (result.next()) {
			product.setId(result.getLong("id"));
			product.setName(result.getString("name"));
			product.setDescription(result.getString("description"));
			product.setValue(result.getFloat("value"));
			product.setAvailable(result.getBoolean("available"));
		}

		return product;
	}

	public void updateProduct(Product product) {
		try {
			String sql = "UPDATE product SET name = ?, description = ?, value = ?, available = ? WHERE id = "
					+ product.getId();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setFloat(3, product.getValue());
			preparedStatement.setBoolean(4, product.isAvailable());

			preparedStatement.execute();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public void deleteProduct(Long id) {
		try {

			String sql = "DELETE FROM product WHERE id = " + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
	}

}
