package com.benjamin.heystranger.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.benjamin.heystranger.MainActivity;
import com.benjamin.heystranger.R;

import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {

    private EditText edtName, edtUserName, edtPassword, edtConfirmPassword, edtBirth;
    private CircleImageView imgAvatar;
    private Button btnRegister;
    private MainActivity mainActivity;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        findId(view);
        initViews(view);
        return view;
    }

    private void findId(View view) {
        edtName = view.findViewById(R.id.edtName);
        edtUserName = view.findViewById(R.id.edtUserNameRegister);
        edtPassword = view.findViewById(R.id.edtPasswordRegister);
        edtConfirmPassword = view.findViewById(R.id.edtPasswordConfirm);
        edtBirth = view.findViewById(R.id.edtBirthdayRegister);
        imgAvatar = view.findViewById(R.id.imgAvatarRegister);
        btnRegister = view.findViewById(R.id.btnRegister);
    }

    private void initViews(View view) {
        mainActivity = (MainActivity) getActivity();
        edtBirth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edtBirthdayRegister:
                chooseDateOfBirth(edtBirth);
                break;
        }
    }

    private void chooseDateOfBirth(final EditText editText){
        final Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(mainActivity,
                new DatePickerDialog.OnDateSetListener() {

                    @SuppressLint("DefaultLocale")
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        editText.setText(String.format("%s/%s/%d", dayOfMonth<10?"0"+dayOfMonth:String.valueOf(dayOfMonth)
                                , (monthOfYear + 1) < 10 ? "0" + (monthOfYear + 1) : String.valueOf(monthOfYear + 1)
                                , year));
                    }
                }, currentYear, currentMonth, currentDay);
        datePickerDialog.show();
    }
}
