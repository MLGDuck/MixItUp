package pt.ipbeja.pdm2.cocktailv1;

import android.app.Activity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pt.ipbeja.pdm2.cocktailv1.Model.Cocktail;

/**
 * Created by MLGDuck on 10/01/2017.
 */

public class Data extends Activity implements Serializable {
    private List<Cocktail> cocktails = new ArrayList<Cocktail>();
    private Cocktail cocktail = null;
    private static Data instance = null;


    public Data(List<Cocktail> cocktails, Cocktail cocktail) {
        this.cocktails = cocktails;
        this.cocktail = cocktail;
    }

    public Data() {
        //this.insertListCocktails();
    }

    public static Data getInstance() {
        if(Data.instance == null) {
            Data.instance = new Data();
        }
        return Data.instance;
    }

    public List<Cocktail> getCocktails() {
        return cocktails;
    }

    public void setCocktails(List<Cocktail> cocktails) {
        this.cocktails = cocktails;
    }

    public Cocktail getCocktail() {
        return cocktail;
    }

    public void setCocktail(Cocktail cocktail) {
        this.cocktail = cocktail;
    }

    public static void setInstance(Data instance) {
        Data.instance = instance;
    }


}
