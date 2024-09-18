package com.example.multiscrn;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.multiscrn.databinding.FragmentFirstBinding;

import java.util.Calendar;

public class FirstFragment extends Fragment {
     Button but;
     EditText url;
    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        url=view.findViewById(R.id.url);
        TimePicker alarmTimePicker = binding.getRoot().findViewById(R.id.alarmTimePicker);

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String urlText=url.getText().toString();
                Toast.makeText(getActivity(), "Alarm is set", Toast.LENGTH_SHORT).show();
//                Uri webpage = Uri.parse(urlText);
//                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
//                    startActivity(intent);
//                }
                if (alarmTimePicker != null) {
                    int hour = alarmTimePicker.getCurrentHour();
                    int minute = alarmTimePicker.getCurrentMinute();

                    // Rest of your code for setting the alarm..

                    // Get current time
                    Calendar currentTime = Calendar.getInstance();
                    int currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
                    int currentMinute = currentTime.get(Calendar.MINUTE);

                    // Calculate time difference
                    int timeDifferenceHours = hour - currentHour;
                    int timeDifferenceMinutes = minute - currentMinute;
                    if (timeDifferenceMinutes < 0) {
                        timeDifferenceHours--;
                        timeDifferenceMinutes += 60;
                    }

                    // Set alarm time
                Calendar alarmTime = Calendar.getInstance();
                alarmTime.add(Calendar.HOUR_OF_DAY, timeDifferenceHours);
                alarmTime.add(Calendar.MINUTE, timeDifferenceMinutes);
                alarmTime.set(Calendar.SECOND, 0);
                    String message="nfnbb";
                    Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                            .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                            .putExtra(AlarmClock.EXTRA_HOUR, hour)
                            .putExtra(AlarmClock.EXTRA_MINUTES, minute);
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}