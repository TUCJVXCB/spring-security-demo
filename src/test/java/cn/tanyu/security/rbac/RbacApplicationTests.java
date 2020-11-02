package cn.tanyu.security.rbac;

import cn.tanyu.security.rbac.entity.JwtUser;
import cn.tanyu.security.rbac.entity.Role;
import cn.tanyu.security.rbac.entity.User;
import cn.tanyu.security.rbac.entity.UserRole;
import cn.tanyu.security.rbac.service.IRoleService;
import cn.tanyu.security.rbac.service.IUserRoleService;
import cn.tanyu.security.rbac.service.IUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class RbacApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    public void test() {

    }

}
