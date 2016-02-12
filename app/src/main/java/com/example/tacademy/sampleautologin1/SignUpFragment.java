package com.example.tacademy.sampleautologin1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {


    public SignUpFragment() {
        // Required empty public constructor
    }

    EditText idView, nameView, pwView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        idView = (EditText)view.findViewById(R.id.edit_userid);
        nameView = (EditText)view.findViewById(R.id.edit_username);
        pwView = (EditText)view.findViewById(R.id.edit_password);
        Button btn = (Button)view.findViewById(R.id.btn_signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userid = idView.getText().toString();
                final String username = nameView.getText().toString();
                final String password = pwView.getText().toString();

                NetworkManager.getInstance().signUp(getContext(), userid, password, new NetworkManager.OnResultListener() {
                    @Override
                    public void onSuccess(Object result) {
                        PropertyManager.getInstance().setUserId(userid);
                        PropertyManager.getInstance().setPassword(password);
                        startActivity(new Intent(getContext(), MainActivity.class));
                        getActivity().finish();
                    }

                    @Override
                    public void onFailure(int code) {

                    }
                });
            }
        });


        return view;
    }

}
