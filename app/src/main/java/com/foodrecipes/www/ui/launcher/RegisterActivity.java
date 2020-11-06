package com.foodrecipes.www.ui.launcher;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.foodrecipes.www.Injection;
import com.foodrecipes.www.databinding.ActivityRegisterBinding;
import com.foodrecipes.www.model.User;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getSimpleName();

    private ActivityRegisterBinding binding;
    private RegisterViewModel mViewModel;
    private final CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("회원가입");
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //ViewModel
        RegisterViewModelFactory mViewModelFactory = Injection.provideRegisterViewModelFactory(this);
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(RegisterViewModel.class);

        binding.button.setOnClickListener(view -> {
            //Register Complete
            String id = binding.edtId.getText().toString();
            if (id.isEmpty()) {
                Toast.makeText(this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
            String password = binding.editTextTextPassword.getText().toString();
            String passwordCheck = binding.editTextTextPassword2.getText().toString();
            if (password.isEmpty() || passwordCheck.isEmpty()) {
                Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!password.equals(passwordCheck)) {
                Toast.makeText(this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            //회원가입 완료
            User user = new User(id, password);
            disposable.add(
                    mViewModel.insertUser(user)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(this::registerComplete,
                                    throwable ->
                                            Toast.makeText(this, "이미 가입되어 있는 아이디입니다.", Toast.LENGTH_SHORT).show()
                            ));
        });
    }

    private void registerComplete() {
        Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다. 가입하신 아이디로 로그인해주세요.", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        disposable.clear();
    }
}
