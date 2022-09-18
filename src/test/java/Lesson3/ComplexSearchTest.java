package Lesson3;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ComplexSearchTest extends AbstractTest{
    @Test
    void getQueryPasta() {

        JsonPath response = given().spec(getRequestSpecification())
                ////.queryParam("apiKey", getApiKey())
                .queryParam("query", "pasta")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();
                //.prettyPeek();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getIntolerances() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("intolerances", "Egg")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));

    }

    @Test
    void getIncludeIngredients() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("includeIngredients", "chocolate")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getExcludeIngredients() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("excludeIngredients", "onion")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getInstructionsRequired() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("instructionsRequired", "false")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getFillIngredients() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("fillIngredients", "true")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getAddRecipeInformation() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("addRecipeInformation", "false")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getAddRecipeNutrition() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("addRecipeNutrition", "true")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getTitleMatch() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("titleMatch", "Crock Pot")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getMaxReadyTime() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("maxReadyTime", "20")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getIgnorePantry() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("ignorePantry", "true")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getMinCarbs() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("minCarbs", "20")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getMaxCarbs() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("maxCarbs", "100")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getMinProtein() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("minProtein", "20")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getMaxProtein() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("maxProtein", "100")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getDiet() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("diet", "Ketogenic")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getCalories() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("minCalories", "100")
                .queryParam("maxCalories", "600")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getExcludeCuisine() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("excludeCuisine", "Mediterranean")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getCuisine() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "Thai")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getEquipment() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("equipment", "blender")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getVitaminA() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("minVitaminA", "10")
                .queryParam("maxVitaminA", "200")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getLimitLicense() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("limitLicense", "true")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getVitaminB() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("minVitaminB", "10")
                .queryParam("maxVitaminB", "200")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getVitaminC() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("minVitaminC", "10")
                .queryParam("maxVitaminC", "200")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getVitaminD() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("minVitaminD", "10")
                .queryParam("maxVitaminD", "200")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }

    @Test
    void getVitaminE() {

        JsonPath response = given().spec(getRequestSpecification())
                //.queryParam("apiKey", getApiKey())
                .queryParam("minVitaminE", "10")
                .queryParam("maxVitaminE", "200")
                .queryParam("number", getRandomNumber())
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .body()
                .jsonPath();

        assertThat(response.get("offset"), equalTo(0));
        assertThat(response.get("number"), equalTo(getRandomNumber()));
    }


}
