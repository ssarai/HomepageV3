package vuchris.tacoma.uw.edu.homepagev3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity2 extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        Button easyButton = (Button) findViewById(R.id.easy_button);
        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity2.this, EasyLevel.class);
                startActivity(intent);
            }
        });

        Button medButton = (Button) findViewById(R.id.medium_button);
        medButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity2.this, MediumLevel.class);
                startActivity(intent);
            }
        });
        Button hardButton = (Button) findViewById(R.id.hard_button);
        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity2.this, HardLevel.class);
                startActivity(intent);
            }
        });
        Button scoreButton = (Button) findViewById(R.id.score_button);
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity2.this, ScoresActivity.class);
                startActivity(intent);
            }
        });

    }
}
