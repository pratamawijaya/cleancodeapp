package unsign3d.cleancodeapp.Posts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import models.Post;
import unsign3d.cleancodeapp.R;

/**
 * Created by unsigned on 26/03/16.
 *
 */
public class PostAdapter extends RecyclerView.Adapter<PostViewHolder>{
    private List<Post> posts;
    private Context context;

    public PostAdapter(List<Post> posts, Context context) {
        this.context = context;
        this.posts = posts;

    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_post, parent, false);

        PostViewHolder viewHolder = new PostViewHolder(v,context);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = posts.get(position);

        holder.title.setText(post.getTitle());
        holder.body.setText(post.getBody());
        holder.id = post.getId();
        holder.userId = post.getUserId();
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
