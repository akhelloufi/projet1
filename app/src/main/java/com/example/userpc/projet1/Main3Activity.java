package com.example.userpc.projet1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;

public class Main3Activity extends AppCompatActivity {

    ImageView imgtake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imgtake=findViewById(R.id.imageView1);
    }

    public void gogo(View view) {
        Bundle x=new Bundle();
        x.putString("cle1","amine");
        Intent i=new Intent(this,Main4Activity.class);
        i.putExtra("bund1",x);
        startActivity(i);
    }
    int requestCode;
    Uri fileUri;
    String mCurrentPhotoPath;
    int REQUEST_TAKE_PHOTO=4;
    public void takeph(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            File file = null;
            try {
                file = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }

            startActivityForResult(intent, REQUEST_TAKE_PHOTO);
        }
    }

    // copied from the android development pages; just added a Toast to show the storage location
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        Toast.makeText(this, mCurrentPhotoPath, Toast.LENGTH_LONG).show();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultcode, Intent intent) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultcode == RESULT_OK) {
            Uri uri = intent.getData();
            Bitmap bitmap = null;
            try { 
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            imgtake.setImageBitmap(bitmap);
        }
    }
}
