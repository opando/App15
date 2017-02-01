package pe.com.opm.app15;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImagenActivity extends AppCompatActivity {


    ImageView foto;
    Button openCamara;

    public static final Integer CAMERA_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);

        //Dialog dialog = new AlertDialog.Builder(this).setTitle("").show();

        foto = (ImageView)findViewById(R.id.iv_foto);
        openCamara = (Button) findViewById(R.id.btn_abrirCamara);

        openCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCamera,CAMERA_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Bitmap bmFoto = (Bitmap)data.getExtras().get("data");
            foto.setImageBitmap(bmFoto);
        }
    }
}
