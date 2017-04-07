package com.example.user.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Member class attributes to use for memory
    private int mScoreTeamA = 0;
    private int mScoreTeamB = 0;
    private int mFoulTeamA = 0;
    private int mFoulTeamB = 0;

    // Constants for Saved Instance State
    private static final String SCORE_TEAM_A = "scoreTeamA";
    private static final String SCORE_TEAM_B = "scoreTeamB";
    private static final String FOUL_TEAM_A = "foulTeamA";
    private static final String FOUL_TEAM_B = "foulTeamB";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore state
            mScoreTeamA = savedInstanceState.getInt(SCORE_TEAM_A);
            mScoreTeamB = savedInstanceState.getInt(SCORE_TEAM_B);
            mFoulTeamA = savedInstanceState.getInt(FOUL_TEAM_A);
            mFoulTeamB = savedInstanceState.getInt(FOUL_TEAM_B);
        }

        setContentView(R.layout.activity_main);
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save the current state

        savedInstanceState.putInt(SCORE_TEAM_A, mScoreTeamA);
        savedInstanceState.putInt(SCORE_TEAM_B, mScoreTeamB);
        savedInstanceState.putInt(FOUL_TEAM_A, mFoulTeamA);
        savedInstanceState.putInt(FOUL_TEAM_B, mFoulTeamB);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);

    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);


    // Restore state members from saved instance
    // Restore the data you saved using the key you used to store it with.
    // put that in scoreTeamA variable.
        mScoreTeamA = savedInstanceState.getInt(SCORE_TEAM_A);
        mScoreTeamB = savedInstanceState.getInt(SCORE_TEAM_B);
        mFoulTeamA = savedInstanceState.getInt(FOUL_TEAM_A);
        mFoulTeamB = savedInstanceState.getInt(FOUL_TEAM_B);
        // redisplay the score
        displayScoreForTeamA(mScoreTeamA);
        displayScoreForTeamB(mScoreTeamB);
        displayFoulForTeamA(mFoulTeamA);
        displayFoulForTeamB(mFoulTeamB);

        super.onRestoreInstanceState(savedInstanceState);

    }

    /* Team A */
    public void addGoalTeamA(View view) {
        mScoreTeamA = mScoreTeamA + 1;
        displayScoreForTeamA(mScoreTeamA);
    }

    public void addFoulTeamA(View view) {
        mFoulTeamA = mFoulTeamA + 1;
        displayFoulForTeamA(mFoulTeamA);
    }

    /* Team B */
    public void addGoalTeamB(View view) {
        mScoreTeamB = mScoreTeamB + 1;
        displayScoreForTeamB(mScoreTeamB);
    }

    public void addFoulTeamB(View view) {
        mFoulTeamB = mFoulTeamB + 1;
        displayFoulForTeamB(mFoulTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given foul for Team A.
     */
    public void displayFoulForTeamA(int foul) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_foul);
        scoreView.setText(String.valueOf(foul));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given foul for Team A.
     */
    public void displayFoulForTeamB(int foul) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_foul);
        scoreView.setText(String.valueOf(foul));
    }

    /* Reset all */
    public void resetScore(View view){
        mScoreTeamA = mScoreTeamB = 0;
        mFoulTeamA = mFoulTeamB = 0;
        displayScoreForTeamA(mScoreTeamA);
        displayFoulForTeamA(mFoulTeamA);
        displayScoreForTeamB(mScoreTeamB);
        displayFoulForTeamB(mFoulTeamA);
    }

}
