package kyrpap.mytestapp3.ui.trends;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kyrpap.mytestapp3.R;
import kyrpap.mytestapp3.data.model.local.Trends;
import kyrpap.mytestapp3.data.network.TrendsApiClient;
import kyrpap.mytestapp3.data.network.TrendsApiInterface;
import kyrpap.mytestapp3.ui.trends.details.TrendsDetailsActivity;

public class TrendsActivity extends AppCompatActivity implements TrendsContract.View, OnItemClickListener {

    @BindView(R.id.trendsRecyclerView)
    RecyclerView mTrendsView;

    private TrendsApiInterface trendsApiInterface;

    private TrendsPresenter mPresenter;

    private TrendsAdapter mTrendsAdapter;

    private List<Trends> mTrendsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trends);
        ButterKnife.bind(this);

        trendsApiInterface = TrendsApiClient.getClient().create(TrendsApiInterface.class);

        mPresenter = new TrendsPresenter(provideConnectivityManager(getApplication()), trendsApiInterface);
        mPresenter.attachView(this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mTrendsView.setLayoutManager(mLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mTrendsView.getContext(),
                mLayoutManager.getOrientation());
        mTrendsView.addItemDecoration(dividerItemDecoration);
        mTrendsView.setItemAnimator(new DefaultItemAnimator());

        mPresenter.getTrends();
    }

    ConnectivityManager provideConnectivityManager(Application application) {
        return (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Override
    public void showTrends(List<Trends> trendsList) {
        mTrendsList = trendsList;
        mTrendsAdapter = new TrendsAdapter(this, mTrendsList, this);
        mTrendsView.setAdapter(mTrendsAdapter);

    }

    @Override
    public void onItemClick(int position) {
        TrendsDetailsActivity.show(this, mTrendsList.get(position));
    }
}
