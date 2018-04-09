package org.unitec.mensajitoandroid;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {

    EditText textoTitulo,textoCuerpo;
    Button btnBuscar;
    Button btnGuardar;
    Button btnBuscarID;
    Button btnBorrar;
    Button btnActualizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoTitulo=findViewById(R.id.textoTitulo);
        textoCuerpo=findViewById(R.id.textoCuerpo);

        btnBuscar=findViewById(R.id.btnBuscar);
        btnGuardar=findViewById(R.id.btnGuardar);
        btnBuscarID=findViewById(R.id.btnBuscarID);
        btnBorrar=findViewById(R.id.btnBorrar);
        btnActualizar=findViewById(R.id.btnActualizar);

        String id=textoTitulo.getText().toString();
        String titulo=textoTitulo.getText().toString();
        String cuerpo=textoCuerpo.getText().toString();


        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TareaBuscarMensajes tareabuscar = new TareaBuscarMensajes();
                tareabuscar.execute(null,null,null);
            }
        });

        btnBuscarID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TareaBuscarUno tareabuscar = new TareaBuscarUno();
                tareabuscar.execute(null,null,null);
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TareaActualizarMensajes tareabuscar = new TareaActualizarMensajes();
                tareabuscar.execute(null,null,null);
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TareaBorrarMensajes tareabuscar = new TareaBorrarMensajes();
                tareabuscar.execute(null,null,null);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TareaGuardarMensajes tareabuscar = new TareaGuardarMensajes();
                tareabuscar.execute(null,null,null);
            }
        });

    }

    public class TareaBuscarMensajes extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }


        @Override
        protected String doInBackground(String... strings) {
            try {

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Mensajito[] mensajitos = restTemplate.getForObject("https://jc-unitec.herokuapp.com/api/mensajito", Mensajito[].class);
            } catch (Exception e) {
            }
            return null;
        }
    }

    public class TareaGuardarMensajes extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }


        @Override
        protected String doInBackground(String... strings) {
            try {

                String titulo=textoTitulo.getText().toString();
                String cuerpo=textoCuerpo.getText().toString();

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Mensajito mensajito = new Mensajito();
                mensajito.setCuerpo(cuerpo);
                mensajito.setTitulo(titulo);

                Estatus estatus = restTemplate.postForObject("https://jc-unitec.herokuapp.com/api/mensajito", mensajito, Estatus.class);

            } catch (Exception e) {

            }
            return null;
        }
    }

    public class TareaBorrarMensajes extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }


        @Override
        protected String doInBackground(String... strings) {
            try {

                String titulo=textoTitulo.getText().toString();
                String cuerpo=textoCuerpo.getText().toString();

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Mensajito mensajito = new Mensajito();
                mensajito.setCuerpo(cuerpo);
                mensajito.setTitulo(titulo);
                restTemplate.delete("https://jc-unitec.herokuapp.com/api/mensajito", mensajito, Estatus.class);

                Estatus estatus = new Estatus();
                estatus.setSuccess(true);
                estatus.setMsj("Mensaje borrado");


                //Estatus estatus = restTemplate.postForObject("https://jc-unitec.herokuapp.com/api/mensajito",mensajito,Estatus.class);
            } catch (Exception e) {

            }
            return null;
        }
    }

    public class TareaActualizarMensajes extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }


        @Override
        protected String doInBackground(String... strings) {
            try {

                String titulo=textoTitulo.getText().toString();
                String cuerpo=textoCuerpo.getText().toString();

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Mensajito mensajito = new Mensajito();
                mensajito.setCuerpo(cuerpo);
                mensajito.setTitulo(titulo);
                restTemplate.put("https://jc-unitec.herokuapp.com/api/mensajito", mensajito, Estatus.class);

                Estatus estatus = new Estatus();
                estatus.setSuccess(true);
                estatus.setMsj("Mensaje borrado");

            } catch (Exception e) {

            }

            return null;
        }

    }

    public class TareaBuscarUno extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }


        @Override
        protected String doInBackground(String... strings) {
            try {

                String titulo=textoTitulo.getText().toString();

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Mensajito mensajito = new Mensajito();
                mensajito.setTitulo(titulo);


                restTemplate.getForObject("https://jc-unitec.herokuapp.com/api/mensajito",mensajito,Estatus.class);

                Estatus estatus = new Estatus();
                estatus.setSuccess(true);
                estatus.setMsj("Mensaje borrado");

            } catch (Exception e) {

            }

            return null;
        }
    }
}

}