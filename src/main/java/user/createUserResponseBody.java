package user;

import lombok.Getter;

@Getter
public class createUserResponseBody {

    private Integer userId;
    private String name;
    private String email;
    private  String mobile;
    private String gender;
    private int age;
    private String nationality;
}
