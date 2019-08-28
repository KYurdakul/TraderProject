package com.example.kerem.traderproject.Presenter;


import com.example.kerem.traderproject.Contract.MainActivityContract;
import com.example.kerem.traderproject.Model.JSON;
import com.example.kerem.traderproject.Service.RetrofitClient;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;

public class RetrofitPresenter {

    private MainActivityContract.View retrofitView;


    public RetrofitPresenter(MainActivityContract.View view){
        this.retrofitView = view;
    }

    public void getRetro(String username,String password,String messageType,String accountID)
    {
        String url="https://tbpilot.matriksdata.com/9999/";
        MainActivityContract.Api api = RetrofitClient.retrofitService(url).create(MainActivityContract.Api.class);
        Call<JSON> call = api.getRetrofit(messageType, 0, username, password, accountID, 4, 2);
        call.enqueue(new Callback<JSON>() {
            @Override
            public void onResponse(Call<JSON> call, Response<JSON> response) {
                JSON json = response.body();
                retrofitView.retrofitView(json);
            }

            @Override
            public void onFailure(Call<JSON> call, Throwable t) {

            }
        });

    }
}
