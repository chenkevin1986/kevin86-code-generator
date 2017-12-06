package ${config.model_package};

import java.sql.Timestamp;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
/**
* <br>
* <b>功能：</b>实例类Model<br>
* <b>作者：</b>kevin chen<br>
* <b>日期：</b> ${lastUpdated} <br>
*/
public class ${tableName?cap_first}Model extends BaseModel {
<#list attrs as prop>
    /** ${prop.comment} */
    private ${prop.type} ${prop.name?uncap_first};
</#list>

<#list attrs as prop>
    <#if prop.type="Timestamp">
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public ${prop.type} get${prop.name?cap_first}(){
        return ${prop.name?uncap_first};
    }
    public void set${prop.name?cap_first}(${prop.type} ${prop.name?uncap_first}){
        this.${prop.name?uncap_first} = ${prop.name?uncap_first};
    }

    <#else>
    public ${prop.type} get${prop.name?cap_first}(){
        return ${prop.name?uncap_first};
    }
    public void set${prop.name?cap_first}(${prop.type} ${prop.name?uncap_first}){
        this.${prop.name?uncap_first} = ${prop.name?uncap_first};
    }

    </#if>
</#list>

    public String toString(){
        return JSON.toJSONString(this);
    }
}
