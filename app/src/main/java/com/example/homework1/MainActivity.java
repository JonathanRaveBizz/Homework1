package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DayRecyclerView.ItemClickListener {

    DayRecyclerView adapter;
    RecyclerView dayView;

    public static Intent returnToMainActivity(Context context)
    {
        return new Intent(context, MainActivity.class);
    }
    //private int ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dayView = findViewById(R.id.dayView);

        setupRecyclerView();

    }
    private void setupRecyclerView()
    {
        ArrayList<String> days= new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturnsday");
        days.add("SunsDays");

        adapter = new DayRecyclerView();
        adapter.setClickListener(this);
        adapter.updateItems(days);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                this,
                2,
                GridLayoutManager.VERTICAL,
                false);
        dayView.setLayoutManager(gridLayoutManager);
        dayView.setAdapter(adapter);

    }
    public void navigateToDayActivity(CharSequence dayName, int dayImage)
    {
        Intent intent = DayActivity.createDayActivityIntent(this);
        intent.putExtra(DayActivity.DAY_IMAGE, dayImage);
        intent.putExtra(DayActivity.DAY_KEY, dayName);
        startActivity(intent);


    }

    @Override
    public void onItemClick(CharSequence dayName, int dayImage) {
        navigateToDayActivity(dayName, dayImage);
    }
}