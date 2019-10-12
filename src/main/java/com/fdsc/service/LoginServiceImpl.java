package com.fdsc.service;

import com.fdsc.dao.RfiduserMapper;
import com.fdsc.model.Rfiduser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    RfiduserMapper rfiduserMapper;

    public String login(String name, String password) {
        List<Rfiduser> rfiduserList = rfiduserMapper.findByName(name);
        if (rfiduserList != null && rfiduserList.size() > 0) {
            Rfiduser rfiduser = rfiduserList.get(0);
            if (rfiduser.getPassword().equals(password)) {
                return "{success:true,msg:'登陆成功'}";
            }
            return "{success:false,msg:'密码错误，登陆失败'}";
        }
        return "{success:false,msg:'用户不存在，登陆失败'}";
    }
}
