package kyrpap.mytestapp3.ui.trends;

import java.util.List;

import kyrpap.mytestapp3.data.model.local.Trends;

public interface TrendsContract {
    interface View {

        void showTrends(List<Trends> mTrendsList);

        void showSettingsMessage();

    }

    interface Presenter {
        void attachView(TrendsContract.View view);

        void getTrends();
    }
}
