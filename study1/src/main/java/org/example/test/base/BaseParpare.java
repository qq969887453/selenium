package org.example.test.base;

import org.apache.log4j.Logger;
import org.example.test.utils.ExcelDataProvider;
import org.example.test.utils.LogConfiguration;
import org.example.test.utils.SeleniumUtil;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.*;

public class BaseParpare {
    static {
        LogConfiguration.initLog("BaseParparePage_");
    }
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
        logger.info("开始启动浏览器!");
        seleniumUtil = new SeleniumUtil();
        this.testContext = context;
        String browserName = context.getCurrentXmlTest().getParameter("browserName");
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

    /**
     * @moduleName 测试用例的包名
     * @caseNum 用例编号
     * @description 如：org.example.test.cases.login.LoginPage_001_LoginSuccessFunction_Test
     *               moduleName = className.substring(24, className.lastIndexOf("."));   ==》 login
     *               className.substring(underlineIndexNum + 1, underlineIndexNum + 4);  ==>  001
     * @return
     */
    @DataProvider(name = "testData")
    public Iterator<Object[]> dataForTestMethod(){
        String moduleName = null;
        String caseNum = null;
        String className = this.getClass().getName();
        int dotIndexNum = className.indexOf(".");
        int underlineIndexNum = className.indexOf("_");
        if (dotIndexNum > 0){
            moduleName = className.substring(23, className.lastIndexOf("."));
        }
        if (underlineIndexNum > 0){
            caseNum = className.substring(underlineIndexNum + 1, underlineIndexNum + 4);
        }
        return new ExcelDataProvider(moduleName, caseNum);
    }
}
