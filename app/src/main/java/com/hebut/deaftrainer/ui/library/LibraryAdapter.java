package com.hebut.deaftrainer.ui.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hebut.deaftrainer.BookItem;
import com.hebut.deaftrainer.LogItem;
import com.hebut.deaftrainer.R;

import java.util.List;

import static java.lang.Math.min;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.ViewHolder> {
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        ImageView mIcon;
        ViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_text);
            mIcon = itemView.findViewById(R.id.iv_icon);
        }
    }
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private List<BookItem> mData;
    private final int MAX_WORDS = 7;

    public LibraryAdapter(Context context, List<BookItem> data) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
        mData = data;
    }

    public LibraryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LibraryAdapter.ViewHolder(mLayoutInflater.inflate(R.layout.library_listitem, parent, false));
    }

    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void add(int pos,BookItem item) {
        mData.add(pos,item);
        notifyItemInserted(pos);
    }

    public void remove(int pos) {
        mData.remove(pos);
        notifyItemRemoved(pos);
    }

    public void onBindViewHolder(final LibraryAdapter.ViewHolder holder, int pos) {
        BookItem li = mData.get(pos);
        holder.mName.setText(li.name);
        holder.mIcon.setImageDrawable(li.icon);
    }
}
