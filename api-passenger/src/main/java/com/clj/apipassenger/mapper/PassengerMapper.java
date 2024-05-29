package com.clj.apipassenger.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clj.apipassenger.bean.PassengerBean;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Author clj
 * @create 2024/5/29 15:39
 */
@Repository
public interface PassengerMapper extends BaseMapper<PassengerBean> {
    List<PassengerBean> selectByMap(HashMap<String, String> phoneMap);
}
