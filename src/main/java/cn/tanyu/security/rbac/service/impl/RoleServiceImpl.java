package cn.tanyu.security.rbac.service.impl;

import cn.tanyu.security.rbac.entity.Role;
import cn.tanyu.security.rbac.mapper.RoleMapper;
import cn.tanyu.security.rbac.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
