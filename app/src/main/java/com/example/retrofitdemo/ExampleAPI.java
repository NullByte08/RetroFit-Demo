package com.example.retrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ExampleAPI {

    //https://jsonplaceholder.typicode.com/posts is the API url taken as an example.

    @GET("posts")     // https://jsonplaceholder.typicode.com/posts . parenthesis contains posts because relative url is /posts
    Call<List<Post>> getPosts();

    /*@GET("posts/{id}/comments")
    Call<List<Comment>> getComment(@Path("id")int postId);*/

    @GET("comments")
    Call<List<Comment>> getComment(@Query("postId")int postId);
}
