package org.example.test.pagehelper;

import org.example.test.utils.SeleniumUtil;
import org.openqa.selenium.By;

public class FramePageHelper {
    /**
     * @param seleniumUtil
     * @param by
     * @Description 根据Frame元素定位进入到Frame
     */
    public static void jumpIntoFrame(SeleniumUtil seleniumUtil, By by){
        seleniumUtil.switchFrame(seleniumUtil.findElementBy(by));
    }

    /**
     * @param seleniumUtil
     * @Description 回到默认的frame
     */
    public static void jumpOut(SeleniumUtil seleniumUtil){
        seleniumUtil.outFrame();
    }

    /**
     * @param seleniumUtil
     * @Description 回退
     */
    public static void jumpParentFrame(SeleniumUtil seleniumUtil){
        seleniumUtil.parentFrame();
    }
}
