package dao.impl;

import DaoInter.UserDaoInter;
import entity.Country;
import entity.Skill;
import entity.User;
import entity.User_skill;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import static entity.DbConnection.connect;

public class UserDaoImpl implements UserDaoInter {
    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDesc = rs.getString("profileDescription");
        String adress=rs.getString("Adress");
        int nationalityId = rs.getInt("nationality_id");
        int bithplaceId = rs.getInt("birthplace_id");
        Date birthDate = rs.getDate("birthdate");
        String nationalityStr = rs.getString("nationality");
        String birthPlaceStr = rs.getString("bithplace");

        Country nationality = new Country(nationalityId, null, nationalityStr);
        Country birthPlace = new Country(bithplaceId, birthPlaceStr, null);

        return new User(id, name, surname, email, phone, profileDesc,adress, birthDate, nationality, birthPlace);

    }


    public List<User> getAll() {
        List<User> result = new ArrayList<User>();
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute(" SELECT " +
                    " u.*, " +
                    " n.nationality, " +
                    " c.name as bithplace " +
                    "FROM user u " +
                    "left join country n on u.nationality_id=n.id " +
                    "left join country c on u.birthplace_id=c.id;");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                User u = getUser(rs);

                result.add(u);
            }

            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


    public boolean updateUser(User u) {
        try {
            Connection c = connect();
            c = connect();

            PreparedStatement stmt = c.prepareStatement("update user set name=? ,surname=? ,email=? "
                    + ",phone=?, profileDescription=?, adress=? , birthdate=?, birthplace_id=? ,nationality_id=? where id =?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            
            stmt.setString(5, u.getProfileDescription());
            stmt.setString(6, u.getAdress());
            stmt.setDate(7, u.getBirthdate());
            stmt.setInt(8, u.getBirthplace().getId());
            stmt.setInt(9, u.getNationality().getId());
            stmt.setInt(10, u.getId());
            return stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean removeUser(int id) {
        try {
            Connection c = connect();
            c = connect();

            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id=" + id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public User getById(int UserId) {
        User result = null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute(" SELECT " +
                    " u.*, " +
                    " n.nationality , " +
                    " c.name as bithplace " +
                    "FROM user u " +
                    "left join country n on u.nationality_id=n.id " +
                    "left join country c on u.birthplace_id=c.id where u.id=" + UserId);

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                result = getUser(rs);
            }

            c.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public boolean addUser(User u) {
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("insert into user(name,surname,email,phone,profileDescription,adress,birthdate) values(?,?,?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            
            stmt.setString(5, u.getProfileDescription());
            stmt.setString(6, u.getAdress());
            stmt.setDate(7, u.getBirthdate());
            return stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}