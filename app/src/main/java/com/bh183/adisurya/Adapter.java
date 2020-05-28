package com.bh183.adisurya;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.NegaraViewHolder> {

    private Context context;
    private ArrayList<Negara> dataNegara;


    public Adapter(Context context, ArrayList<Negara> dataNegara) {
        this.context = context;
        this.dataNegara = dataNegara;
    }

    @NonNull
    @Override
    public NegaraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_negara, parent, false);
        return new NegaraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NegaraViewHolder holder, int position) {
        Negara tempNegara = dataNegara.get(position);
        holder.idNegara = tempNegara.getIdNegara();
        holder.negara.setText(tempNegara.getNegara());
        holder.pemimpin.setText(tempNegara.getPemimpin());
        holder.bahasa.setText(tempNegara.getBahasa());
        holder.ibukota.setText(tempNegara.getIbukota());
        holder.cover = tempNegara.getCover();
        holder.luas.setText(tempNegara.getLuas());
        holder.lagu.setText(tempNegara.getLagu());
        holder.sejarah.setText(tempNegara.getSejarah());


        try {
            File file = new File(holder.cover);
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
            holder.imgCover.setImageBitmap(bitmap);
            holder.imgCover.setContentDescription(holder.cover);
        } catch (FileNotFoundException er){
            er.printStackTrace();
            Toast.makeText(context, "Gagal mengambil gambar dalam media penyimpanan", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {

        return dataNegara.size();
    }

    public class NegaraViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        public int idNegara;
        private ImageView imgCover;
        private TextView negara;
        private TextView pemimpin;
        private TextView bahasa;
        private TextView ibukota;
        private TextView luas;
        private TextView lagu;
        private String cover;
        private TextView sejarah;

        public NegaraViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCover = itemView.findViewById(R.id.iv_negara);
            negara = itemView.findViewById(R.id.tv_negara);
            pemimpin = itemView.findViewById(R.id.tv_pemimpin);
            bahasa = itemView.findViewById(R.id.tv_bahasa);
            ibukota = itemView.findViewById(R.id.tv_ibukota);
            luas = itemView.findViewById(R.id.tv_luas);
            lagu = itemView.findViewById(R.id.tv_lagu);
            sejarah = itemView.findViewById(R.id.tv_sejarah);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent bukaNegara = new Intent(context, TampilActivity.class);
            bukaNegara.putExtra("ID", idNegara);
            bukaNegara.putExtra("NEGARA", negara.getText().toString());
            bukaNegara.putExtra("PEMIMPIN", pemimpin.getText().toString());;
            bukaNegara.putExtra("COVER", cover);
            bukaNegara.putExtra("BAHASA", bahasa.getText().toString());
            bukaNegara.putExtra("IBUKOTA", ibukota.getText().toString());
            bukaNegara.putExtra("LUAS", luas.getText().toString());
            bukaNegara.putExtra("LAGU", lagu.getText().toString());
            bukaNegara.putExtra("SEJARAH", sejarah.getText().toString());
            context.startActivity(bukaNegara);
        }

        @Override
        public boolean onLongClick(View v) {

            Intent bukaInput = new Intent(context, InputActivity.class);
            bukaInput.putExtra("OPERASI", "update");
            bukaInput.putExtra("ID", idNegara);
            bukaInput.putExtra("NEGARA", negara.getText().toString());
            bukaInput.putExtra("PEMIMPIN", pemimpin.getText().toString());;
            bukaInput.putExtra("COVER", cover);
            bukaInput.putExtra("BAHASA", bahasa.getText().toString());
            bukaInput.putExtra("IBUKOTA", ibukota.getText().toString());
            bukaInput.putExtra("LUAS", luas.getText().toString());
            bukaInput.putExtra("LAGU", lagu.getText().toString());
            bukaInput.putExtra("SEJARAH", sejarah.getText().toString());
            context.startActivity(bukaInput);
            return true;
        }
    }
}
