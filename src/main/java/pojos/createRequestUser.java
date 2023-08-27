package pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class createRequestUser {

    private String name;
    private String email;
    private  String mobile;
    private String gender;
    private int age;
    private String nationality;
}
