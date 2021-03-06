package com.hfmx.utils;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 将前台传递回来的查询条件整合成一个HQL或者SQL语句
 * 
 * Map集合中String关键字的格式如下
 * 
 * Y_name_String_LK,其中Y表示写入查询条件,name表示在数据库中查询字段,String表示查询字段的类型,LK表示查询操作符,
 * 如果有重名的可以再后面加上"_1"来标识
 * 
 * 查询字段类型 String-字符串 Num-数字 Date-时间
 * 
 * 操作符 EQ-相等 NE-不等 LT-小于 GT-大于 LE-小于等于 GE-大于等于 LK-模糊 RLK-右模糊 LLK-左模糊
 * 
 * @author mjsh
 * 
 */
public class SearchInfo {
	/**
	 * 查询条件集合
	 */
	private Map<String, Field> fields = new HashMap<String, Field>();

	/**
	 * 从前台传回的查询json数据转换成字段集合
	 * 
	 * @param queryjson
	 */
	public SearchInfo(String queryjson) {
		if (StringUtils.isBlank(queryjson))
			return;
		Map<String, Object> map = JsonParse.getMap(queryjson);
		if (map != null && map.size() > 0) {
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();// key
				Object value = map.get(key);// value
				String[] s = key.split("_");// 将key转换成为字段信息
				if (s.length < 4)
					continue;
				if (value == null || "".equals(value.toString().trim()))// 值为空的条件去掉
					continue;
				if (!"Y".equals(s[0].toUpperCase()))// 判断是否写进查询条件内
					continue;
				fields.put(key, new Field(s[1], s[2], s[3], value));
			}
		}
	}

	/**
	 * 修改查询字段
	 */
	public void modifyField(String oldField, String newField) {
		if (oldField != null && !"".equals(oldField.trim()) && newField != null && !"".equals(newField.trim())
				&& fields.size() > 0) {
			Iterator<String> iterator = fields.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();// key
				if (key.contains("_" + oldField + "_")) {
					fields.get(key).name = newField;
				}
			}
		}
	}

	@Override
	public String toString() {
		StringBuffer sBuffer = new StringBuffer();
		if (fields != null && fields.size() > 0) {
			Iterator<String> iterator = fields.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();// key
				String QL = fields.get(key).toString();
				if (!"".equals(QL.trim())) {
					if (!"".equals(sBuffer.toString().trim()))
						sBuffer.append(" and ");
					sBuffer.append(QL);
				}
			}
		}
		return sBuffer.toString();
	}

	public Map<String, Field> getFields() {
		return fields;
	}

	public void setFields(Map<String, Field> fields) {
		this.fields = fields;
	}

	/**
	 * 每段查询条件的信息
	 */
	public class Field {
		public String name;// 查询字段
		public String type;// 查询字段类型
		public String operator;// 查询字段操作符
		public Object value;// 查询值

		public Field(String name, String type, String operator, Object value) {
			this.name = name;
			this.type = type;
			this.operator = operator;
			this.value = value;
		}

		@Override
		public String toString() {
			if (type == null || "".equals(type) || operator == null || "".equals(operator))
				return "";
			String QL = "";
			// 时间格式
			if ("Date".equals(type)) {
				try {
					Date d = DateUtils.parseDate(this.value.toString(), new String[] { "yyyy-MM-dd",
							"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm" });
					QL = name + judgeOperator() + "'" + DateFormatUtils.format(d, "yyyy-MM-dd HH:mm:ss") + "'";
				} catch (ParseException e) {
					QL = "";
				}
			}
			// 数字格式
			if ("Num".equals(type)) {
				QL = name + judgeOperator() + value.toString();
			}
			// 字符串格式
			if ("String".equals(type)) {
				QL = name + judgeOperator();
				if ("LK".equals(operator)) {
					QL += "'%" + value.toString() + "%'";
				} else if ("RLK".equals(operator)) {
					QL += "'" + value.toString() + "%'";
				} else if ("LLK".equals(operator)) {
					QL += "'%" + value.toString() + "'";
				} else {
					QL = name + " = '" + value.toString() + "'";
				}
			}
			return QL;
		}

		/**
		 * 获取操作符 EQ-相等 NE-不等 LT-小于 GT-大于 LE-小于等于 GE-大于等于 LK-模糊 RLK-右模糊 LLK-左模糊
		 */
		private String judgeOperator() {
			if ("EQ".equals(operator.trim()))
				return " = ";
			if ("NE".equals(operator.trim()))
				return " != ";
			if ("LT".equals(operator.trim()))
				return " < ";
			if ("GT".equals(operator.trim()))
				return " > ";
			if ("LE".equals(operator.trim()))
				return " <= ";
			if ("GE".equals(operator.trim()))
				return " >= ";
			if ("LK".equals(operator.trim()))
				return " like ";
			if ("RLK".equals(operator.trim()))
				return " like ";
			if ("LLK".equals(operator.trim()))
				return " like ";
			return " = ";// 默认
		}
	}
}
