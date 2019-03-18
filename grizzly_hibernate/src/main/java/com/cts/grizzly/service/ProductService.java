package com.cts.grizzly.service;

import java.util.List;

import com.cts.grizzly.bean.Category;
import com.cts.grizzly.bean.Product;

public interface ProductService {
	public String addProduct(Product product);
	public List<Product> viewProducts();
	public Product getProductByID(String id);
	public String deleteProductByID(String id);
}
