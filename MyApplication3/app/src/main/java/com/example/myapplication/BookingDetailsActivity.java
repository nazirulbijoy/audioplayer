package com.example.bookingdetails;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BookingDetailsActivity extends AppCompatActivity {

    private ImageView carImage;
    private TextView carDetails;
    private RatingBar carRating;
    private EditText pickupDate, pickupTime, returnDate, returnTime, additionalInfo;
    private ImageView ownerImage, renterImage;
    private TextView ownerName, ownerEmail, renterName, renterEmail;
    private CalendarView availabilityCalendar;
    private Button advancePaymentButton, cancelButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        // Initialize views
        carImage = findViewById(R.id.car_image);
        carDetails = findViewById(R.id.car_details);
        carRating = findViewById(R.id.car_rating);
        pickupDate = findViewById(R.id.pickup_date);
        pickupTime = findViewById(R.id.pickup_time);
        returnDate = findViewById(R.id.return_date);
        returnTime = findViewById(R.id.return_time);
        additionalInfo = findViewById(R.id.additional_info);
        ownerImage = findViewById(R.id.owner_image);
        renterImage = findViewById(R.id.renter_image);
        ownerName = findViewById(R.id.owner_name);
        ownerEmail = findViewById(R.id.owner_email);
        renterName = findViewById(R.id.renter_name);
        renterEmail = findViewById(R.id.renter_email);
        availabilityCalendar = findViewById(R.id.availability_calendar);
        advancePaymentButton = findViewById(R.id.advance_payment_button);
        cancelButton = findViewById(R.id.cancel_button);

        // Set listeners for buttons
        advancePaymentButton.setOnClickListener(view -> {
            // Handle advance payment button click
        });

        cancelButton.setOnClickListener(view -> {
            // Handle cancel button click
        });

        // You can set other necessary data to views here
    }
}
