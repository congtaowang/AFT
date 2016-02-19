package cn.aft.sample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.aft.sample.R;
import cn.aft.sample.bean.Card;
import cn.aft.tools.Data;

/**
 * 16/2/18 by congtaowang.
 * Version 1.0
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewsHolder> {

    private List<Card> cards;

    public CardViewAdapter(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public CardViewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_card, null);
        return new CardViewsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardViewsHolder holder, int position) {
        holder.bindCard(cards.get(position));
    }

    @Override
    public int getItemCount() {
        return Data.getSize(cards);
    }
}
