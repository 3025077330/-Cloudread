package com.example.jingbin.cloudreader.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.jingbin.cloudreader.R;
import com.example.jingbin.cloudreader.app.App;
import com.example.jingbin.cloudreader.bean.AndroidBean;
import com.example.jingbin.cloudreader.databinding.ItemEverydayOneBinding;
import com.example.jingbin.cloudreader.databinding.ItemEverydayThreeBinding;
import com.example.jingbin.cloudreader.databinding.ItemEverydayTitleBinding;
import com.example.jingbin.cloudreader.databinding.ItemEverydayTwoBinding;
import me.jingbin.bymvvm.rxbus.RxBus;
import com.example.jingbin.cloudreader.app.RxCodeConstants;
import com.example.jingbin.cloudreader.utils.DensityUtil;
import com.example.jingbin.cloudreader.utils.DialogBuild;
import com.example.jingbin.cloudreader.utils.GlideUtil;
import com.example.jingbin.cloudreader.utils.PerfectClickListener;
import com.example.jingbin.cloudreader.ui.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

import me.jingbin.bymvvm.adapter.BaseBindingHolder;
import me.jingbin.library.adapter.BaseByRecyclerViewAdapter;
import me.jingbin.library.adapter.BaseByViewHolder;

/**
 * Created by jingbin on 2016/12/27.
 */

public class EverydayAdapter extends BaseByRecyclerViewAdapter<ArrayList<AndroidBean>, BaseByViewHolder> {

    private static final int TYPE_TITLE = 1; // title
    private static final int TYPE_ONE = 2;// 一张图
    private static final int TYPE_TWO = 3;// 二张图
    private static final int TYPE_THREE = 4;// 三张图
    private int width;

    public EverydayAdapter() {
        WindowManager wm = (WindowManager) App.getInstance().getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
    }

    @Override
    public int getItemViewType(int position) {
        if (!TextUtils.isEmpty(getData().get(position).get(0).gettypeTitle())) {
            return TYPE_TITLE;
        } else if (getData().get(position).size() == 1) {
            return TYPE_ONE;
        } else if (getData().get(position).size() == 2) {
            return TYPE_TWO;
        } else if (getData().get(position).size() == 3) {
            return TYPE_THREE;
        }
        return super.getItemViewType(position);
    }


