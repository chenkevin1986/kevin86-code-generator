package ${config.base_package}.repo;

import ${config.base_package}.entity.${tableName?cap_first}Entity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <br>
 * <b>description：</b>${tableComment} 数据库访问接口【DAO】<br>
 * <b>author：</b>kevin chen<br>
 * <b>Time：</b> ${lastUpdated} <br>
 * <b>Contact：<b>wechat and phone number - 13826126615<br>
 */
public interface ${tableName?cap_first}EntityRepo extends JpaRepository<${tableName?cap_first}Entity, String> {

}