function fnCreate() {
	var npName = document.getElementById("newProjectName");
	var errorBox = document.getElementById("error_box");
	var isError = true;
	if (npName.value.length <1) {
		errorBox.innerHTML = "项目名称不能为空";
		isError = false;
		return;
	}
	window.alert("创建成功");
	window.location.href ='buydevice.html';
}