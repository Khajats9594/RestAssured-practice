package com.userapplication.tests;

import io.restassured.response.ResponseBody;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import user.CreateUserClient;

import static org.testng.Assert.assertEquals;

public class DeleteRequest {

    @Test
    public void shouldDeleteUser(ITestContext context){

        //Arrange
        Object id = context.getAttribute("id");

        //Act
        ResponseBody responseBody = new CreateUserClient().deleteUser(id);

        //Assert
        assertEquals(responseBody.asString(),"User with ID " + id + " has been successfully deleted.");
    }
}
