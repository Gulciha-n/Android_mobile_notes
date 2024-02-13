package com.example.artbookjava;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.Manifest.permission;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.Toast.Callback;

import com.example.artbookjava.databinding.ActivityArtBinding;
import com.example.artbookjava.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.net.URI;

public class ArtActivity extends AppCompatActivity {

    private ActivityArtBinding binding;
    ActivityResultLauncher<Intent> activityResultLauncher;
    ActivityResultLauncher<String> permissionLauncher;
    Bitmap selectedImageGallery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArtBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        registerLauncher();

    }

    public void save(View view){
    }
    public void selectImage(View view){

        if(Build.VERSION.SDK_INT >= VERSION_CODES.TIRAMISU ){
            //Android 33+ ise READ_EXTERNAL_STORAGE ise yaramaz READ_MEDIA_IMAGES kullanacagız.
            if(ContextCompat.checkSelfPermission(this, permission.READ_MEDIA_IMAGES) != getPackageManager().PERMISSION_GRANTED){

                //kullanıcıya açıklama göstermek zorunda mıyız onu kontrol ediyoruz.Android kendi kontrol ediyor
                if(ActivityCompat.shouldShowRequestPermissionRationale(this, permission.READ_MEDIA_IMAGES)){

                    //snackbar olusturduk ve buton ekledik
                    Snackbar.make(view,"Permission needed for gallery",Snackbar.LENGTH_INDEFINITE).setAction("Give Permission", new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //request permission
                            permissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES);

                        }
                    }).show();
                }
                else{
                    //request permission
                    permissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES);

                }
            }
            else{
                //permission granted
                //izin varsa galerye gidip görsel alıp gelecegız (PICK edecek)
                //Galerye gittikten sonra ne yapılacagını kontrol etmek icin ActivityResultLauncher kullanıyoruz
                Intent intentToGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityResultLauncher.launch(intentToGallery);

            }

        }
        else{
            //Android 32- READ_EXTERNAL_STORAGE kullanıyoruz
            if(ContextCompat.checkSelfPermission(this, permission.READ_EXTERNAL_STORAGE) != getPackageManager().PERMISSION_GRANTED){

                //kullanıcıya açıklama göstermek zorunda mıyız onu kontrol ediyoruz.Android kendi kontrol ediyor
                if(ActivityCompat.shouldShowRequestPermissionRationale(this, permission.READ_EXTERNAL_STORAGE)){

                    //snackbar olusturduk ve buton ekledik
                    Snackbar.make(view,"Permission needed for gallery",Snackbar.LENGTH_INDEFINITE).setAction("Give Permission", new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //request permission
                            permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);

                        }
                    }).show();
                }
                else{
                    //request permission
                    permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);

                }
            }
            else{
                //permission granted
                //izin varsa galerye gidip görsel alıp gelecegız (PICK edecek)
                //Galerye gittikten sonra ne yapılacagını kontrol etmek icin ActivityResultLauncher kullanıyoruz
                Intent intentToGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityResultLauncher.launch(intentToGallery);

            }
        }

        //Manifest dosyasına izin kontrolünü ekle : <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"></uses-permission>


    }

    //registerLauncher metodunda activityResultLauncher  ve permissionLauncher'ı registerForActivityResult kullanarak register islemini yapalım
    private void registerLauncher(){

        //go to the gallery
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                if (result.getResultCode() == RESULT_OK){
                    Intent intentFromResult =  result.getData();
                    if(intentFromResult != null){
                        Uri imageData =  intentFromResult.getData(); //uri of data
                        //binding.selectImage.setImageURI(imageData); //we need the data , not where it's stored. we will add to the database

                        //convert data(uri) to bitmap
                        //galeryden alacagımız gorseli bitmap'e ceviriyoruz
                        try {
                            if(Build.VERSION.SDK_INT >=28){
                                ImageDecoder.Source source = ImageDecoder.createSource(ArtActivity.this.getContentResolver(),imageData);
                                selectedImageGallery = ImageDecoder.decodeBitmap(source);
                                binding.selectImage.setImageBitmap(selectedImageGallery);
                            }
                            else {
                                selectedImageGallery = MediaStore.Images.Media.getBitmap(ArtActivity.this.getContentResolver(),imageData);
                                
                            }

                        }
                        catch (Exception exception){
                            exception.printStackTrace(); //show all error message in logcat

                        }
                    }
                }
            }
        });

        //ask permission
        permissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {

                if(result){
                    //permission granted , go to gallery
                    Intent intentToGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    activityResultLauncher.launch(intentToGallery);

                }
                else{
                    //permission denied
                    Toast.makeText(ArtActivity.this, "Permission needed", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
