package farid.example.com.retrofitrecyclerview.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import farid.example.com.retrofitrecyclerview.Detail;
import farid.example.com.retrofitrecyclerview.R;
import farid.example.com.retrofitrecyclerview.model.ModelData;
import farid.example.com.retrofitrecyclerview.viewholder.RecyclerHolder;

/**
 * Created by Farid on 09/05/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerHolder> {
    private List<ModelData> modelData;

    public RecyclerViewAdapter(List<ModelData> modelData) {
        this.modelData = modelData;
    }


    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, final int position) {

        holder.name.setText(modelData.get(position).getNama_mhs());
        holder.kelas.setText(modelData.get(position).getKelas_mhs());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Detail.class);

                intent.putExtra("id_mhs", modelData.get(position).getId_mhs());

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelData.size();
    }
}
