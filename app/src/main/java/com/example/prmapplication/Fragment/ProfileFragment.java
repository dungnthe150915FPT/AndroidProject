package com.example.prmapplication.Fragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.prmapplication.R;

public class ProfileFragment extends Fragment {

    private Button btnLogin, btnRegister;

    private void bindingView(View view) {
        btnLogin = view.findViewById(R.id.btnLogin);
        btnRegister = view.findViewById(R.id.btnRegister);
    }

    private void bindingAction() {
        btnLogin.setOnClickListener(this::onClickLogin);
        btnRegister.setOnClickListener(this::onClickRegister);
    }

    private void onClickLogin(View view) {
        Toast.makeText(getContext(), "Login", Toast.LENGTH_SHORT).show();
    }

    private void onClickRegister(View view) {
        Toast.makeText(getContext(), "Register", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingView(view);
        bindingAction();
    }
}