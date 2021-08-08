package com.devansh.myproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devansh.myproject.model.Festival;
import com.devansh.myproject.repositories.FestivalRepository;

import java.util.ArrayList;

public class ViewModelFestival extends ViewModel {

    MutableLiveData<ArrayList<Festival>> festLiveData;
    FestivalRepository festivalRepository;

    public ViewModelFestival () {
        festivalRepository = new FestivalRepository().getInstance();
    }

    public MutableLiveData<ArrayList<Festival>> getMutableLiveData() {
        festLiveData = festivalRepository.getFestivals();
        return festLiveData;
    }

}
