package com.fdsc.dao;

import com.fdsc.model.RfidtempMain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RfidtempMainMapper {

   public void update(@Param("rfIdList") List<String> rfIdList, @Param("status")String status,
                      @Param("equInfor")String equInfor, @Param("dongJ")String dongJ, @Param("tbkc")String tbkc);

   public void updateCode(@Param("codeList") List<String> codeList, @Param("status")String status,
                          @Param("equInfor")String equInfor, @Param("dongJ")String dongJ, @Param("tbkc")String tbkc);
   public void insert(@Param("list") List<String> list, @Param("equInfor")String equInfor);
   public void insertCode(@Param("list") List<String> list, @Param("equInfor")String equInfor);
   public void insertComing(@Param("rfId")String rfId, @Param("status")String status, @Param("equInfor")String equInfor);
   public void insertCodeComing(@Param("code") String code, @Param("status")String status, @Param("equInfor")String equInfor);

   public List<RfidtempMain> findByRfid(String Rfid);
   public List<RfidtempMain> findByCode(String code);

   public void editEntity(@Param("rfId") String rfId,@Param("code") String code, @Param("status")String status,
                      @Param("equInfor")String equInfor, @Param("dongJ")String dongJ, @Param("tbkc")String tbkc);
   public void addEntity(@Param("rfId") String rfId,@Param("code") String code, @Param("status")String status,
                      @Param("equInfor")String equInfor, @Param("dongJ")String dongJ, @Param("tbkc")String tbkc);
}