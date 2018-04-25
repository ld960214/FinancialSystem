function fnRegister() {
 var rUsername = document.getElementById("rusername")
 var rPassWord = document.getElementById("rpassword")
 var rErrorBox = document.getElementById("rerror_box")
 var isError = true;
 if (rUsername.value.length > 20 || rUsername.value.length < 6) {
  rErrorBox.innerHTML = "用户名请输入6-20位字符";
  isError = false;
  return false;
 }else if((rUsername.value.charCodeAt(0)>=48) && (rUsername.value.charCodeAt(0)<=57)){
  rErrorBox.innerHTML = "首字符必须为字母";
  return false;
 }
 
 
 if (rPassWord.value.length > 20 || rPassWord.value.length < 6) {
  rErrorBox.innerHTML = "密码请输入6-20位字符"
  isError = false;
  return false;
 }
 var data = {"username" : rUsername.value,
		 "password" : rPassWord.value};
 
 $.post("/api/user",data,function(result){
	    alert(result);
	    });
 
}

