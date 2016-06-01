package vuchris.tacoma.uw.edu.homepagev3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class HardLevel extends ActionBarActivity {

    String mWord ;
    int mFailCounter = 0;
    int mGuessedLetters = 0;
    int mPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level);
        setRandomWord();
    }

    public void introduceLetter(View v){

        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);

        String letter = myEditText.getText().toString();

        myEditText.setText("");

        Log.d("MYLOG", "The letter is " + letter);

        if(letter.length() > 0) {
            checkLetter(letter.toUpperCase());
        }else{
            Toast.makeText(this,"Please introduce a letter",Toast.LENGTH_SHORT).show();
        }

    }

    public void checkLetter(String introducedLetter){

        char charIntroduced = introducedLetter.charAt(0);

        Boolean letterGuessed = false;

        for( int i =0 ; i < mWord.length() ; i++){

            char charFromTheWord = mWord.charAt(i);

            if (charFromTheWord == charIntroduced){

                Log.d("MYLOG","There was one match");

                letterGuessed = true;

                showLettersAtIndex(i,charIntroduced);

                mGuessedLetters++;
                mPoints++;

            }
        }
        if (letterGuessed == false){
            letterFailed(Character.toString(charIntroduced));

        }

        if (mGuessedLetters == mWord.length()){
            letterPassed();
            mPoints++;
            clearScreen();
            setRandomWord();
        }
    }

    public void setRandomWord(){

        String words ="BLACK CRAZY TABLE SHIPS PIZZA QUICK JUICY QUIRK CHUCK JOKER";

        String[] arrayWords = words.split(" ");

        int randomNumber = (int) ( Math.random() * arrayWords.length);

        String randomWord = arrayWords[randomNumber];

        mWord = randomWord;

    }

    public void clearScreen() {
        TextView textViewFailed = (TextView) findViewById(R.id.textView6);
        textViewFailed.setText("");

        mGuessedLetters = 0;
        mFailCounter = 0;

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.LayoutLetters);

        for (int i=0; i < layoutLetters.getChildCount() ; i++ ){

            TextView currentTextView = (TextView) layoutLetters.getChildAt(i);
            currentTextView.setText("_");

        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.stage1_hangman);
    }

    public void letterFailed(String letterFailed){

        TextView textViewFailed = (TextView) findViewById(R.id.textView6);
        String previousFail = textViewFailed.getText().toString();
        textViewFailed.setText(previousFail+letterFailed);

        mFailCounter++;
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        if(mFailCounter == 1){
            imageView.setImageResource(R.drawable.stage2_hangman);
        }else if (mFailCounter == 2){
            imageView.setImageResource(R.drawable.stage3_hangman);
        }else if (mFailCounter == 3){
            imageView.setImageResource(R.drawable.stage4_hangman);
        }else if (mFailCounter == 4){
            imageView.setImageResource(R.drawable.stage5_hangman);
        }else if (mFailCounter == 5){
            imageView.setImageResource(R.drawable.stage6_hangman);
        }else if (mFailCounter == 6) {
            imageView.setImageResource(R.drawable.stage7_hangman);


            Intent gameOverIntent = new Intent(this,GameOverActivity.class);

            gameOverIntent.putExtra("POINTS_IDENTIFIER",mPoints);

            startActivity(gameOverIntent);

            finish();
        }
    }
    public void letterPassed(){
        Intent winner = new Intent(this,WinActivity.class);
        winner.putExtra("POINTS_IDENTIFIER",(mPoints-mFailCounter));
        startActivity(winner);
        finish();
    }

    public void showLettersAtIndex(int position, char letterGuessed){

        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.LayoutLetters);

        TextView textView = (TextView) layoutLetter.getChildAt(position);

        textView.setText(Character.toString(letterGuessed));

    }
}
