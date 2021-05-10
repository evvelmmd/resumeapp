package dao.impl;

import DaoInter.UserDaoInter;
import DaoInter.UserSkillDaoInter;
import entity.Country;
import entity.Skill;
import entity.User;
import entity.User_skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static entity.DbConnection.connect;

public class UserSkillDaoImpl implements UserSkillDaoInter {




    private User_skill getUserSkill(ResultSet rs) throws Exception{
        int userId=rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName=rs.getString("skill_name");
        int power =rs.getInt("power");

        return new User_skill(null,new User(userId),new Skill(skillId,skillName),power);
    }
    @Override
    public List<User_skill> getAllSkillByUser(int userId) {
        List<User_skill> result = new ArrayList<>();
        try {
                Connection c = connect();
                PreparedStatement stmt = c.prepareStatement(" SELECT " +
                        " u.*, "+
                        " us.skill_id, " +
                        " s.name as skill_name, " +
                        " us.power " +
                        " from " +
                        " user_skill us " +
                        " left join user u on us.user_id=u.id " +
                        " left join skill s on us.skill_id = s.id " +
                        " where " +
                        "us.user_id = ? ");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                User_skill u = getUserSkill(rs);

                result.add(u);
            }

            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}