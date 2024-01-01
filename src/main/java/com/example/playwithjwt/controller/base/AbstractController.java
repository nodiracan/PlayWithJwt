package com.example.playwithjwt.controller.base;

import com.example.playwithjwt.service.base.BaseService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractController <S extends BaseService> implements BaseController{

    public  final S service;

    protected final static String API = "/api";
    protected final static String VERSION = "/v1";
    protected final static String PATH = API + VERSION;

}
