package com.example.lab2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Weapon pChoice;
    private Weapon cChoice;
    private int winCountP;
    private int winCountC;
    private TextView winCountView;
    private TextView weaponChoiceView;
    private TextView winnerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        winCountView = findViewById(R.id.winCountView);
        weaponChoiceView = findViewById(R.id.weaponChoiceView);
        winnerView = findViewById(R.id.winnerView);
    }

    public void btnRockClicked(View v){
        pChoice = Weapon.ROCK;
        winner(pChoice);

    }

    public void btnPaperClicked(View v){
        pChoice = Weapon.PAPER;
        winner(pChoice);

    }
    public void btnScissorsClicked(View v){
        pChoice = Weapon.SCISSORS;
        winner(pChoice);

    }

    private void rndComputerChoice(){
        Random rand = new Random();
        int random = 1 + rand.nextInt(3);

        switch(random) {
            case 1:
                cChoice = Weapon.ROCK;
                break;
            case 2:
                cChoice = Weapon.PAPER;
                break;
            case 3:
                cChoice = Weapon.SCISSORS;
                break;
            default:
                cChoice = Weapon.PAPER;
                break;
        }


    }

    private void winner(Weapon pChoice){
        //calling rndComputerChoice
        rndComputerChoice();

        switch(pChoice){
            //Rock is Weapon so we can use it
            case ROCK:
                if(cChoice == Weapon.ROCK){
                    winnerView.setText("Tie");
                }
                else if(cChoice == Weapon.PAPER){
                    winnerView.setText("Computer Wins");
                    winCountC++;
                }
                else if(cChoice == Weapon.SCISSORS){
                    winnerView.setText("Players Wins");
                    winCountP++;
                }
                break;
            case PAPER:
                if(cChoice == Weapon.PAPER){
                    winnerView.setText("Tie");
                }
                else if(cChoice == Weapon.ROCK){
                    winnerView.setText("Player wins");
                    winCountP++;
                }
                else if(cChoice == Weapon.SCISSORS){
                    winnerView.setText("Computer Wins");
                    winCountC++;
                }
                break;

            default:
                if(cChoice == Weapon.SCISSORS){
                    winnerView.setText("Tie");
                }
                else if(cChoice == Weapon.ROCK){
                    winnerView.setText("Player wins");
                    winCountP++;
                }
                else if(cChoice == Weapon.PAPER){
                    winnerView.setText("Computer wins");
                    winCountC++;
                }
                break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Player: " );sb.append(winCountP);sb.append(" Computer: ");sb.append(winCountC);
        winCountView.setText(sb.toString());

        StringBuilder weapon = new StringBuilder();
        sb.append("Player Weapon: ");sb.append(pChoice);sb.append("Computer Weapon: ");sb.append(cChoice);
        weaponChoiceView.setText(weapon.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");

        private String message;

        Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

    };
}
