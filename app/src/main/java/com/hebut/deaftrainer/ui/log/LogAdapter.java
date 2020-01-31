package com.hebut.deaftrainer.ui.log;

import android.content.Context;
import android.view.*;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.hebut.deaftrainer.LogItem;
import com.hebut.deaftrainer.R;
import java.util.List;
import static java.lang.Math.*;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.ViewHolder> {
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mName,mWords,mRight,mWrong,mDate;
        ViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_name);
            mWords = itemView.findViewById(R.id.tv_words);
            mRight = itemView.findViewById(R.id.tv_right);
            mWrong = itemView.findViewById(R.id.tv_wrong);
            mDate = itemView.findViewById(R.id.tv_date);
        }
    }
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private List<LogItem> mData;
    private final int MAX_WORDS = 7;

    public LogAdapter(Context context, List<LogItem> data) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
        mData = data;
    }

    public LogAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LogAdapter.ViewHolder(mLayoutInflater.inflate(R.layout.log_listitem, parent, false));
    }

    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void add(int pos,LogItem item) {
        mData.add(pos,item);
        notifyItemInserted(pos);
    }

    public void remove(int pos) {
        mData.remove(pos);
        notifyItemRemoved(pos);
    }

    public void onBindViewHolder(final LogAdapter.ViewHolder holder, int pos) {
        LogItem li = mData.get(pos);
        holder.mName.setText(li.name);
        if(!li.words.isEmpty()) {
            StringBuilder words = new StringBuilder();
            Object[] sa = li.words.toArray();
            int size = li.words.size();
            for (int i = 0; i < min(size - 1,MAX_WORDS); ++i) {
                words.append(sa[i]);
                words.append(",");
            }
            words.append(sa[size - 1]);
            if(size > MAX_WORDS) {
                words.append("...");
            }
            holder.mWords.setText(words.toString());
        }
        holder.mRight.setText("" + li.right);
        holder.mWrong.setText("" + li.wrong);
        holder.mDate.setText(li.date.toString());
    }
}
