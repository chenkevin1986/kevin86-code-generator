package com.kevin86.tool1.mybatis.manager;

import com.kevin86.common.db.DbManager;
import freemarker.template.Template;
import com.kevin86.tool1.gui.frame.PathConfigFrame;
import com.kevin86.tool1.mybatis.MyBatisPathConfig;
import com.kevin86.common.bean.JavaBeanClass;
import com.kevin86.utils.DateUtil;
import com.kevin86.utils.FreeMarkerUtils;
import com.kevin86.utils.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chengang on 2016/3/16.
 */
public class ProManager {
    private ProManager() {
    }

    private static final class SingTonHandler{
        private static final ProManager instance = new ProManager();
    }
    public static ProManager getInstance(){
        return SingTonHandler.instance;
    }
    private JavaBeanClass myBatisClass;

    public boolean proPjtMapperXml(MyBatisPathConfig config, String tableName, List<Integer> cbNums){
        try{
            myBatisClass = DbManager.getInstance().getJavaBeanClassByTableName(tableName,"");
            Map<String, Object> root = new HashMap<String, Object>();
            root.put("lastUpdated", DateUtil.getNowStringDate());
            root.put("config",config);
            root.put("tableName",tableName);
            root.put("attrs",myBatisClass.getAttrs());
            String comon_outfile = config.getProject_path() + "/"+ PathConfigFrame.srcStr+"/";
            Template template = null;
            String outfile = null;
            // 生成xml
            if (cbNums.contains(0) || cbNums.contains(1)){
                template = FreeMarkerUtils.getTemplate("mapperxml.ftl");
                String mapperxml_package = config.getMapperxml_package();
                mapperxml_package = mapperxml_package.replaceAll("\\.","/");
                outfile = comon_outfile + mapperxml_package
                        +"/" + StringUtils.uppercaseString(tableName)+"Mapper.xml";
                FreeMarkerUtils.writeTemplate(outfile, template, root);
            }
            //生成mapper类
            if (cbNums.contains(0) || cbNums.contains(2)){
                template = FreeMarkerUtils.getTemplate("mapper.ftl");
                String mapper_package = config.getMapper_package();
                mapper_package = mapper_package.replaceAll("\\.","/");
                outfile = comon_outfile + mapper_package
                        +"/" + StringUtils.uppercaseString(tableName)+"Mapper.java";
                FreeMarkerUtils.writeTemplate(outfile, template, root);
            }
            //生成model类
            if (cbNums.contains(0) || cbNums.contains(3)){
                template = FreeMarkerUtils.getTemplate("model.ftl");
                String model_package = config.getModel_package();
                model_package = model_package.replaceAll("\\.","/");
                outfile = comon_outfile + model_package
                        +"/" + StringUtils.uppercaseString(tableName)+"Model.java";
                FreeMarkerUtils.writeTemplate(outfile, template, root);
            }
            //生成Service类
            if (cbNums.contains(0) || cbNums.contains(4)){
                template = FreeMarkerUtils.getTemplate("service.ftl");
                String service_package = config.getService_package();
                service_package = service_package.replaceAll("\\.","/");
                outfile = comon_outfile + service_package
                        +"/" + StringUtils.uppercaseString(tableName)+"Service.java";
                FreeMarkerUtils.writeTemplate(outfile, template, root);
            }
            //生成ServiceImp类
            if (cbNums.contains(0) || cbNums.contains(5)){
                template = FreeMarkerUtils.getTemplate("serviceimpl.ftl");
                String serviceimpl_package = config.getServiceimpl_package();
                serviceimpl_package = serviceimpl_package.replaceAll("\\.","/");
                outfile = comon_outfile + serviceimpl_package
                        +"/" + StringUtils.uppercaseString(tableName)+"ServiceImp.java";
                FreeMarkerUtils.writeTemplate(outfile, template, root);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
