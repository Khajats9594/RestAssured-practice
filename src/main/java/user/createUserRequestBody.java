package user;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class createUserRequestBody {

    private String name;
    private String email;
    private  String mobile;
    private String gender;
    private int age;
    private String nationality;
}
