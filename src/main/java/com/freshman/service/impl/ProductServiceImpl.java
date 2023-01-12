package com.freshman.service.impl;

import com.freshman.controller.Code;
import com.freshman.controller.Result;
import com.freshman.mapper.ProductMapper;
import com.freshman.pojo.Product;
import com.freshman.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    @Cacheable(value = "cacheSpace", key = "#id")
    public Result getById(Integer id) {
        Product product = productMapper.getById(id);
        if(product != null){
            return new Result(Code.FIND_SUCCESS,"find successful",product);
        }else {
            return new Result(Code.FIND_FAIL,"find fail");
        }
    }

    @Override
    public Result getAll() {
        List<Product> list = productMapper.getAll();
        if (list != null){
            return new Result(Code.FIND_ALL_SUCCESS,"find all successful",list);
        }else {
            return new Result(Code.FIND_ALL_FAIL,"find all fail");
        }
    }

    @Override
    public Result addProduct(Product product) {
        int i = productMapper.addProduct(product);
        if (i > 0){
            return new Result(Code.ADD_SUCCESS,"Add product successful");
        }else {
            return new Result(Code.ADD_FAIL,"Add product fail");
        }
    }

    @Override
    public Result deleteProduct(Integer id) {
        int i = productMapper.deleteProduct(id);
        if (i > 0){
            return new Result(Code.DELETE_SUCCESS,"delete successful");
        }else {
            return new Result(Code.DELETE_FAIL,"delete fail");
        }
    }

    @Override
    public Result updateProduct(Product product) {
        int i = productMapper.updateProduct(product);
        if (i > 0){
            return new Result(Code.UPDATE_SUCCESS,"update successful!");
        }else
            return new Result(Code.UPDATE_FAIL,"update fail");
    }
}
