package com.foodrecipes.www.ui.main;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.foodrecipes.www.Constants;
import com.foodrecipes.www.databinding.ItemLayoutFoodBinding;
import com.foodrecipes.www.model.Food;

import java.util.ArrayList;
import java.util.List;

interface OnFoodClickListener {
    void onFoodClicked(Food food);
}

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodViewHolder> {
    private List<Food> foodList;
    private OnFoodClickListener onFoodClickListener;

    FoodListAdapter(OnFoodClickListener onFoodClickListener) {
        foodList = new ArrayList<>();
        this.onFoodClickListener = onFoodClickListener;
    }

    void submitList(List<Food> foodList) {
        if (this.foodList.size() != 0) {
            this.foodList.clear();
        }
        this.foodList.addAll(foodList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodViewHolder(ItemLayoutFoodBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), onFoodClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.bind(food);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    static class FoodViewHolder extends RecyclerView.ViewHolder {
        private final ItemLayoutFoodBinding binding;
        private final OnFoodClickListener onFoodClickListener;

        public FoodViewHolder(ItemLayoutFoodBinding binding, OnFoodClickListener onFoodClickListener) {
            super(binding.getRoot());
            this.binding = binding;
            this.onFoodClickListener = onFoodClickListener;
        }

        public void bind(Food food) {
            binding.getRoot().setOnClickListener(view -> {
                onFoodClickListener.onFoodClicked(food);
            });
            binding.imageView.setImageResource(food.getImage());
            binding.tvName.setText(food.getName());
            String sType = "";
            switch (food.getSpecificType()) {
                case Constants.KOREAN_KIMCHI:
                    sType = "김치";
                    break;
                case Constants.KOREAN_SOUP:
                    sType = "찌개";
                    break;
                case Constants.KOREAN_BULGOGI:
                    sType = "불고기";
                    break;
                case Constants.YANGSIK_HAMBURGER:
                    sType = "햄버거";
                    break;
                case Constants.YANGSIK_PASTA:
                    sType = "파스타";
                    break;
                case Constants.YANGSIK_PIZZA:
                    sType = "피자";
                    break;
                case Constants.YANGSIK_STEAK:
                    sType = "스테이크";
                    break;
                case Constants.CHINESE_GOGI:
                    sType = "고기";
                    break;
                case Constants.CHINESE_HONHAP:
                    sType = "혼합요리";
                    break;
                case Constants.CHINESE_NODDLE:
                    sType = "면요리";
                    break;
                case Constants.JAPANESE_DUPBAP:
                    sType = "덮밥";
                    break;
                case Constants.JAPANESE_GATSU:
                    sType = "돈가스";
                    break;
                case Constants.JAPANESE_NOODLE:
                    sType = "면요리";
                    break;
            }
            binding.tvType.setText(sType);
        }
    }
}
