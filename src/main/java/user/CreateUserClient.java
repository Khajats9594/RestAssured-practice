package user;

import enums.LogType;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import report.FrameworkLogger;

import static report.FrameworkLogger.*;

public class CreateUserClient {

    public createUserResponseBody createUser(createUserRequestBody requestBody){
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("http://localhost:9292/user/signup");

        //log(LogType.LOGJSON,response.prettyPrint());

        createUserResponseBody createUserResponseBody = response.as(createUserResponseBody.class);

        return createUserResponseBody;
    }

    public createUserResponseBody getUser(Object id){
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .get("http://localhost:9292/user/"+id);

        //log(LogType.LOGJSON,response.prettyPrint());

        createUserResponseBody createUserResponseBody = response.as(createUserResponseBody.class);

        return createUserResponseBody;
    }

    public createUserResponseBody updateUser(createUserRequestBody requestBody,Object id){
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .put("http://localhost:9292/user/update/"+id);

        //log(LogType.LOGJSON,response.prettyPrint());

        createUserResponseBody createUserResponseBody = response.as(createUserResponseBody.class);

        return createUserResponseBody;
    }

    public ResponseBody deleteUser(Object id){
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .delete("http://localhost:9292/user/delete/"+id);

        ResponseBody message = response.body();
        //log(LogType.PASS,response.body().asString());

        return message;
    }

}
