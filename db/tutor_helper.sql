/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : tutor_helper

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2019-10-27 23:19:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `attendance_id` int(11) NOT NULL AUTO_INCREMENT,
  `attendance_name` varchar(255) DEFAULT NULL,
  `attendance_type` varchar(255) DEFAULT NULL,
  `attendance_time` varchar(255) DEFAULT NULL,
  `attendance_address` varchar(255) DEFAULT NULL,
  `attendance_manager` varchar(255) DEFAULT NULL,
  `attendance_state` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`attendance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of attendance
-- ----------------------------

-- ----------------------------
-- Table structure for attendance_record
-- ----------------------------
DROP TABLE IF EXISTS `attendance_record`;
CREATE TABLE `attendance_record` (
  `attendance_record_id` int(11) NOT NULL AUTO_INCREMENT,
  `attendance_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `attendance_record_time` varchar(255) DEFAULT NULL,
  `attendance_record_address` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`attendance_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of attendance_record
-- ----------------------------

-- ----------------------------
-- Table structure for base_cert
-- ----------------------------
DROP TABLE IF EXISTS `base_cert`;
CREATE TABLE `base_cert` (
  `cert_id` int(11) NOT NULL AUTO_INCREMENT,
  `cert_name` varchar(255) DEFAULT NULL,
  `cert_describe` varchar(255) DEFAULT NULL,
  `cert_type` varchar(255) DEFAULT NULL,
  `cert_logo` varchar(255) DEFAULT NULL,
  `cert_lssuer` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cert_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_cert
-- ----------------------------

-- ----------------------------
-- Table structure for base_class
-- ----------------------------
DROP TABLE IF EXISTS `base_class`;
CREATE TABLE `base_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `school_id` int(11) DEFAULT NULL,
  `college_id` int(11) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `class_regis_time` varchar(255) DEFAULT NULL,
  `class_stu_num` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_class
-- ----------------------------

-- ----------------------------
-- Table structure for base_college
-- ----------------------------
DROP TABLE IF EXISTS `base_college`;
CREATE TABLE `base_college` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `school_id` int(11) DEFAULT NULL,
  `college_name` varchar(255) DEFAULT NULL,
  `college_describe` varchar(255) DEFAULT NULL,
  `college_logo` varchar(255) DEFAULT NULL,
  `college_stu_num` varchar(255) DEFAULT NULL,
  `college_regis_time` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_college
-- ----------------------------

