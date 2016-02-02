package com.hadlink.recyclerviewhelpper.unrelated;

import android.support.v7.widget.RecyclerView;

import com.hadlink.recyclerviewhelpper.R;
import com.hadlink.rvhelpperlib.adapter.RecyclerViewAdapter;
import com.hadlink.rvhelpperlib.adapter.ViewHolderHelper;

import java.util.List;

/**
 * @author Created by lyao on 2016/1/18.
 * @update
 * @description
 */
public class FuelAdapter extends RecyclerViewAdapter<FuelBean> {
    public FuelAdapter(RecyclerView recyclerView, List<FuelBean> list) {
        super(recyclerView, R.layout.item2, list);
    }

    @Override protected void setItemChildListener(ViewHolderHelper viewHolderHelper) {
        super.setItemChildListener(viewHolderHelper);
        viewHolderHelper.setItemChildClickListener(R.id.faveVal);
        viewHolderHelper.setItemChildClickListener(R.id.priceLayout);
        viewHolderHelper.setItemChildClickListener(R.id.labelView);
    }

    @Override protected void fillData(ViewHolderHelper viewHolderHelper, int position, FuelBean model) {
        LabelView_New labelViewNew = viewHolderHelper.getView(R.id.labelView);
        labelViewNew.setText(model.discount + "折");
        viewHolderHelper.setText(R.id.faveVal, model.faceVal + "");
        viewHolderHelper.setText(R.id.price, model.price + "");
        viewHolderHelper.getView(R.id.mainContent).setSelected(model.isSelect);
    }

    public void setSelectItem(int position, Runnable r) {
        List<FuelBean> datas = getDatas();
        FuelBean fuelBean = datas.get(position);
        if (!fuelBean.isSelect) {
            for (FuelBean f : datas) {
                f.isSelect = false;
            }
            fuelBean.isSelect = true;
            notifyDataSetChanged();
            if (r != null) r.run();
        }
    }
}