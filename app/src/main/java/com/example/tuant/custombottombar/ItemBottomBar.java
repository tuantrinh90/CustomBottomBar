package com.example.tuant.custombottombar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.LinearLayout;


public class ItemBottomBar extends LinearLayout {

    AppCompatImageView icBottom;
    Drawable drawableNormal, drawableActive;
    int colorNomar, colorActive;
    AppCompatTextView txtCustom;
    String txtTextview;
    LinearLayout linearLayout;
    int colorBackground;

    public ItemBottomBar(Context context) {
        super(context);
        init(context, null);
    }

    public ItemBottomBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ItemBottomBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.item_bottom_bar, this);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Custom_Bottom_Bar);

        drawableNormal = typedArray.getDrawable(R.styleable.Custom_Bottom_Bar_drawable_normal);
        drawableActive = typedArray.getDrawable(R.styleable.Custom_Bottom_Bar_drawable_active);
        boolean isActive = typedArray.getBoolean(R.styleable.Custom_Bottom_Bar_isCheckDrawableActive, false);
        colorBackground = typedArray.getColor(R.styleable.Custom_Bottom_Bar_colorBackground, 0);

        txtTextview = typedArray.getString(R.styleable.Custom_Bottom_Bar_txt_custom);
        colorNomar = typedArray.getColor(R.styleable.Custom_Bottom_Bar_color_txt_normal,
                ContextCompat.getColor(context, R.color.white));
        colorActive = typedArray.getColor(R.styleable.Custom_Bottom_Bar_color_txt_active,
                ContextCompat.getColor(context, R.color.colorPrimary));
        boolean isCheckColor = typedArray.getBoolean(R.styleable.Custom_Bottom_Bar_isColor, false);

        icBottom = findViewById(R.id.ic_bottom);
        txtCustom = findViewById(R.id.txtBottom);
        linearLayout = findViewById(R.id.color_background);

        setActiveIcon(isActive);
        setActiveTextView(isCheckColor);
        setBackgroundActive(colorBackground);

        typedArray.recycle();

    }

    public void setActiveIcon(boolean isActive) {
        icBottom.setImageDrawable(isActive ? drawableActive : drawableNormal);
    }

    public void setActiveTextView(boolean activeTextView) {
        txtCustom.setTextColor(activeTextView ? colorActive : colorNomar);
        txtCustom.setText(txtTextview);
    }

    public void setBackgroundActive(int backgroundActive) {
        linearLayout.setBackgroundColor(backgroundActive);
    }
}
