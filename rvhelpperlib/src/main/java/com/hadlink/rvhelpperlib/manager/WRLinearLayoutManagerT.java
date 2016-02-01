/*
 *
 *   Copyright (c) 2016, lyao. lomoliger@hotmail.com
 *
 *   Part of the code from the open source community,
 *   thanks stackOverflow & gitHub .
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.hadlink.rvhelpperlib.manager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * @author Created by lyao on 2016/1/19.
 *         wrap content's rv
 */
public class WRLinearLayoutManagerT extends android.support.v7.widget.LinearLayoutManager {

    private int[] mMeasuredDimension = new int[2];
    private Context ctx;

    public WRLinearLayoutManagerT(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        this.ctx = context;
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state,
                          int widthSpec, int heightSpec) {
        final int widthMode = View.MeasureSpec.getMode(widthSpec);
        final int heightMode = View.MeasureSpec.getMode(heightSpec);
        final int widthSize = View.MeasureSpec.getSize(widthSpec);
        final int heightSize = View.MeasureSpec.getSize(heightSpec);
        int width = 0;
        int height = 0;
        for (int i = 0; i < getItemCount(); i++) {
            measureScrapChild(recycler, i,
                    View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED),
                    mMeasuredDimension);

            if (getOrientation() == HORIZONTAL) {
                width = width + mMeasuredDimension[0];
                if (i == 0) {
                    height = mMeasuredDimension[1];
                }
            } else {
                height = height + mMeasuredDimension[1];
                if (i == 0) {
                    width = mMeasuredDimension[0];
                }
            }
        }

        switch (widthMode) {
            case View.MeasureSpec.EXACTLY:
                width = widthSize;
            case View.MeasureSpec.AT_MOST:
            case View.MeasureSpec.UNSPECIFIED:
        }

        switch (heightMode) {
            case View.MeasureSpec.EXACTLY:
                height = heightSize;
            case View.MeasureSpec.AT_MOST:
            case View.MeasureSpec.UNSPECIFIED:
        }

        setMeasuredDimension(width, height);
    }

    private void measureScrapChild(RecyclerView.Recycler recycler, int position, int widthSpec,
                                   int heightSpec, int[] measuredDimension) {

        View view = recycler.getViewForPosition(position);

        // For adding Item Decor Insets to view
        super.measureChildWithMargins(view, 0, 0);
        RecyclerView.LayoutParams p = (RecyclerView.LayoutParams) view.getLayoutParams();
        int childWidthSpec = ViewGroup.getChildMeasureSpec(widthSpec,
                getPaddingLeft() + getPaddingRight() + getDecoratedLeft(view) + getDecoratedRight(view), p.width);
        CharSequence text = ((TextView) ((FrameLayout) view).getChildAt(0)).getText();
        if(TextUtils.equals("HeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeightHeight",
                text)){
            int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec,
                    getPaddingTop() + getPaddingBottom() + getPaddingBottom() + getDecoratedBottom(view), p.height);
        }
        int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec,
                getPaddingTop() + getPaddingBottom() + getPaddingBottom() + getDecoratedBottom(view), p.height);
        view.measure(childWidthSpec, childHeightSpec);

        // Get decorated measurements
        measuredDimension[0] = getDecoratedMeasuredWidth(view);
        measuredDimension[1] = getDecoratedMeasuredHeight(view);
        recycler.recycleView(view);
    }

    @Override public boolean canScrollVertically() {
        return false;
    }
}