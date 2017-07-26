package farid.example.com.retrofitrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import farid.example.com.retrofitrecyclerview.network.ApiCLient;
import farid.example.com.retrofitrecyclerview.service.APIService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.email)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.btn_sign)
    Button btnSign;
    @BindView(R.id.inputan)
    LinearLayout inputan;
    @BindView(R.id.or)
    TextView or;
    @BindView(R.id.have_acount)
    TextView haveAcount;
    @BindView(R.id.txt_register)
    TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_sign, R.id.txt_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sign:
                aksiLogin();
                break;
            case R.id.txt_register:
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                break;
        }
    }

    private void aksiLogin() {
        APIService apiService = ApiCLient.getCLient().create(APIService.class);
        Call<ResponseBody> call = apiService.loginAkun(username.getText().toString(), password.getText().toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    Toast.makeText(LoginActivity.this, response.body().string(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
