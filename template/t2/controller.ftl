package ${config.base_package}.controller;

import ${config.base_package}.service.${tableName?cap_first}Service;
import ${config.base_package}.vo.${tableName?cap_first}Vo;
import ${config.base_package}.dto.${tableName?cap_first}Dto;
import com.jihai.mengmian.web.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import java.util.List;

/**
 * <br>
 * <b>description：</b>${tableComment} Restful-Api接口<br>
 * <b>author：</b>kevin chen<br>
 * <b>Time：</b> ${lastUpdated} <br>
 * <b>Contact：<b>wechat and phone number - 13826126615<br>
 */
@Api(description = "${tableComment}Restful-Api接口服务", tags = "${tableComment} Restful-Api接口服务")
@RestController
public class ${tableName?cap_first}Controller {

    @Autowired
    private ${tableName?cap_first}Service ${tableName?uncap_first}Service;

    @ApiOperation(value = "新增",notes = "新增接口")
    @PostMapping("/${tableName?uncap_first}")
    public ApiResponse<${tableName?cap_first}Vo> insert(@RequestBody ${tableName?cap_first}Dto ${tableName?uncap_first}Dto){
          return ${tableName?uncap_first}Service.insert(${tableName?uncap_first}Dto);
    }


    @ApiOperation(value = "修改",notes = "修改接口")
    @PutMapping("/${tableName?uncap_first}")
    public ApiResponse<${tableName?cap_first}Vo> update(@RequestBody ${tableName?cap_first}Dto ${tableName?uncap_first}Dto){
          return ${tableName?uncap_first}Service.update(${tableName?uncap_first}Dto);
    }

    @ApiOperation(value = "查询单条数据",notes = "查询单条数据接口")
    @GetMapping("/${tableName?uncap_first}/{id}")
    public ApiResponse<${tableName?cap_first}Vo> findOne(@PathVariable("id") String id){
          return ${tableName?uncap_first}Service.findOne(id);
    }

    @ApiOperation(value = "查询所有数据",notes = "查询所有数据接口")
    @GetMapping("/${tableName?uncap_first}")
    public ApiResponse<List<${tableName?cap_first}Vo>> findAll(){
          return ${tableName?uncap_first}Service.findAll();
    }

    @ApiOperation(value = "删除单条数据",notes = "删除单条数据接口")
    @DeleteMapping("/${tableName?uncap_first}/{id}")
    public ApiResponse delete(String id){
          return ${tableName?uncap_first}Service.delete(id);
    }


}
