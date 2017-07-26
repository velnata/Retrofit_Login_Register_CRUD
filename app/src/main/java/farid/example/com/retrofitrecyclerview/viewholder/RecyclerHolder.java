package farid.example.com.retrofitrecyclerview.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import farid.example.com.retrofitrecyclerview.R;

/**
 * Created by Farid on 09/05/2017.
 */

public class RecyclerHolder extends RecyclerView.ViewHolder {

   public TextView name, kelas;
    public CardView card;


    public RecyclerHolder(View itemView) {

        super(itemView);

        name = (TextView) itemView.findViewById(R.id.name);
        kelas = (TextView) itemView.findViewById(R.id.kelas);
        card =(CardView)itemView.findViewById(R.id.card);

    }

}
