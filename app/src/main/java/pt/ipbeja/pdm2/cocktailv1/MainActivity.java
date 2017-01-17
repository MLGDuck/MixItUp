package pt.ipbeja.pdm2.cocktailv1;

import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import pt.ipbeja.pdm2.cocktailv1.Fragments.Cocktail_info;
import pt.ipbeja.pdm2.cocktailv1.Fragments.Cocktail_list;
import pt.ipbeja.pdm2.cocktailv1.Model.Cocktail;
import pt.ipbeja.pdm2.cocktailv1.Model.DataInterface;


public class MainActivity extends FragmentActivity implements  Cocktail_list.OnCocktailSelectedListener, DataInterface {

    private static Data data = Data.getInstance();
    Cocktail_list cocktail_list = null;
    Cocktail_info cocktail_info = null;
    DataBase dataBase = null;
    private ArrayList<String> cocktailtile = null;
    private Cocktail cocktail = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        dataBase = new DataBase(this);
        this.insertdatabase();
        this.cocktailtile =(ArrayList<String>) dataBase.getAllCocktailsTitles();
        //this.cocktail= dataBase.GetCocktail();


        if (findViewById(R.id.container) != null) {

            if (savedInstanceState != null) {
                return;
            }


            Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Cocktail_list list = new Cocktail_list();
            fragmentTransaction.add(R.id.container, list, "COCKTAILLIST");
            fragmentTransaction.commit();


        }
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(R.layout.activity_main);

    }
    public Data getData(){

        return MainActivity.data;

    }

    public void onCocktailSelected(int position) {

        if ((findViewById(R.id.container) != null)){ //|| ((findViewById(R.id.container) == null))){


            this.cocktail_info = new Cocktail_info();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            cocktail_info.setArguments(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, cocktail_info);
            transaction.addToBackStack(null);
            transaction.commit();

        }
        else{
            Cocktail_info cocktailInfo = (Cocktail_info)

                    getSupportFragmentManager().findFragmentById(R.id.detalhes);
            cocktailInfo.updateDescriptionView();


        }
    }
    public void insertdatabase()
    {   int id = 0;
        String name = "Apple Martini";

        String ingred = "1 Part Absolut Vodka\n " +
                "⅔ Part Apple Juice, Fresh Pressed\n " +
                "⅔ Part Apple Liqueur\n " +
                "⅓ Part Lemon Juice\n " +
                "⅓ Part Simple Syrup\n " +
                "1 Slice Apple ";

        String prep = "Fill a shaker with ice cubes.\n" +
                "Add all ingredients.\n" +
                "Shake and strain into a chilled cocktail glass.\n" +
                "Garnish with apple.";

        Cocktail cocktail = new Cocktail(id, name, ingred, prep);
        dataBase.insertcocktails(cocktail);
        id++;


        name ="Cosmopolitan";
        ingred="1 ½ Parts Absolut Citron\n" +
                "⅓ Part Lime Juice\n" +
                "½ Part Triple Sec\n" +
                "⅔ Part Cranberry Juice\n" +
                "1 Twist Orange";
        prep="Fill a shaker with ice cubes.\n" +
                "Add all ingredients.\n" +
                "Shake and strain into a chilled cocktail glass.\n" +
                "Garnish with orange.";
        cocktail = new Cocktail(id, name, ingred, prep );
        dataBase.insertcocktails(cocktail);
        id++;


        name ="Long Island Iced Tea";
        ingred="⅔ Part Absolut Vodka\n" +
                "⅔ Part Light Rum\n" +
                "1 ⅓ Parts Lemon Juice\n" +
                "⅔ Part Gin\n" +
                "⅔ Part Tequila Blanco\n" +
                "⅔ Part Triple Sec\n" +
                "1 ⅓ Parts Cola\n" +
                "1 Wedge Lime";
        prep="Fill a highball glass with ice cubes.\n" +
                "Add all ingredients.\n" +
                "Garnish with lime.";
       cocktail = new Cocktail(id, name, ingred, prep );
        dataBase.insertcocktails(cocktail);
        id++;






    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_photo:
                return true;

            default:

                return super.onOptionsItemSelected(item);

        }
    }

    public void photo_onClick(MenuItem item) {


    }*/
}
