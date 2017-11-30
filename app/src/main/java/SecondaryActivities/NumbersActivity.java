package SecondaryActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import myapps.essenceofnumbers.MainActivity;
import myapps.essenceofnumbers.R;

public class NumbersActivity extends AppCompatActivity {

    public static final String LOG_TAG = NumbersActivity.class.getName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        Button goButton = findViewById(R.id.go_button);
        Button randomizeButton = findViewById(R.id.randomize_button);
        final EditText inputEditText = findViewById(R.id.numbers_edit);

        goButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(NumbersActivity.this, ResultActivity.class);
                final String inputString = inputEditText.getText().toString();
                if (inputString.equals("")) {
                    Toast.makeText(NumbersActivity.this, "Cannot show results without an input", Toast.LENGTH_LONG).show();
                } else
                {
                    intent.putExtra(MainActivity.EXTRA_DATA_FOR_INTENT, new String[] {"trivia", "no", inputString});
                    startActivity(intent);
                }

            }
        });


        randomizeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(NumbersActivity.this, ResultActivity.class);
                final String inputString = inputEditText.getText().toString();
                intent.putExtra(MainActivity.EXTRA_DATA_FOR_INTENT, new String[] {"trivia", "yes", ""});
                startActivity(intent);
            }
        });

    }
}