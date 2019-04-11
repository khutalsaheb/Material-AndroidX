package com.example.introapp.ViewModel;

import com.example.introapp.Helper.Api;
import com.example.introapp.Temp.News;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TabViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<News>> heroList;

    //we will call this method to get the data
    public LiveData<List<News>> getHeroes() {
        //if the list is null
        if (heroList == null) {
            heroList = new MutableLiveData<>();
            //we will load it asynchronously from server in this method
            loadNewses();
        }

        //finally we will return the list
        return heroList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadNewses() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<News>> call = api.getHeroes();
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(@NonNull Call<List<News>> call, @NonNull Response<List<News>> response) {
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<News>> call, @NonNull Throwable t) {

            }
        });
    }
}