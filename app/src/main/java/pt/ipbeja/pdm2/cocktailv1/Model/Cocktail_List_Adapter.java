package pt.ipbeja.pdm2.cocktailv1.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import pt.ipbeja.pdm2.cocktailv1.DataBase;
import pt.ipbeja.pdm2.cocktailv1.R;

import static java.security.AccessController.getContext;

/**
 * Created by MLGDuck on 10/01/2017.
 */

public class Cocktail_List_Adapter extends ArrayAdapter<Cocktail> {
    public List<Cocktail> cocktails;
    DataBase db = null;


    public Cocktail_List_Adapter(Context context, int resource, List<Cocktail> objects) {
        super(context, resource, objects);
        this.cocktails=objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        db = new DataBase(this.getContext());

        View rowView = inflater.inflate(R.layout.cocktail_item, parent, false);

        TextView txtCategory = (TextView) rowView.findViewById(R.id.txtCocktailName);
        //txtCategory.setText("" + this.cocktails.get(position).getCocktailTitle());
        txtCategory.setText("" + this.db.getAllCocktailsTitles().get(position));

        return rowView;
    }
}
