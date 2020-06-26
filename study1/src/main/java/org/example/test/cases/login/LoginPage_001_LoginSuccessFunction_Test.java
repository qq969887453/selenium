package org.example.test.cases.login;

import org.example.test.base.BaseParpare;
import org.example.test.pagehelper.HomePageHelper;
import org.example.test.pagehelper.LoginPageHelper;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginPage_001_LoginSuccessFunction_Test extends BaseParpare {

    @Test
    public void loginSuccessFunction(Map<String, String> data) {
        LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
        LoginPageHelper.typeLoginInfo(seleniumUtil, "jojo", "bean");
        HomePageHelper.waitHomePageLoad(seleniumUtil, timeOut);
        HomePageHelper.checkUsername(seleniumUtil, timeOut, "jojo");
    }
}
