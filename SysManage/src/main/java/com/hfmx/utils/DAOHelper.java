package com.hfmx.utils;

import javax.persistence.Entity;

/**
 * DAO层帮助类
 * 
 * @author Administrator
 * 
 */
public class DAOHelper {
	
	/**
	 * 根据反射获取实体类名称
	 * @param entityClass
	 * @return
	 */
	public static <T> String getEntityName(Class<T> entityClass) {
		String entityName = entityClass.getSimpleName();
		Entity entity = entityClass.getAnnotation(Entity.class);
		if (null != entity.name() && !("".equals(entity.name()))) {
			entityName = entity.name();
		}

		return entityName;
	}
}
