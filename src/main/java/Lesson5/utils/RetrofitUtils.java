package Lesson5.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class RetrofitUtils {
    Properties properties = new Properties();

    private static InputStream configFile;

    static {
        try {
            configFile = new FileInputStream("src/main/resources/my.properties");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    @SneakyThrows
    public String getBaseUrl () {
        properties.load(configFile);
        return properties.getProperty("url");

    }

    public Retrofit getRetrofit (){
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }






}
