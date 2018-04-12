package com.pinzhi365.workuse.sailfish2;

import android.content.Context;
import android.databinding.DataBindingUtil;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pinzhi365.workuse.sailfish2.databinding.AdapterSecondItemBinding;

import java.util.ArrayList;

import model.MemberOrderListBean;

public class SecondAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<MemberOrderListBean.OrderBean> orderBeans;

    public SecondAdapter(Context context, ArrayList<MemberOrderListBean.OrderBean> orderBeans) {
        this.context = context;
        this.orderBeans = orderBeans;

    }

    @Override
    public int getItemCount() {
        return this.orderBeans.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        AdapterSecondItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.adapter_second_item, parent, false);

        return new OrderBeanViewHolder(binding.getRoot());

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AdapterSecondItemBinding binding = DataBindingUtil.getBinding(holder.itemView);
        binding.setOrderbean(orderBeans.get(position));
        binding.executePendingBindings();
    }

    static class OrderBeanViewHolder extends RecyclerView.ViewHolder {
        public OrderBeanViewHolder(View itemView) {
            super(itemView);
        }
    }
}
