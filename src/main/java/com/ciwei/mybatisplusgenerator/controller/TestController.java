package com.ciwei.mybatisplusgenerator.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ciwei.mybatisplusgenerator.ciwei.model.AsdCiweiModel;
import com.ciwei.mybatisplusgenerator.ciwei.service.IAsdCiweiService;
import com.ciwei.mybatisplusgenerator.user.model.UserModel;
import com.ciwei.mybatisplusgenerator.user.service.IUserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IAsdCiweiService asdCiweiService;

	/**
	 * 页码下标
	 */
	private Integer pageIndex = 1;

	/**
	 * 每页数量
	 */
	private Integer pageSize = 2;

	@RequestMapping(value = "lists")
	public <T> List<T> lists() {
		LambdaQueryWrapper<AsdCiweiModel> lambdaQueryWrapper = new QueryWrapper<AsdCiweiModel>().lambda()
				.eq(AsdCiweiModel::getId ,3);
		List<AsdCiweiModel> asdCiweiModels = asdCiweiService.list(lambdaQueryWrapper);
		System.out.println(asdCiweiService.listByIds(Lists.newArrayList("1" ,"2")));
		//0和1都代表从第一条开始取2条 页码2数量2那就是从第三条开始取也就是3和4的记录 以此类推的呀
		IPage<UserModel> iPage = userService.page(new Page(pageIndex, pageSize));
		List<UserModel> userModels = iPage.getRecords();
		for (UserModel userModel : userModels) {
			System.out.println(userModel.getName());
		}
		return (List<T>) userService.list();
	}

}
