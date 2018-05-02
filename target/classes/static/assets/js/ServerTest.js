/**
 * 
 */

var header_key=null;
var userid=null;
var proid=null;
var subid=null;


console.log("本页面为测试页面，使用前请阅读一下内容\n");
console.log("除了用户模块，之后所有模块都需要先登录获取token后点击\n");
console.log("除了项目添加的用户id为自动获取操作，其余请选择查询上一级的列表获取相应id\n");
console.log("课题下的所有项目均有查询和更新，查询须控制台写入subid值，更新请看js中各函数data项，值得注意的是，更新规则根据id判断分别为:\n");
console.log("更新 id不变 , 删除 id变为负数 , 添加 id=0");

var okdata = {
		username: 'admin1',
		userpassword: 'admin11'
	};

var errdata = {
		username: 'admin12',
		userpassword: 'admin11'
	};

function pubclick(){
	var data = {
		userid:	4,
		username: 'admin1',
		userpassword: 'admin11'
	};
	
	$.ajaxSetup({  
        contentType : 'application/json'  
    });
	
	$.ajax({
		url: '/api/user',
		type:'PUT',
		data: JSON.stringify(data),
		success: function(result){
			alert(JSON.stringify(result));
		}
	});
}

function login(data){

	$.ajaxSetup({  
        contentType : 'application/json'  
    });
	$.ajax({
		url: '/api/login',
		type:'POST',
		data: JSON.stringify(data),
		success: function(data, textStatus, request){
			header_key=request.getResponseHeader("Authorization");
			userid=data - 0;
			alert("登陆成功");
		},
		error:function(){
			alert("登录失败");
		}
	});
}

function reg(){
	var data = {
			username: 'admin1',
			userpassword: 'admin11'
		};

	$.ajax({
		url: 'api/user',
		type:'POST',
		data: data,
		success: function(result){
			alert(JSON.stringify(result));
		},
		error:function(){
			alert("注册失败");
		}
	});
}

