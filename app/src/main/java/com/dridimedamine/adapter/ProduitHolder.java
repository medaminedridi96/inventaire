package com.dridimedamine.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dridimedamine.entites.Produit;
import com.dridimedamine.inventaire.R;

import org.w3c.dom.Text;

public class ProduitHolder extends RecyclerView.ViewHolder {

    private TextView theoricValueTextView;
    private TextView realValueTextView;

    private ImageView productImageView;
    private TextView productNameTextView;
    private TextView productCodeTextView;

    public ProduitHolder(@NonNull View itemView) {
        super(itemView);

        theoricValueTextView = itemView.findViewById(R.id.tv_thorical_stock);
        realValueTextView = itemView.findViewById(R.id.tv_real_stock);

        productImageView = itemView.findViewById(R.id.iv_product_image);

        productNameTextView = itemView.findViewById(R.id.tv_product_name);
        productCodeTextView = itemView.findViewById(R.id.tv_product_code);
    }

    public void bind(Produit produit) {
        int simulateTheoricalValue = 23; //TODO check these values
        realValueTextView.setText(String.format("%s\n%s", simulateTheoricalValue, itemView.getContext().getString(R.string.theorical_stock)));

        theoricValueTextView.setText(String.format("%s\n%s", produit.getQuantite(), itemView.getContext().getString(R.string.real_stock)));

        productNameTextView.setText(produit.getNom());
        productCodeTextView.setText(String.format("%s %s", itemView.getContext().getString(R.string.code_label),produit.getCode()));
    }
}
