package unsign3d.cleancodeapp.Posts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import unsign3d.cleancodeapp.R;

/**
 * Created by unsigned on 26/03/16.
 *
 */
public class PostViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.title_string)
    TextView title;
    @Bind(R.id.body_string)
    TextView body;
    @Bind(R.id.card_view)
    CardView cardView;

    int id, userId;

    public PostViewHolder(View itemView, Context context) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        cardView.setOnClickListener(l ->{
            // start async getpost
            PostController.getPost(id);
            // now start new activity
            Intent intent = new Intent(context, GetActivity.class);
            context.startActivity(intent);
        });


    }
}
