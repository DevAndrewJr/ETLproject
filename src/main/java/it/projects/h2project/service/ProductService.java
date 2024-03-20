package it.projects.h2project.service;

import it.projects.h2project.entity.*;
import it.projects.h2project.exception.*;
import it.projects.h2project.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products from default method findAll()
    public List< Product > getAllProducts(){
            try {
                List< Product > product = productRepository.findAll();
                if (product.isEmpty()) {
                    throw new ProductNotFoundException("Products are not present");
                }
                return product;
            }catch(Exception e){
                e.printStackTrace();
                throw e;
            }
    }


    public Product getProductById(String code) {
        Optional< Product > productOptional = productRepository.findById(code);
        try {
            if (productOptional.isPresent() && !productOptional.isEmpty()) {
                return productOptional.get();
            } else {
                throw new ProductNotFoundException("Product " + code + " is not present");
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }


    public List<Product> findAllByDescriptionContaining(String searchText){
        Optional< List<Product> > productOptional = productRepository.findAllByDescriptionContainingIgnoreCase(searchText);
            try {
                if (productOptional.isPresent() && !productOptional.get().isEmpty()) {
                    return productOptional.get();
                } else {
                    throw new ProductNotFoundException("Product " + searchText + " is not present");
                }
            }catch(Exception e){
                e.printStackTrace();
                throw e;
            }
    }

    public Object alfanumericCode(){
        int randomNumber = (int) Math.random() * 50000;
        String randomNumberString = Integer.toString(randomNumber);
        String code = "ITEM-" + randomNumberString;
        return code;
    }

    public Product saveProduct(Product product) {
        try {

            // Generate alfanumeric code
            String code = (String) alfanumericCode();
            product.setCode(code);

            if (product == null || product.getCode() == null || product.getCode().isEmpty() || product.getNameProduct() == null || product.getNameProduct().isEmpty()) {
                throw new ProductIllegalArgumentException("Product name or code cannot be null or empty");
            }

            Optional<Product> existingProduct = productRepository.findByCodeContainingIgnoreCase(product.getCode());
            if (existingProduct.isPresent()) {
                throw new DuplicateProductCodeException("Product code already exists: " + product.getCode());
            }

            Product saveProduct = productRepository.saveAndFlush(product);
            return saveProduct;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }


}