package org.example.test.cases.login;

import org.apache.log4j.Logger;
import org.example.test.base.BaseParpare;
import org.example.test.pagehelper.RegisterPageHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPage_002_RegisterSuccessFunction_Test extends BaseParpare {
    public static final Logger logger = Logger.getLogger(RegisterPage_002_RegisterSuccessFunction_Test.class.getName());

    @Test(dataProvider = "registerDate")
    public void registerSuccessFunction(){
        //进入到注册明细页面
        RegisterPageHelper.clickRegister(seleniumUtil, timeOut);
    }

    @DataProvider(name = "registerDate")
    public Object[][] data(){
        return new Object[][]{
                {"username","zhangsan"},
                {"password","123456"},
                {"confirmpassword","123456"},
        };
    }
}
