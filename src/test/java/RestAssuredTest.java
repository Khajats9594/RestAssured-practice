import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.createRequestUser;
import pojos.createResponseUser;

public class RestAssuredTest {

    @Test
    public void shouldCreateUser(){

        //Arrange
        createRequestUser user = createRequestUser.builder()
                .name("Jon")
                .email("jon@gmail.com")
                .age(27)
                .gender("male")
                .mobile("9876543210")
                .nationality("USA")
                .build();

        //Act
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(user)
                .post("http://localhost:9292/user/signup");

        response.prettyPrint();

        createResponseUser createResponseUser = response.as(createResponseUser.class);

        //Assert
        Assert.assertNotNull(createResponseUser.getUserId());
        Assert.assertEquals(createResponseUser.getName(), user.getName());

    }
}
