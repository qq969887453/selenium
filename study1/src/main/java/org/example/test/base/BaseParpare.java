package org.example.test.base;


import org.apache.log4j.Logger;
import org.example.test.utils.SeleniumUtil;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

public class BaseParpare {
    static Logger logger = Logger.getLogger(BaseParpare.class.getName());
    protected SeleniumUtil seleniumUtil = null;
    protected ITestContext testContext = null;

    /**
     * @param context
     * 启动浏览器打开测试页面
     */
    @BeforeClass
    public void startTest(ITestContext context){
        seleniumUtil = new SeleniumUtil();
        this.testContext = context;
        String browserName = context.getCurrentXmlTest().getParameter("browserName");
    }
}
