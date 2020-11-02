package cn.tanyu.security.rbac.service.impl;

import cn.tanyu.security.rbac.entity.JwtUser;
import cn.tanyu.security.rbac.entity.Role;
import cn.tanyu.security.rbac.entity.User;
import cn.tanyu.security.rbac.entity.UserRole;
import cn.tanyu.security.rbac.service.IRoleService;
import cn.tanyu.security.rbac.service.IUserRoleService;
import cn.tanyu.security.rbac.service.IUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tanyu
 * @version 1.0
 * @description: TODO
 * @date 2020/10/29 9:04 上午
 */
@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("我被调用了");

        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, username));
        log.info(user.toString());

        JwtUser jwtUser = new JwtUser();
        BeanUtils.copyProperties(user, jwtUser);

        List<UserRole> userRoleList = userRoleService.list(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, user.getId()));
        List<Long> roleIds = userRoleList.stream()
                .map(UserRole::getRoleId)
                .collect(Collectors.toList());

        List<Role> roleList = roleService.list(Wrappers.<Role>lambdaQuery().in(Role::getId, roleIds));

        List<SimpleGrantedAuthority> authorities = roleList.stream().map(e -> new SimpleGrantedAuthority("ROLE_" + e.getName())).collect(Collectors.toList());
        jwtUser.setAuthorities(authorities);

        return jwtUser;

    }
}
