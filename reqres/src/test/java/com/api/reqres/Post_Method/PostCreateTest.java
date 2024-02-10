package com.api.reqres.Post_Method;
import com.api.reqres.Protocol_Design.PostUtils;
import com.api.reqres.Utilites.GlobalData;
import com.api.reqres.Utilites.Resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PostCreateTest {
    String parameter = "/users";

    String POST_Create_Users_EndPoint = GlobalData.Service_End_Point + GlobalData.Resource_End_Point + parameter;


    @Test
    public void postCreateTest() {
        System.out.println("POSTCreateUsers_EndPoint: " + POST_Create_Users_EndPoint);


        Response postCreateTest = given().
                contentType("application/json")
                .body(PostUtils.Json_Post_Create_User)
                //.body(PostUtils.createUser(PostUtils.randomGivenUserName))
                .when()
                .post(POST_Create_Users_EndPoint);

        postCreateTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.Successfully_Account_Created).log().all()
                .body("name", equalTo("Bishojit Chakrobortty"))
                .body("job", equalTo("qa engineer"));




                /*
                .contentType("application/json")
                .body(json)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .contentType("application/json")
                 */




    }
}
