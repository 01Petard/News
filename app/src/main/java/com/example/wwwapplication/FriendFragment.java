package com.example.wwwapplication;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ListFragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFragment extends Fragment {


    public FriendFragment() {
        // Required empty public constructor
    }


    private View mView;
    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.imgge5
    };
    //存放图片的标题
    private String[] titles = new String[]{
            "夜空",
            "夜景",
            "海上城市",
            "太阳",
            "水边"
    };
    private TextView title;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_friend, null);
        setView();
        return mView;
    }

    private void setView() {
        mViewPaper = mView.findViewById(R.id.vp);

        //显示的图片
        images = new ArrayList<ImageView>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(mView.findViewById(R.id.dot_0));
        dots.add(mView.findViewById(R.id.dot_1));
        dots.add(mView.findViewById(R.id.dot_2));
        dots.add(mView.findViewById(R.id.dot_3));
        dots.add(mView.findViewById(R.id.dot_4));

        title = mView.findViewById(R.id.title);
        title.setText(titles[0]);

        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);

        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
                title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.dot_yes);
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_no);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    /*定义的适配器*/
    public class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
//          super.destroyItem(container, position, object);
//          view.removeView(view.getChildAt(position));
//          view.removeViewAt(position);
            view.removeView(images.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));
            return images.get(position);
        }

    }
    /**
     * 利用线程池定时执行动画轮播
     */
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }


    /**
     * 图片轮播任务
     */
    private class ViewPageTask implements Runnable {

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);
        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        }

        ;
    };

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        TextView textView = getActivity().findViewById(R.id.textView44);
//
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
////从fragment跳转到activity中
//                startActivity(new Intent(getActivity(), guangchangActivity.class));
//            }
//        });
        ImageButton imageButton = getActivity().findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//从fragment跳转到activity中
                startActivity(new Intent(getActivity(), Guangchang1Activity.class));
            }
        });
        ImageButton imageButton1 = getActivity().findViewById(R.id.imageButton1);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//从fragment跳转到activity中
                startActivity(new Intent(getActivity(), Guangchang2Activity.class));
            }
        });
        ImageButton imageButton2 = getActivity().findViewById(R.id.imageButton2);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//从fragment跳转到activity中
                startActivity(new Intent(getActivity(), Guangchang3Activity.class));
            }
        });
        ImageButton imageButton3 = getActivity().findViewById(R.id.imageButton3);

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//从fragment跳转到activity中
                startActivity(new Intent(getActivity(), Guangchang4Activity.class));
            }
        });
        ImageButton imageButton4 = getActivity().findViewById(R.id.imageButton4);

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//从fragment跳转到activity中
                startActivity(new Intent(getActivity(), Guangchang5Activity.class));
            }
        });
    }
}


