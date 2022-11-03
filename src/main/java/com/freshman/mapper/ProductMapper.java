package com.freshman.mapper;

import com.freshman.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    // 根据id查找商品
    Product getById(Integer id);

    // 查找所有商品
    List<Product> getAll();

    // 添加商品
    int addProduct(Product product);

    // 删除商品
    int deleteProduct(Integer id);

    // 修改商品
    int updateProduct(Product product);
}
