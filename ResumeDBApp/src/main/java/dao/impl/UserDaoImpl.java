package dao.impl;

import DaoInter.UserDaoInter;
import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static bean.DbConnection.connect;

public class UserDaoImpl implements UserDaoInter {

    public List<User> getAll() {
        List<User> result = new ArrayList<User>();
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select * from user");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                result.add(new User(id,name,surname,email,phone));
            }

            c.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
       return result;
    }


    public boolean updateUser(User u) {
        try {
        Connection c = connect();
            c = connect();

        PreparedStatement stmt = c.prepareStatement("update user set name=? ,surname=? ,email=? ,phone=? where id =?");
        stmt.setString(1,u.getName());
        stmt.setString(2,u.getSurname());
        stmt.setString(3,u.getEmail());
        stmt.setString(4,u.getPhone());

        stmt.setInt(5,u.getId());
        return stmt.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean removeUser(int id) {
        try {
            Connection c = connect();
            c = connect();

            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id="+id);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public User getById(int UserId) {
            User result=null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select * from user where id="+UserId);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                result = new User(id,name,surname,email,phone);
            }

            c.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public boolean addUser(User u) {
        try (Connection c=connect()){

            PreparedStatement stmt=c.prepareStatement("insert into user(name,surname,email,phone) values(?,?,?,?)");
            stmt.setString(1,u.getName());
            stmt.setString(2,u.getSurname());
            stmt.setString(3,u.getEmail());
            stmt.setString(4,u.getPhone());

            return stmt.execute();

        }

        catch (Exception ex){ex.printStackTrace();}
        return false;
    }
}
