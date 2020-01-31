package com.hebut.deaftrainer.ui.log;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hebut.deaftrainer.LogItem;
import com.hebut.deaftrainer.R;

import java.util.ArrayList;
import java.util.Date;

public class LogFragment extends Fragment {
    RecyclerView mList;
    Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getContext();
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_log, container, false);
        mList = root.findViewById(R.id.log_list);
        mList.setLayoutManager(new LinearLayoutManager(mContext));

        ArrayList<LogItem> tempdata = new ArrayList<>();
        LogItem it1 = new LogItem();
        it1.name = "Subject 1";
        it1.words = new ArrayList<>();
        it1.words.add("a");
        it1.words.add("b");
        it1.words.add("c");
        it1.right = 233;
        it1.wrong = 233;
        it1.date = new Date(2020,2,28);
        for(int i = 0;i < 20;++i)
            tempdata.add(it1);

        mList.setAdapter(new LogAdapter(mContext,tempdata));

        return root;
    }
}
