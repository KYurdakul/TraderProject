package com.example.kerem.traderproject.Contract;


import com.example.kerem.traderproject.Model.JSON;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainActivityContract {


    interface View{
        void retrofitView(JSON json);

    }

    interface Api{
        @GET("Integration.aspx?")
        Call<JSON> getRetrofit(
                @Query("MsgType") String messageType,
                @Query("CustomerNo") int customerNo,
                @Query("Username") String username,
                @Query("Password") String password,
                @Query("AccountID") String accountID,
                @Query("ExchangeID") int exchangeID,
                @Query("OutputType") int outputType
        );

    }

}
