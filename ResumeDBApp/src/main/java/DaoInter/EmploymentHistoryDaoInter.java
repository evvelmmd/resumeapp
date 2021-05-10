package DaoInter;
import entity.Employment_history;
import entity.User_skill;

import java.util.List;

public interface EmploymentHistoryDaoInter {

    public List<Employment_history> getAllEmploymentHistoryByUserId(int userId);
}