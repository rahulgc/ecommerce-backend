package com.ecom.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.backend.dto.ProductDTO;
import com.ecom.backend.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id){
		ProductDTO pd=ps.getProduct(id);
		
		return new ResponseEntity<>(pd,HttpStatus.OK);
		
	}
	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody ProductDTO pdto){
		Integer id= ps.addProduct(pdto);
		String msg="Product "+id+" added successfuly";
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
		ps.deleteProduct(id);
		String msg="Product "+id+" is deleted successfully";
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts(){
		List<ProductDTO> prodList=ps.getAllProduct();
		return new ResponseEntity<>(prodList,HttpStatus.OK);
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id ,@RequestBody ProductDTO pdto){
		
		ProductDTO product=ps.updateProduct(id,pdto);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}

}
