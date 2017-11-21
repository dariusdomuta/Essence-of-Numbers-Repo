package myapps.essenceofnumbers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import SecondaryActivities.DateActivity;
import SecondaryActivities.MathActivity;
import SecondaryActivities.NumbersActivity;
import SecondaryActivities.YearsActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(MainActivity.this);

        Button datesButton = findViewById(R.id.dates_button);
        datesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DateActivity.class);
                startActivity(intent);
            }
        });

        Button mathButton = findViewById(R.id.math_button);
        mathButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MathActivity.class);
                startActivity(intent);
            }
        });

        Button numbersButton = findViewById(R.id.numbers_button);
        numbersButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(intent);
            }
        });

        Button yearsButton = findViewById(R.id.years_button);
        yearsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, YearsActivity.class);
                startActivity(intent);
            }
        });

    }
}
