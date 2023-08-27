import org.testng.ITestContext;
import org.testng.annotations.Test;
import user.CreateUserClient;
import user.createUserResponseBody;

import static org.testng.Assert.assertEquals;

public class GetRequest {

    @Test
    public void shouldGetUser(ITestContext context){

        //Arrange
        Object id = context.getAttribute("id");

        //Act
        createUserResponseBody responseBody = new CreateUserClient().getUser(id);

        //Assert
        assertEquals(responseBody.getName(),"Jon");
        assertEquals(responseBody.getNationality(),"USA");
    }
}
