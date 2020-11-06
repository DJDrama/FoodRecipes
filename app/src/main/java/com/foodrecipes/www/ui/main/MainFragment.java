package com.foodrecipes.www.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.foodrecipes.www.Constants;
import com.foodrecipes.www.R;
import com.foodrecipes.www.databinding.FragmentMainBinding;


public class MainFragment extends Fragment implements View.OnClickListener {
    private FragmentMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.clHansik.setOnClickListener(this);
        binding.clYangsik.setOnClickListener(this);
        binding.clChinese.setOnClickListener(this);
        binding.clJapanese.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        int type = Constants.KOREAN;
        switch (view.getId()) {
            case R.id.cl_hansik:
                type = Constants.KOREAN;
                break;
            case R.id.cl_yangsik:
                type = Constants.YANGSIK;
                break;
            case R.id.cl_chinese:
                type = Constants.CHINESE;
                break;
            case R.id.cl_japanese:
                type = Constants.JAPANESE;
                break;
        }
        NavDirections action = MainFragmentDirections.actionMainFragmentToFoodListFragment(type);
        Navigation.findNavController(view).navigate(action);
    }
}
