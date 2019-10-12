package com.fdsc.service;

import java.util.Map;

public interface FdscOpeationService {


    /**
     * 获取数据
     * @param rfid
     * @return
     */
    public String findByRfid(String rfid);
    public String findByCode(String code);
    /**
     * 获取数据冻结
     * @param rfid
     * @return
     */
    public String findDJByRfid(String rfid);
    public String findDJByCode(String code);
    /**
     * 获取数据调拨
     * @param rfid
     * @return
     */
    public String findTBByRfid(String rfid);
    public String findTBByCode(String code);

    /**
     * 出库
     * @param rfIds
     */
    public String outGoing(String rfIds,String equInfor);
    public String outGoingCode(String codes,String equInfor);
    /**
     * 入库
     * @param rfIds
     */
    public String inComing(String rfIds,String equInfor);
    public String inComingCode(String codes,String equInfor);

    /**
     * 盘存
     * @param rfids
     */
    public void inventoryRfid(String rfids,String equInfor);
    public void inventoryCode(String codes,String equInfor);

    /**
     * 冻结
     * @param rfIds
     */
    public String frozenByRfids(String rfIds,String equInfor);
    public String frozenByCodes(String codes,String equInfor);

    /**
     * 调拨
     * @param rfIds
     */
    public String allocationByRfids(String rfIds,String equInfor);
    public String allocationByCodes(String codes,String equInfor);

    /**
     * 调拨查询
     * @param page
     * @param pageSize
     * @param param
     * @return
     */
    public Map<String, Object> selectAllocation(int page, int pageSize, Map<String, Object> param);

    /**
     * 出库查询
     * @param page
     * @param pageSize
     * @param param
     * @return
     */

    public Map<String, Object> selectOutOfStock(int page, int pageSize, Map<String, Object> param);

    /**
     * 结算单查询
     * @param page
     * @param pageSize
     * @param param
     * @return
     */

    public Map<String, Object> findBySelectSettlement(int page, int pageSize, Map<String, Object> param);

}
