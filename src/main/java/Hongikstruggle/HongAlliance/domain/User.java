package Hongikstruggle.HongAlliance.domain;

public class User {

    private Long id; //1번부터 순서대로
    private String name;
    private String email;
    private String password;
    // private boolean admin;, 좋아요 한 것들의 id를 저장하는 값도 필요

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
