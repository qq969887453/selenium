package org.example.test.cases.login;

import org.apache.log4j.Logger;
import org.example.test.base.BaseParpare;
import org.example.test.pagehelper.RegisterPageHelper;
import org.example.data.pojo.RegisterUser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPage_002_RegisterSuccessFunction_Test extends BaseParpare {
    public static final Logger logger = Logger.getLogger(RegisterPage_002_RegisterSuccessFunction_Test.class.getName());

    @Test
    public void registerSuccessFunction(){
        //进入到注册明细页面
        RegisterPageHelper.clickRegister(seleniumUtil, timeOut);
        RegisterUser user = new RegisterUser("zhangsan","123456","123456",
                "zhang", "san","shenzhen","nanshan");
        RegisterPageHelper.register(seleniumUtil, timeOut,user);
    }

    @DataProvider(name = "registerDate")
    public Object[][] data(){
        return new Object[][]{
                {"zhangsan","123456","123456","zhang","san","shenzhen","nanshan"},
                {"lisi","123457","123457","li","si","shenzhen","longhua"},
                {"wangwu","123458","123458","wang","wu","shenzhen","longgang"},
                {"zhaoliu","123459","123459","zhao","liu","shenzhen","futian"},
                {"tianqi","666666","666666","tian","qi","shenzhen","baoan"}
        };
    }
}
