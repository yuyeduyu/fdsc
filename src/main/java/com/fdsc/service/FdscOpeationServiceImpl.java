package com.fdsc.service;

import com.fdsc.dao.RfidNumberMapper;
import com.fdsc.dao.RfidtempMainMapper;
import com.fdsc.model.RfidNumber;
import com.fdsc.model.RfidtempMain;
import com.fdsc.util.PageUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FdscOpeationServiceImpl implements FdscOpeationService {

    @Resource
    RfidNumberMapper rfidNumberMapper;
    @Resource
    RfidtempMainMapper rfidtempMainMapper;

    public String findByRfid(String rfid) {
        try {
            List<RfidNumber> rlist = rfidNumberMapper.findByRfid(rfid);
            return new Gson().toJson(rlist);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String findByCode(String code) {
        String str = null;//把json转换为String
        try {
            List<RfidNumber> rlist = rfidNumberMapper.findByCode(code);
            return new Gson().toJson(rlist);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String findDJByRfid(String rfid) {
        String str = null;//把json转换为String
        RfidtempMain rfidtemp = new RfidtempMain();
        rfidtemp.setdJState("否");
        rfidtemp.setDongJ(BigDecimal.valueOf(0));
        try {
            List<RfidtempMain> rlist = rfidtempMainMapper.findByRfid(rfid);
            for (RfidtempMain rfidtempMain : rlist) {
                if (!StringUtils.isEmpty(rfidtempMain.getDongJ())) {
                    rfidtemp.setDongJ(rfidtempMain.getDongJ());
                }
                if (!StringUtils.isEmpty(rfidtempMain.getdJState())) {
                    rfidtemp.setdJState(rfidtempMain.getdJState());
                }
            }
            return new Gson().toJson(rfidtemp);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String findDJByCode(String code) {
        String str = null;//把json转换为String
        RfidtempMain rfidtemp = new RfidtempMain();
        rfidtemp.setdJState("否");
        rfidtemp.setDongJ(BigDecimal.valueOf(0));
        try {
            List<RfidtempMain> rlist = rfidtempMainMapper.findByCode(code);
            for (RfidtempMain rfidtempMain : rlist) {
                if (!StringUtils.isEmpty(rfidtempMain.getdJState())) {
                    rfidtemp.setdJState(rfidtempMain.getdJState());
                }
                if (!StringUtils.isEmpty(rfidtempMain.getDongJ())) {
                    rfidtemp.setDongJ(rfidtempMain.getDongJ());
                }
            }
            return new Gson().toJson(rfidtemp);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String findTBByCode(String code) {
        String str = null;//把json转换为String
        try {
            List<RfidtempMain> rlist = rfidtempMainMapper.findByCode(code);
            return new Gson().toJson(rlist);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String findTBByRfid(String rfid) {
        try {
            List<RfidtempMain> rlist = rfidtempMainMapper.findByRfid(rfid);
            return new Gson().toJson(rlist);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


    public String outGoing(String rfIds, String equInfor) {

        Gson gson = new Gson();
        List<String> rfIdList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        rfIdList = gson.fromJson(rfIds, type);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (String rfid : rfIdList) {
            /*List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByRfid(rfid);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.update(rfIdList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(rfid, null, "1", equInfor, null, null);
            } else {
            }*/

            Map<String, Object> map = new HashMap<String, Object>(3);
            map.put("info", equInfor);
            map.put("rfid", rfid);
            try {
                map.put("status", "1");
                rfidtempMainMapper.insertComing(rfid, "-1", equInfor);
                mapList.add(map);
            } catch (Exception e) {
                map.put("status", "2");
            }

        }
//        return mapList;
        return new Gson().toJson(mapList);
    }

    public String outGoingCode(String codes, String equInfor) {
        Gson gson = new Gson();

        List<String> codeList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        codeList = gson.fromJson(codes, type);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (String code : codeList) {
            /*List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByCode(code);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.updateCode(codeList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(null, code, "1", equInfor, null, null);
            } else {
            }*/


            Map<String, Object> map = new HashMap<String, Object>(3);
            map.put("info", equInfor);
            map.put("code", code);
            try {
                map.put("status", "1");
                rfidtempMainMapper.insertCodeComing(code, "-1", equInfor);
                mapList.add(map);
            } catch (Exception e) {
                map.put("status", "2");
            }

        }
//        return mapList;
        return new Gson().toJson(mapList);
    }

    public String inComing(String rfIds, String equInfor) {
        Gson gson = new Gson();
        List<String> rfIdList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        rfIdList = gson.fromJson(rfIds, type);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (String rfid : rfIdList) {
            /*List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByRfid(rfid);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.update(rfIdList, "1",equInfor,null,null);
                rfidtempMainMapper.editEntity(rfid, null, "1", equInfor, null, null);
            } else {
            }*/

            Map<String, Object> map = new HashMap<String, Object>(3);
            map.put("info", equInfor);
            map.put("rfid", rfid);
            try {
                map.put("status", "1");
                rfidtempMainMapper.activation(rfid, "2", equInfor);
                mapList.add(map);
            } catch (Exception e) {
                map.put("status", "2");
            }
        }
//        return mapList;
        return new Gson().toJson(mapList);
    }

    public String inComingCode(String codes, String equInfor) {
        Gson gson = new Gson();

        List<String> codeList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        codeList = gson.fromJson(codes, type);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (String code : codeList) {
            /*List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByCode(code);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.updateCode(codeList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(null, code, "1", equInfor, null, null);
            } else {
            }*/
            Map<String, Object> map = new HashMap<String, Object>(3);
            map.put("info", equInfor);
            map.put("code", code);
            try {
                map.put("status", "1");
                rfidtempMainMapper.activationCode(code, "2", equInfor);
                mapList.add(map);
            } catch (Exception e) {
                map.put("status", "2");
            }

        }
//        return mapList;
        return new Gson().toJson(mapList);
    }


    public void inventoryRfid(String rfIds, String equInfor) {
        Gson gson = new Gson();
        List<String> rfIdList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        rfIdList = gson.fromJson(rfIds, type);
        rfidtempMainMapper.insert(rfIdList, equInfor);
    }

    public void inventoryCode(String codes, String equInfor) {
        Gson gson = new Gson();

        List<String> codeList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        codeList = gson.fromJson(codes, type);
        rfidtempMainMapper.insertCode(codeList, equInfor);
    }

    public String frozenByRfids(String rfIds, String equInfor) {
        Gson gson = new Gson();
        List<String> rfIdList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        rfIdList = gson.fromJson(rfIds, type);
        //rfidtempMainMapper.update(rfIdList, null, equInfor, "1", null);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (String rfId : rfIdList) {
            Map<String, Object> map = new HashMap<String, Object>(3);
            map.put("info", equInfor);
            map.put("rfId", rfId);
            try {
                map.put("status", "1");
                rfidtempMainMapper.addEntity(rfId, null, null, equInfor, "1", null);
                mapList.add(map);
            } catch (Exception e) {
                map.put("status", "2");
            }

            /*List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByRfid(rfId);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.updateCode(codeList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(rfId, null, null, equInfor, "1", null);
            } else {
            }*/

        }
        return new Gson().toJson(mapList);
//        return mapList;
    }

    public String frozenByCodes(String codes, String equInfor) {
        Gson gson = new Gson();

        List<String> codeList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        codeList = gson.fromJson(codes, type);
        //rfidtempMainMapper.updateCode(codeList, null, null, "1", null);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (String code : codeList) {
            /*List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByCode(code);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.updateCode(codeList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(null, code, null, equInfor, "1", null);
            } else {
            }*/

            Map<String, Object> map = new HashMap<String, Object>(3);
            map.put("info", equInfor);
            map.put("code", code);
            try {
                map.put("status", "1");
                rfidtempMainMapper.addEntity(null, code, null, equInfor, "1", null);
                mapList.add(map);
            } catch (Exception e) {
                map.put("status", "2");
            }

        }
//        return mapList;
        return new Gson().toJson(mapList);
    }

    public String allocationByRfids(String rfIds, String equInfor) {
        Gson gson = new Gson();
        List<String> rfIdList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        rfIdList = gson.fromJson(rfIds, type);
        //rfidtempMainMapper.update(rfIdList, null, null, null, "1");
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (String rfId : rfIdList) {
          /*  List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByRfid(rfId);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.updateCode(codeList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(rfId, null, null, equInfor, null, "1");
            } else {
            }*/

            Map<String, Object> map = new HashMap<String, Object>(3);
            map.put("info", equInfor);
            map.put("rfId", rfId);
            try {
                map.put("status", "1");
                rfidtempMainMapper.addEntity(rfId, null, null, equInfor, null, "1");
                mapList.add(map);
            } catch (Exception e) {
                map.put("status", "2");
            }

        }
//        return mapList;
        return new Gson().toJson(mapList);
    }

    public String allocationByCodes(String codes, String equInfor) {
        Gson gson = new Gson();

        List<String> codeList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        codeList = gson.fromJson(codes, type);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (String code : codeList) {
            /*List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByCode(code);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.updateCode(codeList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(null, code, null, equInfor, null, "1");
            } else {
            }*/

            Map<String, Object> map = new HashMap<String, Object>(3);
            map.put("info", equInfor);
            map.put("code", code);
            try {
                map.put("status", "1");
                rfidtempMainMapper.addEntity(null, code, null, equInfor, null, "1");
                mapList.add(map);
            } catch (Exception e) {
                map.put("status", "2");
            }

        }
//        return mapList;
        return new Gson().toJson(mapList);
        //rfidtempMainMapper.updateCode(codeList, null, null, null, "1");
    }

    public Map<String, Object> selectAllocation(int page, int pageSize, Map<String, Object> param) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String,Object>> rfidNumberList = rfidNumberMapper.findBySelectKctbmx(param);
        if (rfidNumberList!=null&&rfidNumberList.size()>0) {
            map.put("list", PageUtil.getPage(rfidNumberList, page, pageSize));
            map.put("count", rfidNumberList.size());
            map.put("pages", rfidNumberList.size()%pageSize>0?(rfidNumberList.size()/pageSize+1):(rfidNumberList.size()/pageSize));
        }else{
            map.put("list",null);
            map.put("count", 0);
            map.put("pages", 0);
        }
        return map;
    }
    public Map<String, Object> selectOutOfStock(int page, int pageSize, Map<String, Object> param) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String,Object>> rfidNumberList = rfidNumberMapper.findBySelectSpckdmx(param);
        if (rfidNumberList!=null&&rfidNumberList.size()>0) {
            map.put("list", PageUtil.getPage(rfidNumberList, page, pageSize));
            map.put("count", rfidNumberList.size());
            map.put("pages", rfidNumberList.size()%pageSize>0?(rfidNumberList.size()/pageSize+1):(rfidNumberList.size()/pageSize));
        }else{
            map.put("count", 0);
            map.put("list",null);
            map.put("pages", 0);
        }
        return map;
    }
    public Map<String, Object> findBySelectSettlement(int page, int pageSize, Map<String, Object> param) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String,Object>> rfidNumberList = rfidNumberMapper.findBySelectSettlement(param);
        if (rfidNumberList!=null&&rfidNumberList.size()>0) {
            map.put("list", PageUtil.getPage(rfidNumberList, page, pageSize));
            map.put("count", rfidNumberList.size());
            map.put("pages", rfidNumberList.size()%pageSize>0?(rfidNumberList.size()/pageSize+1):(rfidNumberList.size()/pageSize));
        }else{
            map.put("list",null);
            map.put("pages", 0);
            map.put("count", 0);
        }
        return map;
    }
}
