package entity;

import java.util.Date;

public class Employment_history {
    private Integer id;
    private String header;
    private Date beginDate;
    private Date endDate;
    private String jobDesc;
    private User user;

    public Employment_history(){}

    public Employment_history(Integer id, String header, Date beginDate, Date endDate, String jobDesc, User user) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDesc = jobDesc;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Employment_history{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", jobDesc='" + jobDesc + '\'' +
                ", user=" + user +
                '}';
    }
}
