package ikas.android.demo.java11.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ikas.android.demo.java11.R;

public class MainFragment extends Fragment {

    private MainViewModel mainViewModel;
    private TextView contentView;

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
        var view = inflater.inflate(R.layout.main_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        contentView = view.findViewById(R.id.content);

        var runBtn = view.findViewById(R.id.run);
        runBtn.setOnClickListener(this::query);

        mainViewModel.content.observe(this.getViewLifecycleOwner(), this::updateContent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentView = null;
    }

    public void query(View v) {
        var data = getArguments();
        if (null != data) {
            mainViewModel.queryAsync(data.getString("key"));
        }
    }

    public void updateContent(String content) {
        contentView.setText(content);
    }

}