package org.example.test.cases.login;

import org.apache.log4j.Logger;
import org.example.test.base.BaseParpare;
import org.example.test.pagehelper.HomePageHelper;
import org.example.test.pagehelper.LoginPageHelper;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginPage_001_LoginSuccessFunction_Test extends BaseParpare {

    Logger logger = Logger.getLogger(LoginPage_001_LoginSuccessFunction_Test.class.getName());

    /**
     * 登录成功
     */
    //@Test(dataProvider = "testData")
    public void loginSuccessFunction(Map<String, String> data) {
        LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
        LoginPageHelper.typeLoginInfo(seleniumUtil, data.get("USERNAME"), data.get("PASSWORD"));
        HomePageHelper.waitHomePageLoad(seleniumUtil, timeOut);
        HomePageHelper.checkUsername(seleniumUtil, timeOut, data.get("USERNAME"));
    }

    /**
     * 用户名密码错误
     */
    public void loginFailureFunction(){
        LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
        LoginPageHelper.typeLoginInfo(seleniumUtil, "jojo1", "bean");
        seleniumUtil.pause(1000);
        HomePageHelper.checkLoginFailure(seleniumUtil, timeOut);
    }
}
