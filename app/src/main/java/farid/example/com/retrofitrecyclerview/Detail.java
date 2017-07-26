package farid.example.com.retrofitrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import farid.example.com.retrofitrecyclerview.model.ModelData;
import farid.example.com.retrofitrecyclerview.network.ApiCLient;
import farid.example.com.retrofitrecyclerview.service.APIService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail extends AppCompatActivity implements View.OnClickListener {

    List<ModelData> modelData;

    EditText edt_nama, edt_kelas;
    Button btn_edit, btn_hapus;

    Intent intent;

    String strId_mhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        intent = getIntent();

        inisialisasi();

        ambilDataDetail();

        btn_edit.setOnClickListener(this);

        btn_hapus.setOnClickListener(this);
    }

    private void inisialisasi() {
        edt_nama = (EditText) findViewById(R.id.detail_nama);
        edt_kelas = (EditText) findViewById(R.id.detail_kelas);
        btn_edit = (Button) findViewById(R.id.btn_edit);
        btn_hapus = (Button) findViewById(R.id.btn_hapus);

        strId_mhs = intent.getStringExtra("id_mhs");
    }

    private void ambilDataDetail() {
        APIService apiService = ApiCLient.getCLient().create(APIService.class);

        Call<List<ModelData>> call = apiService.getId(intent.getStringExtra("id_mhs"));

        call.enqueue(new Callback<List<ModelData>>() {
            @Override
            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {
                List<ModelData> row = response.body();

                modelData = new ArrayList<ModelData>(row);

                String tampilnama = null, tampilkelas = "";

                for (int i = 0; i < modelData.size(); i++) {
                    tampilnama = modelData.get(i).getNama_mhs();
                    tampilkelas = modelData.get(i).getKelas_mhs();
                }
                edt_nama.setText(tampilnama);
                edt_kelas.setText(tampilkelas);
            }

            @Override
            public void onFailure(Call<List<ModelData>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == btn_edit) {

            APIService apiService = ApiCLient.getCLient().create(APIService.class);

            Call<ResponseBody> call =
                    apiService.updateData (strId_mhs, edt_nama.getText().toString(), edt_kelas.getText().toString());

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    try {
                        Toast.makeText(Detail.this, response.body().string(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(Detail.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else if(view==btn_hapus){

            APIService apiService = ApiCLient.getCLient().create(APIService.class);

            Call<ResponseBody> call = apiService.deleteData(strId_mhs);

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    Toast.makeText(Detail.this, "berhasil hapus", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }
    }
}
