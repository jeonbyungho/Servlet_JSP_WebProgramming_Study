package obj;

public class Member {
    
    private String id;
    private String pwd;
    private String name;
    private String gender;
    private String phone;
    
    public Member(String id, String pwd, String name, String gender, String phone) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
