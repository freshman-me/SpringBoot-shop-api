package com.freshman.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
    private Integer id;
    private String productName;
    private String description;

}
