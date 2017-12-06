package ${config.base_package}.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * <br>
 * <b>description：</b>${tableComment} ENTITY实体<br>
 * <b>author：</b>kevin chen<br>
 * <b>Time：</b> ${lastUpdated} <br>
 * <b>Contact：<b>wechat and phone number - 13826126615<br>
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "${tableName}")
public class ${tableName?cap_first}Entity {

<#list attrs as prop>

    <#if prop.key="PRI">
    @Id
    @Column(columnDefinition = "${prop.dbType} NOT NULL COMMENT '${prop.comment}'")
    private ${prop.type} ${prop.name?uncap_first};
    <#else>
    @Column(columnDefinition = "${prop.dbType} NOT NULL COMMENT '${prop.comment}'")
    private ${prop.type} ${prop.name?uncap_first};
    </#if>

</#list>

}