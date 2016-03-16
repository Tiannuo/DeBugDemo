package com.example.debugdemo.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.debugdemo.BaseUse.BaseTitleActivity;
import com.example.debugdemo.Fragmnet.My;
import com.example.debugdemo.Fragmnet.TabHostFragment;
import com.example.debugdemo.R;
import com.example.debugdemo.TabBean;
import com.example.debugdemo.Wight.FragmentTabHost;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/3/8 0008.
 */

public class FragmentTabHostNewActivity extends BaseTitleActivity {
    @Bind(android.R.id.tabhost)
    FragmentTabHost fragmentTabHost;
    private ArrayList<TabBean> tabs=new ArrayList<>();

    @Override
    protected void getIntentData() {
        setChildLayout(R.layout.activity_fragmenttabhostalyout);
        initTab();

    }

    private void initTab() {
        TabBean tab_home=new TabBean(R.drawable.selector_icon_home, TabHostFragment.class,R.string.home_title);
        TabBean tab_map=new TabBean(R.drawable.selector_icon_map, My.class,R.string.map_title);
        TabBean tab_hadoop=new TabBean(R.drawable.selector_icon_hood, TabHostFragment.class,R.string.hadoop_title);
        TabBean tab_my=new TabBean(R.drawable.selector_icon_my, TabHostFragment.class,R.string.user_title);
        tabs.add(tab_home);
        tabs.add(tab_map);
        tabs.add(tab_hadoop);
        tabs.add(tab_my);

        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        for (TabBean tabBean:tabs){
            TabHost.TabSpec tabSpec=fragmentTabHost.newTabSpec(getString(tabBean.getTitle()));
            tabSpec.setIndicator(buildIndicator(tabBean));
            fragmentTabHost.addTab(tabSpec,tabBean.getFragment(),null);
        }

        fragmentTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);

        fragmentTabHost.setOnTabChangedListener(tabChangeListener);
        fragmentTabHost.setOnTabRefreshListener(onTabRefreshListener);
        tv_title.setText(fragmentTabHost.getCurrentTabTag());


    }

    @Override
    protected void initView() {



    }

    @Override
    protected void initData() {

    }



    TabHost.OnTabChangeListener tabChangeListener=new TabHost.OnTabChangeListener() {
        @Override
        public void onTabChanged(String tabId) {
            tv_title.setText(tabId);
        }
    };


    FragmentTabHost.OnTabRefreshListener onTabRefreshListener=new FragmentTabHost.OnTabRefreshListener() {
        @Override
        public boolean onTabRefresh(int index) {
            if (index==tabs.size()-1&&FirstLogin()){
                return true;
            }
            return false;
        }
    };





    private View buildIndicator(TabBean tabBean) {
        View view= LayoutInflater.from(this).inflate(R.layout.tab_indicator, null);
        ImageView img= (ImageView) view.findViewById(R.id.icon_tab);
        TextView text= (TextView) view.findViewById(R.id.txt_indicator);
        img.setBackgroundResource(tabBean.getIcon());
        text.setText(tabBean.getTitle());
        return view;
    }
}
