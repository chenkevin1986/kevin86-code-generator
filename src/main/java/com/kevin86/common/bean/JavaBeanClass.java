package com.kevin86.common.bean;

import com.kevin86.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengang on 2016/3/15.
 */
public class JavaBeanClass {
    /***表名*/
    private String tableName;

    private String tableComment;
    /**字段信息*/
    private List<AttributeInfo> attrs = new ArrayList<AttributeInfo>();

    public JavaBeanClass(String tableName, List<AttributeInfo> attrs) {
        this.tableName = tableName;
        this.attrs = attrs;
    }

    public JavaBeanClass(String tableName, String tableComment, List<AttributeInfo> attrs) {
        this.tableName = StringUtils.humpNaming(tableName);
        this.tableComment = tableComment;
        this.attrs = attrs;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public List<AttributeInfo> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<AttributeInfo> attrs) {
        this.attrs = attrs;
    }
}
