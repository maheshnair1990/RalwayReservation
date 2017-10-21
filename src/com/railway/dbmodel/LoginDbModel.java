/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railway.dbmodel;

//import org.springframework.jdbc.core.JdbcTemplate;
import com.railway.uimodel.RegistrationUiModel;
import com.railway.uimodel.TrainUiModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;  

/**
 *
 * @author Mahesh Nair
 */
public class LoginDbModel {

//    @Autowired
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public boolean getUser(String user, String password) {
        String sql = "select count(*) from register where user='" + user + "' and password= '" + password + "'";
        int count = 0;
        try {
//            count = template.queryForInt(sql);
            count = template.queryForObject(sql, Integer.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean loginFlag = false;
        if (count == 1) {
            loginFlag = true;
        }

        return loginFlag;

    }

    public int insertUser(RegistrationUiModel registerUimodel) {
        String loginSql = "select count(*) from register where user='" + registerUimodel.getUser() + "' and password= '" + registerUimodel.getPassword() + "'";
        int loginCount = template.queryForObject(loginSql, Integer.class);
        if (loginCount > 0) {
            return 0;
        } else {
            String sql = "insert into register (email,user,password)values ('" + registerUimodel.getEmail() + "','" + registerUimodel.getUser() + "','" + registerUimodel.getPassword() + "');";
            int count = template.update(sql);
            return count;
        }

    }

    public List<TrainUiModel> getTrain(String stationFrom) {
        String sql = "select * from trains where stations='" + stationFrom + "'";
        return template.query(sql, new RowMapper<TrainUiModel>() {
            public TrainUiModel mapRow(ResultSet rs, int row) throws SQLException {
                TrainUiModel e = new TrainUiModel();
                e.setTrainNo(rs.getInt(1));
                e.setStation(rs.getString(2));
                e.setTrain(rs.getString(3));
                e.setTicketAvailiable(rs.getInt(4));
                e.setArrivalTime(rs.getString(5));
                e.setDepTime(rs.getString(6));
//                e.   (rs.getInt(1));
//                e.setName(rs.getString(2));
//                e.setSalary(rs.getFloat(3));
//                e.setDesignation(rs.getString(4));
                return e;
            }
        });
    }
}
