package pt.ipbeja.pdm2.cocktailv1.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pt.ipbeja.pdm2.cocktailv1.Data;
import pt.ipbeja.pdm2.cocktailv1.DataBase;
import pt.ipbeja.pdm2.cocktailv1.Model.Cocktail;
import pt.ipbeja.pdm2.cocktailv1.Model.DataInterface;
import pt.ipbeja.pdm2.cocktailv1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Cocktail_info extends Fragment {
    Data data = null;
    DataBase db = null;

    public Cocktail_info() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cocktail_info, container, false);

       db = new DataBase(this.getContext());

//        int position = getArguments().getInt("position");


        if (data != null) {
            Cocktail cocktail = Cocktail_info.this.data.getCocktail();

            if (cocktail != null) {

                TextView txtTitle = (TextView) view.findViewById(R.id.txtinfoTitle);

                txtTitle.setText(cocktail.getCocktailTitle());


                    TextView txtIngradients = (TextView) view.findViewById(R.id.txtIngredients);
                    txtIngradients.setText(cocktail.getCocktailIngre());

                    TextView txtMthodPreparation = (TextView) view.findViewById(R.id.txtMethodPreparation);
                    txtMthodPreparation.setText(cocktail.getCocktailPrep());

                }

        }
        return view;

    }

    @Override
    public void onAttach(Context context) {
        if (context instanceof DataInterface){
            this.data = ((DataInterface) context).getData();
        }else{

            throw new RuntimeException(context.toString()
                    + "must implement IData");
        }
        super.onAttach(context);


    }
    public void updateDescriptionView() {

        View view = getView();

        if (data != null) {
            Cocktail cocktail = Cocktail_info.this.data.getCocktail();

            if (cocktail != null) {

                TextView txtTitle = (TextView) view.findViewById(R.id.txtinfoTitle);
                txtTitle.setText(cocktail.getCocktailTitle());


                //ImageView imgDescription = (ImageView) view.findViewById(R.id.imgViewDescription);
                //imgDescription.setImageResource(dishName.getImgDish());


                if (data.getCocktail() != null) {

                    TextView txtIngradients = (TextView) view.findViewById(R.id.txtIngredients);
                    txtIngradients.setText(cocktail.getCocktailIngre());

                    TextView txtMthodPreparation = (TextView) view.findViewById(R.id.txtMethodPreparation);
                    txtMthodPreparation.setText(cocktail.getCocktailPrep());

                }
            }
        }

    }
}
