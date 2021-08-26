package com.devansh.myproject.home.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devansh.myproject.home.model.Festival;
import com.devansh.myproject.home.repositories.FestivalRepository;

import java.util.ArrayList;

public class ViewModelFestival extends ViewModel {
    LiveData<ArrayList<Festival>> festLiveData;
    FestivalRepository festivalRepository;

    public ViewModelFestival () {
        festivalRepository = new FestivalRepository().getInstance();
    }

    public LiveData<ArrayList<Festival>> getMutableLiveData() {
        festLiveData = festivalRepository.getFestivals();
        return festLiveData;
    }

    public void updateData() {
        festivalRepository.updateData();
    }

}
