package com.example.lab10;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

public class SonguuliTask extends Task<ObservableList<Integer>>{

    private int sleepTimeInMillis = 50;
    private int lower = 0;
    private int upper = 0;
    private static byte songuuliResult;

    public SonguuliTask(int lowerLimit, int upperLimit)
    {
        this.lower = lowerLimit;
        this.upper = upperLimit;
    }

    public SonguuliTask(int lowerLimit,int upperLimit,int sleepTimeInMillis)
    {
        this(lowerLimit, upperLimit);
        this.sleepTimeInMillis = sleepTimeInMillis;
    }

    public SonguuliTask() {

    }

    @Override
    protected ObservableList<Integer> call() throws Exception {
        long count = 50000;
        long counter = 0;
        ObservableList<Integer> results = FXCollections.observableArrayList();


//        int boxCount[] = new int[22];

        for(int i = 0; i < count; i++) {
            counter++;

            updateProgress(counter, count);
        }
        return results;

    }

    @Override
    public void succeeded()
    {
        super.succeeded();

    }
}
