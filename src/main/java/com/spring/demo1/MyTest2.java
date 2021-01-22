package com.spring.demo1;

import com.spring.demo1.controller.UserController;
import com.spring.demo1.service.UserService;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2021/1/21 15:23
 */
public class MyTest2 {

    @Test
    public void test(){
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        //获取所有的属性值
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            String name = field.getName();
            MyAutoWired annotation = field.getAnnotation(MyAutoWired.class);
            if(annotation!=null){
                field.setAccessible(true);
                //获取属性类型
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();
                    field.set(userController,o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(userController.getUserService());
    }
}
