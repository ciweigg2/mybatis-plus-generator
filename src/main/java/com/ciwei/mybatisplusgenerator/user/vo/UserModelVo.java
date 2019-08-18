package com.ciwei.mybatisplusgenerator.user.vo;

import java.time.LocalDateTime;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.ciwei.mybatisplusgenerator.user.model.UserModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Ciwei
 * @date 2019-08-18
 * @jdk.version 1.8
 * @desc 用户表vo
 */
@ApiModel(value = "用户表vo" ,description = "只有努力才能不被辜负")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserModelVo extends UserModel implements Serializable {

    @ApiModelProperty(value = "测试字段")
    private String jyw;

    @ApiModelProperty(value = "测试字段2")
    private String jyw2;

    @ApiModelProperty(value = "测试字段3")
    private LocalDateTime jyw3;

}
