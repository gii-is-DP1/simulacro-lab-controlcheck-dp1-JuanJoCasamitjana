package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
    public List<Product> getAllProducts(){
        return this.repository.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return this.repository.productsCheaperThan(price);
    }

    public ProductType getProductType(String typeName) {
        return this.repository.findProductType(typeName);
    }

    public Product save(Product p){
        return this.repository.save(p);       
    }

    public List<ProductType> findAllProductTypes() {
    	return this.repository.findAllProductTypes();
    }
    
}
