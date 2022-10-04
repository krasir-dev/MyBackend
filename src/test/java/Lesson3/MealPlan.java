package Lesson3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MealPlan extends AbstractTest{

    @BeforeAll
    static void setUp() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
    @Test
    void addMealTest() {
 /*           String hash = given()
                    .queryParam("apiKey", getApiKey())
                    .body("{ \"username\": \"krasir\",}")
                    .when()
                    .post(getBaseUrl() + "users/connect")
                    .then()
                    .statusCode(200)
                    .extract()
                    .jsonPath()
                    .prettyPeek()
                    .get("hash")
                    .toString();*/


        String id = given()
                .queryParam("hash", getHashUser())
                .queryParam("apiKey", getApiKey())
                .pathParam("userName", getUserName())
                .body("{\n"
                        + " \"date\": 1663344701,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"2 banana\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/{userName}/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("hash", getHashUser())
                .queryParam("apiKey", getApiKey())
                .pathParam("userName", getUserName())
                .delete("https://api.spoonacular.com/mealplanner/{userName}/items/" + id)
                .then()
                .statusCode(200);
    }

}
