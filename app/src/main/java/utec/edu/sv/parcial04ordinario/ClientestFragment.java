package utec.edu.sv.parcial04ordinario;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import utec.edu.sv.parcial04ordinario.datos.Clientes;

public class ClientestFragment extends Fragment {

    EditText txtNombre,txtApellido,txtDireccion,txtCiudad;
    TextView tvMensajes;
    Button btnGuardar, btnActualizar, bntBorrar;
    Context context;


    public ClientestFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatActivity appCompatActivity =new AppCompatActivity();
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_clientes, container, false);

        View view=inflater.inflate(R.layout.fragment_clientes, container, false);
        txtNombre = view.findViewById(R.id.edtNombre);
        txtApellido = view.findViewById(R.id.edtApellido);
        txtDireccion = view.findViewById(R.id.edtDireccion);
        txtCiudad = view.findViewById(R.id.edtCiudad);
        btnGuardar =view.findViewById(R.id.btnGuardar);
        tvMensajes=view.findViewById(R.id.tvMensaje);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clientes baseProv = new Clientes(context);
                long codigoSave = baseProv.insertCliente(txtNombre.getText().toString(),txtApellido.getText().toString(),txtDireccion.getText().toString(),txtCiudad.getText().toString());
                if (codigoSave > 0){
                    tvMensajes.append("Registro insertado");
                }else{
                    tvMensajes.append("Error en insertar");
                }
            }
        });


        txtNombre.setText("Marvin");
        txtApellido.setText("Ramirez");
        // Inflate the layout for this fragment
        return view;
    }

}

