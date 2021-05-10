package entity;

public class User_skill {
    private Integer id;
    private User user;
    private Skill skill;
    private int power;

    public User_skill(Integer id, User user, Skill skill, int power) {
        this.id = id;
        this.user = user;
        this.skill = skill;
        this.power = power;
    }
    public User_skill(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "User_skill{" +
                "id=" + id +
                ", user=" + user +
                ", skill=" + skill +
                ", power=" + power +
                '}';
    }
}
