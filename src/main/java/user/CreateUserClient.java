package user;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateUserClient {

    public createUserResponseBody createUser(createUserRequestBody requestBody){
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("http://localhost:9292/user/signup");

        createUserResponseBody createUserResponseBody = response.as(createUserResponseBody.class);

        return createUserResponseBody;
    }
}
