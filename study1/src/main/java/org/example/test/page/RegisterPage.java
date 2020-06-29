package org.example.test.page;

import org.openqa.selenium.By;

public class RegisterPage {
    //注册链接/html/body/table/tbody/tr[3]/td[1]/blockquote/a[1]/b
    public static final By RP_REGISTER_LINK = By.xpath("//a[1]/b");

    // 注册页面用户名
    public static final By RP_REGISTER_USERNAME = By.name("username");

    // 注册页面密码
    public static final By RP_REGISTER_PASSWORD = By.name("password");

    // 注册页面确认密码
    public static final By RP_REGISTER_PASSWORD_CONFIRM = By.name("passwordConfirm");

    // 注册页面firstName
    public static final By RP_REGISTER_FIRST_NAME = By.name("firstName");

    // 注册页面lastName
    public static final By RP_REGISTER_LAST_NAME = By.name("lastName");

    //Street Address
    public static final By RP_REGISTER_ADDRESS = By.name("address1");

    //City/State/Zip
    public static final By RP_REGISTER_CITY_STATE_ZIP = By.name("address2");

    // 登录按钮
    public static final By RP_REGISTER_BUTTON = By.xpath("//*[@src='/WebTours/images/button_next.gif']");
}
