package com.example.quizappvi.ui.fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizappvi.MainViewModel;
import com.example.quizappvi.R;

import java.util.Objects;

public class MainFragment extends Fragment {
Button startB;
Spinner s,s2;
SeekBar seekbar;
TextView changeTextValue;

private MainViewModel mViewModel;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);




    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.message.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
changeTextValue=view.findViewById(R.id.changetextValue);
seekbar=view.findViewById(R.id.seekBar);
       startB=view.findViewById(R.id.Bstart);

        s = view. findViewById(R.id.CategoryQ);
      s2 = view. findViewById(R.id.DifQ);

spinner1();
spinner2();
start();


seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {




        changeTextValue.setText(String.valueOf(new Integer(progress)));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});


    }








    public void start(){

        startB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getContext(), "в задании про логику на кнопку нету", Toast.LENGTH_SHORT).show();

            }
        });



    }




public  void spinner1(){


    ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(
            Objects.requireNonNull(getContext()), R.array.types, R.layout.support_simple_spinner_dropdown_item);
    adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
    s.setAdapter(adapter);



}

    public  void spinner2(){




        ArrayAdapter <CharSequence> adapter2 = ArrayAdapter.createFromResource(
                Objects.requireNonNull(getContext()), R.array.dificulity, R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        s2.setAdapter(adapter2);


    }


}