package com.freshman.controller;

import lombok.Data;

@Data
public class Code {

    public static final Integer LOGIN_SUCCESS = 1001;
    public static final Integer LOGIN_FAIL = 1000;

    public static final Integer REGISTER_SUCCESS = 2001;
    public static final Integer REGISTER_FAIL = 2000;

    public static final Integer FIND_SUCCESS = 3001;
    public static final Integer FIND_FAIL = 3000;
    public static final Integer FIND_ALL_SUCCESS = 4001;
    public static final Integer FIND_ALL_FAIL = 4000;

    public static final Integer ADD_SUCCESS = 5001;
    public static final Integer ADD_FAIL = 5000;

    public static final Integer DELETE_SUCCESS = 6001;
    public static final Integer DELETE_FAIL = 6000;

    public static final Integer UPDATE_SUCCESS = 7001;
    public static final Integer UPDATE_FAIL = 7000;
}
