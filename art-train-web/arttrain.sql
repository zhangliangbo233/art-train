/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.1.73 : Database - arttrain
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`arttrain` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `arttrain`;

/*Table structure for table `BATCH_JOB_EXECUTION` */

DROP TABLE IF EXISTS `BATCH_JOB_EXECUTION`;

CREATE TABLE `BATCH_JOB_EXECUTION` (
  `JOB_EXECUTION_ID` bigint(20) NOT NULL,
  `VERSION` bigint(20) DEFAULT NULL,
  `JOB_INSTANCE_ID` bigint(20) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  `START_TIME` datetime DEFAULT NULL,
  `END_TIME` datetime DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `EXIT_CODE` varchar(2500) DEFAULT NULL,
  `EXIT_MESSAGE` varchar(2500) DEFAULT NULL,
  `LAST_UPDATED` datetime DEFAULT NULL,
  `JOB_CONFIGURATION_LOCATION` varchar(2500) DEFAULT NULL,
  PRIMARY KEY (`JOB_EXECUTION_ID`),
  KEY `JOB_INST_EXEC_FK` (`JOB_INSTANCE_ID`),
  CONSTRAINT `JOB_INST_EXEC_FK` FOREIGN KEY (`JOB_INSTANCE_ID`) REFERENCES `BATCH_JOB_INSTANCE` (`JOB_INSTANCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `BATCH_JOB_EXECUTION` */

insert  into `BATCH_JOB_EXECUTION`(`JOB_EXECUTION_ID`,`VERSION`,`JOB_INSTANCE_ID`,`CREATE_TIME`,`START_TIME`,`END_TIME`,`STATUS`,`EXIT_CODE`,`EXIT_MESSAGE`,`LAST_UPDATED`,`JOB_CONFIGURATION_LOCATION`) values (1,2,1,'2014-08-03 15:10:43','2014-08-03 15:10:43','2014-08-03 15:10:43','FAILED','FAILED','','2014-08-03 15:10:43',NULL),(2,2,1,'2014-08-03 15:15:58','2014-08-03 15:15:58','2014-08-03 15:15:58','FAILED','FAILED','','2014-08-03 15:15:58',NULL),(3,2,1,'2014-08-03 15:17:32','2014-08-03 15:17:32','2014-08-03 15:17:32','FAILED','FAILED','','2014-08-03 15:17:32',NULL),(4,2,1,'2014-08-03 15:18:02','2014-08-03 15:18:02','2014-08-03 15:18:02','COMPLETED','COMPLETED','','2014-08-03 15:18:02',NULL),(5,2,1,'2014-08-03 15:26:00','2014-08-03 15:26:00','2014-08-03 15:26:00','COMPLETED','NOOP','All steps already completed or no steps configured for this job.','2014-08-03 15:26:00',NULL);

/*Table structure for table `BATCH_JOB_EXECUTION_CONTEXT` */

DROP TABLE IF EXISTS `BATCH_JOB_EXECUTION_CONTEXT`;

CREATE TABLE `BATCH_JOB_EXECUTION_CONTEXT` (
  `JOB_EXECUTION_ID` bigint(20) NOT NULL,
  `SHORT_CONTEXT` varchar(2500) NOT NULL,
  `SERIALIZED_CONTEXT` text,
  PRIMARY KEY (`JOB_EXECUTION_ID`),
  CONSTRAINT `JOB_EXEC_CTX_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `BATCH_JOB_EXECUTION` (`JOB_EXECUTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `BATCH_JOB_EXECUTION_CONTEXT` */

insert  into `BATCH_JOB_EXECUTION_CONTEXT`(`JOB_EXECUTION_ID`,`SHORT_CONTEXT`,`SERIALIZED_CONTEXT`) values (1,'{\"map\":[\"\"]}',NULL),(2,'{\"map\":[\"\"]}',NULL),(3,'{\"map\":[\"\"]}',NULL),(4,'{\"map\":[\"\"]}',NULL),(5,'{\"map\":[\"\"]}',NULL);

/*Table structure for table `BATCH_JOB_EXECUTION_PARAMS` */

DROP TABLE IF EXISTS `BATCH_JOB_EXECUTION_PARAMS`;

CREATE TABLE `BATCH_JOB_EXECUTION_PARAMS` (
  `JOB_EXECUTION_ID` bigint(20) NOT NULL,
  `TYPE_CD` varchar(6) NOT NULL,
  `KEY_NAME` varchar(100) NOT NULL,
  `STRING_VAL` varchar(250) DEFAULT NULL,
  `DATE_VAL` datetime DEFAULT NULL,
  `LONG_VAL` bigint(20) DEFAULT NULL,
  `DOUBLE_VAL` double DEFAULT NULL,
  `IDENTIFYING` char(1) NOT NULL,
  KEY `JOB_EXEC_PARAMS_FK` (`JOB_EXECUTION_ID`),
  CONSTRAINT `JOB_EXEC_PARAMS_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `BATCH_JOB_EXECUTION` (`JOB_EXECUTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `BATCH_JOB_EXECUTION_PARAMS` */

/*Table structure for table `BATCH_JOB_EXECUTION_SEQ` */

DROP TABLE IF EXISTS `BATCH_JOB_EXECUTION_SEQ`;

CREATE TABLE `BATCH_JOB_EXECUTION_SEQ` (
  `ID` bigint(20) NOT NULL,
  `UNIQUE_KEY` char(1) NOT NULL,
  UNIQUE KEY `UNIQUE_KEY_UN` (`UNIQUE_KEY`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `BATCH_JOB_EXECUTION_SEQ` */

insert  into `BATCH_JOB_EXECUTION_SEQ`(`ID`,`UNIQUE_KEY`) values (5,'0');

/*Table structure for table `BATCH_JOB_INSTANCE` */

DROP TABLE IF EXISTS `BATCH_JOB_INSTANCE`;

CREATE TABLE `BATCH_JOB_INSTANCE` (
  `JOB_INSTANCE_ID` bigint(20) NOT NULL,
  `VERSION` bigint(20) DEFAULT NULL,
  `JOB_NAME` varchar(100) NOT NULL,
  `JOB_KEY` varchar(32) NOT NULL,
  PRIMARY KEY (`JOB_INSTANCE_ID`),
  UNIQUE KEY `JOB_INST_UN` (`JOB_NAME`,`JOB_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `BATCH_JOB_INSTANCE` */

insert  into `BATCH_JOB_INSTANCE`(`JOB_INSTANCE_ID`,`VERSION`,`JOB_NAME`,`JOB_KEY`) values (1,0,'reportJob','d41d8cd98f00b204e9800998ecf8427e');

/*Table structure for table `BATCH_JOB_SEQ` */

DROP TABLE IF EXISTS `BATCH_JOB_SEQ`;

CREATE TABLE `BATCH_JOB_SEQ` (
  `ID` bigint(20) NOT NULL,
  `UNIQUE_KEY` char(1) NOT NULL,
  UNIQUE KEY `UNIQUE_KEY_UN` (`UNIQUE_KEY`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `BATCH_JOB_SEQ` */

insert  into `BATCH_JOB_SEQ`(`ID`,`UNIQUE_KEY`) values (1,'0');

/*Table structure for table `BATCH_STEP_EXECUTION` */

DROP TABLE IF EXISTS `BATCH_STEP_EXECUTION`;

CREATE TABLE `BATCH_STEP_EXECUTION` (
  `STEP_EXECUTION_ID` bigint(20) NOT NULL,
  `VERSION` bigint(20) NOT NULL,
  `STEP_NAME` varchar(100) NOT NULL,
  `JOB_EXECUTION_ID` bigint(20) NOT NULL,
  `START_TIME` datetime NOT NULL,
  `END_TIME` datetime DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `COMMIT_COUNT` bigint(20) DEFAULT NULL,
  `READ_COUNT` bigint(20) DEFAULT NULL,
  `FILTER_COUNT` bigint(20) DEFAULT NULL,
  `WRITE_COUNT` bigint(20) DEFAULT NULL,
  `READ_SKIP_COUNT` bigint(20) DEFAULT NULL,
  `WRITE_SKIP_COUNT` bigint(20) DEFAULT NULL,
  `PROCESS_SKIP_COUNT` bigint(20) DEFAULT NULL,
  `ROLLBACK_COUNT` bigint(20) DEFAULT NULL,
  `EXIT_CODE` varchar(2500) DEFAULT NULL,
  `EXIT_MESSAGE` varchar(2500) DEFAULT NULL,
  `LAST_UPDATED` datetime DEFAULT NULL,
  PRIMARY KEY (`STEP_EXECUTION_ID`),
  KEY `JOB_EXEC_STEP_FK` (`JOB_EXECUTION_ID`),
  CONSTRAINT `JOB_EXEC_STEP_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `BATCH_JOB_EXECUTION` (`JOB_EXECUTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `BATCH_STEP_EXECUTION` */

insert  into `BATCH_STEP_EXECUTION`(`STEP_EXECUTION_ID`,`VERSION`,`STEP_NAME`,`JOB_EXECUTION_ID`,`START_TIME`,`END_TIME`,`STATUS`,`COMMIT_COUNT`,`READ_COUNT`,`FILTER_COUNT`,`WRITE_COUNT`,`READ_SKIP_COUNT`,`WRITE_SKIP_COUNT`,`PROCESS_SKIP_COUNT`,`ROLLBACK_COUNT`,`EXIT_CODE`,`EXIT_MESSAGE`,`LAST_UPDATED`) values (1,2,'step1',1,'2014-08-03 15:10:43','2014-08-03 15:10:43','FAILED',0,0,0,0,0,0,0,1,'FAILED','org.springframework.jdbc.BadSqlGrammarException: Attempt to process next row failed; bad SQL grammar [select a.*,b.school,b.contact_person,b.contact_mobile,b.age,b.birthday,b.address,b.grade             from arttrain_student_sign a,arttrain_student_info b        where a.student_id=b.id and a.is_delete=1]; nested exception is java.sql.SQLException: Column \'course_name\' not found.\n	at org.springframework.jdbc.support.SQLStateSQLExceptionTranslator.doTranslate(SQLStateSQLExceptionTranslator.java:98)\n	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:72)\n	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:80)\n	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:80)\n	at org.springframework.batch.item.database.AbstractCursorItemReader.doRead(AbstractCursorItemReader.java:453)\n	at org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader.read(AbstractItemCountingItemStreamItemReader.java:83)\n	at org.springframework.batch.core.step.item.SimpleChunkProvider.doRead(SimpleChunkProvider.java:91)\n	at org.springframework.batch.core.step.item.SimpleChunkProvider.read(SimpleChunkProvider.java:155)\n	at org.springframework.batch.core.step.item.SimpleChunkProvider$1.doInIteration(SimpleChunkProvider.java:114)\n	at org.springframework.batch.repeat.support.RepeatTemplate.getNextResult(RepeatTemplate.java:368)\n	at org.springframework.batch.repeat.support.RepeatTemplate.executeInternal(RepeatTemplate.java:215)\n	at org.springframework.batch.repeat.support.RepeatTemplate.iterate(RepeatTemplate.java:144)\n	at org.springframework.batch.core.step.item.SimpleChunkProvider.provide(SimpleChunkProvider.java:108)\n	at org.springframework.batch.core.step.item.ChunkOrientedTasklet.execute(ChunkOrientedTasklet.java:69)\n	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:406)\n	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:330)\n	at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:130)\n	at org.springframework.batch.core.step.tasklet.TaskletStep$2.doInChunkContext(TaskletStep.java:271)\n	at org.springframework.batch.core.scope.context.StepContextRepeatCallback.doInIterat','2014-08-03 15:10:43'),(2,2,'step1',2,'2014-08-03 15:15:58','2014-08-03 15:15:58','FAILED',0,4,0,0,0,0,0,1,'FAILED','org.springframework.beans.NotReadablePropertyException: Invalid property \'sign_course_name\' of bean class [com.suning.arttrain.dto.StudentSignView]: Bean property \'sign_course_name\' is not readable or has an invalid getter method: Does the return type of the getter match the parameter type of the setter?\n	at org.springframework.beans.BeanWrapperImpl.getPropertyValue(BeanWrapperImpl.java:709)\n	at org.springframework.beans.BeanWrapperImpl.getPropertyValue(BeanWrapperImpl.java:701)\n	at org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor.extract(BeanWrapperFieldExtractor.java:57)\n	at org.springframework.batch.item.file.transform.ExtractorLineAggregator.aggregate(ExtractorLineAggregator.java:54)\n	at org.springframework.batch.item.file.FlatFileItemWriter.write(FlatFileItemWriter.java:267)\n	at org.springframework.batch.core.step.item.SimpleChunkProcessor.writeItems(SimpleChunkProcessor.java:175)\n	at org.springframework.batch.core.step.item.SimpleChunkProcessor.doWrite(SimpleChunkProcessor.java:151)\n	at org.springframework.batch.core.step.item.SimpleChunkProcessor.write(SimpleChunkProcessor.java:274)\n	at org.springframework.batch.core.step.item.SimpleChunkProcessor.process(SimpleChunkProcessor.java:199)\n	at org.springframework.batch.core.step.item.ChunkOrientedTasklet.execute(ChunkOrientedTasklet.java:75)\n	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:406)\n	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:330)\n	at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:130)\n	at org.springframework.batch.core.step.tasklet.TaskletStep$2.doInChunkContext(TaskletStep.java:271)\n	at org.springframework.batch.core.scope.context.StepContextRepeatCallback.doInIteration(StepContextRepeatCallback.java:77)\n	at org.springframework.batch.repeat.support.RepeatTemplate.getNextResult(RepeatTemplate.java:368)\n	at org.springframework.batch.repeat.support.RepeatTemplate.executeInternal(RepeatTemplate.java:215)\n	at org.springframework.batch.repeat.support.RepeatTemplate.iterate(RepeatTemplate.java:144)\n	at org.springframework.batch.core.step.tasklet.TaskletStep.doExecute(TaskletStep.java:257)\n	at org.springframework.batch.core.step.AbstractStep.execute(AbstractStep.java:198)\n	at org.springframework.batch.core.job.SimpleStepHandler.handleStep(SimpleStepHandler.java:148)\n	at org.springframework','2014-08-03 15:15:58'),(3,2,'step1',3,'2014-08-03 15:17:32','2014-08-03 15:17:32','FAILED',0,4,0,0,0,0,0,1,'FAILED','org.springframework.beans.NotReadablePropertyException: Invalid property \'sign_course_name\' of bean class [com.suning.arttrain.dto.StudentSignView]: Bean property \'sign_course_name\' is not readable or has an invalid getter method: Does the return type of the getter match the parameter type of the setter?\n	at org.springframework.beans.BeanWrapperImpl.getPropertyValue(BeanWrapperImpl.java:709)\n	at org.springframework.beans.BeanWrapperImpl.getPropertyValue(BeanWrapperImpl.java:701)\n	at org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor.extract(BeanWrapperFieldExtractor.java:57)\n	at org.springframework.batch.item.file.transform.ExtractorLineAggregator.aggregate(ExtractorLineAggregator.java:54)\n	at org.springframework.batch.item.file.FlatFileItemWriter.write(FlatFileItemWriter.java:267)\n	at org.springframework.batch.core.step.item.SimpleChunkProcessor.writeItems(SimpleChunkProcessor.java:175)\n	at org.springframework.batch.core.step.item.SimpleChunkProcessor.doWrite(SimpleChunkProcessor.java:151)\n	at org.springframework.batch.core.step.item.SimpleChunkProcessor.write(SimpleChunkProcessor.java:274)\n	at org.springframework.batch.core.step.item.SimpleChunkProcessor.process(SimpleChunkProcessor.java:199)\n	at org.springframework.batch.core.step.item.ChunkOrientedTasklet.execute(ChunkOrientedTasklet.java:75)\n	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:406)\n	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:330)\n	at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:130)\n	at org.springframework.batch.core.step.tasklet.TaskletStep$2.doInChunkContext(TaskletStep.java:271)\n	at org.springframework.batch.core.scope.context.StepContextRepeatCallback.doInIteration(StepContextRepeatCallback.java:77)\n	at org.springframework.batch.repeat.support.RepeatTemplate.getNextResult(RepeatTemplate.java:368)\n	at org.springframework.batch.repeat.support.RepeatTemplate.executeInternal(RepeatTemplate.java:215)\n	at org.springframework.batch.repeat.support.RepeatTemplate.iterate(RepeatTemplate.java:144)\n	at org.springframework.batch.core.step.tasklet.TaskletStep.doExecute(TaskletStep.java:257)\n	at org.springframework.batch.core.step.AbstractStep.execute(AbstractStep.java:198)\n	at org.springframework.batch.core.job.SimpleStepHandler.handleStep(SimpleStepHandler.java:148)\n	at org.springframework','2014-08-03 15:17:32'),(4,3,'step1',4,'2014-08-03 15:18:02','2014-08-03 15:18:02','COMPLETED',1,4,0,4,0,0,0,0,'COMPLETED','','2014-08-03 15:18:02');

/*Table structure for table `BATCH_STEP_EXECUTION_CONTEXT` */

DROP TABLE IF EXISTS `BATCH_STEP_EXECUTION_CONTEXT`;

CREATE TABLE `BATCH_STEP_EXECUTION_CONTEXT` (
  `STEP_EXECUTION_ID` bigint(20) NOT NULL,
  `SHORT_CONTEXT` varchar(2500) NOT NULL,
  `SERIALIZED_CONTEXT` text,
  PRIMARY KEY (`STEP_EXECUTION_ID`),
  CONSTRAINT `STEP_EXEC_CTX_FK` FOREIGN KEY (`STEP_EXECUTION_ID`) REFERENCES `BATCH_STEP_EXECUTION` (`STEP_EXECUTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `BATCH_STEP_EXECUTION_CONTEXT` */

insert  into `BATCH_STEP_EXECUTION_CONTEXT`(`STEP_EXECUTION_ID`,`SHORT_CONTEXT`,`SERIALIZED_CONTEXT`) values (1,'{\"map\":[{\"entry\":[{\"string\":\"FlatFileItemWriter.current.count\",\"long\":0},{\"string\":\"FlatFileItemWriter.written\",\"long\":0},{\"string\":\"JdbcCursorItemReader.read.count\",\"int\":0},{\"string\":[\"batch.stepType\",\"org.springframework.batch.core.step.tasklet.TaskletStep\"]},{\"string\":[\"batch.taskletType\",\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\"]}]}]}',NULL),(2,'{\"map\":[{\"entry\":[{\"string\":\"FlatFileItemWriter.current.count\",\"long\":0},{\"string\":\"FlatFileItemWriter.written\",\"long\":0},{\"string\":\"JdbcCursorItemReader.read.count\",\"int\":0},{\"string\":[\"batch.stepType\",\"org.springframework.batch.core.step.tasklet.TaskletStep\"]},{\"string\":[\"batch.taskletType\",\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\"]}]}]}',NULL),(3,'{\"map\":[{\"entry\":[{\"string\":\"FlatFileItemWriter.current.count\",\"long\":0},{\"string\":\"FlatFileItemWriter.written\",\"long\":0},{\"string\":\"JdbcCursorItemReader.read.count\",\"int\":0},{\"string\":[\"batch.stepType\",\"org.springframework.batch.core.step.tasklet.TaskletStep\"]},{\"string\":[\"batch.taskletType\",\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\"]}]}]}',NULL),(4,'{\"map\":[{\"entry\":[{\"string\":\"FlatFileItemWriter.current.count\",\"long\":108},{\"string\":\"FlatFileItemWriter.written\",\"long\":4},{\"string\":\"JdbcCursorItemReader.read.count\",\"int\":5},{\"string\":[\"batch.stepType\",\"org.springframework.batch.core.step.tasklet.TaskletStep\"]},{\"string\":[\"batch.taskletType\",\"org.springframework.batch.core.step.item.ChunkOrientedTasklet\"]}]}]}',NULL);

/*Table structure for table `BATCH_STEP_EXECUTION_SEQ` */

DROP TABLE IF EXISTS `BATCH_STEP_EXECUTION_SEQ`;

CREATE TABLE `BATCH_STEP_EXECUTION_SEQ` (
  `ID` bigint(20) NOT NULL,
  `UNIQUE_KEY` char(1) NOT NULL,
  UNIQUE KEY `UNIQUE_KEY_UN` (`UNIQUE_KEY`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `BATCH_STEP_EXECUTION_SEQ` */

insert  into `BATCH_STEP_EXECUTION_SEQ`(`ID`,`UNIQUE_KEY`) values (4,'0');

/*Table structure for table `arttrain_cas_user` */

DROP TABLE IF EXISTS `arttrain_cas_user`;

CREATE TABLE `arttrain_cas_user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '用户是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `arttrain_cas_user` */

insert  into `arttrain_cas_user`(`id`,`user_name`,`password`,`create_time`,`enabled`) values (1,'zhanglb','13ebbc69e8836b7fa51008099ecded27','2014-07-30 19:45:24',1);

/*Table structure for table `arttrain_course_info` */

DROP TABLE IF EXISTS `arttrain_course_info`;

CREATE TABLE `arttrain_course_info` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(10) DEFAULT NULL COMMENT '课程名称',
  `begin_time` date DEFAULT NULL COMMENT '开课时间',
  `total_days` int(5) DEFAULT NULL COMMENT '课程天数',
  `end_time` date DEFAULT NULL COMMENT '结课时间',
  `teacher_id` bigint(10) DEFAULT NULL COMMENT '授课老师id',
  `teacher_name` varchar(10) DEFAULT NULL COMMENT '授课老师姓名',
  `price` decimal(10,2) DEFAULT NULL COMMENT '课程价格，保留两位小数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `arttrain_course_info` */

insert  into `arttrain_course_info`(`id`,`course_name`,`begin_time`,`total_days`,`end_time`,`teacher_id`,`teacher_name`,`price`) values (4,'test','2014-08-15',30,'2014-09-14',3,'hhaaha','400.00');

/*Table structure for table `arttrain_menu_info` */

DROP TABLE IF EXISTS `arttrain_menu_info`;

CREATE TABLE `arttrain_menu_info` (
  `id` bigint(10) NOT NULL,
  `text` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `parent_id` bigint(10) DEFAULT NULL COMMENT '上级菜单id',
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '是否可以正常使用 0：否 1：是',
  `state` varchar(10) DEFAULT NULL COMMENT '是否展开',
  `icon_cls` varchar(50) DEFAULT NULL COMMENT '图标样式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `arttrain_menu_info` */

insert  into `arttrain_menu_info`(`id`,`text`,`url`,`parent_id`,`is_delete`,`state`,`icon_cls`) values (1,'学生管理','',0,1,'closed',''),(2,'学生报名信息','/arttrain/studentMsg/showStudentSignInfos.html',1,1,'open','icon-gears'),(3,'老师管理','',0,1,'closed',''),(4,'老师信息','/arttrain/teacher/showTeacherInfos.html',3,1,'open','icon-gears'),(5,'课程管理','',0,1,'closed',''),(6,'课程信息','/arttrain/course/showCourseInfos.html',5,1,'open','icon-gears'),(7,'系统管理','',0,1,'closed',''),(8,'参数设置','/arttrain/system/sytemConfig.html',7,1,'open','icon-gears');

/*Table structure for table `arttrain_student_info` */

DROP TABLE IF EXISTS `arttrain_student_info`;

CREATE TABLE `arttrain_student_info` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL COMMENT '学生姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `birthday` varchar(20) DEFAULT NULL COMMENT '生日',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `contact_person` varchar(10) DEFAULT NULL COMMENT '联系人',
  `contact_mobile` varchar(11) DEFAULT NULL COMMENT '联系人电话',
  `school` varchar(50) DEFAULT NULL COMMENT '所在学校',
  `grade` varchar(10) DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `arttrain_student_info` */

insert  into `arttrain_student_info`(`id`,`name`,`age`,`birthday`,`address`,`contact_person`,`contact_mobile`,`school`,`grade`) values (1,'tt',15,'1986-07-10','江苏淮安','张良波','13905194625','',NULL),(2,'zhanglb',15,'1986-07-10','江苏淮安','张良波','13905194625','涟水中学','二年级'),(3,'zhanglb',15,'1986-07-10','江苏淮安','张良波','13905194625','涟水中学','二年级'),(5,'zhanglb',15,'1986-07-10','江苏淮安','张良波','13905194625','涟水中学','二年级'),(6,'zhanglb',15,'1986-07-10','江苏淮安','张良波','13905194625','涟水中学','二年级'),(7,'张良波',10,'1986-10-07',NULL,'zlb','13905194625',NULL,NULL),(8,'张良波',10,'1986-10-07',NULL,'zlb','13905194625',NULL,NULL),(9,'张良波',10,'1986-10-07',NULL,'zlb','13905194625',NULL,NULL),(10,'张良波',23,'2014-07-31','','张良波2','13905194625','',NULL),(11,'张良波',23,'2014-07-31','','张良波2','13905194625','',NULL),(12,'张良波',23,'2014-07-31','','张良波2','13905194625','',NULL),(13,'张良波',23,'2014-07-31','','张良波2','13905194625','',NULL),(14,'tst',23,'2014-07-30','','444','13906194625','',NULL),(15,'tt',23,'2014-08-09','','3s','13905194528','',NULL);

/*Table structure for table `arttrain_student_sign` */

DROP TABLE IF EXISTS `arttrain_student_sign`;

CREATE TABLE `arttrain_student_sign` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(10) DEFAULT NULL COMMENT '学生id',
  `student_name` varchar(10) DEFAULT NULL COMMENT '学生姓名',
  `sign_time` datetime DEFAULT NULL COMMENT '报名时间',
  `sign_expense` decimal(10,2) DEFAULT NULL COMMENT '报名费用',
  `sign_course_id` bigint(10) DEFAULT NULL COMMENT '报名课程id',
  `sign_course_name` varchar(10) DEFAULT NULL COMMENT '报名课程名称',
  `is_delete` tinyint(1) DEFAULT '1' COMMENT '删除标识 0：删除 1：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `arttrain_student_sign` */

insert  into `arttrain_student_sign`(`id`,`student_id`,`student_name`,`sign_time`,`sign_expense`,`sign_course_id`,`sign_course_name`,`is_delete`) values (1,1,'张良波','2014-07-31 10:53:12','90.00',0,'语文',NULL),(2,1,'张良波','2014-07-31 10:53:45','90.00',0,'语文',NULL),(3,1,'张良波','2014-07-31 10:54:30','90.00',0,'语文',1),(4,1,'张良波','2014-07-31 15:41:47','23.00',0,'Java',1),(5,1,'张良波','2014-07-31 15:41:55','23.00',0,'Java',1),(6,1,'张良波','2014-07-31 15:43:22','23.00',0,'Javttt',1),(7,1,'张良波','2014-07-31 15:45:55','23.00',0,'Java',0),(8,1,'tst','2014-07-31 15:48:29','24.00',0,'c++',0),(9,1,'tt','2014-08-09 15:25:00','23.00',3,'弹琴',1);

/*Table structure for table `arttrain_teacher_info` */

DROP TABLE IF EXISTS `arttrain_teacher_info`;

CREATE TABLE `arttrain_teacher_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `contact_mobile` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `assume_time` datetime DEFAULT NULL COMMENT '入职时间',
  `salary` decimal(10,2) DEFAULT NULL COMMENT '工资金额，保留两位小数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `arttrain_teacher_info` */

insert  into `arttrain_teacher_info`(`id`,`name`,`age`,`contact_mobile`,`assume_time`,`salary`) values (2,'zb',24,'13905194625','2014-08-08 00:00:00','2300.00'),(3,'hhaaha',23,'13905194625','2014-08-07 13:53:17','100.00'),(4,'rrr',34,'13905183456','2014-08-16 13:20:16','23.00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

http://monitor.cnsuning.com/monitor-portal/dashboard/showMonitorDashboard
