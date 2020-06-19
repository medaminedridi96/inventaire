package com.dridimedamine.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dridimedamine.entites.Depot;
import com.dridimedamine.entites.Produit;
import com.dridimedamine.inventaire.R;

import java.util.List;

public class ProduitAdapter extends RecyclerView.Adapter<ProduitHolder> {

    private List<Produit> mProduitsList;

    public ProduitAdapter(List<Produit> produitList) {
        mProduitsList = produitList;
    }

    @NonNull
    @Override
    public ProduitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produit, parent, false);
        return new ProduitHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitHolder holder, int position) {
        holder.bind(mProduitsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mProduitsList.size();
    }
}