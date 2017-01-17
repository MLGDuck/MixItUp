package pt.ipbeja.pdm2.cocktailv1.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import pt.ipbeja.pdm2.cocktailv1.Data;
import pt.ipbeja.pdm2.cocktailv1.DataBase;
import pt.ipbeja.pdm2.cocktailv1.Model.Cocktail;
import pt.ipbeja.pdm2.cocktailv1.Model.Cocktail_List_Adapter;
import pt.ipbeja.pdm2.cocktailv1.Model.DataInterface;
import pt.ipbeja.pdm2.cocktailv1.R;



/**
 * A simple {@link Fragment} subclass.
 */
public class Cocktail_list extends Fragment {

    OnCocktailSelectedListener mCallback;
    ListView listViewvCategories;
    Data data = null;
    DataBase db = null;
    private final int REQUEST_CODE = 0;
    private List<Cocktail> cocktails;
    Cocktail_List_Adapter adapter;




    public Cocktail_list() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DataInterface){
            this.data = ((DataInterface) context).getData();
        }else{

            throw new RuntimeException(context.toString()
                    + "must implement IData");
        }

        try {
            mCallback = (Cocktail_list.OnCocktailSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement Listener");}


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cocktail_list, container, false);



        //this.db = new DBHelper(DishCategoryFragment.this.getContext());

        //this.categories = this.db.getAllCategories();

        db = new DataBase(this.getContext());

        this.cocktails= db.getAllCocktails();

                listViewvCategories = (ListView) rootView.findViewById(R.id.ListView_Cocktail);
        adapter = new Cocktail_List_Adapter(getActivity(), 1, cocktails);
        listViewvCategories.setAdapter(adapter);
        listViewvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Cocktail c = Cocktail_list.this.cocktails.get(position);

               Cocktail_list.this.data.setCocktail(c);

                mCallback.onCocktailSelected(position);


            }
        });


        return rootView;
    }

    public interface OnCocktailSelectedListener {
        public void onCocktailSelected(int position);
    }

}
