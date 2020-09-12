package com.abhay.shoppingbackend.dao;

import java.util.List;
import com.abhay.shoppingbackend.dto.Product;

public interface ProductDAO {
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product prodcut);
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}
