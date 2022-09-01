package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;
    
    private static final String CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";
    
    @GetMapping("/create")
    public String initCreationForm(ModelMap modelMap) {
    	String view = CREATE_OR_UPDATE_FORM;
    	modelMap.addAttribute("product", new Product());
    	modelMap.addAttribute("productTypes", this.service.findAllProductTypes());
    	return view;
    }
    
    @PostMapping("/create")
    public String processCreationForm(@Valid Product p, BindingResult result, ModelMap modelMap) {
    	if(result.hasErrors()) {
    		modelMap.addAttribute("product", p);
    		modelMap.addAttribute("productTypes", this.service.findAllProductTypes());
    		return CREATE_OR_UPDATE_FORM;
    	} else {
    		this.service.save(p);
    		modelMap.addAttribute("message", "Product succesfully saved!");
    	}
    	
    	return "welcome";
    }
}
