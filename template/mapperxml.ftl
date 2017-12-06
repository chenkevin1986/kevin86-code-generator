<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--
         符号转义说明
    &lt;          <
    &gt;          >
    &lt;&gt;     <>
    &amp;        &
    &apos;       '
    &quot;       "
  <![CDATA[ 这里写你的SQL或者符号 ]]>
  自动生成的时间：${lastUpdated}
  author： kevin chen
 -->
<mapper namespace="${config.mapper_package}.${tableName?cap_first}Mapper" >

    <!-- Result Map 数据库映射到实体类  -->
    <resultMap id="tableMapToModel" type="${config.model_package}.${tableName?cap_first}Model" >
    <#list attrs as prop>
           <result column="${prop.name}" property="${prop.name}"/>
    </#list>
    </resultMap>

    <!-- 所有条件分页 -->
    <sql id="model">
        <include refid="modelCount"/>
           ${"$"+"{pageUtil.orderByCondition}"}
        <if test="pageUtil.paging == true" >
           ${"$"+"{pageUtil.limit}"}
        </if>
    </sql>

    <!-- 总记录数 -->
    <sql id="modelCount">
        <where>
            <choose>
                <when test="pageUtil.like==true">
                    <include refid="andOtherAllLike"/>
                </when>
                <otherwise>
                    <include refid="andOtherAll"/>
                </otherwise>
            </choose>
          ${"$"+"{pageUtil.andCondition}"}
        </where>
        ${"$"+"{pageUtil.queryCondition}"}
    </sql>

    <!-- tbaleColumns  所有列 -->
    <sql id="tbaleColumns">
        <trim suffix="" suffixOverrides=",">
        <#list attrs as prop>${prop.name},</#list>
        </trim>
    </sql>

    <!-- insertColumns 入库列 -->
    <sql id="insertColumns">
        <trim suffix="" suffixOverrides=",">
        <#list attrs as prop>
        <#if prop.type="Timestamp">
            <if test="${prop.name} != null " >
                ${prop.name},
            </if>
        <#else>
            <if test="${prop.name} != null and ${prop.name} != '' " >
                ${prop.name},
            </if>
        </#if>
        </#list>
        </trim>
    </sql>


    <!-- insertParams  入库值 -->
    <sql id="insertParams">
        <trim suffix="" suffixOverrides=",">
        <#list attrs as prop>
            <#if prop.type="Timestamp">
                <if test="${prop.name} != null " >
                ${"#"+"{"+prop.name+"}"},
                </if>
            <#else>
                <if test="${prop.name} != null and ${prop.name} != '' " >
                ${"#"+"{"+prop.name+"}"},
                </if>
            </#if>
        </#list>
        </trim>
    </sql>


    <!-- updateParams  更新列 -->
    <sql id="updateParams">
        <trim suffix="" suffixOverrides=",">
        <#list attrs as prop>
            <#if prop.type="Timestamp">
                <if test="${prop.name} != null " >
                     ${prop.name} = ${"#"+"{"+prop.name+"}"},
                </if>
            <#else>
                <if test="${prop.name} != null and ${prop.name} != '' " >
                    ${prop.name} = ${"#"+"{"+prop.name+"}"},
                </if>
            </#if>
        </#list>
        </trim>
    </sql>


    <!-- 条件 查询  , 去掉主键列-->
    <sql id="andOther">
        <trim  suffixOverrides="," >
        <#list attrs as prop>
            <#if prop.key != "PRI">
                <if test="${prop.name} != null " >
                    and ${prop.name} =  ${"#"+"{"+prop.name+"}"}
                </if>
            </#if>
        </#list>
        </trim>
    </sql>


    <!-- 查询条件  包含所有 -->
    <sql id="andOtherAll">
        <trim  suffixOverrides="," >
        <#list attrs as prop>
            <#if prop.type="Timestamp">
                <if test="${prop.name} != null " >
                    and ${prop.name} =  ${"#"+"{"+prop.name+"}"}
                </if>
            <#else>
                <if test="${prop.name} != null and ${prop.name} != '' " >
                    and ${prop.name} = ${"#"+"{"+prop.name+"}"}
                </if>
            </#if>
        </#list>
        </trim>
    </sql>


    <!-- 模糊查询判断 -->
    <sql id="andOtherAllLike">
        <trim  suffixOverrides="," >
        <#list attrs as prop>
            <#if prop.type="Timestamp">
                <if test="${prop.name} != null " >
                    and ${prop.name} like  &apos;%${"$"+"{"+prop.name+"}"}%&apos;
                </if>
            <#else>
                <if test="${prop.name} != null and ${prop.name} != '' " >
                    and ${prop.name} like  &apos;%${"$"+"{"+prop.name+"}"}%&apos;
                </if>
            </#if>
        </#list>
        </trim>
    </sql>

    <!-- where 条件  -->
    <sql id="where">
        where 1=1
    </sql>

    <!-- columnKey  主键 列名称 ,视图获取不到主键 需要设置 -->
    <sql id="columnKey">
        and id=${"#"+"{id}"}
    </sql>


    <!-- 自定义查询 -->
    <sql id="sql">
        <if test="sql != null and sql !=''">
        ${"$"+"{sql}"}
        </if>
        <if test="sql == null || sql==''">
            select <include refid="tbaleColumns"/> from ${tableName?cap_first} <include refid="where"/>
        </if>
    </sql>

    <!-- 查询条件 -->
    <sql id="queryCondition">
        <if test="queryCondition != null and queryCondition != ''">
        ${"$"+"{queryCondition}"}
        </if>
    </sql>


    <!-- 添加,插入记录   -->
    <insert id="insert"  parameterType="${config.model_package}.${tableName?cap_first}Model" >
        insert into ${tableName?cap_first}(<include refid="insertColumns"/>) values(<include refid="insertParams"/>);
    </insert>

    <!-- 添加,SQL添加   -->
    <insert id="insertBySql" parameterType="java.lang.String">
        <include refid="sql"/>
    </insert>

    <!-- 删除,主键删除   -->
    <delete id="deleteByPrimaryKey" parameterType="${config.model_package}.${tableName?cap_first}Model">
        delete from ${tableName?cap_first}<include refid="where"/><include refid="columnKey"/>
    </delete>

    <!-- 删除,实体删除   -->
    <delete id="deleteByEntity" parameterType="${config.model_package}.${tableName?cap_first}Model">
        delete from ${tableName?cap_first}<include refid="where"/><include refid="andOtherAll"/>
    </delete>

    <!-- 删除,SQL删除   -->
    <delete id="deleteBySql" parameterType="java.lang.String">
        <include refid="sql"/>
    </delete>

    <!-- 修改,主键更新  -->
    <update id="updateByPrimaryKey" parameterType="${config.model_package}.${tableName?cap_first}Model" >
        update ${tableName?cap_first} <set><include refid="updateParams"/></set><include refid="where"/><include refid="columnKey"/>
    </update>

    <!-- 修改,SQL更新 -->
    <update id="updateBySql" parameterType="java.lang.String">
        <include refid="sql"/>
    </update>

    <!-- 查询,主键查询   -->
    <select id="selectByPrimaryKey"  resultMap="tableMapToModel" parameterType="java.lang.Object">
        select <include refid="tbaleColumns"/> from ${tableName?cap_first} <include refid="where"/> <include refid="columnKey"/>
    </select>

    <!-- 查询,实体查询   -->
    <select id="selectByEntiry"  resultMap="tableMapToModel" parameterType="${config.model_package}.${tableName?cap_first}Model">
        select <include refid="tbaleColumns"/> from ${tableName?cap_first} <include refid="where"/> <include refid="andOtherAll"/>
    </select>

    <!-- 查询,SQL -->
    <select id="selectBySql"  resultMap="tableMapToModel" parameterType="java.lang.String">
        <include refid="sql"/>
    </select>

    <!-- 查询 ,总行数,分页 ,模型 -->
    <select id="selectByModelCount" resultType="java.lang.Integer"  parameterType="${config.model_package}.${tableName?cap_first}Model">
        select count(1) from ${tableName?cap_first} <include refid="modelCount"/>
    </select>

    <!-- 查询,排序,分页,模型  -->
    <select id="selectByModel" resultMap="tableMapToModel"  parameterType="${config.model_package}.${tableName?cap_first}Model">
        select <include refid="tbaleColumns"/>from ${tableName?cap_first} <include refid="model"/>
    </select>

    <!-- 查询,总行数,Map -->
    <select id="selectByMapCount" resultType="java.lang.Integer"  parameterType="java.util.Map">
        select count(1) from ${tableName?cap_first} <include refid="where"/><include refid="andOtherAll"/>
    ${"$"+"{queryCondition}"}
        <if test="andCondition !=null and andCondition !=''">
            and ${"$"+"{andCondition}"}
        </if>
        <if test="orderCondition != null and queryCondition != ''" >
            order by ${"$"+"{orderCondition}"}
        </if>
    </select>

    <!-- 查询,参数查询,Map -->
    <select id="selectByMap" resultMap="tableMapToModel"  parameterType="java.util.Map">
        select <include refid="tbaleColumns"/>from ${tableName?cap_first} <include refid="where"/><include refid="andOtherAll"/>
    ${"$"+"{queryCondition}"}
        <if test="andCondition !=null and andCondition !=''">
            and ${"$"+"{andCondition}"}
        </if>
        <if test="orderCondition != null and queryCondition != ''" >
            order by ${"$"+"{orderCondition}"}
        </if>
    </select>

    <!-- 查询,总行数,Map分页 -->
    <select id="selectByMapPagingCount" resultType="java.lang.Integer"  parameterType="java.util.Map">
        select count(0) from ${tableName?cap_first} <include refid="where"/><include refid="andOtherAll"/>
    ${"$"+"{queryCondition}"}
        <if test="andCondition !=null and andCondition !=''">
            and ${"$"+"{andCondition}"}
        </if>
    ${"$"+"{pageUtil.queryCondition}"}
    ${"$"+"{pageUtil.andCondition}"}
    </select>

    <!-- 查询,参数查询,Map分页 -->
    <select id="selectByMapPaging" resultMap="tableMapToModel"  parameterType="java.util.Map">
        select <include refid="tbaleColumns"/>from ${tableName?cap_first} <include refid="where"/><include refid="andOtherAll"/>
    ${"$"+"{queryCondition}"}
        <if test="andCondition !=null and andCondition !=''">
            and ${"$"+"{andCondition}"}
        </if>
        <if test="orderCondition != null and queryCondition != ''" >
            order by ${"$"+"{orderCondition}"}
        </if>
    ${"$"+"{pageUtil.queryCondition}"}
    ${"$"+"{pageUtil.andCondition}"}
    ${"$"+"{pageUtil.orderByCondition}"}
    ${"$"+"{pageUtil.limit}"}
    </select>

    <!--查询, 图表 -->
    <select id="charts" parameterType="java.util.Map" resultType="java.util.Map">
        <!-- '%Y-%m-%d %H:%i:%s' -->
        SELECT COUNT(*),DATE_FORMAT(createTime,'${"$"+"{groupTimeFormat}"}') as createTime  FROM ${tableName?cap_first}
        <if test="startTimeFormat!=null and endTimeFormat!=null">
            WHERE
            createTime&gt;=DATE_FORMAT(NOW(), '${"$"+"{startTimeFormat}"}') AND createTime&lt;=DATE_FORMAT(NOW(), '${"$"+"{endTimeFormat}"}')
        </if>
        GROUP BY DATE_FORMAT(createTime,'${"$"+"{groupTimeFormat}"}')
    </select>

    <!--/////////////// 级联递归查询  一对多 ///////////////-->
    <resultMap type="${config.model_package}.${tableName?cap_first}Model" id="tableMapToModelChild" extends="tableMapToModel">

        <!-- 一对一关联   注意 顺序       需要用时开启 -->
        <!--
       <association property="${tableName?uncap_first}Model" column="parentId" select="getParent">

       </association>
       -->

        <!-- 一对多关联  -->
        <collection property="list${tableName?cap_first}Model" column="id" select="getChild">
            <!-- 对象的属性 -->
        </collection>

    </resultMap>

    <!--
<select id="getParent" resultMap="tableMapToModelChild" parameterType="String">
     SELECT * FROM ${tableName?cap_first} where id=${"#"+"{parentId}"}
</select>
-->

    <select id="getChild" resultMap="tableMapToModelChild" parameterType="String">
        SELECT * FROM ${tableName?cap_first} where parentId=${"#"+"{id}"}
    </select>

    <select id="selectByChild" resultMap="tableMapToModelChild"  parameterType="${config.model_package}.${tableName?cap_first}Model">
        SELECT <include refid="tbaleColumns"/>FROM ${tableName?cap_first}
        <where>
            <include refid="andOtherAll"/>
        ${"$"+"{pageUtil.andCondition}"}
        </where>
    ${"$"+"{pageUtil.queryCondition}"}
    ${"$"+"{pageUtil.orderByCondition}"}
        <if test="pageUtil.paging == true" >
        ${"$"+"{pageUtil.limit}"}
        </if>

    </select>
    <!--/////////////// 级联递归查询  一对多 ///////////////-->


    <!--//////////////////////增加/////////////////////// -->

</mapper>
