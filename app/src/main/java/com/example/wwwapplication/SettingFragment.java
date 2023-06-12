package com.example.wwwapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {


    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btn_jiancha = getActivity().findViewById(R.id.jiancha);

        btn_jiancha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "已是最新版本", Toast.LENGTH_LONG).show();
            }
        });



        Button btn_yijian = getActivity().findViewById(R.id.yijian);
        btn_yijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              
//从fragment跳转到activity中
                startActivity(new Intent(getActivity(), ReviewCommodityActivity.class));
            }
        });
    }

}

