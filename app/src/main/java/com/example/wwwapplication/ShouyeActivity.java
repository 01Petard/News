package com.example.wwwapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShouyeActivity extends AppCompatActivity {

    //声明ViewPager
    private ViewPager mViewPager;
    //适配器
    private FragmentPagerAdapter mAdapter;
    //装载Fragment的集合
    private List<Fragment> mFragments;

    //四个Tab对应的布局
    private LinearLayout mTabWechat;
    private LinearLayout mTabFriend;
//    private LinearLayout mTabContact;
    private LinearLayout mTabSetting;

    //四个Tab对应的ImageButton
    private ImageButton mImgWechat;
    private ImageButton mImgFriend;
//    private ImageButton mImgContact;
    private ImageButton mImgSetting;
    private ListView news_list;
    private List<Map<String, Object>> mData;
    private long exitTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouye);
        initViews();//初始化控件
        initEvents();//初始化事件
        initDatas();//初始化数据
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initDatas() {
        mFragments = new ArrayList<>();
        //将四个Fragment加入集合中
        mFragments.add(new IndexFragment());
        mFragments.add(new FriendFragment());
//        mFragments.add(new ContactFragment());
        mFragments.add(new SettingFragment());

        //初始化适配器
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {//从集合中获取对应位置的Fragment
                return mFragments.get(position);
            }

            @Override
            public int getCount() {//获取集合中Fragment的总数
                return mFragments.size();
            }

        };

        mViewPager.setAdapter(mAdapter);
        //设置ViewPager的切换监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            //页面滚动事件
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //页面选中事件
            @Override
            public void onPageSelected(int position) {
                //设置position对应的集合中的Fragment
                mViewPager.setCurrentItem(position);
                resetImgs();
                selectTab(position);
            }

            @Override
            //页面滚动状态改变事件
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initEvents() {
        //设置四个Tab的点击事件
        mTabWechat.setOnClickListener(onClickListener);
        mTabFriend.setOnClickListener(onClickListener);
//        mTabContact.setOnClickListener(onClickListener);
        mTabSetting.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //先将四个ImageButton置为灰色
            resetImgs();

            //根据点击的Tab切换不同的页面及设置对应的ImageButton为绿色
            switch (v.getId()) {
                case R.id.id_tab_wechat:
                    selectTab(0);
                    break;
                case R.id.id_tab_friend:
                    selectTab(1);
                    break;
//                case R.id.id_tab_contact:
//                    selectTab(2);
//                    break;
                case R.id.id_tab_setting:
                    selectTab(2);
                    break;
            }
        }
    };

    //初始化控件
    private void initViews() {
        mViewPager = findViewById(R.id.id_viewpager);

        mTabWechat = findViewById(R.id.id_tab_wechat);
        mTabFriend = findViewById(R.id.id_tab_friend);
//        mTabContact = findViewById(R.id.id_tab_contact);
        mTabSetting = findViewById(R.id.id_tab_setting);

        mImgWechat = findViewById(R.id.id_tab_wechat_img);
        mImgFriend = findViewById(R.id.id_tab_friend_img);
//        mImgContact = findViewById(R.id.id_tab_contact_img);
        mImgSetting = findViewById(R.id.id_tab_setting_img);

    }

    private void selectTab(int i) {
        //根据点击的Tab设置对应的ImageButton为绿色
        switch (i) {
            case 0:
                mImgWechat.setImageResource(R.mipmap.tab_weixin_pressed);
                break;
            case 1:
                mImgFriend.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;
//            case 2:
//                mImgContact.setImageResource(R.mipmap.tab_address_pressed);
//                break;
            case 2:
                mImgSetting.setImageResource(R.mipmap.tab_settings_pressed);
                break;
        }
        //设置当前点击的Tab所对应的页面
        mViewPager.setCurrentItem(i);
    }

    //将四个ImageButton设置为灰色
    private void resetImgs() {
        mImgWechat.setImageResource(R.mipmap.tab_weixin_normal);
        mImgFriend.setImageResource(R.mipmap.tab_find_frd_normal);
//        mImgContact.setImageResource(R.mipmap.tab_address_normal);
        mImgSetting.setImageResource(R.mipmap.tab_settings_normal);
    }
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, " 再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
