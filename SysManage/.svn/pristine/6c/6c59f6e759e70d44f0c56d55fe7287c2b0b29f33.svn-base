package com.hfmx.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class ViewJspController {

	@RequestMapping(value = "/{page}")
	public String toJSP(@PathVariable String page) {
		page = page.replace(".do", "");
		return page;
	}

	@RequestMapping(value = "/{p1}/{page}")
	public String toJSP(@PathVariable String p1, @PathVariable String page) {
		page = page.replace(".do", "");
		return p1 + "/" + page;
	}

	@RequestMapping(value = "/{p1}/{p2}/{page}")
	public String toJSP(@PathVariable String p1, @PathVariable String p2,
			@PathVariable String page) {
		page = page.replace(".do", "");
		return p1 + "/" + p2 + "/" + page;
	}

	@RequestMapping(value = "/{p1}/{p2}/{p3}/{page}")
	public String toJSP(@PathVariable String p1, @PathVariable String p2,
			@PathVariable String p3, @PathVariable String page) {
		page = page.replace(".do", "");
		return p1 + "/" + p2 + "/" + p3 + "/" + page;
	}

	@RequestMapping(value = "/{p1}/{p2}/{p3}/{p4}/{page}")
	public String toJSP(@PathVariable String p1, @PathVariable String p2,
			@PathVariable String p3, @PathVariable String p4,
			@PathVariable String page) {
		page = page.replace(".do", "");
		return p1 + "/" + p2 + "/" + p3 + "/" + p4 + "/" + page;
	}

	@RequestMapping(value = "/{p1}/{p2}/{p3}/{p4}/{p5}/{page}")
	public String toJSP(@PathVariable String p1, @PathVariable String p2,
			@PathVariable String p3, @PathVariable String p4,
			@PathVariable String p5, @PathVariable String page) {
		page = page.replace(".do", "");
		return p1 + "/" + p2 + "/" + p3 + "/" + p4 + "/" + p5 + "/" + page;
	}
}
