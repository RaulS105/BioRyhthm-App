package com.example.bioryhthmastrologysigns;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Activity2 extends AppCompatActivity
{
    private LineGraphSeries<DataPoint> physical, emotional, intellectual;
    TextView t1;
    TextView bioRyhthmResult;
    GraphView graph;
    Button button;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        button = (Button)findViewById(R.id.btnNextResult);
        t1 = (TextView) findViewById(R.id.tvBirthday);
        bioRyhthmResult = (TextView) findViewById(R.id.tvBioResults);

        //sets current date for BioRhythm Calculation
        Calendar cal = Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);
        final int day = cal.get(Calendar.DAY_OF_MONTH);
        final int month = cal.get(Calendar.MONTH) + 1;
        Calendar today = new GregorianCalendar(year, month - 1, day);


        //brings time from HomeActivity Class
       final int getMonth = getIntent().getExtras().getInt("Month");
       final int getDay = getIntent().getExtras().getInt("Day");
       final int getYear = getIntent().getExtras().getInt("Year");

       t1.setText("Your Birthday is:" + "\n" + "Month: " + getMonth + "\n" + " Day: " + getDay + "\n" +" Year: " + getYear );

       Calendar born = new GregorianCalendar(getYear, getMonth - 1 , getDay);
       double diffTime = today.getTimeInMillis() - born.getTimeInMillis();
       diffTime = diffTime/(24*60*60*1000);

        //sets calculations for BioRhythm
       double physicalResult = (Math.sin((2 * Math.PI*diffTime)/23)*100);
       double emotionalResult = (Math.sin((2 * Math.PI*diffTime)/28)*100);
       double intellectualResult = (Math.sin((2*Math.PI*diffTime)/33)*100);
        //Rounds from decimal place
       DecimalFormat locate = new DecimalFormat("##0.0");

       //Sends results from bioRhythm
       bioRyhthmResult.setText("Biorhythm Scan Reports" + "\n" + "Physical Level: " + locate.format(physicalResult) + "\n" + "Emotional Level: " + locate.format(emotionalResult) + "\n"
                             + "Intellectual Level: "+ locate.format(intellectualResult));


        graph = (GraphView) findViewById(R.id.graph);
        graph.setVisibility(View.GONE);

        double x;

        x = 0.0;
        //Initialize to set color sin waves.
        physical = new LineGraphSeries<>();
        physical.setColor(Color.RED);
        emotional = new LineGraphSeries<>();
        emotional.setColor(Color.YELLOW);
        intellectual = new LineGraphSeries<>();
        intellectual.setColor(Color.GREEN);

        //for loop to not max more that 500 data points in graph.
        for (int i = 0; i < 500; i++)
        {
            x = x + .000008 ;

            //sets the sin curve for physical value
            double physicalY = (Math.sin((2 * Math.PI*diffTime*x)/23)*100);
            //sets the sin curve for emotional value
            double emotionalY = (Math.sin((2 * Math.PI*diffTime*x)/28)*100);
            //set the intellectual curve for emotional value.
            double intellectualY = (Math.sin((2*Math.PI*diffTime*x)/33)*100);


            physical.appendData(new DataPoint(x ,physicalY), true, 500);
            emotional.appendData(new DataPoint(x ,emotionalY), true, 500);
            intellectual.appendData(new DataPoint(x,intellectualY), true, 500);

        }
        graph.addSeries(physical);
        graph.addSeries(emotional);
        graph.addSeries(intellectual);
        graph.setVisibility(View.VISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent astrology = new Intent(Activity2.this, ActivityAstrology.class);

                astrology.putExtra("Day", getDay);
                astrology.putExtra("Month", getMonth);
                startActivity(astrology);

            }
        });


    }
}
