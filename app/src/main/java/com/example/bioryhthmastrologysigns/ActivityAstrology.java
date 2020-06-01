package com.example.bioryhthmastrologysigns;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityAstrology extends AppCompatActivity
{
    TextView tvAstrology;
    MediaPlayer mySong;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astrology);

        //sets the textView to display when needed
        tvAstrology = findViewById(R.id.tvAstrologySigns);

        //calls the months and day from MainActivity
        int getnewMonth = getIntent().getExtras().getInt("Month");
        int getnewDay = getIntent().getExtras().getInt("Day");

        //sets astrological signs from user input in MainActivity
        if ((getnewDay >= 20 && getnewMonth == 1)||(getnewDay <= 18 && getnewMonth == 2))
        {
            tvAstrology.setText("Hello User! your Western Zodiac is Aquarius (January 20 - February 18)..." +
                                "Aquarians are the true star children of the Zodiac. "+ "\n" +
                                "Those born under the Aquirius sign are the consumate " + "\n" +
                                "forware thinking dreamers and doers.");


        }
        else if ((getnewDay >= 19 && getnewMonth == 2) || (getnewDay <= 20 && getnewMonth == 3))
        {
            tvAstrology.setText(  "Hello, your Western Zodiac is Pisces (February 19 - March 20)"+
            "\nPisces are delicate, sensetive, and ethereal, those"+
            "\nborn under the zodiac sign of Pisces are the"+
            "\ngossamer souls who teach our world how to love"+
            "\nunconditionally.");
        }
        else if ((getnewDay >= 21 && getnewMonth == 3) || (getnewDay <= 19 && getnewMonth == 4))
        {
            tvAstrology.setText( "Hello, your Western Zodiac is Aries (March 21 - April 19)"+
            "\nThe Aries will stride into places where no one else"+
            "\ndares to go. They are strong and courageous.");
        }
        else if ((getnewDay >= 21 && getnewMonth == 4) || (getnewDay <= 20 && getnewMonth == 5))
        {
            tvAstrology.setText( "Hello, your Western Zodiac is Taurus (April 21 - May 20)"+
                    "\nThe Taurus know for being reliable, practical,"+
                    "\nambitious and sensua.");
        }
        else if ((getnewDay >= 21 && getnewMonth == 5) || (getnewDay <= 20 && getnewMonth == 6))
        {
            tvAstrology.setText( "Hello, your Western Zodiac is Gemini (May 21 - June 20)"+
                    "\nExpressive and quick-witted, Gemini represents two different"+
                    "\ndpersonalities in one and you will never be sure which one you will face." +
                    "\nThey are sociable, communicative and ready for fun.");
        }
        else if ((getnewDay >= 21 && getnewMonth == 6) || (getnewDay <= 20 && getnewMonth == 7))
        {
            tvAstrology.setText( "Hello, your Western Zodiac is Cancer (June 21 - July 20)"+
                    "\nYou are Deeply intuitive and sentimental.");
        }
        else if ((getnewDay >= 21 && getnewMonth == 7) || (getnewDay <= 21 && getnewMonth == 8))
        {
            tvAstrology.setText( "Hello, your Western Zodiac is Leo (July 21 - August 21)"+
                    "\nWarm, action-oriented and driven by the desire to be loved"+
                    "\nand admired.");
        }
        else if ((getnewDay >= 22 && getnewMonth == 8) || (getnewDay <= 22 && getnewMonth == 9))
        {
            tvAstrology.setText( "Hello, your Western Zodiac is Virgo (August 22 - September 22)"+
                    "\nA Virgo personality is a mix of intelligence, attention to"+
                    "\ndetail, common sense, and commitment.");
        }
        else if ((getnewDay >= 23 && getnewMonth == 9) || (getnewDay <= 22 && getnewMonth == 10))
        {
            tvAstrology.setText( "Hello, your Western Zodiac is Libra (September 23 - October 22)"+
                    "\nA Libra is peaceful and loving but also moody, stubborn"+
                    "\nand indecisive.");
        }
        else if ((getnewDay >= 23 && getnewMonth == 10) || (getnewDay <= 22 && getnewMonth == 11))
        {
            tvAstrology.setText( "Hello, your Western Zodiac is Scorpio (October 23 - November 22)"+
                    "\nThe Scorpio-born are strong willed and mysterious, and"+
                    "\nthey know how to effortlessly grab the limelight, as they" +
                    "\npossess what it takes to achieve their goals.");
        }
        else if ((getnewDay >= 23 && getnewMonth == 11) || (getnewDay <= 20 && getnewMonth == 12))
        {
            tvAstrology.setText( "Hello, your Western Zodiac is Sagittarius (November 23 - December 20)"+
                    "\nCurious and energetic, Sagittarius is one of the biggest"+
                    "\ntravelers among all zodiac signs. Their open mind and" +
                    "\nphilosophical view motivates them to wander around the" +
                    "\nworld in search of the meaning of life.");
        }
        else if ((getnewDay >= 21 && getnewMonth == 12) || (getnewDay <= 19 && getnewMonth == 1))
        {
            tvAstrology.setText( "Hello, your Western Zodiac is Capricorn (December 21 - January 19)"+
                    "\nThe Capricorn-born people are the most determined of the"+
                    "\nentire Zodiac. The most prominent qualities of the Goats, " +
                    "\nas they are called, are that they are ambitious, conservative," +
                    "\ndetermined, practical and helpful.");
        }



}}
