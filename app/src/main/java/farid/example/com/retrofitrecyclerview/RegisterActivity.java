package farid.example.com.retrofitrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import farid.example.com.retrofitrecyclerview.Helper.Helpernya;
import farid.example.com.retrofitrecyclerview.network.ApiCLient;
import farid.example.com.retrofitrecyclerview.service.APIService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.edt_reg_username)
    EditText edtRegUsername;
    @BindView(R.id.edt_reg_email)
    EditText edtRegEmail;
    @BindView(R.id.edt_reg_password)
    EditText edtRegPassword;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    private void register() {

        if (Helpernya.isEmpty(edtRegUsername)) {

            edtRegUsername.setError("required");
        } else if (Helpernya.isEmpty(edtRegEmail)) {

            edtRegEmail.setError("required");
        } else if (Helpernya.isEmpty(edtRegPassword)) {

            edtRegPassword.setError("required");
        } else
        {

            APIService apiService = ApiCLient.getCLient().create(APIService.class);
        Call<ResponseBody> call = apiService.registerAkun
                (edtRegUsername.getText().toString(), edtRegEmail.getText().toString(), edtRegPassword.getText().toString());

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
    }

    @OnClick(R.id.btn_register)
    public void onClick() {
        register();
    }
}
