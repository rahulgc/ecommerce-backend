package com.ecom.backend.service;


import java.util.List;

import com.ecom.backend.dto.ProductDTO;


public interface ProductService {

	public ProductDTO getProduct(Integer id);

	public Integer addProduct(ProductDTO pdto);

	public void deleteProduct(Integer id);

	public List<ProductDTO> getAllProduct();

	public ProductDTO updateProduct(Integer id,ProductDTO pdto);

}
