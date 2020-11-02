package cn.tanyu.security.rbac.service.impl;

import cn.tanyu.security.rbac.entity.UserRole;
import cn.tanyu.security.rbac.mapper.UserRoleMapper;
import cn.tanyu.security.rbac.service.IUserRoleService;
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
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
