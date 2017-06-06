package com.example.logonrm.demonavigationdrawer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.logonrm.demonavigationdrawer.R;

public class FormularioFragment extends Fragment implements View.OnClickListener {


    public FormularioFragment() {}

    private EditText editTextValor1;
    private EditText editTextValor2;
    private Button btnSoma;
    private Button btnSubt;
    private Button btnMult;
    private Button btnDiv;
    private TextView txtViewResultado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_formulario, container, false);

        editTextValor1 = (EditText) v.findViewById(R.id.tilValor1);
        editTextValor2 = (EditText) v.findViewById(R.id.tilValor2);
        btnSoma = (Button) v.findViewById(R.id.btnSoma);
        btnDiv = (Button) v.findViewById(R.id.btnDiv);
        btnMult = (Button) v.findViewById(R.id.btnMult);
        btnSubt = (Button) v.findViewById(R.id.btnSubt);
        txtViewResultado = (TextView) v.findViewById(R.id.txtResultado);

        btnSubt.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnSoma.setOnClickListener(this);
        btnMult.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        if (checkCampoEmBranco(editTextValor1.getText().toString(),editTextValor2.getText().toString())) {
            Toast.makeText(getActivity(),"Campo em branco!", Toast.LENGTH_SHORT).show();
            return;
        }
        Long resultado = null;
        switch (v.getId()) {

            case R.id.btnSoma:
                resultado = Long.parseLong(editTextValor1.getText().toString()) + Long.parseLong(editTextValor2.getText().toString());
                break;
            case R.id.btnSubt:
                resultado = Long.parseLong(editTextValor1.getText().toString()) - Long.parseLong(editTextValor2.getText().toString());

                break;
            case R.id.btnMult:
                resultado = Long.parseLong(editTextValor1.getText().toString()) * Long.parseLong(editTextValor2.getText().toString());
                break;
            case R.id.btnDiv:
                if (Long.parseLong(editTextValor2.getText().toString()) == 0.0) {
                    Toast.makeText(getActivity(), "Multiplicação por 0 não é possível.", Toast.LENGTH_SHORT).show();
                } else {
                    resultado = Long.parseLong(editTextValor1.getText().toString()) / Long.parseLong(editTextValor2.getText().toString());
                }
                break;

        }
        txtViewResultado.setText(String.valueOf(resultado));
    }

    public boolean checkCampoEmBranco(String valor1, String valor2) {
        boolean retorno = false;
        if (TextUtils.isEmpty(valor1) || TextUtils.isEmpty(valor2))
            retorno = true;
        return retorno;
    }
}
