package ikas.android.demo.java11;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ikas.android.demo.java11.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            var data = new Bundle();
            data.putString("key", "hello java 11");

            var page = MainFragment.newInstance();
            page.setArguments(data);

            getSupportFragmentManager().beginTransaction().replace(R.id.container, page).commitNow();
        }
    }
}