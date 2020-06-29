package com.dridimedamine.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dridimedamine.listener.OnItemClicked;
import com.dridimedamine.entites.Depot;
import com.dridimedamine.entites.Produit;
import com.dridimedamine.inventaire.R;

import java.util.List;

public class ProduitAdapter extends RecyclerView.Adapter<ProduitHolder> {

    private List<Produit> mProduitsList;
    private OnItemClicked onItemClicked;

    public ProduitAdapter(List<Produit> produitList, OnItemClicked onItemClicked) {
        mProduitsList = produitList;
        this.onItemClicked = onItemClicked;
    }

    @NonNull
    @Override
    public ProduitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produit, parent, false);
        return new ProduitHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitHolder holder, int position) {
        holder.bind(mProduitsList.get(position), this.onItemClicked);
    }

    @Override
    public int getItemCount() {
        return mProduitsList.size();
    }
}