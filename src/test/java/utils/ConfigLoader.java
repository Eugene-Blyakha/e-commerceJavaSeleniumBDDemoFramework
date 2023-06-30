package utils;

import constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configlLoader;

    private ConfigLoader(){
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)){
            case PROD: properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
            break;
            case STAGE: properties = PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");
            break;
            default: throw new IllegalStateException("INVALID ENV:" + env);
            }
        }



    public static ConfigLoader getInstance(){
        if(configlLoader == null){
            configlLoader = new ConfigLoader();
        }
        return configlLoader;
    }

    public String getBaseUrl(){
        String baseUrl = properties.getProperty("baseUrl");
        if(baseUrl != null)
            return baseUrl;
        else throw new RuntimeException("property baseUrl is not specified in the stage_config.properties file");
    }

    public String getUsername(){
        String prop = properties.getProperty("username");
        if(prop != null)
            return prop;
        else throw new RuntimeException("property username is not specified in the stage_config.properties file");
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop != null)
            return prop;
        else throw new RuntimeException("property password is not specified in the stage_config.properties file");
    }

}
