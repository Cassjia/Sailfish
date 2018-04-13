package com.pinzhi365.workuse.sailfish2;

import android.content.Context;
import android.databinding.DataBindingUtil;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
//        orderBeans.get(position).getOrderProducts().get(0).articlePicPathNew.set
// ("https://goss2.vcg.com/creative/vcg/800/new/VCG41N945269902.jpg");
//        binding.setVariable(BR.orderproduct,orderBeans.get(position).getOrderProducts().get(0)
// .articlePicPathNew.get());
//        binding.setVariable(BR.articlePicPath,orderBeans.get(position).getOrderProducts().get
// (0).getArticlePicPath());
        orderBeans.get(position).setPosition(position);
        binding.setArticlePicPath(orderBeans.get(position).getOrderProducts().get(0)
                .getArticlePicPath());
        binding.setPrice(orderBeans.get(position).getOrderProducts().get(0).getArticlePrice());
        binding.setAmount(orderBeans.get(position).getOrderProducts().get(0).getOrderAmount());
        binding.executePendingBindings();
    }

    private static class OrderBeanViewHolder extends RecyclerView.ViewHolder {
        private OrderBeanViewHolder(View itemView) {
            super(itemView);
        }
    }


}
