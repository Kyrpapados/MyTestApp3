package kyrpap.mytestapp3.ui.trends.details;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kyrpap.mytestapp3.R;
import kyrpap.mytestapp3.data.model.local.Trends;
import kyrpap.mytestapp3.util.Statics;

public class TrendsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.userThumb)
    ImageView mThumbView;
    @BindView(R.id.title)
    TextView mTitleView;
    @BindView(R.id.description)
    TextView mDescriptioView;
    @BindView(R.id.owner)
    TextView mOwnerView;

    private Trends trend;

    public static void show(Activity activity,@NonNull Trends trend) {
        Intent intent = new Intent(activity, TrendsDetailsActivity.class);
        intent.putExtra(Statics.TREND, trend);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trends_details);
        ButterKnife.bind(this);

        trend = getIntent().getExtras().getParcelable(Statics.TREND);

        showTrend(trend);




    }

    private void showTrend(Trends trend) {
        Glide.with(this)
                .applyDefaultRequestOptions(new RequestOptions().override(200, 200))
                .load(trend.getOwner().getAvatar())
                .into(mThumbView);

        mTitleView.setText("Name: "+trend.getName());

        mOwnerView.setText("Created by: "+trend.getOwner().getLogin());

        if(trend.getDescription() != null && !trend.getDescription().equalsIgnoreCase("")) {
            mDescriptioView.setText("Description: "+trend.getDescription());
        }else {
            mDescriptioView.setText("No description.");
        }
    }
}
