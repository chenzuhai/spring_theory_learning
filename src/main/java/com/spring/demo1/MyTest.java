package com.spring.demo1;


import com.spring.demo1.controller.UserController;
import com.spring.demo1.service.UserService;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2021/1/21 15:07
 */
public class MyTest {

    @Test
    public void test() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        //创建对象
        UserService userService = new UserService();
        //获取所有属性
        Field serviceField = clazz.getDeclaredField("userService");
        serviceField.setAccessible(true);
        //通过方法才能设置具体的数性质
        String name = serviceField.getName();
        //拼接方法名称
        name = name.substring(0,1).toUpperCase()+name.substring(1,name.length());
        String setMethodName = "set"+name;
        //通过方法注入属性对象
        Method method = clazz.getMethod(setMethodName, UserService.class);
        method.invoke(userController,userService);
        System.out.println(userController.getUserService());
    }
}
