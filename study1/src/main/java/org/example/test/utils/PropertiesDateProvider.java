package org.example.test.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @Description 从properties文件中读取相关测试数据
 */
public class PropertiesDateProvider {

    public static String getTestData(String configFilePath, String key){
        PropertiesConfiguration config = null;
        try {
            config = new PropertiesConfiguration(configFilePath);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return String.valueOf(config.getProperties(key));
    }
}
