package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuizz(View view) {

        EditText addname = findViewById(R.id.addName);

        String name = addname.getText().toString();

        CheckBox checkBox1 = (CheckBox)findViewById(R.id.question1_checkbox_rwanda);
        boolean responseQuestion1Rwanda = checkBox1.isChecked();

        CheckBox checkBox2 = (CheckBox)findViewById(R.id.question2_checkbox_japan);
        boolean responseQuestion2 = checkBox2.isChecked();

        CheckBox checkBox3 = (CheckBox)findViewById(R.id.question3_checkbox1_rwanda);
        boolean responseQuestion3Rw = checkBox3.isChecked();

        CheckBox checkBox4 = (CheckBox)findViewById(R.id.question3_checkbox2_uganda);
        boolean responseQuestion3Ug = checkBox4.isChecked();

        CheckBox checkBox5 = (CheckBox)findViewById(R.id.question3_checkbox3_congo);
        boolean responseQuestion3Cg = checkBox5.isChecked();

        CheckBox checkBox6 = (CheckBox)findViewById(R.id.question4_checkbox2_195);
        boolean responseQuestion4= checkBox6.isChecked();

        CheckBox checkBox7 = (CheckBox)findViewById(R.id.question5_checkbox2_rwanda);
        boolean responseQuestion5= checkBox7.isChecked();

        int totalScore = countingPoints(responseQuestion1Rwanda, responseQuestion2,
                responseQuestion3Rw, responseQuestion3Ug, responseQuestion3Cg,
                responseQuestion4, responseQuestion5)  ;



        String quizScore =  createSummary (name, totalScore);
       // displayMessage(quizScore);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, name + "'s Quiz Score" );
        intent.putExtra(Intent.EXTRA_TEXT, quizScore);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     *
     * @return   the  message with the score and quiz report.
     */

    private String createSummary (String name, int score){

        String pointReport = "Hello " + name + "\n Congratulations on taking the Quiz";

        pointReport += "\n you scored: " + score + " out of 14";

        pointReport += "\n Thank you!!!";


        return pointReport;
    }

    /**
     *
     * this method display the content
     */

    private void displayMessage(String message) {

        TextView orderSummaryTextView = (TextView) findViewById(R.id.quizSummary);

        orderSummaryTextView.setText(message);

    }

    /**
     *
     * count points and add  return score
     * */

 private int countingPoints (boolean responseQuestion1Rwanda, boolean responseQuestion2, boolean responseQuestion3Rw, boolean responseQuestion3Ug, boolean question3Cg, boolean responseQuestion4, boolean response5Question ){

        score = 0;

    if (responseQuestion1Rwanda) {
          score += 2; }

     if (responseQuestion2) {
         score += 2; ;
     }

     if (responseQuestion3Rw){
         score += 2; ;
     }

     if (responseQuestion3Ug){
         score += 2; ;
     }

     if (question3Cg){
         score += 2; ;
     }

     if (responseQuestion4){
         score += 2; ;
     }

     if (response5Question){
         score += 2; ;
     }
        return score;
 }
}
