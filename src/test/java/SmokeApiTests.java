import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class SmokeApiTests {
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";
    String body = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }""";

    @Test
    void createUserTest() {
        //given - config
        //when - http
        //then - assert

        ValidatableResponse response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(body)
                .when().post(BASE_URL + "user").then();
        response.statusCode(200);
        response.extract().response().prettyPrint();
    }

    @Test
    void checkUserResponseBody() {

                 given()
                .baseUri(BASE_URL)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(body).
                when()
                .post("user")
                .then()
                .statusCode(200)
                .body("code",equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", notNullValue(String.class));
    }


}
