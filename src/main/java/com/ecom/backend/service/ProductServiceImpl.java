package com.ecom.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.backend.Exception.ResourceNotFoundException;
import com.ecom.backend.dto.ProductDTO;
import com.ecom.backend.entity.Product;
import com.ecom.backend.repository.ProductRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository pr;

	@Override
	public ProductDTO getProduct(Integer id) {
		Optional<Product> p=Optional.of(pr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not Found !")));
		Product prd=p.get();
		ProductDTO pdto=Product.prepareProductDTO(prd);
		// TODO Auto-generated method stub
		return pdto;
	}

	@Override
	public Integer addProduct(ProductDTO pdto) {
		// TODO Auto-generated method stub
		Product p=ProductDTO.prepareProduct(pdto);
		pr.saveAndFlush(p);
		return p.getProductId();
	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		Optional<Product> prod=Optional.of(pr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not Found !")));
		Product p=prod.get();
		pr.delete(p);

}

	@Override
	public List<ProductDTO> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> products=pr.findAll();
		List<ProductDTO> productdtolist=new ArrayList();
		for(Product p:products) {
			ProductDTO pdto= Product.prepareProductDTO(p);
			productdtolist.add(pdto);
			
		}
		return productdtolist;
	}

	@Override
	public ProductDTO updateProduct(Integer id,ProductDTO pd) {
		// TODO Auto-generated method stub
		Optional<Product> prod=Optional.of(pr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not Found !")));
		Product p=prod.get();
		p.setProductName(pd.getProductName());
		p.setPrice(pd.getPrice());
		p.setQuantity(pd.getQuantity());
		p.setLive(pd.isLive());
		p.setProductDesc(pd.getProductDesc());
		p.setStock(pd.isStock());
		p.setImageAddress(pd.getImageAddress());
		
		pr.saveAndFlush(p);
		ProductDTO pdto=Product.prepareProductDTO(p);
		return pdto;
	}
}
