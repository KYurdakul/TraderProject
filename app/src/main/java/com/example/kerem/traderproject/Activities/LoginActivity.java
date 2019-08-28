package com.example.kerem.traderproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.kerem.traderproject.Contract.MainActivityContract;
import com.example.kerem.traderproject.Model.JSON;
import com.example.kerem.traderproject.Presenter.RetrofitPresenter;
import com.example.kerem.traderproject.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener, MainActivityContract.View{

    EditText editUsername,editPassword;
    Button loginButton;
    ProgressBar progressBar;

    String messageType="A",accountID="0";
    RetrofitPresenter retrofitPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername = findViewById(R.id.username);
        editPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.button);
        loginButton.setOnClickListener(this);
        progressBar = findViewById(R.id.progressBar);

        retrofitPresenter = new RetrofitPresenter(LoginActivity.this);
        }


    public void onClick(View v){
        progressBar.setVisibility(View.VISIBLE);
        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();
        retrofitPresenter.getRetro(username,password,messageType,accountID);
    }

    @Override
    public void retrofitView(JSON json) {
        progressBar.setVisibility(View.INVISIBLE);
        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();
        String description = json.getResult().getDescription();
        Boolean state = json.getResult().getState();

        Toast.makeText(this, description, Toast.LENGTH_LONG).show();

        if(state==true){
            Intent intent = new Intent(this,PortfolioActivity.class);
            intent.putExtra("DefaultAccount",json.getAccount());
            intent.putExtra("Username",username);
            intent.putExtra("Password",password);
            this.startActivity(intent);
        }

    }

}
