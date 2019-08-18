package com.ciwei.mybatisplusgenerator.ciwei.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Ciwei
 * @since 2019-08-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("asd_ciwei")
public class AsdCiweiModel implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;


}
