package com.suning.arttrain.service;

import com.suning.arttrain.common.exception.ParamsValidatorException;
import com.suning.arttrain.dto.StudentSignView;
import com.suning.arttrain.param.StudentSignCreateParam;
import com.suning.arttrain.persistent.StudentInfo;
import com.suning.arttrain.service.BaseTest;
import com.suning.arttrain.service.StudentMsgService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhanglb on 2014/7/31.
 */
public class StudentMsgTest extends BaseTest {

    @Autowired
    private StudentMsgService studentMsgService;


    @Test
    public void addStudentInfoTest(){
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setName("zhanglb");
        studentInfo.setAge(15);
        studentInfo.setBirthday("7/10/1986");
        studentInfo.setAddress("江苏淮安");
        studentInfo.setContactPerson("张良波");
        studentInfo.setContactMobile("13905194625");
        studentInfo.setGrade("二年级");
        studentInfo.setSchool("涟水中学");

        Assert.assertEquals(studentMsgService.addStudentInfo(studentInfo),1);
    }

    @Test
    public void deleteStudentSignTest(){
        long id =6;
        studentMsgService.deleteStudentSign(id);
    }

    @Test(expected = ParamsValidatorException.class)
    public void loadSignWithStuInfoByIdTest(){
        long id =6;
        try {
            studentMsgService.loadSignWithStuInfoById(id);
        } catch (ParamsValidatorException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveStudentSignTest(){
        StudentSignCreateParam signCreateParam = new StudentSignCreateParam();
        signCreateParam.setSignId(7);
        signCreateParam.setStudentId(8);
        signCreateParam.setSignCourseName("语文");
        signCreateParam.setName("张良波");
        signCreateParam.setAge(10);
        signCreateParam.setContactPerson("zlb");
        signCreateParam.setContactMobile("13905194625");
        signCreateParam.setSignExpense(90);
        signCreateParam.setBirthday("10/7/1986");

        try {
            studentMsgService.saveStudentSign(signCreateParam);
        } catch (ParamsValidatorException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void listExpireStudentsInfosTest() throws Exception {

        List<StudentSignView> expireStudentsInfo = studentMsgService.listExpireStudentsInfos();

        Assert.assertNotNull(expireStudentsInfo);
    }
}
