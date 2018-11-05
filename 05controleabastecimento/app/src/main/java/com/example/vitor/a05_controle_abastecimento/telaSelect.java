package com.example.vitor.a05_controle_abastecimento;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class telaSelect extends AppCompatActivity {
    private abastecimentoAdapter postoAdapter;
    private RecyclerView rvTotalPostos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_select);
        abastecimentoDAO start = new abastecimentoDAO();
        this.rvTotalPostos = findViewById(R.id.rvTotalPostos);
        this.postoAdapter = new abastecimentoAdapter();
        this.postoAdapter.listaAvaliacoes = abastecimentoDAO.getLista(this.getApplicationContext());
        rvTotalPostos.setAdapter(this.postoAdapter);
        rvTotalPostos.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));


    }


    public void criarNovo(View Objeto) {


        try {
            Intent telaCriar = new Intent(this.getApplicationContext(), telaCriarPosto.class);
            startActivityForResult(telaCriar,1);
            ArrayList<Posto> novo = abastecimentoDAO.getLista(this.getApplicationContext());
            this.postoAdapter= new abastecimentoAdapter();
            this.postoAdapter.listaAvaliacoes = novo;
            this.postoAdapter.notifyDataSetChanged();
        } catch (Exception e) {
        }

    }



}
