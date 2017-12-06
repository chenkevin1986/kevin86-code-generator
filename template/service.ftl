package ${config.service_package};

import ${config.mapper_package}.${tableName?cap_first}Mapper;

/**
*
* <br>
* <b>功能：</b>定义在这里由 ${tableName?cap_first}ServiceImp来实现 私有的 <br>
* <b>作者：</b>kevin chen<br>
* <b>日期：</b> ${lastUpdated} <br>
* <b>版权所有：<b>版权所有(C) 2016，QQ 103848039<br>
*/
public interface ${tableName?cap_first}Service<T>  extends BaseService<T> , ${tableName?cap_first}Mapper<T> {

}