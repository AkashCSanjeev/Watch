package com.example.watch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.example.watch.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Values");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                HashMap<String, Object> data = (HashMap<String, Object>) dataSnapshot.getValue();

                binding.rateText.setText(""+data.get("HeartRate")+" bpm");
                binding.temptext.setText(""+data.get("BodyTemperature")+ " \u00B0 C");
                binding.lightText.setText(""+data.get("Light")+" lux");
                binding.oxyText.setText(""+data.get("OxygenSaturation")+" %");
                binding.soundText.setText(""+data.get("Sound")+ " dB");
                binding.touchText.setText(""+data.get("Touch")+ " sec");

                Log.d("ErrorMain", "Value  is: " + data.get("Sound"));

                if(data.get("HeartRate").getClass() == Double.class &&((double)data.get("HeartRate") < 60 || (double)data.get("HeartRate")>100)){
                    binding.heartCard.setCardBackgroundColor(Color.parseColor("#880808"));
                    binding.rateText.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.heartLabel.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.rateImage.setImageDrawable(getDrawable(R.drawable.heart_rate_white));

                } else if(data.get("HeartRate").getClass() == Long.class && ((long)data.get("HeartRate") < 60 || (long)data.get("HeartRate")>100)){
                    binding.heartCard.setCardBackgroundColor(Color.parseColor("#880808"));
                    binding.rateText.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.heartLabel.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.rateImage.setImageDrawable(getDrawable(R.drawable.heart_rate_white));

                } else {
                    binding.heartCard.setCardBackgroundColor(Color.parseColor("#AFE1AF"));
                    binding.rateText.setTextColor(Color.parseColor("#0f0f0f"));
                    binding.heartLabel.setTextColor(Color.parseColor("#0f0f0f"));
                    binding.rateImage.setImageDrawable(getDrawable(R.drawable.heart_rate_black));

                }

                if(data.get("BodyTemperature").getClass() == Double.class &&((double)data.get("BodyTemperature") < 36.1 || (double)data.get("BodyTemperature")>37.2)){
                    binding.tempCard.setCardBackgroundColor(Color.parseColor("#880808"));
                    binding.temptext.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.tempLabel.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.tempImage.setImageDrawable(getDrawable(R.drawable.temp_white));

                }else if(data.get("BodyTemperature").getClass() == Long.class &&((long)data.get("BodyTemperature") < 36.1 || (long)data.get("BodyTemperature")>37.2)){
                    binding.tempCard.setCardBackgroundColor(Color.parseColor("#880808"));
                    binding.temptext.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.tempLabel.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.tempImage.setImageDrawable(getDrawable(R.drawable.temp_white));
                }
                else {
                    binding.tempCard.setCardBackgroundColor(Color.parseColor("#AFE1AF"));
                    binding.temptext.setTextColor(Color.parseColor("#0f0f0f"));
                    binding.tempLabel.setTextColor(Color.parseColor("#0f0f0f"));
                    binding.tempImage.setImageDrawable(getDrawable(R.drawable.temp_black));

                }

                if(data.get("Light").getClass() == Double.class && (double)data.get("Light") < 100 ){
                    binding.Lightcard.setCardBackgroundColor(Color.parseColor("#880808"));
                    binding.lightText.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.lightLabel.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.lightImage.setImageDrawable(getDrawable(R.drawable.light_white));

                }else if(data.get("Light").getClass() == Long.class && (long)data.get("Light") < 100){
                    binding.Lightcard.setCardBackgroundColor(Color.parseColor("#880808"));
                    binding.lightText.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.lightLabel.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.lightImage.setImageDrawable(getDrawable(R.drawable.light_white));

                }
                else {
                    binding.Lightcard.setCardBackgroundColor(Color.parseColor("#AFE1AF"));
                    binding.lightText.setTextColor(Color.parseColor("#0f0f0f"));
                    binding.lightLabel.setTextColor(Color.parseColor("#0f0f0f"));
                    binding.lightImage.setImageDrawable(getDrawable(R.drawable.light_black));


                }

                if(data.get("OxygenSaturation").getClass() == Double.class && (double)data.get("OxygenSaturation") < 95){
                    binding.oxyCard.setCardBackgroundColor(Color.parseColor("#880808"));
                    binding.oxyText.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.oxyLabel.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.oxyImage.setImageDrawable(getDrawable(R.drawable.oxygen_white));


                }else if(data.get("OxygenSaturation").getClass() == Long.class && (long)data.get("OxygenSaturation") < 95){
                    binding.oxyCard.setCardBackgroundColor(Color.parseColor("#880808"));
                    binding.oxyText.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.oxyLabel.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.oxyImage.setImageDrawable(getDrawable(R.drawable.oxygen_white));

                }else {
                    binding.oxyCard.setCardBackgroundColor(Color.parseColor("#AFE1AF"));
                    binding.oxyText.setTextColor(Color.parseColor("#0f0f0f"));
                    binding.oxyLabel.setTextColor(Color.parseColor("#0f0f0f"));
                    binding.oxyImage.setImageDrawable(getDrawable(R.drawable.oxygen_black));


                }

                if(data.get("Sound").getClass() == Double.class && (double)data.get("Sound")>45){
                    binding.soundCard.setCardBackgroundColor(Color.parseColor("#880808"));
                    binding.soundText.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.soundLabel.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.soundImage.setImageDrawable(getDrawable(R.drawable.sound_white));


                }
                else if(data.get("Sound").getClass() == Long.class && (long)data.get("Sound")>45){
                    binding.soundCard.setCardBackgroundColor(Color.parseColor("#880808"));
                    binding.soundText.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.soundLabel.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.soundImage.setImageDrawable(getDrawable(R.drawable.sound_white));

                }
                else {
                    binding.soundCard.setCardBackgroundColor(Color.parseColor("#AFE1AF"));
                    binding.soundText.setTextColor(Color.parseColor("#0f0f0f"));
                    binding.soundLabel.setTextColor(Color.parseColor("#0f0f0f"));
                    binding.soundImage.setImageDrawable(getDrawable(R.drawable.sound_black));


                }

                if(data.get("Touch").getClass() == Double.class && (double)data.get("Touch") < 20){
                    binding.touchCard.setCardBackgroundColor(Color.parseColor("#880808"));
                    binding.touchLabel.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.touchText.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.touchImage.setImageDrawable(getDrawable(R.drawable.touch_white));


                }else if(data.get("Touch").getClass() == Long.class && (long)data.get("Touch") < 20){
                    binding.touchCard.setCardBackgroundColor(Color.parseColor("#880808"));
                    binding.touchLabel.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.touchText.setTextColor(Color.parseColor("#DAF7A6"));
                    binding.touchImage.setImageDrawable(getDrawable(R.drawable.touch_white));

                }
                else {
                    binding.touchCard.setCardBackgroundColor(Color.parseColor("#AFE1AF"));
                    binding.touchText.setTextColor(Color.parseColor("#0f0f0f"));
                    binding.touchLabel.setTextColor(Color.parseColor("#0f0f0f"));
                    binding.touchImage.setImageDrawable(getDrawable(R.drawable.touch_black));


                }






            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("ErrorMain", "Failed to read value.", error.toException());
            }
        });
    }
}