package SecondaryActivities;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.app.LoaderManager.LoaderCallbacks;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import Loaders.LoaderAsync;
import myapps.essenceofnumbers.MainActivity;
import myapps.essenceofnumbers.R;




/**
 * Created by dariu on 11/22/2017.
 */

public class ResultActivity extends AppCompatActivity implements LoaderCallbacks<String>{

    public static final String LOG_TAG = ResultActivity.class.getName();
    public static final String BASE_URL = "http:/numbersapi.com/";
    private static final int EARTHQUAKE_LOADER_ID = 1;
    private static final String URL = "http:/numbersapi.com/42/trivia";

    private String senderActivity;
    private String isRandom;
    private String input;
    private String stringUrl;

    @Override
    public Loader<String> onCreateLoader(int i, Bundle bundle) {
        return new LoaderAsync(this, stringUrl);


    }

    @Override
    public void onLoadFinished(Loader<String> loader, String result) {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        TextView resultTextView = findViewById(R.id.result_fact);
        resultTextView.setText(result);

        TextView resultNumberTextView = findViewById(R.id.result_number);
        resultNumberTextView.setText(input);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent=this.getIntent();
        if (intent != null){
            String[] passedData = intent.getExtras().getStringArray(MainActivity.EXTRA_DATA_FOR_INTENT);
            senderActivity = passedData[0];
            isRandom = passedData[1];
            input = passedData[2];



            if (isRandom.equals("no")) {
                stringUrl = BASE_URL + input + "/" + senderActivity;
            } else {
                stringUrl = BASE_URL + "random/" + senderActivity;
            }
        }

        Button resetButton = (Button) findViewById(R.id.reset_button);
        Button tryAnotherOneButton = (Button) findViewById(R.id.another_one_button);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        tryAnotherOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (senderActivity.equals("trivia")) {
                        Intent intent = new Intent(ResultActivity.this, NumbersActivity.class);
                        startActivity(intent);
                    } else if (senderActivity.equals("year")) {
                        Intent intent = new Intent(ResultActivity.this, YearsActivity.class);
                        startActivity(intent);
                    } else if (senderActivity.equals("date")) {
                        Intent intent = new Intent(ResultActivity.this, DateActivity.class);
                        startActivity(intent);
                    } else if (senderActivity.equals("math")) {
                        Intent intent = new Intent(ResultActivity.this, MathActivity.class);
                        startActivity(intent);
                    }
            }
        });

        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);


    }
}
