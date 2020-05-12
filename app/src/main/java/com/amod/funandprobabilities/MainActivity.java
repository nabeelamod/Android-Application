package com.amod.funandprobabilities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1,tab2,tab3,tab4,tab5;
    public PageAdapter pageradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tab1 = (TabItem) findViewById(R.id.Tab1);
        tab2 = (TabItem) findViewById(R.id.Tab2);
        tab3 = (TabItem) findViewById(R.id.Tab3);
        tab4 = (TabItem) findViewById(R.id.Tab4);
        tab5 = (TabItem) findViewById(R.id.Tab5);
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
                } else if (tab.getPosition() == 3){
                    pageradapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 4){
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
    int counter = 3;
    public void onClickGoBtn2(View view) throws InterruptedException {
        final TextView rPS = (TextView) findViewById(R.id.rockPaper);
        final ImageView display = (ImageView) findViewById(R.id.imageView2);
        final ImageView display2 = (ImageView) findViewById(R.id.imageView22);
        final TextView hT = (TextView) findViewById(R.id.headsTails);

        rPS.setText("Rock / Paper / Scissors");
        display.setImageResource(R.drawable.question);
        hT.setText("Heads / Tails");
        display2.setImageResource(R.drawable.question);

        Handler handler = new Handler();

        final TextView countDown = (TextView) findViewById(R.id.countDown2);

        new CountDownTimer(3000, 1000){
            public void onTick(long millisUntilFinished){
                countDown.setText(String.valueOf(counter));
                counter--;
            }
            public  void onFinish(){
                countDown.setText("GO!");
            }
        }.start();
        counter = 3;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                randNum = ran.nextInt((3-1)+1)+1;

                if (randNum == 1){
                    rPS.setText("Rock");
                    display.setImageResource(R.drawable.rock);
                } else if (randNum == 2){
                    rPS.setText("Paper");
                    display.setImageResource(R.drawable.paper);
                } else {
                    rPS.setText("Scissors");
                    display.setImageResource(R.drawable.scissors);
                }

                randNum = ran.nextInt((2-1)+1)+1;

                if (randNum == 1){
                    hT.setText("Heads");
                    display2.setImageResource(R.drawable.heads);
                } else {
                    hT.setText("Tails");
                    display2.setImageResource(R.drawable.tails);
                }
            }
        },3000);

    }

    public void onClickRollBtn3(View view) {
        randNum = ran.nextInt((6-1)+1)+1;
        int diceSum = 0;

        TextView sumDice = (TextView) findViewById(R.id.diceSum3);
        ImageView displayDice1 = (ImageView) findViewById(R.id.imageDice1);
        ImageView displayDice2 = (ImageView) findViewById(R.id.imageDice2);

        if (randNum == 1){
            displayDice1.setImageResource(R.drawable.dice1);
            diceSum = 1;
        } else if (randNum == 2){
            displayDice1.setImageResource(R.drawable.dice2);
            diceSum = 2;
        } else if (randNum == 3){
            displayDice1.setImageResource(R.drawable.dice3);
            diceSum = 3;
        } else if (randNum == 4){
            displayDice1.setImageResource(R.drawable.dice4);
            diceSum = 4;
        } else if (randNum == 5){
            displayDice1.setImageResource(R.drawable.dice5);
            diceSum = 5;
        } else if (randNum == 6){
            displayDice1.setImageResource(R.drawable.dice6);
            diceSum = 6;
        }

        randNum = ran.nextInt((6-1)+1)+1;

        if (randNum == 1){
            displayDice2.setImageResource(R.drawable.dice1);
            diceSum = diceSum + 1;
        } else if (randNum == 2){
            displayDice2.setImageResource(R.drawable.dice2);
            diceSum = diceSum + 2;
        } else if (randNum == 3){
            displayDice2.setImageResource(R.drawable.dice3);
            diceSum = diceSum + 3;
        } else if (randNum == 4){
            displayDice2.setImageResource(R.drawable.dice4);
            diceSum = diceSum + 4;
        } else if (randNum == 5){
            displayDice2.setImageResource(R.drawable.dice5);
            diceSum = diceSum + 5;
        } else if (randNum == 6){
            displayDice2.setImageResource(R.drawable.dice6);
            diceSum = diceSum + 6;
        }

        sumDice.setText("Dice Sum: " + diceSum);
    }

    Random rand = new Random();
    int randomLetter;
    int j = 1;

    ArrayList<Integer> array = new ArrayList<Integer>();

    public void onClickStartBtn5(View view) {
        final int[] countdownint = {30};

        TextView letter = (TextView) findViewById(R.id.letter5);
        TextView lettersDone = (TextView) findViewById(R.id.lettersDone);
        final TextView countdown5 = (TextView) findViewById(R.id.countDown5);

        new CountDownTimer(30000, 1000){
            public void onTick(long millisUntilFinished){
                countdown5.setText(String.valueOf(countdownint[0]) + " Seconds Remaining");
                countdownint[0]--;
            }
            public  void onFinish(){
                countdown5.setText("STOP!");
            }
        }.start();

        if (array.size() >= 26)
        {
            j++;
            letter.setText("New Game");
            array.clear();
            lettersDone.setText("(GAME " + j + ") Done:");
        }

        randomLetter = rand.nextInt((26 - 1) + 1) + 1;

        while (array.contains(randomLetter)){
            randomLetter = rand.nextInt((26 - 1) + 1) + 1;
        }
        array.add(randomLetter);

        if (randomLetter == 1){
            letter.setText("A");
            lettersDone.append("A,");
        } else if (randomLetter == 2){
            letter.setText("B");
            lettersDone.append("B,");
        } else if (randomLetter == 3) {
            letter.setText("C");
            lettersDone.append("C,");
        } else if (randomLetter == 4){
            letter.setText("D");
            lettersDone.append("D,");
        } else if (randomLetter == 5){
            letter.setText("E");
            lettersDone.append("E,");
        } else if (randomLetter == 6){
            letter.setText("F");
            lettersDone.append("F,");
        } else if (randomLetter == 7){
            letter.setText("G");
            lettersDone.append("G,");
        } else if (randomLetter == 8){
            letter.setText("H");
            lettersDone.append("H,");
        } else if (randomLetter == 9){
            letter.setText("I");
            lettersDone.append("I,");
        } else if (randomLetter == 10){
            letter.setText("J");
            lettersDone.append("J,");
        } else if (randomLetter == 11){
            letter.setText("K");
            lettersDone.append("K,");
        } else if (randomLetter == 12){
            letter.setText("L");
            lettersDone.append("L,");
        } else if (randomLetter == 13){
            letter.setText("M");
            lettersDone.append("M,");
        } else if (randomLetter == 14){
            letter.setText("N");
            lettersDone.append("N,");
        } else if (randomLetter == 15){
            letter.setText("O");
            lettersDone.append("O,");
        } else if (randomLetter == 16){
            letter.setText("P");
            lettersDone.append("P,");
        } else if (randomLetter == 17){
            letter.setText("Q");
            lettersDone.append("Q,");
        } else if (randomLetter == 18){
            letter.setText("R");
            lettersDone.append("R,");
        } else if (randomLetter == 19){
            letter.setText("S");
            lettersDone.append("S,");
        } else if (randomLetter == 20){
            letter.setText("T");
            lettersDone.append("T,");
        } else if (randomLetter == 21){
            letter.setText("U");
            lettersDone.append("U,");
        } else if (randomLetter == 22){
            letter.setText("V");
            lettersDone.append("V,");
        } else if (randomLetter == 23){
            letter.setText("W");
            lettersDone.append("W,");
        } else if (randomLetter == 24){
            letter.setText("X");
            lettersDone.append("X,");
        } else if (randomLetter == 25){
            letter.setText("Y");
            lettersDone.append("Y,");
        } else if (randomLetter == 26){
            letter.setText("Z");
            lettersDone.append("Z,");
        }

    }

    public void onClickCheckBtn4(View view) {
        TextView palOutput = (TextView) findViewById(R.id.outputPal);
        EditText pal = (EditText) findViewById(R.id.userPalInput);

        String palindrome = pal.getText().toString();

        String spacelessString = palindrome.replaceAll("\\s+", "").toLowerCase();

        int length = spacelessString.length();
        int front = 0;
        int end = length - 1;

        palOutput.setText("YES");
        while (end > front)
        {
            char firstChar = spacelessString.charAt(front++);
            char lastChar = spacelessString.charAt(end--);
            if (firstChar != lastChar)
                palOutput.setText("NO");
        }

    }

}
