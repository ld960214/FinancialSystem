/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50543
Source Host           : localhost:3306
Source Database       : budget

Target Server Type    : MYSQL
Target Server Version : 50543
File Encoding         : 65001

Date: 2018-04-03 09:46:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `amountlimit`
-- ----------------------------
DROP TABLE IF EXISTS `amountlimit`;
CREATE TABLE `amountlimit` (
  `aId` int(11) NOT NULL AUTO_INCREMENT,
  `aEstimateFinance` double(6,0) DEFAULT NULL,
  `aActualFinance` double(6,0) DEFAULT NULL,
  `sId` int(11) NOT NULL,
  `typeId` int(3) NOT NULL,
  PRIMARY KEY (`aId`),
  KEY `TA` (`typeId`),
  KEY `TS` (`sId`),
  CONSTRAINT `TA` FOREIGN KEY (`typeId`) REFERENCES `type` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `TS` FOREIGN KEY (`sId`) REFERENCES `subject` (`sId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of amountlimit
-- ----------------------------

-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `dId` int(11) NOT NULL AUTO_INCREMENT,
  `deviceName` varchar(50) DEFAULT NULL,
  `deviceVersion` varchar(50) DEFAULT NULL,
  `devicePrice` double(6,0) DEFAULT NULL,
  `deviceNum` int(5) DEFAULT NULL,
  `dTotalFinance` double(6,0) DEFAULT NULL,
  `dPurpose` varchar(1000) DEFAULT NULL,
  `dParameter` varchar(1000) DEFAULT NULL,
  `dBasis` varchar(1000) DEFAULT NULL,
  `sId` int(11) NOT NULL,
  `typeId` int(3) NOT NULL,
  PRIMARY KEY (`dId`),
  KEY `DD` (`sId`),
  KEY `tt` (`typeId`),
  CONSTRAINT `DD` FOREIGN KEY (`sId`) REFERENCES `subject` (`sId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tt` FOREIGN KEY (`typeId`) REFERENCES `type` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------

-- ----------------------------
-- Table structure for `directfinance`
-- ----------------------------
DROP TABLE IF EXISTS `directfinance`;
CREATE TABLE `directfinance` (
  `directId` int(11) NOT NULL AUTO_INCREMENT,
  `typeId` int(3) NOT NULL,
  `totalFinance` double(6,0) NOT NULL,
  `specialFinance` double(6,0) NOT NULL,
  `selfFinance` double(6,0) DEFAULT '0',
  `sId` int(11) NOT NULL,
  PRIMARY KEY (`directId`),
  KEY `TD` (`typeId`),
  KEY `ST` (`sId`),
  CONSTRAINT `ST` FOREIGN KEY (`sId`) REFERENCES `subject` (`sId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `TD` FOREIGN KEY (`typeId`) REFERENCES `type` (`typeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of directfinance
-- ----------------------------

-- ----------------------------
-- Table structure for `material`
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `mId` int(11) NOT NULL AUTO_INCREMENT,
  `mName` varchar(50) DEFAULT NULL,
  `mNum` int(5) DEFAULT NULL,
  `mPrice` double(6,0) DEFAULT NULL,
  `mTotal` double(6,0) DEFAULT NULL,
  `mPurpose` varchar(1000) DEFAULT NULL,
  `mParameter` varchar(1000) DEFAULT NULL,
  `mBasis` varchar(1000) DEFAULT NULL,
  `sId` int(11) NOT NULL,
  PRIMARY KEY (`mId`),
  KEY `md` (`sId`),
  CONSTRAINT `md` FOREIGN KEY (`sId`) REFERENCES `subject` (`sId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------

-- ----------------------------
-- Table structure for `meeting`
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `meId` int(11) NOT NULL AUTO_INCREMENT,
  `meName` varchar(50) DEFAULT NULL,
  `meContent` varchar(300) DEFAULT NULL,
  `meDate` datetime DEFAULT NULL,
  `meDays` int(3) DEFAULT NULL,
  `mePNum` int(5) DEFAULT NULL,
  `meDes` varchar(1000) DEFAULT NULL,
  `meTotalDes` varchar(1000) DEFAULT NULL,
  `sId` int(11) NOT NULL,
  PRIMARY KEY (`meId`),
  KEY `ms` (`sId`),
  CONSTRAINT `ms` FOREIGN KEY (`sId`) REFERENCES `subject` (`sId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meeting
-- ----------------------------

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `pId` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(50) NOT NULL,
  `projectType` varchar(50) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`pId`),
  KEY `UP` (`userId`),
  CONSTRAINT `UP` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------

-- ----------------------------
-- Table structure for `publish`
-- ----------------------------
DROP TABLE IF EXISTS `publish`;
CREATE TABLE `publish` (
  `puId` int(11) NOT NULL AUTO_INCREMENT,
  `puNum` int(11) DEFAULT NULL,
  `puDes` varchar(1000) DEFAULT NULL,
  `ptId` int(11) DEFAULT NULL,
  `sId` int(11) DEFAULT NULL,
  PRIMARY KEY (`puId`),
  KEY `PP` (`ptId`),
  KEY `ps` (`sId`),
  CONSTRAINT `PP` FOREIGN KEY (`ptId`) REFERENCES `publishtype` (`ptId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ps` FOREIGN KEY (`sId`) REFERENCES `subject` (`sId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publish
-- ----------------------------

-- ----------------------------
-- Table structure for `publishtype`
-- ----------------------------
DROP TABLE IF EXISTS `publishtype`;
CREATE TABLE `publishtype` (
  `ptId` int(11) NOT NULL AUTO_INCREMENT,
  `ptName` varchar(50) DEFAULT NULL,
  `ptDes` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ptId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publishtype
-- ----------------------------
INSERT INTO `publishtype` VALUES ('1', '论文费', '按照课题预定指标，课题发表n篇学术论文，按国内论文版面费2500元/篇、国际学术会议投稿注册费7000元/篇计算（以大数据和机器学习领域知名的国际会议注册费测算）；预计国内发表n篇，国外投稿发表n篇计算，论文费支出：0.25万元/篇×n篇+0.7万元/篇×n篇=n万元。');
INSERT INTO `publishtype` VALUES ('2', '专利费', '按照课题预定指标，课题申请专利n项，专利申请费及代理费按5000元/项计算，专利费支出：0.5万元/项×n项=n万元。');
INSERT INTO `publishtype` VALUES ('3', '软件著作权', '按照课题预定指标，课题申请n项软件著作权，按1000元/项计算，软件著作权支出：0.1万元/项×n项=0.30万元。');

-- ----------------------------
-- Table structure for `subject`
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `sId` int(11) NOT NULL AUTO_INCREMENT,
  `subjectName` varchar(50) NOT NULL,
  `sEstimateFinance` double(6,0) NOT NULL,
  `sActualFinance` double(6,0) DEFAULT NULL,
  `specialFinance` double(6,0) NOT NULL,
  `selfFinance` double(6,0) DEFAULT NULL,
  `sTotalFinance` double(6,0) NOT NULL,
  `directFinance` double(6,0) NOT NULL,
  `indirectFinance` double(6,0) NOT NULL,
  `PId` int(11) NOT NULL,
  PRIMARY KEY (`sId`),
  KEY `SP` (`PId`),
  CONSTRAINT `SP` FOREIGN KEY (`PId`) REFERENCES `project` (`pId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------

-- ----------------------------
-- Table structure for `trip`
-- ----------------------------
DROP TABLE IF EXISTS `trip`;
CREATE TABLE `trip` (
  `trId` int(11) NOT NULL AUTO_INCREMENT,
  `trDays` int(11) DEFAULT NULL,
  `trPNum` int(6) DEFAULT NULL,
  `trCityNum` int(6) DEFAULT NULL,
  `trDes` varchar(1000) DEFAULT NULL,
  `trDesTotal` varchar(1000) DEFAULT NULL,
  `sId` int(11) NOT NULL,
  `meId` int(11) NOT NULL,
  `ttId` int(11) NOT NULL,
  PRIMARY KEY (`trId`),
  KEY `trs` (`sId`),
  KEY `trm` (`meId`),
  KEY `tti` (`ttId`),
  CONSTRAINT `trm` FOREIGN KEY (`meId`) REFERENCES `meeting` (`meId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trs` FOREIGN KEY (`sId`) REFERENCES `subject` (`sId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tti` FOREIGN KEY (`ttId`) REFERENCES `triptype` (`ttId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trip
-- ----------------------------

-- ----------------------------
-- Table structure for `triptype`
-- ----------------------------
DROP TABLE IF EXISTS `triptype`;
CREATE TABLE `triptype` (
  `ttId` int(11) NOT NULL AUTO_INCREMENT,
  `ttName` varchar(50) DEFAULT NULL,
  `ttDes` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ttId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of triptype
-- ----------------------------
INSERT INTO `triptype` VALUES ('1', '业务需求与发展动态调研差旅费', '摸透政府、行业业务大数据的用户需求、数据集成及应用研发现状、产业趋势、发展动态，对课题各技术方案的定型至关重要。课题组将根据需要，联系协调政府及行业各类业务单位、数据产品开发机构、知名企业与机构等进行需求调研、现有数据应用实况调研、大数据融合应用产业发展动态与趋势调研。拟选择政府及社会开放大数据应用基础较好的n、n、n和n等进行业务需求、最新产品与趋势调研，每个城市n次，平均每个城市n天，选取课题骨干人员n人参加。此项差旅费小计：n人×n城市×（530×n天+1000）元/人次=n万元。');
INSERT INTO `triptype` VALUES ('2', '专家咨询产生的差旅费', '课题执行期间，将邀请从事大数据分析、挖掘和可视化理论和技术研究、机器学习技术研究专家以及财务专家，参加课题技术方案专题论证会（共n次课题专题论证，每次n人）、项目组关联课题技术集成会议（n次、每次n人）、课题中期检查会（n次，每次n人）、课题验收会（n次，每次n人），共计n人次，本地专家控制n比例，外地专家n比例。外专家平均按2000元/次的差旅费标准，为此差旅费支出小计：n人次×2500元/人次 = n万元。');

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `typeId` int(3) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(50) NOT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '设备费');
INSERT INTO `type` VALUES ('2', '购置设备费');
INSERT INTO `type` VALUES ('3', '试制设备费');
INSERT INTO `type` VALUES ('4', '设备改造与租赁费');
INSERT INTO `type` VALUES ('5', '材料费');
INSERT INTO `type` VALUES ('6', '测试化验加工费');
INSERT INTO `type` VALUES ('7', '燃料动力费');
INSERT INTO `type` VALUES ('8', '差旅费');
INSERT INTO `type` VALUES ('9', '会议费');
INSERT INTO `type` VALUES ('10', '国际合作与交流费');
INSERT INTO `type` VALUES ('11', '出版/文献/信息传播/知识产权事务费');
INSERT INTO `type` VALUES ('12', '劳务费');
INSERT INTO `type` VALUES ('13', '专家咨询费');
INSERT INTO `type` VALUES ('14', '其他支出');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `userPassword` char(20) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '贺玉', '112');
