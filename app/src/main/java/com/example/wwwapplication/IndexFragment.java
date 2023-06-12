package com.example.wwwapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment {


    public IndexFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_wechat, container, false);
        View view = inflater.inflate(R.layout.fragment_wechat, null);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayout linear1 = getActivity().findViewById(R.id.linear1);

        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "详情", Toast.LENGTH_LONG).show();

//从fragment跳转到activity中
                startActivity(new Intent(getActivity(), Xinwen1Activity.class));
            }
        });


        LinearLayout linear2 = getActivity().findViewById(R.id.linear2);

        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "详情", Toast.LENGTH_LONG).show();

//从fragment跳转到activity中
                startActivity(new Intent(getActivity(), Xinwen2Activity.class));
            }
        });


        LinearLayout linear3 = getActivity().findViewById(R.id.linear3);

        linear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "详情", Toast.LENGTH_LONG).show();

//从fragment跳转到activity中
                startActivity(new Intent(getActivity(), Xinwen3Activity.class));
            }
        });


        LinearLayout linear4 = getActivity().findViewById(R.id.linear4);

        linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "详情", Toast.LENGTH_LONG).show();

//从fragment跳转到activity中
                startActivity(new Intent(getActivity(), Xinwen4Activity.class));
            }
        });


        LinearLayout linear5 = getActivity().findViewById(R.id.linear5);
        linear5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "详情", Toast.LENGTH_LONG).show();

//从fragment跳转到activity中
                startActivity(new Intent(getActivity(), Xinwen5Activity.class));
            }
        });

        LinearLayout linear6 = getActivity().findViewById(R.id.linear6);
        linear6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "详情", Toast.LENGTH_LONG).show();

//从fragment跳转到activity中
                startActivity(new Intent(getActivity(), Xinwen6Activity.class));
            }
        });

        LinearLayout linear7 = getActivity().findViewById(R.id.linear7);
        linear7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "详情", Toast.LENGTH_LONG).show();

//从fragment跳转到activity中
                startActivity(new Intent(getActivity(), Xinwen7Activity.class));
            }
        });
    }

}

