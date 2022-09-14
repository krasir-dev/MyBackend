package Lesson3;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class CuisineTest extends AbstractTest {

    @Test
    void postCuisineSwedishPancake() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Swedish Pancake")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Nordic"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineBurger() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Burger")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("American"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineLasagna() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Lasagna")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Italian"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineJollofRice() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Jollof Rice")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("African"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineBeefWellington() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Beef Wellington")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("British"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineCallalooSoup() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Callaloo Soup")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Caribbean"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineVegetableFriedRice() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Vegetable Fried Rice")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Chinese"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineBakedRatatouille() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Baked Ratatouille")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("French"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineChapchae() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Chapchae")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Korean"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineThaiGreenMangoSalad() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Thai Green Mango Salad")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Thai"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineRomesco() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Romesco")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Spanish"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisinePizza() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Pizza")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Italian"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineRisotto() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Risotto")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Italian"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineIrishColcannon() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=Irish Colcannon")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Irish"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineGermanMeatloaf() {

        given()
                .queryParam("apiKey", getApiKey())
                .body("title=German Meatloaf")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("German"))
                .when()
                .post(getBaseUrl() + "recipes/cuisine")
                .then()
                .statusCode(200);
    }
}
