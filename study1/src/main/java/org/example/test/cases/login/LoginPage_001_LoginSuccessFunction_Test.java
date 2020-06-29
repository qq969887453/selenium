package org.example.test.cases.login;

import org.example.test.base.BaseParpare;
import org.example.test.page.FramePage;
import org.example.test.pagehelper.HomePageHelper;
import org.example.test.pagehelper.LoginPageHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginPage_001_LoginSuccessFunction_Test extends BaseParpare {

    /**
     * 登录成功
     */
    public void loginSuccessFunction() {
        LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
        LoginPageHelper.typeLoginInfo(seleniumUtil, "jojo", "bean");
        HomePageHelper.waitHomePageLoad(seleniumUtil, timeOut);
        HomePageHelper.checkUsername(seleniumUtil, timeOut, "jojo");
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
