package com.kevin86.tool2;

public class Tool2PathConfig {
    /**目标项目（模块）项目路径*/
    private String target_project_path;
    /**基础包路径*/
    private String base_package;

    public Tool2PathConfig() {
        load();
    }

    private void load(){
        this.target_project_path = System.getProperty("target_project_path");
        this.base_package = System.getProperty("base_package");
    }


    public String getTarget_project_path() {
        return target_project_path;
    }

    public void setTarget_project_path(String target_project_path) {
        this.target_project_path = target_project_path;
    }

    public String getBase_package() {
        return base_package;
    }

    public void setBase_package(String base_package) {
        this.base_package = base_package;
    }
}
