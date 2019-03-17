CREATE DATABASE Clinic;
USE Clinic;

/*
 * Patient
 * */
CREATE TABLE Patient(
	PatientId INTEGER PRIMARY KEY AUTO_INCREMENT,
	Name VARCHAR(30) NOT NULL,
	Sex CHAR(1) NOT NULL,
	OfficePhoneNumber VARCHAR(30),
	MobilePhoneNumber VARCHAR(30),
	Email VARCHAR(30)
);

INSERT INTO Patient 
(Name , Sex , OfficePhoneNumber , MobilePhoneNumber, Email ) 
VALUES 
('孙悟空6' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('猪八戒1' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('沙僧1' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('唐僧1' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('孙悟空2' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('猪八戒2' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('沙僧2' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('唐僧2' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('孙悟空3' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('猪八戒3' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('沙僧3' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('唐僧3' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('孙悟空4' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('猪八戒4' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('沙僧4' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('唐僧4' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('孙悟空5' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('猪八戒5' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('沙僧5' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com'),
('唐僧5' , '男' , '0733-33333333' , '135x....' , 'sunwukong@hngy.com')
;


/*
 * PatientRecord
 */
CREATE TABLE PatientRecord
(
	PatientId INTEGER,
	FOREIGN KEY (PatientId) REFERENCES Patient(PatientId),

	RecordId INTEGER PRIMARY KEY AUTO_INCREMENT,      -- 记录编号
	Name VARCHAR(30),                                     	 -- 患者姓名
	-- `PatientRecordTime` DATETIME DEFAULT NULL,	       		 -- 记录时间
	-- 方便测试使用df代替时间
	`df` DATETIME DEFAULT NULL,
     DiseaseType VARCHAR(30)                                 -- 患病类型
);

INSERT INTO PatientRecord
(PatientId , RecordId , Name , df , DiseaseType)
VALUES
('1' , '1001' , '孙悟空6' , '2017-9-19 09:01:26' , '拔牙'),
('1' , '1002' , '孙悟空6' , '2017-8-19 09:01:26' , '补牙'),
('2' , '1003' , '猪八戒1' , '2017-10-19 14:01:26' , '拔牙'),
('3' , '1004' , '沙僧1' , '2016-5-12 10:21:26' , '洗牙'),
('6' , '1005' , '猪八戒2' , '2018-2-28 08:01:26' , '镶牙'),
('10' , '1006' , '猪八戒3' , '2017-9-29 16:11:26' , '拔牙'),
('10' , '1007' , '猪八戒3' , '2016-3-19 09:01:26' , '补牙')
;

CREATE TABLE user_table(
    id int primary key auto_increment,
    username varchar(20),
    pass varchar(20)
);

INSERT INTO user_table
(username,pass ) 
VALUES 
('admin' , 'admin' ),
('xiao' , 'xiao' ),
('wang' , 'wang' )
;