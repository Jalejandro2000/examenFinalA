package com.example.examenfinal.modelo;

import android.content.Context;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenfinal.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import org.json.JSONException;
import org.json.JSONObject;

@NonReusable
@Layout(R.layout.row_issue)

public class Revistas {
    // Acciones para cambiar los valores por la API
    @View(R.id.txtTitle)
    TextView txtTitulo;

    @View(R.id.txtDescripcion)
    TextView txtVolumen;

    @View(R.id.imgPortada)
    ImageView imagen;

/*    @Click(R.id.btnVerRevista)
    public void onRevistaViewClick() {
        try {
            Intent intent = new Intent(ctx.getApplicationContext(), UserAdapter.class);

            Bundle cambio_app = new Bundle();
            cambio_app.putString("journal_id", obj_revista_json.getString("journal_id"));
            intent.putExtras(cambio_app);
            ctx.startActivity(intent);

        } catch (JSONException ex) {
        }
    }*/

    Context ctx;
    JSONObject obj_revista_json;

    // Constructor que recibira el context de la aplicación y un JSONObjet
    public Revistas(Context context, JSONObject item_obj_revista) {
        ctx = context;
        obj_revista_json = item_obj_revista;
    }

    // Lectura de la API y cambiandolo al layout creado
    @Resolve
    protected void onResolved() {
        try {
            // Html.fromHtml() "Sirve para convertir HTML en texto normal"
            this.txtTitulo.setText(Html.fromHtml(obj_revista_json.getString("name")));
            this.txtVolumen.setText(Html.fromHtml(obj_revista_json.getString("description")));
            Glide.with(ctx).load(obj_revista_json.getString("portada"))
                    .into(imagen);
        } catch (JSONException ex) {
        }
    }
}
