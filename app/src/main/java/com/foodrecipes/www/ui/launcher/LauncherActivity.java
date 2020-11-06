package com.foodrecipes.www.ui.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.foodrecipes.www.Injection;
import com.foodrecipes.www.MainActivity;
import com.foodrecipes.www.databinding.ActivityLauncherBinding;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class LauncherActivity extends AppCompatActivity {
    private static final String TAG = LauncherActivity.class.getSimpleName();

    private ActivityLauncherBinding binding;
    private LauncherViewModel mViewModel;
    private final CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("로그인");
        binding = ActivityLauncherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LauncherViewModelFactory mViewModelFactory = Injection.provideLauncherViewModelFactory(this);
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(LauncherViewModel.class);


        binding.tvRegister.setOnClickListener(view -> {
            Intent intent = new Intent(LauncherActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
        binding.buttonLogin.setOnClickListener(view -> {
            String id = binding.edtId.getText().toString();
            if (id.isEmpty()) {
                Toast.makeText(this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
            String password = binding.editTextTextPassword.getText().toString();
            if (password.isEmpty()) {
                Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }

            disposable.add(
                    mViewModel.getUserId(password).subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(userId -> compareId(userId, id)
                                    , throwable -> Toast.makeText(this, "가입하신 아이디가 존재하지 않거나, 비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show())
            );
        });
    }

    private void compareId(String userId, String id) {
        if (userId.equals(id)) {
            Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        disposable.clear();
    }
}
