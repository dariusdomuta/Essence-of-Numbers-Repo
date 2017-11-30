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

public class DateActivity extends AppCompatActivity {

    public static final String LOG_TAG = NumbersActivity.class.getName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        Button goButton = findViewById(R.id.go_button);
        Button randomizeButton = findViewById(R.id.randomize_button);
        final EditText inputMonthEditText = findViewById(R.id.month_edit);
        final EditText inputDayEditText = findViewById(R.id.day_edit);

        goButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DateActivity.this, ResultActivity.class);
                final String inputMonthString = inputMonthEditText.getText().toString();
                final String inputDayString = inputDayEditText.getText().toString();
                if ((inputMonthString.equals("")) || (inputDayString.equals(""))) {
                    Toast.makeText(DateActivity.this, "Cannot show results without an input", Toast.LENGTH_LONG).show();
                } else {
                    final String inputString = inputMonthString + "/" + inputDayString;
                    intent.putExtra(MainActivity.EXTRA_DATA_FOR_INTENT, new String[] {"date", "no", inputString});
                    startActivity(intent);
                }

            }
        });


        randomizeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DateActivity.this, ResultActivity.class);
                final String inputMonthString = inputMonthEditText.getText().toString();
                final String inputDayString = inputDayEditText.getText().toString();
                final String inputString = inputMonthString + "/" + inputDayString;
                intent.putExtra(MainActivity.EXTRA_DATA_FOR_INTENT, new String[] {"date", "yes", ""});
                startActivity(intent);
            }
        });

    }
}