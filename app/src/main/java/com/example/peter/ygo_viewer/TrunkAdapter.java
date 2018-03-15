package com.example.peter.ygo_viewer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Peter on 3/14/2018.
 */

public class TrunkAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Card> mDataSource;

    public TrunkAdapter(Context context, ArrayList<Card> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }
    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //before optimization
        /*View rowView = mInflater.inflate(R.layout.list_item_card, parent, false);

        TextView nameTextView =
                rowView.findViewById(com.example.peter.ygo_viewer.R.id.card_name);
        TextView cardInfoTextView =
                rowView.findViewById(com.example.peter.ygo_viewer.R.id.card_info);
        ImageView cardPicImageView =
                rowView.findViewById(com.example.peter.ygo_viewer.R.id.card_pic);
        */
        ViewHolder holder;
        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_card, parent, false);
            holder = new ViewHolder();
            holder.cardNameView = convertView.findViewById(R.id.card_name);
            holder.cardInfoView = convertView.findViewById(R.id.card_info);
            holder.cardPicView = convertView.findViewById(R.id.card_pic);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        TextView nameTextView = holder.cardNameView;
        TextView infoTextView = holder.cardInfoView;
        ImageView picImageView = holder.cardPicView;


        Card card = (Card) getItem(position);
        nameTextView.setText(card.cardName);

        //cardInfoTextView.setText(formatCardInfo(card));
        infoTextView.setText(formatCardInfo(card));

        // cardPicImageView <---> picImageView
        if (card.cardColor.equals("F93")) {
            picImageView.setImageResource(R.drawable.effect);
        } else if (card.cardColor.equals("96C")) {
            picImageView.setImageResource(R.drawable.fusion);
        } else if (card.cardColor.equals("FF3")) {
            picImageView.setImageResource(R.drawable.normal);
        } else if (card.cardColor.equals("F36")) {
            picImageView.setImageResource(R.drawable.trap);
        } else if (card.cardColor.equals("396")) {
            picImageView.setImageResource(R.drawable.spell);
        } else if (card.cardColor.equals("66F")) {
            picImageView.setImageResource(R.drawable.ritual);
        }
        //return rowView;
        return convertView;
    }

    private String formatCardInfo(Card card) {
        if (card.cardColor.equals("396") ||
                card.cardColor.equals("F36")) {
            if (card.cardEffect.length() > 60) {
                return card.cardEffect.substring(0, 60);
            } else {
                return card.cardEffect;
            }
        } else {
            return "ATK " + (int) card.cardAttack + "  /  " + "DEF " + (int) card.cardDefense;
        }
    }

    private static class ViewHolder {
        public TextView cardNameView;
        public TextView cardInfoView;
        public ImageView cardPicView;
    }
}
