package com.freshman.service;

import com.freshman.controller.Result;
import com.freshman.pojo.Product;

public interface ProductService {

    Result getById(Integer id);

    Result getAll();

    Result addProduct(Product product);

    Result deleteProduct(Integer id);

    Result updateProduct(Product product);
}
