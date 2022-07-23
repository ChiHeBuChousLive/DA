package com.codermy.myspringsecurityplus;

import com.codermy.myspringsecurityplus.admin.dao.DeptDao;
import com.codermy.myspringsecurityplus.admin.dao.UserDao;
import com.codermy.myspringsecurityplus.admin.dto.DeptDto;
import com.codermy.myspringsecurityplus.admin.entity.MyUser;
import com.codermy.myspringsecurityplus.admin.service.UserService;
import com.codermy.myspringsecurityplus.common.utils.TreeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/8/22
 */
@SpringBootTest
public class test {
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;


    @Test
    public void a(){
        List<DeptDto> selectRoleDeptTree = deptDao.selectRoleDeptTree(2);
        System.out.println(selectRoleDeptTree);
        DeptDto deptDto = new DeptDto();
        List<DeptDto> buildAll = deptDao.buildAll(deptDto);
        System.out.println(buildAll);
        List<DeptDto> tree = TreeUtil.deptTree(selectRoleDeptTree, buildAll);
        System.out.println(tree);
        //checkphontunique测试
        MyUser myUser=new MyUser();
        myUser.setUserId(1);
        myUser.setEmail("1454564646@qq.com");
        myUser.setPhone("c");
        System.out.println("===================================");
        System.out.println(userService.checkPhoneUnique(myUser));
        //userdao测试
        System.out.println("====================");
        System.out.println(userDao.checkUserEmailUnique("2631916781@qq.com"));


    }
}
