package com.zv.geochat.ui.adapter;

import static android.content.ContentValues.TAG;
import static android.text.format.DateUtils.FORMAT_NUMERIC_DATE;
import static android.text.format.DateUtils.FORMAT_SHOW_DATE;
import static android.text.format.DateUtils.HOUR_IN_MILLIS;
import static android.text.format.DateUtils.SECOND_IN_MILLIS;
import static android.text.format.DateUtils.MINUTE_IN_MILLIS;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zv.geochat.R;
import com.zv.geochat.model.ChatMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import co.dift.ui.SwipeToAction;


public class ChatMessagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ChatMessage> items;


    /** References to the views for each data item **/
    public class ChatMessageViewHolder extends SwipeToAction.ViewHolder<ChatMessage> {
        public TextView userName;
        public TextView chatMessageBody;
        public ImageView imageView;
        public TextView chatMessageDate;

        public TextView chatMessageID;

        public ChatMessageViewHolder(View v) {
            super(v);

            userName = (TextView) v.findViewById(R.id.userName);
            chatMessageBody = (TextView) v.findViewById(R.id.body);
            chatMessageDate = (TextView) v.findViewById(R.id.chatMessageDate);
            imageView = (ImageView) v.findViewById(R.id.image);
            chatMessageID = (TextView) v.findViewById(R.id.chatMessageID);
        }
    }

    /** Constructor **/
    public ChatMessagesAdapter(List<ChatMessage> items) {
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);

        return new ChatMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChatMessage item = items.get(position);
        ChatMessageViewHolder vh = (ChatMessageViewHolder) holder;

        int chatMessageDateInt = Integer.parseInt(item.getMessageDate());
        String chatMessageDateString= new SimpleDateFormat("MM/dd/yyyy").format(new Date(chatMessageDateInt * 1000L));
        String chatMessageTimeString= new SimpleDateFormat("HH:mm").format(new Date(chatMessageDateInt * 1000L));

        int chatID = Integer.parseInt(item.getId());

        vh.userName.setText(item.getUserName());
        vh.chatMessageBody.setText(item.getBody());
        vh.chatMessageID.setText("Chat Message ID: " + String.valueOf(chatID));

        Long currentTime = (new Date().getTime());
        Long millisecondsDiff = currentTime - (chatMessageDateInt * 1000L);
        Long timeGap = TimeUnit.MILLISECONDS.toHours(millisecondsDiff);

        if(timeGap > 24 )
            vh.chatMessageDate.setText("Time:"+chatMessageDateString);
        else
            vh.chatMessageDate.setText("Time:"+chatMessageTimeString);
        vh.data = item;
    }
}