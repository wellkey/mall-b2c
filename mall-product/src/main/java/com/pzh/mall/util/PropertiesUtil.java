package com.pzh.mall.util;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertiesUtil implements EnvironmentAware {

    static Environment environment;

    public PropertiesUtil(){}

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public static String getPro(String proName){
        if(environment != null) {
            return environment.getProperty(proName);
        }
        return null;
    }

}
