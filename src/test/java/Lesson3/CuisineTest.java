package Lesson3;

import Lesson4.CuisineResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;

public class CuisineTest extends AbstractTest {

    static final String url = "recipes/cuisine";
    @Test
    void postCuisineLesson4() {
        CuisineResponse response =given().spec(getRequestSpecification())
                .when()
                .formParam("title", "Vegetable Fried Rice")
                .post(getBaseUrl() + url)
                .then()
                .extract()
                .response()
                .body()
                .as(CuisineResponse.class);

        assertThat(response.getCuisine(), containsString("Chinese"));



    }

    @Test
    void postCuisineSwedishPancake() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Swedish Pancake")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Scandinavian"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineBurger() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Burger")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("American"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineLasagna() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Lasagna")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Italian"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineJollofRice() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Jollof Rice")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("African"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineBeefWellington() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Beef Wellington")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("British"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineCallalooSoup() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Callaloo Soup")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Caribbean"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineVegetableFriedRice() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Vegetable Fried Rice")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Chinese"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineBakedRatatouille() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Baked Ratatouille")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("French"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineChapchae() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Chapchae")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Korean"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineThaiGreenMangoSalad() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Thai Green Mango Salad")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Thai"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineRomesco() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Romesco")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Spanish"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisinePizza() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Pizza")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Italian"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineRisotto() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Risotto")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Italian"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineIrishColcannon() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=Irish Colcannon")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("Irish"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }

    @Test
    void postCuisineGermanMeatloaf() {

        given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .body("title=German Meatloaf")
                .expect()
                .body("confidence", greaterThan(0.0F))
                .body("cuisine", equalTo("German"))
                .when()
                .post(getBaseUrl() + url)
                .then()
                .statusCode(200);
    }
}
