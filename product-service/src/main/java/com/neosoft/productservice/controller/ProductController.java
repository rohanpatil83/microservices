package com.neosoft.productservice.controller;

import com.neosoft.productservice.document.Product;
import com.neosoft.productservice.dto.ProductDto;
import com.neosoft.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/welcome")
    public String welcome() {
        return "WELCOME TO PRODUCT SERVICE";
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        Product product1 = productService.addProduct(product);
        return new ResponseEntity<>(product1 + "product saved with id" +" "+ product1.getPId(), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        String str = productService.deleteById(id);
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getByid(@PathVariable String id) {
        Optional<Product> product = productService.getById(id);
        if (product.isPresent()) {
            return new ResponseEntity<Optional<Product>>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("product doesnt exit with given id : " + id, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updatebyid/{id}")
    public ResponseEntity<?> updateById(@PathVariable String id, @RequestBody ProductDto productDto){
       String str=productService.updateProductById(id,productDto);
        return new ResponseEntity<>(str,HttpStatus.ACCEPTED
        );
    }

}
