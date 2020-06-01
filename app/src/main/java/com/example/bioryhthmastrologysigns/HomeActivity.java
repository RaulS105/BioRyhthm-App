package com.example.bioryhthmastrologysigns;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";
    private TextView mDisplayDate;
    MediaPlayer mySong;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    public int year;
    public int day;
    public int month;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mySong = MediaPlayer.create(HomeActivity.this, R.raw.music);
        mDisplayDate = (TextView) findViewById(R.id.tvDate);
        mySong.start();

        mDisplayDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Calendar cal2 = Calendar.getInstance();
                year = cal2.get(Calendar.YEAR);
                day = cal2.get(Calendar.DAY_OF_MONTH);
                month = cal2.get(Calendar.MONTH);

                DatePickerDialog dialog = new DatePickerDialog(HomeActivity.this, onDateSetListener, year, month, day);

                dialog.getWindow().setBackgroundDrawable((new ColorDrawable(Color.WHITE)));
                dialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;

                Log.d(TAG, "onDateSet: mm/dd/yy" + month + "/" + day + "/" + year);
                String date = month + " / " + day + " / " + year;
                mDisplayDate.setText(date);
                Intent intent = new Intent(HomeActivity.this, Activity2.class);

                intent.putExtra("Month", month);
                intent.putExtra("Day", day);
                intent.putExtra("Year", year);
                startActivity(intent);
            }

        };


    }}





