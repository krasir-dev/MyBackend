package Lesson3;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTest {
    static Properties properties = new Properties();
    private static InputStream configFile;
    private static String apiKey;
    private static String baseUrl;
    private static int randomNumber;
    private static String hashUser;

    private static String userName;

    protected static RequestSpecification requestSpecification;
    protected static ResponseSpecification responseSpecification;


    @BeforeAll
    static void initTest() throws IOException {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        configFile = new FileInputStream("src/main/resources/my.properties");
        properties.load(configFile);

        apiKey = properties.getProperty("apiKey");
        baseUrl = properties.getProperty("baseUrl");
        hashUser = properties.getProperty("hashUser");
        userName = properties.getProperty("userName");

        randomNumber = 1 + (int) (Math.random() * 10);

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured.responseSpecification = responseSpecification;
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public static String getHashUser() {
        return hashUser;
    }

    public static RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public static String getUserName() {
        return userName;
    }
}
