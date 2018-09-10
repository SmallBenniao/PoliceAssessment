package com.police.assessment.policeassessment.base.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import org.wjh.androidlib.listadapter.LoadMoreSingleLayoutAdapter;
import org.wjh.androidlib.listadapter.LoadingState;
import org.wjh.androidlib.listadapter.OnFooterErrorListener;
import org.wjh.androidlib.listadapter.OnSlideUpListener;

import java.util.List;

public abstract class BaseListFragment extends BaseFragment {

    // 当前页数
    protected int currentPage = 0;
    // 总页数
    protected int totalPage = 1;
    // 适配器（单布局）
    protected LoadMoreSingleLayoutAdapter adapter;


    protected boolean isRefresh = false;
    // 此属性只针对上拉加载使用
    // success和fail时一定要重置为true
    private boolean isCanRequest = false;

    public class MyRefreshListener implements SwipeRefreshLayout.OnRefreshListener {

        @Override
        public void onRefresh() {
            isRefresh = true;
            requestData(1);
        }
    }


    @Override
    public void load() {
        super.load();

        initAdapter();
        initRecyclerAndSwipe();
        initListener();
        requestData(++currentPage);
    }


    protected abstract void initAdapter();

    public abstract void initRecyclerAndSwipe();

    protected abstract void initListener();

    public void defaultInitList(RecyclerView recyclerView, SwipeRefreshLayout refreshLayout, RecyclerView.LayoutManager manager) {

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setOnFooterErrorListener(new MySimpleLayoutErrorListener());
        recyclerView.addOnScrollListener(new MyLoadMoreListener());
        if (refreshLayout != null)
            refreshLayout.setOnRefreshListener(new MyRefreshListener());
        adapter.setLoadState(LoadingState.LOAD_FIRST);
    }

    public void afterRefresh() {

        if (isRefresh) {
            isRefresh = false;

            showSuccessMsg("刷新成功");
        }
    }

    public class MyLoadMoreListener extends OnSlideUpListener {

        @Override
        public void onLoadMore() {

            if (!isCanRequest)
                return;

            ++currentPage;

            if (currentPage > totalPage) {

                if (adapter != null)
                    adapter.setLoadState(LoadingState.LOAD_END);

            } else {

                if (adapter != null)
                    adapter.setLoadState(LoadingState.LOADING);

                isCanRequest = false;
                requestData(currentPage);
            }

        }
    }

    public class MySimpleLayoutErrorListener implements OnFooterErrorListener {

        @Override
        public void onClick() {
            ++currentPage;

            if (currentPage > totalPage) {

                if (adapter != null)
                    adapter.setLoadState(LoadingState.LOAD_END);

            } else {

                if (adapter != null)
                    adapter.setLoadState(LoadingState.LOADING);

                requestData(currentPage);
            }
        }
    }

    public abstract void requestData(int page);


    protected void successNeedTodo(SwipeRefreshLayout layout) {

        isCanRequest = true;

        if (layout != null) {
            layout.setRefreshing(false);
        }

        if (adapter != null)
            adapter.setLoadState(LoadingState.LOAD_COMPLETE);

    }

    protected void failNeedTodo(SwipeRefreshLayout layout) {

        isCanRequest = true;

        if (layout != null) {
            layout.setRefreshing(false);
        }

        if (currentPage >= 1)
            currentPage--;

        if (adapter != null)
            adapter.setLoadState(LoadingState.LOAD_ERROR);

    }


    protected void needToResetPageOne(List list, int pageSize) {
        adapter.clearAll();
        this.totalPage = pageSize;
        currentPage = 1;
        afterRefresh();
        needToCheckListNull(list);
    }

    private void needToCheckListNull(List list) {

        if (list == null || list.size() == 0) {
            adapter.setLoadState(LoadingState.LOAD_NODATA);
        }
    }

}
