function fnLogin() {
	var userName = document.getElementById("username")
	var passWord = document.getElementById("password")
	var errorBox = document.getElementById("error_box")
	var isError = true;
	if (userName.value.length > 20 || userName.value.length < 6) {
		errorBox.innerHTML = "用户名请输入6-20位字符";
		isError = false;
		return false;
	}
	else if((userName.value.charCodeAt(0)>=48) && (userName.value.charCodeAt(0)<=57))
	{
		errorBox.innerHTML = "首字符必须为字母";
		return false;
	}	
	if (passWord.value.length > 20 || passWord.value.length < 6) 
	{
		errorBox.innerHTML = "密码请输入6-20位字符"
		isError = false;
		return false;
	}
	return true;
}