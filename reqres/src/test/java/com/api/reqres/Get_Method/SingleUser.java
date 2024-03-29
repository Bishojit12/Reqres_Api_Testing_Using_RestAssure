package com.api.reqres.Get_Method;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class SingleUser {
    @Test
    public void singleUsers(){

        Response singleUsers = given().

                when().
                get("https://reqres.in/api/users/2");

        singleUsers.then()
                .assertThat()
                .time(lessThan(2000L))
                .statusCode(200).log().all();

    }

}
