package dao.impl;

import DaoInter.UserDaoInter;
import bean.Nationality;
import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static bean.DbConnection.connect;

public class UserDaoImpl implements UserDaoInter{
    private User getUser(ResultSet rs) throws Exception{
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        int nationalityId=rs.getInt("nationality_id");
        int bithplaceId=rs.getInt("birthplace_id");
        Date birthDate=rs.getDate("birthdate");
        String nationalityStr = rs.getString("nationality");
        String birthPlaceStr = rs.getString("bithplace");

        Nationality nationality=new Nationality(nationalityId,nationalityStr,null);
        Nationality birthPlace=new Nationality(bithplaceId,birthPlaceStr,null);

        return new User(id,name,surname,email,phone,birthDate,nationality,birthPlace);

    }

    public List<User> getAll() {
        List<User> result = new ArrayList<User>();
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("SELECT " +
                    "u.*," +
                    "n.name as nationality," +
                    "c.country_name as bithplace" +
                    "FROM user u" +
                    "left join nationality n on u.nationality_id=n.id" +
                    "left join nationality c on u.birthplace_id=c.id");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                User u=getUser(rs);

                result.add(u);
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
            stmt.execute("SELECT \n" +
                    "u.*," +
                    "n.name as nationality," +
                    "c.country_name as bithplace" +
                    "FROM user u" +
                    "left join nationality n on u.nationality_id=n.id" +
                    "left join nationality c on u.birthplace_id=c.id  where u.id="+UserId);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                result = getUser(rs);
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
