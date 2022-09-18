package Lesson3;

import Lesson4.AddShoppingListRequest;
import Lesson4.CuisineResponse;
import Lesson4.ShopingListResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;

public class ShoppingList extends AbstractTest {

    static final String url = "mealplanner/";


    @Test
    void addShoppingList() {
        AddShoppingListRequest addShoppingListRequest = new AddShoppingListRequest("4 cake", "Baking", true);


        String id =given().spec(getRequestSpecification())
                .pathParam("userName", getUserName())
                .queryParam("hash", getHashUser())
                .body(addShoppingListRequest)
                .when()
                .post(getBaseUrl() + url + "{userName}/shopping-list/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        System.out.println(id);

        given()
                .pathParam("userName", getUserName())
                .queryParam("hash", getHashUser())
                .queryParam("apiKey", getApiKey())
                .pathParam("userName", getUserName())
                .delete(getBaseUrl() + url + "{userName}/shopping-list/items/"+ id)
                .then()
                .statusCode(200);

    }

    @Test
    void getShoppingList() {
        ShopingListResponse response = given().spec(getRequestSpecification())
                .pathParam("userName", getUserName())
                .queryParam("hash", getHashUser())
                .when()
                .get(getBaseUrl() + url + "{userName}/shopping-list")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .body()
                .as(ShopingListResponse.class);


        System.out.println(response.getCost());

        assertThat(response.getCost(), greaterThan(500d));

    }
    @Test
    void deleteShoppingListItem() {
        given()
                .queryParam("hash", getHashUser())
                .queryParam("apiKey", getApiKey())
                .pathParam("userName", getUserName())
                .delete("https://api.spoonacular.com/mealplanner/{userName}/shopping-list/items/1309771")
                .then()
                .statusCode(200);
    }



}
