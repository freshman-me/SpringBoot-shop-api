package com.freshman.service.impl;

import com.freshman.controller.Result;
import com.freshman.mapper.ProductMapper;
import com.freshman.pojo.Product;
import com.freshman.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Result getById(Integer id) {
        Product product = productMapper.getById(id);
        if(product != null){
            return new Result(300,"find sucessful",product);
        }else {
            return new Result(-300,"find fail");
        }
    }

    @Override
    public Result getAll() {
        List<Product> list = productMapper.getAll();
        if (list != null){
            return new Result(400,"find all sucessful",list);
        }else {
            return new Result(-400,"find all fail");
        }
    }

    @Override
    public Result addProduct(Product product) {
        int i = productMapper.addProduct(product);
        if (i > 0){
            return new Result(500,"Add product sucessful");
        }else {
            return new Result(-500,"Add product fail");
        }
    }

    @Override
    public Result deleteProduct(Integer id) {
        int i = productMapper.deleteProduct(id);
        if (i > 0){
            return new Result(600,"delete successful");
        }else {
            return new Result(-600,"delete fail");
        }
    }

    @Override
    public Result updateProduct(Product product) {
        int i = productMapper.updateProduct(product);
        if (i > 0){
            return new Result(700,"update successful!");
        }else
            return new Result(-700,"update fail");
    }
}
