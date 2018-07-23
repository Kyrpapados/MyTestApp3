package kyrpap.mytestapp3.ui.trends;

import android.net.ConnectivityManager;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kyrpap.mytestapp3.data.network.TrendsApiInterface;

public class TrendsPresenter implements TrendsContract.Presenter {

    private TrendsContract.View mView;
    private ConnectivityManager mConnectivityManager;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private TrendsApiInterface trendsApiInterface;

    public TrendsPresenter(ConnectivityManager mConnectivityManager, TrendsApiInterface trendsApiInterface){
        this.mConnectivityManager = mConnectivityManager;
        this.trendsApiInterface = trendsApiInterface;
    }

    @Override
    public void attachView(TrendsContract.View view) {
        mView = view;
    }

    @Override
    public void getTrends() {
        if(checkInternetConnection()){
            mCompositeDisposable.add(trendsApiInterface.getTrends().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((trendsResponse) -> mView.showTrends(trendsResponse.getTrends()),
                            throwable -> {
                            }));
        }
    }

    private boolean checkInternetConnection() {
        if (!(mConnectivityManager.getActiveNetworkInfo() != null && mConnectivityManager.getActiveNetworkInfo().isConnected())) {
            mView.showSettingsMessage();

            return false;
        }

        return true;
    }
}
