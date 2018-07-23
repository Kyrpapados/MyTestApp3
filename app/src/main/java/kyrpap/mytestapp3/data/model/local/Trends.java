package kyrpap.mytestapp3.data.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Trends implements Parcelable {
    public static final Creator<Trends> CREATOR = new Creator<Trends>() {
        @Override
        public Trends createFromParcel(Parcel in) {
            return new Trends(in);
        }

        @Override
        public Trends[] newArray(int size) {
            return new Trends[size];
        }
    };

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("owner")
    private Owner owner;

    @SerializedName("private")
    private boolean isPrivate;

    @SerializedName("description")
    private String description;

    @SerializedName("created_at")
    private String createdAt;

    public Trends() {
    }

    protected Trends(Parcel in) {
        id = in.readInt();
        name = in.readString();
        fullName = in.readString();
        owner = in.readParcelable(Owner.class.getClassLoader());
        isPrivate = in.readByte() != 0;
        description = in.readString();
        createdAt = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(fullName);
        parcel.writeParcelable(owner, i);
        parcel.writeByte((byte) (isPrivate ? 1 : 0));
        parcel.writeString(description);
        parcel.writeString(createdAt);
    }
}