package utec.edu.sv.parcial04ordinario.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import utec.edu.sv.parcial04ordinario.R;
import utec.edu.sv.parcial04ordinario.entidades.EntClientes;

public class LstClientesAdapter extends RecyclerView.Adapter<LstClientesAdapter.ProveedoresViewHolder>{

    ArrayList<EntClientes> listaclientes;

    public LstClientesAdapter(ArrayList<EntClientes> entClientes) {
        this.listaclientes=entClientes;
    }

    @NonNull
    @Override
    public LstClientesAdapter.ProveedoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_clientes,null,false);
        return new ProveedoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LstClientesAdapter.ProveedoresViewHolder holder, int position) {
        holder.viewNombre.setText(listaclientes.get(position).getNOMBRE());
        holder.viewoApellido.setText(listaclientes.get(position).getAPELLIDO());
        holder.viewDireccion.setText(listaclientes.get(position).getDIRECCION());
        holder.viewCiudad.setText(listaclientes.get(position).getCIUDAD());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProveedoresViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre,viewoApellido,viewDireccion,viewCiudad;
        public ProveedoresViewHolder(@NonNull View itemView){
            super(itemView);
            viewNombre=itemView.findViewById(R.id.tvNombre);
            viewoApellido=itemView.findViewById(R.id.tvApellido);
            viewDireccion=itemView.findViewById(R.id.tvDireccion);
            viewCiudad=itemView.findViewById(R.id.tvCiudad);
        }
    }
}
