package DaoInter;
import entity.User_skill;
import java.util.List;

/**
 *
 * @author TURAL
 */
public interface UserSkillDaoInter {
     
     
    public List<User_skill> getAllSkillByUserId(int id);

    public boolean insertUserSkill(User_skill u);
    
    public boolean updateUserSkill(User_skill u);
    
    public boolean removeUser(int id);
}