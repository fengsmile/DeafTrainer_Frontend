package com.hebut.deaftrainer.ui.library;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LibraryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LibraryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is train fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}