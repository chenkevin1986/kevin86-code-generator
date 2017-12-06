package ${config.serviceimpl_package};
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${config.service_package}.${tableName?cap_first}Service;
import ${config.mapper_package}.${tableName?cap_first}Mapper;

/**
*
* <br>
* <b>功能：</b>用于事物处理<br>
* <b>作者：</b>kevin chen <br>
* <b>日期：</b> ${lastUpdated} <br>
* <b>版权所有：<b>版权所有(C) 2016，QQ 103848039<br>
*/
@Service("${tableName?uncap_first}Service")
public class ${tableName?cap_first}ServiceImp<T> extends BaseServiceImp<T> implements ${tableName?cap_first}Service<T>{
    @Autowired
    private ${tableName?cap_first}Mapper<T> mapper;

    public ${tableName?cap_first}Mapper<T> getMapper() {
          return mapper;
    }

}