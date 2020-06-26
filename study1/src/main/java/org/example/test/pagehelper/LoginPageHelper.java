package org.example.test.pagehelper;

import org.apache.log4j.Logger;
import org.example.test.page.LoginPage;
import org.example.test.utils.SeleniumUtil;

/**
 * 登录页面帮助类
 */
public class LoginPageHelper {
    public static Logger logger = Logger.getLogger(LoginPageHelper.class.getName());

    /**
     * @param seleniumUtil
     * @param username
     * @param password
     * @description 登录操作
     */
    public static void typeLoginInfo(SeleniumUtil seleniumUtil, String username, String password){
        logger.info("开始输入登录信息");
        seleniumUtil.clear(LoginPage.LP_INPUT_EMAIL);
        seleniumUtil.type(LoginPage.LP_INPUT_EMAIL, username);
        seleniumUtil.clear(LoginPage.LP_INPUT_PASSWORD);
        seleniumUtil.type(LoginPage.LP_INPUT_PASSWORD, password);
        seleniumUtil.click(LoginPage.LP_BUTTON_LOGIN);
    }
}
