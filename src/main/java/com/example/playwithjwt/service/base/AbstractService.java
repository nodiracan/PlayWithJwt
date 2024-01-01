package com.example.playwithjwt.service.base;

import com.example.playwithjwt.mapper.BaseMapper;
import com.example.playwithjwt.repositories.base.BaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractService<R extends BaseRepository, M extends BaseMapper> implements BaseService {
    protected final  R repository;
    protected final M mapper;
}
