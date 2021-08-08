package com.devansh.myproject.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devansh.myproject.model.Festival;
import com.devansh.myproject.repositories.FestivalRepository;

import java.util.ArrayList;

public class ViewModelFestival extends ViewModel {

    MutableLiveData<ArrayList<Festival>> festLiveData;
    FestivalRepository festivalRepository;

    ViewModelFestival() {

    }

}
