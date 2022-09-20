package Lesson5.api;

import Lesson5.dto.Product;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface ProductController {
    @GET("products")
    Call<ResponseBody> getAllProducts();

    @POST("products")
    Call<Product> createProduct(@Body Product createProductRequest);

    @PUT("products")
    Call<Product> modifyProduct(@Body Product modifyProductRequest);

    @GET("products/{id}")
    Call<Product> getSpecificProductById(@Path("id") int id);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProductById (@Path("id") int id);

}
