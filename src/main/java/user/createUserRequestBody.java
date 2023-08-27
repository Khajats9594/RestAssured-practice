package user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class createUserRequestBody {

    private String name;
    private String email;
    private  String mobile;
    private String gender;
    private int age;
    private String nationality;
}
