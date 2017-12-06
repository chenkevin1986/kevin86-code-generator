package com.kevin86.common.bean;


import com.kevin86.utils.StringUtils;

public class AttributeInfo {
	/**属性名*/
	private String name;  
	/**属性类型*/
    private String type;
    /**数据库表中原始类型信息*/
    private String dbType;
    /**属性注释*/
    private String comment;
    /**主键 or 外键*/
    private String key;
   
    public AttributeInfo() {  
    }

	public AttributeInfo(FieldDataInfo fieldDataInfo){
		this.name = StringUtils.humpNaming(fieldDataInfo.getField());
		this.type = fieldDataInfo.changeType();
		this.dbType = fieldDataInfo.getType();
		this.comment = fieldDataInfo.getComment();
		this.key = fieldDataInfo.getKey();
	}

	public AttributeInfo(String name, String type, String comment) {
		this.name = name;
		this.type = type;
		this.comment = comment;
	}

	public AttributeInfo(String name, String type, String comment, String key) {
		this.name = name;
		this.type = type;
		this.comment = comment;
		this.key = key;
	}

	public String getName() {  
        return name;  
    }  
   
    public void setName(String name) {  
        this.name = name;  
    }  
   
    public String getType() {  
        return type;  
    }  
   
    public void setType(String type) {  
        this.type = type;  
    }

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
}
