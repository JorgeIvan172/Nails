package com.example.nailsstudio.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nailsstudio.R;
import com.example.nailsstudio.entidades.Citas;

import java.util.ArrayList;

public class ListaCitaAdapter extends RecyclerView.Adapter<ListaCitaAdapter.CitasViewHolder> {


    ArrayList<Citas> listaCitas;

    public ListaCitaAdapter( ArrayList<Citas> listaCitas){
        this.listaCitas = listaCitas;
    }

    @NonNull
    @Override
    public CitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_citas, null, false);
        return new CitasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitasViewHolder holder, int position) {
        holder.viewNombre.setText(listaCitas.get(position).getNombreCliente());
        holder.viewHora.setText(listaCitas.get(position).getHora());
        holder.viewTipo.setText(listaCitas.get(position).getTipoCita());
        holder.viewTelefono.setText(listaCitas.get(position).getTelefonoCliente());
    }

    @Override
    public int getItemCount() {
       return listaCitas.size();
    }

    public class CitasViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewHora, viewTipo, viewTelefono;
        public CitasViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewHora = itemView.findViewById(R.id.viewHora);
            viewTipo= itemView.findViewById(R.id.viewTipo);
            viewTelefono = itemView.findViewById(R.id.viewTelefono);
        }
    }
}
