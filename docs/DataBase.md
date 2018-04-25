# 数据库说明

----

- [数据库说明](#数据库说明)
  - [数据库总览](#数据库总览)
  - [数据库明细](#数据库明细)

## 数据库总览

|数据库表|作用|
|:---|:---|
|[User](#User)|用户|
|[Projects](#Projects)|项目|
|[Subjects](#Subjects)|课题|
|[Devices](#Device)|设备|
|[Materials](#Materials)|材料|
|[Childmaterials](#Childmaterials)|材料子表|
|[Trips](#Trips)|差旅|
|[Conference](#Conference)|会议|
|[Iptf](#Iptf)|出版文献信息传播知识产权事务|


## 数据库明细

### User

|列名|作用|类型|是否可空|
|:---|:---|:----|:----:|
|userid|id，主键|int|✖|
|username|用户名|varchar(50)|✖|
|userpassword|密码|varchar(20)|✖|

### Projects

|列名|作用|类型|是否可空|
|:---|:---|:----|:----:|
|proid|id,主键|int|✖|
|proname|项目名称|varchar(100)|✖|
|protype|项目类型,便于拓展|int(3)|✖|
|userid|所属用户id,外键关联[User](#User)|✖|

### Subjects

|列名|作用|类型|是否可空|
|:---|:---|:----|:----:|
|subid|id,主键|int|✖|
|subname|课题名称|varchar(100)|✖|
|subtype|课题类型|int(3)|✖|
|proid|所属项目id,外键关联[Projects](#Projects)|✖|

### Devices

|列名|作用|类型|是否可空|
|:---|:---|:----|:----:|
|did|id，主键|int|✖|
|introduction|设备介绍|varchar(1024)|✖|
|dname|设备名称|varchar(100)|✖|
|unitprice|设备单价,具体到元不接受角分|int|✖|
|dtype|设备具体规格参数|varchar(100)|✖|
|subid|所属课题id,外键关联[Subjects](#Subjects)|✖|

### Materials

|列名|作用|类型|是否可空|
|:---|:---|:----|:----:|
|mid|id,主键|int|✖|
|maname|材料模块名称|varchar(100)|✖|
|mdes|材料描述|varchar(1024)|✖|
|subid|所属课题id,外键关联[Subjects](#Subjects)|✖|

### Childmaterials

|列名|作用|类型|是否可空|
|:---|:---|:----|:----:|
|cmid|id,主键|int|✖|
|cmname|材料名|varchar(100)|✖|
|cmamount|数量|int|✖|
|cmperprice|单价,具体到元不接受角分|int|✖|
|mid|所属材料表id,外键关联[Childmaterials](#Childmaterials)|int|✖|

### Trips

差旅费计算公式  总=人数✖人次✖(补助✖天数+单价)

|列名|作用|类型|是否可空|
|:---|:---|:----|:----:|
|tid|id,主键|int|✖|
|tname|差旅名|varchar(100)|✖|
|tdes|差旅描述|varchar(1024)|✖|
|tdays|差旅天数|int|✖|
|tamount|差旅人数|int|✖|
|tperprice|差旅单价,具体到元不接受角分|int|✖|
|tallowance|差旅补助|int|✖|
|subid|所属课题表id,外键关联[Subjects](#Subjects)|int|✖|

### Conference

|列名|作用|类型|是否可空|
|:---|:---|:----|:----:|
|cid|id,主键|int|✖|
|cname|会议名|varchar(100)|✖|
|ctopic|会议主要议题|varchar(100)|✖|
|ctime|会议时间,字符串形式|vvarchar(45)|✖|
|cdays|会议天数|int|✖|
|camount|会议人数|int|✖|
|cdes|会议描述|varchar(1024)|✖|
|subid|所属课题表id,外键关联[Subjects](#Subjects)|int|✖|

### Iptf

|列名|作用|类型|是否可空|
|:---|:---|:----|:----:|
|iid|id,主键|int|✖|
|iname|费用名|varchar(100)|✖|
|ides|费用描述|varchar(1024)|✖|
|iperprice|费用单价|int|✖|
|iamount|费用数量|int|✖|
|subid|所属课题表id,外键关联[Subjects](#Subjects)|int|✖|

