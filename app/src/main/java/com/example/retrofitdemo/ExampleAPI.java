package com.example.retrofitdemo;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ExampleAPI {

    //https://jsonplaceholder.typicode.com/posts is the API url taken as an example.

    @GET("posts")     // https://jsonplaceholder.typicode.com/posts . parenthesis contains posts because relative url is /posts
    Call<List<Post>> getPosts();

    /*@GET("posts/{id}/comments")
    Call<List<Comment>> getComment(@Path("id")int postId);*/

    @GET("comments")
    Call<List<Comment>> getComment(@Query("postId")int postId,@Query("_sort")String sort,@Query("_order")String order);

    @GET
    Call<List<Comment>> getComment(@Url String url);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPostFUE(@Field("userId") int userId, @Field("title") String title, @Field("body") String text);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPostFUEFM(@FieldMap Map<String,String> fields);

    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id")int id,@Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
