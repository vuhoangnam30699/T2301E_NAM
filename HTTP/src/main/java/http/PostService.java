package http;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import java.io.IOException;
import java.util.List;

public class PostService {
    private static final String BASE_URL = "https://dummyjson.com";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Post> list(int page, int size) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/posts?page=" + page + "&size=" + size)
                .build();
        Response response = client.newCall(request).execute();
        return mapper.readValue(response.body().string(), PostResponse.class).getPosts();
    }

    public Post create(Post post) throws IOException {
        RequestBody body = RequestBody.create(JSON, mapper.writeValueAsString(post));
        Request request = new Request.Builder()
                .url(BASE_URL + "/posts")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return (Post) mapper.readValue(response.body().string(), PostResponse.class).getPosts();
    }

    public Post update(int id, Post post) throws IOException {
        RequestBody body = RequestBody.create(JSON, mapper.writeValueAsString(post));
        Request request = new Request.Builder()
                .url(BASE_URL + "/posts/" + id)
                .put(body)
                .build();
        Response response = client.newCall(request).execute();
        return mapper.readValue(response.body().string(), Post.class);
    }

    public Post delete(int id) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "/posts/" + id)
                .delete()
                .build();
        Response response = client.newCall(request).execute();
        return mapper.readValue(response.body().string(), Post.class);
    }
}