function tche(){

	$.ajax({
		url: '/api/test',
		type:'GET',
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}




$("#putuser").click(function(){
	pubclick();
});

$("#erroruser").click(function(){
	login(errdata);
})
$("#okuser").click(function(){
	login(okdata);
})

$("#tcheck").click(function(){
	tche();
});

$("#register").click(function(){
	reg();
});

//
//项目
//
//
function addp(){
	var data = {
		proname:'测试用项目',
		protype:1,
		userid:userid
	}
	$.ajaxSetup({  
        contentType : 'application/json'  
    });
	$.ajax({
		url: '/api/project',
		type:'POST',
		data: JSON.stringify(data),
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

function listp(){
	$.ajax({
		url: '/api/projects/'+userid,
		type:'GET',
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

function upp(){
	var data = {
			proid:1,
			proname:'测试用项目',
			protype:2,
			userid:userid
		}
	$.ajaxSetup({  
        contentType : 'application/json'  
    });
	$.ajax({
		url: '/api/project',
		type:'PUT',
		data: JSON.stringify(data),
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

function delp(){
	$.ajax({
		url: '/api/project/'+proid,
		type:'DELETE',
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}


$("#addp").click(function(){
	addp();
});

$("#listp").click(function(){
	listp();
});
$("#upp").click(function(){
	upp();
});
$("#delp").click(function(){
	delp();
});

//
//课题
//
//

function adds(){
	var data = {
		subname:'测试用项目',
		subtype:1,
		proid:proid
	}
	$.ajaxSetup({  
        contentType : 'application/json'  
    });
	$.ajax({
		url: '/api/subject',
		type:'POST',
		data: JSON.stringify(data),
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

function lists(){
	$.ajax({
		url: '/api/subjects/'+proid,
		type:'GET',
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

function ups(){
	var data = {
			subid:subid,
			subname:'测试用项目',
			subtype:2,
			proid:proid
		}
	$.ajaxSetup({  
        contentType : 'application/json'  
    });
	$.ajax({
		url: '/api/subject',
		type:'PUT',
		data: JSON.stringify(data),
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

function dels(){
	$.ajax({
		url: '/api/subject/'+subid,
		type:'DELETE',
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}


$("#adds").click(function(){
	adds();
});

$("#lists").click(function(){
	lists();
});
$("#ups").click(function(){
	ups();
});
$("#dels").click(function(){
	dels();
});
//
//设备
//
//

function listd(){
	$.ajax({
		url: '/api/devices/'+subid,
		type:'GET',
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

function upd(){

	var data = [{
		did:null,
		introduction:'这是一个测试用项目',
		dname:"项目1",
		unitprice:1000,
		damount: 2,
		dtype:"hR1型",
		subid:subid
	},{
		did:null,
		introduction:'这是第二个测试用项目',
		dname:"项目2",
		unitprice:1000,
		dtype:"hR2型",
		subid:subid
	},{
		did:null,
		introduction:'这是第三个测试用项目',
		dname:"项目3",
		unitprice:1000,
		dtype:"hR3型",
		subid:subid
	}];
	
	$.ajaxSetup({  
        contentType : 'application/json'  
    });
	$.ajax({
		url: '/api/devices/save',
		type:'PUT',
		data: JSON.stringify(data),
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

$("#listd").click(function(){
	listd();
});
$("#upd").click(function(){
	upd();
});

//
//差旅
//
//

function listt(){
	$.ajax({
		url: '/api/trips/'+subid,
		type:'GET',
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

function upt(){

	var data = [{
		tid:null,
		tdes:'这是一个测试用差旅',
		tname:"差旅1",
		tperprice:1000,
		tdays:2,
		ttimes:3,
		tamount:2,
		tallowance:1000,
		subid:subid
	},
	{
		tid:null,
		tdes:'这是一个测试用差旅',
		tname:"差旅2",
		tperprice:1000,
		tdays:2,
		ttimes:3,
		tamount:2,
		tallowance:1000,
		subid:subid
	}];
	
	$.ajaxSetup({  
      contentType : 'application/json'  
  });
	$.ajax({
		url: '/api/trips/save',
		type:'PUT',
		data: JSON.stringify(data),
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

$("#listt").click(function(){
	listt();
});
$("#upt").click(function(){
	upt();
});

//
//差旅
//
//

function listc(){
	$.ajax({
		url: '/api/conferences/'+subid,
		type:'GET',
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

function upc(){

	var data = [{
		cid:null,
		cdes:'这是一个测试用差旅',
		cname:"会议1",
		ctopic:"我就是个会议1的议题",
		ctime:"2018-04",
		cdays:2,
		camount:2,
		cperprice:100,
		subid:subid
	}];
	
	$.ajaxSetup({  
    contentType : 'application/json'  
});
	$.ajax({
		url: '/api/conferences/save',
		type:'PUT',
		data: JSON.stringify(data),
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

$("#listc").click(function(){
	listc();
});
$("#upc").click(function(){
	upc();
});

//
//文献出版信息传播知识产权
//
//

function listi(){
	$.ajax({
		url: '/api/iptfs/'+subid,
		type:'GET',
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

function upi(){

	var data = [{
		iid:null,
		ides:'这是一个测试用产权',
		iname:"产权1",
		iperprice:2,
		iamount:2,
		subid:subid
	}];
	
	$.ajaxSetup({  
  contentType : 'application/json'  
});
	$.ajax({
		url: '/api/iptfs/save',
		type:'PUT',
		data: JSON.stringify(data),
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

$("#listi").click(function(){
	listi();
});
$("#upi").click(function(){
	upi();
});

//
//材料
//
//

function listm(){
	$.ajax({
		url: '/api/materials/'+subid,
		type:'GET',
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

function upm(){

	var data = [
	    {
	        "ma":{
	            "mid":1,
	            "maname":"材料1",
	            "mdes":"这是材料1的描述",
	            "subid":1
	        },
	        "cm":[
	            {
	                "cmid":1,
	                "cmname":"材料1的材料1",
	                "cmamount":3,
	                "cmperprice":100,
	                "mid":1
	            },
	            {
	                "cmid":2,
	                "cmname":"材料1的材料2",
	                "cmamount":1,
	                "cmperprice":1000,
	                "mid":1
	            }
	        ]
	    },
	    {
	        "ma":{
	            "mid":2,
	            "maname":"材料2",
	            "mdes":"这是材料2的描述",
	            "subid":1
	        },
	        "cm":[
	            {
	                "cmid":3,
	                "cmname":"材料2的材料1",
	                "cmamount":1,
	                "cmperprice":10000,
	                "mid":2
	            }
	        ]
	    }
	];
	
	$.ajaxSetup({  
contentType : 'application/json'  
});
	$.ajax({
		url: '/api/materials/save',
		type:'PUT',
		data: JSON.stringify(data),
		headers: {
			Authorization : header_key,
		  },
		success: function(result){
			alert(JSON.stringify(result));
		},
		error: function(result){
			alert(JSON.stringify(result));
		}
	});
}

$("#listm").click(function(){
	listm();
});
$("#upm").click(function(){
	upm();
});

//
//下载
//
function getword(){
    var xhr = new XMLHttpRequest();
    xhr.open("GET", '/api/word/'+subid, true);
    xhr.setRequestHeader("Authorization",header_key,);
    xhr.responseType = 'blob';
    xhr.send();
}

$("#getword").click(function(){
	getword();
});