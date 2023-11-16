package com.example.semana12sqlite.Controlador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semana12sqlite.Modelo.Usuario;
import com.example.semana12sqlite.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
    private TextView ID,Nombre,Correo;
        public ViewHolder(View itemView){
            super(itemView);
            Nombre=(TextView)itemView.findViewById(R.id.tvNombre);
            Correo=(TextView)itemView.findViewById(R.id.tvCorreo);
            ID=(TextView)itemView.findViewById(R.id.tvID);
        }
    }
    public List<Usuario> usuarioList;
    public UserAdapter(List<Usuario>usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Nombre.setText(usuarioList.get(position).getNombre());
        holder.Correo.setText(usuarioList.get(position).getCorreo());
        holder.ID.setText(usuarioList.get(position).getID());

    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }
}
