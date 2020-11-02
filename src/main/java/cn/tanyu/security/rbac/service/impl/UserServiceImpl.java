package cn.tanyu.security.rbac.service.impl;

import cn.tanyu.security.rbac.entity.User;
import cn.tanyu.security.rbac.mapper.UserMapper;
import cn.tanyu.security.rbac.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tanyu
 * @since 2020-10-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
