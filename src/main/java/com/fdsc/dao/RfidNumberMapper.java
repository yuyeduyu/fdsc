package com.fdsc.dao;

import com.fdsc.model.RfidNumber;

import java.util.List;
import java.util.Map;

public interface RfidNumberMapper {

   public List<RfidNumber> findByRfid(String Rfid);
   public List<RfidNumber> findByCode(String code);

   /**
    * 调拨查询
    * @param param
    * @return
    */
   public List<Map<String,Object> > findBySelectKctbmx(Map<String,Object> param);

   /**
    * 出库查询
    * @param param
    * @return
    */
   public List<Map<String,Object> > findBySelectSpckdmx(Map<String,Object> param);
   /**
    * 结算表查询
    * @param param
    * @return
    */
   public List<Map<String,Object> > findBySelectSettlement(Map<String,Object> param);


}