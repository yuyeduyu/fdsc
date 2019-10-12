package com.fdsc.controller;

import com.fdsc.service.FdscOpeationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class FdscController {

    @Resource
    FdscOpeationService fdscOpeationService;

    //出库
    @ResponseBody
    @RequestMapping("outGoing")
    public String outGoing(String rfids, String equInfor) {

        try {

            String data = fdscOpeationService.outGoing(rfids, equInfor);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
//        return "success";
    }

    //条码出库
    @ResponseBody
    @RequestMapping("outGoingCode")
    public String outGoingCode(String codes, String equInfor) {

        try {
            String data = fdscOpeationService.outGoingCode(codes, equInfor);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
//        return "success";
    }

    //入库
    @ResponseBody
    @RequestMapping("inComing")
    public String inComing(String rfids, String equInfor) {
        try {
            String data = fdscOpeationService.inComing(rfids, equInfor);
            return data;

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
//        return "success";
    }

    //条码入库
    @ResponseBody
    @RequestMapping("inComingCode")
    public String inComingCode(String codes, String equInfor) {
        try {
            String data = fdscOpeationService.inComingCode(codes, equInfor);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
//        return "success";
    }

    @ResponseBody
    @RequestMapping("findByRfid")
    public String findByRfid(String rfId) {
        String listJson = fdscOpeationService.findByRfid(rfId);
        return listJson;
    }

    //查询
    @ResponseBody
    @RequestMapping("findByCode")
    public String findByCode(String code) {
        String listJson = fdscOpeationService.findByCode(code);
        return listJson;
    }

    /**
     * 冻结查询
     *
     * @param rfId
     * @return
     */
    @ResponseBody
    @RequestMapping("findDJByRfid")
    public String findDJByRfid(String rfId) {
        String listJson = fdscOpeationService.findDJByRfid(rfId);
        return listJson;
    }

    //查询
    @ResponseBody
    @RequestMapping("findDJByCode")
    public String findDJByCode(String code) {
        String listJson = fdscOpeationService.findDJByCode(code);
        return listJson;
    }

    /**
     * 调拨
     * //     * @param rfId
     *
     * @return
     *//*
    @ResponseBody
    @RequestMapping("findTBByRfid")
    public String findTBByRfid(String rfId) {
        String listJson = fdscOpeationService.findTBByRfid(rfId);
        return listJson;
    }

    //查询
    @ResponseBody
    @RequestMapping("findTBByCode")
    public String findTBByCode(String code) {
        String listJson = fdscOpeationService.findTBByCode(code);
        return listJson;
    }*/

    //盘存
    @ResponseBody
    @RequestMapping("inventory")
    public String inventory(String rfids, String equInfor) {
        try {
            fdscOpeationService.inventoryRfid(rfids, equInfor);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("inventoryCode")
    public String inventoryCode(String codes, String equInfor) {
        try {
            fdscOpeationService.inventoryCode(codes, equInfor);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    //冻结
    @ResponseBody
    @RequestMapping("frozenByRfid")
    public String frozenByRfid(String rfids, String equInfor) {
        try {

            String data = fdscOpeationService.frozenByRfids(rfids, equInfor);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
//        return "success";
    }

    @ResponseBody
    @RequestMapping("frozenByCode")
    public String frozenByCode(String codes, String equInfor) {
        try {

            String data = fdscOpeationService.frozenByCodes(codes, equInfor);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
//        return "success";
    }

    //调拨
    @ResponseBody
    @RequestMapping("allocationByRfid")
    public String allocationByRfid(String rfids, String equInfor) {
        try {

            String data = fdscOpeationService.allocationByRfids(rfids, equInfor);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
//        return "success";
    }

    @ResponseBody
    @RequestMapping("allocationByCode")
    public String allocationByCode(String codes, String equInfor) {
        try {

            String data = fdscOpeationService.allocationByCodes(codes, equInfor);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
//        return "success";
    }

    /**
     * 查询调拨
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("selectAllocationList")
    public Map<String, Object> selectAllocationList(HttpServletRequest request, @RequestParam(defaultValue = "1") String page, @RequestParam(defaultValue = "10") String pageSize
            , String productName, String color, String startTime, String endTime) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("productName", productName);
        params.put("color", color);
        if (!StringUtils.isEmpty(startTime))
            params.put("startTime", startTime + " 00:00:00");
        if (!StringUtils.isEmpty(endTime))
            params.put("endTime", endTime+" 23:59:59");
        Map<String, Object> map = fdscOpeationService.selectAllocation(Integer.valueOf(page), Integer.valueOf(pageSize), params);
        return map;
    }

    /**
     * 查询出库
     *
     * @param request
     * @param page
     * @param pageSize
     * @param productName
     * @param color
     * @param startTime
     * @param endTime
     * @return
     */
    @ResponseBody
    @RequestMapping("selectOutOfStockList")
    public Map<String, Object> selectOutOfStockList(HttpServletRequest request, @RequestParam(defaultValue = "1") String page, @RequestParam(defaultValue = "10") String pageSize
            , String productName, String color, String startTime, String endTime) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("productName", productName);
        params.put("color", color);
        if (!StringUtils.isEmpty(startTime))
            params.put("startTime", startTime + " 00:00:00");
        if (!StringUtils.isEmpty(endTime))
            params.put("endTime", endTime+" 23:59:59");
        Map<String, Object> map = fdscOpeationService.selectOutOfStock(Integer.valueOf(page), Integer.valueOf(pageSize), params);
        return map;
    }

    /**
     * 查询结算单
     *
     * @param page
     * @param pageSize
     * @param productName
     * @param startTime
     * @param endTime
     * @return
     */
    @ResponseBody
    @RequestMapping("selectSettlementList")
    public Map<String, Object> selectSettlementList(@RequestParam(defaultValue = "1") String page, @RequestParam(defaultValue = "10") String pageSize
            , String productName, String startTime, String endTime, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> params = new HashMap<String, Object>();
        if(!StringUtils.isEmpty(productName)){
            params.put("productName", "%"+productName+"%");
        }
        if (!StringUtils.isEmpty(startTime))
            params.put("startTime", startTime + " 00:00:00");
        if (!StringUtils.isEmpty(endTime))
            params.put("endTime", endTime+" 23:59:59");
        Map<String, Object> map = fdscOpeationService.findBySelectSettlement(Integer.valueOf(page), Integer.valueOf(pageSize), params);
        return map;
    }
}
