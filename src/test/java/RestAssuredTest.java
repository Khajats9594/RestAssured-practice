import io.restassured.response.ResponseBody;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import user.CreateUserClient;
import user.createUserRequestBody;
import user.createUserResponseBody;
import static org.testng.Assert.*;
public class RestAssuredTest {

    @Test(priority = 1)
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
        //log(LogType.JSON,requestBody.toString());

        //Act
        createUserResponseBody responseBody = new CreateUserClient().createUser(requestBody);
        context.setAttribute("id",responseBody.getUserId());

        //Assert
        assertNotNull(responseBody.getUserId());
        assertEquals(responseBody.getName(), requestBody.getName());
    }
    @Test(priority = 2)
    public void shouldGetUser(ITestContext context){

        //Arrange
        Object id = context.getAttribute("id");

        //Act
        createUserResponseBody responseBody = new CreateUserClient().getUser(id);

        //Assert
        assertEquals(responseBody.getName(),"Jon");
        assertEquals(responseBody.getNationality(),"USA");
    }
    @Test(priority = 3)
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
        //log(LogType.JSON,requestBody.toString());

        //Act
        createUserResponseBody responseBody = new CreateUserClient().updateUser(requestBody,id);

        //Assert
        assertEquals(responseBody.getName(),requestBody.getName());
        assertEquals(responseBody.getNationality(),requestBody.getNationality());
    }
    @Test(priority = 4)
    public void shouldDeleteUser(ITestContext context){

        //Arrange
        Object id = context.getAttribute("id");

        //Act
        ResponseBody responseBody = new CreateUserClient().deleteUser(id);

        //Assert
        assertEquals(responseBody.asString(),"User with ID " + id + " has been successfully deleted.");
    }

}
