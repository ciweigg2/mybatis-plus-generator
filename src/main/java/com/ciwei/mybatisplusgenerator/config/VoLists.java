package com.ciwei.mybatisplusgenerator.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VoLists {

	/**
	 * 字段类型
	 */
	private String propertyType;

	/**
	 * 字段名
	 */
	private String propertyName;

	/**
	 * 字段注释
	 */
	private String comment;

}
