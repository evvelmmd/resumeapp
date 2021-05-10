package dao.impl;

import DaoInter.CountryDaoInter;
import entity.Country;
import entity.Employment_history;
import entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static entity.DbConnection.connect;

public class CountryDaoImpl implements CountryDaoInter {
    private Country getAllCountry(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String cName = rs.getString("name");
        String nat = rs.getString("nationality");

        return new Country(id, cName, nat);

    }

    @Override
    public List<Country> getAll() {
        List<Country> result = new ArrayList<>();
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("SELECT * from country");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Country country = getAllCountry(rs);

                result.add(country);
            }

            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }
}
