package kyrpap.mytestapp3.data.model.responce;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import kyrpap.mytestapp3.data.model.local.Trends;

public class TrendsResponse{

    @SerializedName("items")
    private List<Trends> trends;

    public List<Trends> getTrends() {
        return trends;
    }

    public void setTrends(List<Trends> trends) {
        this.trends = trends;
    }
}
