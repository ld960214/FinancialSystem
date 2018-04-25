/**
 * 
 */

var header_key=null;
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
			alert("登陆成功");
		},
		error:function(){
			alert("登录失败");
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