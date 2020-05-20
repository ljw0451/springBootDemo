package com.ljw.utils.shiro;

import com.ljw.entity.system.UserDto;
import com.ljw.mapper.system.SysResMapper;
import com.ljw.mapper.system.SysRoleMapper;
import com.ljw.service.system.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author : lijianwen
 * @Date : 2020-05-19
 * @Version : 1.0
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Autowired
    SysResMapper sysResMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserDto userInfo  = (UserDto)principal.getPrimaryPrincipal();
        sysRoleMapper.findRoleByUsername(userInfo.getUserName()).stream().forEach(
                sysRole -> {
                    authorizationInfo.addRole(sysRole.getRoleName());
                    sysResMapper.findPermissionByRoleId(sysRole.getRoleId()).stream().forEach(
                            sysPermission -> {
                                authorizationInfo.addStringPermission(sysPermission.getResName());
                            }
                    );
                }
        );
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserDto userInfo = userInfoService.findByUsername(username);
        System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            ////没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
//                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
