package farid.example.com.retrofitrecyclerview;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import farid.example.com.retrofitrecyclerview.adapter.RecyclerViewAdapter;
import farid.example.com.retrofitrecyclerview.model.ModelData;
import farid.example.com.retrofitrecyclerview.network.ApiCLient;
import farid.example.com.retrofitrecyclerview.service.APIService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    SearchView searchView;
    FloatingActionButton fab;

    EditText edt_nama, edt_kelas;
    Button btn_tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        ambilData();
        
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahData();
            }
        });
    }

    private void tambahData() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Tambah Data");
        dialog.setContentView(R.layout.activity_tambah);

        edt_nama = (EditText)dialog.findViewById(R.id.edt_tambahnama);
        edt_kelas = (EditText)dialog.findViewById(R.id.edt_tambahkelas);
        btn_tambah = (Button) dialog.findViewById(R.id.btn_tambahdata);
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prosesTambahData();
                ambilData();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void prosesTambahData() {
        APIService apiService = ApiCLient.getCLient().create(APIService.class);
        Call<ResponseBody> call = apiService.tambahData(edt_nama.getText().toString(), edt_kelas.getText().toString());
        
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    Toast.makeText(MainActivity.this, response.body().string(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void ambilData() {
        APIService apiService = ApiCLient.getCLient().create(APIService.class);
        Call<List<ModelData>> call = apiService.getData();
        call.enqueue(new Callback<List<ModelData>>() {
            @Override
            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {
                List<ModelData> rowListItem = response.body();
                recyclerViewAdapter = new RecyclerViewAdapter(rowListItem);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
            @Override
            public void onFailure(Call<List<ModelData>> call, Throwable t) {

            }
        });

    }


    private void searchData(String newText) {
        APIService apiService = ApiCLient.getCLient().create(APIService.class);
        Call<List<ModelData>> call = apiService.searchQuery(newText);
        call.enqueue(new Callback<List<ModelData>>() {
            @Override
            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {
                List<ModelData> rowListItem = response.body();
                recyclerViewAdapter = new RecyclerViewAdapter(rowListItem);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
            @Override
            public void onFailure(Call<List<ModelData>> call, Throwable t) {
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        searchView = (SearchView)menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchData(newText);

                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_refresh:
                ambilData();
                break;
        }
        return true;
    }

}
