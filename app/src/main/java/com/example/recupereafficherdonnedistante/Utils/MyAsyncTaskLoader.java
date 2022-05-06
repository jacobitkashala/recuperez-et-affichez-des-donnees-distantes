package com.example.recupereafficherdonnedistante.Utils;

import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

public class MyAsyncTaskLoader extends AsyncTaskLoader<Long> {
    public MyAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public Long loadInBackground() {
        return Utils.executeLongActionDuring7seconds();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
