package com.suning.arttrain.util;

import com.suning.arttrain.dto.StudentSignView;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhanglb on 14-8-3.
 * 数据库批量导出
 */
public class StudentSignRowMapper implements RowMapper<StudentSignView> {

    @Override
    public StudentSignView mapRow(ResultSet rs, int rowNum) throws SQLException {

        StudentSignView signView = new StudentSignView();

        signView.setAge(rs.getInt("age"));
        signView.setAddress(rs.getString("address"));
        signView.setBirthday(rs.getString("birthday"));
        //signView.setSignCourseName(rs.getString("sign_course_name"));

        return signView;
    }
}
