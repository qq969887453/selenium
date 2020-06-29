package org.example.test.pagehelper;

import org.apache.log4j.Logger;
import org.example.test.page.FramePage;
import org.example.test.page.RegisterPage;
import org.example.test.utils.SeleniumUtil;

public class RegisterPageHelper {

    public static final Logger logger = Logger.getLogger(RegisterPageHelper.class.getName());

    public static void clickRegister(SeleniumUtil seleniumUtil, int timeOut){
        FramePageHelper.jumpIntoFrame(seleniumUtil,FramePage.FP_FRAME_BODY);
        FramePageHelper.jumpIntoFrame(seleniumUtil,FramePage.FP_FRAME_INFO);
        seleniumUtil.click(RegisterPage.RP_REGISTER_LINK);
    }
}
