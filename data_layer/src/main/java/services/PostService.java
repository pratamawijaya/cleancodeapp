package services;

import java.util.List;

import models.Post;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by unsigned on 26/03/16.
 *
 * this inteface maps to the /posts api
 */
public interface PostService {

    @GET("/posts")
    Observable<List<Post>> listPosts();

    @GET("/posts/{id}")
    Observable<Post> getPost(@Path("id") int id);

}
