package com.freshman.controller;

import com.freshman.pojo.Product;
import com.freshman.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable("id")Integer id){
        return productService.getById(id);
    }

    @GetMapping("/getAll")
    @Cacheable(value = "productCache",key = "#root.methodName")
    public Result getAll(){
        log.info("使用了数据库~~~~");
        return productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id")Integer id){
        return productService.deleteProduct(id);
    }

    @PostMapping("/update/{id}")
    public Result update(@PathVariable("id")Integer id,@RequestBody Product product){
        product.setId(id);
        return productService.updateProduct(product);
    }

}
