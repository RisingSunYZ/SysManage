package com.hfmx.test.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import com.hfmx.utils.JsonParse;

public class jacksonTest {

	@Test
	public void jacksontestobj() {
		STU s = new STU("张三", 19, "清华");
		String json = JsonParse.getJson(s);
		System.out.println(json);

		STU s2 = JsonParse.getObject(json, STU.class);
		System.out.println(s2.toString());
	}

	@Test
	public void jacksontest1() {
		List<STU> list = new ArrayList<STU>();
		list.add(new STU("张三", 19, "清华"));
		list.add(new STU("李四", 21, "北大"));
		list.add(new STU("王麻子", 23, "新东方"));
		list.add(new STU("李二蛋", 21, "蓝翔"));
		String json = JsonParse.getJson(list);
		System.out.println(json);

		List<STU> list2 = JsonParse.getList(json, STU.class);
		if (list2 != null && list2.size() > 0) {
			for (STU s : list2)
				System.out.println(s);
		}
	}

	@Test
	public void jacksontest2() {
		List<HashMap<String, STU>> listmap = new ArrayList<HashMap<String, STU>>();
		HashMap<String, STU> map1 = new HashMap<String, STU>();
		map1.put("张三", new STU("张三", 19, "清华"));
		listmap.add(map1);
		HashMap<String, STU> map2 = new HashMap<String, STU>();
		map2.put("李四", new STU("李四", 21, "北大"));
		listmap.add(map2);
		HashMap<String, STU> map3 = new HashMap<String, STU>();
		map3.put("王麻子", new STU("王麻子", 23, "新东方"));
		listmap.add(map3);
		HashMap<String, STU> map4 = new HashMap<String, STU>();
		map4.put("李二蛋", new STU("李二蛋", 21, "蓝翔"));
		listmap.add(map4);
		String json = JsonParse.getJson(listmap);
		System.out.println(json);

		List<Map<String, STU>> listmap2 = JsonParse.getListMap(json, STU.class);
		if (listmap2 != null && listmap2.size() > 0) {
			for (Map<String, STU> map : listmap2) {
				for (Map.Entry<String, STU> entry : map.entrySet()) {
					System.out.print(entry.getKey() + ":" + entry.getValue() + "\n");
				}
			}
		}
	}

	@Test
	public void jacksontest3() {
		Map<String, STU> map = new HashMap<String, STU>();
		map.put("张三", new STU("张三", 19, "清华"));
		map.put("李四", new STU("李四", 21, "北大"));
		map.put("王麻子", new STU("王麻子", 23, "新东方"));
		map.put("李二蛋", new STU("李二蛋", 21, "蓝翔"));
		String json = JsonParse.getJson(map);
		System.out.println(json);

		Map<String, STU> map2 = JsonParse.getMap(json, STU.class);
		for (Map.Entry<String, STU> entry : map2.entrySet()) {
			System.out.print(entry.getKey() + ":" + entry.getValue() + "\n");
		}
	}
}
