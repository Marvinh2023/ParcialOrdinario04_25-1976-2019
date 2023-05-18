package utec.edu.sv.parcial04ordinario;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import utec.edu.sv.parcial04ordinario.adaptadores.LstClientesAdapter;
import utec.edu.sv.parcial04ordinario.datos.Clientes;
import utec.edu.sv.parcial04ordinario.entidades.EntClientes;

public class VerClienetesFragment extends Fragment {

    RecyclerView listaClientes;
    ArrayList<EntClientes> AlistClientes;
    Context context;

    public VerClienetesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_verclientes, container, false);
        listaClientes=view.findViewById(R.id.rcvLstClientes);

        listaClientes.setLayoutManager(new LinearLayoutManager(context));

        Clientes dbProve = new Clientes(context);

        AlistClientes=new ArrayList<>();
        LstClientesAdapter adapter =  new LstClientesAdapter(dbProve.mostrarClientes());
        listaClientes.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }
}