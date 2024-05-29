package com.clj.apipassenger.service;

import com.clj.apipassenger.bean.PassengerBean;
import com.clj.apipassenger.mapper.PassengerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author clj
 * @create 2024/5/29 15:59
 */
@Service
public class LoginService {
    @Autowired
    private PassengerMapper passengerMapper;

    /**
     * 查询乘客是否存在
     * */
    public boolean passengerIsExsits(String phone){
        HashMap<String,String> phoneMap = new HashMap();
        phoneMap.put("phone",phone);
        List<PassengerBean> passengerBeans = passengerMapper.selectByMap(phoneMap);
        if (passengerBeans.size() > 0){
            for (PassengerBean pb :
                    passengerBeans) {
                System.out.println(pb);
            }
            return true;
        }else {
            return false;
        }
    }

    /**
     * 插入乘客
     * */
    public int insertPassenger(PassengerBean passengerBean){
        return passengerMapper.insert(passengerBean);
    }

}
