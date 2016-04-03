package unsign3d.cleancodeapp.Posts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import models.Post;
import unsign3d.cleancodeapp.R;
import unsign3d.cleancodeapp.flux_layer.SingleDispatcher;
import unsigned.fluxify.stores.StoreObject;

public class ListActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    PostStore store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        SingleDispatcher dispatcher = SingleDispatcher.getInstance();

        store = new PostStore(dispatcher);

        dispatcher.register(this);
        dispatcher.register(store);

        // check if store is already provisioned, if not
        // make it change

        if(store.getItems().isEmpty()) {
            PostController.listPosts();
        }
        else {
            updateUI();
        }

    }


    @Subscribe
    public void onPostStoreChanged(PostStore.PostStoreChangedEvent event){
        updateUI();
    }

    public void updateUI(){
        StoreObject object = store.getItems().get("post_list");
        List<Post> posts = (List<Post>) object.getCarry();

        PostAdapter postAdapter = new PostAdapter(posts, this);
        recyclerView.setAdapter(postAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
