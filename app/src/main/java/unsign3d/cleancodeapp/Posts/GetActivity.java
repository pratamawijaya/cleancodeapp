package unsign3d.cleancodeapp.Posts;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;

import butterknife.Bind;
import butterknife.ButterKnife;
import models.Post;
import unsign3d.cleancodeapp.R;
import unsign3d.cleancodeapp.flux_layer.SingleDispatcher;
import unsigned.fluxify.stores.StoreObject;

public class GetActivity extends AppCompatActivity {

    @Bind(R.id.title_string)
    TextView title;
    @Bind(R.id.body_string)
    TextView body;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    SinglePostStore store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        ButterKnife.bind(this);

        store = new SinglePostStore(SingleDispatcher.getInstance());
        SingleDispatcher.getInstance().register(this);
        SingleDispatcher.getInstance().register(store);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Subscribe
    public void onStoreChangedEvent(SinglePostStore.SinglePostStoreChangedEvent event){
        updateUI();
    }

    public void updateUI(){
        StoreObject object = store.getItems().get("post");
        Post post = (Post) object.getCarry();

        title.setText(post.getTitle());
        body.setText(post.getBody());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
