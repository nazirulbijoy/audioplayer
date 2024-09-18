package com.example.bookingdetailsactivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TripReview extends AppCompatActivity {

    private ImageView carImage, backButton, ratingStar, pdateImage, ptimeImage, rdateImage, rtimeImage;
    private TextView tvTitle, carName, carRating, pickupDatePickerHint, pickupTimePickerHint,
            returnDatePickerHint, returnTimePickerHint, totalDistance, numberOfPassengers,
            numberOfStoppages, additionalInfo, ownerName, ownerEmail, renterName, renterEmail,
            acFeatureAmount, distanceFeatureAmount, totalAmount, advanceAmount;
    private Button  reviewButton ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        tvTitle = findViewById(R.id.tv_title);
        carImage = findViewById(R.id.car_image);
        backButton = findViewById(R.id.back_button);
        carName = findViewById(R.id.car_name);
        carRating = findViewById(R.id.car_rating);
        ratingStar = findViewById(R.id.rating_star);
        pickupDatePickerHint = findViewById(R.id.pickup_date_picker_hint);
        pickupTimePickerHint = findViewById(R.id.Pickup_date_timePicker_hint);
        pdateImage = findViewById(R.id.pdate_image);
        ptimeImage = findViewById(R.id.ptime_image);
        returnDatePickerHint = findViewById(R.id.return_date_picker_hint);
        returnTimePickerHint = findViewById(R.id.return_date_time_hint);
        rdateImage = findViewById(R.id.rdate_image);
        rtimeImage = findViewById(R.id.rtime_image);
        totalDistance = findViewById(R.id.distance_feature_amount_value_1);
        numberOfPassengers = findViewById(R.id.total_amount_value_1);
        numberOfStoppages = findViewById(R.id.seats_amount_value);
        additionalInfo = findViewById(R.id.additional_info);
        ownerName = findViewById(R.id.owner_name);
        ownerEmail = findViewById(R.id.owner_email);
        renterName = findViewById(R.id.renter_name);
        renterEmail = findViewById(R.id.renter_email);
        acFeatureAmount = findViewById(R.id.ac_feature_amount_value);
        distanceFeatureAmount = findViewById(R.id.distance_feature_amount_value);
        totalAmount = findViewById(R.id.total_amount_value);
        advanceAmount = findViewById(R.id.advance_amount_value);
        reviewButton = findViewById(R.id.review_button);

        // Example data setting, in a real application data will come from an intent or database
        carImage.setImageResource(R.drawable.car_pic);
        carName.setText("Toyota Axios");
        carRating.setText("4.9");
        ratingStar.setImageResource(R.drawable.ic_star);
        pickupDatePickerHint.setText("18 September, 2024");
        pickupTimePickerHint.setText("12:12 AM");
        pdateImage.setImageResource(R.drawable.date);
        ptimeImage.setImageResource(R.drawable.time);
        returnDatePickerHint.setText("18 September, 2024");
        returnTimePickerHint.setText("12:12 AM");
        rdateImage.setImageResource(R.drawable.date);
        rtimeImage.setImageResource(R.drawable.time);
        totalDistance.setText("30 Km");
        numberOfPassengers.setText("5");
        numberOfStoppages.setText("2");
        additionalInfo.setText("AC");
        ownerName.setText("Karim Hossain");
        ownerEmail.setText("karim@gmail.com");
        renterName.setText("Karim Hossain");
        renterEmail.setText("karim@gmail.com");
        acFeatureAmount.setText("20*5=100 ৳");
        distanceFeatureAmount.setText("100*30=3000 ৳");
        totalAmount.setText("3100 ৳");
        advanceAmount.setText("3100*50%=1600 ৳");
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Or handle back navigation as needed
            }
        });
        reviewButton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showReviewDialog();
            }
        });
    }
    private void showReviewDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_review);

        RatingBar ratingBar = dialog.findViewById(R.id.rating_bar);
        EditText feedbackText = dialog.findViewById(R.id.feedback_text);
        Button cancelButton = dialog.findViewById(R.id.cancel_button);
        Button submitButton = dialog.findViewById(R.id.submit_button);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle submit action, e.g., save the review to the database
                float rating = ratingBar.getRating();
                String feedback = feedbackText.getText().toString();
                // Save the rating and feedback
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
