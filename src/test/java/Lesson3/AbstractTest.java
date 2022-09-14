package Lesson3;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTest {
    static Properties properties =new Properties();
    private static InputStream configFile;
    private static String apiKey;
    private static String baseUrl;
    private static int randomNumber;
    private static String hashUser;

    private static RequestSpecification requestSpec;

    @BeforeAll
    static void initTest () throws IOException {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        configFile =new FileInputStream("src/main/resources/my.properties");
        properties.load(configFile);

        apiKey = properties.getProperty("apiKey");
        baseUrl = properties.getProperty("baseUrl");
        hashUser = properties.getProperty("hashUser");

        randomNumber = 1 + (int)(Math.random()*10);

        /*requestSpec  = new ResponseSpecBuilder()
                .setContentType("application/x-www-form-urlencoded")
                .build();*/

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
}
