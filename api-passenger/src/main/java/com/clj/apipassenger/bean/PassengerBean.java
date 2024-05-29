package com.clj.apipassenger.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Author clj
 * @create 2024/5/29 15:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("t_passenger") // mybatis-plus 中 如果bean名和表名不一致 需要声明
public class PassengerBean {
    @TableId
    private int id;
    private String name;
    private String phone;
    private Date createDtm;
    private Date updateDtm;
}
