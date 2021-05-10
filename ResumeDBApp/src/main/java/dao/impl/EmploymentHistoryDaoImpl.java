package dao.impl;

import DaoInter.EmploymentHistoryDaoInter;
import DaoInter.UserSkillDaoInter;
import entity.Employment_history;
import entity.Skill;
import entity.User;
import entity.User_skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static entity.DbConnection.connect;

public class EmploymentHistoryDaoImpl implements EmploymentHistoryDaoInter {


    private Employment_history getEmploymentHistory(ResultSet rs) throws Exception {

        String header = rs.getString("header");
        Date begin_date = rs.getDate("begin_date");
        Date end_date = rs.getDate("end_date");
        String JobDesc = rs.getString("JobDescription");
        int userId = rs.getInt("user_id");
        Employment_history emp = new Employment_history(null, header, begin_date, end_date, JobDesc, new User(userId));
        return emp;
    }

    @Override
    public List<Employment_history> getAllEmploymentHistoryByUserId(int userId) {
        List<Employment_history> result = new ArrayList<>();
        try {
            Connection c = connect();
            PreparedStatement stmt = c.prepareStatement("select * from employment_history where user_id=? ");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Employment_history emp = getEmploymentHistory(rs);

                result.add(emp);
            }

            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}