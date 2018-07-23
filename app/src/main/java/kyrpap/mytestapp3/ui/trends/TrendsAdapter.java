package kyrpap.mytestapp3.ui.trends;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kyrpap.mytestapp3.R;
import kyrpap.mytestapp3.data.model.local.Trends;

public class TrendsAdapter extends RecyclerView.Adapter<TrendsAdapter.ViewHolder>{

    private Context context;
    private List<Trends> trends;
    private final OnItemClickListener listener;

    public TrendsAdapter(Context context, List<Trends> trends, OnItemClickListener listener) {
        this.context = context;
        this.trends = trends;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trend, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mNameView.setText(trends.get(position).getFullName());

        Glide.with(context)
                .applyDefaultRequestOptions(new RequestOptions().override(200, 200))
                .load(trends.get(position).getOwner().getAvatar())
                .into(holder.mThumbView);
    }

    @Override
    public int getItemCount() {
        return trends.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.thumb)
        ImageView mThumbView;
        @BindView(R.id.name)
        TextView mNameView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(v -> listener.onItemClick(getAdapterPosition()));
        }
    }
}
