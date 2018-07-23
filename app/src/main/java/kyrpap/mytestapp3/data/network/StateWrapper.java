package kyrpap.mytestapp3.data.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static kyrpap.mytestapp3.data.network.StateWrapper.Status.ERROR;
import static kyrpap.mytestapp3.data.network.StateWrapper.Status.LOADING;
import static kyrpap.mytestapp3.data.network.StateWrapper.Status.NO_INTERNET;
import static kyrpap.mytestapp3.data.network.StateWrapper.Status.SUCCESS;


public class StateWrapper<T> {
    @NonNull
    private final Status status;
    @Nullable
    private T data;
    @Nullable
    private Throwable throwable;

    public StateWrapper(@NonNull Status status, @Nullable T data, @Nullable Throwable throwable) {
        this.status = status;
        this.data = data;
        this.throwable = throwable;
    }

    public StateWrapper(@NonNull Status status) {
        this.status = status;
    }

    public static <T> StateWrapper<T> success(@Nullable T data) {
        return new StateWrapper<>(SUCCESS, data, null);
    }

    public static <T> StateWrapper<T> error(Throwable throwable, @Nullable T data) {
        return new StateWrapper<>(ERROR, data, throwable);
    }

    public static <T> StateWrapper<T> noInternetError() {
        return new StateWrapper<>(NO_INTERNET);
    }

    public static <T> StateWrapper<T> loading(@Nullable T data) {
        return new StateWrapper<>(LOADING, data, null);
    }

    @NonNull
    public Status getStatus() {
        return status;
    }

    @Nullable
    public T getData() {
        return data;
    }

    @Nullable
    public Throwable getThrowable() {
        return throwable;
    }

    public enum Status {
        SUCCESS,
        ERROR,
        LOADING,
        NO_INTERNET
    }
}