package com.fdsc.dao;

import com.fdsc.model.Dtproperties;
import com.fdsc.model.RfidNumber;

import java.util.List;

public interface DtpropertiesMapper {
    public List<Dtproperties> findByRfid(String Rfid);
}