package example.login.domain;

public class Member {
    private String userid;
    private String passwd;
    private String name;

    public Member() {
    }

    public Member(String userid, String passwd, String name) {
        this.userid = userid;
        this.passwd = passwd;
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
