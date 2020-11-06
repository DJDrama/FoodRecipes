package com.foodrecipes.www.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.foodrecipes.www.Injection;
import com.foodrecipes.www.databinding.FragmentFoodListBinding;
import com.foodrecipes.www.model.Food;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FoodListFragment extends Fragment implements OnFoodClickListener {
    private String TAG = FoodListFragment.class.getSimpleName();
    private FragmentFoodListBinding binding;

    private FoodListViewModelFactory mViewModelFactory;

    private FoodListViewModel mViewModel;
    private final CompositeDisposable mDisposable = new CompositeDisposable();

    private FoodListAdapter foodListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFoodListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModelFactory = Injection.provideFoodListViewModelFactory(requireContext());
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(FoodListViewModel.class);

        //set recyclerview
        foodListAdapter = new FoodListAdapter(this);
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerview.setAdapter(foodListAdapter);

        int type = (int) getArguments().get("type");
        mDisposable.add(
                mViewModel.getFoodList(type)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                foodList ->
                                        foodListAdapter.submitList(foodList),
                                throwable ->
                                        Log.e(TAG, "Unable To Fetch Food List", throwable)
                        ));

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mDisposable.clear();
    }

    @Override
    public void onFoodClicked(Food food) {
        NavDirections action = FoodListFragmentDirections.actionFoodListFragmentToFoodDetailFragment(food);
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }
}
