package com.example.android.courtcounter;

import android.content.Context;
import android.media.Image;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import org.w3c.dom.Text;

import static android.R.attr.name;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.android.courtcounter.R.id.edit_team_b;
import static com.example.android.courtcounter.R.id.play_button;
import static com.example.android.courtcounter.R.id.team_a_name;
import static com.example.android.courtcounter.R.id.team_b_name;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));

        final boolean[] three_flag = {false};
        final boolean[] two_flag = {false};
        final boolean[] one_flag = {false};

        final LinearLayout name_layout = (LinearLayout)findViewById(R.id.name_layout);
        final LinearLayout team_buttons = (LinearLayout) findViewById(R.id.team_buttons);

        //TEAM A NAME TEXT VIEW
        final TextView team_a_name = (TextView) findViewById(R.id.team_a_name);

        //TEAM A EDIT VIEW
        final EditText edit_team_a = (EditText) findViewById(R.id.edit_team_a);

        //TEAM B EDIT VIEW
        final EditText edit_team_b = (EditText) findViewById(R.id.edit_team_b);

        //TEAM B  NAME TEXT VIEW
        final TextView team_b_name = (TextView) findViewById(R.id.team_b_name);

        //TEAM BUTTONS
        final Button team_a_add = (Button) findViewById(R.id.team_a_add);
        final Button team_b_add = (Button) findViewById(R.id.team_b_add);

        //POINTS BUTTONS
        final Button three_points = (Button) findViewById(R.id.three_points);
        final Button two_points = (Button) findViewById(R.id.two_points);
        final Button one_point = (Button) findViewById(R.id.one_point);

        //TEAM A SCORE TEXT VIEW
        final TextView team_a_score = (TextView) findViewById(R.id.team_a_score);

        //TEAM B SCORE TEXT VIEW
        final TextView team_b_score = (TextView) findViewById(R.id.team_b_score);

        //PLAY,RESET,END GAME BUTTONS
        Button play_button = (Button) findViewById(R.id.play_button);
        Button reset_button = (Button) findViewById(R.id.reset_button);
        Button end_game_button = (Button) findViewById(R.id.end_game_button);

        //COMMENTARY TEXT VIEWS
        final TextView commentary_one = (TextView) findViewById(R.id.commentary_one);
        final TextView commentary_two = (TextView) findViewById(R.id.commentary_two);

        //TET INPUT LAYOUTS OF BOTH TEAMS
        final TextInputLayout container_team_a = (TextInputLayout) findViewById(R.id.container_team_a);
        final TextInputLayout container_team_b = (TextInputLayout) findViewById(R.id.container_team_b);
        //ON CLICK LISTENER FOR THREE POINTS BUTTON
        three_points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(team_buttons.getVisibility() == View.VISIBLE)
                    team_buttons.setVisibility(GONE);
                else
                    team_buttons.setVisibility(VISIBLE);
                three_flag[0] = true;
            }
        });

        //ON CLICK LISTENER FOR TWO POINTS BUTTON
        two_points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(team_buttons.getVisibility() == View.VISIBLE)
                    team_buttons.setVisibility(GONE);
                else
                    team_buttons.setVisibility(VISIBLE);
                two_flag[0] = true;
            }
        });

        //ON CLICK LISTENER FOR ONE POINT BUTTON
        one_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(team_buttons.getVisibility() == View.VISIBLE)
                    team_buttons.setVisibility(GONE);
                else
                    team_buttons.setVisibility(VISIBLE);
                one_flag[0] = true;
            }
        });

        //ON CLICK LISTENER FOR TEAM A ADD BUTTON
        team_a_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(three_flag[0])
                {
                    three_flag[0] = false;
                    int score = Integer.parseInt(team_a_score.getText().toString());
                    String message_two = commentary_one.getText().toString();
                    String message_one = team_a_name.getText().toString() + " scored 3 Points!!";
                    commentary_one.setText(message_one);
                    commentary_two.setText(message_two);
                    score = score + 3;
                    team_a_score.setText(Integer.toString(score));
                }
                else if(two_flag[0])
                {
                    two_flag[0] = false;
                    String message_two = commentary_one.getText().toString();
                    String message_one = team_a_name.getText().toString() + " scored 2 Points!!";
                    commentary_one.setText(message_one);
                    commentary_two.setText(message_two);
                    int score = Integer.parseInt(team_a_score.getText().toString());
                    score = score + 2;
                    team_a_score.setText(Integer.toString(score));
                }
                else
                {
                    one_flag[0] = false;
                    String message_two = commentary_one.getText().toString();
                    String message_one = team_a_name.getText().toString() + " scored 1 Point!!";
                    commentary_one.setText(message_one);
                    commentary_two.setText(message_two);
                    int score = Integer.parseInt(team_a_score.getText().toString());
                    score = score + 1;
                    team_a_score.setText(Integer.toString(score));
                }
                team_buttons.setVisibility(GONE);
            }
        });

        //ON CLICK LISTENER FOR TEAM B ADD BUTTON
        team_b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(three_flag[0])
                {
                    three_flag[0] = false;
                    String message_two = commentary_one.getText().toString();
                    String message_one = team_b_name.getText().toString() + " scored 3 Points!!";
                    commentary_one.setText(message_one);
                    commentary_two.setText(message_two);
                    int score = Integer.parseInt(team_b_score.getText().toString());
                    score = score + 3;
                    team_b_score.setText(Integer.toString(score));
                }
                else if(two_flag[0])
                {
                    two_flag[0] = false;
                    String message_two = commentary_one.getText().toString();
                    String message_one = team_b_name.getText().toString() + " scored 2 Points!!";
                    commentary_one.setText(message_one);
                    commentary_two.setText(message_two);
                    int score = Integer.parseInt(team_b_score.getText().toString());
                    score = score + 2;
                    team_b_score.setText(Integer.toString(score));
                }
                else
                {
                    one_flag[0] = false;
                    String message_two = commentary_one.getText().toString();
                    String message_one = team_b_name.getText().toString() + " scored 1 Point!!";
                    commentary_one.setText(message_one);
                    commentary_two.setText(message_two);
                    int score = Integer.parseInt(team_b_score.getText().toString());
                    score = score + 1;
                    team_b_score.setText(Integer.toString(score));
                }
                team_buttons.setVisibility(GONE);
            }
        });

        team_buttons.setVisibility(GONE);

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = "This field cannot be empty!";
                String maxLength = "Maximum 10 letters allowed!";
                String name_a = edit_team_a.getText().toString();
                String name_b = edit_team_b.getText().toString();
                if (name_a.isEmpty() || name_a.length()>10)
                {
                    container_team_a.setErrorEnabled(true);
                    if(name_a.length()>10)
                        container_team_a.setError(maxLength);
                    else
                        container_team_a.setError(error);
                }
                else
                {
                    container_team_a.setErrorEnabled(false);
                    team_a_name.setText(name_a);
                    team_a_add.setText(name_a);
                }
                if(name_b.isEmpty() || name_b.length()>10)
                {
                    container_team_b.setErrorEnabled(true);
                    if(name_b.length()>10)
                        container_team_b.setError(maxLength);
                    else
                        container_team_b.setError(error);
                }
                else
                {
                    container_team_b.setErrorEnabled(false);
                    team_b_name.setText(name_b);
                    team_b_add.setText(name_b);

                }

                if(getCurrentFocus()!=null)
                {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }

            }
        });
        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_layout.setVisibility(VISIBLE);
                team_a_name.setText("Team A");
                team_b_name.setText("Team B");
                edit_team_a.setText("");
                edit_team_b.setText("");
                team_a_score.setText("0");
                team_b_score.setText("0");
                team_a_add.setText("TEAM A");
                team_b_add.setText("TEAM B");
                commentary_one.setText("");
                commentary_two.setText("");
                container_team_a.setErrorEnabled(false);
                container_team_b.setErrorEnabled(false);
            }
        });

        end_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score_team_a = Integer.parseInt(team_a_score.getText().toString());
                int score_team_b = Integer.parseInt(team_b_score.getText().toString());
                if(score_team_a == 0 && score_team_b == 0)
                {
                    //DO NOTHING
                }
                else if(score_team_a > score_team_b)
                {
                    String message = team_a_name.getText() + " won the match!";
                    commentary_one.setText(message);

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage(message).create().show();
                }
                else
                {
                    String message = team_b_name.getText() + " won the match!";
                    commentary_one.setText(message);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage(message).create().show();
                }
            }
        });

    }
}
