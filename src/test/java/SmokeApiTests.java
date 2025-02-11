import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class SmokeApiTests {
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";

    @Test
    void createUserTest() {
        //given - config
        //when - http
        //then - assert
        String bodyJson = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"string\",\n" +
                "  \"firstName\": \"string\",\n" +
                "  \"lastName\": \"string\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"phone\": \"string\",\n" +
                "  \"userStatus\": 0,\n" +
                "}";


        ValidatableResponse response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(bodyJson)
                .when().post(BASE_URL + "user").then();
        response.statusCode(400);
        response.extract().response().prettyPrint();
    }
}
