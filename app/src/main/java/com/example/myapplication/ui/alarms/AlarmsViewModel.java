package com.example.myapplication.ui.alarms;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlarmsViewModel extends ViewModel {
    private final MutableLiveData<Boolean> isAlarmTimingDeleted = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isAlarmSaved = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isAlarmAdded = new MutableLiveData<>(false);

    private final MutableLiveData<Boolean> isTestAlarmAdded = new MutableLiveData<>(false);

    private final MutableLiveData<Boolean> isAlarmDeleted = new MutableLiveData<>(false);

    private final MutableLiveData<Long> selectedDate = new MutableLiveData<>();

    public LiveData<Boolean> getIsAlarmTimingDeleted() {
        return isAlarmTimingDeleted;
    }



    public void setAlarmTimingDeleted(boolean isDeleted) {
        isAlarmTimingDeleted.setValue(isDeleted);
    }

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

    public LiveData<Boolean> getIsAlarmAdded() {
        return isAlarmAdded;
    }

    public LiveData<Boolean> getIsTestVAlarmAdded() {
        return isTestAlarmAdded;
    }

    public void setAlarmAdded(boolean isAdded) {
        isAlarmAdded.setValue(isAdded);
    }

    public void setTestAlarmAdded(boolean isAdded) {
        isTestAlarmAdded.setValue(isAdded);
    }

}
