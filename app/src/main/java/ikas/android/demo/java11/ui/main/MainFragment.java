package ikas.android.demo.java11.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ikas.android.demo.java11.databinding.MainFragmentBinding;

public class MainFragment extends Fragment {

    private MainViewModel mainViewModel;
    private MainFragmentBinding view;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = MainFragmentBinding.inflate(inflater, container, false);
        return view.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View root, @Nullable Bundle savedInstanceState) {
        view.run.setOnClickListener(this::queryAsync);
        mainViewModel.content.observe(this.getViewLifecycleOwner(), this::updateContent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null;
    }

    public void queryAsync(View v) {
        var data = getArguments();
        if (null != data) {
            mainViewModel.queryAsync(data.getString("key"));
        }
    }

    public void updateContent(String content) {
        view.content.setText(content);
    }

}