import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import static io.restassured.RestAssured.given;

public class GetAllUsersTests {
    //1. Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new  UsersClient();
    }
    @Test
    public void shouldGetAllUsers(){
        //2. Act
        usersClient
                .getAllUsers()
                    .then()
        //3. Assert
                        .statusCode(200)
                        .log().body()
                        .body("data", Matchers.hasSize(20))
                        .body("data", Matchers.hasItem(Matchers.hasEntry("gender", "male")));
    }



}
