package com.hebut.deaftrainer.ui.user;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hebut.deaftrainer.R;

public class UserFragment extends Fragment {

    private UserViewModel userViewModel;
    private RecyclerView mList;
    private Context mContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userViewModel =
                ViewModelProviders.of(this).get(UserViewModel.class);
        mContext = getContext();
        View root = inflater.inflate(R.layout.fragment_user, container, false);
//        final TextView textView = root.findViewById(R.id.text_notifications);
//        userViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        mList = root.findViewById(R.id.user_menu);
//        mList.setLayoutManager(new LinearLayoutManager(mContext));
//        mList.setAdapter(new UserAdapter(mContext));
        return root;
    }
}