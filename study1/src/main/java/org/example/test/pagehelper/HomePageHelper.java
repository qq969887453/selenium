package org.example.test.pagehelper;

import org.apache.log4j.Logger;
import org.example.test.page.FramePage;
import org.example.test.page.HomePage;
import org.example.test.utils.SeleniumUtil;

public class HomePageHelper {

    public static Logger logger = Logger.getLogger(HomePageHelper.class.getName());

    /**
     * @description 等待首页元素加载
     * @param seleniumUtil selenium api封装引用对象
     * @param timeOut 等待元素超时的时间
     * */
    public static void waitHomePageLoad(SeleniumUtil seleniumUtil,int timeOut){
        FramePageHelper.jumpOut(seleniumUtil);
        //等待body frame显示出来
        seleniumUtil.waitForElementToLoad(timeOut, FramePage.FP_FRAME_BODY);
        FramePageHelper.jumpIntoFrame(seleniumUtil, FramePage.FP_FRAME_BODY);//先进入到body frame中
        //等待navbar frame显示出来
        seleniumUtil.waitForElementToLoad(timeOut, FramePage.FP_FRAME_NAVBAR);
        FramePageHelper.jumpIntoFrame(seleniumUtil, FramePage.FP_FRAME_NAVBAR);//再进入body frame的子frame:navbar frame中
        logger.info("开始等待首页元素加载");
        seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_FLIGHTS);
        seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_ITINERARY);
        seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_HOME);
        seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_SIGNOFF);
        logger.info("首页元素加载完毕");
        FramePageHelper.jumpOut(seleniumUtil);

    }

    public static void checkUsername(SeleniumUtil seleniumUtil, int time, String username){
        FramePageHelper.jumpIntoFrame(seleniumUtil, FramePage.FP_FRAME_BODY);
        FramePageHelper.jumpIntoFrame(seleniumUtil, FramePage.FP_FRAME_INFO);
        logger.info("开始检查用户名"+username);
        seleniumUtil.isTextCorrect(seleniumUtil.getText(HomePage.HP_TEXT_USERNAME), username);
    }
}
