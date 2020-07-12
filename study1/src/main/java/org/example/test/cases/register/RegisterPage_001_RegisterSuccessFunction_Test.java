package org.example.test.cases.register;

import org.apache.log4j.Logger;
import org.example.test.base.BaseParpare;
import org.example.test.pagehelper.RegisterPageHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

class RegisterPage_001_RegisterSuccessFunction_Test extends BaseParpare {
    public static final Logger logger = Logger.getLogger(RegisterPage_001_RegisterSuccessFunction_Test.class.getName());

    @Test(dataProvider = "data")
    public void registerSuccessFunction(Map<Object, Object> data){
        //进入到注册明细页面
        RegisterPageHelper.clickRegister(seleniumUtil, timeOut);
        /*RegisterUser user = new RegisterUser("zhangsan","123456","123456",
                "zhang", "san","shenzhen","nanshan");*/
        /*RegisterPageHelper.register(seleniumUtil, timeOut,user);*/
        System.out.println(data.size());
        if (data != null){
            for (Object key: data.keySet()){
                Map<String, String> cases = (Map<String, String>) data.get(key);
                RegisterPageHelper.typeRegisterInfo(seleniumUtil,cases.get("USERNAME"),cases.get("PASSWORD"),
                        cases.get("Confirm"),cases.get("First Name"),cases.get("Last Name"),cases.get("Street Address"),
                        cases.get("City/State/Zip"));
            }
        }else {
            Assert.fail("数据为空，请重准备数据！");
        }
    }
}
