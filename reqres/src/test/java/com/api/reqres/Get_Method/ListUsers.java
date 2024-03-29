package com.api.reqres.Get_Method;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class ListUsers {
    @Test
    public void listUsers(){

        Response listUsers = given().

                when().
                get("https://reqres.in/api/users?page=2");

        listUsers.then()
                .assertThat()
                .time(lessThan(2000L))
                .statusCode(200).log().all()
                .body( "page",equalTo(2),
                        "per_page",equalTo(6),
                        "total",equalTo(12),
                        "total_pages",equalTo(2));

    }
}
