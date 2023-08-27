import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import user.CreateUserClient;
import user.createUserRequestBody;
import user.createUserResponseBody;

import static org.testng.Assert.*;

public class RestAssuredTest {

    @Test
    public void shouldCreateUser(){

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

        //Assert
        assertNotNull(responseBody.getUserId());
        assertEquals(responseBody.getName(), requestBody.getName());


    }
}
