package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dingdan {
    private long dId;
    private String userName;
    private String beneficiary;
    private String subject;
    private Timestamp payTime;
    private String orderNumber;
    private Integer tradeStatus;
}
