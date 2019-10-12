/*
package com.fdsc.service;

import com.fdsc.dao.RfidNumberMapper;
import com.fdsc.dao.RfidtempMainMapper;
import com.fdsc.model.RfidNumber;
import com.fdsc.model.RfidtempMain;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpeationServiceImpl implements FdscOpeationService {

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

    public void outGoing(String rfIds, String equInfor) {

        Gson gson = new Gson();
        List<String> rfIdList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        rfIdList = gson.fromJson(rfIds, type);
        for (String rfid : rfIdList) {
            List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByRfid(rfid);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.update(rfIdList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(rfid, null, "1", equInfor, null, null);
            } else {
                rfidtempMainMapper.insertComing(rfid, "-1", equInfor);
            }
        }

    }

    public void outGoingCode(String codes, String equInfor) {
        Gson gson = new Gson();

        List<String> codeList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        codeList = gson.fromJson(codes, type);
        for (String code : codeList) {
            List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByCode(code);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.updateCode(codeList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(null, code, "1", equInfor, null, null);
            } else {
                rfidtempMainMapper.insertCodeComing(code, "-1", equInfor);
            }
        }
    }

    public void inComing(String rfIds, String equInfor) {
        Gson gson = new Gson();
        List<String> rfIdList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        rfIdList = gson.fromJson(rfIds, type);
        for (String rfid : rfIdList) {
            List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByRfid(rfid);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.update(rfIdList, "1",equInfor,null,null);
                rfidtempMainMapper.editEntity(rfid, null, "1", equInfor, null, null);
            } else {
                rfidtempMainMapper.insertComing(rfid, "1", equInfor);
            }
        }
    }

    public void inComingCode(String codes, String equInfor) {
        Gson gson = new Gson();

        List<String> codeList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        codeList = gson.fromJson(codes, type);
        for (String code : codeList) {
            List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByCode(code);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.updateCode(codeList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(null, code, "1", equInfor, null, null);
            } else {
                rfidtempMainMapper.insertCodeComing(code, "1", equInfor);
            }
        }
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

    public void frozenByRfids(String rfIds, String equInfor) {
        Gson gson = new Gson();
        List<String> rfIdList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        rfIdList = gson.fromJson(rfIds, type);
        //rfidtempMainMapper.update(rfIdList, null, equInfor, "1", null);
        for (String rfId : rfIdList) {
            List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByRfid(rfId);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.updateCode(codeList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(rfId, null, null, equInfor, "1", null);
            } else {
                rfidtempMainMapper.addEntity(rfId, null, null, equInfor, "1", null);
            }
        }
    }

    public void frozenByCodes(String codes, String equInfor) {
        Gson gson = new Gson();

        List<String> codeList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        codeList = gson.fromJson(codes, type);
        //rfidtempMainMapper.updateCode(codeList, null, null, "1", null);
        for (String code : codeList) {
            List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByCode(code);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.updateCode(codeList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(null, code, null, equInfor, "1", null);
            } else {
                rfidtempMainMapper.addEntity(null, code, null, equInfor, "1", null);
            }
        }
    }

    public void allocationByRfids(String rfIds, String equInfor) {
        Gson gson = new Gson();
        List<String> rfIdList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        rfIdList = gson.fromJson(rfIds, type);
        //rfidtempMainMapper.update(rfIdList, null, null, null, "1");
        for (String rfId : rfIdList) {
            List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByRfid(rfId);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.updateCode(codeList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(rfId, null, null, equInfor, null, "1");
            } else {
                rfidtempMainMapper.addEntity(rfId, null, null, equInfor, null, "1");
            }
        }
    }

    public void allocationByCodes(String codes, String equInfor) {
        Gson gson = new Gson();

        List<String> codeList = new ArrayList<String>();

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();

        codeList = gson.fromJson(codes, type);
        for (String code : codeList) {
            List<RfidtempMain> rfidtempMains = rfidtempMainMapper.findByCode(code);
            if (rfidtempMains != null && rfidtempMains.size() > 0) {
                //rfidtempMainMapper.updateCode(codeList, "-1",equInfor,null,null);
                rfidtempMainMapper.editEntity(null, code, null, equInfor, null, "1");
            } else {
                rfidtempMainMapper.addEntity(null, code, null, equInfor, null, "1");
            }
        }
        //rfidtempMainMapper.updateCode(codeList, null, null, null, "1");
    }
}
*/
