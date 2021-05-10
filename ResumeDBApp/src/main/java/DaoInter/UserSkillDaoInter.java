package DaoInter;
import entity.User_skill;

import java.util.List;

public interface UserSkillDaoInter {

    public List<User_skill> getAllSkillByUser(int userId);
}