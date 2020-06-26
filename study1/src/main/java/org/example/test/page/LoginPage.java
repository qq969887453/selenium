package org.example.test.page;

import org.openqa.selenium.By;

public class LoginPage {

    /**
     * 登录页面输入框
     */
    public static final By LP_INPUT_USERNAME = By.name("username");

    /**
     * 登录页面密码输入框
     */
    public static final By LP_INPUT_PASSWORD = By.name("password");

    /**
     * 登录按钮
     */
    public static final By LP_BUTTON_LOGIN = By.name("login");

    /**
     * 登录错误信息
     */
    public static final By LP_TEXT_ERROR = By.xpath("//*[@color='red']");
}
