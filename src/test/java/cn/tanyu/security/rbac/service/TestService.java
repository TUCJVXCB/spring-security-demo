package cn.tanyu.security.rbac.service;

import cn.tanyu.security.rbac.entity.JwtUser;
import cn.tanyu.security.rbac.entity.Role;
import cn.tanyu.security.rbac.entity.User;
import cn.tanyu.security.rbac.entity.UserRole;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tanyu
 * @version 1.0
 * @description: TODO
 * @date 2020/10/29 9:33 上午
 */
@SpringBootTest
public class TestService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IRoleService roleService;

    @Test
    public void test() {
        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, "123456"));

        JwtUser jwtUser = new JwtUser();
        BeanUtils.copyProperties(user, jwtUser);

        List<UserRole> userRoleList = userRoleService.list(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, user.getId()));
        List<Long> roleIds = userRoleList.stream()
                .map(UserRole::getRoleId)
                .collect(Collectors.toList());

        List<Role> roleList = roleService.list(Wrappers.<Role>lambdaQuery().eq(Role::getId, roleIds));

        List<SimpleGrantedAuthority> authorities = roleList.stream().map(e -> new SimpleGrantedAuthority("ROLE_" + e.getName())).collect(Collectors.toList());
        jwtUser.setAuthorities(authorities);

        System.out.println(jwtUser);
    }
}
