package com.Blacat.Ouc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blacat.Ouc.ConstNums;
import com.Blacat.Ouc.Entities.Projects;
import com.Blacat.Ouc.ResponseTools.*;
import com.Blacat.Ouc.Services.ProjectsService;
import com.Blacat.Ouc.Services.UserService;

@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	UserService userService;

	@Autowired
	ProjectsService projectsService;

	@GetMapping("projects/{userid}")
	public Object getProjects(@PathVariable String userid) {
		try {
			int uid = Integer.parseInt(userid);
			List<Projects> pjs = projectsService.getProjects(uid);
			return new ResponseData(ConstNums.FIND_OK, "找到", pjs.size(), pjs);
		} catch (Exception e) {
			return new ResponseData(ConstNums.FIND_ERROR, "错误", 1, e.getMessage());
		}
	}

	@GetMapping("project/{projectid}")
	public Object getProject(@PathVariable String projectid) {
		try {
			int pid = Integer.parseInt(projectid);
			Projects projects = projectsService.getProject(pid);
			return new ResponseData(ConstNums.FIND_OK, "find", 1, projects);
		} catch (Exception e) {
			return new ResponseData(ConstNums.FIND_ERROR, "错误", 1, e.getMessage());
		}
	}

	@PostMapping("project")
	public Object addProject(@RequestBody Projects projects){
		Boolean f = projectsService.addProject(projects);
		if(f) return new ResponseData(ConstNums.ADD_OK, "添加成功", 1, f);
		else return new ResponseData(ConstNums.ADD_ERROR_SERVER, "添加失败", 1, !f);
	}
	
	@PutMapping("project")
	public Object upProject(@RequestBody Projects projects){
		Boolean f = projectsService.upProject(projects);
		if(f) return new ResponseData(ConstNums.UPDATE_OK, "添加成功", 1, f);
		else return new ResponseData(ConstNums.UPDATE_ERROR_SERVER, "添加失败", 1, !f);
	}
	
	@DeleteMapping("project/{projectid}")
	public Object delProject(@PathVariable String projectid) {
		try {
			int pid = Integer.parseInt(projectid);
			projectsService.delProject(pid);
			return new ResponseData(ConstNums.DELETE_OK, "删除成功", 1,null );
		} catch (Exception e) {
			return new ResponseData(ConstNums.DELETE_ERROR_SERVER, "删除错误", 1, e.getMessage());
		}
	}
}
