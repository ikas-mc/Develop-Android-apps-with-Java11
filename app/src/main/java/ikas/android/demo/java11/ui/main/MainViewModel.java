package ikas.android.demo.java11.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MainViewModel extends ViewModel {
    public final MutableLiveData<String> content = new MutableLiveData<>();

    public CompletableFuture<String> queryAsync(String param) {
        return CompletableFuture.supplyAsync(() -> {
            var data = List.of(param, LocalDateTime.now().toString());
            return String.join("\n", data);
        }).whenCompleteAsync((result, e) -> {
            content.postValue(result);
        });
    }
}