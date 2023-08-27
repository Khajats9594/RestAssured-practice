import org.testng.ITestContext;
import org.testng.annotations.Test;
import user.CreateUserClient;
import user.createUserRequestBody;
import user.createUserResponseBody;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PostRequest {

    @Test
    public void shouldCreateUser(ITestContext context){

        //Arrange
        createUserRequestBody requestBody = createUserRequestBody.builder()
                .name("Jon")
                .email("jon@gmail.com")
                .age(27)
                .gender("male")
                .mobile("9876543210")
                .nationality("USA")
                .build();

        //Act
        createUserResponseBody responseBody = new CreateUserClient().createUser(requestBody);
        context.setAttribute("id",responseBody.getUserId());

        //Assert
        assertNotNull(responseBody.getUserId());
        assertEquals(responseBody.getName(), requestBody.getName());
    }
}
