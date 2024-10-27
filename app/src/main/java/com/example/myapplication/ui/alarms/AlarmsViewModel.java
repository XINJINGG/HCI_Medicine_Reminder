package com.example.myapplication.ui.alarms;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlarmsViewModel extends ViewModel {
    private final MutableLiveData<Boolean> isAlarmDeleted = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isAlarmSaved = new MutableLiveData<>(false);

    public LiveData<Boolean> getIsAlarmDeleted() {
        return isAlarmDeleted;
    }

    public void setAlarmDeleted(boolean isDeleted) {
        isAlarmDeleted.setValue(isDeleted);
    }

    public LiveData<Boolean> getIsAlarmSaved() {
        return isAlarmSaved;
    }

    public void setAlarmSaved(boolean isSaved) {
        isAlarmSaved.setValue(isSaved);
    }

}
