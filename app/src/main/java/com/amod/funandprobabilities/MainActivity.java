package com.amod.funandprobabilities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1,tab2,tab3;
    public PageAdapter pageradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tab1 = (TabItem) findViewById(R.id.Tab1);
        tab2 = (TabItem) findViewById(R.id.Tab2);
        tab3 = (TabItem) findViewById(R.id.Tab3);
        viewPager = findViewById(R.id.viewpager);

        pageradapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageradapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 0){
                    pageradapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 1){
                    pageradapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 2){
                    pageradapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    Random ran = new Random();
    int randNum;
    int min,max;
    int userScore1 = 0;

    public void onClickStartBtn1(View view) {
        max = 10;
        min = 1;

        EditText temp = (EditText) findViewById(R.id.userMaxInput);
        String temp1 = temp.getText().toString();

        if (!"".equals(temp)){
            max = Integer.parseInt(temp1);
        }

        randNum = ran.nextInt((max-min)+1)+min;
        TextView text = (TextView) findViewById(R.id.output1);
        text.setText("Number Generated! Enter Your Guess Below!");
    }

    public void onClickGuessBtn1(View view) {
        TextView guesses1 = (TextView) findViewById(R.id.outputGuesses);

        int userGuessInputInt = 0;

        EditText temp = (EditText) findViewById(R.id.userGuess1);
        String temp1 = temp.getText().toString();

        if (!"".equals(temp)){
            userGuessInputInt = Integer.parseInt(temp1);
        }

        TextView userGuess = (TextView) findViewById(R.id.outputGuess);
        guesses1.append(temp1 + ",");
        if (userGuessInputInt > randNum)
        {
            userGuess.setText("Lower");
        } else if (userGuessInputInt < randNum){
            userGuess.setText("Higher");
        } else {
            userGuess.setText("Correct");
            randNum = ran.nextInt((max-min)+1)+min;

            TextView score1 = (TextView) findViewById(R.id.score1);
            userScore1++;
            score1.setText("Score:" + userScore1);
            guesses1.setText("Already Guessed: None");
        }
    }
}
