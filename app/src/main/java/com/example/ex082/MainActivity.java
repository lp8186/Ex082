package com.example.ex082;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    TextView capitalCity,size,language,song;
    ListView country;
    Spinner mainland;
    String [][] countries= new String[4][8];
    String [][][] information= new String[4][7][4];
    int remember;
    String[] n = {"country1","country2","country3","country4","coutry5","country6","country7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        capitalCity = (TextView) findViewById(R.id.capitalCity);
        size = (TextView) findViewById(R.id.size);
        language = (TextView) findViewById(R.id.language);
        song = (TextView) findViewById(R.id.song);
        country = (ListView) findViewById(R.id.country);
        mainland = (Spinner) findViewById(R.id.mainland);


        countries[0]= new String[]{"Nepal", "China", "India", "Japan", "Iran", "Lebanon", "Singapore"};
        countries[1]= new String[]{"Brazil", "Mexico", "Colombia", "Argentina", "Canada", "Peru", "Chile"};
        countries[2]= new String[]{"Nigeria", "Ethiopia", "Kenya", "Algeria", "Sudan", "Zimbabwe", "Tanzania"};
        countries[3]= new String[]{"France", "Poland", "Italy", "Germany", "Spain", "Portugal", "Sweden"};

        information[0][0]= new String[]{"Kathmando","29,136,808","Nepali","Sayaun Thunga Phulka"};
        information[0][1]= new String[]{"Bijing","1,439,323,776","Stundard Chinese","March of the Volunteer"};
        information[0][2]= new String[]{"New Delhi","1,380,004,385","Hindi","Vande Mataram"};
        information[0][3]= new String[]{"Tokyo","126,476,461","Japanese","Kimigayo"};
        information[0][4]= new String[]{"Teharan","83,992,949","Persian","National Anthem of the Islamic Republic of Iran"};
        information[0][5]= new String[]{"Beirut","6,825,445","Arabic","Lebanese National Anthem"};
        information[0][6]= new String[]{"None","5,850,342","English","Majulah Singapura"};

        information[1][0]= new String[]{"Brasilia","212,559,417","Portuguese","Brazilian National Anthem"};
        information[1][1]= new String[]{"Mexico City","128,932,753","Spanish","Himno National Mexicano"};
        information[1][2]= new String[]{"Bogota","50,882,891","Spanish","National Anthem of the Republic of Colombia"};
        information[1][3]= new String[]{"Buenos Aires","45,195,774","Spanish","Argentine National Anthem"};
        information[1][4]= new String[]{"Ottawa","37,742,154","English","O Canada"};
        information[1][5]= new String[]{"Lima","32,971,854","Spanish","Himno National del Peru"};
        information[1][6]= new String[]{"Santiago","19,116,201","Spanish","National Anthem of Chile"};

        information[2][0]= new String[]{"Abuja","206,139,589","too many","Arise, O Compatriots"};
        information[2][1]= new String[]{"Adiss Ababa","114,963,588","Amharic","Ethiopia, Be Happy"};
        information[2][2]= new String[]{"Nairobi","53,771,296","Swahili","O God, of all Creation"};
        information[2][3]= new String[]{"Algiers","43,851,044","Arabic","Kassaman"};
        information[2][4]= new String[]{"Khartoum","43,849,260","Arabic","We Are the Soldiers of God, the Soldiers of our Homeland"};
        information[2][5]= new String[]{"Harare","14,862,924","too many","O lift high, high, our flag of Zimbabwe"};
        information[2][6]= new String[]{"Dodoma","59,734,218","Swahili","God bless Africa"};

        information[3][0]= new String[]{"Paris","65,273,511","French","La Marseillaise"};
        information[3][1]= new String[]{"Warsaw","37,846,611","Polish","Poland is not yet lost"};
        information[3][2]= new String[]{"Rome","60,461,826","Italian","Il Canto degli Italiani"};
        information[3][3]= new String[]{"Berlin", "83,783,942","German","Deutschlandlied"};
        information[3][4]= new String[]{"Madrid", "46,754,778","Spanish","Mrcha Real"};
        information[3][5]= new String[]{"Lisbon","10,196,709","Portuguese","A Portugesa"};
        information[3][6]= new String[]{"Stockholm","10,099,265","Swedish","Du gamla, du fria"};

        ArrayAdapter<String> adp2 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.continents));
        mainland.setAdapter(adp2);

        mainland.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (remember!=0) {
            capitalCity.setText(information[remember-1][position][0]);
            size.setText(information[remember-1][position][1]);
            language.setText(information[remember-1][position][2]);
            song.setText(information[remember-1][position][3]);
        }





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position!=0) {
            ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, countries[position - 1]);
            country.setAdapter(adp);

            country.setOnItemClickListener(this);

        }
        else {
            ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,n);
            country.setAdapter(adp);

            country.setOnItemClickListener(this);

            capitalCity.setText("Capital City");
            size.setText("Population Size");
            language.setText("Language");
            song.setText("Anthem");
        }
        remember= position;


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


