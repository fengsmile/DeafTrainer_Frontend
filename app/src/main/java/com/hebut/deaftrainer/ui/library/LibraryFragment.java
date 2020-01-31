package com.hebut.deaftrainer.ui.library;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.hebut.deaftrainer.BookItem;
import com.hebut.deaftrainer.R;

import java.util.ArrayList;

public class LibraryFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private LibraryViewModel dashboardViewModel;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView mList;
    private Context mContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mContext = getContext();
        dashboardViewModel =
                ViewModelProviders.of(this).get(LibraryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_library, container, false);
        refreshLayout = root.findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(this);

        mList = root.findViewById(R.id.book_list);
        mList.setLayoutManager(new LinearLayoutManager(mContext));

        ArrayList<BookItem> tempdata = new ArrayList<>();
        BookItem it1 = new BookItem();
        it1.name = "Subject 1";
        it1.icon = getResources().getDrawable(R.mipmap.ic_launcher);
        for(int i = 0;i < 20;++i)
            tempdata.add(it1);
        mList.setAdapter(new LibraryAdapter(mContext,tempdata));

//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    public void onRefresh() {
        Toast.makeText(getActivity(), "fafafa", Toast.LENGTH_SHORT).show();
        refreshLayout.setRefreshing(false);
    }
}