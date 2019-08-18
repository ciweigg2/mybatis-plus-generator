package com.ciwei.mybatisplusgenerator.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ciwei.mybatisplusgenerator.user.mapper.UserMapper;
import com.ciwei.mybatisplusgenerator.user.model.UserModel;
import com.ciwei.mybatisplusgenerator.user.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Ciwei
 * @since 2019-08-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserModel> implements IUserService {

}