    @NonNull
    @Override
    public BaseByViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_TITLE:
                return new TitleHolder(parent, R.layout.item_everyday_title);
            case TYPE_ONE:
                return new OneHolder(parent, R.layout.item_everyday_one);
            case TYPE_TWO:
                return new TwoHolder(parent, R.layout.item_everyday_two);
            default:
                return new ThreeHolder(parent, R.layout.item_everyday_three);
        }
    }

    private class TitleHolder extends BaseBindingHolder<List<AndroidBean>, ItemEverydayTitleBinding> {

        TitleHolder(ViewGroup parent, int title) {
            super(parent, title);
        }

        @Override
        protected void onBindingView(BaseBindingHolder holder, List<AndroidBean> object, int position) {
            int index = 0;
            String title = object.get(0).gettypeTitle();
            binding.tvTitleType.setText(title);
            if ("Android".equals(title)) {
                index = 0;
            } else if ("福利".equals(title)) {
                index = 1;
            } else if ("iOS".equals(title)) {
                index = 2;
            } else if ("休息视频".equals(title)) {
                index = 2;
            } else if ("拓展资源".equals(title)) {
                index = 2;
            } else if ("瞎推荐".equals(title)) {
                index = 2;
            } else if ("前端".equals(title)) {
                index = 2;
            } else if ("App".equals(title)) {
                index = 2;
            }

            if (position != 0) {
                binding.viewLine.setVisibility(View.VISIBLE);
            } else {
                binding.viewLine.setVisibility(View.GONE);
            }

            final int finalIndex = index;
            binding.llTitleMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RxBus.getDefault().post(RxCodeConstants.JUMP_TYPE, finalIndex);
                }
            });
        }
    }

    private class OneHolder extends BaseBindingHolder<List<AndroidBean>, ItemEverydayOneBinding> {

        OneHolder(ViewGroup parent, int title) {
            super(parent, title);
        }

        @Override
        protected void onBindingView(BaseBindingHolder holder, List<AndroidBean> object, int position) {
            DensityUtil.setWidthHeight(binding.ivOnePhoto, width, 2.6f);
            if ("福利".equals(object.get(0).getType())) {
                binding.tvOnePhotoTitle.setVisibility(View.GONE);
                binding.ivOnePhoto.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                ImageLoadUtil.displayEspImage(object.get(0).getUrl(), binding.ivOnePhoto, 1);
                Glide.with(binding.ivOnePhoto.getContext())
                        .load(object.get(0).getUrl())
                        .transition(DrawableTransitionOptions.withCrossFade(1500))
                        .placeholder(R.drawable.img_two_bi_one)
                        .error(R.drawable.img_two_bi_one)
                        .into(binding.ivOnePhoto);

            } else {
                binding.tvOnePhotoTitle.setVisibility(View.VISIBLE);
                setDes(object, 0, binding.tvOnePhotoTitle);
                displayRandomImg(1, 0, binding.ivOnePhoto, object);
            }
            setOnClick(binding.llOnePhoto, object.get(0));
        }
    }

    private class TwoHolder extends BaseBindingHolder<List<AndroidBean>, ItemEverydayTwoBinding> {
        private int imageWidth;

        TwoHolder(ViewGroup parent, int title) {
            super(parent, title);
            imageWidth = (width - DensityUtil.dip2px(parent.getContext(), 3)) / 2;
        }

        @Override
        protected void onBindingView(BaseBindingHolder holder, List<AndroidBean> object, int position) {
            DensityUtil.setWidthHeight(binding.ivTwoOneOne, imageWidth, 1.75f);
            DensityUtil.setWidthHeight(binding.ivTwoOneTwo, imageWidth, 1.75f);
            displayRandomImg(2, 0, binding.ivTwoOneOne, object);
            displayRandomImg(2, 1, binding.ivTwoOneTwo, object);
            setDes(object, 0, binding.tvTwoOneOneTitle);
            setDes(object, 1, binding.tvTwoOneTwoTitle);
            setOnClick(binding.llTwoOneOne, object.get(0));
            setOnClick(binding.llTwoOneTwo, object.get(1));
        }
    }

    private class ThreeHolder extends BaseBindingHolder<List<AndroidBean>, ItemEverydayThreeBinding> {

        private int imageWidth;

        ThreeHolder(ViewGroup parent, int title) {
            super(parent, title);
            imageWidth = (width - DensityUtil.dip2px(parent.getContext(), 6)) / 3;
        }

        @Override
        protected void onBindingView(BaseBindingHolder holder, List<AndroidBean> object, int position) {
            DensityUtil.setWidthHeight(binding.ivThreeOneOne, imageWidth, 1);
            DensityUtil.setWidthHeight(binding.ivThreeOneTwo, imageWidth, 1);
            DensityUtil.setWidthHeight(binding.ivThreeOneThree, imageWidth, 1);
            displayRandomImg(3, 0, binding.ivThreeOneOne, object);
            displayRandomImg(3, 1, binding.ivThreeOneTwo, object);
            displayRandomImg(3, 2, binding.ivThreeOneThree, object);
            setOnClick(binding.llThreeOneOne, object.get(0));
            setOnClick(binding.llThreeOneTwo, object.get(1));
            setOnClick(binding.llThreeOneThree, object.get(2));
            setDes(object, 0, binding.tvThreeOneOneTitle);
            setDes(object, 1, binding.tvThreeOneTwoTitle);
            setDes(object, 2, binding.tvThreeOneThreeTitle);
        }
    }

    private void setDes(List<AndroidBean> object, int position, TextView textView) {
        textView.setText(object.get(position).getDesc());
    }

    private void displayRandomImg(int imgNumber, int position, ImageView imageView, List<AndroidBean> object) {
//        DebugUtil.error("-----Image_url: "+object.get(position).getImageUrl());
        GlideUtil.displayRandom(imgNumber, object.get(position).getImageUrl(), imageView);
    }


    private void setOnClick(final LinearLayout linearLayout, final AndroidBean bean) {
        linearLayout.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                WebViewActivity.loadUrl(v.getContext(), bean.getUrl(), bean.getDesc());
            }
        });

        linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String title = TextUtils.isEmpty(bean.getType()) ? bean.getDesc() : bean.getType() + "：  " + bean.getDesc();
                DialogBuild.showCustom(v, title, "查看详情", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        WebViewActivity.loadUrl(linearLayout.getContext(), bean.getUrl(), bean.getDesc());
                    }
                });
                return false;
            }
        });

    }
}
