package com.hhl.flowlayoutdemo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.hhl.library.FlowTagLayout;
import com.hhl.library.OnTagSelectListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FlowTagLayout mMobileFlowTagLayout;
    private TagAdapter<String> mMobileTagAdapter;
    private List<String> dataSource = new ArrayList<>();
 private TextView tag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
tag = (TextView) findViewById(R.id.tag);
        mMobileFlowTagLayout = (FlowTagLayout) findViewById(R.id.mobile_flow_layout);

        mMobileTagAdapter = new TagAdapter<>(this);
        mMobileFlowTagLayout.setAdapter(mMobileTagAdapter);
        mMobileFlowTagLayout.setOnTagSelectListener(new OnTagSelectListener() {
            @Override
            public void onItemSelect(FlowTagLayout parent, List<Integer> selectedList) {
                if (selectedList != null && selectedList.size() > 0) {
                    StringBuilder sb = new StringBuilder();

                    for (int i : selectedList) {
                        sb.append(parent.getAdapter().getItem(i));
                        sb.append(".");
                    }
                    Snackbar.make(parent, "已选标签:" + sb.toString(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else{
                    Snackbar.make(parent, "没有选择标签", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        initMobileData();
        tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMobileTagAdapter.clerrall();
                dataSource.clear();
                dataSource.add("单卖吗");
                dataSource.add("比亚迪");
                dataSource.add("英菲尼迪");
                dataSource.add("玛莎拉蒂");
                mMobileTagAdapter.onlyAddAll(dataSource);
            }
        });
    }

    private void initMobileData() {
        dataSource.add("比亚迪");
        dataSource.add("英菲尼迪");
        dataSource.add("玛莎拉蒂");
        dataSource.add("IOS");
        dataSource.add("android");
        dataSource.add("java");
        dataSource.add("世界上最牛逼的导弹");
        dataSource.add("大众");
        dataSource.add("不得了");
        dataSource.add("mini");
        dataSource.add("移动研发工程师");
        dataSource.add("移动互联网");
        dataSource.add("高薪+期权");
        mMobileTagAdapter.onlyAddAll(dataSource);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
