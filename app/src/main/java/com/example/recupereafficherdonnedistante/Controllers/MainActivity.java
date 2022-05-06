package com.example.recupereafficherdonnedistante.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.recupereafficherdonnedistante.R;
import com.example.recupereafficherdonnedistante.Utils.MyAsyncTask;
import com.example.recupereafficherdonnedistante.Utils.Utils;

public class MainActivity extends AppCompatActivity implements MyAsyncTask.Listeners {
    private TextView mTextView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar =findViewById(R.id.pbProcessing);
        mTextView= findViewById(R.id.activity_main_text_view);

    }

    // ------------
    // ACTIONS
    // ------------

    public void onClickButton(View v){
        int buttonTag = Integer.valueOf(v.getTag().toString());
        switch (buttonTag){
            case 10: // CASE USER CLICKED ON BUTTON "EXECUTE ACTION IN MAIN THREAD"
               // Utils.executeLongActionDuring7seconds();
                mTextView.setText("Début de l execution du tâche dans le main principal");
                Long number =Utils.executeLongActionDuring7seconds();
                String stringNumber=  String.valueOf(number);
                mTextView.setText(stringNumber);
                break;
            case 20: // CASE USER CLICKED ON BUTTON "EXECUTE ACTION IN BACKGROUND"
                // this.startHandlerThread();
                break;
            case 30: // CASE USER CLICKED ON BUTTON "START ALARM"
                // this.startAlarm();
                break;
            case 40: // CASE USER CLICKED ON BUTTON "STOP ALARM"
                // this.stopAlarm();
                break;
            case 50: // CASE USER CLICKED ON BUTTON "EXECUTE JOB SCHEDULER"
                // this.startJobScheduler();
                break;
            case 60: // CASE USER CLICKED ON BUTTON "EXECUTE ASYNCTASK"
                //  this.startAsyncTask();
                break;
            case 70: // CASE USER CLICKED ON BUTTON "EXECUTE ASYNCTASKLOADER"
                // this.startAsyncTaskLoader();
                break;
        }
    }


    @Override
    public void onPreExecute() {

    }

    @Override
    public void doInBackground() {

    }

    @Override
    public void onPostExecute(Long success) {

    }
}