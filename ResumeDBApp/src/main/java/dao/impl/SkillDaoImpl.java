package dao.impl;

import DaoInter.CountryDaoInter;
import DaoInter.SkillDaoInter;
import entity.Country;
import entity.Skill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static entity.DbConnection.connect;

public class SkillDaoImpl implements SkillDaoInter {
    private Skill getAllSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String sName = rs.getString("name");


        return new Skill(id, sName);

    }

    @Override
    public List<Skill> getAll() {
        List<Skill> result = new ArrayList<>();
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("SELECT * from skill");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Skill skill = getAllSkill(rs);

                result.add(skill);
            }

            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }
}
