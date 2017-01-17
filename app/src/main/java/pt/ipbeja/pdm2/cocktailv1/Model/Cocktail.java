package pt.ipbeja.pdm2.cocktailv1.Model;

import java.io.Serializable;

/**
 * Created by MLGDuck on 10/01/2017.
 */

public class Cocktail implements Serializable {

    private int cocktailId;
    private String cocktailTitle;
    private String cocktailIngre;
    private String cocktailPrep;

    public Cocktail(int cocktailId, String cocktailTitle, String cocktailIngre, String cocktailPrep) {
        this.cocktailId = cocktailId;
        this.cocktailTitle = cocktailTitle;
        this.cocktailIngre = cocktailIngre;
        this.cocktailPrep = cocktailPrep;
    }

    public int getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(int cocktailId) {
        this.cocktailId = cocktailId;
    }

    public String getCocktailTitle() {
        return cocktailTitle;
    }

    public void setCocktailTitle(String cocktailTitle) {
        this.cocktailTitle = cocktailTitle;
    }

    public String getCocktailIngre() {
        return cocktailIngre;
    }

    public void setCocktailIngre(String cocktailIngre) {
        this.cocktailIngre = cocktailIngre;
    }

    public String getCocktailPrep() {
        return cocktailPrep;
    }

    public void setCocktailPrep(String cocktailPrep) {
        this.cocktailPrep = cocktailPrep;
    }
}
