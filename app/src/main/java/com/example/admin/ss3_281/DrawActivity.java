package com.example.admin.ss3_281;

import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

public class DrawActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "DrawActivity";
    private ImageView ivColor;
    private ImageView ivDone;
    private RadioButton rdThin;
    private RadioButton rdMedium;
    private RadioButton rdStrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        setupUI();
    }
    private void setupUI(){
        ivColor = findViewById(R.id.iv_color);
        ivDone  = findViewById(R.id.iv_done);
        rdThin  = findViewById(R.id.rb_thin);
        rdMedium  = findViewById(R.id.rb_medium);
        rdStrong  = findViewById(R.id.rb_strong);

        ivColor.setOnClickListener(this);
        rdThin.setOnClickListener(this);
        rdMedium.setOnClickListener(this);
        rdStrong.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_color:{
                ColorPickerDialogBuilder
                        .with(this)
                        .setTitle("Choose color")
                        .initialColor(ContextCompat.getColor(this, R.color.colorAccent))
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .density(15)
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {
                                Log.d(TAG, "onColorSelected: " + selectedColor);
                            }
                        })
                        .setPositiveButton("Ok", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .build()
                        .show();
                break;
            }
            case R.id.iv_done:{

                break;
            }

            case R.id.rb_thin:
                Log.d(TAG, "onClick: Thin");
                break;
            case R.id.rb_medium:
                Log.d(TAG, "onClick: Medium");
                break;
            case R.id.rb_strong:
                Log.d(TAG, "onClick: Strong");
                break;
           
        }
    }

}
