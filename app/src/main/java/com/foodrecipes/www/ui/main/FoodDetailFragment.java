package com.foodrecipes.www.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.foodrecipes.www.Constants;
import com.foodrecipes.www.databinding.FragmentFoodDetailBinding;
import com.foodrecipes.www.model.Food;

public class FoodDetailFragment extends Fragment {
    private FragmentFoodDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFoodDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Food food = (Food) getArguments().get("food");

        binding.imageView4.setImageResource(food.getImage());
        binding.tvName.setText(food.getName());
        String sType="";
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
        binding.tvMain.setText("주재료: " +food.getMainIngredient());
        binding.tvSub.setText("부재료 : " + food.getSubIngredient());
        binding.tvProcess.setText(food.getProcess());


    }
}
