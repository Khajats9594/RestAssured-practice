import org.testng.ITestContext;
import org.testng.annotations.Test;
import user.CreateUserClient;
import user.createUserRequestBody;
import user.createUserResponseBody;

import static org.testng.Assert.assertEquals;

public class UpdateRequest {

    @Test
    public void shouldUpdateUser(ITestContext context){

        //Arrange
        Object id = context.getAttribute("id");
        createUserRequestBody requestBody = createUserRequestBody.builder()
                .name("vinod")
                .email("vtn@gmail.com")
                .age(27)
                .gender("male")
                .mobile("9876543210")
                .nationality("India")
                .build();

        //Act
        createUserResponseBody responseBody = new CreateUserClient().updateUser(requestBody,id);

        //Assert
        assertEquals(responseBody.getName(),requestBody.getName());
        assertEquals(responseBody.getNationality(),requestBody.getNationality());
    }
}
