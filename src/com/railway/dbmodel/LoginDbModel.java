/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.railway.dbmodel;

//import org.springframework.jdbc.core.JdbcTemplate;
import com.railway.uimodel.BookTicketUiModel;
import com.railway.uimodel.CancelTicketUiModel;
import com.railway.uimodel.RegistrationUiModel;
import com.railway.uimodel.TrainUiModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpSession;
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
        String loginSql = "select count(*) from register where user='" + registerUimodel.getUser() + "'";
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
                return e;
            }
        });
    }

    public int insertCustomerInfo(BookTicketUiModel bookTicketUimodel, String trainNo) {
        int count = 0;
        String insertSql = "insert into cust_info(name,age,user_id,train_no,active) values('" + bookTicketUimodel.getCustName() + "',"
                + "'" + bookTicketUimodel.getAge() + "','" + bookTicketUimodel.getLoggedUser() + "','" + trainNo + "','1')";
        count = template.update(insertSql);
        if (count == 1) {
            count = 0;
            int custId = template.queryForObject("SELECT max(id) as id FROM cust_info", Integer.class);
            String pnrInsert = "insert into pnr(train_no,cust_id,pnr_status,ticket) values('" + trainNo + "','" + custId + "','Booked','" + bookTicketUimodel.getTicketNumber() + "')";
            int prnInsertCount = template.update(pnrInsert);
            if (prnInsertCount == 1) {
                String sql = "update trains set ticket_availiable=ticket_availiable-" + Integer.parseInt(bookTicketUimodel.getTicketNumber()) + " where train_no=" + trainNo;
                int ticketCount = template.update(sql);
                if (ticketCount == 1) {
                    count = template.queryForObject("SELECT max(id) as id FROM pnr", Integer.class);
                }
            }

            return count;
        } else {
            return count;
        }
    }

    public List<CancelTicketUiModel> getPnrList(String pnrNumber) {
        String sql = "select p.*,c.name,c.active from pnr p join cust_info c on p.cust_id=c.id where p.id=" + pnrNumber;
        return template.query(sql, new RowMapper<CancelTicketUiModel>() {
            @Override
            public CancelTicketUiModel mapRow(ResultSet rs, int i) throws SQLException {

                CancelTicketUiModel element = new CancelTicketUiModel();
                element.setTrainNo(Integer.parseInt(rs.getString(2)));
                element.setCustName(rs.getString(6));
                element.setTicketBooked(rs.getString(5));
                element.setActive(rs.getInt(7));
                element.setCustId(rs.getString(3));
                return element;
            }
        });

    }

    public int cancelBooking(String custId, String trainNumber, String tickets) {
        int count = 0;
        String pnrSql = "update cust_info set active=0 where id=" + custId;
        count = template.update(pnrSql);
        if (count == 1) {

            String trainSql = "update trains set ticket_availiable=ticket_availiable + '" + Integer.parseInt(tickets) + "'where train_no=" + trainNumber;
            count = template.update(trainSql);
            return count;

        } else {
            return count;
        }
    }

}
