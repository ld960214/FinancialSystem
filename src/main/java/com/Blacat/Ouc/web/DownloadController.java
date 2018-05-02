package com.Blacat.Ouc.web;

import java.io.Console;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.Blacat.Ouc.ConstNums;
import com.Blacat.Ouc.Entities.Projects;
import com.Blacat.Ouc.ResponseTools.ResponseData;
import com.Blacat.Ouc.ResponseTools.WordService;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Controller
public class DownloadController {
	@Autowired
	WordService wordService;

	
	@GetMapping("/api/word/{subid}")
	public void getWord(HttpServletRequest req,HttpServletResponse res,@PathVariable String subid){
		try {
			int sid = Integer.parseInt(subid);
			Map<String,Object> mp = wordService.getWord(sid);
			res.setCharacterEncoding(req.getCharacterEncoding());
			res.setContentType("application/octet-stream"); 
			// 告诉浏览器用什么软件可以打开此文件
		    //res.setHeader("content-Type", "application/msword");
		    // 下载文件的默认名称
		    res.setHeader("Content-Disposition", "attachment;filename=xx.doc");
		    Configuration configuration = new Configuration();
		    configuration.setDefaultEncoding("UTF-8");
		    configuration.setClassForTemplateLoading(getClass(), "/");
		    Template template = configuration.getTemplate("info.ftl");
		    template.process(mp, new OutputStreamWriter(res.getOutputStream()));
		    
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
