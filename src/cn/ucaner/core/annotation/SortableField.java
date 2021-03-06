/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.annotation;

import java.lang.reflect.Field;

/**
* @Package：cn.ucaner.core.annotation   
* @ClassName：SortableField   
* @Description：   <p> SortableField 可排序字段 </p>
* @Author： - Jason   
* @CreatTime：2018年10月18日 下午9:55:25   
* @Modify By：   
* @ModifyTime：  2018年10月18日
* @Modify marker：   
* @version    V1.0
 */
public class SortableField {
	
	public SortableField(){}  
     
    public SortableField(FieldMeta meta, Field field) {  
        super();  
        this.meta = meta;  
        this.field = field;  
        this.name=field.getName();  
        this.type=field.getType();  
    }  
      
      
    public SortableField(FieldMeta meta, String name, Class<?> type) {  
        super();  
        this.meta = meta;  
        this.name = name;  
        this.type = type;  
    }  
  
  
    private FieldMeta meta;  
    private Field field;  
    private String name;  
    private Class<?> type;  
      
    public FieldMeta getMeta() {  
        return meta;  
    }  
    public void setMeta(FieldMeta meta) {  
        this.meta = meta;  
    }  
    public Field getField() {  
        return field;  
    }  
    public void setField(Field field) {  
        this.field = field;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public Class<?> getType() {  
        return type;  
    }  
  
    public void setType(Class<?> type) {  
        this.type = type;  
    }  

}
