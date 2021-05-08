import DaoInter.UserDaoInter;
import bean.User;
import dao.impl.UserDaoImpl;

public class main {
    public static void main(String[] args) throws Exception{
        UserDaoInter UserDao =new UserDaoImpl();

//        UserDao.removeUser(1);
//        List<User> list2 = UserDao.getAll();
//        System.out.println("list: " + list);
//        System.out.println("list2: " + list2);


//          User u = new User();
//          u.setName("Eyvaz");
//          u.setSurname("Memmedov");
//          u.setEmail("evellmd@gmail.com");
//          u.setPhone("51515155");
//          u.setId(2);
//           UserDao.updateUser(u);
//        List<User> list = UserDao.getAll();
//        System.out.println("list: " + list);

//        User u =UserDao.getById(2);
//        u.setName("Evvel");
//        u.setPhone("0705123982");
//        UserDao.updateUser(u);
//        System.out.println(u.toString());

        User u =new User(4,"dssscsc","Dosdar","dos@gmaiil.com", "0705123982");
        UserDao.addUser(u);

    }
}
