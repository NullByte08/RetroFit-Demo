package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ExampleAPI exampleAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();

        exampleAPI = retrofit.create(ExampleAPI.class);

        //getPosts();
        //getComments();
        createPost();
        createPostFUE();
    }

    private void getPosts() {
        Call<List<Post>> call = exampleAPI.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle();
                    content += "Text: " + post.getText() + "\n\n";  //  content string is the final result

                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

    private void getComments() {
        Call<List<Comment>> call = exampleAPI.getComment(3, "id", "desc");

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }

                List<Comment> comments = response.body();

                for (Comment comment : comments) {
                    String content = "";
                    content += "ID: " + comment.getId() + "\n";
                    content += "Email: " + comment.getEmail() + "\n";
                    content += "Body: " + comment.getBody();
                    content += "Name: " + comment.getName() + "\n\n";  //  content string is the final result

                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

    private void createPost() {
        final Post post = new Post(23, "NEW TITLE", "NEW TEXT");

        Call<Post> call = exampleAPI.createPost(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }

                Post postresponse = response.body();


                String content = "";

                content += "Code: " + response.code()+"\n";

                content += "ID: " + postresponse.getId() + "\n";
                content += "User ID: " + postresponse.getUserId() + "\n";
                content += "Title: " + postresponse.getTitle();
                content += "Text: " + postresponse.getText() + "\n\n";  //  content string is the final result

                textView.setText(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }

    private void createPostFUE(){

        Call<Post> call = exampleAPI.createPostFUE(23,"NEW TITLE","NEW TEXT");

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }

                Post postresponse = response.body();


                String content = "";

                content += "Code: " + response.code()+"\n";

                content += "ID: " + postresponse.getId() + "\n";
                content += "User ID: " + postresponse.getUserId() + "\n";
                content += "Title: " + postresponse.getTitle();
                content += "Text: " + postresponse.getText() + "\n\n";  //  content string is the final result

                textView.setText(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }



}
