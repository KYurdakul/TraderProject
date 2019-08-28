package com.example.kerem.traderproject.Activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.example.kerem.traderproject.Adapter.RecyclerViewAdapter;
import com.example.kerem.traderproject.Contract.MainActivityContract;
import com.example.kerem.traderproject.Model.JSON;
import com.example.kerem.traderproject.Presenter.RetrofitPresenter;
import com.example.kerem.traderproject.Model.Item;
import com.example.kerem.traderproject.R;


public class PortfolioActivity extends AppCompatActivity implements MainActivityContract.View{


    String messageType="AN";
    RetrofitPresenter retrofitPresenter;
    RecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    TextView toplamTutar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);

        recyclerView = findViewById(R.id.recycler_layout);
        toplamTutar = findViewById(R.id.total);


        Bundle extras = getIntent().getExtras();
        final String intentAccountID = extras.getString("DefaultAccount");
        final String intentUsername = extras.getString("Username");
        final String intentPassword = extras.getString("Password");

        retrofitPresenter = new RetrofitPresenter(PortfolioActivity.this);
        retrofitPresenter.getRetro(intentUsername, intentPassword, messageType, intentAccountID);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    @Override
    public void retrofitView(JSON json) {
        Boolean state = json.getResult().getState();
        if(state==true) {
            adapter = new RecyclerViewAdapter(json.getItems(), getApplicationContext());
            recyclerView.setAdapter(adapter);

            double sumTutar = 0;
            for (Item items : json.getItems()){
                int miktarT2 = items.getQty_T2();
                Double fiyat = items.getLastPx();
                Double tutar = miktarT2*fiyat;
                sumTutar += tutar;

                toplamTutar.setText(String.format("%,.3f",sumTutar));

            }
        }

    }

}
