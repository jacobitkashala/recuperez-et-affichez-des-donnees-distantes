package com.example.recupereafficherdonnedistante.Controllers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recupereafficherdonnedistante.R;
import com.example.recupereafficherdonnedistante.Utils.MyAsyncTask;
import com.example.recupereafficherdonnedistante.Utils.MyAsyncTaskLoader;
import com.example.recupereafficherdonnedistante.Utils.Utils;

public class MainActivity extends AppCompatActivity implements MyAsyncTask.Listeners , LoaderManager.LoaderCallbacks<Long> {
    // private TextView mTextView;
    private ProgressBar progressBar,progressBarCercle;
    private  static int TASK_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.pbProcessing);
        progressBarCercle = findViewById(R.id.progress_bar_cercle);
        // mTextView= findViewById(R.id.activity_main_text_view);

        progressBarCercle.setVisibility(View.GONE);

        //Try to resume possible loading AsyncTask
        this.resumeAsyncTaskLoaderIfPossible();

    }

    // ------------
    // ACTIONS
    // ------------

    public void onClickButton(View v){
        int buttonTag = Integer.valueOf(v.getTag().toString());
        switch (buttonTag){
            case 10: // CASE USER CLICKED ON BUTTON "EXECUTE ACTION IN MAIN THREAD"
               // Utils.executeLongActionDuring7seconds();
                // mTextView.setText("Début de l execution du tâche dans le main principal");
                Long number =Utils.executeLongActionDuring7seconds();
                String stringNumber=  String.valueOf(number);
               //  mTextView.setText(stringNumber);
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
                  this.startAsyncTask();
                break;
            case 70: // CASE USER CLICKED ON BUTTON "EXECUTE ASYNCTASKLOADER"
                this.startAsyncTaskLoader();
                break;
        }
    }
    private void startAsyncTaskLoader(){
        getSupportLoaderManager().restartLoader(TASK_ID,null,this);
    }
    private void resumeAsyncTaskLoaderIfPossible(){
        if (getSupportLoaderManager().getLoader(TASK_ID) != null && getSupportLoaderManager().getLoader(TASK_ID).isStarted()) {
            getSupportLoaderManager().initLoader(TASK_ID, null, this);
            this.updateUiBeforTask();
        }
    }

    @Override
    public void onPreExecute() {
        this.updateUiBeforTask();
    }

    @Override
    public void doInBackground() {

    }

    @Override
    public void onPostExecute(Long success) {
        this.updateUiAfterTask(success);
    }

    private void startAsyncTask(){
        new MyAsyncTask(this).execute();
    }
    public void updateUiBeforTask(){
        progressBarCercle.setVisibility(View.VISIBLE);

    }
    public void updateUiAfterTask(Long taskEnd){
        progressBarCercle.setVisibility(View.GONE);
        Toast.makeText(this,"La tache a pris fin"+taskEnd+".",Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public Loader<Long> onCreateLoader(int id, @Nullable Bundle args) {
        this.updateUiBeforTask();
        return new MyAsyncTaskLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Long> loader, Long data) {
        this.updateUiAfterTask(data);

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Long> loader) {

    }
}