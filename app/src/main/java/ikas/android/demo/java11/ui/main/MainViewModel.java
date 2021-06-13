package ikas.android.demo.java11.ui.main;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MainViewModel extends ViewModel {
    public final MutableLiveData<String> content = new MutableLiveData<>();

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void queryAsync(String param) {
        CompletableFuture.supplyAsync(() -> {
            var data = List.of(param, LocalDateTime.now().toString());
            return String.join("\n", data);
        }).whenCompleteAsync((result, e) -> {
            content.postValue(result);
        });
    }
}