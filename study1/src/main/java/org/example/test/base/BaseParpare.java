package org.example.test.base;


import org.apache.log4j.Logger;
import org.example.test.utils.SeleniumUtil;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseParpare {
    static Logger logger = Logger.getLogger(BaseParpare.class.getName());
    protected SeleniumUtil seleniumUtil = null;
    protected ITestContext testContext = null;
    protected int sleepTime = 0;
    protected int timeOut = 0;
    protected String webUrl = "";
    protected int waitMillisecondsForAlert = 0;

    /**
     * @param context
     * 启动浏览器打开测试页面
     */
    @BeforeClass
    public void startTest(ITestContext context){
        seleniumUtil = new SeleniumUtil();
        this.testContext = context;
        String browserName = context.getCurrentXmlTest().getParameter("browserName");
        System.out.println(browserName+"browserName");
        webUrl = context.getCurrentXmlTest().getParameter("testurl");
        timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
        sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
        waitMillisecondsForAlert = Integer.valueOf(context.getCurrentXmlTest().getParameter("waitMillisecondsForAlert"));
        try{
            seleniumUtil.launchBrowser(browserName, context, webUrl, timeOut);
        }catch (Exception e){
            logger.error("浏览器启动异常！");
        }
        testContext.setAttribute("SELENIUM_DRIVER", seleniumUtil.driver);
    }

    @AfterClass
    public void endTest(){
        if (seleniumUtil.driver != null){
            seleniumUtil.quit();
        }else {
            logger.error("浏览器driver没有获取对象，退出失败");
            Assert.fail("浏览器driver没有获取对象，退出失败");
        }
    }

    @Test
    public void test(){

    }
}
