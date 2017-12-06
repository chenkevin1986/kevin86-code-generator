package com.kevin86.common.bean;

/**
 * Created by chengang on 2016/3/15.
 */
public class FieldDataInfo {
    /**字段名称*/
    private String Field;
    /**字段类型*/
    private String Type;
    /**主键 or 外键*/
    private String Key;
    /**注释*/
    private String Comment;

    public FieldDataInfo() {
    }

    public String getField() {
        return Field;
    }

    public void setField(String field) {
        Field = field;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String changeType(){
        if (Type.startsWith("int")){
            return "Integer";
        }
        if (Type.startsWith("bigint")){
            return "Long";
        }
        if (Type.startsWith("varchar")){
            return "String";
        }
        if (Type.startsWith("char")){
            return "String";
        }
        if (Type.startsWith("timestamp")){
            return "Timestamp";
        }
        if (Type.startsWith("datetime")){
            return "Timestamp";
        }
        return Type;
    }

    public String changeComment(){
        if (this.Comment==null || this.Comment.isEmpty()){
            return "无注解";
        }
        return this.Comment;
    }
}
