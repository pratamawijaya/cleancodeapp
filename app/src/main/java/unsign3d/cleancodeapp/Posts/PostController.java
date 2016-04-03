package unsign3d.cleancodeapp.Posts;

import java.util.AbstractMap;

import rest_client.RestClient;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import unsign3d.cleancodeapp.flux_layer.SingleDispatcher;
import unsigned.fluxify.stores.StoreObject;

/**
 * Created by unsigned on 26/03/16.
 *
 */
public class PostController {
    /**
     * This function get the list posts
     */
    public static void listPosts(){
        new RestClient()
                .getPostService()
                .listPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    SingleDispatcher
                            .getInstance()
                            .dispatch(
                                    "POST_HAS_CHANGED",
                                    new AbstractMap.SimpleEntry<>(
                                            "POST_HAS_CHANGED",
                                            new StoreObject(
                                                    "post_list",
                                                    false,
                                                    list
                                            )
                            ));
                });
    }

    public static void getPost(int id){
        new RestClient()
                .getPostService()
                .getPost(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(post -> {
                    SingleDispatcher
                            .getInstance()
                            .dispatch("SINGLE_POST_HAS_CHANGED",
                                    new AbstractMap.SimpleEntry<>(
                                            "SINGLE_POST_HAS_CHANGED",
                                            new StoreObject(
                                                    "post",
                                                    false,
                                                    post
                                            )
                                    ));
                });
    }


}
