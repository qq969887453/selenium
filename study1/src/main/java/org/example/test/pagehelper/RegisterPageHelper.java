package org.example.test.pagehelper;

import org.apache.log4j.Logger;
import org.example.test.page.FramePage;
import org.example.test.page.RegisterPage;
import org.example.data.pojo.RegisterUser;
import org.example.test.utils.SeleniumUtil;

public class RegisterPageHelper {

    public static final Logger logger = Logger.getLogger(RegisterPageHelper.class.getName());

    /**
     * @param seleniumUtil
     * @param timeOut
     * @Description 切换到注册区域
     */
    public static void clickRegister(SeleniumUtil seleniumUtil, int timeOut){
        FramePageHelper.jumpIntoFrame(seleniumUtil,FramePage.FP_FRAME_BODY);
        FramePageHelper.jumpIntoFrame(seleniumUtil,FramePage.FP_FRAME_INFO);
        seleniumUtil.click(RegisterPage.RP_REGISTER_LINK);
    }

    public static void register(SeleniumUtil seleniumUtil, int timeOut, RegisterUser registerUser){
        logger.info("开始输入注册信息");
        seleniumUtil.type(RegisterPage.RP_REGISTER_USERNAME, registerUser.getUsername());
        seleniumUtil.type(RegisterPage.RP_REGISTER_PASSWORD, registerUser.getPassword());
        seleniumUtil.type(RegisterPage.RP_REGISTER_PASSWORD_CONFIRM, registerUser.getPasswordConfirm());
        seleniumUtil.type(RegisterPage.RP_REGISTER_FIRST_NAME, registerUser.getFirstName());
        seleniumUtil.type(RegisterPage.RP_REGISTER_LAST_NAME, registerUser.getLastName());
        seleniumUtil.type(RegisterPage.RP_REGISTER_ADDRESS, registerUser.getAddress1());
        seleniumUtil.type(RegisterPage.RP_REGISTER_CITY_STATE_ZIP, registerUser.getAddress2());
        seleniumUtil.click(RegisterPage.RP_REGISTER_BUTTON);
        logger.info("输入注册信息完成");
    }

    public static void register2(SeleniumUtil seleniumUtil, int timeOut, String username,
                                 String password, String passwordConfirm, String firstName,
                                 String lastName, String address1, String address2){
        logger.info("开始输入注册信息");
        seleniumUtil.type(RegisterPage.RP_REGISTER_USERNAME, username);
        seleniumUtil.type(RegisterPage.RP_REGISTER_PASSWORD, password);
        seleniumUtil.type(RegisterPage.RP_REGISTER_PASSWORD_CONFIRM, passwordConfirm);
        seleniumUtil.type(RegisterPage.RP_REGISTER_FIRST_NAME, firstName);
        seleniumUtil.type(RegisterPage.RP_REGISTER_LAST_NAME, lastName);
        seleniumUtil.type(RegisterPage.RP_REGISTER_ADDRESS, address1);
        seleniumUtil.type(RegisterPage.RP_REGISTER_CITY_STATE_ZIP, address2);
        seleniumUtil.click(RegisterPage.RP_REGISTER_BUTTON);
        logger.info("输入注册信息完成");
    }
}
