package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors
public class UserInfo {
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bir;
    private String sex;
    private String address;
}