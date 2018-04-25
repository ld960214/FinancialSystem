# 接口说明

-------

- [接口说明](#接口说明)
  - [接口总览](#接口总览)
  - [接口模块明细](#接口模块明细)
  - [接口明细](#接口明细)

## 接口总览

|区域|作用|
|:---|:---|
|[用户模块](#用户模块)|用户信息CURD|
|[项目模块](#项目模块)|项目及下属表CURD|
|[功能模块](#功能模块)|包括信息下载|
|[安全模块](#安全模块)|包括登录登出操作|

## 接口模块明细

### 用户模块

|接口名|含有操作|权限|
|:---|:----|:---|
|[/api/user](#1.1)|CURD|0101|

### 项目模块

### 功能模块

### 安全模块

### 接口明细

<h5 id="1.1">/api/user</h5>

<font color="green">C</font>: 

<font color="red">命令</font>:Post 

<font color="red">数据</font> : ``` { "username": username,"password":passowrd} ```

<font color="red">返回</font> : 

实例 ``` {"rescode":rescode,"resString":resString,"resnum":1,"data":null} ```

|rescode|resString|
|:----|:----|
|1|注册成功|
|2|用户名已存在|
|3|注册失败|

<font color="green">U</font>: 

<font color="red">命令</font>:Put

<font color="red">数据</font> : ``` {"userid":userid ,"username": username,"password":passowrd} ```

<font color="red">返回</font> : 

实例 ``` {"rescode":rescode,"resString":resString,"resnum":1,"data":null} ```

|rescode|resString|
|:----|:----|
|1|修改成功|
|2|用户名已存在|
|3|注册失败|



