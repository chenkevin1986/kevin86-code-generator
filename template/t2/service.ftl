package ${config.base_package}.service;

import com.google.common.reflect.TypeToken;
import com.jihai.mengmian.BeanUtils;
import com.jihai.mengmian.BeanListUtils;
import ${config.base_package}.entity.${tableName?cap_first}Entity;
import ${config.base_package}.repo.${tableName?cap_first}EntityRepo;
import ${config.base_package}.vo.${tableName?cap_first}Vo;
import ${config.base_package}.dto.${tableName?cap_first}Dto;
import com.jihai.mengmian.syscode.Syscode;
import com.jihai.mengmian.web.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jihai.mock.ModelEntity;
import java.util.List;

/**
 * <br>
 * <b>description：</b>${tableComment} 业务接口<br>
 * <b>author：</b>kevin chen<br>
 * <b>Time：</b> ${lastUpdated} <br>
 * <b>Contact：<b>wechat and phone number - 13826126615<br>
 */
@Service
public class ${tableName?cap_first}Service {
    @Autowired
    private ${tableName?cap_first}EntityRepo ${tableName?uncap_first}EntityRepo;

    /**
     * 新增
     * @param ${tableName?uncap_first}Dto
     * @return ApiResponse<${tableName?cap_first}Vo>
     */
     public ApiResponse<${tableName?cap_first}Vo> insert(${tableName?cap_first}Dto ${tableName?uncap_first}Dto){
           return ApiResponse.ok(new ModelEntity().resolveBean(new TypeToken<${tableName?cap_first}Vo>(){}.getType()));
           //${tableName?cap_first}Entity ${tableName?uncap_first}Entity = BeanUtils.copyAttrs(new ${tableName?cap_first}Entity(), ${tableName?uncap_first}Dto);
           //${tableName?uncap_first}EntityRepo.save(${tableName?uncap_first}Entity);
           //return ApiResponse.ok(BeanUtils.copyAttrs(new ${tableName?cap_first}Vo(),${tableName?uncap_first}Entity));
     }


     /**
      * 修改
      * @param ${tableName?uncap_first}Dto
      * @return ApiResponse<${tableName?cap_first}Vo>
      */
      public ApiResponse<${tableName?cap_first}Vo> update(${tableName?cap_first}Dto ${tableName?uncap_first}Dto){
            return ApiResponse.ok(new ModelEntity().resolveBean(new TypeToken<${tableName?cap_first}Vo>(){}.getType()));
            //${tableName?cap_first}Entity ${tableName?uncap_first}Entity = BeanUtils.copyAttrs(new ${tableName?cap_first}Entity(), ${tableName?uncap_first}Dto);
            //${tableName?uncap_first}EntityRepo.save(${tableName?uncap_first}Entity);
            //return ApiResponse.ok(BeanUtils.copyAttrs(new ${tableName?cap_first}Vo(),${tableName?uncap_first}Entity));
      }

      /**
       * 通过主键获取对象
       * @param id 实体主键
       * @return ApiResponse<${tableName?cap_first}Vo>
       */
       public ApiResponse<${tableName?cap_first}Vo> findOne(String id){
             return ApiResponse.ok(new ModelEntity().resolveBean(new TypeToken<${tableName?cap_first}Vo>(){}.getType()));
             //${tableName?cap_first}Entity ${tableName?uncap_first}Entity = ${tableName?uncap_first}EntityRepo.findOne(id);
             //return ApiResponse.ok(BeanUtils.copyAttrs(new ${tableName?cap_first}Vo(),${tableName?uncap_first}Entity));
       }

       /**
        * 默认查询所有列表，若要筛选列表，请增加过滤参数
        * @return ApiResponse<List<${tableName?cap_first}Vo>>
        */
        public ApiResponse<List<${tableName?cap_first}Vo>> findAll(){
               return ApiResponse.ok(new ModelEntity().resolveBean(new TypeToken<List<${tableName?cap_first}Vo>>(){}.getType()));
               //List<${tableName?cap_first}Entity> ${tableName?uncap_first}Entities = ${tableName?uncap_first}EntityRepo.findAll();
               //List<${tableName?cap_first}Vo> ${tableName?uncap_first}VoList = new BeanListUtils<${tableName?cap_first}Vo, ${tableName?cap_first}Entity>(${tableName?cap_first}Vo.class, ${tableName?uncap_first}Entities).getTargetList();
               //return ApiResponse.ok(${tableName?uncap_first}VoList);
        }

        /**
         * 删除对应主键的数据
         * @return
         */
         public ApiResponse delete(String id){
                //${tableName?uncap_first}EntityRepo.delete(id);
                return ApiResponse.prompt(Syscode.SC_OK);
         }

}