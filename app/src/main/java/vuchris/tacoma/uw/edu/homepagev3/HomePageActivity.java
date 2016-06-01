package vuchris.tacoma.uw.edu.homepagev3;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button game = (Button) findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, GameActivity2.class);
                startActivity(intent);
            }
        });

//        Button invite = (Button) findViewById(R.id.invite_button);
//        invite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomePageActivity.this, InviteActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    //when user clicks the button, signin or register dialog pops up
    public void launch(View v) {
        DialogFragment fragment = null;
        if (v.getId() == R.id.instructions) {
            fragment = new InstructionsFragment();
        }
        else if(v.getId() == R.id.invite_button){
            Intent inviteIntent = new Intent(this, InviteActivity.class);
            startActivity(inviteIntent);
        }

        //show
        if (fragment != null) {
            fragment.show(getSupportFragmentManager(), "launch");
        }
    }
}
