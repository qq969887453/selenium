package org.example.test.pagehelper;

import org.apache.log4j.Logger;
import org.example.test.page.FramePage;
import org.example.test.page.LoginPage;
import org.example.test.utils.SeleniumUtil;

/**
 * 登录页面帮助类
 */
public class LoginPageHelper {
    public static Logger logger = Logger.getLogger(LoginPageHelper.class.getName());

    /**
     * @param seleniumUtil
     * @param timeOut
     * @Description 等待页面加载
     */
    public static void waitLoginPageLoad(SeleniumUtil seleniumUtil, int timeOut){
        seleniumUtil.pause(1000);
        FramePageHelper.jumpIntoFrame(seleniumUtil, FramePage.FP_FRAME_BODY);
        FramePageHelper.jumpIntoFrame(seleniumUtil, FramePage.FP_FRAME_NAVBAR);

        logger.info("开始检查页面元素。");
        seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_INPUT_USERNAME);
        seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_INPUT_PASSWORD);
        seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_BUTTON_LOGIN);
        logger.info("检查登录页面元素完毕！");
    }

    /**
     * @param seleniumUtil
     * @param username
     * @param password
     * @description 登录操作
     */
    public static void typeLoginInfo(SeleniumUtil seleniumUtil, String username, String password){
        logger.info("开始输入登录信息");
        seleniumUtil.clear(LoginPage.LP_INPUT_USERNAME);
        seleniumUtil.type(LoginPage.LP_INPUT_USERNAME, username);
        seleniumUtil.clear(LoginPage.LP_INPUT_PASSWORD);
        seleniumUtil.type(LoginPage.LP_INPUT_PASSWORD, password);
        seleniumUtil.click(LoginPage.LP_BUTTON_LOGIN);
        logger.info("输入登录信息完毕");
    }
}
