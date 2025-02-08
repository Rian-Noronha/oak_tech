package oak_tech.dao;

import java.util.List;

import org.junit.Test;

import oak_tech.model.Product;

public class TestDataJdbc {
	DAOProductRepository daoProductRepository = null;
	Product product = null;

	@Test
	public void initData() {
		DAOProductRepository daoProductRepository = new DAOProductRepository();
		Product product = new Product();

		product.setName("Computer");
		product.setDescription("This computer is gamer..");
		product.setValue(20);
		product.setAvailable(true);

		daoProductRepository.saveProduct(product);

	}

	@Test
	public void initList() {
		daoProductRepository = new DAOProductRepository();
		try {
			List<Product> products = daoProductRepository.listProducts();

			for (Product p : products) {
				System.out.println(p);
				System.out.println("-----------------------------------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initFind() {
		daoProductRepository = new DAOProductRepository();
		try {
			product = daoProductRepository.findProduct(2L);
			System.out.println(product);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initUpdate() {
		try {
			daoProductRepository = new DAOProductRepository();
			product = daoProductRepository.findProduct(3L);

			product.setDescription("This ball is for water.");
			daoProductRepository.updateProduct(product);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initDelete() {

		try {
			daoProductRepository = new DAOProductRepository();
			daoProductRepository.deleteProduct(3L);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
