package com.Blacat.Ouc.ResponseTools;

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blacat.Ouc.Entities.Childmaterials;
import com.Blacat.Ouc.Entities.Conference;
import com.Blacat.Ouc.Entities.Devices;
import com.Blacat.Ouc.Entities.Iptf;
import com.Blacat.Ouc.Entities.Materials;
import com.Blacat.Ouc.Entities.Trips;
import com.Blacat.Ouc.Services.ChildmaterialsService;
import com.Blacat.Ouc.Services.ConferenceService;
import com.Blacat.Ouc.Services.DevicesService;
import com.Blacat.Ouc.Services.IptfService;
import com.Blacat.Ouc.Services.MaterialsService;
import com.Blacat.Ouc.Services.SubjectsService;
import com.Blacat.Ouc.Services.TripsService;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class WordService {
	@Autowired
	SubjectsService subjectsService;

	@Autowired
	DevicesService devicesService;

	@Autowired
	TripsService tripsService;

	@Autowired
	IptfService iptfService;

	@Autowired
	ConferenceService conferenceService;

	@Autowired
	MaterialsService materialsService;

	@Autowired
	ChildmaterialsService childmaterialsService;

	public Map<String, Object> getWord(int subid){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int AllNum=0;
		//Devices部分
		int DNum =0;
		int DAmount=0;
		List<Devices> DList= devicesService.getDevices(subid);
		List<Map<String,Object>> DeviceList = new ArrayList<Map<String,Object>>();
		for(int i=0;i<DList.size();i++){
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("order", i+1);
			temp.put("dname", DList.get(i).getDname());
			temp.put("introduction", DList.get(i).getIntroduction());
			temp.put("damount", DList.get(i).getDamount());
			temp.put("dtype",DList.get(i).getDtype() );
			double unitprice = 1.0*DList.get(i).getUnitprice()/10000;
			temp.put("unitprice", String.format("%.2f", unitprice));
			int allpriceInt = DList.get(i).getUnitprice()*DList.get(i).getDamount();
			DNum+=allpriceInt;
			double allprice = 1.0*allpriceInt/10000;
			temp.put("allprice", String.format("%.2f", allprice));
			DAmount+=DList.get(i).getDamount();
			DeviceList.add(temp);
		}
		dataMap.put("DeviceList", DeviceList);
		dataMap.put("DeviceAmount",DAmount);
		dataMap.put("DeviceNum3", String.format("%.2f", 1.0*DNum/10000));
		dataMap.put("DeviceNum2", String.format("%.2f", (float)(int)(1.0*DNum/10000+0.5)));
		dataMap.put("DeviceNum", String.format("%d",(int)(1.0*DNum/10000+0.5)));
		AllNum+=DNum;
		//Trips部分
		int TNum=0;
		List<Trips> TList = tripsService.getTrips(subid);
		List<Map<String,Object>> TripList = new ArrayList<Map<String,Object>>();
		for(int i=0;i<TList.size();i++){
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("order",i+1);
			temp.put("tname", TList.get(i).getTname());
			temp.put("tdes", TList.get(i).getTdes());
			int a=TList.get(i).getTdays();
			int b=TList.get(i).getTamount();
			int c=TList.get(i).getTperprice();
			int d=TList.get(i).getTallowance();
			int e=TList.get(i).getTtimes();
			String cal = ""+b+"×";
			if(e!=1) cal=cal+e+"×";
			if(c!=0) {
				cal=cal+"("+c+"×"+a;
				if(d!=0) cal =cal+"+"+d;
				cal=cal+")";
			}else if(d!=1){
				cal=cal+d;
			}
			temp.put("cal", cal);
			int allprice=b*e*(a*c+d);
			TNum+=allprice;
			temp.put("allprice", String.format("%.2f", 1.0*allprice/10000));
			TripList.add(temp);
		}
		dataMap.put("TripList", TripList);
		dataMap.put("TripNum3", String.format("%.2f", 1.0*TNum/10000));
		dataMap.put("TripNum2", String.format("%.2f", (float)(int)(1.0*TNum/10000+0.5)));
		dataMap.put("TripNum", String.format("%d",(int)(1.0*TNum/10000+0.5)));
		AllNum+=TNum;
		//Material部分
		int MNum=0;
		List<Materials> MList = materialsService.getMaterials(subid);
		List<Map<String,Object>> MaterialList = new ArrayList<Map<String,Object>>();
		for(int i=0;i<MList.size();i++){
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("order", i+1);
			temp.put("maname", MList.get(i).getManame());
			temp.put("mdes", MList.get(i).getMdes());
			int allprice =0;
			//
			//孩子部分
			//
			List<Childmaterials> CList = childmaterialsService.getChildmaterials(MList.get(i).getMid());
			List<Map<String,Object>> Child = new ArrayList<Map<String,Object>>();
			for(int j=0;j<CList.size();j++){
				Map<String, Object> temp2 = new HashMap<String, Object>();
				temp2.put("order", j+1);
				temp2.put("cmname", CList.get(j).getCmname());
				temp2.put("cmamount",CList.get(j).getCmamount());
				temp2.put("cmperprice", CList.get(j).getCmperprice());
				int callprice = CList.get(j).getCmamount()*CList.get(j).getCmperprice();
				allprice+=callprice;
				temp2.put("allprice", String.format("%.2f", 1.0*callprice/10000));
				temp2.put("cmperprice2", String.format("%.2f", 1.0*CList.get(j).getCmperprice()/10000));
				Child.add(temp2);
			}
			MNum+=allprice;
			temp.put("child",Child);
			temp.put("allprice", String.format("%.2f", 1.0*allprice/10000));
			MaterialList.add(temp);
		}
		dataMap.put("MaterialList", MaterialList);
		dataMap.put("MaterialNum3", String.format("%.2f", 1.0*MNum/10000));
		dataMap.put("MaterialNum2", String.format("%.2f", (float)(int)(1.0*MNum/10000+0.5)));
		dataMap.put("MaterialNum", String.format("%d",(int)(1.0*MNum/10000+0.5)));
		AllNum+=MNum;
		//Conference部分
		int CNum=0;
		List<Conference> CList =conferenceService.getConferences(subid);
		List<Map<String,Object>> ConferenceList = new ArrayList<Map<String,Object>>();
		for(int i=0;i<CList.size();i++){
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("order", i+1);
			temp.put("cname", CList.get(i).getCname());
			temp.put("ctopic",CList.get(i).getCtopic());
			temp.put("ctime", CList.get(i).getCtime());
			temp.put("cdays", CList.get(i).getCdays());
			temp.put("camount", CList.get(i).getCamount());
			temp.put("cdes", CList.get(i).getCdes());
			temp.put("cperprice", CList.get(i).getCperprice());
			int allprice = CList.get(i).getCamount()*CList.get(i).getCdays()*CList.get(i).getCperprice();
			CNum+=allprice;
			temp.put("allprice", String.format("%.2f", 1.0*allprice/10000));
			ConferenceList.add(temp);
		}
		dataMap.put("ConferenceList", ConferenceList);
		dataMap.put("ConferenceNum3", String.format("%.2f", 1.0*CNum/10000));
		dataMap.put("ConferenceNum2", String.format("%.2f", (float)(int)(1.0*CNum/10000+0.5)));
		dataMap.put("ConferenceNum", String.format("%d",(int)(1.0*CNum/10000+0.5)));
		AllNum+=CNum;
		//Iptf部分
		int INum=0;
		List<Iptf> IList=iptfService.getIptfs(subid);
		List<Map<String,Object>> IptfList = new ArrayList<Map<String,Object>>();
		for(int i=0;i<IList.size();i++){
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("order", i+1);
			temp.put("iname", IList.get(i).getIname());
			temp.put("ides", IList.get(i).getIdes());
			temp.put("iperprice", IList.get(i).getIperprice());
			temp.put("iamount", IList.get(i).getIamount());
			int allprice=IList.get(i).getIamount()*IList.get(i).getIperprice();
			INum+=allprice;
			temp.put("allprice", String.format("%.2f", 1.0*allprice/10000));
			IptfList.add(temp);
		}
		dataMap.put("IptfList", IptfList);
		dataMap.put("IptfNum3", String.format("%.2f", 1.0*INum/10000));
		dataMap.put("IptfNum2", String.format("%.2f", (float)(int)(1.0*INum/10000+0.5)));
		dataMap.put("IptfNum", String.format("%d",(int)(1.0*INum/10000+0.5)));
		AllNum+=CNum;
		dataMap.put("AllNum",String.format("%d",(int)(1.0*AllNum/10000+0.5)) );
		return dataMap;
	}

}
