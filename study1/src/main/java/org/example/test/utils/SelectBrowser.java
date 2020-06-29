package org.example.test.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;

import java.util.Properties;

/**
 * @Description 根据平台选择不同的浏览器
 */
public class SelectBrowser {

    static Logger logger = Logger.getLogger(SelectBrowser.class.getName());

    public WebDriver selectExplorer(String browser, ITestContext context){
        if (browser.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        }
        return null;
    }

    public WebDriver selectExplorerByName(String browser, ITestContext context){
        // 获取系统属性集
        Properties props = System.getProperties();
        // 获取操作系统
        String currentPlatform = props.getProperty("os.name");
        logger.info("当前操作系统是[" + currentPlatform + "]");
        logger.info("启动的测试浏览器["+browser+"]");

        // 从testNG的配置文件读取参数driverConfigFilePath的值
        String driverConfigFilePath = context.getCurrentXmlTest().getParameter("driverConfigFilePath");

        // 声明驱动路径
        String chromedriver_win = PropertiesDateProvider.getTestData(driverConfigFilePath, "chromedriver_win");
        System.out.println(chromedriver_win);
        String chromedriver_linux = PropertiesDateProvider.getTestData(driverConfigFilePath, "chromedriver_linux");
        String chromedriver_mac = PropertiesDateProvider.getTestData(driverConfigFilePath, "chromedriver_mac");
        String ghostdriver_win = PropertiesDateProvider.getTestData(driverConfigFilePath, "ghostdriver_win");
        String iedriver = PropertiesDateProvider.getTestData(driverConfigFilePath, "iedriver");

        if (currentPlatform.toLowerCase().contains("win")){
            if (browser.equalsIgnoreCase("ie")){
                System.setProperty("webdriver.ie.driver", iedriver);
                // 设置IE浏览器常规设置，便于执行自动化测试
                DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
                ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                return new InternetExplorerDriver(ieCapabilities);
            }else if (browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", chromedriver_win);
                return new ChromeDriver();
            }else if (browser.equalsIgnoreCase("firefox")){
                return new FirefoxDriver();
            }else if (browser.equalsIgnoreCase("ghost")){
                DesiredCapabilities ghostCapabilities = new DesiredCapabilities();
                ghostCapabilities.setJavascriptEnabled(true);
                ghostCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, ghostdriver_win);
                return new PhantomJSDriver(ghostCapabilities);
            }else {
                logger.error("The["+browser+"] explorer is not applicable for ["+currentPlatform+"] os");
                Assert.fail("The [" + browser + "] explorer dest not apply to [ " +currentPlatform+ " ] OS");
            }
        }else if (currentPlatform.toLowerCase().contains("linux")){
            if (browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", chromedriver_linux);
                return new ChromeDriver();
            }else if (browser.equalsIgnoreCase("firefox")){
                return new FirefoxDriver();
            }else {
                logger.error("The["+browser+"] explorer is not applicable for ["+currentPlatform+"] os");
                Assert.fail("The [" + browser + "] explorer dest not apply to [ " +currentPlatform+ " ] OS");
            }
        }else if (currentPlatform.toLowerCase().contains("mac")){
            if (browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", chromedriver_mac);
                return new ChromeDriver();
            }else if (browser.equalsIgnoreCase("firefox")){
                return new FirefoxDriver();
            }else {
                logger.error("The["+browser+"] explorer is not applicable for ["+currentPlatform+"] os");
                Assert.fail("The [" + browser + "] explorer dest not apply to [ " +currentPlatform+ " ] OS");
            }
        }else
            logger.error("The ["+currentPlatform+"] is not supported for this automation frame, please change the OS(Windows, MAC, or Linux)");
        Assert.fail("The ["+currentPlatform+"] is not supported for this automation frame, please change the OS(Windows, MAC, or Linux)");
        return null;
    }
}
