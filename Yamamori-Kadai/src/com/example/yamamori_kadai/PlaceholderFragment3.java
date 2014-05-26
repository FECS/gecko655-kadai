package com.example.yamamori_kadai;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class PlaceholderFragment3 extends Fragment {
	final private static int REQUEST_CODE = 0x655;
	private ImageView image;
	private View rootView;

	public PlaceholderFragment3() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.image_fragment, container,
				false);
		image = (ImageView)rootView.findViewById(R.id.image);
		image.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				startActivityForResult(intent, REQUEST_CODE);
				
			}
			
		});
		return rootView;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
        Context context = rootView.getContext();
        if(requestCode == REQUEST_CODE&&resultCode==Activity.RESULT_OK){
            try {
                if(context!=null&&image!=null){
                    InputStream in = context.getContentResolver().openInputStream(data.getData());
                    Bitmap img=BitmapFactory.decodeStream(in);
                    in.close();
                    image.setImageBitmap(img);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
