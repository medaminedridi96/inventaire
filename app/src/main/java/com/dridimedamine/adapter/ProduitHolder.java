package com.dridimedamine.adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dridimedamine.listener.OnItemClicked;
import com.dridimedamine.entites.Produit;
import com.dridimedamine.inventaire.R;

public class ProduitHolder extends RecyclerView.ViewHolder {

    private TextView theoricValueTextView;
    private TextView realValueTextView;

    private ImageView productImageView;
    private TextView productNameTextView;
    private TextView productCodeTextView;

    private ImageButton showDilaogButton;

    public ProduitHolder(@NonNull View itemView) {
        super(itemView);

        theoricValueTextView = itemView.findViewById(R.id.tv_thorical_stock);
        realValueTextView = itemView.findViewById(R.id.tv_real_stock);

        productImageView = itemView.findViewById(R.id.iv_product_image);

        productNameTextView = itemView.findViewById(R.id.tv_product_name);
        productCodeTextView = itemView.findViewById(R.id.tv_product_code);

        showDilaogButton = itemView.findViewById(R.id.iv_button_down);
    }

    public void bind(Produit produit, OnItemClicked onItemClicked) {
        int simulateTheoricalValue = 23; //TODO check these values
        realValueTextView.setText(String.format("%s\n%s", simulateTheoricalValue, itemView.getContext().getString(R.string.theorical_stock)));

        theoricValueTextView.setText(String.format("%s\n%s", produit.getQuantite(), itemView.getContext().getString(R.string.real_stock)));

        productNameTextView.setText(produit.getNom());
        productCodeTextView.setText(String.format("%s %s", itemView.getContext().getString(R.string.code_label), produit.getCode()));

        showDilaogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicked.onItemClicked(produit);
            }
        });


    }
}
