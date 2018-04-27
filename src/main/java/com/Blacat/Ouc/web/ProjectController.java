package com.Blacat.Ouc.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
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
import com.Blacat.Ouc.Entities.Childmaterials;
import com.Blacat.Ouc.Entities.Conference;
import com.Blacat.Ouc.Entities.Devices;
import com.Blacat.Ouc.Entities.Iptf;
import com.Blacat.Ouc.Entities.MaterialGroup;
import com.Blacat.Ouc.Entities.Materials;
import com.Blacat.Ouc.Entities.Projects;
import com.Blacat.Ouc.Entities.Subjects;
import com.Blacat.Ouc.Entities.Trips;
import com.Blacat.Ouc.ResponseTools.*;
import com.Blacat.Ouc.Services.ChildmaterialsService;
import com.Blacat.Ouc.Services.ConferenceService;
import com.Blacat.Ouc.Services.DevicesService;
import com.Blacat.Ouc.Services.IptfService;
import com.Blacat.Ouc.Services.MaterialsService;
import com.Blacat.Ouc.Services.ProjectsService;
import com.Blacat.Ouc.Services.SubjectsService;
import com.Blacat.Ouc.Services.TripsService;
import com.Blacat.Ouc.Services.UserService;

@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	UserService userService;

	@Autowired
	ProjectsService projectsService;

	@Autowired
	SubjectsService subjectsService;

	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	DevicesService devicesService;

	@Autowired
	ConferenceService conferenceService;

	@Autowired
	TripsService tripsService;

	@Autowired
	MaterialsService materialsService;

	@Autowired
	IptfService iptfService;

	@Autowired
	ChildmaterialsService childmaterialsService;

	///
	/// Project部分
	///
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
			return new ResponseData(ConstNums.FIND_OK, "找到", 1, projects);
		} catch (Exception e) {
			return new ResponseData(ConstNums.FIND_ERROR, "错误", 1, e.getMessage());
		}
	}

	@PostMapping("project")
	public Object addProject(@RequestBody Projects projects) {
		Projects newp = projectsService.addProject(projects);
		if (newp != null)
			return new ResponseData(ConstNums.ADD_OK, "添加成功", 1, newp);
		else
			return new ResponseData(ConstNums.ADD_ERROR_SERVER, "添加失败", 1, newp);
	}

	@PutMapping("project")
	public Object upProject(@RequestBody Projects projects) {
		Boolean f = projectsService.upProject(projects);
		if (f)
			return new ResponseData(ConstNums.UPDATE_OK, "修改成功", 1, f);
		else
			return new ResponseData(ConstNums.UPDATE_ERROR_SERVER, "修改失败", 1, !f);
	}

	@DeleteMapping("project/{projectid}")
	public Object delProject(@PathVariable String projectid) {
		try {
			int pid = Integer.parseInt(projectid);
			projectsService.delProject(pid);
			return new ResponseData(ConstNums.DELETE_OK, "删除成功", 1, null);
		} catch (Exception e) {
			return new ResponseData(ConstNums.DELETE_ERROR_SERVER, "删除错误", 1, e.getMessage());
		}
	}

	///
	/// Subject部分
	///
	@GetMapping("subjects/{projectid}")
	public Object getSubjects(@PathVariable String projectid) {
		try {
			int proid = Integer.parseInt(projectid);
			List<Subjects> sjs = subjectsService.getSubjects(proid);
			return new ResponseData(ConstNums.FIND_OK, "找到", sjs.size(), sjs);
		} catch (Exception e) {
			return new ResponseData(ConstNums.FIND_ERROR, "错误", 1, e.getMessage());
		}
	}

	@GetMapping("subject/{subjectid}")
	public Object getSubject(@PathVariable String subjectid) {
		try {
			int sid = Integer.parseInt(subjectid);
			Subjects subjects = subjectsService.getSubject(sid);
			return new ResponseData(ConstNums.FIND_OK, "找到", 1, subjects);
		} catch (Exception e) {
			return new ResponseData(ConstNums.FIND_ERROR, "错误", 1, e.getMessage());
		}
	}

	@PutMapping("subject")
	public Object upSubject(@RequestBody Subjects subjects) {
		Boolean f = subjectsService.upSubject(subjects);
		if (f)
			return new ResponseData(ConstNums.UPDATE_OK, "修改成功", 1, f);
		else
			return new ResponseData(ConstNums.UPDATE_ERROR_SERVER, "修改失败", 1, !f);
	}

	@PostMapping("subject")
	public Object addSubject(@RequestBody Subjects subjects) {
		Subjects f = subjectsService.addSubject(subjects);
		if (f != null)
			return new ResponseData(ConstNums.ADD_OK, "添加成功", 1, f);
		else
			return new ResponseData(ConstNums.ADD_ERROR_SERVER, "添加失败", 1, f);
	}

	@DeleteMapping("subject/{subjectid}")
	public Object delSubject(@PathVariable String subjectid) {
		try {
			int sid = Integer.parseInt(subjectid);
			subjectsService.delSubject(sid);
			return new ResponseData(ConstNums.FIND_OK, "删除成功", 1, null);
		} catch (Exception e) {
			return new ResponseData(ConstNums.FIND_ERROR, "删除错误", 1, e.getMessage());
		}
	}

	//
	// 设备
	//
	//
	@GetMapping("devices/{subjectid}")
	public Object getDevices(@PathVariable String subjectid) {
		try {
			int sid = Integer.parseInt(subjectid);
			List<Devices> devices = devicesService.getDevices(sid);
			return new ResponseData(ConstNums.FIND_OK, "找到", devices.size(), devices);
		} catch (Exception e) {
			return new ResponseData(ConstNums.FIND_ERROR, "错误", 1, e.getMessage());
		}
	}

	@PutMapping("devices/save")
	public Object upDevices(@RequestBody List<Devices> devices) {
		try {
			List<Devices> addD = new ArrayList<Devices>();
			List<Devices> upD = new ArrayList<Devices>();
			List<Integer> delD = new ArrayList<Integer>();
			List<Devices> result = new ArrayList<Devices>();
			List<Devices> temp = new ArrayList<Devices>();
			devices.forEach(a -> {
				if (a.getDid() > 0)
					upD.add(a);
				else if (a.getDid() < 0)
					delD.add(-a.getDid());
				else
					addD.add(a);
			});
			temp = devicesService.addDevices(addD);
			temp.forEach(a -> {
				result.add(a);
			});
			temp = devicesService.upDevices(upD);
			temp.forEach(a -> {
				result.add(a);
			});
			devicesService.delDevices(delD);
			return new ResponseData(ConstNums.UPDATE_OK, "保存成功", result.size(), result);
		} catch (Exception e) {
			return new ResponseData(ConstNums.UPDATE_ERROR_SERVER, "保存错误", devices.size(), e.getMessage());
		}
	}

	//
	// 差旅
	//
	//
	@GetMapping("trips/{subjectid}")
	public Object getTrips(@PathVariable String subjectid) {
		try {
			int sid = Integer.parseInt(subjectid);
			List<Trips> trips = tripsService.getTrips(sid);
			return new ResponseData(ConstNums.FIND_OK, "找到", trips.size(), trips);
		} catch (Exception e) {
			return new ResponseData(ConstNums.FIND_ERROR, "错误", 1, e.getMessage());
		}
	}

	@PutMapping("trips/save")
	public Object uptrips(@RequestBody List<Trips> trips) {
		try {
			List<Trips> addT = new ArrayList<Trips>();
			List<Trips> upT = new ArrayList<Trips>();
			List<Integer> delT = new ArrayList<Integer>();
			List<Trips> result = new ArrayList<Trips>();
			List<Trips> temp = new ArrayList<Trips>();
			trips.forEach(a -> {
				if (a.getTid() > 0)
					upT.add(a);
				else if (a.getTid() < 0)
					delT.add(-a.getTid());
				else
					addT.add(a);
			});
			temp = tripsService.addTrips(addT);
			temp.forEach(a -> {
				result.add(a);
			});
			temp = tripsService.upTrips(upT);
			temp.forEach(a -> {
				result.add(a);
			});
			tripsService.delTrips(delT);
			return new ResponseData(ConstNums.UPDATE_OK, "保存成功", result.size(), result);
		} catch (Exception e) {
			return new ResponseData(ConstNums.UPDATE_ERROR_SERVER, "保存错误", trips.size(), e.getMessage());
		}
	}

	//
	// 会议
	//

	@GetMapping("conferences/{subjectid}")
	public Object getConferences(@PathVariable String subjectid) {
		try {
			int sid = Integer.parseInt(subjectid);
			List<Conference> conference = conferenceService.getConferences(sid);
			return new ResponseData(ConstNums.FIND_OK, "找到", conference.size(), conference);
		} catch (Exception e) {
			return new ResponseData(ConstNums.FIND_ERROR, "错误", 1, e.getMessage());
		}
	}

	@PutMapping("conferences/save")
	public Object upConferences(@RequestBody List<Conference> conference) {
		try {
			List<Conference> addC = new ArrayList<Conference>();
			List<Conference> upC = new ArrayList<Conference>();
			List<Integer> delC = new ArrayList<Integer>();
			List<Conference> result = new ArrayList<Conference>();
			List<Conference> temp = new ArrayList<Conference>();
			conference.forEach(a -> {
				if (a.getCid() > 0)
					upC.add(a);
				else if (a.getCid() < 0)
					delC.add(-a.getCid());
				else
					addC.add(a);
			});
			temp = conferenceService.addConferences(addC);
			temp.forEach(a -> {
				result.add(a);
			});
			temp = conferenceService.upConferences(upC);
			temp.forEach(a -> {
				result.add(a);
			});
			conferenceService.delConferences(delC);
			return new ResponseData(ConstNums.UPDATE_OK, "保存成功", result.size(), result);
		} catch (Exception e) {
			return new ResponseData(ConstNums.UPDATE_ERROR_SERVER, "保存错误", conference.size(), e.getMessage());
		}
	}

	//
	// 出版文献信息传播知识产权事务
	//

	@GetMapping("iptfs/{subjectid}")
	public Object getIptfs(@PathVariable String subjectid) {
		try {
			int sid = Integer.parseInt(subjectid);
			List<Iptf> iptf = iptfService.getIptfs(sid);
			return new ResponseData(ConstNums.FIND_OK, "找到", iptf.size(), iptf);
		} catch (Exception e) {
			return new ResponseData(ConstNums.FIND_ERROR, "错误", 1, e.getMessage());
		}
	}

	@PutMapping("iptfs/save")
	public Object upIptfs(@RequestBody List<Iptf> iptf) {
		try {
			List<Iptf> addI = new ArrayList<Iptf>();
			List<Iptf> upI = new ArrayList<Iptf>();
			List<Integer> delI = new ArrayList<Integer>();
			List<Iptf> result = new ArrayList<Iptf>();
			List<Iptf> temp = new ArrayList<Iptf>();
			iptf.forEach(a -> {
				if (a.getIid() > 0)
					upI.add(a);
				else if (a.getIid() < 0)
					delI.add(-a.getIid());
				else
					addI.add(a);
			});
			temp = iptfService.addIptfs(addI);
			temp.forEach(a -> {
				result.add(a);
			});
			temp = iptfService.upIptfs(upI);
			temp.forEach(a -> {
				result.add(a);
			});
			iptfService.delIptfs(delI);
			return new ResponseData(ConstNums.UPDATE_OK, "保存成功", result.size(), result);
		} catch (Exception e) {
			return new ResponseData(ConstNums.UPDATE_ERROR_SERVER, "保存错误", iptf.size(), e.getMessage());
		}
	}

	//
	// 材料
	//

	@GetMapping("materials/{subjectid}")
	public Object getMaterialss(@PathVariable String subjectid) {
		try {
			int sid = Integer.parseInt(subjectid);
			List<Materials> materials = materialsService.getMaterials(sid);
			List<MaterialGroup> result = new ArrayList<MaterialGroup>();
			// List<Map<String,Object>> result = new ArrayList<Map<String,
			// Object>>();
			materials.forEach(a -> {

				// Map<String,Object> temp = new HashMap<String, Object>();
				List<Childmaterials> cms = childmaterialsService.getChildmaterials(a.getMid());
				result.add(new MaterialGroup(a, cms));
				// temp.put("ma",a);
				// temp.put("cm", cms);
				// result.add(temp);
			});
			return new ResponseData(ConstNums.FIND_OK, "找到", result.size(), result);
		} catch (Exception e) {
			return new ResponseData(ConstNums.FIND_ERROR, "错误", 1, e.getMessage());
		}
	}

	@PutMapping("materials/save")
	public Object upMaterialss(@RequestBody List<MaterialGroup> mlist) {
		try {
			List<MaterialGroup> addM = new ArrayList<MaterialGroup>();
			List<MaterialGroup> upM = new ArrayList<MaterialGroup>();
			List<MaterialGroup> resultM = new ArrayList<MaterialGroup>();
			List<Integer> delM = new ArrayList<Integer>();
			for (MaterialGroup a : mlist) {
				if (a.getMa().getMid() >= 0){
					if(a.getCm().size()==0)
					return new ResponseData(ConstNums.UPDATE_ERROR_PARAMETER, "子项为null", mlist.size(), mlist);
					int flag=0;
					for(int i=0;i<a.getCm().size();i++){
						if(a.getCm().get(i).getCmid()>=0) flag=1;
					}
					if(flag==0) new ResponseData(ConstNums.UPDATE_ERROR_PARAMETER, "子项全部被删除", mlist.size(), mlist);
				}
				
				if (a.getMa().getMid() > 0)
					upM.add(a);
				else if (a.getMa().getMid() < 0)
					delM.add(-a.getMa().getMid());
				else
					addM.add(a);
			}
			
			for(MaterialGroup a : addM){
				Materials ma = materialsService.addMaterial(a.getMa());
				List<Childmaterials> addCm = new ArrayList<Childmaterials>();
				List<Childmaterials> upCm = new ArrayList<Childmaterials>();
				List<Integer> delCm = new ArrayList<Integer>();
				List<Childmaterials> tempCm = new ArrayList<Childmaterials>();
				List<Childmaterials> resultCm = new ArrayList<Childmaterials>();
				for(Childmaterials b : a.getCm()){
					b.setMid(ma.getMid());
					if (b.getCmid() > 0)
						upCm.add(b);
					else if (b.getCmid() < 0)
						delCm.add(-b.getCmid());
					else
						addCm.add(b);
				}
				tempCm = childmaterialsService.addChildmaterials(addCm);
				tempCm.forEach(c -> {
					resultCm.add(c);
				});
				tempCm = childmaterialsService.upChildmaterials(upCm);
				tempCm.forEach(c -> {
					resultCm.add(c);
				});
				childmaterialsService.delChildmaterials(delCm);
				resultM.add(new MaterialGroup(ma, resultCm));
			}
			
			for(MaterialGroup a : upM){
				Materials ma = materialsService.addMaterial(a.getMa());
				List<Childmaterials> addCm = new ArrayList<Childmaterials>();
				List<Childmaterials> upCm = new ArrayList<Childmaterials>();
				List<Integer> delCm = new ArrayList<Integer>();
				List<Childmaterials> tempCm = new ArrayList<Childmaterials>();
				List<Childmaterials> resultCm = new ArrayList<Childmaterials>();
				for(Childmaterials b : a.getCm()){
					b.setMid(ma.getMid());
					if (b.getCmid() > 0)
						upCm.add(b);
					else if (b.getCmid() < 0)
						delCm.add(-b.getCmid());
					else
						addCm.add(b);
				}
				tempCm = childmaterialsService.addChildmaterials(addCm);
				tempCm.forEach(c -> {
					resultCm.add(c);
				});
				tempCm = childmaterialsService.upChildmaterials(upCm);
				tempCm.forEach(c -> {
					resultCm.add(c);
				});
				childmaterialsService.delChildmaterials(delCm);
				resultM.add(new MaterialGroup(ma, resultCm));
			}
			
			materialsService.delMaterials(delM);
			
			return new ResponseData(ConstNums.UPDATE_OK, "保存成功", resultM.size(), resultM);
		} catch (Exception e) {
			return new ResponseData(ConstNums.UPDATE_ERROR_SERVER, "错误", 1, e.getMessage());
		}

	}
}
