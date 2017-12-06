package com.kevin86.tool1.mybatis;

/**
 * Created by chengang on 2016/3/15.
 */
public class MyBatisPathConfig {
    /**mapper类的包*/
    private String mapper_package;
    /**mapper-xml 的包路径*/
    private String mapperxml_package;
    /**model类的包*/
    private String model_package;
    /**service接口的包*/
    private String service_package;
    /**serviceimp类的包*/
    private String serviceimpl_package;
    /**project的路径*/
    private String project_path;

    public MyBatisPathConfig() {
        load();
    }

    private void load(){
        this.mapper_package = System.getProperty("mapper_package");
        this.mapperxml_package = System.getProperty("mapperxml_package");
        this.model_package = System.getProperty("model_package");
        this.service_package = System.getProperty("service_package");
        this.serviceimpl_package = System.getProperty("serviceimpl_package");
        this.project_path = System.getProperty("project_path");
    }

    public String getMapper_package() {
        return mapper_package;
    }

    public String getMapperxml_package() {
        return mapperxml_package;
    }

    public String getModel_package() {
        return model_package;
    }

    public String getService_package() {
        return service_package;
    }

    public String getServiceimpl_package() {
        return serviceimpl_package;
    }

    public String getProject_path() {
        return project_path;
    }
}
