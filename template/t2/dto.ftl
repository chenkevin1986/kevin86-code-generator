package ${config.base_package}.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <br>
 * <b>description：</b>${tableComment} DTO实体<br>
 * <b>author：</b>kevin chen<br>
 * <b>Time：</b> ${lastUpdated} <br>
 * <b>Contact：<b>wechat and phone number - 13826126615<br>
 */
@Data
@ApiModel(value = "Dto实体信息", description = "Dto实体信息")
public class ${tableName?cap_first}Dto {
<#list attrs as prop>
    @ApiModelProperty( value = "填写其字段的含义")
    private ${prop.type} ${prop.name?uncap_first};
</#list>

}