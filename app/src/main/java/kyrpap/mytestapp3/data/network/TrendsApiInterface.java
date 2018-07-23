package kyrpap.mytestapp3.data.network;

import io.reactivex.Flowable;
import kyrpap.mytestapp3.data.model.responce.TrendsResponse;
import retrofit2.http.GET;

public interface TrendsApiInterface {

    //search/repositories?q=android&sort=stars&order=asc
    @GET("search/repositories?q=android&sort=stars&order=asc")
    Flowable<TrendsResponse> getTrends();
}