-- ----------------------------
-- Table structure for base_commodity
-- ----------------------------
DROP TABLE IF EXISTS `base_commodity`;
CREATE TABLE `base_commodity` (
  `commodity_id` int(11) NOT NULL,
  `commodity_name` varchar(255) DEFAULT NULL,
  `commodity_price` varchar(255) DEFAULT NULL,
  `commodity_img` varchar(255) DEFAULT NULL,
  `commodity_old_price` varchar(255) DEFAULT NULL,
  `commodity_describe` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `commodity_provider` varchar(255) DEFAULT NULL,
  `commodity_produce_time` varchar(255) DEFAULT NULL,
  `commodity_validity` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`commodity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_commodity
-- ----------------------------

-- ----------------------------
-- Table structure for base_course
-- ----------------------------
DROP TABLE IF EXISTS `base_course`;
CREATE TABLE `base_course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL,
  `course_lecturer` varchar(255) DEFAULT NULL COMMENT '讲师',
  `course_type` varchar(255) DEFAULT NULL,
  `course_state` varchar(255) DEFAULT NULL,
  `course_stu_num` int(11) DEFAULT NULL,
  `course_address` varchar(255) DEFAULT NULL,
  `course_abstract` varchar(255) DEFAULT NULL,
  `course_detail` varchar(255) DEFAULT NULL,
  `course_time` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of base_course
-- ----------------------------

-- ----------------------------
-- Table structure for base_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `base_enterprise`;
CREATE TABLE `base_enterprise` (
  `enterprise_id` int(11) NOT NULL AUTO_INCREMENT,
  `enterprise_name` varchar(255) DEFAULT NULL,
  `enterprise_describe` varchar(255) DEFAULT NULL,
  `enterprise_logo` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `enterprise_people_num` varchar(255) DEFAULT NULL,
  `enterprise_regis_time` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`enterprise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_enterprise
-- ----------------------------

-- ----------------------------
-- Table structure for base_enterprise_type
-- ----------------------------
DROP TABLE IF EXISTS `base_enterprise_type`;
CREATE TABLE `base_enterprise_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_enterprise_type
-- ----------------------------

-- ----------------------------
-- Table structure for base_menu
-- ----------------------------
DROP TABLE IF EXISTS `base_menu`;
CREATE TABLE `base_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_level` varchar(255) DEFAULT NULL,
  `menu_parent` varchar(255) DEFAULT NULL,
  `menu_sub_size` int(11) DEFAULT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  `menu_index` int(255) DEFAULT NULL,
  `menu_icon` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_menu
-- ----------------------------
INSERT INTO `base_menu` VALUES ('1', '系统设置', '1', '0', null, '', '999', '', '4', '', '', 'normal');
INSERT INTO `base_menu` VALUES ('2', '模块二', '1', null, null, null, '888', null, '1', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('3', '子菜单一', '2', '1', null, '../', '111', 'fa-pie-chart', '1', null, null, 'normal');
INSERT INTO `base_menu` VALUES ('4', '子菜单1', '2', '2', null, null, '111', 'fa-pie-chart', '1', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('5', '菜单设置', '2', '1', null, '../pages/system/menu.html', '1', null, '4', null, null, 'normal');
INSERT INTO `base_menu` VALUES ('17', '用户角色', '1', '1', null, null, null, null, '4', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('21', '123', '2', '1', null, null, null, null, '4', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('22', '用户角色', '1', '1', null, null, null, null, '4', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('23', '角色列表', '1', '22', null, null, null, null, '4', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('24', '角色列表', '2', '22', null, null, null, null, '4', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('25', null, '1', '1', null, null, null, null, '1', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('26', '123', '1', '1', null, null, null, null, '4', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('27', null, '1', '1', null, null, null, null, '1', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('28', null, '1', '1', null, null, null, null, '1', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('29', null, '1', '1', null, null, null, null, '1', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('30', null, '1', '1', null, null, null, null, '1', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('31', 'ce', '1', '1', null, null, null, null, '1', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('32', '学生成绩', '1', '1', null, null, null, null, '1', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('33', '学生成绩', '1', '1', null, null, '3', null, '1', null, null, 'normal');
INSERT INTO `base_menu` VALUES ('34', '心里测试', '1', '1', null, null, '1', null, '1', null, null, 'normal');
INSERT INTO `base_menu` VALUES ('35', '科研管理', '1', '1', null, null, '1', null, '1', null, null, 'normal');
INSERT INTO `base_menu` VALUES ('36', '新闻推荐', '1', '1', null, null, '1', null, '1', null, null, 'normal');
INSERT INTO `base_menu` VALUES ('37', '考勤管理', '1', '1', null, null, '1', null, '1', null, null, 'normal');
INSERT INTO `base_menu` VALUES ('38', '家园互动', '1', '1', null, null, '1', null, '1', null, null, 'normal');
INSERT INTO `base_menu` VALUES ('39', '奖学金', '1', '1', null, null, '1', null, '1', null, null, 'normal');
INSERT INTO `base_menu` VALUES ('40', '考研管理', '1', '1', null, null, '1', null, '1', null, null, 'normal');
INSERT INTO `base_menu` VALUES ('41', '早读管理', '1', '1', null, null, '1', null, '1', null, null, 'normal');
INSERT INTO `base_menu` VALUES ('42', '早读测试菜单', '2', '41', null, null, '1', null, '1', null, null, 'delete');
INSERT INTO `base_menu` VALUES ('43', '学校管理', '1', '1', null, null, '1', null, '4', null, null, 'normal');
INSERT INTO `base_menu` VALUES ('45', '学校列表', '2', '43', null, '../pages/manager/school/school.html', '1', null, '4', null, null, 'normal');

-- ----------------------------
-- Table structure for base_message
-- ----------------------------
DROP TABLE IF EXISTS `base_message`;
CREATE TABLE `base_message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(255) DEFAULT NULL,
  `getter` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `send_time` varchar(255) DEFAULT NULL,
  `send_state` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of base_message
-- ----------------------------

-- ----------------------------
-- Table structure for base_module
-- ----------------------------
DROP TABLE IF EXISTS `base_module`;
CREATE TABLE `base_module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_title` varchar(255) DEFAULT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `module_index` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of base_module
-- ----------------------------

-- ----------------------------
-- Table structure for base_school
-- ----------------------------
DROP TABLE IF EXISTS `base_school`;
CREATE TABLE `base_school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `school_name` varchar(255) DEFAULT NULL,
  `school_describe` varchar(255) DEFAULT NULL,
  `school_address` varchar(255) DEFAULT NULL,
  `school_slogan` varchar(255) DEFAULT NULL,
  `school_logo` varchar(255) DEFAULT NULL,
  `school_stu_num` varchar(255) DEFAULT NULL,
  `school_regis_time` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_school
-- ----------------------------
INSERT INTO `base_school` VALUES ('1', 'dsads', '描述', '地址', '校训', 'logo\'', null, '123', null, null, 'delete');
INSERT INTO `base_school` VALUES ('2', '2', null, null, null, null, null, null, null, null, 'delete');
INSERT INTO `base_school` VALUES ('3', null, null, null, null, null, null, null, '1572186766', null, 'delete');
INSERT INTO `base_school` VALUES ('4', null, null, null, null, null, null, null, '1572186779', null, 'delete');
INSERT INTO `base_school` VALUES ('5', null, null, null, null, null, null, null, '1572186784', null, 'delete');
INSERT INTO `base_school` VALUES ('6', null, null, null, null, null, null, null, '1572186788', null, 'delete');
INSERT INTO `base_school` VALUES ('7', '学校名称', '描述', 'xiaozhi', 'xiaozun', null, null, null, '1572186857', null, 'delete');
INSERT INTO `base_school` VALUES ('8', '学校名称', '描述', '校址', '校训', null, null, '10/30/2019', '1572187068', null, 'delete');
INSERT INTO `base_school` VALUES ('9', 'fdasf', 'dasdf', 'dsadsa', 'dsad', null, null, '10/29/2019', '1572187095', null, 'delete');
INSERT INTO `base_school` VALUES ('10', 'dsad', null, null, null, null, null, null, '1572188526', null, 'delete');
INSERT INTO `base_school` VALUES ('11', '学校名称', '描述', '校址', '校训', null, null, '10/31/2019', '1572188747', null, 'normal');
INSERT INTO `base_school` VALUES ('12', null, null, null, null, null, null, null, '1572189176', null, 'delete');

-- ----------------------------
-- Table structure for base_score
-- ----------------------------
DROP TABLE IF EXISTS `base_score`;
CREATE TABLE `base_score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(255) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `teacher_id` varchar(255) DEFAULT NULL,
  `score_value` double(255,0) DEFAULT NULL,
  `gpa` double(255,0) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of base_score
-- ----------------------------

-- ----------------------------
-- Table structure for base_state
-- ----------------------------
DROP TABLE IF EXISTS `base_state`;
CREATE TABLE `base_state` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_index` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_state
-- ----------------------------

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `wechat` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `slogan` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `type_describe` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `identity` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_user
-- ----------------------------
INSERT INTO `base_user` VALUES ('7', '456', '456', null, null, null, null, null, null, null, null, null, null, '1', '学生', null, null, '1572004895', null, 'normal');
INSERT INTO `base_user` VALUES ('8', 'admin', 'admin', '系统管理员', '134126', 'email', '联系地址', 'wchat', 'qq', '26', '', 'hello', '地区', '4', '系统管理员', null, null, null, null, 'normal');
INSERT INTO `base_user` VALUES ('9', '123', '123', '周先生', '电话', 'email', '地址', '13413739238923', 'qq号', '21', null, '签名', '广东', '1', '学生', null, null, '1572147442', null, 'normal');
INSERT INTO `base_user` VALUES ('12', '789', '789', null, null, null, null, null, null, null, null, null, null, '1', '学生', null, null, '1572150642', null, 'normal');

-- ----------------------------
-- Table structure for base_user_type
-- ----------------------------
DROP TABLE IF EXISTS `base_user_type`;
CREATE TABLE `base_user_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_user_type
-- ----------------------------
INSERT INTO `base_user_type` VALUES ('1', '1', null, '学生', null, null, 'normal');
INSERT INTO `base_user_type` VALUES ('2', '2', null, '教师', null, null, 'normal');
INSERT INTO `base_user_type` VALUES ('3', '3', null, '管理员', null, null, 'normal');
INSERT INTO `base_user_type` VALUES ('4', '4', null, '系统管理员', null, null, 'normal');

-- ----------------------------
-- Table structure for early_reading
-- ----------------------------
DROP TABLE IF EXISTS `early_reading`;
CREATE TABLE `early_reading` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reading_name` varchar(255) DEFAULT NULL,
  `reading_time` varchar(255) DEFAULT NULL,
  `reading_address` varchar(255) DEFAULT NULL,
  `reading_abstract` varchar(255) DEFAULT NULL,
  `reading_type` varchar(255) DEFAULT NULL,
  `reading_class` varchar(255) DEFAULT NULL,
  `reading_state` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of early_reading
-- ----------------------------

-- ----------------------------
-- Table structure for postgraduate_exam
-- ----------------------------
DROP TABLE IF EXISTS `postgraduate_exam`;
CREATE TABLE `postgraduate_exam` (
  `exam_id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_name` varchar(255) DEFAULT NULL,
  `exam_type` varchar(255) DEFAULT NULL,
  `exam_college` varchar(255) DEFAULT NULL,
  `exam_state` varchar(255) DEFAULT NULL,
  `exam_address` varchar(255) DEFAULT NULL,
  `exam_time` varchar(255) DEFAULT NULL,
  `exam_abstract` varchar(255) DEFAULT NULL,
  `exam_detail` varchar(255) DEFAULT NULL,
  `exam_img` varchar(255) DEFAULT NULL,
  `exam_publisher` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of postgraduate_exam
-- ----------------------------

-- ----------------------------
-- Table structure for postgraduate_exam_enroll
-- ----------------------------
DROP TABLE IF EXISTS `postgraduate_exam_enroll`;
CREATE TABLE `postgraduate_exam_enroll` (
  `enroll_id` int(11) NOT NULL AUTO_INCREMENT,
  `postgraduate_exam_id` int(11) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `identify` varchar(255) DEFAULT NULL,
  `sno` varchar(255) DEFAULT NULL,
  `college_target` varchar(255) DEFAULT NULL,
  `major_target` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`enroll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of postgraduate_exam_enroll
-- ----------------------------

-- ----------------------------
-- Table structure for psy_test_answer
-- ----------------------------
DROP TABLE IF EXISTS `psy_test_answer`;
CREATE TABLE `psy_test_answer` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of psy_test_answer
-- ----------------------------

-- ----------------------------
-- Table structure for psy_test_answer_consult
-- ----------------------------
DROP TABLE IF EXISTS `psy_test_answer_consult`;
CREATE TABLE `psy_test_answer_consult` (
  `consult_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) DEFAULT NULL,
  `subject_score_min` varchar(255) DEFAULT NULL,
  `subject_score_max` varchar(255) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`consult_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of psy_test_answer_consult
-- ----------------------------

-- ----------------------------
-- Table structure for psy_test_answer_record
-- ----------------------------
DROP TABLE IF EXISTS `psy_test_answer_record`;
CREATE TABLE `psy_test_answer_record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of psy_test_answer_record
-- ----------------------------

-- ----------------------------
-- Table structure for psy_test_item
-- ----------------------------
DROP TABLE IF EXISTS `psy_test_item`;
CREATE TABLE `psy_test_item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) DEFAULT NULL,
  `item_serial_number` int(11) DEFAULT NULL,
  `item_title` varchar(255) DEFAULT NULL,
  `item_option` varchar(255) DEFAULT NULL,
  `item_type` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of psy_test_item
-- ----------------------------

-- ----------------------------
-- Table structure for psy_test_item_type
-- ----------------------------
DROP TABLE IF EXISTS `psy_test_item_type`;
CREATE TABLE `psy_test_item_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of psy_test_item_type
-- ----------------------------

-- ----------------------------
-- Table structure for psy_test_subject
-- ----------------------------
DROP TABLE IF EXISTS `psy_test_subject`;
CREATE TABLE `psy_test_subject` (
  `subject_id` int(11) NOT NULL,
  `subject_title` varchar(255) DEFAULT NULL,
  `subject_abstract` varchar(255) DEFAULT NULL,
  `subject_detail` varchar(255) DEFAULT NULL,
  `subject_suit` varchar(255) DEFAULT NULL COMMENT '试用',
  `subject_publisher` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of psy_test_subject
-- ----------------------------

-- ----------------------------
-- Table structure for scholarship
-- ----------------------------
DROP TABLE IF EXISTS `scholarship`;
CREATE TABLE `scholarship` (
  `scholarship_id` int(11) NOT NULL AUTO_INCREMENT,
  `scholarship_name` varchar(255) DEFAULT NULL,
  `scholarship_abstract` varchar(255) DEFAULT NULL,
  `scholarship_detail` varchar(255) DEFAULT NULL,
  `scholarship_filter` varchar(255) DEFAULT NULL,
  `scholarship_money` varchar(255) DEFAULT NULL,
  `scholarship_level` varchar(255) DEFAULT NULL,
  `scholarship_number` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`scholarship_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of scholarship
-- ----------------------------

-- ----------------------------
-- Table structure for scholarship_apply_record
-- ----------------------------
DROP TABLE IF EXISTS `scholarship_apply_record`;
CREATE TABLE `scholarship_apply_record` (
  `apply_id` varchar(255) DEFAULT NULL,
  `scholarship_id` int(11) DEFAULT NULL,
  `distribution_name` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL COMMENT '班级id',
  `apply_state` int(11) DEFAULT NULL,
  `gpa` varchar(255) DEFAULT NULL,
  `score_report_img` varchar(255) DEFAULT NULL,
  `apply_describe` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of scholarship_apply_record
-- ----------------------------

-- ----------------------------
-- Table structure for scholarship_distribution
-- ----------------------------
DROP TABLE IF EXISTS `scholarship_distribution`;
CREATE TABLE `scholarship_distribution` (
  `distribution_id` varchar(255) DEFAULT NULL,
  `scholarship_id` int(11) DEFAULT NULL,
  `distribution_name` varchar(255) DEFAULT NULL,
  `school_id` int(11) DEFAULT NULL,
  `college_id` varchar(255) DEFAULT NULL,
  `class_id` varchar(255) DEFAULT NULL COMMENT '班级id',
  `number` int(11) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of scholarship_distribution
-- ----------------------------

-- ----------------------------
-- Table structure for scient_subject
-- ----------------------------
DROP TABLE IF EXISTS `scient_subject`;
CREATE TABLE `scient_subject` (
  `scient_subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `scient_subject_name` varchar(255) DEFAULT NULL,
  `scient_subject_publisher` varchar(255) DEFAULT NULL,
  `scient_subject_member` varchar(255) DEFAULT NULL,
  `scient_subject_abstract` varchar(255) DEFAULT NULL,
  `scient_subject_detail` varchar(255) DEFAULT NULL,
  `scient_subject_img` varchar(255) DEFAULT NULL,
  `scient_subject_state` varchar(255) DEFAULT NULL,
  `scient_subject_file` varchar(255) DEFAULT NULL,
  `scient_subject_platform` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`scient_subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of scient_subject
-- ----------------------------
