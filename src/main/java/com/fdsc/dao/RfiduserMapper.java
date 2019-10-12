package com.fdsc.dao;

import com.fdsc.model.Rfiduser;

import java.util.List;

public interface RfiduserMapper {
    public List<Rfiduser> findByName(String name);
}