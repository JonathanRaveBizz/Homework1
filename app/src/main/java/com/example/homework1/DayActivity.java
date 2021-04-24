package com.example.homework1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DayActivity extends AppCompatActivity {

    public static final String DAY_KEY = "DAY_KEY";
    public static final String DAY_IMAGE = "DAY_IMAGE";

    private TextView mTextView;
    private ImageView mImageView;
    private Button mButton;
    private View.OnClickListener ReturnToMain;

    public static Intent createDayActivityIntent(Context context) {
        return new Intent(context, DayActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        mTextView = (TextView) findViewById(R.id.the_days_text);
        mImageView = findViewById(R.id.the_days_image);
        mButton = findViewById(R.id.the_return_button);
        mButton.setOnClickListener(ReturnToMain);

        String dayText = "";
        int dayImage = 0;

        Bundle bundle = getIntent().getExtras();
        if(bundle !=null)
        {
            dayText = bundle.getString(DAY_KEY);
            //dayImage = bundle.getInt(DAY_IMAGE, 0);
        }
        mTextView.setText(dayText);
        dayText=dayText.toLowerCase();
        Context context = mImageView.getContext();
        int id = context.getResources().getIdentifier(dayText, "drawable", context.getPackageName());
        mImageView.setImageResource(id);

    }
    public void ReturnToMain(View view)
    {
        //Intent intent = MainActivity.returnToMainActivity(this);
        finish();
    };

}