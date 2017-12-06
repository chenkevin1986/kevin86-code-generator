package com.kevin86.common.db;

import com.kevin86.common.bean.AttributeInfo;
import com.kevin86.common.bean.FieldDataInfo;
import com.kevin86.common.bean.JavaBeanClass;
import com.kevin86.common.bean.TableInfo;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chengang on 2016/3/15.
 */
public class DbManager {
    private final CommonDBUtilsHelper db;

    private DbManager() {
        this.db = CommonDBUtilsHelper.getInstance();
    }

    private static final class SingTonHandler{
        private static final DbManager instance = new DbManager();
    }
    public static DbManager getInstance(){
        return SingTonHandler.instance;
    }

    private final BeanListHandler<FieldDataInfo> beanListHandler = new BeanListHandler<FieldDataInfo>(FieldDataInfo.class);

    private final BeanListHandler<TableInfo> tableInfoBeanListHandler = new BeanListHandler<TableInfo>(TableInfo.class);

    public List<TableInfo> getTableNames() {
        String sql = "show table status";
        try {
            return this.db.getRunner().query(sql, tableInfoBeanListHandler);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<JavaBeanClass> getJavaBeanList(){
        List<TableInfo> tableNames = getTableNames();
        if (tableNames==null || tableNames.size()==0)
            throw new IllegalStateException("检查当前数据库是否存在数据表！");
        List<JavaBeanClass> javaBeanClassList = new ArrayList<>();
        for (Iterator<TableInfo> iterator = tableNames.iterator(); iterator.hasNext(); ) {
            TableInfo tableInfo = iterator.next();
            JavaBeanClass javaBeanClass = getJavaBeanClassByTableName(tableInfo.getName(), tableInfo.getComment());
            javaBeanClassList.add(javaBeanClass);
        }
        return javaBeanClassList;
    }

    public JavaBeanClass getJavaBeanClassByTableName(String tableName,String comment){
        String sql = "show full fields from "+tableName;
        try {
            List<FieldDataInfo> fieldInfos = this.db.getRunner().query(sql, beanListHandler);
            if (fieldInfos !=null && fieldInfos.size()>0 ){
                List<AttributeInfo> attrs = new ArrayList<AttributeInfo>();
                for (Iterator<FieldDataInfo> iterator = fieldInfos.iterator(); iterator.hasNext(); ) {
                    FieldDataInfo next =  iterator.next();
                    AttributeInfo info = new AttributeInfo(next);
                    attrs.add(info);
                }
                return new JavaBeanClass(tableName,comment,attrs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
