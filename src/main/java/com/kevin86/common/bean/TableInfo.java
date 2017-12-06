package com.kevin86.common.bean;

public class TableInfo {
    /**表名*/
    private String Name;

    private String Create_time;

    private String Update_time;
    /**字符集*/
    private String Collation;
    /**引擎*/
    private String Engine;
    /**注释*/
    private String Comment;

    public TableInfo() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCreate_time() {
        return Create_time;
    }

    public void setCreate_time(String create_time) {
        Create_time = create_time;
    }

    public String getUpdate_time() {
        return Update_time;
    }

    public void setUpdate_time(String update_time) {
        Update_time = update_time;
    }

    public String getCollation() {
        return Collation;
    }

    public void setCollation(String collation) {
        Collation = collation;
    }

    public String getEngine() {
        return Engine;
    }

    public void setEngine(String engine) {
        Engine = engine;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
