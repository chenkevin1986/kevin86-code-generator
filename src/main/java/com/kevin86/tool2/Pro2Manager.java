package com.kevin86.tool2;


import com.kevin86.common.bean.JavaBeanClass;
import com.kevin86.common.db.DbManager;
import com.kevin86.tool1.gui.frame.PathConfigFrame;
import com.kevin86.tool1.mybatis.MyBatisPathConfig;
import com.kevin86.utils.DateUtil;
import com.kevin86.utils.FreeMarkerUtils;
import com.kevin86.utils.StringUtils;
import freemarker.template.Template;
import org.apache.commons.lang3.tuple.Triple;

import java.io.File;
import java.util.*;

public class Pro2Manager {

    private Pro2Manager() {
    }

    private static final class SingTonHandler{
        private static final Pro2Manager instance = new Pro2Manager();
    }
    public static Pro2Manager getInstance(){
        return Pro2Manager.SingTonHandler.instance;
    }

    private List<JavaBeanClass> javaBeanClassList;

    private static final Tool2PathConfig tool2PathConfig = new Tool2PathConfig();

    /**
     * 批量（batch）生成(product) 所有数据库表对应的相关java类
     */
    public void proBatchClass(){
        this.javaBeanClassList = DbManager.getInstance().getJavaBeanList();
        for (Iterator<JavaBeanClass> iterator = javaBeanClassList.iterator(); iterator.hasNext(); ) {
            JavaBeanClass javaBeanClass =  iterator.next();
            proSingleClass(tool2PathConfig,javaBeanClass);
        }
    }

    public static final List<Triple<String,String,String>> tripeList = new ArrayList<>();
    static {
        tripeList.add(Triple.of("entity.ftl","/entity/","Entity.java"));
        tripeList.add(Triple.of("dto.ftl","/dto/","Dto.java"));
        tripeList.add(Triple.of("vo.ftl","/vo/","Vo.java"));
        tripeList.add(Triple.of("entityRepo.ftl","/repo/","EntityRepo.java"));
        tripeList.add(Triple.of("service.ftl","/service/","Service.java"));
        tripeList.add(Triple.of("controller.ftl","/controller/","Controller.java"));
    }


    public boolean proSingleClass(Tool2PathConfig config, JavaBeanClass javaBeanClass){
        try{
            Map<String, Object> root = new HashMap<String, Object>();
            root.put("lastUpdated", DateUtil.getNowStringDate());
            root.put("config",config);
            root.put("tableComment",javaBeanClass.getTableComment());
            root.put("tableName",javaBeanClass.getTableName());
            root.put("attrs",javaBeanClass.getAttrs());
            String comon_outfile = config.getTarget_project_path() + "/src/main/java/";
            String basePackage = config.getBase_package();
            String basePath = basePackage.replaceAll("\\.","/");
            for (Iterator<Triple<String,String,String>> iterator = tripeList.iterator(); iterator.hasNext(); ) {
                Triple<String,String,String> triple =  iterator.next();
                Template template = FreeMarkerUtils.getTemplate(triple.getLeft());
                String outfile = comon_outfile + basePath +triple.getMiddle();
                File file = new File(outfile);
                if (!file.exists()){
                    file.mkdirs(); //一定要创建上层目录 不然会报错
                }
                outfile = outfile + StringUtils.uppercaseString(javaBeanClass.getTableName())+triple.getRight();
                FreeMarkerUtils.writeTemplate(outfile, template, root);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
