package it.projects.h2project.controller;

import it.projects.h2project.entity.*;
import it.projects.h2project.service.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/project/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/list", produces="application/json")
    @ResponseBody
    public ResponseEntity< ? > getAllProducts()   {

        List<Product> product = productService.getAllProducts();
        return ResponseEntity.ok(product); // return response 200 ok
    }


    @GetMapping(value = "/get/{code}", produces="application/json")
    @ResponseBody
    public ResponseEntity< ? > getProductById(@PathVariable ("code") String code){

            Product product = productService.getProductById(code);
            return ResponseEntity.ok(product);
    }

    @GetMapping(value = "/description/search/{searchText}", produces="application/json")
    @ResponseBody
    public ResponseEntity< ? > searchProductsByDescription(@PathVariable("searchText") String searchText) {

            List<Product> product = productService.findAllByDescriptionContaining(searchText);
            return ResponseEntity.ok(product);
    }

    @PostMapping (value = "/save", produces = "application/json")
    @ResponseBody
    public ResponseEntity< ? > saveProduct (@RequestBody Product product){

            Product saveProduct = productService.saveProduct(product);
            return ResponseEntity.status(HttpStatus.OK).body("Product created successfully with code " + saveProduct.getCode());
        }

}
