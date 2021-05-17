package DaoInter;

import entity.Employment_history;

import java.util.List;

public interface EmploymentHistoryDaoInter {

    public List<Employment_history> getAllEmploymentHistoryByUserId(int userId);

}