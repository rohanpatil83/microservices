package com.neosoft.productservice.service;

import com.neosoft.productservice.document.Product;
import com.neosoft.productservice.dto.ProductDto;
import com.neosoft.productservice.repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Slf4j(topic = "productService")
public class ProductService {


    @Autowired
    ProductRepo productRepo;

    public Product addProduct(Product product) {
        product.setPId(product.getPId() + "ttt");
        log.info("product request :: {}",product.getPId(),product.getPName());
        return product = productRepo.save(product);



    }


    public List<Product> getAll() {
        return productRepo.findAll();
    }

    public String deleteById(String id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return "deleted successfully";
        }
        return "product is doesn't exit wih given id :" + id;

    }


    public String updateProductById(String id, ProductDto productDto) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
            Product product1 = product.get();
            product1.setPType(productDto.getPType());
            product1.setPName(productDto.getPName());
            product1.setPQuantity(productDto.getPQuantity());
            productRepo.save(product1);
            return "updated successfully with id :"+ id;
        } else {
            return "product is not present with given id : " + id;
        }

    }

    public Optional<Product> getById(String id) {
        return productRepo.findById(id);


    }
}
