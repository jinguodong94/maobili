package com.example.maoboli;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
public class MainActivity extends Activity {
	private ImageView mImageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mImageView = (ImageView) findViewById(R.id.imageview);
		initBitmap();
	}
	private void initBitmap() {
		Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.me);
		int scaleRatio = 20;
		int blurRadius = 8;
		Bitmap scaledBitmap = Bitmap.createScaledBitmap(decodeResource,
				decodeResource.getWidth() / scaleRatio,
				decodeResource.getHeight() / scaleRatio,
		    false);
		Bitmap blurBitmap = FastBlur.doBlur(scaledBitmap, blurRadius, true);
		mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		mImageView.setImageBitmap(blurBitmap);
	}
}
