package com.upayogisewa.guruparampara.gpmain.activities.Jyotishes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;
import com.upayogisewa.guruparampara.R;
import com.upayogisewa.guruparampara.gpmain.activities.MainActivities.BaseActivity;
import com.upayogisewa.guruparampara.utils.SharedPref;

public class AbakahadChakra extends BaseActivity {

    TextView m_nakshtra, m_rashi,m_rashiSwami,m_varna,m_vashya,m_yoni, m_vairayoni,m_gana,m_nadi,m_aasana,kutafal;
    TextView f_nakshtra, f_rashi,f_rashiSwami,f_varna,f_vashya,f_yoni, f_vairayoni,f_gana,f_nadi,f_aasana, m_guna;
    Boolean m_aswini=false,m_bharani=false,m_kritika1=false,m_kritika3=false,m_rohini=false,m_mrigaA2=false,m_mrigaB2=false,m_aadra=false,m_punarvasu3=false,m_punarvasu1=false,m_tisya=false,m_ashlesha=false,m_magha=false,m_pufa=false,m_ufa1=false,m_ufa3=false,m_hasta=false,
            m_chitraA2=false,m_chitraB2=false,m_swati=false,m_vishakha3=false,m_vishakha1=false,m_anuradha=false,m_jestha=false,m_mula=false,m_pusha1=false,m_pusha3=false,m_usha1=false,m_usha3=false,m_shravana=false,m_dhanisthaA2=false,
            m_dhanisthaB2=false,m_shatavisha=false,m_pubha3=false,m_pubha1=false,m_ubha=false,m_revati=false;

   Boolean f_aswini=false,f_bharani=false,f_kritika1=false,f_kritika3=false,f_rohini=false,f_mrigaA2=false,f_mrigaB2=false,f_aadra=false,f_punarvasu3=false,f_punarvasu1=false,f_tisya=false,f_ashlesha=false,f_magha=false,f_pufa=false,f_ufa1=false,f_ufa3=false,f_hasta=false,
           f_chitraA2=false,f_chitraB2=false,f_swati=false,f_vishakha3=false,f_vishakha1=false,f_anuradha=false,f_jestha=false,f_mula=false,f_pusha1=false,f_pusha3=false,f_usha1=false,f_usha3=false,f_shravana=false,f_dhanisthaA2=false,
           f_dhanisthaB2=false,f_shatavisha=false,f_pubha3=false,f_pubha1=false,f_ubha=false,f_revati=false;
   String f_cr,f_cl, m_cr,m_cl;
    Spinner m_chooseNak, m_chooseLatter,f_chooseNak, f_chooseLatter;
    SharedPref sharedPref;
    int clickCount = 0;
    private Handler handler;
    private TextView textView;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abakahad_chakra);

        initToolbar(true);
        setToolbarTitle(getResources().getString(R.string.hora_chakra));
        enableUpButton();
        prepareAds();
        sharedPref = new SharedPref(this);
        sharedPref.setIntersCounter(clickCount);
        delayShowInsAds();

        m_nakshtra = findViewById(R.id.m_nakshatraName);
        m_rashi = findViewById(R.id.m_rashiName);
        m_rashiSwami = findViewById(R.id.m_rahshiSwamiName);
        m_varna = findViewById(R.id.m_varnaName);
        m_vashya = findViewById(R.id.m_vashyaName);
        m_yoni = findViewById(R.id.m_yoniName);
        m_vairayoni = findViewById(R.id.m_vairaYoniName);
        m_gana = findViewById(R.id.m_ganaName);
        m_nadi = findViewById(R.id.m_nadiName);
        m_aasana = findViewById(R.id.m_asanaName);
        m_guna = findViewById(R.id.m_guna);

        f_nakshtra = findViewById(R.id.f_nakshatraName);
        f_rashi = findViewById(R.id.f_rashiName);
        f_rashiSwami = findViewById(R.id.f_rahshiSwamiName);
        f_varna = findViewById(R.id.f_varnaName);
        f_vashya = findViewById(R.id.f_vashyaName);
        f_yoni = findViewById(R.id.f_yoniName);
        f_vairayoni = findViewById(R.id.f_vairaYoniName);
        f_gana = findViewById(R.id.f_ganaName);
        f_nadi = findViewById(R.id.f_nadiName);
        f_aasana = findViewById(R.id.f_asanaName);

        spinnerPicker();

    }

    public void spinnerPicker(){
        m_chooseNak = findViewById(R.id.m_choseNakshtra);
        m_chooseLatter = findViewById(R.id.m_chooseLatter);

        f_chooseNak = findViewById(R.id.f_choseNakshtra);
        f_chooseLatter = findViewById(R.id.f_chooseLatter);

        ArrayAdapter<?> adapterRashi = ArrayAdapter.createFromResource(this, R.array.rashi, android.R.layout.simple_spinner_dropdown_item);

        m_chooseNak.setAdapter(adapterRashi);
        f_chooseNak.setAdapter(adapterRashi);

        m_chooseNak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                m_cr = m_chooseNak.getSelectedItem().toString();

                ArrayAdapter<?> adapterMesha = ArrayAdapter.createFromResource(getApplicationContext(), R.array.meshaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterVrisha = ArrayAdapter.createFromResource(getApplicationContext(), R.array.vrishaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterMithun = ArrayAdapter.createFromResource(getApplicationContext(), R.array.mithunName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterKarka = ArrayAdapter.createFromResource(getApplicationContext(), R.array.karkaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterSinha = ArrayAdapter.createFromResource(getApplicationContext(), R.array.simhaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterKanya = ArrayAdapter.createFromResource(getApplicationContext(), R.array.kanyaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterTula = ArrayAdapter.createFromResource(getApplicationContext(), R.array.tulaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterVrishchika = ArrayAdapter.createFromResource(getApplicationContext(), R.array.vrishchikaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterDhanu = ArrayAdapter.createFromResource(getApplicationContext(), R.array.dhanuName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterMakra = ArrayAdapter.createFromResource(getApplicationContext(), R.array.makrName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterKumbha = ArrayAdapter.createFromResource(getApplicationContext(), R.array.kumbhaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterMeen = ArrayAdapter.createFromResource(getApplicationContext(), R.array.minaName, android.R.layout.simple_spinner_dropdown_item);

                if (m_cr == null){
                    Toast.makeText(getApplicationContext(), "No Rashi selected", Toast.LENGTH_SHORT).show();
                }else {
                    switch (m_cr) {
                        case "मेष":
                            m_chooseLatter.setAdapter(adapterMesha);
                            break;
                        case "वृष":
                            m_chooseLatter.setAdapter(adapterVrisha);
                            break;
                        case "मिथुन":
                            m_chooseLatter.setAdapter(adapterMithun);
                            break;
                        case "कर्क":
                            m_chooseLatter.setAdapter(adapterKarka);
                            break;
                        case "सिंह":
                            m_chooseLatter.setAdapter(adapterSinha);
                            break;
                        case "कन्या":
                            m_chooseLatter.setAdapter(adapterKanya);
                            break;
                        case "तुला":
                            m_chooseLatter.setAdapter(adapterTula);
                            break;
                        case "वृश्चिक":
                            m_chooseLatter.setAdapter(adapterVrishchika);
                            break;
                        case "धनु":
                            m_chooseLatter.setAdapter(adapterDhanu);
                            break;
                        case "मकर":
                            m_chooseLatter.setAdapter(adapterMakra);
                            break;
                        case "कुम्भ":
                            m_chooseLatter.setAdapter(adapterKumbha);
                            break;
                        case "मीन":
                            m_chooseLatter.setAdapter(adapterMeen);
                            break;
                        default:
                            m_chooseLatter.setAdapter(null);
                            break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        m_chooseLatter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                m_cl = m_chooseLatter.getSelectedItem().toString();

                switch (m_cl) {
                    case "चु":
                    case "चे":
                    case "चो":
                    case "ला":
                        m_aswini = true;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("अश्विनी");
                        m_rashi.setText("मेष");
                        m_rashiSwami.setText("मंगल");
                        m_varna.setText("क्षत्रिय");
                        m_vashya.setText("चतुष्पद");
                        m_yoni.setText("अश्व");
                        m_vairayoni.setText("महिष");
                        m_gana.setText("देव");
                        m_nadi.setText("आदि");
                        m_aasana.setText("अश्व");
                        if (m_aswini) {
                            Toast.makeText(mActivity, "true", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "ली":
                    case "लू":
                    case "ले":
                    case "लो":
                        m_bharani = true;
                        m_aswini = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("भरणी");
                        m_rashi.setText("मेष");
                        m_rashiSwami.setText("मंगल");
                        m_varna.setText("क्षत्रिय");
                        m_vashya.setText("चतुष्पद");
                        m_yoni.setText("गज");
                        m_vairayoni.setText("सिंह");
                        m_gana.setText("मनुष्य");
                        m_nadi.setText("मध्य");
                        m_aasana.setText("प्रेत");
                        break;
                    case "अ":
                        m_kritika1 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("कृत्तिका");
                        m_rashi.setText("मेष");
                        m_rashiSwami.setText("मंगल");
                        m_varna.setText("क्षत्रिय");
                        m_vashya.setText("चतुष्पद");
                        m_yoni.setText("अज");
                        m_vairayoni.setText("वानर");
                        m_gana.setText("राक्षस");
                        m_nadi.setText("अन्त्य");
                        m_aasana.setText("अग्निकुण्ड");
                        break;
                    case "ई":
                    case "उ":
                    case "ए":
                        m_kritika3 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("कृत्तिका");
                        m_rashi.setText("वृष");
                        m_rashiSwami.setText("शुक्र");
                        m_varna.setText("वैश्य");
                        m_vashya.setText("चतुष्पद");
                        m_yoni.setText("अज");
                        m_vairayoni.setText("वानर");
                        m_gana.setText("राक्षस");
                        m_nadi.setText("अन्त्य");
                        m_aasana.setText("अग्निकुण्ड");
                        break;
                    case "ओ":
                    case "वा":
                    case "वी":
                    case "वु":
                        m_rohini = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("रोहिणी");
                        m_rashi.setText("वृष");
                        m_rashiSwami.setText("शुक्र");
                        m_varna.setText("वैश्य");
                        m_vashya.setText("चतुष्पद");
                        m_yoni.setText("सर्प");
                        m_vairayoni.setText("नकुल");
                        m_gana.setText("मनुष्य");
                        m_nadi.setText("अन्त्य");
                        m_aasana.setText("गौ");
                        break;
                    case "वे":
                    case "वो":
                        m_mrigaA2 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("मॄगशिरा");
                        m_rashi.setText("वृष");
                        m_rashiSwami.setText("शुक्र");
                        m_varna.setText("वैश्य");
                        m_vashya.setText("चतुष्पद");
                        m_yoni.setText("सर्प");
                        m_vairayoni.setText("नकुल");
                        m_gana.setText("देव");
                        m_nadi.setText("मध्य");
                        m_aasana.setText("मृग");
                        break;
                    case "का":
                    case "की":
                        m_mrigaB2 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("मॄगशिरा");
                        m_rashi.setText("मिथुन");
                        m_rashiSwami.setText("बुध");
                        m_varna.setText("शुद्र");
                        m_vashya.setText("मनुष्य");
                        m_yoni.setText("सर्प");
                        m_vairayoni.setText("नकुल");
                        m_gana.setText("देव");
                        m_nadi.setText("मध्य");
                        m_aasana.setText("मृग");
                        break;
                    case "कु":
                    case "घ":
                    case "ङ":
                    case "छ":
                        m_aadra = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("आद्रा");
                        m_rashi.setText("मिथुन");
                        m_rashiSwami.setText("बुध");
                        m_varna.setText("शुद्र");
                        m_vashya.setText("मनुष्य");
                        m_yoni.setText("श्वान");
                        m_vairayoni.setText("मृग");
                        m_gana.setText("मनुष्य");
                        m_nadi.setText("आदि");
                        m_aasana.setText("भुजंग");
                        break;
                    case "के":
                    case "को":
                    case "हा":
                        m_punarvasu3 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("पुनर्वसु");
                        m_rashi.setText("मिथुन");
                        m_rashiSwami.setText("बुध");
                        m_varna.setText("शुद्र");
                        m_vashya.setText("मनुष्य");
                        m_yoni.setText("मार्जार");
                        m_vairayoni.setText("मूषक");
                        m_gana.setText("देव");
                        m_nadi.setText("आदि");
                        m_aasana.setText("कमल");
                        break;
                    case "ही":
                        m_punarvasu1 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("पुनर्वसु");
                        m_rashi.setText("कर्क");
                        m_rashiSwami.setText("चंद्र");
                        m_varna.setText("ब्राह्मण");
                        m_vashya.setText("जलचर");
                        m_yoni.setText("मार्जार");
                        m_vairayoni.setText("मूषक");
                        m_gana.setText("देव");
                        m_nadi.setText("आदि");
                        m_aasana.setText("कमल");
                        break;
                    case "हु":
                    case "हे":
                    case "हो":
                    case "डा":
                        m_tisya = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("पुष्य");
                        m_rashi.setText("कर्क");
                        m_rashiSwami.setText("चंद्र");
                        m_varna.setText("ब्राह्मण");
                        m_vashya.setText("जलचर");
                        m_yoni.setText("अज");
                        m_vairayoni.setText("वानर");
                        m_gana.setText("देव");
                        m_nadi.setText("मध्य");
                        m_aasana.setText("कलश");
                        break;
                    case "डी":
                    case "डू":
                    case "डे":
                    case "डो":
                        m_ashlesha = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("अश्लेशा");
                        m_rashi.setText("कर्क");
                        m_rashiSwami.setText("चंद्र");
                        m_varna.setText("ब्राह्मण");
                        m_vashya.setText("जलचर");
                        m_yoni.setText("मार्जार");
                        m_vairayoni.setText("मूषक");
                        m_gana.setText("राक्षस");
                        m_nadi.setText("अन्त्य");
                        m_aasana.setText("काक");
                        break;
                    case "मा":
                    case "मी":
                    case "मू":
                    case "मे":
                        m_magha = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("मघा");
                        m_rashi.setText("सिंह");
                        m_rashiSwami.setText("सूर्य");
                        m_varna.setText("क्षत्रिय");
                        m_vashya.setText("चतुष्पद");
                        m_yoni.setText("मूषक");
                        m_vairayoni.setText("मार्जार");
                        m_gana.setText("राक्षस");
                        m_nadi.setText("अन्त्य");
                        m_aasana.setText("महिष");
                        break;
                    case "मो":
                    case "टा":
                    case "टी":
                    case "टू":
                        m_pufa = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("पूर्वाफाल्गुनी");
                        m_rashi.setText("सिंह");
                        m_rashiSwami.setText("सूर्य");
                        m_varna.setText("क्षत्रिय");
                        m_vashya.setText("चतुष्पद");
                        m_yoni.setText("मूषक");
                        m_vairayoni.setText("मार्जार");
                        m_gana.setText("मनुष्य");
                        m_nadi.setText("मध्य");
                        m_aasana.setText("शिला");
                        break;
                    case "टे":
                        m_ufa1 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("उत्तराफाल्गुनी");
                        m_rashi.setText("सिंह");
                        m_rashiSwami.setText("सूर्य");
                        m_varna.setText("क्षत्रिय");
                        m_vashya.setText("चतुष्पद");
                        m_yoni.setText("गौ");
                        m_vairayoni.setText("व्याघ्र");
                        m_gana.setText("मनुष्य");
                        m_nadi.setText("आदि");
                        m_aasana.setText("शिला");
                        break;
                    case "टो":
                    case "पा":
                    case "पी":
                        m_ufa3 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("उत्तराफाल्गुनी");
                        m_rashi.setText("कन्या");
                        m_rashiSwami.setText("बुध");
                        m_varna.setText("वैश्य");
                        m_vashya.setText("मनुष्य");
                        m_yoni.setText("गौ");
                        m_vairayoni.setText("व्याघ्र");
                        m_gana.setText("मनुष्य");
                        m_nadi.setText("आदि");
                        m_aasana.setText("शिला");
                        break;
                    case "पू":
                    case "ष":
                    case "ण":
                    case "ठ":
                        m_hasta = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("हस्त");
                        m_rashi.setText("कन्या");
                        m_rashiSwami.setText("बुध");
                        m_varna.setText("वैश्य");
                        m_vashya.setText("मनुष्य");
                        m_yoni.setText("महिष");
                        m_vairayoni.setText("अश्व");
                        m_gana.setText("देव");
                        m_nadi.setText("आदि");
                        m_aasana.setText("गज");
                        break;
                    case "पे":
                    case "पो":
                        m_chitraA2 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("चित्रा");
                        m_rashi.setText("कन्या");
                        m_rashiSwami.setText("बुध");
                        m_varna.setText("वैश्य");
                        m_vashya.setText("मनुष्य");
                        m_yoni.setText("व्याघ्र");
                        m_vairayoni.setText("गौ");
                        m_gana.setText("राक्षस");
                        m_nadi.setText("मध्य");
                        m_aasana.setText("मयूर");
                        break;
                    case "रा":
                    case "री":
                        m_chitraB2 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("चित्रा");
                        m_rashi.setText("तुला");
                        m_rashiSwami.setText("शुक्र");
                        m_varna.setText("शुद्र");
                        m_vashya.setText("मनुष्य");
                        m_yoni.setText("व्याघ्र");
                        m_vairayoni.setText("गौ");
                        m_gana.setText("राक्षस");
                        m_nadi.setText("मध्य");
                        m_aasana.setText("मयूर");
                        break;
                    case "रू":
                    case "रे":
                    case "रो":
                    case "ता":
                        m_swati = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("स्वाती");
                        m_rashi.setText("तुला");
                        m_rashiSwami.setText("शुक्र");
                        m_varna.setText("शुद्र");
                        m_vashya.setText("मनुष्य");
                        m_yoni.setText("महिष");
                        m_vairayoni.setText("अश्व");
                        m_gana.setText("देव");
                        m_nadi.setText("अन्त्य");
                        m_aasana.setText("दोल");
                        break;
                    case "ती":
                    case "तू":
                    case "ते":
                        m_vishakha3 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("विशाखा");
                        m_rashi.setText("तुला");
                        m_rashiSwami.setText("शुक्र");
                        m_varna.setText("शुद्र");
                        m_vashya.setText("मनुष्य");
                        m_yoni.setText("व्याघ्र");
                        m_vairayoni.setText("गौ");
                        m_gana.setText("राक्षस");
                        m_nadi.setText("अन्त्य");
                        m_aasana.setText("अज");
                        break;
                    case "तो":
                        m_vishakha1 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("विशाखा");
                        m_rashi.setText("वृश्चिक");
                        m_rashiSwami.setText("मंगल");
                        m_varna.setText("ब्राह्मण");
                        m_vashya.setText("कीट");
                        m_yoni.setText("व्याघ्र");
                        m_vairayoni.setText("गौ");
                        m_gana.setText("राक्षस");
                        m_nadi.setText("अन्त्य");
                        m_aasana.setText("अज");
                        break;
                    case "ना":
                    case "नी":
                    case "नू":
                    case "ने":
                        m_anuradha = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("अनुराधा");
                        m_rashi.setText("वृश्चिक");
                        m_rashiSwami.setText("मंगल");
                        m_varna.setText("ब्राह्मण");
                        m_vashya.setText("कीट");
                        m_yoni.setText("मृग");
                        m_vairayoni.setText("स्वान");
                        m_gana.setText("देव");
                        m_nadi.setText("मध्य");
                        m_aasana.setText("हंस");
                        break;
                    case "नो":
                    case "या":
                    case "यी":
                    case "यू":
                        m_jestha = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("ज्येष्ठा");
                        m_rashi.setText("वृश्चिक");
                        m_rashiSwami.setText("मंगल");
                        m_varna.setText("ब्राह्मण");
                        m_vashya.setText("कीट");
                        m_yoni.setText("मृग");
                        m_vairayoni.setText("स्वान");
                        m_gana.setText("राक्षस");
                        m_nadi.setText("आदि");
                        m_aasana.setText("कच्छप");
                        break;
                    case "ये":
                    case "यो":
                    case "भा":
                    case "भी":
                        m_mula = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("मूल");
                        m_rashi.setText("धनु");
                        m_rashiSwami.setText("बृहस्पति");
                        m_varna.setText("क्षत्रिय");
                        m_vashya.setText("मनुष्य");
                        m_yoni.setText("श्वान");
                        m_vairayoni.setText("मृग");
                        m_gana.setText("राक्षस");
                        m_nadi.setText("आदि");
                        m_aasana.setText("मूल");
                        break;
                    case "भू":
                    case "धा":
                    case "फा":
                    case "ढा":
                        m_pusha1 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("पूर्वाषाढा");
                        m_rashi.setText("धनु");
                        m_rashiSwami.setText("बृहस्पति");
                        m_varna.setText("क्षत्रिय");
                        m_vashya.setText("मनुष्य");
                        m_yoni.setText("वानर");
                        m_vairayoni.setText("अज");
                        m_gana.setText("मनुष्य");
                        m_nadi.setText("मध्य");
                        m_aasana.setText("शयन");
                        break;
                    case "भे":
                        m_pusha3 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("उत्तराषाढा");
                        m_rashi.setText("धनु");
                        m_rashiSwami.setText("बृहस्पति");
                        m_varna.setText("क्षत्रिय");
                        m_vashya.setText("मनुष्य");
                        m_yoni.setText("नकुल");
                        m_vairayoni.setText("नकुल");
                        m_gana.setText("मनुष्य");
                        m_nadi.setText("अन्त्य");
                        m_aasana.setText("शयन");
                        break;
                    case "भो":
                    case "जा":
                    case "जी":
                        m_usha1 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("उत्तराषाढा");
                        m_rashi.setText("मकर");
                        m_rashiSwami.setText("शनि");
                        m_varna.setText("वैश्य");
                        m_vashya.setText("चतुष्पद");
                        m_yoni.setText("नकुल");
                        m_vairayoni.setText("नकुल");
                        m_gana.setText("मनुष्य");
                        m_nadi.setText("अन्त्य");
                        m_aasana.setText("शयन");
                        break;
                    case "जू":
                    case "जे":
                    case "जो":
                    case "खा":
                        m_nakshtra.setText("अभिजित");
                        m_rashi.setText("मकर");
                        m_rashiSwami.setText("शनि");
                        m_varna.setText("वैश्य");
                        m_vashya.setText("चतुष्पद");
                        m_yoni.setText("नकुल / अज");
                        m_vairayoni.setText("अज / गज");
                        m_gana.setText("मनुष्य / देव");
                        m_nadi.setText("अन्त्य");
                        m_aasana.setText("शयन / नर");
                        break;
                    case "खी":
                    case "खू":
                    case "खे":
                    case "खो":
                        m_shravana = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("श्रवण");
                        m_rashi.setText("मकर");
                        m_rashiSwami.setText("शनि");
                        m_varna.setText("वैश्य");
                        m_vashya.setText("चतुष्पद");
                        m_yoni.setText("वानर");
                        m_vairayoni.setText("अज");
                        m_gana.setText("देव");
                        m_nadi.setText("अन्त्य");
                        m_aasana.setText("नर");
                        break;
                    case "गा":
                    case "गी":
                        m_dhanisthaA2 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("धनिष्ठा");
                        m_rashi.setText("मकर");
                        m_rashiSwami.setText("शनि");
                        m_varna.setText("वैश्य");
                        m_vashya.setText("चतुष्पद");
                        m_yoni.setText("सिंह");
                        m_vairayoni.setText("गज");
                        m_gana.setText("राक्षस");
                        m_nadi.setText("मध्य");
                        m_aasana.setText("आढक");
                        break;
                    case "गु":
                    case "गे":
                        m_dhanisthaB2 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("धनिष्ठा");
                        m_rashi.setText("कुम्भ");
                        m_rashiSwami.setText("शनि");
                        m_varna.setText("शुद्र");
                        m_vashya.setText("द्विपद ");
                        m_yoni.setText("सिंह");
                        m_vairayoni.setText("गज");
                        m_gana.setText("राक्षस");
                        m_nadi.setText("मध्य");
                        m_aasana.setText("आढक");
                        break;
                    case "गो":
                    case "सा":
                    case "सी":
                    case "सू":
                        m_shatavisha = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("शतभिषा");
                        m_rashi.setText("कुम्भ");
                        m_rashiSwami.setText("शनि");
                        m_varna.setText("शुद्र");
                        m_vashya.setText("द्विपद ");
                        m_yoni.setText("अश्व");
                        m_vairayoni.setText("महिष");
                        m_gana.setText("राक्षस");
                        m_nadi.setText("आदि");
                        m_aasana.setText("वृष");
                        break;
                    case "से":
                    case "सो":
                    case "दा":
                        m_pubha3 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("पूर्वभाद्र्पद");
                        m_rashi.setText("कुम्भ");
                        m_rashiSwami.setText("शनि");
                        m_varna.setText("शुद्र");
                        m_vashya.setText("द्विपद ");
                        m_yoni.setText("सिंह");
                        m_vairayoni.setText("गज");
                        m_gana.setText("मनुष्य");
                        m_nadi.setText("आदि");
                        m_aasana.setText("भद्रपीठ");
                        break;
                    case "दी":
                        m_pubha1 = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("पूर्वभाद्र्पद");
                        m_rashi.setText("मीन");
                        m_rashiSwami.setText("बृहस्पति");
                        m_varna.setText("ब्राह्मण");
                        m_vashya.setText("जलचर");
                        m_yoni.setText("सिंह");
                        m_vairayoni.setText("गज");
                        m_gana.setText("मनुष्य");
                        m_nadi.setText("आदि");
                        m_aasana.setText("भद्रपीठ");
                        break;
                    case "दू":
                    case "थ":
                    case "झ":
                    case "ञ":
                        m_ubha = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_revati = false;
                        m_nakshtra.setText("उत्तरभाद्रपदा");
                        m_rashi.setText("मीन");
                        m_rashiSwami.setText("बृहस्पति");
                        m_varna.setText("ब्राह्मण");
                        m_vashya.setText("जलचर");
                        m_yoni.setText("गौ");
                        m_vairayoni.setText("व्याघ्र");
                        m_gana.setText("मनुष्य");
                        m_nadi.setText("मध्य");
                        m_aasana.setText("भद्रपीठ");
                        break;
                    case "दे":
                    case "दो":
                    case "च":
                    case "ची":
                        m_revati = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_nakshtra.setText("रेवती");
                        m_rashi.setText("मीन");
                        m_rashiSwami.setText("बृहस्पति");
                        m_varna.setText("ब्राह्मण");
                        m_vashya.setText("जलचर");
                        m_yoni.setText("गज");
                        m_vairayoni.setText("सिंह");
                        m_gana.setText("देव");
                        m_nadi.setText("आदि");
                        m_aasana.setText("चक्र");
                        break;
                    default:
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        m_revati = false;
                        m_nakshtra.setText("");
                        m_rashi.setText("");
                        m_rashiSwami.setText("");
                        m_varna.setText("");
                        m_vashya.setText("");
                        m_yoni.setText("");
                        m_vairayoni.setText("");
                        m_gana.setText("");
                        m_nadi.setText("");
                        m_aasana.setText("");
                        break;
                }

                mAshwiniToFALL();
                fAshwiniToFALL();

                mBhariniToFALL();
                fBhariniToFALL();

                mKritika3ToFALL();
                fKritika3ToFALL();

                mKritika1ToFALL();
                fKritika1ToFALL();

                mRohiniToFALL();
                fRohiniToFALL();

                mMrigaA2ToFALL();
                fMrigaA2ToFALL();

                mMrigaB2ToFALL();
                fMrigaB2ToFALL();

                mAdraToFALL();
                fAdraToFALL();

                mPunarvasu3ToFALL();
                fPunarvasu3ToFALL();

                mPunarvasu1ToFALL();
                fPunarvasu1ToFALL();

                mTishyaToFALL();
                fTishyaToFALL();

                mAshleshaToFALL();
                fAshleshaToFALL();

                mMaghaToFALL();
                fMaghaToFALL();

                mPufaToFALL();
                fPufaToFALL();

                mUfa1ToFALL();
                fUfa1ToFALL();

                mUfa3ToFALL();
                fUfa3ToFALL();

                mHastaToFALL();
                fHastaToFALL();

                mChitraA2ToFALL();
                fChitraA2ToFALL();

                mChitraB2ToFALL();
                fChitraB2ToFALL();

                mSwatiToFALL();
                fSwatiToFALL();

                mBishakha3ToFALL();
                fBishakha3ToFALL();

                mBishakha1ToFALL();
                fBishakha1ToFALL();

                mAnuradhaToFALL();
                fAnuradhaToFALL();

                mJesthaToFALL();
                fJesthaToFALL();

                mMulaToFALL();
                fMulaToFALL();

                mPusha1ToFALL();
                fPusha1ToFALL();

                mPusha3ToFALL();
                fPusha3ToFALL();

                mUsha1ToFALL();
                fUsha1ToFALL();

                mUsha3ToFALL();
                fUsha3ToFALL();

                mShravanaToFALL();
                fShravanaToFALL();

                mDhanistaA2ToFALL();
                fDhanistaA2ToFALL();

                mDhanistaB2ToFALL();
                fDhanistaB2ToFALL();

                mShatavishaToFALL();
                fShatavishaToFALL();

                mPubha3ToFALL();
                fPubha3ToFALL();

                mPubha1ToFALL();
                fPubha1ToFALL();

                mUbhaToFALL();
                fUbhaToFALL();

                mRewatiToFALL();
                fRewatiToFALL();

//                try {
//                    int getGuna = Integer.parseInt(m_guna.getText().toString());
//                    if (getGuna < 19) {
//                        kutafal.setText("अयोग्य");
//                    }
//                    if (getGuna > 26){
//                        kutafal.setText("अतिउत्तम");
//                    }else {
//                        kutafal.setText("उत्तम");
//                    }
//                } catch (NumberFormatException e) {
//                    // Display an error message to the user
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        f_chooseNak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                f_cr = f_chooseNak.getSelectedItem().toString();

                ArrayAdapter<?> adapterMesha = ArrayAdapter.createFromResource(getApplicationContext(), R.array.meshaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterVrisha = ArrayAdapter.createFromResource(getApplicationContext(), R.array.vrishaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterMithun = ArrayAdapter.createFromResource(getApplicationContext(), R.array.mithunName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterKarka = ArrayAdapter.createFromResource(getApplicationContext(), R.array.karkaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterSinha = ArrayAdapter.createFromResource(getApplicationContext(), R.array.simhaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterKanya = ArrayAdapter.createFromResource(getApplicationContext(), R.array.kanyaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterTula = ArrayAdapter.createFromResource(getApplicationContext(), R.array.tulaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterVrishchika = ArrayAdapter.createFromResource(getApplicationContext(), R.array.vrishchikaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterDhanu = ArrayAdapter.createFromResource(getApplicationContext(), R.array.dhanuName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterMakra = ArrayAdapter.createFromResource(getApplicationContext(), R.array.makrName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterKumbha = ArrayAdapter.createFromResource(getApplicationContext(), R.array.kumbhaName, android.R.layout.simple_spinner_dropdown_item);
                ArrayAdapter<?> adapterMeen = ArrayAdapter.createFromResource(getApplicationContext(), R.array.minaName, android.R.layout.simple_spinner_dropdown_item);

                if (f_cr == null){
                    Toast.makeText(getApplicationContext(), "No Rashi selected", Toast.LENGTH_SHORT).show();
                }else {
                    switch (f_cr) {
                        case "मेष":
                            f_chooseLatter.setAdapter(adapterMesha);
                            break;
                        case "वृष":
                            f_chooseLatter.setAdapter(adapterVrisha);
                            break;
                        case "मिथुन":
                            f_chooseLatter.setAdapter(adapterMithun);
                            break;
                        case "कर्क":
                            f_chooseLatter.setAdapter(adapterKarka);
                            break;
                        case "सिंह":
                            f_chooseLatter.setAdapter(adapterSinha);
                            break;
                        case "कन्या":
                            f_chooseLatter.setAdapter(adapterKanya);
                            break;
                        case "तुला":
                            f_chooseLatter.setAdapter(adapterTula);
                            break;
                        case "वृश्चिक":
                            f_chooseLatter.setAdapter(adapterVrishchika);
                            break;
                        case "धनु":
                            f_chooseLatter.setAdapter(adapterDhanu);
                            break;
                        case "मकर":
                            f_chooseLatter.setAdapter(adapterMakra);
                            break;
                        case "कुम्भ":
                            f_chooseLatter.setAdapter(adapterKumbha);
                            break;
                        case "मीन":
                            f_chooseLatter.setAdapter(adapterMeen);
                            break;
                        default:
                            f_chooseLatter.setAdapter(null);
                            break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        f_chooseLatter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                f_cl = f_chooseLatter.getSelectedItem().toString();

                switch (f_cl) {
                    case "चु":
                    case "चे":
                    case "चो":
                    case "ला":
                        f_aswini = true;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;

                        f_nakshtra.setText("अश्विनी");
                        f_rashi.setText("मेष");
                        f_rashiSwami.setText("मंगल");
                        f_varna.setText("क्षत्रिय");
                        f_vashya.setText("चतुष्पद");
                        f_yoni.setText("अश्व");
                        f_vairayoni.setText("महिष");
                        f_gana.setText("देव");
                        f_nadi.setText("आदि");
                        f_aasana.setText("अश्व");
                        break;
                    case "ली":
                    case "लू":
                    case "ले":
                    case "लो":
                        f_bharani = true;
                        f_aswini = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("भरणी");
                        f_rashi.setText("मेष");
                        f_rashiSwami.setText("मंगल");
                        f_varna.setText("क्षत्रिय");
                        f_vashya.setText("चतुष्पद");
                        f_yoni.setText("गज");
                        f_vairayoni.setText("सिंह");
                        f_gana.setText("मनुष्य");
                        f_nadi.setText("मध्य");
                        f_aasana.setText("प्रेत");
                        break;
                    case "अ":
                        f_kritika1 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("कृत्तिका");
                        f_rashi.setText("मेष");
                        f_rashiSwami.setText("मंगल");
                        f_varna.setText("क्षत्रिय");
                        f_vashya.setText("चतुष्पद");
                        f_yoni.setText("अज");
                        f_vairayoni.setText("वानर");
                        f_gana.setText("राक्षस");
                        f_nadi.setText("अन्त्य");
                        f_aasana.setText("अग्निकुण्ड");
                        break;
                    case "ई":
                    case "उ":
                    case "ए":
                        f_kritika3 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("कृत्तिका");
                        f_rashi.setText("वृष");
                        f_rashiSwami.setText("शुक्र");
                        f_varna.setText("वैश्य");
                        f_vashya.setText("चतुष्पद");
                        f_yoni.setText("अज");
                        f_vairayoni.setText("वानर");
                        f_gana.setText("राक्षस");
                        f_nadi.setText("अन्त्य");
                        f_aasana.setText("अग्निकुण्ड");
                        break;
                    case "ओ":
                    case "वा":
                    case "वी":
                    case "वु":
                        f_rohini = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("रोहिणी");
                        f_rashi.setText("वृष");
                        f_rashiSwami.setText("शुक्र");
                        f_varna.setText("वैश्य");
                        f_vashya.setText("चतुष्पद");
                        f_yoni.setText("सर्प");
                        f_vairayoni.setText("नकुल");
                        f_gana.setText("मनुष्य");
                        f_nadi.setText("अन्त्य");
                        f_aasana.setText("गौ");
                        break;
                    case "वे":
                    case "वो":
                        f_mrigaA2 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("मॄगशिरा");
                        f_rashi.setText("वृष");
                        f_rashiSwami.setText("शुक्र");
                        f_varna.setText("वैश्य");
                        f_vashya.setText("चतुष्पद");
                        f_yoni.setText("सर्प");
                        f_vairayoni.setText("नकुल");
                        f_gana.setText("देव");
                        f_nadi.setText("मध्य");
                        f_aasana.setText("मृग");
                        break;
                    case "का":
                    case "की":
                        f_mrigaB2 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("मॄगशिरा");
                        f_rashi.setText("मिथुन");
                        f_rashiSwami.setText("बुध");
                        f_varna.setText("शुद्र");
                        f_vashya.setText("मनुष्य");
                        f_yoni.setText("सर्प");
                        f_vairayoni.setText("नकुल");
                        f_gana.setText("देव");
                        f_nadi.setText("मध्य");
                        f_aasana.setText("मृग");
                        break;
                    case "कु":
                    case "घ":
                    case "ङ":
                    case "छ":
                        f_aadra = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("आद्रा");
                        f_rashi.setText("मिथुन");
                        f_rashiSwami.setText("बुध");
                        f_varna.setText("शुद्र");
                        f_vashya.setText("मनुष्य");
                        f_yoni.setText("श्वान");
                        f_vairayoni.setText("मृग");
                        f_gana.setText("मनुष्य");
                        f_nadi.setText("आदि");
                        f_aasana.setText("भुजंग");
                        break;
                    case "के":
                    case "को":
                    case "हा":
                        f_punarvasu3 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("पुनर्वसु");
                        f_rashi.setText("मिथुन");
                        f_rashiSwami.setText("बुध");
                        f_varna.setText("शुद्र");
                        f_vashya.setText("मनुष्य");
                        f_yoni.setText("मार्जार");
                        f_vairayoni.setText("मूषक");
                        f_gana.setText("देव");
                        f_nadi.setText("आदि");
                        f_aasana.setText("कमल");
                        break;
                    case "ही":
                        f_punarvasu1 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("पुनर्वसु");
                        f_rashi.setText("कर्क");
                        f_rashiSwami.setText("चंद्र");
                        f_varna.setText("ब्राह्मण");
                        f_vashya.setText("जलचर");
                        f_yoni.setText("मार्जार");
                        f_vairayoni.setText("मूषक");
                        f_gana.setText("देव");
                        f_nadi.setText("आदि");
                        f_aasana.setText("कमल");
                        break;
                    case "हु":
                    case "हे":
                    case "हो":
                    case "डा":
                        f_tisya = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("पुष्य");
                        f_rashi.setText("कर्क");
                        f_rashiSwami.setText("चंद्र");
                        f_varna.setText("ब्राह्मण");
                        f_vashya.setText("जलचर");
                        f_yoni.setText("अज");
                        f_vairayoni.setText("वानर");
                        f_gana.setText("देव");
                        f_nadi.setText("मध्य");
                        f_aasana.setText("कलश");
                        break;
                    case "डी":
                    case "डू":
                    case "डे":
                    case "डो":
                        f_ashlesha = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("अश्लेशा");
                        f_rashi.setText("कर्क");
                        f_rashiSwami.setText("चंद्र");
                        f_varna.setText("ब्राह्मण");
                        f_vashya.setText("जलचर");
                        f_yoni.setText("मार्जार");
                        f_vairayoni.setText("मूषक");
                        f_gana.setText("राक्षस");
                        f_nadi.setText("अन्त्य");
                        f_aasana.setText("काक");
                        break;
                    case "मा":
                    case "मी":
                    case "मू":
                    case "मे":
                        f_magha = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("मघा");
                        f_rashi.setText("सिंह");
                        f_rashiSwami.setText("सूर्य");
                        f_varna.setText("क्षत्रिय");
                        f_vashya.setText("चतुष्पद");
                        f_yoni.setText("मूषक");
                        f_vairayoni.setText("मार्जार");
                        f_gana.setText("राक्षस");
                        f_nadi.setText("अन्त्य");
                        f_aasana.setText("महिष");
                        break;
                    case "मो":
                    case "टा":
                    case "टी":
                    case "टू":
                        f_pufa = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("पूर्वाफाल्गुनी");
                        f_rashi.setText("सिंह");
                        f_rashiSwami.setText("सूर्य");
                        f_varna.setText("क्षत्रिय");
                        f_vashya.setText("चतुष्पद");
                        f_yoni.setText("मूषक");
                        f_vairayoni.setText("मार्जार");
                        f_gana.setText("मनुष्य");
                        f_nadi.setText("मध्य");
                        f_aasana.setText("शिला");
                        break;
                    case "टे":
                        f_ufa1 = true;
                        f_nakshtra.setText("उत्तराफाल्गुनी");
                        f_rashi.setText("सिंह");
                        f_rashiSwami.setText("सूर्य");
                        f_varna.setText("क्षत्रिय");
                        f_vashya.setText("चतुष्पद");
                        f_yoni.setText("गौ");
                        f_vairayoni.setText("व्याघ्र");
                        f_gana.setText("मनुष्य");
                        f_nadi.setText("आदि");
                        f_aasana.setText("शिला");
                        break;
                    case "टो":
                    case "पा":
                    case "पी":
                        f_ufa3 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("उत्तराफाल्गुनी");
                        f_rashi.setText("कन्या");
                        f_rashiSwami.setText("बुध");
                        f_varna.setText("वैश्य");
                        f_vashya.setText("मनुष्य");
                        f_yoni.setText("गौ");
                        f_vairayoni.setText("व्याघ्र");
                        f_gana.setText("मनुष्य");
                        f_nadi.setText("आदि");
                        f_aasana.setText("शिला");
                        break;
                    case "पू":
                    case "ष":
                    case "ण":
                    case "ठ":
                        f_hasta = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("हस्त");
                        f_rashi.setText("कन्या");
                        f_rashiSwami.setText("बुध");
                        f_varna.setText("वैश्य");
                        f_vashya.setText("मनुष्य");
                        f_yoni.setText("महिष");
                        f_vairayoni.setText("अश्व");
                        f_gana.setText("देव");
                        f_nadi.setText("आदि");
                        f_aasana.setText("गज");
                        break;
                    case "पे":
                    case "पो":
                        f_chitraA2 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("चित्रा");
                        f_rashi.setText("कन्या");
                        f_rashiSwami.setText("बुध");
                        f_varna.setText("वैश्य");
                        f_vashya.setText("मनुष्य");
                        f_yoni.setText("व्याघ्र");
                        f_vairayoni.setText("गौ");
                        f_gana.setText("राक्षस");
                        f_nadi.setText("मध्य");
                        f_aasana.setText("मयूर");
                        break;
                    case "रा":
                    case "री":
                        f_chitraB2 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("चित्रा");
                        f_rashi.setText("तुला");
                        f_rashiSwami.setText("शुक्र");
                        f_varna.setText("शुद्र");
                        f_vashya.setText("मनुष्य");
                        f_yoni.setText("व्याघ्र");
                        f_vairayoni.setText("गौ");
                        f_gana.setText("राक्षस");
                        f_nadi.setText("मध्य");
                        f_aasana.setText("मयूर");
                        break;
                    case "रू":
                    case "रे":
                    case "रो":
                    case "ता":
                        f_swati = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("स्वाती");
                        f_rashi.setText("तुला");
                        f_rashiSwami.setText("शुक्र");
                        f_varna.setText("शुद्र");
                        f_vashya.setText("मनुष्य");
                        f_yoni.setText("महिष");
                        f_vairayoni.setText("अश्व");
                        f_gana.setText("देव");
                        f_nadi.setText("अन्त्य");
                        f_aasana.setText("दोल");
                        break;
                    case "ती":
                    case "तू":
                    case "ते":
                        f_vishakha3 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("विशाखा");
                        f_rashi.setText("तुला");
                        f_rashiSwami.setText("शुक्र");
                        f_varna.setText("शुद्र");
                        f_vashya.setText("मनुष्य");
                        f_yoni.setText("व्याघ्र");
                        f_vairayoni.setText("गौ");
                        f_gana.setText("राक्षस");
                        f_nadi.setText("अन्त्य");
                        f_aasana.setText("अज");
                        break;
                    case "तो":
                        f_vishakha1 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("विशाखा");
                        f_rashi.setText("वृश्चिक");
                        f_rashiSwami.setText("मंगल");
                        f_varna.setText("ब्राह्मण");
                        f_vashya.setText("कीट");
                        f_yoni.setText("व्याघ्र");
                        f_vairayoni.setText("गौ");
                        f_gana.setText("राक्षस");
                        f_nadi.setText("अन्त्य");
                        f_aasana.setText("अज");
                        break;
                    case "ना":
                    case "नी":
                    case "नू":
                    case "ने":
                        f_anuradha = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("अनुराधा");
                        f_rashi.setText("वृश्चिक");
                        f_rashiSwami.setText("मंगल");
                        f_varna.setText("ब्राह्मण");
                        f_vashya.setText("कीट");
                        f_yoni.setText("मृग");
                        f_vairayoni.setText("स्वान");
                        f_gana.setText("देव");
                        f_nadi.setText("मध्य");
                        f_aasana.setText("हंस");
                        break;
                    case "नो":
                    case "या":
                    case "यी":
                    case "यू":
                        f_jestha = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("ज्येष्ठा");
                        f_rashi.setText("वृश्चिक");
                        f_rashiSwami.setText("मंगल");
                        f_varna.setText("ब्राह्मण");
                        f_vashya.setText("कीट");
                        f_yoni.setText("मृग");
                        f_vairayoni.setText("स्वान");
                        f_gana.setText("राक्षस");
                        f_nadi.setText("आदि");
                        f_aasana.setText("कच्छप");
                        break;
                    case "ये":
                    case "यो":
                    case "भा":
                    case "भी":
                        f_mula = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("मूल");
                        f_rashi.setText("धनु");
                        f_rashiSwami.setText("बृहस्पति");
                        f_varna.setText("क्षत्रिय");
                        f_vashya.setText("मनुष्य");
                        f_yoni.setText("श्वान");
                        f_vairayoni.setText("मृग");
                        f_gana.setText("राक्षस");
                        f_nadi.setText("आदि");
                        f_aasana.setText("मूल");
                        break;
                    case "भू":
                    case "धा":
                    case "फा":
                    case "ढा":
                        f_pusha1 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("पूर्वाषाढा");
                        f_rashi.setText("धनु");
                        f_rashiSwami.setText("बृहस्पति");
                        f_varna.setText("क्षत्रिय");
                        f_vashya.setText("मनुष्य");
                        f_yoni.setText("वानर");
                        f_vairayoni.setText("अज");
                        f_gana.setText("मनुष्य");
                        f_nadi.setText("मध्य");
                        f_aasana.setText("शयन");
                        break;
                    case "भे":
                        f_usha1 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("उत्तराषाढा");
                        f_rashi.setText("धनु");
                        f_rashiSwami.setText("बृहस्पति");
                        f_varna.setText("क्षत्रिय");
                        f_vashya.setText("मनुष्य");
                        f_yoni.setText("नकुल");
                        f_vairayoni.setText("नकुल");
                        f_gana.setText("मनुष्य");
                        f_nadi.setText("अन्त्य");
                        f_aasana.setText("शयन");
                        break;
                    case "भो":
                    case "जा":
                    case "जी":
                        f_usha3 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("उत्तराषाढा");
                        f_rashi.setText("मकर");
                        f_rashiSwami.setText("शनि");
                        f_varna.setText("वैश्य");
                        f_vashya.setText("चतुष्पद");
                        f_yoni.setText("नकुल");
                        f_vairayoni.setText("नकुल");
                        f_gana.setText("मनुष्य");
                        f_nadi.setText("अन्त्य");
                        f_aasana.setText("शयन");
                        break;
                    case "जू":
                    case "जे":
                    case "जो":
                    case "खा":
                        f_nakshtra.setText("अभिजित");
                        f_rashi.setText("मकर");
                        f_rashiSwami.setText("शनि");
                        f_varna.setText("वैश्य");
                        f_vashya.setText("चतुष्पद");
                        f_yoni.setText("नकुल / अज");
                        f_vairayoni.setText("अज / गज");
                        f_gana.setText("मनुष्य / देव");
                        f_nadi.setText("अन्त्य");
                        f_aasana.setText("शयन / नर");
                        break;
                    case "खी":
                    case "खू":
                    case "खे":
                    case "खो":
                        f_shravana = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("श्रवण");
                        f_rashi.setText("मकर");
                        f_rashiSwami.setText("शनि");
                        f_varna.setText("वैश्य");
                        f_vashya.setText("चतुष्पद");
                        f_yoni.setText("वानर");
                        f_vairayoni.setText("अज");
                        f_gana.setText("देव");
                        f_nadi.setText("अन्त्य");
                        f_aasana.setText("नर");
                        break;
                    case "गा":
                    case "गी":
                        f_dhanisthaA2 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("धनिष्ठा");
                        f_rashi.setText("मकर");
                        f_rashiSwami.setText("शनि");
                        f_varna.setText("वैश्य");
                        f_vashya.setText("चतुष्पद");
                        f_yoni.setText("सिंह");
                        f_vairayoni.setText("गज");
                        f_gana.setText("राक्षस");
                        f_nadi.setText("मध्य");
                        f_aasana.setText("आढक");
                        break;
                    case "गु":
                    case "गे":
                        f_dhanisthaB2 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("धनिष्ठा");
                        f_rashi.setText("कुम्भ");
                        f_rashiSwami.setText("शनि");
                        f_varna.setText("शुद्र");
                        f_vashya.setText("द्विपद ");
                        f_yoni.setText("सिंह");
                        f_vairayoni.setText("गज");
                        f_gana.setText("राक्षस");
                        f_nadi.setText("मध्य");
                        f_aasana.setText("आढक");
                        break;
                    case "गो":
                    case "सा":
                    case "सी":
                    case "सू":
                        f_shatavisha = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("शतभिषा");
                        f_rashi.setText("कुम्भ");
                        f_rashiSwami.setText("शनि");
                        f_varna.setText("शुद्र");
                        f_vashya.setText("द्विपद ");
                        f_yoni.setText("अश्व");
                        f_vairayoni.setText("महिष");
                        f_gana.setText("राक्षस");
                        f_nadi.setText("आदि");
                        f_aasana.setText("वृष");
                        break;
                    case "से":
                    case "सो":
                    case "दा":
                        f_pubha3 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("पूर्वभाद्र्पद");
                        f_rashi.setText("कुम्भ");
                        f_rashiSwami.setText("शनि");
                        f_varna.setText("शुद्र");
                        f_vashya.setText("द्विपद ");
                        f_yoni.setText("सिंह");
                        f_vairayoni.setText("गज");
                        f_gana.setText("मनुष्य");
                        f_nadi.setText("आदि");
                        f_aasana.setText("भद्रपीठ");
                        break;
                    case "दी":
                        f_pubha1 = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("पूर्वभाद्र्पद");
                        f_rashi.setText("मीन");
                        f_rashiSwami.setText("बृहस्पति");
                        f_varna.setText("ब्राह्मण");
                        f_vashya.setText("जलचर");
                        f_yoni.setText("सिंह");
                        f_vairayoni.setText("गज");
                        f_gana.setText("मनुष्य");
                        f_nadi.setText("आदि");
                        f_aasana.setText("भद्रपीठ");
                        break;
                    case "दू":
                    case "थ":
                    case "झ":
                    case "ञ":
                        f_ubha = true;
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_revati = false;
                        f_nakshtra.setText("उत्तरभाद्रपदा");
                        f_rashi.setText("मीन");
                        f_rashiSwami.setText("बृहस्पति");
                        f_varna.setText("ब्राह्मण");
                        f_vashya.setText("जलचर");
                        f_yoni.setText("गौ");
                        f_vairayoni.setText("व्याघ्र");
                        f_gana.setText("मनुष्य");
                        f_nadi.setText("मध्य");
                        f_aasana.setText("भद्रपीठ");
                        break;
                    case "दे":
                    case "दो":
                    case "च":
                    case "ची":
                        m_revati = true;
                        m_aswini = false;
                        m_bharani = false;
                        m_kritika1 = false;
                        m_kritika3 = false;
                        m_rohini = false;
                        m_mrigaA2 = false;
                        m_mrigaB2 = false;
                        m_aadra = false;
                        m_punarvasu3 = false;
                        m_punarvasu1 = false;
                        m_tisya = false;
                        m_ashlesha = false;
                        m_magha = false;
                        m_pufa = false;
                        m_ufa1 = false;
                        m_ufa3 = false;
                        m_hasta = false;
                        m_chitraA2 = false;
                        m_chitraB2 = false;
                        m_swati = false;
                        m_vishakha3 = false;
                        m_vishakha1 = false;
                        m_anuradha = false;
                        m_jestha = false;
                        m_mula = false;
                        m_pusha1 = false;
                        m_pusha3 = false;
                        m_usha1 = false;
                        m_usha3 = false;
                        m_shravana = false;
                        m_dhanisthaA2 = false;
                        m_dhanisthaB2 = false;
                        m_shatavisha = false;
                        m_pubha3 = false;
                        m_pubha1 = false;
                        m_ubha = false;
                        f_nakshtra.setText("रेवती");
                        f_rashi.setText("मीन");
                        f_rashiSwami.setText("बृहस्पति");
                        f_varna.setText("ब्राह्मण");
                        f_vashya.setText("जलचर");
                        f_yoni.setText("गज");
                        f_vairayoni.setText("सिंह");
                        f_gana.setText("देव");
                        f_nadi.setText("आदि");
                        f_aasana.setText("चक्र");
                        break;
                    default:
                        f_aswini = false;
                        f_bharani = false;
                        f_kritika1 = false;
                        f_kritika3 = false;
                        f_rohini = false;
                        f_mrigaA2 = false;
                        f_mrigaB2 = false;
                        f_aadra = false;
                        f_punarvasu3 = false;
                        f_punarvasu1 = false;
                        f_tisya = false;
                        f_ashlesha = false;
                        f_magha = false;
                        f_pufa = false;
                        f_ufa1 = false;
                        f_ufa3 = false;
                        f_hasta = false;
                        f_chitraA2 = false;
                        f_chitraB2 = false;
                        f_swati = false;
                        f_vishakha3 = false;
                        f_vishakha1 = false;
                        f_anuradha = false;
                        f_jestha = false;
                        f_mula = false;
                        f_pusha1 = false;
                        f_pusha3 = false;
                        f_usha1 = false;
                        f_usha3 = false;
                        f_shravana = false;
                        f_dhanisthaA2 = false;
                        f_dhanisthaB2 = false;
                        f_shatavisha = false;
                        f_pubha3 = false;
                        f_pubha1 = false;
                        f_ubha = false;
                        f_revati = false;
                        f_nakshtra.setText("");
                        f_rashi.setText("");
                        f_rashiSwami.setText("");
                        f_varna.setText("");
                        f_vashya.setText("");
                        f_yoni.setText("");
                        f_vairayoni.setText("");
                        f_gana.setText("");
                        f_nadi.setText("");
                        f_aasana.setText("");
                        break;
                }

                mAshwiniToFALL();
                fAshwiniToFALL();

                mBhariniToFALL();
                fBhariniToFALL();

                mKritika3ToFALL();
                fKritika3ToFALL();

                mKritika1ToFALL();
                fKritika1ToFALL();

                mRohiniToFALL();
                fRohiniToFALL();

                mMrigaA2ToFALL();
                fMrigaA2ToFALL();

                mMrigaB2ToFALL();
                fMrigaB2ToFALL();

                mAdraToFALL();
                fAdraToFALL();

                mPunarvasu3ToFALL();
                fPunarvasu3ToFALL();

                mPunarvasu1ToFALL();
                fPunarvasu1ToFALL();

                mTishyaToFALL();
                fTishyaToFALL();

                mAshleshaToFALL();
                fAshleshaToFALL();

                mMaghaToFALL();
                fMaghaToFALL();

                mPufaToFALL();
                fPufaToFALL();

                mUfa1ToFALL();
                fUfa1ToFALL();

                mUfa3ToFALL();
                fUfa3ToFALL();

                mHastaToFALL();
                fHastaToFALL();

                mChitraA2ToFALL();
                fChitraA2ToFALL();

                mChitraB2ToFALL();
                fChitraB2ToFALL();

                mSwatiToFALL();
                fSwatiToFALL();

                mBishakha3ToFALL();
                fBishakha3ToFALL();

                mBishakha1ToFALL();
                fBishakha1ToFALL();

                mAnuradhaToFALL();
                fAnuradhaToFALL();

                mJesthaToFALL();
                fJesthaToFALL();

                mMulaToFALL();
                fMulaToFALL();

                mPusha1ToFALL();
                fPusha1ToFALL();

                mPusha3ToFALL();
                fPusha3ToFALL();

                mUsha1ToFALL();
                fUsha1ToFALL();

                mUsha3ToFALL();
                fUsha3ToFALL();

                mShravanaToFALL();
                fShravanaToFALL();

                mDhanistaA2ToFALL();
                fDhanistaA2ToFALL();

                mDhanistaB2ToFALL();
                fDhanistaB2ToFALL();

                mShatavishaToFALL();
                fShatavishaToFALL();

                mPubha3ToFALL();
                fPubha3ToFALL();

                mPubha1ToFALL();
                fPubha1ToFALL();

                mUbhaToFALL();
                fUbhaToFALL();

                mRewatiToFALL();
                fRewatiToFALL();

//                try {
//                    int getGuna = Integer.parseInt(m_guna.getText().toString());
//                    if (getGuna < 19) {
//                        kutafal.setText("अयोग्य");
//                    }
//                    if (getGuna > 26){
//                        kutafal.setText("अतिउत्तम");
//                    }else {
//                        kutafal.setText("उत्तम");
//                    }
//                } catch (NumberFormatException e) {
//                    // Display an error message to the user
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @SuppressLint("SetTextI18n")

    public void mAshwiniToFALL(){

        if (m_aswini && f_aswini){
            m_guna.setText("28");
        }else if (m_aswini && f_bharani) {
            m_guna.setText("34");
        }else if (m_aswini && f_kritika1) {
            m_guna.setText("27.18");
        }else if (m_aswini && f_kritika3) {
            m_guna.setText("18.18");
        }else if (m_aswini && f_rohini) {
            m_guna.setText("23.18");
        }else if (m_aswini && f_mrigaA2) {
            m_guna.setText("23.18");
        }else if (m_aswini && f_mrigaB2) {
            m_guna.setText("26.18");
        }else if (m_aswini && f_aadra) {
            m_guna.setText("18.18");
        }else if (m_aswini && f_punarvasu3) {
            m_guna.setText("18.18");
        }else if (m_aswini && f_punarvasu1) {
            m_guna.setText("22.18");
        }else if (m_aswini && f_tisya) {
            m_guna.setText("31.18");
        }else if (m_aswini && f_ashlesha) {
            m_guna.setText("26");
        }else if (m_aswini && f_magha) {
            m_guna.setText("21");
        }else if (m_aswini && f_pufa) {
            m_guna.setText("27");
        }else if (m_aswini && f_ufa1) {
            m_guna.setText("18.18");
        }else if (m_aswini && f_ufa3) {
            m_guna.setText("12.18");
        }else if (m_aswini && f_hasta) {
            m_guna.setText("10.18");
        }else if (m_aswini && f_chitraA2) {
            m_guna.setText("12.18");
        }else if (m_aswini && f_chitraB2) {
            m_guna.setText("22");
        }else if (m_aswini && f_swati) {
            m_guna.setText("28");
        }else if (m_aswini && f_vishakha3) {
            m_guna.setText("22");
        }else if (m_aswini && f_vishakha1) {
            m_guna.setText("17.18");
        }else if (m_aswini && f_anuradha) {
            m_guna.setText("25.18");
        }else if (m_aswini && f_jestha) {
            m_guna.setText("13");
        }else if (m_aswini && f_mula) {
            m_guna.setText("11.18");
        }else if (m_aswini && f_pusha1) {
            m_guna.setText("25.18");
        }else if (m_aswini && f_pusha3) {
            m_guna.setText("27");
        }else if (m_aswini && f_usha1) {
            m_guna.setText("24");
        }else if (m_aswini && f_usha3) {
            m_guna.setText("28");
        }else if (m_aswini && f_shravana) {
            m_guna.setText("27.27");
        }else if (m_aswini && f_dhanisthaA2) {
            m_guna.setText("21");
        }else if (m_aswini && f_dhanisthaB2) {
            m_guna.setText("19.18");
        }else if (m_aswini && f_shatavisha) {
            m_guna.setText("14.18");
        }else if (m_aswini && f_pubha3) {
            m_guna.setText("17.18");
        }else if (m_aswini && f_pubha1) {
            m_guna.setText("15.18");
        }else if (m_aswini && f_ubha) {
            m_guna.setText("25.18");
        }else if (m_aswini && f_revati) {
            m_guna.setText("26");
        }
    }

    public void mBhariniToFALL(){

        if (m_bharani && f_aswini){
            m_guna.setText("33");
        }else if (m_bharani && f_bharani) {
            m_guna.setText("28");
        }else if (m_bharani && f_kritika1) {
            m_guna.setText("29");
        }else if (m_bharani && f_kritika3) {
            m_guna.setText("20");
        }else if (m_bharani && f_rohini) {
            m_guna.setText("23.18");
        }else if (m_bharani && f_mrigaA2) {
            m_guna.setText("14.18");
        }else if (m_bharani && f_mrigaB2) {
            m_guna.setText("17.18");
        }else if (m_bharani && f_aadra) {
            m_guna.setText("26.18");
        }else if (m_bharani && f_punarvasu3) {
            m_guna.setText("25.18");
        }else if (m_bharani && f_punarvasu1) {
            m_guna.setText("29.18");
        }else if (m_bharani && f_tisya) {
            m_guna.setText("22.18");
        }else if (m_bharani && f_ashlesha) {
            m_guna.setText("24.18");
        }else if (m_bharani && f_magha) {
            m_guna.setText("21");
        }else if (m_bharani && f_pufa) {
            m_guna.setText("19");
        }else if (m_bharani && f_ufa1) {
            m_guna.setText("27");
        }else if (m_bharani && f_ufa3) {
            m_guna.setText("21");
        }else if (m_bharani && f_hasta) {
            m_guna.setText("19.18");
        }else if (m_bharani && f_chitraA2) {
            m_guna.setText("5.18");
        }else if (m_bharani && f_chitraB2) {
            m_guna.setText("15");
        }else if (m_bharani && f_swati) {
            m_guna.setText("29");
        }else if (m_bharani && f_vishakha3) {
            m_guna.setText("23");
        }else if (m_bharani && f_vishakha1) {
            m_guna.setText("18.18");
        }else if (m_bharani && f_anuradha) {
            m_guna.setText("15.18");
        }else if (m_bharani && f_jestha) {
            m_guna.setText("18.18");
        }else if (m_bharani && f_mula) {
            m_guna.setText("19.18");
        }else if (m_bharani && f_pusha1) {
            m_guna.setText("18.18");
        }else if (m_bharani && f_pusha3) {
            m_guna.setText("20");
        }else if (m_bharani && f_usha1) {
            m_guna.setText("25.18");
        }else if (m_bharani && f_usha3) {
            m_guna.setText("29.18");
        }else if (m_bharani && f_shravana) {
            m_guna.setText("27.09");
        }else if (m_bharani && f_dhanisthaA2) {
            m_guna.setText("12");
        }else if (m_bharani && f_dhanisthaB2) {
            m_guna.setText("10.18");
        }else if (m_bharani && f_shatavisha) {
            m_guna.setText("20.18");
        }else if (m_bharani && f_pubha3) {
            m_guna.setText("24.18");
        }else if (m_bharani && f_pubha1) {
            m_guna.setText("22.18");
        }else if (m_bharani && f_ubha) {
            m_guna.setText("16.18");
        }else if (m_bharani && f_revati) {
            m_guna.setText("25.18");
        }
    }
    public void mKritika1ToFALL(){

        if (m_kritika1 && f_aswini){
            m_guna.setText("28.18");
        }else if (m_kritika1 && f_bharani) {
            m_guna.setText("29");
        }else if (m_kritika1 && f_kritika1) {
            m_guna.setText("28");
        }else if (m_kritika1 && f_kritika3) {
            m_guna.setText("19");
        }else if (m_kritika1 && f_rohini) {
            m_guna.setText("12");
        }else if (m_kritika1 && f_mrigaA2) {
            m_guna.setText("19.18");
        }else if (m_kritika1 && f_mrigaB2) {
            m_guna.setText("22.18");
        }else if (m_kritika1 && f_aadra) {
            m_guna.setText("20.18");
        }else if (m_kritika1 && f_punarvasu3) {
            m_guna.setText("22.18");
        }else if (m_kritika1 && f_punarvasu1) {
            m_guna.setText("26.18");
        }else if (m_kritika1 && f_tisya) {
            m_guna.setText("27.18");
        }else if (m_kritika1 && f_ashlesha) {
            m_guna.setText("23.18");
        }else if (m_kritika1 && f_magha) {
            m_guna.setText("17.18");
        }else if (m_kritika1 && f_pufa) {
            m_guna.setText("21");
        }else if (m_kritika1 && f_ufa1) {
            m_guna.setText("22");
        }else if (m_kritika1 && f_ufa3) {
            m_guna.setText("16");
        }else if (m_kritika1 && f_hasta) {
            m_guna.setText("17");
        }else if (m_kritika1 && f_chitraA2) {
            m_guna.setText("18.18");
        }else if (m_kritika1 && f_chitraB2) {
            m_guna.setText("28");
        }else if (m_kritika1 && f_swati) {
            m_guna.setText("17");
        }else if (m_kritika1 && f_vishakha3) {
            m_guna.setText("20");
        }else if (m_kritika1 && f_vishakha1) {
            m_guna.setText("15.18");
        }else if (m_kritika1 && f_anuradha) {
            m_guna.setText("20.18");
        }else if (m_kritika1 && f_jestha) {
            m_guna.setText("25.18");
        }else if (m_kritika1 && f_mula) {
            m_guna.setText("24");
        }else if (m_kritika1 && f_pusha1) {
            m_guna.setText("17.18");
        }else if (m_kritika1 && f_pusha3) {
            m_guna.setText("19");
        }else if (m_kritika1 && f_usha1) {
            m_guna.setText("12.18");
        }else if (m_kritika1 && f_usha3) {
            m_guna.setText("16.18");
        }else if (m_kritika1 && f_shravana) {
            m_guna.setText("13.27");
        }else if (m_kritika1 && f_dhanisthaA2) {
            m_guna.setText("27");
        }else if (m_kritika1 && f_dhanisthaB2) {
            m_guna.setText("25.18");
        }else if (m_kritika1 && f_shatavisha) {
            m_guna.setText("27.18");
        }else if (m_kritika1 && f_pubha3) {
            m_guna.setText("19.18");
        }else if (m_kritika1 && f_pubha1) {
            m_guna.setText("17.18");
        }else if (m_kritika1 && f_ubha) {
            m_guna.setText("19.18");
        }else if (m_kritika1 && f_revati) {
            m_guna.setText("12.18");
        }
    }
    public void mKritika3ToFALL(){

        if (m_kritika3 && f_aswini){
            m_guna.setText("18.18");
        }else if (m_kritika3 && f_bharani) {
            m_guna.setText("19");
        }else if (m_kritika3 && f_kritika1) {
            m_guna.setText("18");
        }else if (m_kritika3 && f_kritika3) {
            m_guna.setText("28");
        }else if (m_kritika3 && f_rohini) {
            m_guna.setText("21");
        }else if (m_kritika3 && f_mrigaA2) {
            m_guna.setText("28.18");
        }else if (m_kritika3 && f_mrigaB2) {
            m_guna.setText("20");
        }else if (m_kritika3 && f_aadra) {
            m_guna.setText("18");
        }else if (m_kritika3 && f_punarvasu3) {
            m_guna.setText("20");
        }else if (m_kritika3 && f_punarvasu1) {
            m_guna.setText("23");
        }else if (m_kritika3 && f_tisya) {
            m_guna.setText("24");
        }else if (m_kritika3 && f_ashlesha) {
            m_guna.setText("20");
        }else if (m_kritika3 && f_magha) {
            m_guna.setText("18.18");
        }else if (m_kritika3 && f_pufa) {
            m_guna.setText("22");
        }else if (m_kritika3 && f_ufa1) {
            m_guna.setText("23");
        }else if (m_kritika3 && f_ufa3) {
            m_guna.setText("20.18");
        }else if (m_kritika3 && f_hasta) {
            m_guna.setText("21.18");
        }else if (m_kritika3 && f_chitraA2) {
            m_guna.setText("23");
        }else if (m_kritika3 && f_chitraB2) {
            m_guna.setText("23");
        }else if (m_kritika3 && f_swati) {
            m_guna.setText("12");
        }else if (m_kritika3 && f_vishakha3) {
            m_guna.setText("15");
        }else if (m_kritika3 && f_vishakha1) {
            m_guna.setText("20.18");
        }else if (m_kritika3 && f_anuradha) {
            m_guna.setText("25.18");
        }else if (m_kritika3 && f_jestha) {
            m_guna.setText("30.18");
        }else if (m_kritika3 && f_mula) {
            m_guna.setText("18.18");
        }else if (m_kritika3 && f_pusha1) {
            m_guna.setText("12");
        }else if (m_kritika3 && f_pusha3) {
            m_guna.setText("13.18");
        }else if (m_kritika3 && f_usha1) {
            m_guna.setText("7");
        }else if (m_kritika3 && f_usha3) {
            m_guna.setText("14");
        }else if (m_kritika3 && f_shravana) {
            m_guna.setText("11.09");
        }else if (m_kritika3 && f_dhanisthaA2) {
            m_guna.setText("24.18");
        }else if (m_kritika3 && f_dhanisthaB2) {
            m_guna.setText("30");
        }else if (m_kritika3 && f_shatavisha) {
            m_guna.setText("32");
        }else if (m_kritika3 && f_pubha3) {
            m_guna.setText("24");
        }else if (m_kritika3 && f_pubha1) {
            m_guna.setText("20");
        }else if (m_kritika3 && f_ubha) {
            m_guna.setText("22");
        }else if (m_kritika3 && f_revati) {
            m_guna.setText("15");
        }
    }
    public void mRohiniToFALL(){

        if (m_rohini && f_aswini){
            m_guna.setText("21.18");
        }else if (m_rohini && f_bharani) {
            m_guna.setText("22.18");
        }else if (m_rohini && f_kritika1) {
            m_guna.setText("11");
        }else if (m_rohini && f_kritika3) {
            m_guna.setText("21");
        }else if (m_rohini && f_rohini) {
            m_guna.setText("28");
        }else if (m_rohini && f_mrigaA2) {
            m_guna.setText("35");
        }else if (m_rohini && f_mrigaB2) {
            m_guna.setText("26.18");
        }else if (m_rohini && f_aadra) {
            m_guna.setText("24");
        }else if (m_rohini && f_punarvasu3) {
            m_guna.setText("23");
        }else if (m_rohini && f_punarvasu1) {
            m_guna.setText("26");
        }else if (m_rohini && f_tisya) {
            m_guna.setText("27");
        }else if (m_rohini && f_ashlesha) {
            m_guna.setText("13");
        }else if (m_rohini && f_magha) {
            m_guna.setText("11.18");
        }else if (m_rohini && f_pufa) {
            m_guna.setText("25.18");
        }else if (m_rohini && f_ufa1) {
            m_guna.setText("27");
        }else if (m_rohini && f_ufa3) {
            m_guna.setText("24.18");
        }else if (m_rohini && f_hasta) {
            m_guna.setText("24.18");
        }else if (m_rohini && f_chitraA2) {
            m_guna.setText("19.18");
        }else if (m_rohini && f_chitraB2) {
            m_guna.setText("19.18");
        }else if (m_rohini && f_swati) {
            m_guna.setText("15");
        }else if (m_rohini && f_vishakha3) {
            m_guna.setText("10");
        }else if (m_rohini && f_vishakha1) {
            m_guna.setText("15.18");
        }else if (m_rohini && f_anuradha) {
            m_guna.setText("28.18");
        }else if (m_rohini && f_jestha) {
            m_guna.setText("23.18");
        }else if (m_rohini && f_mula) {
            m_guna.setText("12.18");
        }else if (m_rohini && f_pusha1) {
            m_guna.setText("18.18");
        }else if (m_rohini && f_pusha3) {
            m_guna.setText("20");
        }else if (m_rohini && f_usha1) {
            m_guna.setText("10");
        }else if (m_rohini && f_usha3) {
            m_guna.setText("17");
        }else if (m_rohini && f_shravana) {
            m_guna.setText("17.09");
        }else if (m_rohini && f_dhanisthaA2) {
            m_guna.setText("21");
        }else if (m_rohini && f_dhanisthaB2) {
            m_guna.setText("26.18");
        }else if (m_rohini && f_shatavisha) {
            m_guna.setText("25");
        }else if (m_rohini && f_pubha3) {
            m_guna.setText("31");
        }else if (m_rohini && f_pubha1) {
            m_guna.setText("27");
        }else if (m_rohini && f_ubha) {
            m_guna.setText("26");
        }else if (m_rohini && f_revati) {
            m_guna.setText("18");
        }
    }
    public void mMrigaA2ToFALL(){

        if (m_mrigaA2 && f_aswini){
            m_guna.setText("22.18");
        }else if (m_mrigaA2 && f_bharani) {
            m_guna.setText("14.18");
        }else if (m_mrigaA2 && f_kritika1) {
            m_guna.setText("17.18");
        }else if (m_mrigaA2 && f_kritika3) {
            m_guna.setText("27.18");
        }else if (m_mrigaA2 && f_rohini) {
            m_guna.setText("36");
        }else if (m_mrigaA2 && f_mrigaA2) {
            m_guna.setText("28");
        }else if (m_mrigaA2 && f_mrigaB2) {
            m_guna.setText("19.18");
        }else if (m_mrigaA2 && f_aadra) {
            m_guna.setText("25.18");
        }else if (m_mrigaA2 && f_punarvasu3) {
            m_guna.setText("24");
        }else if (m_mrigaA2 && f_punarvasu1) {
            m_guna.setText("27");
        }else if (m_mrigaA2 && f_tisya) {
            m_guna.setText("20");
        }else if (m_mrigaA2 && f_ashlesha) {
            m_guna.setText("21");
        }else if (m_mrigaA2 && f_magha) {
            m_guna.setText("19.18");
        }else if (m_mrigaA2 && f_pufa) {
            m_guna.setText("17.18");
        }else if (m_mrigaA2 && f_ufa1) {
            m_guna.setText("25.18");
        }else if (m_mrigaA2 && f_ufa3) {
            m_guna.setText("23");
        }else if (m_mrigaA2 && f_hasta) {
            m_guna.setText("25.18");
        }else if (m_mrigaA2 && f_chitraA2) {
            m_guna.setText("11.18");
        }else if (m_mrigaA2 && f_chitraB2) {
            m_guna.setText("11.18");
        }else if (m_mrigaA2 && f_swati) {
            m_guna.setText("25.18");
        }else if (m_mrigaA2 && f_vishakha3) {
            m_guna.setText("18");
        }else if (m_mrigaA2 && f_vishakha1) {
            m_guna.setText("23.18");
        }else if (m_mrigaA2 && f_anuradha) {
            m_guna.setText("21.18");
        }else if (m_mrigaA2 && f_jestha) {
            m_guna.setText("23.18");
        }else if (m_mrigaA2 && f_mula) {
            m_guna.setText("12.18");
        }else if (m_mrigaA2 && f_pusha1) {
            m_guna.setText("10.18");
        }else if (m_mrigaA2 && f_pusha3) {
            m_guna.setText("12");
        }else if (m_mrigaA2 && f_usha1) {
            m_guna.setText("16.18");
        }else if (m_mrigaA2 && f_usha3) {
            m_guna.setText("23.18");
        }else if (m_mrigaA2 && f_shravana) {
            m_guna.setText("26.09");
        }else if (m_mrigaA2 && f_dhanisthaA2) {
            m_guna.setText("13");
        }else if (m_mrigaA2 && f_dhanisthaB2) {
            m_guna.setText("18.18");
        }else if (m_mrigaA2 && f_shatavisha) {
            m_guna.setText("26.18");
        }else if (m_mrigaA2 && f_pubha3) {
            m_guna.setText("31");
        }else if (m_mrigaA2 && f_pubha1) {
            m_guna.setText("27");
        }else if (m_mrigaA2 && f_ubha) {
            m_guna.setText("18");
        }else if (m_mrigaA2 && f_revati) {
            m_guna.setText("27");
        }
    }
    public void mMrigaB2ToFALL(){

        if (m_mrigaB2 && f_aswini){
            m_guna.setText("25.18");
        }else if (m_mrigaB2 && f_bharani) {
            m_guna.setText("17.18");
        }else if (m_mrigaB2 && f_kritika1) {
            m_guna.setText("20.18");
        }else if (m_mrigaB2 && f_kritika3) {
            m_guna.setText("18");
        }else if (m_mrigaB2 && f_rohini) {
            m_guna.setText("26.18");
        }else if (m_mrigaB2 && f_mrigaA2) {
            m_guna.setText("18.18");
        }else if (m_mrigaB2 && f_mrigaB2) {
            m_guna.setText("28");
        }else if (m_mrigaB2 && f_aadra) {
            m_guna.setText("34");
        }else if (m_mrigaB2 && f_punarvasu3) {
            m_guna.setText("32.18");
        }else if (m_mrigaB2 && f_punarvasu1) {
            m_guna.setText("19");
        }else if (m_mrigaB2 && f_tisya) {
            m_guna.setText("12");
        }else if (m_mrigaB2 && f_ashlesha) {
            m_guna.setText("13");
        }else if (m_mrigaB2 && f_magha) {
            m_guna.setText("22");
        }else if (m_mrigaB2 && f_pufa) {
            m_guna.setText("20");
        }else if (m_mrigaB2 && f_ufa1) {
            m_guna.setText("28");
        }else if (m_mrigaB2 && f_ufa3) {
            m_guna.setText("30.18");
        }else if (m_mrigaB2 && f_hasta) {
            m_guna.setText("33");
        }else if (m_mrigaB2 && f_chitraA2) {
            m_guna.setText("19");
        }else if (m_mrigaB2 && f_chitraB2) {
            m_guna.setText("13");
        }else if (m_mrigaB2 && f_swati) {
            m_guna.setText("27");
        }else if (m_mrigaB2 && f_vishakha3) {
            m_guna.setText("19.18");
        }else if (m_mrigaB2 && f_vishakha1) {
            m_guna.setText("13");
        }else if (m_mrigaB2 && f_anuradha) {
            m_guna.setText("11");
        }else if (m_mrigaB2 && f_jestha) {
            m_guna.setText("13");
        }else if (m_mrigaB2 && f_mula) {
            m_guna.setText("21");
        }else if (m_mrigaB2 && f_pusha1) {
            m_guna.setText("19");
        }else if (m_mrigaB2 && f_pusha3) {
            m_guna.setText("17.18");
        }else if (m_mrigaB2 && f_usha1) {
            m_guna.setText("25");
        }else if (m_mrigaB2 && f_usha3) {
            m_guna.setText("20");
        }else if (m_mrigaB2 && f_shravana) {
            m_guna.setText("24.09");
        }else if (m_mrigaB2 && f_dhanisthaA2) {
            m_guna.setText("9.18");
        }else if (m_mrigaB2 && f_dhanisthaB2) {
            m_guna.setText("12");
        }else if (m_mrigaB2 && f_shatavisha) {
            m_guna.setText("20");
        }else if (m_mrigaB2 && f_pubha3) {
            m_guna.setText("24.18");
        }else if (m_mrigaB2 && f_pubha1) {
            m_guna.setText("25.18");
        }else if (m_mrigaB2 && f_ubha) {
            m_guna.setText("16.18");
        }else if (m_mrigaB2 && f_revati) {
            m_guna.setText("25.18");
        }
    }
    public void mAdraToFALL(){

        if (m_aadra && f_aswini){
            m_guna.setText("16.18");
        }else if (m_aadra && f_bharani) {
            m_guna.setText("25.18");
        }else if (m_aadra && f_kritika1) {
            m_guna.setText("19.18");
        }else if (m_aadra && f_kritika3) {
            m_guna.setText("17");
        }else if (m_aadra && f_rohini) {
            m_guna.setText("23");
        }else if (m_aadra && f_mrigaA2) {
            m_guna.setText("23.18");
        }else if (m_aadra && f_mrigaB2) {
            m_guna.setText("33");
        }else if (m_aadra && f_aadra) {
            m_guna.setText("28");
        }else if (m_aadra && f_punarvasu3) {
            m_guna.setText("24");
        }else if (m_aadra && f_punarvasu1) {
            m_guna.setText("10.18");
        }else if (m_aadra && f_tisya) {
            m_guna.setText("18");
        }else if (m_aadra && f_ashlesha) {
            m_guna.setText("12");
        }else if (m_aadra && f_magha) {
            m_guna.setText("22");
        }else if (m_aadra && f_pufa) {
            m_guna.setText("28");
        }else if (m_aadra && f_ufa1) {
            m_guna.setText("21");
        }else if (m_aadra && f_ufa3) {
            m_guna.setText("23.18");
        }else if (m_aadra && f_hasta) {
            m_guna.setText("22.18");
        }else if (m_aadra && f_chitraA2) {
            m_guna.setText("26");
        }else if (m_aadra && f_chitraB2) {
            m_guna.setText("20");
        }else if (m_aadra && f_swati) {
            m_guna.setText("26");
        }else if (m_aadra && f_vishakha3) {
            m_guna.setText("20");
        }else if (m_aadra && f_vishakha1) {
            m_guna.setText("13.18");
        }else if (m_aadra && f_anuradha) {
            m_guna.setText("16");
        }else if (m_aadra && f_jestha) {
            m_guna.setText("3");
        }else if (m_aadra && f_mula) {
            m_guna.setText("15");
        }else if (m_aadra && f_pusha1) {
            m_guna.setText("27");
        }else if (m_aadra && f_pusha3) {
            m_guna.setText("25.18");
        }else if (m_aadra && f_usha1) {
            m_guna.setText("27");
        }else if (m_aadra && f_usha3) {
            m_guna.setText("22");
        }else if (m_aadra && f_shravana) {
            m_guna.setText("21.09");
        }else if (m_aadra && f_dhanisthaA2) {
            m_guna.setText("16.18");
        }else if (m_aadra && f_dhanisthaB2) {
            m_guna.setText("19");
        }else if (m_aadra && f_shatavisha) {
            m_guna.setText("12");
        }else if (m_aadra && f_pubha3) {
            m_guna.setText("17");
        }else if (m_aadra && f_pubha1) {
            m_guna.setText("18");
        }else if (m_aadra && f_ubha) {
            m_guna.setText("25.18");
        }else if (m_aadra && f_revati) {
            m_guna.setText("24.18");
        }
    }
    public void mPunarvasu3ToFALL() {

        if (m_punarvasu3 && f_aswini){
            m_guna.setText("18.18");
        }else if (m_punarvasu3 && f_bharani) {
            m_guna.setText("26.18");
        }else if (m_punarvasu3 && f_kritika1) {
            m_guna.setText("20.18");
        }else if (m_punarvasu3 && f_kritika3) {
            m_guna.setText("18");
        }else if (m_punarvasu3 && f_rohini) {
            m_guna.setText("23");
        }else if (m_punarvasu3 && f_mrigaA2) {
            m_guna.setText("23");
        }else if (m_punarvasu3 && f_mrigaB2) {
            m_guna.setText("32.18");
        }else if (m_punarvasu3 && f_aadra) {
            m_guna.setText("25");
        }else if (m_punarvasu3 && f_punarvasu3) {
            m_guna.setText("28");
        }else if (m_punarvasu3 && f_punarvasu1) {
            m_guna.setText("14.18");
        }else if (m_punarvasu3 && f_tisya) {
            m_guna.setText("21.18");
        }else if (m_punarvasu3 && f_ashlesha) {
            m_guna.setText("15");
        }else if (m_punarvasu3 && f_magha) {
            m_guna.setText("21");
        }else if (m_punarvasu3 && f_pufa) {
            m_guna.setText("27");
        }else if (m_punarvasu3 && f_ufa1) {
            m_guna.setText("21");
        }else if (m_punarvasu3 && f_ufa3) {
            m_guna.setText("23.18");
        }else if (m_punarvasu3 && f_hasta) {
            m_guna.setText("23.18");
        }else if (m_punarvasu3 && f_chitraA2) {
            m_guna.setText("24.18");
        }else if (m_punarvasu3 && f_chitraB2) {
            m_guna.setText("28.18");
        }else if (m_punarvasu3 && f_swati) {
            m_guna.setText("27");
        }else if (m_punarvasu3 && f_vishakha3) {
            m_guna.setText("20");
        }else if (m_punarvasu3 && f_vishakha1) {
            m_guna.setText("13.18");
        }else if (m_punarvasu3 && f_anuradha) {
            m_guna.setText("20.18");
        }else if (m_punarvasu3 && f_jestha) {
            m_guna.setText("5");
        }else if (m_punarvasu3 && f_mula) {
            m_guna.setText("12");
        }else if (m_punarvasu3 && f_pusha1) {
            m_guna.setText("27");
        }else if (m_punarvasu3 && f_pusha3) {
            m_guna.setText("25.18");
        }else if (m_punarvasu3 && f_usha1) {
            m_guna.setText("27");
        }else if (m_punarvasu3 && f_usha3) {
            m_guna.setText("22");
        }else if (m_punarvasu3 && f_shravana) {
            m_guna.setText("22.09");
        }else if (m_punarvasu3 && f_dhanisthaA2) {
            m_guna.setText("16");
        }else if (m_punarvasu3 && f_dhanisthaB2) {
            m_guna.setText("18.18");
        }else if (m_punarvasu3 && f_shatavisha) {
            m_guna.setText("13");
        }else if (m_punarvasu3 && f_pubha3) {
            m_guna.setText("18");
        }else if (m_punarvasu3 && f_pubha1) {
            m_guna.setText("19");
        }else if (m_punarvasu3 && f_ubha) {
            m_guna.setText("27");
        }else if (m_punarvasu3 && f_revati) {
            m_guna.setText("26.18");
        }
    }
    public void mPunarvasu1ToFALL(){

        if (m_punarvasu1 && f_aswini){
            m_guna.setText("24.18");
        }else if (m_punarvasu1 && f_bharani) {
            m_guna.setText("32.18");
        }else if (m_punarvasu1 && f_kritika1) {
            m_guna.setText("26.18");
        }else if (m_punarvasu1 && f_kritika3) {
            m_guna.setText("23");
        }else if (m_punarvasu1 && f_rohini) {
            m_guna.setText("28");
        }else if (m_punarvasu1 && f_mrigaA2) {
            m_guna.setText("28");
        }else if (m_punarvasu1 && f_mrigaB2) {
            m_guna.setText("20");
        }else if (m_punarvasu1 && f_aadra) {
            m_guna.setText("12.18");
        }else if (m_punarvasu1 && f_punarvasu3) {
            m_guna.setText("15.18");
        }else if (m_punarvasu1 && f_punarvasu1) {
            m_guna.setText("28");
        }else if (m_punarvasu1 && f_tisya) {
            m_guna.setText("35");
        }else if (m_punarvasu1 && f_ashlesha) {
            m_guna.setText("28.18");
        }else if (m_punarvasu1 && f_magha) {
            m_guna.setText("17.18");
        }else if (m_punarvasu1 && f_pufa) {
            m_guna.setText("23.18");
        }else if (m_punarvasu1 && f_ufa1) {
            m_guna.setText("17.18");
        }else if (m_punarvasu1 && f_ufa3) {
            m_guna.setText("19");
        }else if (m_punarvasu1 && f_hasta) {
            m_guna.setText("19");
        }else if (m_punarvasu1 && f_chitraA2) {
            m_guna.setText("20");
        }else if (m_punarvasu1 && f_chitraB2) {
            m_guna.setText("19.18");
        }else if (m_punarvasu1 && f_swati) {
            m_guna.setText("28");
        }else if (m_punarvasu1 && f_vishakha3) {
            m_guna.setText("21");
        }else if (m_punarvasu1 && f_vishakha1) {
            m_guna.setText("19");
        }else if (m_punarvasu1 && f_anuradha) {
            m_guna.setText("26");
        }else if (m_punarvasu1 && f_jestha) {
            m_guna.setText("10.18");
        }else if (m_punarvasu1 && f_mula) {
            m_guna.setText("8");
        }else if (m_punarvasu1 && f_pusha1) {
            m_guna.setText("23");
        }else if (m_punarvasu1 && f_pusha3) {
            m_guna.setText("24.18");
        }else if (m_punarvasu1 && f_usha1) {
            m_guna.setText("23");
        }else if (m_punarvasu1 && f_usha3) {
            m_guna.setText("28");
        }else if (m_punarvasu1 && f_shravana) {
            m_guna.setText("27.09");
        }else if (m_punarvasu1 && f_dhanisthaA2) {
            m_guna.setText("22");
        }else if (m_punarvasu1 && f_dhanisthaB2) {
            m_guna.setText("13.18");
        }else if (m_punarvasu1 && f_shatavisha) {
            m_guna.setText("8");
        }else if (m_punarvasu1 && f_pubha3) {
            m_guna.setText("13");
        }else if (m_punarvasu1 && f_pubha1) {
            m_guna.setText("18");
        }else if (m_punarvasu1 && f_ubha) {
            m_guna.setText("26");
        }else if (m_punarvasu1 && f_revati) {
            m_guna.setText("25.18");
        }
    }
    public void mTishyaToFALL(){

        if (m_tisya && f_aswini){
            m_guna.setText("32.18");
        }else if (m_tisya && f_bharani) {
            m_guna.setText("24.18");
        }else if (m_tisya && f_kritika1) {
            m_guna.setText("27.18");
        }else if (m_tisya && f_kritika3) {
            m_guna.setText("24");
        }else if (m_tisya && f_rohini) {
            m_guna.setText("29");
        }else if (m_tisya && f_mrigaA2) {
            m_guna.setText("21");
        }else if (m_tisya && f_mrigaB2) {
            m_guna.setText("13");
        }else if (m_tisya && f_aadra) {
            m_guna.setText("20");
        }else if (m_tisya && f_punarvasu3) {
            m_guna.setText("22.18");
        }else if (m_tisya && f_punarvasu1) {
            m_guna.setText("35");
        }else if (m_tisya && f_tisya) {
            m_guna.setText("28");
        }else if (m_tisya && f_ashlesha) {
            m_guna.setText("29");
        }else if (m_tisya && f_magha) {
            m_guna.setText("19.18");
        }else if (m_tisya && f_pufa) {
            m_guna.setText("17.18");
        }else if (m_tisya && f_ufa1) {
            m_guna.setText("26.18");
        }else if (m_tisya && f_ufa3) {
            m_guna.setText("28");
        }else if (m_tisya && f_hasta) {
            m_guna.setText("28");
        }else if (m_tisya && f_chitraA2) {
            m_guna.setText("12");
        }else if (m_tisya && f_chitraB2) {
            m_guna.setText("11.18");
        }else if (m_tisya && f_swati) {
            m_guna.setText("27.18");
        }else if (m_tisya && f_vishakha3) {
            m_guna.setText("21");
        }else if (m_tisya && f_vishakha1) {
            m_guna.setText("19");
        }else if (m_tisya && f_anuradha) {
            m_guna.setText("19");
        }else if (m_tisya && f_jestha) {
            m_guna.setText("21");
        }else if (m_tisya && f_mula) {
            m_guna.setText("17");
        }else if (m_tisya && f_pusha1) {
            m_guna.setText("13");
        }else if (m_tisya && f_pusha3) {
            m_guna.setText("14.18");
        }else if (m_tisya && f_usha1) {
            m_guna.setText("24");
        }else if (m_tisya && f_usha3) {
            m_guna.setText("29");
        }else if (m_tisya && f_shravana) {
            m_guna.setText("25.09");
        }else if (m_tisya && f_dhanisthaA2) {
            m_guna.setText("13");
        }else if (m_tisya && f_dhanisthaB2) {
            m_guna.setText("4.18");
        }else if (m_tisya && f_shatavisha) {
            m_guna.setText("14.18");
        }else if (m_tisya && f_pubha3) {
            m_guna.setText("20");
        }else if (m_tisya && f_pubha1) {
            m_guna.setText("25");
        }else if (m_tisya && f_ubha) {
            m_guna.setText("19");
        }else if (m_tisya && f_revati) {
            m_guna.setText("27");
        }
    }
    public void mAshleshaToFALL(){

        if (m_ashlesha && f_aswini){
            m_guna.setText("29");
        }else if (m_ashlesha && f_bharani) {
            m_guna.setText("26.18");
        }else if (m_ashlesha && f_kritika1) {
            m_guna.setText("24.18");
        }else if (m_ashlesha && f_kritika3) {
            m_guna.setText("21");
        }else if (m_ashlesha && f_rohini) {
            m_guna.setText("14");
        }else if (m_ashlesha && f_mrigaA2) {
            m_guna.setText("23");
        }else if (m_ashlesha && f_mrigaB2) {
            m_guna.setText("15");
        }else if (m_ashlesha && f_aadra) {
            m_guna.setText("13");
        }else if (m_ashlesha && f_punarvasu3) {
            m_guna.setText("17");
        }else if (m_ashlesha && f_punarvasu1) {
            m_guna.setText("29.18");
        }else if (m_ashlesha && f_tisya) {
            m_guna.setText("30");
        }else if (m_ashlesha && f_ashlesha) {
            m_guna.setText("28");
        }else if (m_ashlesha && f_magha) {
            m_guna.setText("17");
        }else if (m_ashlesha && f_pufa) {
            m_guna.setText("17.18");
        }else if (m_ashlesha && f_ufa1) {
            m_guna.setText("19.18");
        }else if (m_ashlesha && f_ufa3) {
            m_guna.setText("21");
        }else if (m_ashlesha && f_hasta) {
            m_guna.setText("22");
        }else if (m_ashlesha && f_chitraA2) {
            m_guna.setText("26");
        }else if (m_ashlesha && f_chitraB2) {
            m_guna.setText("25.18");
        }else if (m_ashlesha && f_swati) {
            m_guna.setText("13.18");
        }else if (m_ashlesha && f_vishakha3) {
            m_guna.setText("17.18");
        }else if (m_ashlesha && f_vishakha1) {
            m_guna.setText("15.18");
        }else if (m_ashlesha && f_anuradha) {
            m_guna.setText("21");
        }else if (m_ashlesha && f_jestha) {
            m_guna.setText("26");
        }else if (m_ashlesha && f_mula) {
            m_guna.setText("23.18");
        }else if (m_ashlesha && f_pusha1) {
            m_guna.setText("17");
        }else if (m_ashlesha && f_pusha3) {
            m_guna.setText("18.18");
        }else if (m_ashlesha && f_usha1) {
            m_guna.setText("9");
        }else if (m_ashlesha && f_usha3) {
            m_guna.setText("14");
        }else if (m_ashlesha && f_shravana) {
            m_guna.setText("14.09");
        }else if (m_ashlesha && f_dhanisthaA2) {
            m_guna.setText("28");
        }else if (m_ashlesha && f_dhanisthaB2) {
            m_guna.setText("19.18");
        }else if (m_ashlesha && f_shatavisha) {
            m_guna.setText("20.18");
        }else if (m_ashlesha && f_pubha3) {
            m_guna.setText("13.18");
        }else if (m_ashlesha && f_pubha1) {
            m_guna.setText("18.18");
        }else if (m_ashlesha && f_ubha) {
            m_guna.setText("20");
        }else if (m_ashlesha && f_revati) {
            m_guna.setText("14");
        }
    }
    public void mMaghaToFALL(){

        if (m_magha && f_aswini){
            m_guna.setText("23");
        }else if (m_magha && f_bharani) {
            m_guna.setText("22");
        }else if (m_magha && f_kritika1) {
            m_guna.setText("16.18");
        }else if (m_magha && f_kritika3) {
            m_guna.setText("18.18");
        }else if (m_magha && f_rohini) {
            m_guna.setText("12.18");
        }else if (m_magha && f_mrigaA2) {
            m_guna.setText("21.18");
        }else if (m_magha && f_mrigaB2) {
            m_guna.setText("24");
        }else if (m_magha && f_aadra) {
            m_guna.setText("23");
        }else if (m_magha && f_punarvasu3) {
            m_guna.setText("23");
        }else if (m_magha && f_punarvasu1) {
            m_guna.setText("17.18");
        }else if (m_magha && f_tisya) {
            m_guna.setText("18.18");
        }else if (m_magha && f_ashlesha) {
            m_guna.setText("16");
        }else if (m_magha && f_magha) {
            m_guna.setText("28");
        }else if (m_magha && f_pufa) {
            m_guna.setText("30");
        }else if (m_magha && f_ufa1) {
            m_guna.setText("26.18");
        }else if (m_magha && f_ufa3) {
            m_guna.setText("17");
        }else if (m_magha && f_hasta) {
            m_guna.setText("18");
        }else if (m_magha && f_chitraA2) {
            m_guna.setText("23");
        }else if (m_magha && f_chitraB2) {
            m_guna.setText("26");
        }else if (m_magha && f_swati) {
            m_guna.setText("13");
        }else if (m_magha && f_vishakha3) {
            m_guna.setText("18");
        }else if (m_magha && f_vishakha1) {
            m_guna.setText("23.18");
        }else if (m_magha && f_anuradha) {
            m_guna.setText("26.18");
        }else if (m_magha && f_jestha) {
            m_guna.setText("33");
        }else if (m_magha && f_mula) {
            m_guna.setText("24.18");
        }else if (m_magha && f_pusha1) {
            m_guna.setText("19.18");
        }else if (m_magha && f_pusha3) {
            m_guna.setText("21");
        }else if (m_magha && f_usha1) {
            m_guna.setText("10");
        }else if (m_magha && f_usha3) {
            m_guna.setText("6.18");
        }else if (m_magha && f_shravana) {
            m_guna.setText("6.27");
        }else if (m_magha && f_dhanisthaA2) {
            m_guna.setText("19.18");
        }else if (m_magha && f_dhanisthaB2) {
            m_guna.setText("25");
        }else if (m_magha && f_shatavisha) {
            m_guna.setText("27");
        }else if (m_magha && f_pubha3) {
            m_guna.setText("19");
        }else if (m_magha && f_pubha1) {
            m_guna.setText("17.18");
        }else if (m_magha && f_ubha) {
            m_guna.setText("18.18");
        }else if (m_magha && f_revati) {
            m_guna.setText("14");
        }
    }
    public void mPufaToFALL(){

        if (m_pufa && f_aswini){
            m_guna.setText("27");
        }else if (m_pufa && f_bharani) {
            m_guna.setText("20");
        }else if (m_pufa && f_kritika1) {
            m_guna.setText("20");
        }else if (m_pufa && f_kritika3) {
            m_guna.setText("22");
        }else if (m_pufa && f_rohini) {
            m_guna.setText("26.18");
        }else if (m_pufa && f_mrigaA2) {
            m_guna.setText("17.18");
        }else if (m_pufa && f_mrigaB2) {
            m_guna.setText("20");
        }else if (m_pufa && f_aadra) {
            m_guna.setText("29");
        }else if (m_pufa && f_punarvasu3) {
            m_guna.setText("27");
        }else if (m_pufa && f_punarvasu1) {
            m_guna.setText("21.18");
        }else if (m_pufa && f_tisya) {
            m_guna.setText("14.18");
        }else if (m_pufa && f_ashlesha) {
            m_guna.setText("16.18");
        }else if (m_pufa && f_magha) {
            m_guna.setText("30");
        }else if (m_pufa && f_pufa) {
            m_guna.setText("28");
        }else if (m_pufa && f_ufa1) {
            m_guna.setText("34");
        }else if (m_pufa && f_ufa3) {
            m_guna.setText("24.18");
        }else if (m_pufa && f_hasta) {
            m_guna.setText("22");
        }else if (m_pufa && f_chitraA2) {
            m_guna.setText("9");
        }else if (m_pufa && f_chitraB2) {
            m_guna.setText("12");
        }else if (m_pufa && f_swati) {
            m_guna.setText("25");
        }else if (m_pufa && f_vishakha3) {
            m_guna.setText("20");
        }else if (m_pufa && f_vishakha1) {
            m_guna.setText("25.18");
        }else if (m_pufa && f_anuradha) {
            m_guna.setText("22.18");
        }else if (m_pufa && f_jestha) {
            m_guna.setText("25.18");
        }else if (m_pufa && f_mula) {
            m_guna.setText("18.18");
        }else if (m_pufa && f_pusha1) {
            m_guna.setText("17.18");
        }else if (m_pufa && f_pusha3) {
            m_guna.setText("19");
        }else if (m_pufa && f_usha1) {
            m_guna.setText("25.18");
        }else if (m_pufa && f_usha3) {
            m_guna.setText("22");
        }else if (m_pufa && f_shravana) {
            m_guna.setText("17.27");
        }else if (m_pufa && f_dhanisthaA2) {
            m_guna.setText("5.18");
        }else if (m_pufa && f_dhanisthaB2) {
            m_guna.setText("11");
        }else if (m_pufa && f_shatavisha) {
            m_guna.setText("21");
        }else if (m_pufa && f_pubha3) {
            m_guna.setText("25");
        }else if (m_pufa && f_pubha1) {
            m_guna.setText("23.18");
        }else if (m_pufa && f_ubha) {
            m_guna.setText("16.18");
        }else if (m_pufa && f_revati) {
            m_guna.setText("24.18");
        }
    }
    public void mUfa1ToFALL(){

        if (m_ufa1 && f_aswini){
            m_guna.setText("17.18");
        }else if (m_ufa1 && f_bharani) {
            m_guna.setText("28");
        }else if (m_ufa1 && f_kritika1) {
            m_guna.setText("22");
        }else if (m_ufa1 && f_kritika3) {
            m_guna.setText("24");
        }else if (m_ufa1 && f_rohini) {
            m_guna.setText("28");
        }else if (m_ufa1 && f_mrigaA2) {
            m_guna.setText("25.18");
        }else if (m_ufa1 && f_mrigaB2) {
            m_guna.setText("28");
        }else if (m_ufa1 && f_aadra) {
            m_guna.setText("22");
        }else if (m_ufa1 && f_punarvasu3) {
            m_guna.setText("21");
        }else if (m_ufa1 && f_punarvasu1) {
            m_guna.setText("15.18");
        }else if (m_ufa1 && f_tisya) {
            m_guna.setText("24.18");
        }else if (m_ufa1 && f_ashlesha) {
            m_guna.setText("18.18");
        }else if (m_ufa1 && f_magha) {
            m_guna.setText("26.18");
        }else if (m_ufa1 && f_pufa) {
            m_guna.setText("34");
        }else if (m_ufa1 && f_ufa1) {
            m_guna.setText("28");
        }else if (m_ufa1 && f_ufa3) {
            m_guna.setText("18.18");
        }else if (m_ufa1 && f_hasta) {
            m_guna.setText("16.18");
        }else if (m_ufa1 && f_chitraA2) {
            m_guna.setText("15");
        }else if (m_ufa1 && f_chitraB2) {
            m_guna.setText("18");
        }else if (m_ufa1 && f_swati) {
            m_guna.setText("26");
        }else if (m_ufa1 && f_vishakha3) {
            m_guna.setText("18");
        }else if (m_ufa1 && f_vishakha1) {
            m_guna.setText("23.18");
        }else if (m_ufa1 && f_anuradha) {
            m_guna.setText("31.18");
        }else if (m_ufa1 && f_jestha) {
            m_guna.setText("18.18");
        }else if (m_ufa1 && f_mula) {
            m_guna.setText("10");
        }else if (m_ufa1 && f_pusha1) {
            m_guna.setText("25.18");
        }else if (m_ufa1 && f_pusha3) {
            m_guna.setText("27");
        }else if (m_ufa1 && f_usha1) {
            m_guna.setText("26.18");
        }else if (m_ufa1 && f_usha3) {
            m_guna.setText("23");
        }else if (m_ufa1 && f_shravana) {
            m_guna.setText("20.09");
        }else if (m_ufa1 && f_dhanisthaA2) {
            m_guna.setText("13.18");
        }else if (m_ufa1 && f_dhanisthaB2) {
            m_guna.setText("19");
        }else if (m_ufa1 && f_shatavisha) {
            m_guna.setText("13");
        }else if (m_ufa1 && f_pubha3) {
            m_guna.setText("17");
        }else if (m_ufa1 && f_pubha1) {
            m_guna.setText("15.18");
        }else if (m_ufa1 && f_ubha) {
            m_guna.setText("26.18");
        }else if (m_ufa1 && f_revati) {
            m_guna.setText("24.18");
        }
    }
    public void mUfa3ToFALL(){

        if (m_ufa3 && f_aswini){
            m_guna.setText("10.18");
        }else if (m_ufa3 && f_bharani) {
            m_guna.setText("21");
        }else if (m_ufa3 && f_kritika1) {
            m_guna.setText("15");
        }else if (m_ufa3 && f_kritika3) {
            m_guna.setText("20.18");
        }else if (m_ufa3 && f_rohini) {
            m_guna.setText("24.18");
        }else if (m_ufa3 && f_mrigaA2) {
            m_guna.setText("22");
        }else if (m_ufa3 && f_mrigaB2) {
            m_guna.setText("30.18");
        }else if (m_ufa3 && f_aadra) {
            m_guna.setText("24.18");
        }else if (m_ufa3 && f_punarvasu3) {
            m_guna.setText("23.18");
        }else if (m_ufa3 && f_punarvasu1) {
            m_guna.setText("17");
        }else if (m_ufa3 && f_tisya) {
            m_guna.setText("26");
        }else if (m_ufa3 && f_ashlesha) {
            m_guna.setText("20");
        }else if (m_ufa3 && f_magha) {
            m_guna.setText("16");
        }else if (m_ufa3 && f_pufa) {
            m_guna.setText("23.18");
        }else if (m_ufa3 && f_ufa1) {
            m_guna.setText("17.18");
        }else if (m_ufa3 && f_ufa3) {
            m_guna.setText("28");
        }else if (m_ufa3 && f_hasta) {
            m_guna.setText("26");
        }else if (m_ufa3 && f_chitraA2) {
            m_guna.setText("24.18");
        }else if (m_ufa3 && f_chitraB2) {
            m_guna.setText("17.18");
        }else if (m_ufa3 && f_swati) {
            m_guna.setText("25.18");
        }else if (m_ufa3 && f_vishakha3) {
            m_guna.setText("17.18");
        }else if (m_ufa3 && f_vishakha1) {
            m_guna.setText("18");
        }else if (m_ufa3 && f_anuradha) {
            m_guna.setText("26");
        }else if (m_ufa3 && f_jestha) {
            m_guna.setText("13");
        }else if (m_ufa3 && f_mula) {
            m_guna.setText("13");
        }else if (m_ufa3 && f_pusha1) {
            m_guna.setText("28.18");
        }else if (m_ufa3 && f_pusha3) {
            m_guna.setText("27");
        }else if (m_ufa3 && f_usha1) {
            m_guna.setText("29.18");
        }else if (m_ufa3 && f_usha3) {
            m_guna.setText("25.18");
        }else if (m_ufa3 && f_shravana) {
            m_guna.setText("24.09");
        }else if (m_ufa3 && f_dhanisthaA2) {
            m_guna.setText("16");
        }else if (m_ufa3 && f_dhanisthaB2) {
            m_guna.setText("17.18");
        }else if (m_ufa3 && f_shatavisha) {
            m_guna.setText("11.18");
        }else if (m_ufa3 && f_pubha3) {
            m_guna.setText("15.18");
        }else if (m_ufa3 && f_pubha1) {
            m_guna.setText("16.18");
        }else if (m_ufa3 && f_ubha) {
            m_guna.setText("27.18");
        }else if (m_ufa3 && f_revati) {
            m_guna.setText("25.18");
        }
    }
    public void mHastaToFALL(){

        if (m_hasta && f_aswini){
            m_guna.setText("9.18");
        }else if (m_hasta && f_bharani) {
            m_guna.setText("19.18");
        }else if (m_hasta && f_kritika1) {
            m_guna.setText("15");
        }else if (m_hasta && f_kritika3) {
            m_guna.setText("20.18");
        }else if (m_hasta && f_rohini) {
            m_guna.setText("25.18");
        }else if (m_hasta && f_mrigaA2) {
            m_guna.setText("25.18");
        }else if (m_hasta && f_mrigaB2) {
            m_guna.setText("34");
        }else if (m_hasta && f_aadra) {
            m_guna.setText("24.18");
        }else if (m_hasta && f_punarvasu3) {
            m_guna.setText("24.18");
        }else if (m_hasta && f_punarvasu1) {
            m_guna.setText("18");
        }else if (m_hasta && f_tisya) {
            m_guna.setText("27");
        }else if (m_hasta && f_ashlesha) {
            m_guna.setText("20");
        }else if (m_hasta && f_magha) {
            m_guna.setText("16");
        }else if (m_hasta && f_pufa) {
            m_guna.setText("22");
        }else if (m_hasta && f_ufa1) {
            m_guna.setText("16.18");
        }else if (m_hasta && f_ufa3) {
            m_guna.setText("27");
        }else if (m_hasta && f_hasta) {
            m_guna.setText("28");
        }else if (m_hasta && f_chitraA2) {
            m_guna.setText("27");
        }else if (m_hasta && f_chitraB2) {
            m_guna.setText("20");
        }else if (m_hasta && f_swati) {
            m_guna.setText("27.18");
        }else if (m_hasta && f_vishakha3) {
            m_guna.setText("18.18");
        }else if (m_hasta && f_vishakha1) {
            m_guna.setText("19");
        }else if (m_hasta && f_anuradha) {
            m_guna.setText("26");
        }else if (m_hasta && f_jestha) {
            m_guna.setText("12");
        }else if (m_hasta && f_mula) {
            m_guna.setText("13");
        }else if (m_hasta && f_pusha1) {
            m_guna.setText("27");
        }else if (m_hasta && f_pusha3) {
            m_guna.setText("25.18");
        }else if (m_hasta && f_usha1) {
            m_guna.setText("28.18");
        }else if (m_hasta && f_usha3) {
            m_guna.setText("24.18");
        }else if (m_hasta && f_shravana) {
            m_guna.setText("25.09");
        }else if (m_hasta && f_dhanisthaA2) {
            m_guna.setText("19");
        }else if (m_hasta && f_dhanisthaB2) {
            m_guna.setText("21");
        }else if (m_hasta && f_shatavisha) {
            m_guna.setText("9.18");
        }else if (m_hasta && f_pubha3) {
            m_guna.setText("17.18");
        }else if (m_hasta && f_pubha1) {
            m_guna.setText("18.18");
        }else if (m_hasta && f_ubha) {
            m_guna.setText("26.18");
        }else if (m_hasta && f_revati) {
            m_guna.setText("26.18");
        }
    }
    public void mChitraA2ToFALL(){

        if (m_chitraA2 && f_aswini){
            m_guna.setText("12.18");
        }else if (m_chitraA2 && f_bharani) {
            m_guna.setText("4.18");
        }else if (m_chitraA2 && f_kritika1) {
            m_guna.setText("17.18");
        }else if (m_chitraA2 && f_kritika3) {
            m_guna.setText("23");
        }else if (m_chitraA2 && f_rohini) {
            m_guna.setText("19.18");
        }else if (m_chitraA2 && f_mrigaA2) {
            m_guna.setText("12.18");
        }else if (m_chitraA2 && f_mrigaB2) {
            m_guna.setText("21");
        }else if (m_chitraA2 && f_aadra) {
            m_guna.setText("27");
        }else if (m_chitraA2 && f_punarvasu3) {
            m_guna.setText("26.18");
        }else if (m_chitraA2 && f_punarvasu1) {
            m_guna.setText("20");
        }else if (m_chitraA2 && f_tisya) {
            m_guna.setText("12");
        }else if (m_chitraA2 && f_ashlesha) {
            m_guna.setText("25");
        }else if (m_chitraA2 && f_magha) {
            m_guna.setText("22");
        }else if (m_chitraA2 && f_pufa) {
            m_guna.setText("8");
        }else if (m_chitraA2 && f_ufa1) {
            m_guna.setText("14");
        }else if (m_chitraA2 && f_ufa3) {
            m_guna.setText("24.18");
        }else if (m_chitraA2 && f_hasta) {
            m_guna.setText("28");
        }else if (m_chitraA2 && f_chitraA2) {
            m_guna.setText("28");
        }else if (m_chitraA2 && f_chitraB2) {
            m_guna.setText("21");
        }else if (m_chitraA2 && f_swati) {
            m_guna.setText("21");
        }else if (m_chitraA2 && f_vishakha3) {
            m_guna.setText("27.18");
        }else if (m_chitraA2 && f_vishakha1) {
            m_guna.setText("28");
        }else if (m_chitraA2 && f_anuradha) {
            m_guna.setText("12");
        }else if (m_chitraA2 && f_jestha) {
            m_guna.setText("25");
        }else if (m_chitraA2 && f_mula) {
            m_guna.setText("26");
        }else if (m_chitraA2 && f_pusha1) {
            m_guna.setText("12");
        }else if (m_chitraA2 && f_pusha3) {
            m_guna.setText("10.18");
        }else if (m_chitraA2 && f_usha1) {
            m_guna.setText("21");
        }else if (m_chitraA2 && f_usha3) {
            m_guna.setText("17");
        }else if (m_chitraA2 && f_shravana) {
            m_guna.setText("19.09");
        }else if (m_chitraA2 && f_dhanisthaA2) {
            m_guna.setText("16.18");
        }else if (m_chitraA2 && f_dhanisthaB2) {
            m_guna.setText("18");
        }else if (m_chitraA2 && f_shatavisha) {
            m_guna.setText("25");
        }else if (m_chitraA2 && f_pubha3) {
            m_guna.setText("18.18");
        }else if (m_chitraA2 && f_pubha1) {
            m_guna.setText("19.18");
        }else if (m_chitraA2 && f_ubha) {
            m_guna.setText("9.18");
        }else if (m_chitraA2 && f_revati) {
            m_guna.setText("20.18");
        }
    }
    public void mChitraB2ToFALL(){

        if (m_chitraB2 && f_aswini){
            m_guna.setText("22");
        }else if (m_chitraB2 && f_bharani) {
            m_guna.setText("14");
        }else if (m_chitraB2 && f_kritika1) {
            m_guna.setText("27");
        }else if (m_chitraB2 && f_kritika3) {
            m_guna.setText("22");
        }else if (m_chitraB2 && f_rohini) {
            m_guna.setText("18.18");
        }else if (m_chitraB2 && f_mrigaA2) {
            m_guna.setText("11.18");
        }else if (m_chitraB2 && f_mrigaB2) {
            m_guna.setText("14");
        }else if (m_chitraB2 && f_aadra) {
            m_guna.setText("20");
        }else if (m_chitraB2 && f_punarvasu3) {
            m_guna.setText("19.18");
        }else if (m_chitraB2 && f_punarvasu1) {
            m_guna.setText("19.18");
        }else if (m_chitraB2 && f_tisya) {
            m_guna.setText("11.18");
        }else if (m_chitraB2 && f_ashlesha) {
            m_guna.setText("24.18");
        }else if (m_chitraB2 && f_magha) {
            m_guna.setText("25");
        }else if (m_chitraB2 && f_pufa) {
            m_guna.setText("11");
        }else if (m_chitraB2 && f_ufa1) {
            m_guna.setText("17");
        }else if (m_chitraB2 && f_ufa3) {
            m_guna.setText("16.18");
        }else if (m_chitraB2 && f_hasta) {
            m_guna.setText("20");
        }else if (m_chitraB2 && f_chitraA2) {
            m_guna.setText("20");
        }else if (m_chitraB2 && f_chitraB2) {
            m_guna.setText("28");
        }else if (m_chitraB2 && f_swati) {
            m_guna.setText("28");
        }else if (m_chitraB2 && f_vishakha3) {
            m_guna.setText("34.18");
        }else if (m_chitraB2 && f_vishakha1) {
            m_guna.setText("23.18");
        }else if (m_chitraB2 && f_anuradha) {
            m_guna.setText("7.18");
        }else if (m_chitraB2 && f_jestha) {
            m_guna.setText("20.18");
        }else if (m_chitraB2 && f_mula) {
            m_guna.setText("26");
        }else if (m_chitraB2 && f_pusha1) {
            m_guna.setText("12");
        }else if (m_chitraB2 && f_pusha3) {
            m_guna.setText("10.18");
        }else if (m_chitraB2 && f_usha1) {
            m_guna.setText("21");
        }else if (m_chitraB2 && f_usha3) {
            m_guna.setText("24");
        }else if (m_chitraB2 && f_shravana) {
            m_guna.setText("26.09");
        }else if (m_chitraB2 && f_dhanisthaA2) {
            m_guna.setText("23.18");
        }else if (m_chitraB2 && f_dhanisthaB2) {
            m_guna.setText("19");
        }else if (m_chitraB2 && f_shatavisha) {
            m_guna.setText("26");
        }else if (m_chitraB2 && f_pubha3) {
            m_guna.setText("19.18");
        }else if (m_chitraB2 && f_pubha1) {
            m_guna.setText("12.18");
        }else if (m_chitraB2 && f_ubha) {
            m_guna.setText("2.18");
        }else if (m_chitraB2 && f_revati) {
            m_guna.setText("13.18");
        }
    }
    public void mSwatiToFALL(){

        if (m_swati && f_aswini){
            m_guna.setText("27");
        }else if (m_swati && f_bharani) {
            m_guna.setText("29");
        }else if (m_swati && f_kritika1) {
            m_guna.setText("15");
        }else if (m_swati && f_kritika3) {
            m_guna.setText("10");
        }else if (m_swati && f_rohini) {
            m_guna.setText("15");
        }else if (m_swati && f_mrigaA2) {
            m_guna.setText("24.18");
        }else if (m_swati && f_mrigaB2) {
            m_guna.setText("27");
        }else if (m_swati && f_aadra) {
            m_guna.setText("27");
        }else if (m_swati && f_punarvasu3) {
            m_guna.setText("27");
        }else if (m_swati && f_punarvasu1) {
            m_guna.setText("27");
        }else if (m_swati && f_tisya) {
            m_guna.setText("26.18");
        }else if (m_swati && f_ashlesha) {
            m_guna.setText("11.18");
        }else if (m_swati && f_magha) {
            m_guna.setText("11");
        }else if (m_swati && f_pufa) {
            m_guna.setText("25");
        }else if (m_swati && f_ufa1) {
            m_guna.setText("26");
        }else if (m_swati && f_ufa3) {
            m_guna.setText("25.18");
        }else if (m_swati && f_hasta) {
            m_guna.setText("26.18");
        }else if (m_swati && f_chitraA2) {
            m_guna.setText("19");
        }else if (m_swati && f_chitraB2) {
            m_guna.setText("27");
        }else if (m_swati && f_swati) {
            m_guna.setText("28");
        }else if (m_swati && f_vishakha3) {
            m_guna.setText("19");
        }else if (m_swati && f_vishakha1) {
            m_guna.setText("8");
        }else if (m_swati && f_anuradha) {
            m_guna.setText("21.18");
        }else if (m_swati && f_jestha) {
            m_guna.setText("15.18");
        }else if (m_swati && f_mula) {
            m_guna.setText("21");
        }else if (m_swati && f_pusha1) {
            m_guna.setText("27");
        }else if (m_swati && f_pusha3) {
            m_guna.setText("25.18");
        }else if (m_swati && f_usha1) {
            m_guna.setText("19");
        }else if (m_swati && f_usha3) {
            m_guna.setText("22");
        }else if (m_swati && f_shravana) {
            m_guna.setText("22.27");
        }else if (m_swati && f_dhanisthaA2) {
            m_guna.setText("26.18");
        }else if (m_swati && f_dhanisthaB2) {
            m_guna.setText("22");
        }else if (m_swati && f_shatavisha) {
            m_guna.setText("20");
        }else if (m_swati && f_pubha3) {
            m_guna.setText("28");
        }else if (m_swati && f_pubha1) {
            m_guna.setText("21");
        }else if (m_swati && f_ubha) {
            m_guna.setText("19.18");
        }else if (m_swati && f_revati) {
            m_guna.setText("11.18");
        }
    }
    public void mBishakha3ToFALL(){

        if (m_vishakha3 && f_aswini){
            m_guna.setText("22");
        }else if (m_vishakha3 && f_bharani) {
            m_guna.setText("22");
        }else if (m_vishakha3 && f_kritika1) {
            m_guna.setText("19");
        }else if (m_vishakha3 && f_kritika3) {
            m_guna.setText("14");
        }else if (m_vishakha3 && f_rohini) {
            m_guna.setText("9");
        }else if (m_vishakha3 && f_mrigaA2) {
            m_guna.setText("18");
        }else if (m_vishakha3 && f_mrigaB2) {
            m_guna.setText("20.18");
        }else if (m_vishakha3 && f_aadra) {
            m_guna.setText("20");
        }else if (m_vishakha3 && f_punarvasu3) {
            m_guna.setText("21");
        }else if (m_vishakha3 && f_punarvasu1) {
            m_guna.setText("21");
        }else if (m_vishakha3 && f_tisya) {
            m_guna.setText("21");
        }else if (m_vishakha3 && f_ashlesha) {
            m_guna.setText("16.18");
        }else if (m_vishakha3 && f_magha) {
            m_guna.setText("17");
        }else if (m_vishakha3 && f_pufa) {
            m_guna.setText("19");
        }else if (m_vishakha3 && f_ufa1) {
            m_guna.setText("17");
        }else if (m_vishakha3 && f_ufa3) {
            m_guna.setText("16.18");
        }else if (m_vishakha3 && f_hasta) {
            m_guna.setText("18.18");
        }else if (m_vishakha3 && f_chitraA2) {
            m_guna.setText("26.18");
        }else if (m_vishakha3 && f_chitraB2) {
            m_guna.setText("34.18");
        }else if (m_vishakha3 && f_swati) {
            m_guna.setText("20");
        }else if (m_vishakha3 && f_vishakha3) {
            m_guna.setText("28");
        }else if (m_vishakha3 && f_vishakha1) {
            m_guna.setText("17");
        }else if (m_vishakha3 && f_anuradha) {
            m_guna.setText("17");
        }else if (m_vishakha3 && f_jestha) {
            m_guna.setText("20.18");
        }else if (m_vishakha3 && f_mula) {
            m_guna.setText("26");
        }else if (m_vishakha3 && f_pusha1) {
            m_guna.setText("20");
        }else if (m_vishakha3 && f_pusha3) {
            m_guna.setText("18.18");
        }else if (m_vishakha3 && f_usha1) {
            m_guna.setText("13");
        }else if (m_vishakha3 && f_usha3) {
            m_guna.setText("16");
        }else if (m_vishakha3 && f_shravana) {
            m_guna.setText("16.27");
        }else if (m_vishakha3 && f_dhanisthaA2) {
            m_guna.setText("30");
        }else if (m_vishakha3 && f_dhanisthaB2) {
            m_guna.setText("25.18");
        }else if (m_vishakha3 && f_shatavisha) {
            m_guna.setText("26");
        }else if (m_vishakha3 && f_pubha3) {
            m_guna.setText("21");
        }else if (m_vishakha3 && f_pubha1) {
            m_guna.setText("14");
        }else if (m_vishakha3 && f_ubha) {
            m_guna.setText("12");
        }else if (m_vishakha3 && f_revati) {
            m_guna.setText("5.18");
        }
    }
    public void mBishakha1ToFALL(){

        if (m_vishakha1 && f_aswini){
            m_guna.setText("19.18");
        }else if (m_vishakha1 && f_bharani) {
            m_guna.setText("19.18");
        }else if (m_vishakha1 && f_kritika1) {
            m_guna.setText("16.18");
        }else if (m_vishakha1 && f_kritika3) {
            m_guna.setText("21.18");
        }else if (m_vishakha1 && f_rohini) {
            m_guna.setText("16.18");
        }else if (m_vishakha1 && f_mrigaA2) {
            m_guna.setText("25.18");
        }else if (m_vishakha1 && f_mrigaB2) {
            m_guna.setText("15");
        }else if (m_vishakha1 && f_aadra) {
            m_guna.setText("14.18");
        }else if (m_vishakha1 && f_punarvasu3) {
            m_guna.setText("15.18");
        }else if (m_vishakha1 && f_punarvasu1) {
            m_guna.setText("20");
        }else if (m_vishakha1 && f_tisya) {
            m_guna.setText("20");
        }else if (m_vishakha1 && f_ashlesha) {
            m_guna.setText("15.18");
        }else if (m_vishakha1 && f_magha) {
            m_guna.setText("24.18");
        }else if (m_vishakha1 && f_pufa) {
            m_guna.setText("26.18");
        }else if (m_vishakha1 && f_ufa1) {
            m_guna.setText("24.18");
        }else if (m_vishakha1 && f_ufa3) {
            m_guna.setText("19");
        }else if (m_vishakha1 && f_hasta) {
            m_guna.setText("21");
        }else if (m_vishakha1 && f_chitraA2) {
            m_guna.setText("29");
        }else if (m_vishakha1 && f_chitraB2) {
            m_guna.setText("24.18");
        }else if (m_vishakha1 && f_swati) {
            m_guna.setText("10");
        }else if (m_vishakha1 && f_vishakha3) {
            m_guna.setText("18");
        }else if (m_vishakha1 && f_vishakha1) {
            m_guna.setText("28");
        }else if (m_vishakha1 && f_anuradha) {
            m_guna.setText("28");
        }else if (m_vishakha1 && f_jestha) {
            m_guna.setText("31.18");
        }else if (m_vishakha1 && f_mula) {
            m_guna.setText("23.18");
        }else if (m_vishakha1 && f_pusha1) {
            m_guna.setText("17.18");
        }else if (m_vishakha1 && f_pusha3) {
            m_guna.setText("18.18");
        }else if (m_vishakha1 && f_usha1) {
            m_guna.setText("10.18");
        }else if (m_vishakha1 && f_usha3) {
            m_guna.setText("14");
        }else if (m_vishakha1 && f_shravana) {
            m_guna.setText("13.18");
        }else if (m_vishakha1 && f_dhanisthaA2) {
            m_guna.setText("28");
        }else if (m_vishakha1 && f_dhanisthaB2) {
            m_guna.setText("27");
        }else if (m_vishakha1 && f_shatavisha) {
            m_guna.setText("27.18");
        }else if (m_vishakha1 && f_pubha3) {
            m_guna.setText("22.18");
        }else if (m_vishakha1 && f_pubha1) {
            m_guna.setText("21");
        }else if (m_vishakha1 && f_ubha) {
            m_guna.setText("19");
        }else if (m_vishakha1 && f_revati) {
            m_guna.setText("12.18");
        }
    }
    public void mAnuradhaToFALL(){

        if (m_anuradha && f_aswini){
            m_guna.setText("26.18");
        }else if (m_anuradha && f_bharani) {
            m_guna.setText("17.18");
        }else if (m_anuradha && f_kritika1) {
            m_guna.setText("20.18");
        }else if (m_anuradha && f_kritika3) {
            m_guna.setText("25.18");
        }else if (m_anuradha && f_rohini) {
            m_guna.setText("30.18");
        }else if (m_anuradha && f_mrigaA2) {
            m_guna.setText("22.18");
        }else if (m_anuradha && f_mrigaB2) {
            m_guna.setText("12");
        }else if (m_anuradha && f_aadra) {
            m_guna.setText("18");
        }else if (m_anuradha && f_punarvasu3) {
            m_guna.setText("21.18");
        }else if (m_anuradha && f_punarvasu1) {
            m_guna.setText("26");
        }else if (m_anuradha && f_tisya) {
            m_guna.setText("19");
        }else if (m_anuradha && f_ashlesha) {
            m_guna.setText("20");
        }else if (m_anuradha && f_magha) {
            m_guna.setText("26.18");
        }else if (m_anuradha && f_pufa) {
            m_guna.setText("24.18");
        }else if (m_anuradha && f_ufa1) {
            m_guna.setText("33.18");
        }else if (m_anuradha && f_ufa3) {
            m_guna.setText("28");
        }else if (m_anuradha && f_hasta) {
            m_guna.setText("27");
        }else if (m_anuradha && f_chitraA2) {
            m_guna.setText("13");
        }else if (m_anuradha && f_chitraB2) {
            m_guna.setText("8.18");
        }else if (m_anuradha && f_swati) {
            m_guna.setText("22.18");
        }else if (m_anuradha && f_vishakha3) {
            m_guna.setText("18");
        }else if (m_anuradha && f_vishakha1) {
            m_guna.setText("28");
        }else if (m_anuradha && f_anuradha) {
            m_guna.setText("28");
        }else if (m_anuradha && f_jestha) {
            m_guna.setText("30");
        }else if (m_anuradha && f_mula) {
            m_guna.setText("16.18");
        }else if (m_anuradha && f_pusha1) {
            m_guna.setText("16.18");
        }else if (m_anuradha && f_pusha3) {
            m_guna.setText("17.18");
        }else if (m_anuradha && f_usha1) {
            m_guna.setText("24.18");
        }else if (m_anuradha && f_usha3) {
            m_guna.setText("28");
        }else if (m_anuradha && f_shravana) {
            m_guna.setText("27.18");
        }else if (m_anuradha && f_dhanisthaA2) {
            m_guna.setText("14");
        }else if (m_anuradha && f_dhanisthaB2) {
            m_guna.setText("13");
        }else if (m_anuradha && f_shatavisha) {
            m_guna.setText("22");
        }else if (m_anuradha && f_pubha3) {
            m_guna.setText("28.18");
        }else if (m_anuradha && f_pubha1) {
            m_guna.setText("27");
        }else if (m_anuradha && f_ubha) {
            m_guna.setText("20");
        }else if (m_anuradha && f_revati) {
            m_guna.setText("27");
        }
    }
    public void mJesthaToFALL(){

        if (m_jestha && f_aswini){
            m_guna.setText("15");
        }else if (m_jestha && f_bharani) {
            m_guna.setText("19.18");
        }else if (m_jestha && f_kritika1) {
            m_guna.setText("26.18");
        }else if (m_jestha && f_kritika3) {
            m_guna.setText("31.18");
        }else if (m_jestha && f_rohini) {
            m_guna.setText("24.18");
        }else if (m_jestha && f_mrigaA2) {
            m_guna.setText("25.18");
        }else if (m_jestha && f_mrigaB2) {
            m_guna.setText("15");
        }else if (m_jestha && f_aadra) {
            m_guna.setText("4");
        }else if (m_jestha && f_punarvasu3) {
            m_guna.setText("7");
        }else if (m_jestha && f_punarvasu1) {
            m_guna.setText("11.18");
        }else if (m_jestha && f_tisya) {
            m_guna.setText("22");
        }else if (m_jestha && f_ashlesha) {
            m_guna.setText("26");
        }else if (m_jestha && f_magha) {
            m_guna.setText("34");
        }else if (m_jestha && f_pufa) {
            m_guna.setText("26.18");
        }else if (m_jestha && f_ufa1) {
            m_guna.setText("19.18");
        }else if (m_jestha && f_ufa3) {
            m_guna.setText("14");
        }else if (m_jestha && f_hasta) {
            m_guna.setText("14");
        }else if (m_jestha && f_chitraA2) {
            m_guna.setText("27");
        }else if (m_jestha && f_chitraB2) {
            m_guna.setText("22.18");
        }else if (m_jestha && f_swati) {
            m_guna.setText("17.18");
        }else if (m_jestha && f_vishakha3) {
            m_guna.setText("22.18");
        }else if (m_jestha && f_vishakha1) {
            m_guna.setText("32.18");
        }else if (m_jestha && f_anuradha) {
            m_guna.setText("31");
        }else if (m_jestha && f_jestha) {
            m_guna.setText("28");
        }else if (m_jestha && f_mula) {
            m_guna.setText("16");
        }else if (m_jestha && f_pusha1) {
            m_guna.setText("18.18");
        }else if (m_jestha && f_pusha3) {
            m_guna.setText("19.18");
        }else if (m_jestha && f_usha1) {
            m_guna.setText("18.18");
        }else if (m_jestha && f_usha3) {
            m_guna.setText("22");
        }else if (m_jestha && f_shravana) {
            m_guna.setText("22.18");
        }else if (m_jestha && f_dhanisthaA2) {
            m_guna.setText("28");
        }else if (m_jestha && f_dhanisthaB2) {
            m_guna.setText("27");
        }else if (m_jestha && f_shatavisha) {
            m_guna.setText("20");
        }else if (m_jestha && f_pubha3) {
            m_guna.setText("13");
        }else if (m_jestha && f_pubha1) {
            m_guna.setText("11.18");
        }else if (m_jestha && f_ubha) {
            m_guna.setText("22");
        }else if (m_jestha && f_revati) {
            m_guna.setText("22");
        }
    }
    public void mMulaToFALL(){

        if (m_mula && f_aswini){
            m_guna.setText("12.18");
        }else if (m_mula && f_bharani) {
            m_guna.setText("19.18");
        }else if (m_mula && f_kritika1) {
            m_guna.setText("24");
        }else if (m_mula && f_kritika3) {
            m_guna.setText("19.18");
        }else if (m_mula && f_rohini) {
            m_guna.setText("13.18");
        }else if (m_mula && f_mrigaA2) {
            m_guna.setText("14.18");
        }else if (m_mula && f_mrigaB2) {
            m_guna.setText("23");
        }else if (m_mula && f_aadra) {
            m_guna.setText("16");
        }else if (m_mula && f_punarvasu3) {
            m_guna.setText("14");
        }else if (m_mula && f_punarvasu1) {
            m_guna.setText("8");
        }else if (m_mula && f_tisya) {
            m_guna.setText("17");
        }else if (m_mula && f_ashlesha) {
            m_guna.setText("22.18");
        }else if (m_mula && f_magha) {
            m_guna.setText("24.18");
        }else if (m_mula && f_pufa) {
            m_guna.setText("18.18");
        }else if (m_mula && f_ufa1) {
            m_guna.setText("10");
        }else if (m_mula && f_ufa3) {
            m_guna.setText("14");
        }else if (m_mula && f_hasta) {
            m_guna.setText("15");
        }else if (m_mula && f_chitraA2) {
            m_guna.setText("27");
        }else if (m_mula && f_chitraB2) {
            m_guna.setText("27");
        }else if (m_mula && f_swati) {
            m_guna.setText("23");
        }else if (m_mula && f_vishakha3) {
            m_guna.setText("27");
        }else if (m_mula && f_vishakha1) {
            m_guna.setText("22.18");
        }else if (m_mula && f_anuradha) {
            m_guna.setText("16.18");
        }else if (m_mula && f_jestha) {
            m_guna.setText("15");
        }else if (m_mula && f_mula) {
            m_guna.setText("28");
        }else if (m_mula && f_pusha1) {
            m_guna.setText("28");
        }else if (m_mula && f_pusha3) {
            m_guna.setText("26.18");
        }else if (m_mula && f_usha1) {
            m_guna.setText("26.18");
        }else if (m_mula && f_usha3) {
            m_guna.setText("16");
        }else if (m_mula && f_shravana) {
            m_guna.setText("17.27");
        }else if (m_mula && f_dhanisthaA2) {
            m_guna.setText("21");
        }else if (m_mula && f_dhanisthaB2) {
            m_guna.setText("29.18");
        }else if (m_mula && f_shatavisha) {
            m_guna.setText("22.18");
        }else if (m_mula && f_pubha3) {
            m_guna.setText("15.18");
        }else if (m_mula && f_pubha1) {
            m_guna.setText("15");
        }else if (m_mula && f_ubha) {
            m_guna.setText("24");
        }else if (m_mula && f_revati) {
            m_guna.setText("26");
        }
    }
    public void mPusha1ToFALL(){
        if (m_pusha1 && f_aswini){
            m_guna.setText("24.18");
        }else if (m_pusha1 && f_bharani) {
            m_guna.setText("17.18");
        }else if (m_pusha1 && f_kritika1) {
            m_guna.setText("17.18");
        }else if (m_pusha1 && f_kritika3) {
            m_guna.setText("13");
        }else if (m_pusha1 && f_rohini) {
            m_guna.setText("19.18");
        }else if (m_pusha1 && f_mrigaA2) {
            m_guna.setText("10.18");
        }else if (m_pusha1 && f_mrigaB2) {
            m_guna.setText("19.18");
        }else if (m_pusha1 && f_aadra) {
            m_guna.setText("28.18");
        }else if (m_pusha1 && f_punarvasu3) {
            m_guna.setText("27");
        }else if (m_pusha1 && f_punarvasu1) {
            m_guna.setText("21");
        }else if (m_pusha1 && f_tisya) {
            m_guna.setText("11");
        }else if (m_pusha1 && f_ashlesha) {
            m_guna.setText("16");
        }else if (m_pusha1 && f_magha) {
            m_guna.setText("19.18");
        }else if (m_pusha1 && f_pufa) {
            m_guna.setText("17.18");
        }else if (m_pusha1 && f_ufa1) {
            m_guna.setText("25.18");
        }else if (m_pusha1 && f_ufa3) {
            m_guna.setText("29.18");
        }else if (m_pusha1 && f_hasta) {
            m_guna.setText("27");
        }else if (m_pusha1 && f_chitraA2) {
            m_guna.setText("13");
        }else if (m_pusha1 && f_chitraB2) {
            m_guna.setText("13");
        }else if (m_pusha1 && f_swati) {
            m_guna.setText("27");
        }else if (m_pusha1 && f_vishakha3) {
            m_guna.setText("21");
        }else if (m_pusha1 && f_vishakha1) {
            m_guna.setText("16.18");
        }else if (m_pusha1 && f_anuradha) {
            m_guna.setText("14.18");
        }else if (m_pusha1 && f_jestha) {
            m_guna.setText("17.18");
        }else if (m_pusha1 && f_mula) {
            m_guna.setText("28");
        }else if (m_pusha1 && f_pusha1) {
            m_guna.setText("28");
        }else if (m_pusha1 && f_pusha3) {
            m_guna.setText("26.18");
        }else if (m_pusha1 && f_usha1) {
            m_guna.setText("36");
        }else if (m_pusha1 && f_usha3) {
            m_guna.setText("25.18");
        }else if (m_pusha1 && f_shravana) {
            m_guna.setText("23.27");
        }else if (m_pusha1 && f_dhanisthaA2) {
            m_guna.setText("8");
        }else if (m_pusha1 && f_dhanisthaB2) {
            m_guna.setText("16.18");
        }else if (m_pusha1 && f_shatavisha) {
            m_guna.setText("24.18");
        }else if (m_pusha1 && f_pubha3) {
            m_guna.setText("30.18");
        }else if (m_pusha1 && f_pubha1) {
            m_guna.setText("30");
        }else if (m_pusha1 && f_ubha) {
            m_guna.setText("22");
        }else if (m_pusha1 && f_revati) {
            m_guna.setText("29");
        }
    }
    public void mPusha3ToFALL(){

        if (m_pusha3 && f_aswini){
            m_guna.setText("26");
        }else if (m_pusha3 && f_bharani) {
            m_guna.setText("19");
        }else if (m_pusha3 && f_kritika1) {
            m_guna.setText("19");
        }else if (m_pusha3 && f_kritika3) {
            m_guna.setText("14.18");
        }else if (m_pusha3 && f_rohini) {
            m_guna.setText("21");
        }else if (m_pusha3 && f_mrigaA2) {
            m_guna.setText("12");
        }else if (m_pusha3 && f_mrigaB2) {
            m_guna.setText("17.18");
        }else if (m_pusha3 && f_aadra) {
            m_guna.setText("26.18");
        }else if (m_pusha3 && f_punarvasu3) {
            m_guna.setText("25.18");
        }else if (m_pusha3 && f_punarvasu1) {
            m_guna.setText("22.18");
        }else if (m_pusha3 && f_tisya) {
            m_guna.setText("12.18");
        }else if (m_pusha3 && f_ashlesha) {
            m_guna.setText("17.18");
        }else if (m_pusha3 && f_magha) {
            m_guna.setText("21");
        }else if (m_pusha3 && f_pufa) {
            m_guna.setText("19");
        }else if (m_pusha3 && f_ufa1) {
            m_guna.setText("27");
        }else if (m_pusha3 && f_ufa3) {
            m_guna.setText("28");
        }else if (m_pusha3 && f_hasta) {
            m_guna.setText("25.18");
        }else if (m_pusha3 && f_chitraA2) {
            m_guna.setText("11.18");
        }else if (m_pusha3 && f_chitraB2) {
            m_guna.setText("11.18");
        }else if (m_pusha3 && f_swati) {
            m_guna.setText("25.18");
        }else if (m_pusha3 && f_vishakha3) {
            m_guna.setText("19.18");
        }else if (m_pusha3 && f_vishakha1) {
            m_guna.setText("17.18");
        }else if (m_pusha3 && f_anuradha) {
            m_guna.setText("15.18");
        }else if (m_pusha3 && f_jestha) {
            m_guna.setText("18.18");
        }else if (m_pusha3 && f_mula) {
            m_guna.setText("26.18");
        }else if (m_pusha3 && f_pusha1) {
            m_guna.setText("26.18");
        }else if (m_pusha3 && f_pusha3) {
            m_guna.setText("28");
        }else if (m_pusha3 && f_usha1) {
            m_guna.setText("34.18");
        }else if (m_pusha3 && f_usha3) {
            m_guna.setText("27");
        }else if (m_pusha3 && f_shravana) {
            m_guna.setText("23.27");
        }else if (m_pusha3 && f_dhanisthaA2) {
            m_guna.setText("9.18");
        }else if (m_pusha3 && f_dhanisthaB2) {
            m_guna.setText("15");
        }else if (m_pusha3 && f_shatavisha) {
            m_guna.setText("23");
        }else if (m_pusha3 && f_pubha3) {
            m_guna.setText("29");
        }else if (m_pusha3 && f_pubha1) {
            m_guna.setText("31.18");
        }else if (m_pusha3 && f_ubha) {
            m_guna.setText("23.18");
        }else if (m_pusha3 && f_revati) {
            m_guna.setText("30.18");
        }
    }
    public void mUsha1ToFALL(){

        if (m_usha1 && f_aswini){
            m_guna.setText("23");
        }else if (m_usha1 && f_bharani) {
            m_guna.setText("25.18");
        }else if (m_usha1 && f_kritika1) {
            m_guna.setText("12.18");
        }else if (m_usha1 && f_kritika3) {
            m_guna.setText("8");
        }else if (m_usha1 && f_rohini) {
            m_guna.setText("11");
        }else if (m_usha1 && f_mrigaA2) {
            m_guna.setText("16.18");
        }else if (m_usha1 && f_mrigaB2) {
            m_guna.setText("25");
        }else if (m_usha1 && f_aadra) {
            m_guna.setText("28");
        }else if (m_usha1 && f_punarvasu3) {
            m_guna.setText("27");
        }else if (m_usha1 && f_punarvasu1) {
            m_guna.setText("21");
        }else if (m_usha1 && f_tisya) {
            m_guna.setText("22");
        }else if (m_usha1 && f_ashlesha) {
            m_guna.setText("8");
        }else if (m_usha1 && f_magha) {
            m_guna.setText("10");
        }else if (m_usha1 && f_pufa) {
            m_guna.setText("25.18");
        }else if (m_usha1 && f_ufa1) {
            m_guna.setText("26.18");
        }else if (m_usha1 && f_ufa3) {
            m_guna.setText("30.18");
        }else if (m_usha1 && f_hasta) {
            m_guna.setText("28.18");
        }else if (m_usha1 && f_chitraA2) {
            m_guna.setText("22");
        }else if (m_usha1 && f_chitraB2) {
            m_guna.setText("22");
        }else if (m_usha1 && f_swati) {
            m_guna.setText("19");
        }else if (m_usha1 && f_vishakha3) {
            m_guna.setText("14");
        }else if (m_usha1 && f_vishakha1) {
            m_guna.setText("9.18");
        }else if (m_usha1 && f_anuradha) {
            m_guna.setText("22.18");
        }else if (m_usha1 && f_jestha) {
            m_guna.setText("17.18");
        }else if (m_usha1 && f_mula) {
            m_guna.setText("26.18");
        }else if (m_usha1 && f_pusha1) {
            m_guna.setText("34");
        }else if (m_usha1 && f_pusha3) {
            m_guna.setText("32.18");
        }else if (m_usha1 && f_usha1) {
            m_guna.setText("28");
        }else if (m_usha1 && f_usha3) {
            m_guna.setText("17.18");
        }else if (m_usha1 && f_shravana) {
            m_guna.setText("15.09");
        }else if (m_usha1 && f_dhanisthaA2) {
            m_guna.setText("16");
        }else if (m_usha1 && f_dhanisthaB2) {
            m_guna.setText("24.18");
        }else if (m_usha1 && f_shatavisha) {
            m_guna.setText("24.18");
        }else if (m_usha1 && f_pubha3) {
            m_guna.setText("30.18");
        }else if (m_usha1 && f_pubha1) {
            m_guna.setText("30");
        }else if (m_usha1 && f_ubha) {
            m_guna.setText("31");
        }else if (m_usha1 && f_revati) {
            m_guna.setText("21");
        }
    }
    public void mUsha3ToFALL(){

        if (m_usha3 && f_aswini){
            m_guna.setText("26");
        }else if (m_usha3 && f_bharani) {
            m_guna.setText("28.18");
        }else if (m_usha3 && f_kritika1) {
            m_guna.setText("15.18");
        }else if (m_usha3 && f_kritika3) {
            m_guna.setText("14");
        }else if (m_usha3 && f_rohini) {
            m_guna.setText("17");
        }else if (m_usha3 && f_mrigaA2) {
            m_guna.setText("22.18");
        }else if (m_usha3 && f_mrigaB2) {
            m_guna.setText("20");
        }else if (m_usha3 && f_aadra) {
            m_guna.setText("23");
        }else if (m_usha3 && f_punarvasu3) {
            m_guna.setText("22");
        }else if (m_usha3 && f_punarvasu1) {
            m_guna.setText("26");
        }else if (m_usha3 && f_tisya) {
            m_guna.setText("27");
        }else if (m_usha3 && f_ashlesha) {
            m_guna.setText("13");
        }else if (m_usha3 && f_magha) {
            m_guna.setText("5.18");
        }else if (m_usha3 && f_pufa) {
            m_guna.setText("21");
        }else if (m_usha3 && f_ufa1) {
            m_guna.setText("22");
        }else if (m_usha3 && f_ufa3) {
            m_guna.setText("25.18");
        }else if (m_usha3 && f_hasta) {
            m_guna.setText("23.18");
        }else if (m_usha3 && f_chitraA2) {
            m_guna.setText("17");
        }else if (m_usha3 && f_chitraB2) {
            m_guna.setText("25");
        }else if (m_usha3 && f_swati) {
            m_guna.setText("22");
        }else if (m_usha3 && f_vishakha3) {
            m_guna.setText("17");
        }else if (m_usha3 && f_vishakha1) {
            m_guna.setText("13");
        }else if (m_usha3 && f_anuradha) {
            m_guna.setText("26");
        }else if (m_usha3 && f_jestha) {
            m_guna.setText("21");
        }else if (m_usha3 && f_mula) {
            m_guna.setText("15");
        }else if (m_usha3 && f_pusha1) {
            m_guna.setText("22.18");
        }else if (m_usha3 && f_pusha3) {
            m_guna.setText("24");
        }else if (m_usha3 && f_usha1) {
            m_guna.setText("16.18");
        }else if (m_usha3 && f_usha3) {
            m_guna.setText("28");
        }else if (m_usha3 && f_shravana) {
            m_guna.setText("24.09");
        }else if (m_usha3 && f_dhanisthaA2) {
            m_guna.setText("26.18");
        }else if (m_usha3 && f_dhanisthaB2) {
            m_guna.setText("18");
        }else if (m_usha3 && f_shatavisha) {
            m_guna.setText("18");
        }else if (m_usha3 && f_pubha3) {
            m_guna.setText("24");
        }else if (m_usha3 && f_pubha1) {
            m_guna.setText("29.18");
        }else if (m_usha3 && f_ubha) {
            m_guna.setText("30.18");
        }else if (m_usha3 && f_revati) {
            m_guna.setText("20.18");
        }
    }
    public void mShravanaToFALL(){

        if (m_shravana && f_aswini){
            m_guna.setText("26.09");
        }else if (m_shravana && f_bharani) {
            m_guna.setText("26.09");
        }else if (m_shravana && f_kritika1) {
            m_guna.setText("11.27");
        }else if (m_shravana && f_kritika3) {
            m_guna.setText("10.09");
        }else if (m_shravana && f_rohini) {
            m_guna.setText("18.09");
        }else if (m_shravana && f_mrigaA2) {
            m_guna.setText("26.09");
        }else if (m_shravana && f_mrigaB2) {
            m_guna.setText("25.09");
        }else if (m_shravana && f_aadra) {
            m_guna.setText("23.27");
        }else if (m_shravana && f_punarvasu3) {
            m_guna.setText("23.27");
        }else if (m_shravana && f_punarvasu1) {
            m_guna.setText("26.09");
        }else if (m_shravana && f_tisya) {
            m_guna.setText("24.09");
        }else if (m_shravana && f_ashlesha) {
            m_guna.setText("12.09");
        }else if (m_shravana && f_magha) {
            m_guna.setText("4.27");
        }else if (m_shravana && f_pufa) {
            m_guna.setText("18.27");
        }else if (m_shravana && f_ufa1) {
            m_guna.setText("20.09");
        }else if (m_shravana && f_ufa3) {
            m_guna.setText("25.09");
        }else if (m_shravana && f_hasta) {
            m_guna.setText("25.09");
        }else if (m_shravana && f_chitraA2) {
            m_guna.setText("18.09");
        }else if (m_shravana && f_chitraB2) {
            m_guna.setText("26.09");
        }else if (m_shravana && f_swati) {
            m_guna.setText("23.27");
        }else if (m_shravana && f_vishakha3) {
            m_guna.setText("16.27");
        }else if (m_shravana && f_vishakha1) {
            m_guna.setText("11.18");
        }else if (m_shravana && f_anuradha) {
            m_guna.setText("26.18");
        }else if (m_shravana && f_jestha) {
            m_guna.setText("20.18");
        }else if (m_shravana && f_mula) {
            m_guna.setText("15.18");
        }else if (m_shravana && f_pusha1) {
            m_guna.setText("23.27");
        }else if (m_shravana && f_pusha3) {
            m_guna.setText("23.27");
        }else if (m_shravana && f_usha1) {
            m_guna.setText("17.09");
        }else if (m_shravana && f_usha3) {
            m_guna.setText("27.09");
        }else if (m_shravana && f_shravana) {
            m_guna.setText("27.09");
        }else if (m_shravana && f_dhanisthaA2) {
            m_guna.setText("27.09");
        }else if (m_shravana && f_dhanisthaB2) {
            m_guna.setText("20.09");
        }else if (m_shravana && f_shatavisha) {
            m_guna.setText("18.27");
        }else if (m_shravana && f_pubha3) {
            m_guna.setText("24.27");
        }else if (m_shravana && f_pubha1) {
            m_guna.setText("28.27");
        }else if (m_shravana && f_ubha) {
            m_guna.setText("28.27");
        }else if (m_shravana && f_revati) {
            m_guna.setText("20.27");
        }
    }
    public void mDhanistaA2ToFALL(){

        if (m_dhanisthaA2 && f_aswini){
            m_guna.setText("21");
        }else if (m_dhanisthaA2 && f_bharani) {
            m_guna.setText("11");
        }else if (m_dhanisthaA2 && f_kritika1) {
            m_guna.setText("26");
        }else if (m_dhanisthaA2 && f_kritika3) {
            m_guna.setText("24.18");
        }else if (m_dhanisthaA2 && f_rohini) {
            m_guna.setText("21");
        }else if (m_dhanisthaA2 && f_mrigaA2) {
            m_guna.setText("14");
        }else if (m_dhanisthaA2 && f_mrigaB2) {
            m_guna.setText("11.18");
        }else if (m_dhanisthaA2 && f_aadra) {
            m_guna.setText("17.18");
        }else if (m_dhanisthaA2 && f_punarvasu3) {
            m_guna.setText("18");
        }else if (m_dhanisthaA2 && f_punarvasu1) {
            m_guna.setText("22");
        }else if (m_dhanisthaA2 && f_tisya) {
            m_guna.setText("13");
        }else if (m_dhanisthaA2 && f_ashlesha) {
            m_guna.setText("27");
        }else if (m_dhanisthaA2 && f_magha) {
            m_guna.setText("17.18");
        }else if (m_dhanisthaA2 && f_pufa) {
            m_guna.setText("4.18");
        }else if (m_dhanisthaA2 && f_ufa1) {
            m_guna.setText("12.18");
        }else if (m_dhanisthaA2 && f_ufa3) {
            m_guna.setText("16");
        }else if (m_dhanisthaA2 && f_hasta) {
            m_guna.setText("20.18");
        }else if (m_dhanisthaA2 && f_chitraA2) {
            m_guna.setText("16.18");
        }else if (m_dhanisthaA2 && f_chitraB2) {
            m_guna.setText("24.18");
        }else if (m_dhanisthaA2 && f_swati) {
            m_guna.setText("28.18");
        }else if (m_dhanisthaA2 && f_vishakha3) {
            m_guna.setText("31");
        }else if (m_dhanisthaA2 && f_vishakha1) {
            m_guna.setText("27");
        }else if (m_dhanisthaA2 && f_anuradha) {
            m_guna.setText("14");
        }else if (m_dhanisthaA2 && f_jestha) {
            m_guna.setText("27");
        }else if (m_dhanisthaA2 && f_mula) {
            m_guna.setText("20");
        }else if (m_dhanisthaA2 && f_pusha1) {
            m_guna.setText("8");
        }else if (m_dhanisthaA2 && f_pusha3) {
            m_guna.setText("9.18");
        }else if (m_dhanisthaA2 && f_usha1) {
            m_guna.setText("15");
        }else if (m_dhanisthaA2 && f_usha3) {
            m_guna.setText("26.18");
        }else if (m_dhanisthaA2 && f_shravana) {
            m_guna.setText("27.09");
        }else if (m_dhanisthaA2 && f_dhanisthaA2) {
            m_guna.setText("28");
        }else if (m_dhanisthaA2 && f_dhanisthaB2) {
            m_guna.setText("19.18");
        }else if (m_dhanisthaA2 && f_shatavisha) {
            m_guna.setText("24.18");
        }else if (m_dhanisthaA2 && f_pubha3) {
            m_guna.setText("20");
        }else if (m_dhanisthaA2 && f_pubha1) {
            m_guna.setText("25.18");
        }else if (m_dhanisthaA2 && f_ubha) {
            m_guna.setText("14.18");
        }else if (m_dhanisthaA2 && f_revati) {
            m_guna.setText("22.18");
        }
    }
    public void mDhanistaB2ToFALL(){

        if (m_dhanisthaB2 && f_aswini){
            m_guna.setText("19.18");
        }else if (m_dhanisthaB2 && f_bharani) {
            m_guna.setText("9.18");
        }else if (m_dhanisthaB2 && f_kritika1) {
            m_guna.setText("24.18");
        }else if (m_dhanisthaB2 && f_kritika3) {
            m_guna.setText("29");
        }else if (m_dhanisthaB2 && f_rohini) {
            m_guna.setText("25.18");
        }else if (m_dhanisthaB2 && f_mrigaA2) {
            m_guna.setText("18.18");
        }else if (m_dhanisthaB2 && f_mrigaB2) {
            m_guna.setText("13");
        }else if (m_dhanisthaB2 && f_aadra) {
            m_guna.setText("19");
        }else if (m_dhanisthaB2 && f_punarvasu3) {
            m_guna.setText("19.18");
        }else if (m_dhanisthaB2 && f_punarvasu1) {
            m_guna.setText("13.18");
        }else if (m_dhanisthaB2 && f_tisya) {
            m_guna.setText("4.18");
        }else if (m_dhanisthaB2 && f_ashlesha) {
            m_guna.setText("18.18");
        }else if (m_dhanisthaB2 && f_magha) {
            m_guna.setText("24");
        }else if (m_dhanisthaB2 && f_pufa) {
            m_guna.setText("10");
        }else if (m_dhanisthaB2 && f_ufa1) {
            m_guna.setText("18");
        }else if (m_dhanisthaB2 && f_ufa3) {
            m_guna.setText("16.18");
        }else if (m_dhanisthaB2 && f_hasta) {
            m_guna.setText("21");
        }else if (m_dhanisthaB2 && f_chitraA2) {
            m_guna.setText("17");
        }else if (m_dhanisthaB2 && f_chitraB2) {
            m_guna.setText("19");
        }else if (m_dhanisthaB2 && f_swati) {
            m_guna.setText("23");
        }else if (m_dhanisthaB2 && f_vishakha3) {
            m_guna.setText("25.18");
        }else if (m_dhanisthaB2 && f_vishakha1) {
            m_guna.setText("26");
        }else if (m_dhanisthaB2 && f_anuradha) {
            m_guna.setText("13");
        }else if (m_dhanisthaB2 && f_jestha) {
            m_guna.setText("26");
        }else if (m_dhanisthaB2 && f_mula) {
            m_guna.setText("28.18");
        }else if (m_dhanisthaB2 && f_pusha1) {
            m_guna.setText("16.18");
        }else if (m_dhanisthaB2 && f_pusha3) {
            m_guna.setText("15");
        }else if (m_dhanisthaB2 && f_usha1) {
            m_guna.setText("23.18");
        }else if (m_dhanisthaB2 && f_usha3) {
            m_guna.setText("17");
        }else if (m_dhanisthaB2 && f_shravana) {
            m_guna.setText("21.09");
        }else if (m_dhanisthaB2 && f_dhanisthaA2) {
            m_guna.setText("18.18");
        }else if (m_dhanisthaB2 && f_dhanisthaB2) {
            m_guna.setText("28");
        }else if (m_dhanisthaB2 && f_shatavisha) {
            m_guna.setText("33");
        }else if (m_dhanisthaB2 && f_pubha3) {
            m_guna.setText("28.18");
        }else if (m_dhanisthaB2 && f_pubha1) {
            m_guna.setText("17");
        }else if (m_dhanisthaB2 && f_ubha) {
            m_guna.setText("6");
        }else if (m_dhanisthaB2 && f_revati) {
            m_guna.setText("14");
        }
    }
    public void mShatavishaToFALL(){

        if (m_shatavisha && f_aswini){
            m_guna.setText("14.18");
        }else if (m_shatavisha && f_bharani) {
            m_guna.setText("19.18");
        }else if (m_shatavisha && f_kritika1) {
            m_guna.setText("26.18");
        }else if (m_shatavisha && f_kritika3) {
            m_guna.setText("31");
        }else if (m_shatavisha && f_rohini) {
            m_guna.setText("24");
        }else if (m_shatavisha && f_mrigaA2) {
            m_guna.setText("26.18");
        }else if (m_shatavisha && f_mrigaB2) {
            m_guna.setText("21");
        }else if (m_shatavisha && f_aadra) {
            m_guna.setText("12");
        }else if (m_shatavisha && f_punarvasu3) {
            m_guna.setText("13");
        }else if (m_shatavisha && f_punarvasu1) {
            m_guna.setText("7");
        }else if (m_shatavisha && f_tisya) {
            m_guna.setText("14.18");
        }else if (m_shatavisha && f_ashlesha) {
            m_guna.setText("18.18");
        }else if (m_shatavisha && f_magha) {
            m_guna.setText("25");
        }else if (m_shatavisha && f_pufa) {
            m_guna.setText("19");
        }else if (m_shatavisha && f_ufa1) {
            m_guna.setText("12");
        }else if (m_shatavisha && f_ufa3) {
            m_guna.setText("10.18");
        }else if (m_shatavisha && f_hasta) {
            m_guna.setText("9.18");
        }else if (m_shatavisha && f_chitraA2) {
            m_guna.setText("24");
        }else if (m_shatavisha && f_chitraB2) {
            m_guna.setText("26");
        }else if (m_shatavisha && f_swati) {
            m_guna.setText("21");
        }else if (m_shatavisha && f_vishakha3) {
            m_guna.setText("26");
        }else if (m_shatavisha && f_vishakha1) {
            m_guna.setText("26.18");
        }else if (m_shatavisha && f_anuradha) {
            m_guna.setText("22");
        }else if (m_shatavisha && f_jestha) {
            m_guna.setText("19");
        }else if (m_shatavisha && f_mula) {
            m_guna.setText("21.18");
        }else if (m_shatavisha && f_pusha1) {
            m_guna.setText("23.18");
        }else if (m_shatavisha && f_pusha3) {
            m_guna.setText("22");
        }else if (m_shatavisha && f_usha1) {
            m_guna.setText("23.18");
        }else if (m_shatavisha && f_usha3) {
            m_guna.setText("17");
        }else if (m_shatavisha && f_shravana) {
            m_guna.setText("18.27");
        }else if (m_shatavisha && f_dhanisthaA2) {
            m_guna.setText("23.18");
        }else if (m_shatavisha && f_dhanisthaB2) {
            m_guna.setText("33");
        }else if (m_shatavisha && f_shatavisha) {
            m_guna.setText("28");
        }else if (m_shatavisha && f_pubha3) {
            m_guna.setText("19");
        }else if (m_shatavisha && f_pubha1) {
            m_guna.setText("7.18");
        }else if (m_shatavisha && f_ubha) {
            m_guna.setText("16");
        }else if (m_shatavisha && f_revati) {
            m_guna.setText("16");
        }
    }
    public void mPubha3ToFALL(){

        if (m_pubha3 && f_aswini){
            m_guna.setText("15.18");
        }else if (m_pubha3 && f_bharani) {
            m_guna.setText("23.18");
        }else if (m_pubha3 && f_kritika1) {
            m_guna.setText("18.18");
        }else if (m_pubha3 && f_kritika3) {
            m_guna.setText("23");
        }else if (m_pubha3 && f_rohini) {
            m_guna.setText("30");
        }else if (m_pubha3 && f_mrigaA2) {
            m_guna.setText("29");
        }else if (m_pubha3 && f_mrigaB2) {
            m_guna.setText("23.18");
        }else if (m_pubha3 && f_aadra) {
            m_guna.setText("17");
        }else if (m_pubha3 && f_punarvasu3) {
            m_guna.setText("17");
        }else if (m_pubha3 && f_punarvasu1) {
            m_guna.setText("11");
        }else if (m_pubha3 && f_tisya) {
            m_guna.setText("18");
        }else if (m_pubha3 && f_ashlesha) {
            m_guna.setText("12.18");
        }else if (m_pubha3 && f_magha) {
            m_guna.setText("18");
        }else if (m_pubha3 && f_pufa) {
            m_guna.setText("24");
        }else if (m_pubha3 && f_ufa1) {
            m_guna.setText("16");
        }else if (m_pubha3 && f_ufa3) {
            m_guna.setText("14.18");
        }else if (m_pubha3 && f_hasta) {
            m_guna.setText("15.18");
        }else if (m_pubha3 && f_chitraA2) {
            m_guna.setText("17.18");
        }else if (m_pubha3 && f_chitraB2) {
            m_guna.setText("19.18");
        }else if (m_pubha3 && f_swati) {
            m_guna.setText("27");
        }else if (m_pubha3 && f_vishakha3) {
            m_guna.setText("21");
        }else if (m_pubha3 && f_vishakha1) {
            m_guna.setText("21.18");
        }else if (m_pubha3 && f_anuradha) {
            m_guna.setText("26.18");
        }else if (m_pubha3 && f_jestha) {
            m_guna.setText("12");
        }else if (m_pubha3 && f_mula) {
            m_guna.setText("14.18");
        }else if (m_pubha3 && f_pusha1) {
            m_guna.setText("30.18");
        }else if (m_pubha3 && f_pusha3) {
            m_guna.setText("29");
        }else if (m_pubha3 && f_usha1) {
            m_guna.setText("29.18");
        }else if (m_pubha3 && f_usha3) {
            m_guna.setText("23");
        }else if (m_pubha3 && f_shravana) {
            m_guna.setText("23.27");
        }else if (m_pubha3 && f_dhanisthaA2) {
            m_guna.setText("19");
        }else if (m_pubha3 && f_dhanisthaB2) {
            m_guna.setText("28.18");
        }else if (m_pubha3 && f_shatavisha) {
            m_guna.setText("19");
        }else if (m_pubha3 && f_pubha3) {
            m_guna.setText("28");
        }else if (m_pubha3 && f_pubha1) {
            m_guna.setText("16.18");
        }else if (m_pubha3 && f_ubha) {
            m_guna.setText("21.18");
        }else if (m_pubha3 && f_revati) {
            m_guna.setText("18");
        }
    }
    public void mPubha1ToFALL(){

        if (m_pubha1 && f_aswini){
            m_guna.setText("15.18");
        }else if (m_pubha1 && f_bharani) {
            m_guna.setText("23.18");
        }else if (m_pubha1 && f_kritika1) {
            m_guna.setText("18.18");
        }else if (m_pubha1 && f_kritika3) {
            m_guna.setText("21");
        }else if (m_pubha1 && f_rohini) {
            m_guna.setText("28");
        }else if (m_pubha1 && f_mrigaA2) {
            m_guna.setText("27");
        }else if (m_pubha1 && f_mrigaB2) {
            m_guna.setText("25.18");
        }else if (m_pubha1 && f_aadra) {
            m_guna.setText("19");
        }else if (m_pubha1 && f_punarvasu3) {
            m_guna.setText("19");
        }else if (m_pubha1 && f_punarvasu1) {
            m_guna.setText("17");
        }else if (m_pubha1 && f_tisya) {
            m_guna.setText("24");
        }else if (m_pubha1 && f_ashlesha) {
            m_guna.setText("18.18");
        }else if (m_pubha1 && f_magha) {
            m_guna.setText("18.18");
        }else if (m_pubha1 && f_pufa) {
            m_guna.setText("24.18");
        }else if (m_pubha1 && f_ufa1) {
            m_guna.setText("16.18");
        }else if (m_pubha1 && f_ufa3) {
            m_guna.setText("17.18");
        }else if (m_pubha1 && f_hasta) {
            m_guna.setText("18.18");
        }else if (m_pubha1 && f_chitraA2) {
            m_guna.setText("20.18");
        }else if (m_pubha1 && f_chitraB2) {
            m_guna.setText("13.18");
        }else if (m_pubha1 && f_swati) {
            m_guna.setText("21");
        }else if (m_pubha1 && f_vishakha3) {
            m_guna.setText("15");
        }else if (m_pubha1 && f_vishakha1) {
            m_guna.setText("21");
        }else if (m_pubha1 && f_anuradha) {
            m_guna.setText("26");
        }else if (m_pubha1 && f_jestha) {
            m_guna.setText("11.18");
        }else if (m_pubha1 && f_mula) {
            m_guna.setText("16");
        }else if (m_pubha1 && f_pusha1) {
            m_guna.setText("32");
        }else if (m_pubha1 && f_pusha3) {
            m_guna.setText("33.18");
        }else if (m_pubha1 && f_usha1) {
            m_guna.setText("31");
        }else if (m_pubha1 && f_usha3) {
            m_guna.setText("30.18");
        }else if (m_pubha1 && f_shravana) {
            m_guna.setText("29.27");
        }else if (m_pubha1 && f_dhanisthaA2) {
            m_guna.setText("26.18");
        }else if (m_pubha1 && f_dhanisthaB2) {
            m_guna.setText("18");
        }else if (m_pubha1 && f_shatavisha) {
            m_guna.setText("8.18");
        }else if (m_pubha1 && f_pubha3) {
            m_guna.setText("17.18");
        }else if (m_pubha1 && f_pubha1) {
            m_guna.setText("28");
        }else if (m_pubha1 && f_ubha) {
            m_guna.setText("33");
        }else if (m_pubha1 && f_revati) {
            m_guna.setText("29.18");
        }
    }
    public void mUbhaToFALL(){

        if (m_ubha && f_aswini){
            m_guna.setText("25.18");
        }else if (m_ubha && f_bharani) {
            m_guna.setText("18.18");
        }else if (m_ubha && f_kritika1) {
            m_guna.setText("20.18");
        }else if (m_ubha && f_kritika3) {
            m_guna.setText("23");
        }else if (m_ubha && f_rohini) {
            m_guna.setText("27");
        }else if (m_ubha && f_mrigaA2) {
            m_guna.setText("18");
        }else if (m_ubha && f_mrigaB2) {
            m_guna.setText("16.18");
        }else if (m_ubha && f_aadra) {
            m_guna.setText("26.18");
        }else if (m_ubha && f_punarvasu3) {
            m_guna.setText("27");
        }else if (m_ubha && f_punarvasu1) {
            m_guna.setText("25");
        }else if (m_ubha && f_tisya) {
            m_guna.setText("18");
        }else if (m_ubha && f_ashlesha) {
            m_guna.setText("20");
        }else if (m_ubha && f_magha) {
            m_guna.setText("19.18");
        }else if (m_ubha && f_pufa) {
            m_guna.setText("17.18");
        }else if (m_ubha && f_ufa1) {
            m_guna.setText("27.18");
        }else if (m_ubha && f_ufa3) {
            m_guna.setText("28.18");
        }else if (m_ubha && f_hasta) {
            m_guna.setText("26.18");
        }else if (m_ubha && f_chitraA2) {
            m_guna.setText("10.18");
        }else if (m_ubha && f_chitraB2) {
            m_guna.setText("3.18");
        }else if (m_ubha && f_swati) {
            m_guna.setText("19.18");
        }else if (m_ubha && f_vishakha3) {
            m_guna.setText("13");
        }else if (m_ubha && f_vishakha1) {
            m_guna.setText("19");
        }else if (m_ubha && f_anuradha) {
            m_guna.setText("19");
        }else if (m_ubha && f_jestha) {
            m_guna.setText("22");
        }else if (m_ubha && f_mula) {
            m_guna.setText("25");
        }else if (m_ubha && f_pusha1) {
            m_guna.setText("23");
        }else if (m_ubha && f_pusha3) {
            m_guna.setText("24.18");
        }else if (m_ubha && f_usha1) {
            m_guna.setText("32");
        }else if (m_ubha && f_usha3) {
            m_guna.setText("31.18");
        }else if (m_ubha && f_shravana) {
            m_guna.setText("28.09");
        }else if (m_ubha && f_dhanisthaA2) {
            m_guna.setText("15.18");
        }else if (m_ubha && f_dhanisthaB2) {
            m_guna.setText("7");
        }else if (m_ubha && f_shatavisha) {
            m_guna.setText("17");
        }else if (m_ubha && f_pubha3) {
            m_guna.setText("22.18");
        }else if (m_ubha && f_pubha1) {
            m_guna.setText("33");
        }else if (m_ubha && f_ubha) {
            m_guna.setText("28");
        }else if (m_ubha && f_revati) {
            m_guna.setText("34");
        }
    }
    public void mRewatiToFALL(){

        if (m_revati && f_aswini){
            m_guna.setText("27");
        }else if (m_revati && f_bharani) {
            m_guna.setText("27.18");
        }else if (m_revati && f_kritika1) {
            m_guna.setText("12.18");
        }else if (m_revati && f_kritika3) {
            m_guna.setText("15");
        }else if (m_revati && f_rohini) {
            m_guna.setText("20");
        }else if (m_revati && f_mrigaA2) {
            m_guna.setText("28");
        }else if (m_revati && f_mrigaB2) {
            m_guna.setText("26.18");
        }else if (m_revati && f_aadra) {
            m_guna.setText("26.18");
        }else if (m_revati && f_punarvasu3) {
            m_guna.setText("26.18");
        }else if (m_revati && f_punarvasu1) {
            m_guna.setText("24.18");
        }else if (m_revati && f_tisya) {
            m_guna.setText("27");
        }else if (m_revati && f_ashlesha) {
            m_guna.setText("12");
        }else if (m_revati && f_magha) {
            m_guna.setText("13");
        }else if (m_revati && f_pufa) {
            m_guna.setText("25.18");
        }else if (m_revati && f_ufa1) {
            m_guna.setText("25.18");
        }else if (m_revati && f_ufa3) {
            m_guna.setText("26.18");
        }else if (m_revati && f_hasta) {
            m_guna.setText("27.18");
        }else if (m_revati && f_chitraA2) {
            m_guna.setText("20.18");
        }else if (m_revati && f_chitraB2) {
            m_guna.setText("13.18");
        }else if (m_revati && f_swati) {
            m_guna.setText("12.18");
        }else if (m_revati && f_vishakha3) {
            m_guna.setText("5.18");
        }else if (m_revati && f_vishakha1) {
            m_guna.setText("11.18");
        }else if (m_revati && f_anuradha) {
            m_guna.setText("27");
        }else if (m_revati && f_jestha) {
            m_guna.setText("21");
        }else if (m_revati && f_mula) {
            m_guna.setText("26.18");
        }else if (m_revati && f_pusha1) {
            m_guna.setText("32");
        }else if (m_revati && f_pusha3) {
            m_guna.setText("33.18");
        }else if (m_revati && f_usha1) {
            m_guna.setText("23.18");
        }else if (m_revati && f_usha3) {
            m_guna.setText("22.18");
        }else if (m_revati && f_shravana) {
            m_guna.setText("22.27");
        }else if (m_revati && f_dhanisthaA2) {
            m_guna.setText("22.18");
        }else if (m_revati && f_dhanisthaB2) {
            m_guna.setText("14");
        }else if (m_revati && f_shatavisha) {
            m_guna.setText("16");
        }else if (m_revati && f_pubha3) {
            m_guna.setText("20");
        }else if (m_revati && f_pubha1) {
            m_guna.setText("30.18");
        }else if (m_revati && f_ubha) {
            m_guna.setText("34");
        }else if (m_revati && f_revati) {
            m_guna.setText("28");
        }
    }




    public void fAshwiniToFALL(){

        if (f_aswini && m_aswini){
            m_guna.setText("28");
        }else if (f_aswini && m_bharani) {
            m_guna.setText("33");
        }else if (f_aswini && m_kritika1) {
            m_guna.setText("28.18");
        }else if (f_aswini && m_kritika3) {
            m_guna.setText("18.18");
        }else if (f_aswini && m_rohini) {
            m_guna.setText("21.18");
        }else if (f_aswini && m_mrigaA2) {
            m_guna.setText("22.18");
        }else if (f_aswini && m_mrigaB2) {
            m_guna.setText("25.18");
        }else if (f_aswini && m_aadra) {
            m_guna.setText("16.18");
        }else if (f_aswini && m_punarvasu3) {
            m_guna.setText("18.18");
        }else if (f_aswini && m_punarvasu1) {
            m_guna.setText("24.18");
        }else if (f_aswini && m_tisya) {
            m_guna.setText("32.18");
        }else if (f_aswini && m_ashlesha) {
            m_guna.setText("29");
        }else if (f_aswini && m_magha) {
            m_guna.setText("23");
        }else if (f_aswini && m_pufa) {
            m_guna.setText("27");
        }else if (f_aswini && m_ufa1) {
            m_guna.setText("1.18");
        }else if (f_aswini && m_ufa3) {
            m_guna.setText("10.18");
        }else if (f_aswini && m_hasta) {
            m_guna.setText("9.18");
        }else if (f_aswini && m_chitraA2) {
            m_guna.setText("12.18");
        }else if (f_aswini && m_chitraB2) {
            m_guna.setText("22");
        }else if (f_aswini && m_swati) {
            m_guna.setText("27");
        }else if (f_aswini && m_vishakha3) {
            m_guna.setText("22");
        }else if (f_aswini && m_vishakha1) {
            m_guna.setText("19.18");
        }else if (f_aswini && m_anuradha) {
            m_guna.setText("26.18");
        }else if (f_aswini && m_jestha) {
            m_guna.setText("15");
        }else if (f_aswini && m_mula) {
            m_guna.setText("12.18");
        }else if (f_aswini && m_pusha1) {
            m_guna.setText("24.18");
        }else if (f_aswini && m_pusha3) {
            m_guna.setText("26");
        }else if (f_aswini && m_usha1) {
            m_guna.setText("23");
        }else if (f_aswini && m_usha3) {
            m_guna.setText("26");
        }else if (f_aswini && m_shravana) {
            m_guna.setText("26.09");
        }else if (f_aswini && m_dhanisthaA2) {
            m_guna.setText("21");
        }else if (f_aswini && m_dhanisthaB2) {
            m_guna.setText("19.18");
        }else if (f_aswini && m_shatavisha) {
            m_guna.setText("14.18");
        }else if (f_aswini && m_pubha3) {
            m_guna.setText("15.18");
        }else if (f_aswini && m_pubha1) {
            m_guna.setText("15.18");
        }else if (f_aswini && m_ubha) {
            m_guna.setText("25.18");
        }else if (f_aswini && m_revati) {
            m_guna.setText("27");
        }
    }
    public void fBhariniToFALL(){

        if (f_bharani && m_aswini){
            m_guna.setText("34");
        }else if (f_bharani && m_bharani) {
            m_guna.setText("28");
        }else if (f_bharani && m_kritika1) {
            m_guna.setText("29");
        }else if (f_bharani && m_kritika3) {
            m_guna.setText("19");
        }else if (f_bharani && m_rohini) {
            m_guna.setText("22.18");
        }else if (f_bharani && m_mrigaA2) {
            m_guna.setText("14.18");
        }else if (f_bharani && m_mrigaB2) {
            m_guna.setText("17.18");
        }else if (f_bharani && m_aadra) {
            m_guna.setText("25.18");
        }else if (f_bharani && m_punarvasu3) {
            m_guna.setText("26.18");
        }else if (f_bharani && m_punarvasu1) {
            m_guna.setText("32.18");
        }else if (f_bharani && m_tisya) {
            m_guna.setText("24.18");
        }else if (f_bharani && m_ashlesha) {
            m_guna.setText("26.18");
        }else if (f_bharani && m_magha) {
            m_guna.setText("22");
        }else if (f_bharani && m_pufa) {
            m_guna.setText("20");
        }else if (f_bharani && m_ufa1) {
            m_guna.setText("28");
        }else if (f_bharani && m_ufa3) {
            m_guna.setText("21");
        }else if (f_bharani && m_hasta) {
            m_guna.setText("19.18");
        }else if (f_bharani && m_chitraA2) {
            m_guna.setText("4.18");
        }else if (f_bharani && m_chitraB2) {
            m_guna.setText("14");
        }else if (f_bharani && m_swati) {
            m_guna.setText("29");
        }else if (f_bharani && m_vishakha3) {
            m_guna.setText("22");
        }else if (f_bharani && m_vishakha1) {
            m_guna.setText("19.18");
        }else if (f_bharani && m_anuradha) {
            m_guna.setText("17.18");
        }else if (f_bharani && m_jestha) {
            m_guna.setText("19.18");
        }else if (f_bharani && m_mula) {
            m_guna.setText("19.18");
        }else if (f_bharani && m_pusha1) {
            m_guna.setText("17.18");
        }else if (f_bharani && m_pusha3) {
            m_guna.setText("19");
        }else if (f_bharani && m_usha1) {
            m_guna.setText("25.18");
        }else if (f_bharani && m_usha3) {
            m_guna.setText("28.18");
        }else if (f_bharani && m_shravana) {
            m_guna.setText("26.09");
        }else if (f_bharani && m_dhanisthaA2) {
            m_guna.setText("11");
        }else if (f_bharani && m_dhanisthaB2) {
            m_guna.setText("9.18");
        }else if (f_bharani && m_shatavisha) {
            m_guna.setText("19.18");
        }else if (f_bharani && m_pubha3) {
            m_guna.setText("23.18");
        }else if (f_bharani && m_pubha1) {
            m_guna.setText("23.18");
        }else if (f_bharani && m_ubha) {
            m_guna.setText("18.18");
        }else if (f_bharani && m_revati) {
            m_guna.setText("27.18");
        }
    }
    public void fKritika1ToFALL(){

        if (f_kritika1 && m_aswini){
            m_guna.setText("27.18");
        }else if (f_kritika1 && m_bharani) {
            m_guna.setText("29");
        }else if (f_kritika1 && m_kritika1) {
            m_guna.setText("28");
        }else if (f_kritika1 && m_kritika3) {
            m_guna.setText("18");
        }else if (f_kritika1 && m_rohini) {
            m_guna.setText("11");
        }else if (f_kritika1 && m_mrigaA2) {
            m_guna.setText("17.18");
        }else if (f_kritika1 && m_mrigaB2) {
            m_guna.setText("20.18");
        }else if (f_kritika1 && m_aadra) {
            m_guna.setText("19.18");
        }else if (f_kritika1 && m_punarvasu3) {
            m_guna.setText("20.18");
        }else if (f_kritika1 && m_punarvasu1) {
            m_guna.setText("26.18");
        }else if (f_kritika1 && m_tisya) {
            m_guna.setText("27.18");
        }else if (f_kritika1 && m_ashlesha) {
            m_guna.setText("24.18");
        }else if (f_kritika1 && m_magha) {
            m_guna.setText("16.18");
        }else if (f_kritika1 && m_pufa) {
            m_guna.setText("20");
        }else if (f_kritika1 && m_ufa1) {
            m_guna.setText("22");
        }else if (f_kritika1 && m_ufa3) {
            m_guna.setText("15");
        }else if (f_kritika1 && m_hasta) {
            m_guna.setText("15");
        }else if (f_kritika1 && m_chitraA2) {
            m_guna.setText("17");
        }else if (f_kritika1 && m_chitraB2) {
            m_guna.setText("27");
        }else if (f_kritika1 && m_swati) {
            m_guna.setText("15");
        }else if (f_kritika1 && m_vishakha3) {
            m_guna.setText("19");
        }else if (f_kritika1 && m_vishakha1) {
            m_guna.setText("16.18");
        }else if (f_kritika1 && m_anuradha) {
            m_guna.setText("20.18");
        }else if (f_kritika1 && m_jestha) {
            m_guna.setText("26.18");
        }else if (f_kritika1 && m_mula) {
            m_guna.setText("24");
        }else if (f_kritika1 && m_pusha1) {
            m_guna.setText("17.18");
        }else if (f_kritika1 && m_pusha3) {
            m_guna.setText("19");
        }else if (f_kritika1 && m_usha1) {
            m_guna.setText("12.18");
        }else if (f_kritika1 && m_usha3) {
            m_guna.setText("15.18");
        }else if (f_kritika1 && m_shravana) {
            m_guna.setText("11.27");
        }else if (f_kritika1 && m_dhanisthaA2) {
            m_guna.setText("26");
        }else if (f_kritika1 && m_dhanisthaB2) {
            m_guna.setText("24.18");
        }else if (f_kritika1 && m_shatavisha) {
            m_guna.setText("26.18");
        }else if (f_kritika1 && m_pubha3) {
            m_guna.setText("18.18");
        }else if (f_kritika1 && m_pubha1) {
            m_guna.setText("18.18");
        }else if (f_kritika1 && m_ubha) {
            m_guna.setText("20.18");
        }else if (f_kritika1 && m_revati) {
            m_guna.setText("12.18");
        }
    }
    public void fKritika3ToFALL(){

        if (f_kritika3 && m_aswini){
            m_guna.setText("18.18");
        }else if (f_kritika3 && m_bharani) {
            m_guna.setText("20");
        }else if (f_kritika3 && m_kritika1) {
            m_guna.setText("19");
        }else if (f_kritika3 && m_kritika3) {
            m_guna.setText("28");
        }else if (f_kritika3 && m_rohini) {
            m_guna.setText("21");
        }else if (f_kritika3 && m_mrigaA2) {
            m_guna.setText("27.18");
        }else if (f_kritika3 && m_mrigaB2) {
            m_guna.setText("18");
        }else if (f_kritika3 && m_aadra) {
            m_guna.setText("17");
        }else if (f_kritika3 && m_punarvasu3) {
            m_guna.setText("18");
        }else if (f_kritika3 && m_punarvasu1) {
            m_guna.setText("23");
        }else if (f_kritika3 && m_tisya) {
            m_guna.setText("24");
        }else if (f_kritika3 && m_ashlesha) {
            m_guna.setText("21");
        }else if (f_kritika3 && m_magha) {
            m_guna.setText("18.18");
        }else if (f_kritika3 && m_pufa) {
            m_guna.setText("22");
        }else if (f_kritika3 && m_ufa1) {
            m_guna.setText("24");
        }else if (f_kritika3 && m_ufa3) {
            m_guna.setText("20.18");
        }else if (f_kritika3 && m_hasta) {
            m_guna.setText("20.18");
        }else if (f_kritika3 && m_chitraA2) {
            m_guna.setText("23.18");
        }else if (f_kritika3 && m_chitraB2) {
            m_guna.setText("22");
        }else if (f_kritika3 && m_swati) {
            m_guna.setText("10");
        }else if (f_kritika3 && m_vishakha3) {
            m_guna.setText("14.18");
        }else if (f_kritika3 && m_vishakha1) {
            m_guna.setText("21.18");
        }else if (f_kritika3 && m_anuradha) {
            m_guna.setText("25.18");
        }else if (f_kritika3 && m_jestha) {
            m_guna.setText("31.18");
        }else if (f_kritika3 && m_mula) {
            m_guna.setText("19.18");
        }else if (f_kritika3 && m_pusha1) {
            m_guna.setText("13");
        }else if (f_kritika3 && m_pusha3) {
            m_guna.setText("14.18");
        }else if (f_kritika3 && m_usha1) {
            m_guna.setText("8");
        }else if (f_kritika3 && m_usha3) {
            m_guna.setText("14");
        }else if (f_kritika3 && m_shravana) {
            m_guna.setText("10.09");
        }else if (f_kritika3 && m_dhanisthaA2) {
            m_guna.setText("24.18");
        }else if (f_kritika3 && m_dhanisthaB2) {
            m_guna.setText("29");
        }else if (f_kritika3 && m_shatavisha) {
            m_guna.setText("31");
        }else if (f_kritika3 && m_pubha3) {
            m_guna.setText("23");
        }else if (f_kritika3 && m_pubha1) {
            m_guna.setText("21");
        }else if (f_kritika3 && m_ubha) {
            m_guna.setText("23");
        }else if (f_kritika3 && m_revati) {
            m_guna.setText("15");
        }
    }
    public void fRohiniToFALL(){

        if (f_rohini && m_aswini){
            m_guna.setText("23.18");
        }else if (f_rohini && m_bharani) {
            m_guna.setText("23.18");
        }else if (f_rohini && m_kritika1) {
            m_guna.setText("12");
        }else if (f_rohini && m_kritika3) {
            m_guna.setText("21");
        }else if (f_rohini && m_rohini) {
            m_guna.setText("28");
        }else if (f_rohini && m_mrigaA2) {
            m_guna.setText("36");
        }else if (f_rohini && m_mrigaB2) {
            m_guna.setText("26.18");
        }else if (f_rohini && m_aadra) {
            m_guna.setText("23");
        }else if (f_rohini && m_punarvasu3) {
            m_guna.setText("23");
        }else if (f_rohini && m_punarvasu1) {
            m_guna.setText("28");
        }else if (f_rohini && m_tisya) {
            m_guna.setText("29");
        }else if (f_rohini && m_ashlesha) {
            m_guna.setText("14");
        }else if (f_rohini && m_magha) {
            m_guna.setText("12.18");
        }else if (f_rohini && m_pufa) {
            m_guna.setText("26.18");
        }else if (f_rohini && m_ufa1) {
            m_guna.setText("28");
        }else if (f_rohini && m_ufa3) {
            m_guna.setText("24.18");
        }else if (f_rohini && m_hasta) {
            m_guna.setText("25.18");
        }else if (f_rohini && m_chitraA2) {
            m_guna.setText("19.18");
        }else if (f_rohini && m_chitraB2) {
            m_guna.setText("18.18");
        }else if (f_rohini && m_swati) {
            m_guna.setText("15");
        }else if (f_rohini && m_vishakha3) {
            m_guna.setText("9");
        }else if (f_rohini && m_vishakha1) {
            m_guna.setText("16.18");
        }else if (f_rohini && m_anuradha) {
            m_guna.setText("30.18");
        }else if (f_rohini && m_jestha) {
            m_guna.setText("24.18");
        }else if (f_rohini && m_mula) {
            m_guna.setText("13.18");
        }else if (f_rohini && m_pusha1) {
            m_guna.setText("19.18");
        }else if (f_rohini && m_pusha3) {
            m_guna.setText("21");
        }else if (f_rohini && m_usha1) {
            m_guna.setText("11");
        }else if (f_rohini && m_usha3) {
            m_guna.setText("17");
        }else if (f_rohini && m_shravana) {
            m_guna.setText("18.09");
        }else if (f_rohini && m_dhanisthaA2) {
            m_guna.setText("21");
        }else if (f_rohini && m_dhanisthaB2) {
            m_guna.setText("25.18");
        }else if (f_rohini && m_shatavisha) {
            m_guna.setText("24");
        }else if (f_rohini && m_pubha3) {
            m_guna.setText("30");
        }else if (f_rohini && m_pubha1) {
            m_guna.setText("28");
        }else if (f_rohini && m_ubha) {
            m_guna.setText("27");
        }else if (f_rohini && m_revati) {
            m_guna.setText("20");
        }
    }
    public void fMrigaA2ToFALL(){

        if (f_mrigaA2 && m_aswini){
            m_guna.setText("23.18");
        }else if (f_mrigaA2 && m_bharani) {
            m_guna.setText("14.18");
        }else if (f_mrigaA2 && m_kritika1) {
            m_guna.setText("19.18");
        }else if (f_mrigaA2 && m_kritika3) {
            m_guna.setText("18.18");
        }else if (f_mrigaA2 && m_rohini) {
            m_guna.setText("35");
        }else if (f_mrigaA2 && m_mrigaA2) {
            m_guna.setText("28");
        }else if (f_mrigaA2 && m_mrigaB2) {
            m_guna.setText("18.18");
        }else if (f_mrigaA2 && m_aadra) {
            m_guna.setText("23.18");
        }else if (f_mrigaA2 && m_punarvasu3) {
            m_guna.setText("23");
        }else if (f_mrigaA2 && m_punarvasu1) {
            m_guna.setText("28");
        }else if (f_mrigaA2 && m_tisya) {
            m_guna.setText("21");
        }else if (f_mrigaA2 && m_ashlesha) {
            m_guna.setText("23");
        }else if (f_mrigaA2 && m_magha) {
            m_guna.setText("21.18");
        }else if (f_mrigaA2 && m_pufa) {
            m_guna.setText("17.18");
        }else if (f_mrigaA2 && m_ufa1) {
            m_guna.setText("25.18");
        }else if (f_mrigaA2 && m_ufa3) {
            m_guna.setText("22");
        }else if (f_mrigaA2 && m_hasta) {
            m_guna.setText("25.18");
        }else if (f_mrigaA2 && m_chitraA2) {
            m_guna.setText("12.18");
        }else if (f_mrigaA2 && m_chitraB2) {
            m_guna.setText("11.18");
        }else if (f_mrigaA2 && m_swati) {
            m_guna.setText("24.18");
        }else if (f_mrigaA2 && m_vishakha3) {
            m_guna.setText("18");
        }else if (f_mrigaA2 && m_vishakha1) {
            m_guna.setText("25.18");
        }else if (f_mrigaA2 && m_anuradha) {
            m_guna.setText("22.18");
        }else if (f_mrigaA2 && m_jestha) {
            m_guna.setText("25.18");
        }else if (f_mrigaA2 && m_mula) {
            m_guna.setText("14.18");
        }else if (f_mrigaA2 && m_pusha1) {
            m_guna.setText("10.18");
        }else if (f_mrigaA2 && m_pusha3) {
            m_guna.setText("12");
        }else if (f_mrigaA2 && m_usha1) {
            m_guna.setText("16.18");
        }else if (f_mrigaA2 && m_usha3) {
            m_guna.setText("22.18");
        }else if (f_mrigaA2 && m_shravana) {
            m_guna.setText("26.09");
        }else if (f_mrigaA2 && m_dhanisthaA2) {
            m_guna.setText("14");
        }else if (f_mrigaA2 && m_dhanisthaB2) {
            m_guna.setText("18.18");
        }else if (f_mrigaA2 && m_shatavisha) {
            m_guna.setText("26.18");
        }else if (f_mrigaA2 && m_pubha3) {
            m_guna.setText("29");
        }else if (f_mrigaA2 && m_pubha1) {
            m_guna.setText("27");
        }else if (f_mrigaA2 && m_ubha) {
            m_guna.setText("18");
        }else if (f_mrigaA2 && m_revati) {
            m_guna.setText("28");
        }
    }
    public void fMrigaB2ToFALL(){

        if (f_mrigaB2 && m_aswini){
            m_guna.setText("26.18");
        }else if (f_mrigaB2 && m_bharani) {
            m_guna.setText("14.18");
        }else if (f_mrigaB2 && m_kritika1) {
            m_guna.setText("19.18");
        }else if (f_mrigaB2 && m_kritika3) {
            m_guna.setText("28.18");
        }else if (f_mrigaB2 && m_rohini) {
            m_guna.setText("35");
        }else if (f_mrigaB2 && f_mrigaA2) {
            m_guna.setText("28");
        }else if (f_mrigaB2 && m_mrigaB2) {
            m_guna.setText("18.18");
        }else if (f_mrigaB2 && m_aadra) {
            m_guna.setText("23.18");
        }else if (f_mrigaB2 && m_punarvasu3) {
            m_guna.setText("23");
        }else if (f_mrigaB2 && m_punarvasu1) {
            m_guna.setText("28");
        }else if (f_mrigaB2 && m_tisya) {
            m_guna.setText("21");
        }else if (f_mrigaB2 && m_ashlesha) {
            m_guna.setText("23");
        }else if (f_mrigaB2 && m_magha) {
            m_guna.setText("21.18");
        }else if (f_mrigaB2 && m_pufa) {
            m_guna.setText("17.18");
        }else if (f_mrigaB2 && m_ufa1) {
            m_guna.setText("25.18");
        }else if (f_mrigaB2 && m_ufa3) {
            m_guna.setText("22");
        }else if (f_mrigaB2 && m_hasta) {
            m_guna.setText("25.18");
        }else if (f_mrigaB2 && m_chitraA2) {
            m_guna.setText("12.18");
        }else if (f_mrigaB2 && m_chitraB2) {
            m_guna.setText("11.18");
        }else if (f_mrigaB2 && m_swati) {
            m_guna.setText("24.18");
        }else if (f_mrigaB2 && m_vishakha3) {
            m_guna.setText("18");
        }else if (f_mrigaB2 && m_vishakha1) {
            m_guna.setText("25.18");
        }else if (f_mrigaB2 && m_anuradha) {
            m_guna.setText("22.18");
        }else if (f_mrigaB2 && m_jestha) {
            m_guna.setText("25.18");
        }else if (f_mrigaB2 && m_mula) {
            m_guna.setText("14.18");
        }else if (f_mrigaB2 && m_pusha1) {
            m_guna.setText("10.18");
        }else if (f_mrigaB2 && m_pusha3) {
            m_guna.setText("12");
        }else if (f_mrigaB2 && m_usha1) {
            m_guna.setText("16.18");
        }else if (f_mrigaB2 && m_usha3) {
            m_guna.setText("22.18");
        }else if (f_mrigaB2 && m_shravana) {
            m_guna.setText("26.09");
        }else if (f_mrigaB2 && m_dhanisthaA2) {
            m_guna.setText("14");
        }else if (f_mrigaB2 && m_dhanisthaB2) {
            m_guna.setText("18.18");
        }else if (f_mrigaB2 && m_shatavisha) {
            m_guna.setText("25.18");
        }else if (f_mrigaB2 && m_pubha3) {
            m_guna.setText("29");
        }else if (f_mrigaB2 && m_pubha1) {
            m_guna.setText("27");
        }else if (f_mrigaB2 && m_ubha) {
            m_guna.setText("18");
        }else if (f_mrigaB2 && m_revati) {
            m_guna.setText("28");
        }
    }
    public void fAdraToFALL(){

        if (f_aadra && m_aswini){
            m_guna.setText("18.18");
        }else if (f_aadra && m_bharani) {
            m_guna.setText("26.18");
        }else if (f_aadra && m_kritika1) {
            m_guna.setText("20.18");
        }else if (f_aadra && m_kritika3) {
            m_guna.setText("18");
        }else if (f_aadra && m_rohini) {
            m_guna.setText("24");
        }else if (f_aadra && m_mrigaA2) {
            m_guna.setText("25.18");
        }else if (f_aadra && m_mrigaB2) {
            m_guna.setText("34");
        }else if (f_aadra && m_aadra) {
            m_guna.setText("28");
        }else if (f_aadra && m_punarvasu3) {
            m_guna.setText("25");
        }else if (f_aadra && m_punarvasu1) {
            m_guna.setText("12.18");
        }else if (f_aadra && m_tisya) {
            m_guna.setText("20");
        }else if (f_aadra && m_ashlesha) {
            m_guna.setText("13");
        }else if (f_aadra && m_magha) {
            m_guna.setText("23");
        }else if (f_aadra && m_pufa) {
            m_guna.setText("29");
        }else if (f_aadra && m_ufa1) {
            m_guna.setText("22");
        }else if (f_aadra && m_ufa3) {
            m_guna.setText("24.18");
        }else if (f_aadra && m_hasta) {
            m_guna.setText("24.18");
        }else if (f_aadra && m_chitraA2) {
            m_guna.setText("27");
        }else if (f_aadra && m_chitraB2) {
            m_guna.setText("20");
        }else if (f_aadra && m_swati) {
            m_guna.setText("27");
        }else if (f_aadra && m_vishakha3) {
            m_guna.setText("20");
        }else if (f_aadra && m_vishakha1) {
            m_guna.setText("14.18");
        }else if (f_aadra && m_anuradha) {
            m_guna.setText("18");
        }else if (f_aadra && m_jestha) {
            m_guna.setText("4");
        }else if (f_aadra && m_mula) {
            m_guna.setText("16");
        }else if (f_aadra && m_pusha1) {
            m_guna.setText("28");
        }else if (f_aadra && m_pusha3) {
            m_guna.setText("26.18");
        }else if (f_aadra && m_usha1) {
            m_guna.setText("28");
        }else if (f_aadra && m_usha3) {
            m_guna.setText("23");
        }else if (f_aadra && m_shravana) {
            m_guna.setText("23.27");
        }else if (f_aadra && m_dhanisthaA2) {
            m_guna.setText("17.18");
        }else if (f_aadra && m_dhanisthaB2) {
            m_guna.setText("19");
        }else if (f_aadra && m_shatavisha) {
            m_guna.setText("12");
        }else if (f_aadra && m_pubha3) {
            m_guna.setText("17");
        }else if (f_aadra && m_pubha1) {
            m_guna.setText("19");
        }else if (f_aadra && m_ubha) {
            m_guna.setText("26.18");
        }else if (f_aadra && m_revati) {
            m_guna.setText("26.18");
        }
    }
    public void fPunarvasu3ToFALL(){

        if (f_punarvasu3 && m_aswini){
            m_guna.setText("18.18");
        }else if (f_punarvasu3 && m_bharani) {
            m_guna.setText("25.18");
        }else if (f_punarvasu3 && m_kritika1) {
            m_guna.setText("22.18");
        }else if (f_punarvasu3 && m_kritika3) {
            m_guna.setText("20");
        }else if (f_punarvasu3 && m_rohini) {
            m_guna.setText("23");
        }else if (f_punarvasu3 && m_mrigaA2) {
            m_guna.setText("24");
        }else if (f_punarvasu3 && m_mrigaB2) {
            m_guna.setText("32.18");
        }else if (f_punarvasu3 && m_aadra) {
            m_guna.setText("24");
        }else if (f_punarvasu3 && m_punarvasu3) {
            m_guna.setText("28");
        }else if (f_punarvasu3 && m_punarvasu1) {
            m_guna.setText("15.18");
        }else if (f_punarvasu3 && m_tisya) {
            m_guna.setText("22.18");
        }else if (f_punarvasu3 && m_ashlesha) {
            m_guna.setText("17");
        }else if (f_punarvasu3 && m_magha) {
            m_guna.setText("23");
        }else if (f_punarvasu3 && m_pufa) {
            m_guna.setText("27");
        }else if (f_punarvasu3 && m_ufa1) {
            m_guna.setText("21");
        }else if (f_punarvasu3 && m_ufa3) {
            m_guna.setText("23.18");
        }else if (f_punarvasu3 && m_hasta) {
            m_guna.setText("24.18");
        }else if (f_punarvasu3 && m_chitraA2) {
            m_guna.setText("26.18");
        }else if (f_punarvasu3 && m_chitraB2) {
            m_guna.setText("19.18");
        }else if (f_punarvasu3 && m_swati) {
            m_guna.setText("27");
        }else if (f_punarvasu3 && m_vishakha3) {
            m_guna.setText("21");
        }else if (f_punarvasu3 && m_vishakha1) {
            m_guna.setText("15.18");
        }else if (f_punarvasu3 && m_anuradha) {
            m_guna.setText("21.18");
        }else if (f_punarvasu3 && m_jestha) {
            m_guna.setText("7");
        }else if (f_punarvasu3 && m_mula) {
            m_guna.setText("14");
        }else if (f_punarvasu3 && m_pusha1) {
            m_guna.setText("27");
        }else if (f_punarvasu3 && m_pusha3) {
            m_guna.setText("25.18");
        }else if (f_punarvasu3 && m_usha1) {
            m_guna.setText("27");
        }else if (f_punarvasu3 && m_usha3) {
            m_guna.setText("22");
        }else if (f_punarvasu3 && m_shravana) {
            m_guna.setText("23.09");
        }else if (f_punarvasu3 && m_dhanisthaA2) {
            m_guna.setText("18");
        }else if (f_punarvasu3 && m_dhanisthaB2) {
            m_guna.setText("19.18");
        }else if (f_punarvasu3 && m_shatavisha) {
            m_guna.setText("13");
        }else if (f_punarvasu3 && m_pubha3) {
            m_guna.setText("17");
        }else if (f_punarvasu3 && m_pubha1) {
            m_guna.setText("19");
        }else if (f_punarvasu3 && m_ubha) {
            m_guna.setText("27");
        }else if (f_punarvasu3 && m_revati) {
            m_guna.setText("26.18");
        }
    }
    public void fPunarvasu1ToFALL(){

        if (f_punarvasu1 && m_aswini){
            m_guna.setText("22.18");
        }else if (f_punarvasu1 && m_bharani) {
            m_guna.setText("29.18");
        }else if (f_punarvasu1 && m_kritika1) {
            m_guna.setText("26.18");
        }else if (f_punarvasu1 && m_kritika3) {
            m_guna.setText("23.18");
        }else if (f_punarvasu1 && m_rohini) {
            m_guna.setText("26");
        }else if (f_punarvasu1 && m_mrigaA2) {
            m_guna.setText("27");
        }else if (f_punarvasu1 && m_mrigaB2) {
            m_guna.setText("19");
        }else if (f_punarvasu1 && m_aadra) {
            m_guna.setText("10.18");
        }else if (f_punarvasu1 && m_punarvasu3) {
            m_guna.setText("14.18");
        }else if (f_punarvasu1 && m_punarvasu1) {
            m_guna.setText("28");
        }else if (f_punarvasu1 && m_tisya) {
            m_guna.setText("35");
        }else if (f_punarvasu1 && m_ashlesha) {
            m_guna.setText("29.18");
        }else if (f_punarvasu1 && m_magha) {
            m_guna.setText("17.18");
        }else if (f_punarvasu1 && m_pufa) {
            m_guna.setText("21.18");
        }else if (f_punarvasu1 && m_ufa1) {
            m_guna.setText("15.18");
        }else if (f_punarvasu1 && m_ufa3) {
            m_guna.setText("17");
        }else if (f_punarvasu1 && m_hasta) {
            m_guna.setText("18");
        }else if (f_punarvasu1 && m_chitraA2) {
            m_guna.setText("20");
        }else if (f_punarvasu1 && m_chitraB2) {
            m_guna.setText("19.18");
        }else if (f_punarvasu1 && m_swati) {
            m_guna.setText("27");
        }else if (f_punarvasu1 && m_vishakha3) {
            m_guna.setText("21");
        }else if (f_punarvasu1 && m_vishakha1) {
            m_guna.setText("20");
        }else if (f_punarvasu1 && m_anuradha) {
            m_guna.setText("26");
        }else if (f_punarvasu1 && m_jestha) {
            m_guna.setText("11.18");
        }else if (f_punarvasu1 && m_mula) {
            m_guna.setText("8");
        }else if (f_punarvasu1 && m_pusha1) {
            m_guna.setText("21");
        }else if (f_punarvasu1 && m_pusha3) {
            m_guna.setText("22.18");
        }else if (f_punarvasu1 && m_usha1) {
            m_guna.setText("21");
        }else if (f_punarvasu1 && m_usha3) {
            m_guna.setText("26");
        }else if (f_punarvasu1 && m_shravana) {
            m_guna.setText("26.09");
        }else if (f_punarvasu1 && m_dhanisthaA2) {
            m_guna.setText("22");
        }else if (f_punarvasu1 && m_dhanisthaB2) {
            m_guna.setText("13.18");
        }else if (f_punarvasu1 && m_shatavisha) {
            m_guna.setText("7");
        }else if (f_punarvasu1 && m_pubha3) {
            m_guna.setText("11");
        }else if (f_punarvasu1 && m_pubha1) {
            m_guna.setText("17");
        }else if (f_punarvasu1 && m_ubha) {
            m_guna.setText("25");
        }else if (f_punarvasu1 && m_revati) {
            m_guna.setText("24.18");
        }
    }
    public void fTishyaToFALL(){

        if (f_tisya && m_aswini){
            m_guna.setText("31.18");
        }else if (f_tisya && m_bharani) {
            m_guna.setText("22.18");
        }else if (f_tisya && m_kritika1) {
            m_guna.setText("27.18");
        }else if (f_tisya && m_kritika3) {
            m_guna.setText("24");
        }else if (f_tisya && m_rohini) {
            m_guna.setText("27");
        }else if (f_tisya && m_mrigaA2) {
            m_guna.setText("20");
        }else if (f_tisya && m_mrigaB2) {
            m_guna.setText("12");
        }else if (f_tisya && m_aadra) {
            m_guna.setText("18");
        }else if (f_tisya && m_punarvasu3) {
            m_guna.setText("21.18");
        }else if (f_tisya && m_punarvasu1) {
            m_guna.setText("35");
        }else if (f_tisya && m_tisya) {
            m_guna.setText("28");
        }else if (f_tisya && m_ashlesha) {
            m_guna.setText("30");
        }else if (f_tisya && m_magha) {
            m_guna.setText("18.18");
        }else if (f_tisya && m_pufa) {
            m_guna.setText("14.18");
        }else if (f_tisya && m_ufa1) {
            m_guna.setText("24.18");
        }else if (f_tisya && m_ufa3) {
            m_guna.setText("26");
        }else if (f_tisya && m_hasta) {
            m_guna.setText("27");
        }else if (f_tisya && m_chitraA2) {
            m_guna.setText("12");
        }else if (f_tisya && m_chitraB2) {
            m_guna.setText("11.18");
        }else if (f_tisya && m_swati) {
            m_guna.setText("26.18");
        }else if (f_tisya && m_vishakha3) {
            m_guna.setText("21");
        }else if (f_tisya && m_vishakha1) {
            m_guna.setText("20");
        }else if (f_tisya && m_anuradha) {
            m_guna.setText("19");
        }else if (f_tisya && m_jestha) {
            m_guna.setText("22");
        }else if (f_tisya && m_mula) {
            m_guna.setText("17");
        }else if (f_tisya && m_pusha1) {
            m_guna.setText("11");
        }else if (f_tisya && m_pusha3) {
            m_guna.setText("12.18");
        }else if (f_tisya && m_usha1) {
            m_guna.setText("22");
        }else if (f_tisya && m_usha3) {
            m_guna.setText("27");
        }else if (f_tisya && m_shravana) {
            m_guna.setText("24.09");
        }else if (f_tisya && m_dhanisthaA2) {
            m_guna.setText("13");
        }else if (f_tisya && m_dhanisthaB2) {
            m_guna.setText("4.18");
        }else if (f_tisya && m_shatavisha) {
            m_guna.setText("14.18");
        }else if (f_tisya && m_pubha3) {
            m_guna.setText("18");
        }else if (f_tisya && m_pubha1) {
            m_guna.setText("24");
        }else if (f_tisya && m_ubha) {
            m_guna.setText("18");
        }else if (f_tisya && m_revati) {
            m_guna.setText("27");
        }
    }
    public void fAshleshaToFALL(){

        if (f_ashlesha && m_aswini){
            m_guna.setText("26");
        }else if (f_ashlesha && m_bharani) {
            m_guna.setText("24.18");
        }else if (f_ashlesha && m_kritika1) {
            m_guna.setText("23.18");
        }else if (f_ashlesha && m_kritika3) {
            m_guna.setText("20");
        }else if (f_ashlesha && m_rohini) {
            m_guna.setText("13");
        }else if (f_ashlesha && m_mrigaA2) {
            m_guna.setText("21");
        }else if (f_ashlesha && m_mrigaB2) {
            m_guna.setText("13");
        }else if (f_ashlesha && m_aadra) {
            m_guna.setText("12");
        }else if (f_ashlesha && m_punarvasu3) {
            m_guna.setText("15");
        }else if (f_ashlesha && m_punarvasu1) {
            m_guna.setText("28.18");
        }else if (f_ashlesha && m_tisya) {
            m_guna.setText("29");
        }else if (f_ashlesha && m_ashlesha) {
            m_guna.setText("28");
        }else if (f_ashlesha && m_magha) {
            m_guna.setText("16");
        }else if (f_ashlesha && m_pufa) {
            m_guna.setText("16.18");
        }else if (f_ashlesha && m_ufa1) {
            m_guna.setText("18.18");
        }else if (f_ashlesha && m_ufa3) {
            m_guna.setText("20");
        }else if (f_ashlesha && m_hasta) {
            m_guna.setText("20");
        }else if (f_ashlesha && m_chitraA2) {
            m_guna.setText("25");
        }else if (f_ashlesha && m_chitraB2) {
            m_guna.setText("24.18");
        }else if (f_ashlesha && m_swati) {
            m_guna.setText("11.18");
        }else if (f_ashlesha && m_vishakha3) {
            m_guna.setText("16.18");
        }else if (f_ashlesha && m_vishakha1) {
            m_guna.setText("15.18");
        }else if (f_ashlesha && m_anuradha) {
            m_guna.setText("20");
        }else if (f_ashlesha && m_jestha) {
            m_guna.setText("26");
        }else if (f_ashlesha && m_mula) {
            m_guna.setText("22.18");
        }else if (f_ashlesha && m_pusha1) {
            m_guna.setText("16");
        }else if (f_ashlesha && m_pusha3) {
            m_guna.setText("17.18");
        }else if (f_ashlesha && m_usha1) {
            m_guna.setText("8");
        }else if (f_ashlesha && m_usha3) {
            m_guna.setText("13");
        }else if (f_ashlesha && m_shravana) {
            m_guna.setText("12.09");
        }else if (f_ashlesha && m_dhanisthaA2) {
            m_guna.setText("27");
        }else if (f_ashlesha && m_dhanisthaB2) {
            m_guna.setText("18.18");
        }else if (f_ashlesha && m_shatavisha) {
            m_guna.setText("18.18");
        }else if (f_ashlesha && m_pubha3) {
            m_guna.setText("12.18");
        }else if (f_ashlesha && m_pubha1) {
            m_guna.setText("18.18");
        }else if (f_ashlesha && m_ubha) {
            m_guna.setText("20");
        }else if (f_ashlesha && m_revati) {
            m_guna.setText("12");
        }
    }
    public void fMaghaToFALL(){

        if (f_magha && m_aswini){
            m_guna.setText("21");
        }else if (f_magha && m_bharani) {
            m_guna.setText("21");
        }else if (f_magha && m_kritika1) {
            m_guna.setText("17.18");
        }else if (f_magha && m_kritika3) {
            m_guna.setText("18.18");
        }else if (f_magha && m_rohini) {
            m_guna.setText("11.18");
        }else if (f_magha && m_mrigaA2) {
            m_guna.setText("19.18");
        }else if (f_magha && m_mrigaB2) {
            m_guna.setText("22");
        }else if (f_magha && m_aadra) {
            m_guna.setText("22");
        }else if (f_magha && m_punarvasu3) {
            m_guna.setText("21");
        }else if (f_magha && m_punarvasu1) {
            m_guna.setText("17.18");
        }else if (f_magha && m_tisya) {
            m_guna.setText("19.18");
        }else if (f_magha && m_ashlesha) {
            m_guna.setText("17");
        }else if (f_magha && m_magha) {
            m_guna.setText("28");
        }else if (f_magha && m_pufa) {
            m_guna.setText("30");
        }else if (f_magha && m_ufa1) {
            m_guna.setText("26.18");
        }else if (f_magha && m_ufa3) {
            m_guna.setText("16");
        }else if (f_magha && m_hasta) {
            m_guna.setText("16");
        }else if (f_magha && m_chitraA2) {
            m_guna.setText("22");
        }else if (f_magha && m_chitraB2) {
            m_guna.setText("25");
        }else if (f_magha && m_swati) {
            m_guna.setText("11");
        }else if (f_magha && m_vishakha3) {
            m_guna.setText("17");
        }else if (f_magha && m_vishakha1) {
            m_guna.setText("24.18");
        }else if (f_magha && m_anuradha) {
            m_guna.setText("26.18");
        }else if (f_magha && m_jestha) {
            m_guna.setText("34");
        }else if (f_magha && m_mula) {
            m_guna.setText("24.18");
        }else if (f_magha && m_pusha1) {
            m_guna.setText("19.18");
        }else if (f_magha && m_pusha3) {
            m_guna.setText("21");
        }else if (f_magha && m_usha1) {
            m_guna.setText("10");
        }else if (f_magha && m_usha3) {
            m_guna.setText("5.18");
        }else if (f_magha && m_shravana) {
            m_guna.setText("4.27");
        }else if (f_magha && m_dhanisthaA2) {
            m_guna.setText("18.18");
        }else if (f_magha && m_dhanisthaB2) {
            m_guna.setText("24");
        }else if (f_magha && m_shatavisha) {
            m_guna.setText("25");
        }else if (f_magha && m_pubha3) {
            m_guna.setText("18");
        }else if (f_magha && m_pubha1) {
            m_guna.setText("18.18");
        }else if (f_magha && m_ubha) {
            m_guna.setText("19.18");
        }else if (f_magha && m_revati) {
            m_guna.setText("13");
        }
    }
    public void fPufaToFALL(){

        if (f_pufa && m_aswini){
            m_guna.setText("27");
        }else if (f_pufa && m_bharani) {
            m_guna.setText("19");
        }else if (f_pufa && m_kritika1) {
            m_guna.setText("21");
        }else if (f_pufa && m_kritika3) {
            m_guna.setText("22");
        }else if (f_pufa && m_rohini) {
            m_guna.setText("25.18");
        }else if (f_pufa && m_mrigaA2) {
            m_guna.setText("17.18");
        }else if (f_pufa && m_mrigaB2) {
            m_guna.setText("20");
        }else if (f_pufa && m_aadra) {
            m_guna.setText("28");
        }else if (f_pufa && m_punarvasu3) {
            m_guna.setText("27");
        }else if (f_pufa && m_punarvasu1) {
            m_guna.setText("23.18");
        }else if (f_pufa && m_tisya) {
            m_guna.setText("17.18");
        }else if (f_pufa && m_ashlesha) {
            m_guna.setText("17.18");
        }else if (f_pufa && m_magha) {
            m_guna.setText("30");
        }else if (f_pufa && m_pufa) {
            m_guna.setText("28");
        }else if (f_pufa && m_ufa1) {
            m_guna.setText("34");
        }else if (f_pufa && m_ufa3) {
            m_guna.setText("23.18");
        }else if (f_pufa && m_hasta) {
            m_guna.setText("22");
        }else if (f_pufa && m_chitraA2) {
            m_guna.setText("8");
        }else if (f_pufa && m_chitraB2) {
            m_guna.setText("11");
        }else if (f_pufa && m_swati) {
            m_guna.setText("25");
        }else if (f_pufa && m_vishakha3) {
            m_guna.setText("19");
        }else if (f_pufa && m_vishakha1) {
            m_guna.setText("26.18");
        }else if (f_pufa && m_anuradha) {
            m_guna.setText("24.18");
        }else if (f_pufa && m_jestha) {
            m_guna.setText("26.18");
        }else if (f_pufa && m_mula) {
            m_guna.setText("18.18");
        }else if (f_pufa && m_pusha1) {
            m_guna.setText("17.18");
        }else if (f_pufa && m_pusha3) {
            m_guna.setText("19");
        }else if (f_pufa && m_usha1) {
            m_guna.setText("25.18");
        }else if (f_pufa && m_usha3) {
            m_guna.setText("21");
        }else if (f_pufa && m_shravana) {
            m_guna.setText("18.27");
        }else if (f_pufa && m_dhanisthaA2) {
            m_guna.setText("4.18");
        }else if (f_pufa && m_dhanisthaB2) {
            m_guna.setText("10");
        }else if (f_pufa && m_shatavisha) {
            m_guna.setText("19");
        }else if (f_pufa && m_pubha3) {
            m_guna.setText("24");
        }else if (f_pufa && m_pubha1) {
            m_guna.setText("24.18");
        }else if (f_pufa && m_ubha) {
            m_guna.setText("17.18");
        }else if (f_pufa && m_revati) {
            m_guna.setText("25.18");
        }
    }
    public void fUfa1ToFALL(){

        if (f_ufa1 && m_aswini){
            m_guna.setText("18.18");
        }else if (f_ufa1 && m_bharani) {
            m_guna.setText("27");
        }else if (f_ufa1 && m_kritika1) {
            m_guna.setText("22");
        }else if (f_ufa1 && m_kritika3) {
            m_guna.setText("23");
        }else if (f_ufa1 && m_rohini) {
            m_guna.setText("27");
        }else if (f_ufa1 && m_mrigaA2) {
            m_guna.setText("25.18");
        }else if (f_ufa1 && m_mrigaB2) {
            m_guna.setText("28");
        }else if (f_ufa1 && m_aadra) {
            m_guna.setText("21");
        }else if (f_ufa1 && m_punarvasu3) {
            m_guna.setText("21");
        }else if (f_ufa1 && m_punarvasu1) {
            m_guna.setText("17.18");
        }else if (f_ufa1 && m_tisya) {
            m_guna.setText("26.18");
        }else if (f_ufa1 && m_ashlesha) {
            m_guna.setText("19.18");
        }else if (f_ufa1 && m_magha) {
            m_guna.setText("26.18");
        }else if (f_ufa1 && m_pufa) {
            m_guna.setText("34");
        }else if (f_ufa1 && m_ufa1) {
            m_guna.setText("28");
        }else if (f_ufa1 && m_ufa3) {
            m_guna.setText("17.18");
        }else if (f_ufa1 && m_hasta) {
            m_guna.setText("15.18");
        }else if (f_ufa1 && m_chitraA2) {
            m_guna.setText("14");
        }else if (f_ufa1 && m_chitraB2) {
            m_guna.setText("17");
        }else if (f_ufa1 && m_swati) {
            m_guna.setText("26");
        }else if (f_ufa1 && m_vishakha3) {
            m_guna.setText("17");
        }else if (f_ufa1 && m_vishakha1) {
            m_guna.setText("24.18");
        }else if (f_ufa1 && m_anuradha) {
            m_guna.setText("33.18");
        }else if (f_ufa1 && m_jestha) {
            m_guna.setText("19.18");
        }else if (f_ufa1 && m_mula) {
            m_guna.setText("10");
        }else if (f_ufa1 && m_pusha1) {
            m_guna.setText("25.18");
        }else if (f_ufa1 && m_pusha3) {
            m_guna.setText("27");
        }else if (f_ufa1 && m_usha1) {
            m_guna.setText("26.18");
        }else if (f_ufa1 && m_usha3) {
            m_guna.setText("22");
        }else if (f_ufa1 && m_shravana) {
            m_guna.setText("20.09");
        }else if (f_ufa1 && m_dhanisthaA2) {
            m_guna.setText("12.18");
        }else if (f_ufa1 && m_dhanisthaB2) {
            m_guna.setText("18");
        }else if (f_ufa1 && m_shatavisha) {
            m_guna.setText("12");
        }else if (f_ufa1 && m_pubha3) {
            m_guna.setText("16");
        }else if (f_ufa1 && m_pubha1) {
            m_guna.setText("16.18");
        }else if (f_ufa1 && m_ubha) {
            m_guna.setText("27.18");
        }else if (f_ufa1 && m_revati) {
            m_guna.setText("25.18");
        }
    }
    public void fUfa3ToFALL(){

        if (f_ufa3 && m_aswini){
            m_guna.setText("12.18");
        }else if (f_ufa3 && m_bharani) {
            m_guna.setText("21");
        }else if (f_ufa3 && m_kritika1) {
            m_guna.setText("16");
        }else if (f_ufa3 && m_kritika3) {
            m_guna.setText("20.18");
        }else if (f_ufa3 && m_rohini) {
            m_guna.setText("24.18");
        }else if (f_ufa3 && m_mrigaA2) {
            m_guna.setText("23");
        }else if (f_ufa3 && m_mrigaB2) {
            m_guna.setText("30.18");
        }else if (f_ufa3 && m_aadra) {
            m_guna.setText("23.18");
        }else if (f_ufa3 && m_punarvasu3) {
            m_guna.setText("23.18");
        }else if (f_ufa3 && m_punarvasu1) {
            m_guna.setText("19");
        }else if (f_ufa3 && m_tisya) {
            m_guna.setText("28");
        }else if (f_ufa3 && m_ashlesha) {
            m_guna.setText("21");
        }else if (f_ufa3 && m_magha) {
            m_guna.setText("17");
        }else if (f_ufa3 && m_pufa) {
            m_guna.setText("24.18");
        }else if (f_ufa3 && m_ufa1) {
            m_guna.setText("18.18");
        }else if (f_ufa3 && m_ufa3) {
            m_guna.setText("28");
        }else if (f_ufa3 && m_hasta) {
            m_guna.setText("27");
        }else if (f_ufa3 && m_chitraA2) {
            m_guna.setText("24.18");
        }else if (f_ufa3 && m_chitraB2) {
            m_guna.setText("16.18");
        }else if (f_ufa3 && m_swati) {
            m_guna.setText("25.18");
        }else if (f_ufa3 && m_vishakha3) {
            m_guna.setText("16.18");
        }else if (f_ufa3 && m_vishakha1) {
            m_guna.setText("19");
        }else if (f_ufa3 && m_anuradha) {
            m_guna.setText("28");
        }else if (f_ufa3 && m_jestha) {
            m_guna.setText("14");
        }else if (f_ufa3 && m_mula) {
            m_guna.setText("14");
        }else if (f_ufa3 && m_pusha1) {
            m_guna.setText("29.18");
        }else if (f_ufa3 && m_pusha3) {
            m_guna.setText("28");
        }else if (f_ufa3 && m_usha1) {
            m_guna.setText("30.18");
        }else if (f_ufa3 && m_usha3) {
            m_guna.setText("25.18");
        }else if (f_ufa3 && m_shravana) {
            m_guna.setText("25.09");
        }else if (f_ufa3 && m_dhanisthaA2) {
            m_guna.setText("16");
        }else if (f_ufa3 && m_dhanisthaB2) {
            m_guna.setText("16.18");
        }else if (f_ufa3 && m_shatavisha) {
            m_guna.setText("10.18");
        }else if (f_ufa3 && m_pubha3) {
            m_guna.setText("14.18");
        }else if (f_ufa3 && m_pubha1) {
            m_guna.setText("17.18");
        }else if (f_ufa3 && m_ubha) {
            m_guna.setText("28.18");
        }else if (f_ufa3 && m_revati) {
            m_guna.setText("26.18");
        }
    }
    public void fHastaToFALL(){

        if (f_hasta && m_aswini){
            m_guna.setText("10.18");
        }else if (f_hasta && m_bharani) {
            m_guna.setText("19.18");
        }else if (f_hasta && m_kritika1) {
            m_guna.setText("17");
        }else if (f_hasta && m_kritika3) {
            m_guna.setText("21.18");
        }else if (f_hasta && m_rohini) {
            m_guna.setText("24.18");
        }else if (f_hasta && m_mrigaA2) {
            m_guna.setText("25.18");
        }else if (f_hasta && m_mrigaB2) {
            m_guna.setText("33");
        }else if (f_hasta && m_aadra) {
            m_guna.setText("22.18");
        }else if (f_hasta && m_punarvasu3) {
            m_guna.setText("23.18");
        }else if (f_hasta && m_punarvasu1) {
            m_guna.setText("19");
        }else if (f_hasta && m_tisya) {
            m_guna.setText("28");
        }else if (f_hasta && m_ashlesha) {
            m_guna.setText("22");
        }else if (f_hasta && m_magha) {
            m_guna.setText("18");
        }else if (f_hasta && m_pufa) {
            m_guna.setText("22");
        }else if (f_hasta && m_ufa1) {
            m_guna.setText("16.18");
        }else if (f_hasta && m_ufa3) {
            m_guna.setText("26");
        }else if (f_hasta && m_hasta) {
            m_guna.setText("28");
        }else if (f_hasta && m_chitraA2) {
            m_guna.setText("28");
        }else if (f_hasta && m_chitraB2) {
            m_guna.setText("20");
        }else if (f_hasta && m_swati) {
            m_guna.setText("26");
        }else if (f_hasta && m_vishakha3) {
            m_guna.setText("18.18");
        }else if (f_hasta && m_vishakha1) {
            m_guna.setText("21");
        }else if (f_hasta && m_anuradha) {
            m_guna.setText("27");
        }else if (f_hasta && m_jestha) {
            m_guna.setText("14");
        }else if (f_hasta && m_mula) {
            m_guna.setText("15");
        }else if (f_hasta && m_pusha1) {
            m_guna.setText("27");
        }else if (f_hasta && m_pusha3) {
            m_guna.setText("25.18");
        }else if (f_hasta && m_usha1) {
            m_guna.setText("28.18");
        }else if (f_hasta && m_usha3) {
            m_guna.setText("23.18");
        }else if (f_hasta && m_shravana) {
            m_guna.setText("25.09");
        }else if (f_hasta && m_dhanisthaA2) {
            m_guna.setText("26.18");
        }else if (f_hasta && m_dhanisthaB2) {
            m_guna.setText("21.18");
        }else if (f_hasta && m_shatavisha) {
            m_guna.setText("9.18");
        }else if (f_hasta && m_pubha3) {
            m_guna.setText("15.18");
        }else if (f_hasta && m_pubha1) {
            m_guna.setText("18.18");
        }else if (f_hasta && m_ubha) {
            m_guna.setText("26.18");
        }else if (f_hasta && m_revati) {
            m_guna.setText("27.18");
        }
    }
    public void fChitraA2ToFALL(){

        if (f_chitraA2 && m_aswini){
            m_guna.setText("12.18");
        }else if (f_chitraA2 && m_bharani) {
            m_guna.setText("5.18");
        }else if (f_chitraA2 && m_kritika1) {
            m_guna.setText("18.18");
        }else if (f_chitraA2 && m_kritika3) {
            m_guna.setText("23");
        }else if (f_chitraA2 && m_rohini) {
            m_guna.setText("19.18");
        }else if (f_chitraA2 && m_mrigaA2) {
            m_guna.setText("11.18");
        }else if (f_chitraA2 && m_mrigaB2) {
            m_guna.setText("19");
        }else if (f_chitraA2 && m_aadra) {
            m_guna.setText("26");
        }else if (f_chitraA2 && m_punarvasu3) {
            m_guna.setText("24.18");
        }else if (f_chitraA2 && m_punarvasu1) {
            m_guna.setText("20");
        }else if (f_chitraA2 && m_tisya) {
            m_guna.setText("12");
        }else if (f_chitraA2 && m_ashlesha) {
            m_guna.setText("26");
        }else if (f_chitraA2 && m_magha) {
            m_guna.setText("23");
        }else if (f_chitraA2 && m_pufa) {
            m_guna.setText("9");
        }else if (f_chitraA2 && m_ufa1) {
            m_guna.setText("15");
        }else if (f_chitraA2 && m_ufa3) {
            m_guna.setText("24.18");
        }else if (f_chitraA2 && m_hasta) {
            m_guna.setText("27");
        }else if (f_chitraA2 && m_chitraA2) {
            m_guna.setText("28");
        }else if (f_chitraA2 && m_chitraB2) {
            m_guna.setText("20");
        }else if (f_chitraA2 && m_swati) {
            m_guna.setText("19");
        }else if (f_chitraA2 && m_vishakha3) {
            m_guna.setText("26.18");
        }else if (f_chitraA2 && m_vishakha1) {
            m_guna.setText("29");
        }else if (f_chitraA2 && m_anuradha) {
            m_guna.setText("13");
        }else if (f_chitraA2 && m_jestha) {
            m_guna.setText("27");
        }else if (f_chitraA2 && m_mula) {
            m_guna.setText("27");
        }else if (f_chitraA2 && m_pusha1) {
            m_guna.setText("13");
        }else if (f_chitraA2 && m_pusha3) {
            m_guna.setText("11.18");
        }else if (f_chitraA2 && m_usha1) {
            m_guna.setText("22");
        }else if (f_chitraA2 && m_usha3) {
            m_guna.setText("17");
        }else if (f_chitraA2 && m_shravana) {
            m_guna.setText("18.09");
        }else if (f_chitraA2 && m_dhanisthaA2) {
            m_guna.setText("16.18");
        }else if (f_chitraA2 && m_dhanisthaB2) {
            m_guna.setText("17");
        }else if (f_chitraA2 && m_shatavisha) {
            m_guna.setText("24");
        }else if (f_chitraA2 && m_pubha3) {
            m_guna.setText("17.18");
        }else if (f_chitraA2 && m_pubha1) {
            m_guna.setText("20.18");
        }else if (f_chitraA2 && m_ubha) {
            m_guna.setText("10.18");
        }else if (f_chitraA2 && m_revati) {
            m_guna.setText("20.18");
        }
    }
    public void fChitraB2ToFALL(){

        if (f_chitraB2 && m_aswini){
            m_guna.setText("22");
        }else if (f_chitraB2 && m_bharani) {
            m_guna.setText("15");
        }else if (f_chitraB2 && m_kritika1) {
            m_guna.setText("28");
        }else if (f_chitraB2 && m_kritika3) {
            m_guna.setText("23");
        }else if (f_chitraB2 && m_rohini) {
            m_guna.setText("19.18");
        }else if (f_chitraB2 && m_mrigaA2) {
            m_guna.setText("11.18");
        }else if (f_chitraB2 && m_mrigaB2) {
            m_guna.setText("13");
        }else if (f_chitraB2 && m_aadra) {
            m_guna.setText("20");
        }else if (f_chitraB2 && m_punarvasu3) {
            m_guna.setText("18.18");
        }else if (f_chitraB2 && m_punarvasu1) {
            m_guna.setText("19.18");
        }else if (f_chitraB2 && m_tisya) {
            m_guna.setText("11.18");
        }else if (f_chitraB2 && m_ashlesha) {
            m_guna.setText("25.18");
        }else if (f_chitraB2 && m_magha) {
            m_guna.setText("26");
        }else if (f_chitraB2 && m_pufa) {
            m_guna.setText("12");
        }else if (f_chitraB2 && m_ufa1) {
            m_guna.setText("18");
        }else if (f_chitraB2 && m_ufa3) {
            m_guna.setText("17.18");
        }else if (f_chitraB2 && m_hasta) {
            m_guna.setText("20");
        }else if (f_chitraB2 && m_chitraA2) {
            m_guna.setText("21");
        }else if (f_chitraB2 && m_chitraB2) {
            m_guna.setText("28");
        }else if (f_chitraB2 && m_swati) {
            m_guna.setText("27");
        }else if (f_chitraB2 && m_vishakha3) {
            m_guna.setText("34.18");
        }else if (f_chitraB2 && m_vishakha1) {
            m_guna.setText("24.18");
        }else if (f_chitraB2 && m_anuradha) {
            m_guna.setText("8.18");
        }else if (f_chitraB2 && m_jestha) {
            m_guna.setText("22");
        }else if (f_chitraB2 && m_mula) {
            m_guna.setText("27");
        }else if (f_chitraB2 && m_pusha1) {
            m_guna.setText("13");
        }else if (f_chitraB2 && m_pusha3) {
            m_guna.setText("11.18");
        }else if (f_chitraB2 && m_usha1) {
            m_guna.setText("22");
        }else if (f_chitraB2 && m_usha3) {
            m_guna.setText("25");
        }else if (f_chitraB2 && m_shravana) {
            m_guna.setText("26.09");
        }else if (f_chitraB2 && m_dhanisthaA2) {
            m_guna.setText("24.18");
        }else if (f_chitraB2 && m_dhanisthaB2) {
            m_guna.setText("19");
        }else if (f_chitraB2 && m_shatavisha) {
            m_guna.setText("26");
        }else if (f_chitraB2 && m_pubha3) {
            m_guna.setText("19.18");
        }else if (f_chitraB2 && m_pubha1) {
            m_guna.setText("13.18");
        }else if (f_chitraB2 && m_ubha) {
            m_guna.setText("3.18");
        }else if (f_chitraB2 && m_revati) {
            m_guna.setText("13.18");
        }
    }
    public void fSwatiToFALL(){

        if (f_swati && m_aswini){
            m_guna.setText("28");
        }else if (f_swati && m_bharani) {
            m_guna.setText("29");
        }else if (f_swati && m_kritika1) {
            m_guna.setText("17");
        }else if (f_swati && m_kritika3) {
            m_guna.setText("12");
        }else if (f_swati && m_rohini) {
            m_guna.setText("15");
        }else if (f_swati && m_mrigaA2) {
            m_guna.setText("25.18");
        }else if (f_swati && m_mrigaB2) {
            m_guna.setText("27");
        }else if (f_swati && m_aadra) {
            m_guna.setText("26");
        }else if (f_swati && m_punarvasu3) {
            m_guna.setText("27");
        }else if (f_swati && m_punarvasu1) {
            m_guna.setText("28");
        }else if (f_swati && m_tisya) {
            m_guna.setText("27.18");
        }else if (f_swati && m_ashlesha) {
            m_guna.setText("13.18");
        }else if (f_swati && m_magha) {
            m_guna.setText("13");
        }else if (f_swati && m_pufa) {
            m_guna.setText("25");
        }else if (f_swati && m_ufa1) {
            m_guna.setText("26");
        }else if (f_swati && m_ufa3) {
            m_guna.setText("26.18");
        }else if (f_swati && m_hasta) {
            m_guna.setText("27.18");
        }else if (f_swati && m_chitraA2) {
            m_guna.setText("21");
        }else if (f_swati && m_chitraB2) {
            m_guna.setText("28");
        }else if (f_swati && m_swati) {
            m_guna.setText("28");
        }else if (f_swati && m_vishakha3) {
            m_guna.setText("20");
        }else if (f_swati && m_vishakha1) {
            m_guna.setText("10");
        }else if (f_swati && m_anuradha) {
            m_guna.setText("22");
        }else if (f_swati && m_jestha) {
            m_guna.setText("17");
        }else if (f_swati && m_mula) {
            m_guna.setText("23");
        }else if (f_swati && m_pusha1) {
            m_guna.setText("27");
        }else if (f_swati && m_pusha3) {
            m_guna.setText("25.18");
        }else if (f_swati && m_usha1) {
            m_guna.setText("19");
        }else if (f_swati && m_usha3) {
            m_guna.setText("22");
        }else if (f_swati && m_shravana) {
            m_guna.setText("23.27");
        }else if (f_swati && m_dhanisthaA2) {
            m_guna.setText("28.18");
        }else if (f_swati && m_dhanisthaB2) {
            m_guna.setText("23");
        }else if (f_swati && m_shatavisha) {
            m_guna.setText("21");
        }else if (f_swati && m_pubha3) {
            m_guna.setText("27");
        }else if (f_swati && m_pubha1) {
            m_guna.setText("21");
        }else if (f_swati && m_ubha) {
            m_guna.setText("29.18");
        }else if (f_swati && m_revati) {
            m_guna.setText("12.18");
        }
    }
    public void fBishakha3ToFALL(){

        if (f_vishakha3 && m_aswini){
            m_guna.setText("22");
        }else if (f_vishakha3 && m_bharani) {
            m_guna.setText("23");
        }else if (f_vishakha3 && m_kritika1) {
            m_guna.setText("20");
        }else if (f_vishakha3 && m_kritika3) {
            m_guna.setText("15");
        }else if (f_vishakha3 && m_rohini) {
            m_guna.setText("10");
        }else if (f_vishakha3 && m_mrigaA2) {
            m_guna.setText("18");
        }else if (f_vishakha3 && m_mrigaB2) {
            m_guna.setText("19");
        }else if (f_vishakha3 && m_aadra) {
            m_guna.setText("20");
        }else if (f_vishakha3 && m_punarvasu3) {
            m_guna.setText("20");
        }else if (f_vishakha3 && m_punarvasu1) {
            m_guna.setText("21");
        }else if (f_vishakha3 && m_tisya) {
            m_guna.setText("21");
        }else if (f_vishakha3 && m_ashlesha) {
            m_guna.setText("17.18");
        }else if (f_vishakha3 && m_magha) {
            m_guna.setText("18");
        }else if (f_vishakha3 && m_pufa) {
            m_guna.setText("20");
        }else if (f_vishakha3 && m_ufa1) {
            m_guna.setText("18");
        }else if (f_vishakha3 && m_ufa3) {
            m_guna.setText("17.18");
        }else if (f_vishakha3 && m_hasta) {
            m_guna.setText("18.18");
        }else if (f_vishakha3 && m_chitraA2) {
            m_guna.setText("27.18");
        }else if (f_vishakha3 && m_chitraB2) {
            m_guna.setText("34.18");
        }else if (f_vishakha3 && m_swati) {
            m_guna.setText("19");
        }else if (f_vishakha3 && m_vishakha3) {
            m_guna.setText("28");
        }else if (f_vishakha3 && m_vishakha1) {
            m_guna.setText("18");
        }else if (f_vishakha3 && m_anuradha) {
            m_guna.setText("18");
        }else if (f_vishakha3 && m_jestha) {
            m_guna.setText("22.18");
        }else if (f_vishakha3 && m_mula) {
            m_guna.setText("27");
        }else if (f_vishakha3 && m_pusha1) {
            m_guna.setText("21");
        }else if (f_vishakha3 && m_pusha3) {
            m_guna.setText("19.18");
        }else if (f_vishakha3 && m_usha1) {
            m_guna.setText("14");
        }else if (f_vishakha3 && m_usha3) {
            m_guna.setText("17");
        }else if (f_vishakha3 && m_shravana) {
            m_guna.setText("17.09");
        }else if (f_vishakha3 && m_dhanisthaA2) {
            m_guna.setText("31");
        }else if (f_vishakha3 && m_dhanisthaB2) {
            m_guna.setText("25.18");
        }else if (f_vishakha3 && m_shatavisha) {
            m_guna.setText("26");
        }else if (f_vishakha3 && m_pubha3) {
            m_guna.setText("21");
        }else if (f_vishakha3 && m_pubha1) {
            m_guna.setText("15");
        }else if (f_vishakha3 && m_ubha) {
            m_guna.setText("13");
        }else if (f_vishakha3 && m_revati) {
            m_guna.setText("5");
        }
    }
    public void fBishakha1ToFALL(){

        if (f_vishakha1 && m_aswini){
            m_guna.setText("17.18");
        }else if (f_vishakha1 && m_bharani) {
            m_guna.setText("18.18");
        }else if (f_vishakha1 && m_kritika1) {
            m_guna.setText("15.18");
        }else if (f_vishakha1 && m_kritika3) {
            m_guna.setText("20.18");
        }else if (f_vishakha1 && m_rohini) {
            m_guna.setText("15.18");
        }else if (f_vishakha1 && m_mrigaA2) {
            m_guna.setText("23.18");
        }else if (f_vishakha1 && m_mrigaB2) {
            m_guna.setText("13");
        }else if (f_vishakha1 && m_aadra) {
            m_guna.setText("13.18");
        }else if (f_vishakha1 && m_punarvasu3) {
            m_guna.setText("13.18");
        }else if (f_vishakha1 && m_punarvasu1) {
            m_guna.setText("19");
        }else if (f_vishakha1 && m_tisya) {
            m_guna.setText("19");
        }else if (f_vishakha1 && m_ashlesha) {
            m_guna.setText("15.18");
        }else if (f_vishakha1 && m_magha) {
            m_guna.setText("23.18");
        }else if (f_vishakha1 && m_pufa) {
            m_guna.setText("25.18");
        }else if (f_vishakha1 && m_ufa1) {
            m_guna.setText("23.18");
        }else if (f_vishakha1 && m_vishakha1) {
            m_guna.setText("18");
        }else if (f_vishakha1 && m_hasta) {
            m_guna.setText("19");
        }else if (f_vishakha1 && m_chitraA2) {
            m_guna.setText("28");
        }else if (f_vishakha1 && m_chitraB2) {
            m_guna.setText("23.18");
        }else if (f_vishakha1 && m_swati) {
            m_guna.setText("8");
        }else if (f_vishakha1 && m_vishakha3) {
            m_guna.setText("17");
        }else if (f_vishakha1 && m_vishakha1) {
            m_guna.setText("28");
        }else if (f_vishakha1 && m_anuradha) {
            m_guna.setText("28");
        }else if (f_vishakha1 && m_jestha) {
            m_guna.setText("32.18");
        }else if (f_vishakha1 && m_mula) {
            m_guna.setText("22.18");
        }else if (f_vishakha1 && m_pusha1) {
            m_guna.setText("16.18");
        }else if (f_vishakha1 && m_pusha3) {
            m_guna.setText("17.18");
        }else if (f_vishakha1 && m_usha1) {
            m_guna.setText("9.18");
        }else if (f_vishakha1 && m_usha3) {
            m_guna.setText("13");
        }else if (f_vishakha1 && m_shravana) {
            m_guna.setText("11.18");
        }else if (f_vishakha1 && m_dhanisthaA2) {
            m_guna.setText("27");
        }else if (f_vishakha1 && m_dhanisthaB2) {
            m_guna.setText("26");
        }else if (f_vishakha1 && m_shatavisha) {
            m_guna.setText("26.18");
        }else if (f_vishakha1 && m_pubha3) {
            m_guna.setText("21.18");
        }else if (f_vishakha1 && m_pubha1) {
            m_guna.setText("21");
        }else if (f_vishakha1 && m_ubha) {
            m_guna.setText("19");
        }else if (f_vishakha1 && m_revati) {
            m_guna.setText("11.18");
        }
    }
    public void fAnuradhaToFALL(){

        if (f_anuradha && m_aswini){
            m_guna.setText("25.18");
        }else if (f_anuradha && m_bharani) {
            m_guna.setText("15.18");
        }else if (f_anuradha && m_kritika1) {
            m_guna.setText("20.18");
        }else if (f_anuradha && m_kritika3) {
            m_guna.setText("25.18");
        }else if (f_anuradha && m_rohini) {
            m_guna.setText("28.18");
        }else if (f_anuradha && m_mrigaA2) {
            m_guna.setText("21.18");
        }else if (f_anuradha && m_mrigaB2) {
            m_guna.setText("11");
        }else if (f_anuradha && m_aadra) {
            m_guna.setText("16");
        }else if (f_anuradha && m_punarvasu3) {
            m_guna.setText("20.18");
        }else if (f_anuradha && m_punarvasu1) {
            m_guna.setText("26");
        }else if (f_anuradha && m_tisya) {
            m_guna.setText("19");
        }else if (f_anuradha && m_ashlesha) {
            m_guna.setText("21");
        }else if (f_anuradha && m_magha) {
            m_guna.setText("26.18");
        }else if (f_anuradha && m_pufa) {
            m_guna.setText("22.18");
        }else if (f_anuradha && m_ufa1) {
            m_guna.setText("31.18");
        }else if (f_anuradha && m_vishakha1) {
            m_guna.setText("26");
        }else if (f_anuradha && m_hasta) {
            m_guna.setText("26");
        }else if (f_anuradha && m_chitraA2) {
            m_guna.setText("12");
        }else if (f_anuradha && m_chitraB2) {
            m_guna.setText("7.18");
        }else if (f_anuradha && m_swati) {
            m_guna.setText("21.18");
        }else if (f_anuradha && m_vishakha3) {
            m_guna.setText("17.18");
        }else if (f_anuradha && m_vishakha1) {
            m_guna.setText("28");
        }else if (f_anuradha && m_anuradha) {
            m_guna.setText("28");
        }else if (f_anuradha && m_jestha) {
            m_guna.setText("21");
        }else if (f_anuradha && m_mula) {
            m_guna.setText("16.18");
        }else if (f_anuradha && m_pusha1) {
            m_guna.setText("14.18");
        }else if (f_anuradha && m_pusha3) {
            m_guna.setText("15.18");
        }else if (f_anuradha && m_usha1) {
            m_guna.setText("22.18");
        }else if (f_anuradha && m_usha3) {
            m_guna.setText("26");
        }else if (f_anuradha && m_shravana) {
            m_guna.setText("26.18");
        }else if (f_anuradha && m_dhanisthaA2) {
            m_guna.setText("14");
        }else if (f_anuradha && m_dhanisthaB2) {
            m_guna.setText("13");
        }else if (f_anuradha && m_shatavisha) {
            m_guna.setText("22");
        }else if (f_anuradha && m_pubha3) {
            m_guna.setText("26.18");
        }else if (f_anuradha && m_pubha1) {
            m_guna.setText("26");
        }else if (f_anuradha && m_ubha) {
            m_guna.setText("19");
        }else if (f_anuradha && m_revati) {
            m_guna.setText("27");
        }
    }
    public void fJesthaToFALL(){

        if (f_jestha && m_aswini){
            m_guna.setText("13");
        }else if (f_jestha && m_bharani) {
            m_guna.setText("18.18");
        }else if (f_jestha && m_kritika1) {
            m_guna.setText("25.18");
        }else if (f_jestha && m_kritika3) {
            m_guna.setText("30.18");
        }else if (f_jestha && m_rohini) {
            m_guna.setText("23.18");
        }else if (f_jestha && m_mrigaA2) {
            m_guna.setText("23.18");
        }else if (f_jestha && m_mrigaB2) {
            m_guna.setText("13");
        }else if (f_jestha && m_aadra) {
            m_guna.setText("3");
        }else if (f_jestha && m_punarvasu3) {
            m_guna.setText("5");
        }else if (f_jestha && m_punarvasu1) {
            m_guna.setText("10.18");
        }else if (f_jestha && m_tisya) {
            m_guna.setText("21");
        }else if (f_jestha && m_ashlesha) {
            m_guna.setText("26");
        }else if (f_jestha && m_magha) {
            m_guna.setText("33");
        }else if (f_jestha && m_pufa) {
            m_guna.setText("25.18");
        }else if (f_jestha && m_ufa1) {
            m_guna.setText("18.18");
        }else if (f_jestha && m_ufa3) {
            m_guna.setText("13");
        }else if (f_jestha && m_hasta) {
            m_guna.setText("12");
        }else if (f_jestha && m_chitraA2) {
            m_guna.setText("25");
        }else if (f_jestha && m_chitraB2) {
            m_guna.setText("20.18");
        }else if (f_jestha && m_swati) {
            m_guna.setText("15.18");
        }else if (f_jestha && m_vishakha3) {
            m_guna.setText("20.18");
        }else if (f_jestha && m_vishakha1) {
            m_guna.setText("31.18");
        }else if (f_jestha && m_anuradha) {
            m_guna.setText("30");
        }else if (f_jestha && m_jestha) {
            m_guna.setText("28");
        }else if (f_jestha && m_mula) {
            m_guna.setText("15");
        }else if (f_jestha && m_pusha1) {
            m_guna.setText("17.18");
        }else if (f_jestha && m_pusha3) {
            m_guna.setText("18.18");
        }else if (f_jestha && m_usha1) {
            m_guna.setText("17.18");
        }else if (f_jestha && m_usha3) {
            m_guna.setText("21");
        }else if (f_jestha && m_shravana) {
            m_guna.setText("20.18");
        }else if (f_jestha && m_dhanisthaA2) {
            m_guna.setText("27");
        }else if (f_jestha && m_dhanisthaB2) {
            m_guna.setText("26");
        }else if (f_jestha && m_shatavisha) {
            m_guna.setText("19");
        }else if (f_jestha && m_pubha3) {
            m_guna.setText("12");
        }else if (f_jestha && m_pubha1) {
            m_guna.setText("11.18");
        }else if (f_jestha && m_ubha) {
            m_guna.setText("22");
        }else if (f_jestha && m_revati) {
            m_guna.setText("21");
        }
    }
    public void fMulaToFALL(){

        if (f_mula && m_aswini){
            m_guna.setText("11.18");
        }else if (f_mula && m_bharani) {
            m_guna.setText("19.18");
        }else if (f_mula && m_kritika1) {
            m_guna.setText("24");
        }else if (f_mula && m_kritika3) {
            m_guna.setText("19.18");
        }else if (f_mula && m_rohini) {
            m_guna.setText("12.18");
        }else if (f_mula && m_mrigaA2) {
            m_guna.setText("12.18");
        }else if (f_mula && m_mrigaB2) {
            m_guna.setText("21");
        }else if (f_mula && m_aadra) {
            m_guna.setText("15");
        }else if (f_mula && m_punarvasu3) {
            m_guna.setText("12");
        }else if (f_mula && m_punarvasu1) {
            m_guna.setText("8");
        }else if (f_mula && m_tisya) {
            m_guna.setText("17");
        }else if (f_mula && m_ashlesha) {
            m_guna.setText("23.18");
        }else if (f_mula && m_magha) {
            m_guna.setText("24.18");
        }else if (f_mula && m_pufa) {
            m_guna.setText("18.18");
        }else if (f_mula && m_ufa1) {
            m_guna.setText("10");
        }else if (f_mula && m_ufa3) {
            m_guna.setText("13");
        }else if (f_mula && m_hasta) {
            m_guna.setText("13");
        }else if (f_mula && m_chitraA2) {
            m_guna.setText("26");
        }else if (f_mula && m_chitraB2) {
            m_guna.setText("26");
        }else if (f_mula && m_swati) {
            m_guna.setText("21");
        }else if (f_mula && m_vishakha3) {
            m_guna.setText("26");
        }else if (f_mula && m_vishakha1) {
            m_guna.setText("23.18");
        }else if (f_mula && m_anuradha) {
            m_guna.setText("16.18");
        }else if (f_mula && m_jestha) {
            m_guna.setText("16");
        }else if (f_mula && m_mula) {
            m_guna.setText("28");
        }else if (f_mula && m_pusha1) {
            m_guna.setText("28");
        }else if (f_mula && m_pusha3) {
            m_guna.setText("26.18");
        }else if (f_mula && m_usha1) {
            m_guna.setText("26.18");
        }else if (f_mula && m_usha3) {
            m_guna.setText("15");
        }else if (f_mula && m_shravana) {
            m_guna.setText("16");
        }else if (f_mula && m_dhanisthaA2) {
            m_guna.setText("20.18");
        }else if (f_mula && m_dhanisthaB2) {
            m_guna.setText("28.18");
        }else if (f_mula && m_shatavisha) {
            m_guna.setText("21.18");
        }else if (f_mula && m_pubha3) {
            m_guna.setText("14.18");
        }else if (f_mula && m_pubha1) {
            m_guna.setText("16");
        }else if (f_mula && m_ubha) {
            m_guna.setText("25");
        }else if (f_mula && m_revati) {
            m_guna.setText("26.18");
        }
    }
    public void fPusha1ToFALL(){

        if (f_pusha1 && m_aswini){
            m_guna.setText("25.18");
        }else if (f_pusha1 && m_bharani) {
            m_guna.setText("18.18");
        }else if (f_pusha1 && m_kritika1) {
            m_guna.setText("17.18");
        }else if (f_pusha1 && m_kritika3) {
            m_guna.setText("12");
        }else if (f_pusha1 && m_rohini) {
            m_guna.setText("18.18");
        }else if (f_pusha1 && m_mrigaA2) {
            m_guna.setText("10.18");
        }else if (f_pusha1 && m_mrigaB2) {
            m_guna.setText("19");
        }else if (f_pusha1 && m_aadra) {
            m_guna.setText("27");
        }else if (f_pusha1 && m_punarvasu3) {
            m_guna.setText("27");
        }else if (f_pusha1 && m_punarvasu1) {
            m_guna.setText("23");
        }else if (f_pusha1 && m_tisya) {
            m_guna.setText("13");
        }else if (f_pusha1 && m_ashlesha) {
            m_guna.setText("17");
        }else if (f_pusha1 && m_magha) {
            m_guna.setText("19.19");
        }else if (f_pusha1 && m_pufa) {
            m_guna.setText("17.18");
        }else if (f_pusha1 && m_ufa1) {
            m_guna.setText("25.18");
        }else if (f_pusha1 && m_ufa3) {
            m_guna.setText("18.18");
        }else if (f_pusha1 && m_hasta) {
            m_guna.setText("27");
        }else if (f_pusha1 && m_chitraA2) {
            m_guna.setText("12");
        }else if (f_pusha1 && m_chitraB2) {
            m_guna.setText("12");
        }else if (f_pusha1 && m_swati) {
            m_guna.setText("27");
        }else if (f_pusha1 && m_vishakha3) {
            m_guna.setText("20");
        }else if (f_pusha1 && m_vishakha1) {
            m_guna.setText("17.18");
        }else if (f_pusha1 && m_anuradha) {
            m_guna.setText("16.18");
        }else if (f_pusha1 && m_jestha) {
            m_guna.setText("18.18");
        }else if (f_pusha1 && m_mula) {
            m_guna.setText("28");
        }else if (f_pusha1 && m_pusha1) {
            m_guna.setText("28");
        }else if (f_pusha1 && m_pusha3) {
            m_guna.setText("26.18");
        }else if (f_pusha1 && m_usha1) {
            m_guna.setText("34");
        }else if (f_pusha1 && m_usha3) {
            m_guna.setText("22.18");
        }else if (f_pusha1 && m_shravana) {
            m_guna.setText("23.27");
        }else if (f_pusha1 && m_dhanisthaA2) {
            m_guna.setText("8");
        }else if (f_pusha1 && m_dhanisthaB2) {
            m_guna.setText("16.18");
        }else if (f_pusha1 && m_shatavisha) {
            m_guna.setText("23.18");
        }else if (f_pusha1 && m_pubha3) {
            m_guna.setText("30.18");
        }else if (f_pusha1 && m_pubha1) {
            m_guna.setText("32");
        }else if (f_pusha1 && m_ubha) {
            m_guna.setText("23");
        }else if (f_pusha1 && m_revati) {
            m_guna.setText("32");
        }
    }
    public void fPusha3ToFALL(){

        if (f_pusha3 && m_aswini){
            m_guna.setText("27");
        }else if (f_pusha3 && m_bharani) {
            m_guna.setText("20");
        }else if (f_pusha3 && m_kritika1) {
            m_guna.setText("19");
        }else if (f_pusha3 && m_kritika3) {
            m_guna.setText("13.18");
        }else if (f_pusha3 && m_rohini) {
            m_guna.setText("20");
        }else if (f_pusha3 && m_mrigaA2) {
            m_guna.setText("12");
        }else if (f_pusha3 && m_mrigaB2) {
            m_guna.setText("17.18");
        }else if (f_pusha3 && m_aadra) {
            m_guna.setText("25.18");
        }else if (f_pusha3 && m_punarvasu3) {
            m_guna.setText("25.18");
        }else if (f_pusha3 && m_punarvasu1) {
            m_guna.setText("24.18");
        }else if (f_pusha3 && m_tisya) {
            m_guna.setText("14.18");
        }else if (f_pusha3 && m_ashlesha) {
            m_guna.setText("18.18");
        }else if (f_pusha3 && m_magha) {
            m_guna.setText("21.18");
        }else if (f_pusha3 && m_pufa) {
            m_guna.setText("19");
        }else if (f_pusha3 && m_ufa1) {
            m_guna.setText("27");
        }else if (f_pusha3 && m_ufa3) {
            m_guna.setText("27");
        }else if (f_pusha3 && m_hasta) {
            m_guna.setText("25.18");
        }else if (f_pusha3 && m_chitraA2) {
            m_guna.setText("10.18");
        }else if (f_pusha3 && m_chitraB2) {
            m_guna.setText("10.18");
        }else if (f_pusha3 && m_swati) {
            m_guna.setText("25.18");
        }else if (f_pusha3 && m_vishakha3) {
            m_guna.setText("18.18");
        }else if (f_pusha3 && m_vishakha1) {
            m_guna.setText("19.18");
        }else if (f_pusha3 && m_anuradha) {
            m_guna.setText("17.18");
        }else if (f_pusha3 && m_jestha) {
            m_guna.setText("19.18");
        }else if (f_pusha3 && m_mula) {
            m_guna.setText("26.18");
        }else if (f_pusha3 && m_pusha1) {
            m_guna.setText("26.18");
        }else if (f_pusha3 && m_pusha3) {
            m_guna.setText("28");
        }else if (f_pusha3 && m_usha1) {
            m_guna.setText("32.18");
        }else if (f_pusha3 && m_usha3) {
            m_guna.setText("24");
        }else if (f_pusha3 && m_shravana) {
            m_guna.setText("24.27");
        }else if (f_pusha3 && m_dhanisthaA2) {
            m_guna.setText("9.18");
        }else if (f_pusha3 && m_dhanisthaB2) {
            m_guna.setText("15.18");
        }else if (f_pusha3 && m_shatavisha) {
            m_guna.setText("22.18");
        }else if (f_pusha3 && m_pubha3) {
            m_guna.setText("29.18");
        }else if (f_pusha3 && m_pubha1) {
            m_guna.setText("33.18");
        }else if (f_pusha3 && m_ubha) {
            m_guna.setText("24.18");
        }else if (f_pusha3 && m_revati) {
            m_guna.setText("33.18");
        }
    }
    public void fUsha1ToFALL(){

        if (f_usha1 && m_aswini){
            m_guna.setText("24");
        }else if (f_usha1 && m_bharani) {
            m_guna.setText("25.18");
        }else if (f_usha1 && m_kritika1) {
            m_guna.setText("12.18");
        }else if (f_usha1 && m_kritika3) {
            m_guna.setText("7");
        }else if (f_usha1 && m_rohini) {
            m_guna.setText("10");
        }else if (f_usha1 && m_mrigaA2) {
            m_guna.setText("16.18");
        }else if (f_usha1 && m_mrigaB2) {
            m_guna.setText("25");
        }else if (f_usha1 && m_aadra) {
            m_guna.setText("27");
        }else if (f_usha1 && m_punarvasu3) {
            m_guna.setText("27");
        }else if (f_usha1 && m_punarvasu1) {
            m_guna.setText("23");
        }else if (f_usha1 && m_tisya) {
            m_guna.setText("24");
        }else if (f_usha1 && m_ashlesha) {
            m_guna.setText("9");
        }else if (f_usha1 && m_magha) {
            m_guna.setText("10");
        }else if (f_usha1 && m_pufa) {
            m_guna.setText("25.18");
        }else if (f_usha1 && m_ufa1) {
            m_guna.setText("26.18");
        }else if (f_usha1 && m_ufa3) {
            m_guna.setText("29.18");
        }else if (f_usha1 && m_hasta) {
            m_guna.setText("28.18");
        }else if (f_usha1 && m_chitraA2) {
            m_guna.setText("21");
        }else if (f_usha1 && m_chitraB2) {
            m_guna.setText("21");
        }else if (f_usha1 && m_swati) {
            m_guna.setText("19");
        }else if (f_usha1 && m_vishakha3) {
            m_guna.setText("13");
        }else if (f_usha1 && m_vishakha1) {
            m_guna.setText("10.18");
        }else if (f_usha1 && m_anuradha) {
            m_guna.setText("24.18");
        }else if (f_usha1 && m_jestha) {
            m_guna.setText("18.18");
        }else if (f_usha1 && m_mula) {
            m_guna.setText("26.18");
        }else if (f_usha1 && m_pusha1) {
            m_guna.setText("36");
        }else if (f_usha1 && m_pusha3) {
            m_guna.setText("34.18");
        }else if (f_usha1 && m_usha1) {
            m_guna.setText("28");
        }else if (f_usha1 && m_usha3) {
            m_guna.setText("16.18");
        }else if (f_usha1 && m_shravana) {
            m_guna.setText("17.09");
        }else if (f_usha1 && m_dhanisthaA2) {
            m_guna.setText("15");
        }else if (f_usha1 && m_dhanisthaB2) {
            m_guna.setText("23.18");
        }else if (f_usha1 && m_shatavisha) {
            m_guna.setText("23.18");
        }else if (f_usha1 && m_pubha3) {
            m_guna.setText("29.18");
        }else if (f_usha1 && m_pubha1) {
            m_guna.setText("31");
        }else if (f_usha1 && m_ubha) {
            m_guna.setText("32");
        }else if (f_usha1 && m_revati) {
            m_guna.setText("23");
        }
    }
    public void fUsha3ToFALL(){

        if (f_usha3 && m_aswini){
            m_guna.setText("28");
        }else if (f_usha3 && m_bharani) {
            m_guna.setText("29.18");
        }else if (f_usha3 && m_kritika1) {
            m_guna.setText("16.18");
        }else if (f_usha3 && m_kritika3) {
            m_guna.setText("14");
        }else if (f_usha3 && m_rohini) {
            m_guna.setText("17");
        }else if (f_usha3 && m_mrigaA2) {
            m_guna.setText("23.18");
        }else if (f_usha3 && m_mrigaB2) {
            m_guna.setText("20");
        }else if (f_usha3 && m_aadra) {
            m_guna.setText("22");
        }else if (f_usha3 && m_punarvasu3) {
            m_guna.setText("22");
        }else if (f_usha3 && m_punarvasu1) {
            m_guna.setText("28");
        }else if (f_usha3 && m_tisya) {
            m_guna.setText("29");
        }else if (f_usha3 && m_ashlesha) {
            m_guna.setText("14");
        }else if (f_usha3 && m_magha) {
            m_guna.setText("6.18");
        }else if (f_usha3 && m_pufa) {
            m_guna.setText("22");
        }else if (f_usha3 && m_ufa1) {
            m_guna.setText("23");
        }else if (f_usha3 && m_ufa3) {
            m_guna.setText("25.18");
        }else if (f_usha3 && m_hasta) {
            m_guna.setText("24.18");
        }else if (f_usha3 && m_chitraA2) {
            m_guna.setText("17");
        }else if (f_usha3 && m_chitraB2) {
            m_guna.setText("24");
        }else if (f_usha3 && m_swati) {
            m_guna.setText("22");
        }else if (f_usha3 && m_vishakha3) {
            m_guna.setText("16");
        }else if (f_usha3 && m_vishakha1) {
            m_guna.setText("14");
        }else if (f_usha3 && m_anuradha) {
            m_guna.setText("28");
        }else if (f_usha3 && m_jestha) {
            m_guna.setText("22");
        }else if (f_usha3 && m_mula) {
            m_guna.setText("16");
        }else if (f_usha3 && m_pusha1) {
            m_guna.setText("25.18");
        }else if (f_usha3 && m_pusha3) {
            m_guna.setText("27");
        }else if (f_usha3 && m_usha1) {
            m_guna.setText("17.18");
        }else if (f_usha3 && m_usha3) {
            m_guna.setText("28");
        }else if (f_usha3 && m_shravana) {
            m_guna.setText("27.09");
        }else if (f_usha3 && m_dhanisthaA2) {
            m_guna.setText("26.18");
        }else if (f_usha3 && m_dhanisthaB2) {
            m_guna.setText("17");
        }else if (f_usha3 && m_shatavisha) {
            m_guna.setText("17");
        }else if (f_usha3 && m_pubha3) {
            m_guna.setText("23");
        }else if (f_usha3 && m_pubha1) {
            m_guna.setText("30.18");
        }else if (f_usha3 && m_ubha) {
            m_guna.setText("31.18");
        }else if (f_usha3 && m_revati) {
            m_guna.setText("22.18");
        }
    }
    public void fShravanaToFALL(){

        if (f_shravana && m_aswini){
            m_guna.setText("27.27");
        }else if (f_shravana && m_bharani) {
            m_guna.setText("27.27");
        }else if (f_shravana && m_kritika1) {
            m_guna.setText("13.27");
        }else if (f_shravana && m_kritika3) {
            m_guna.setText("11.09");
        }else if (f_shravana && m_rohini) {
            m_guna.setText("17.09");
        }else if (f_shravana && m_mrigaA2) {
            m_guna.setText("26.09");
        }else if (f_shravana && m_mrigaB2) {
            m_guna.setText("24.09");
        }else if (f_shravana && m_aadra) {
            m_guna.setText("21.27");
        }else if (f_shravana && m_punarvasu3) {
            m_guna.setText("22.27");
        }else if (f_shravana && m_punarvasu1) {
            m_guna.setText("27.09");
        }else if (f_shravana && m_tisya) {
            m_guna.setText("25.09");
        }else if (f_shravana && m_ashlesha) {
            m_guna.setText("14.09");
        }else if (f_shravana && m_magha) {
            m_guna.setText("6.27");
        }else if (f_shravana && m_pufa) {
            m_guna.setText("18.27");
        }else if (f_shravana && m_ufa1) {
            m_guna.setText("20.09");
        }else if (f_shravana && m_ufa3) {
            m_guna.setText("24.09");
        }else if (f_shravana && m_hasta) {
            m_guna.setText("25.09");
        }else if (f_shravana && m_chitraA2) {
            m_guna.setText("19.09");
        }else if (f_shravana && m_chitraB2) {
            m_guna.setText("26.09");
        }else if (f_shravana && m_swati) {
            m_guna.setText("22.27");
        }else if (f_shravana && m_vishakha3) {
            m_guna.setText("16.27");
        }else if (f_shravana && m_vishakha1) {
            m_guna.setText("13.18");
        }else if (f_shravana && m_anuradha) {
            m_guna.setText("27.18");
        }else if (f_shravana && m_jestha) {
            m_guna.setText("22.18");
        }else if (f_shravana && m_mula) {
            m_guna.setText("17.27");
        }else if (f_shravana && m_pusha1) {
            m_guna.setText("23.27");
        }else if (f_shravana && m_pusha3) {
            m_guna.setText("23.27");
        }else if (f_shravana && m_usha1) {
            m_guna.setText("15.09");
        }else if (f_shravana && f_usha3) {
            m_guna.setText("24.09");
        }else if (f_shravana && m_shravana) {
            m_guna.setText("27.09");
        }else if (f_shravana && m_dhanisthaA2) {
            m_guna.setText("29.09");
        }else if (f_shravana && m_dhanisthaB2) {
            m_guna.setText("21.09");
        }else if (f_shravana && m_shatavisha) {
            m_guna.setText("18.27");
        }else if (f_shravana && m_pubha3) {
            m_guna.setText("23.27");
        }else if (f_shravana && m_pubha1) {
            m_guna.setText("29.27");
        }else if (f_shravana && m_ubha) {
            m_guna.setText("28.27");
        }else if (f_shravana && m_revati) {
            m_guna.setText("22.27");
        }
    }
    public void fDhanistaA2ToFALL(){

        if (f_dhanisthaA2 && m_aswini){
            m_guna.setText("21");
        }else if (f_dhanisthaA2 && m_bharani) {
            m_guna.setText("12");
        }else if (f_dhanisthaA2 && m_kritika1) {
            m_guna.setText("27");
        }else if (f_dhanisthaA2 && m_kritika3) {
            m_guna.setText("24.18");
        }else if (f_dhanisthaA2 && m_rohini) {
            m_guna.setText("21");
        }else if (f_dhanisthaA2 && m_mrigaA2) {
            m_guna.setText("13");
        }else if (f_dhanisthaA2 && m_mrigaB2) {
            m_guna.setText("9.18");
        }else if (f_dhanisthaA2 && m_aadra) {
            m_guna.setText("16.18");
        }else if (f_dhanisthaA2 && m_punarvasu3) {
            m_guna.setText("16");
        }else if (f_dhanisthaA2 && m_punarvasu1) {
            m_guna.setText("22");
        }else if (f_dhanisthaA2 && m_tisya) {
            m_guna.setText("13");
        }else if (f_dhanisthaA2 && m_ashlesha) {
            m_guna.setText("28");
        }else if (f_dhanisthaA2 && m_magha) {
            m_guna.setText("19.18");
        }else if (f_dhanisthaA2 && m_pufa) {
            m_guna.setText("5.18");
        }else if (f_dhanisthaA2 && m_ufa1) {
            m_guna.setText("13.18");
        }else if (f_dhanisthaA2 && m_ufa3) {
            m_guna.setText("16");
        }else if (f_dhanisthaA2 && m_hasta) {
            m_guna.setText("19.18");
        }else if (f_dhanisthaA2 && m_chitraA2) {
            m_guna.setText("16.18");
        }else if (f_dhanisthaA2 && m_chitraB2) {
            m_guna.setText("23.18");
        }else if (f_dhanisthaA2 && m_swati) {
            m_guna.setText("26.18");
        }else if (f_dhanisthaA2 && m_vishakha3) {
            m_guna.setText("30");
        }else if (f_dhanisthaA2 && m_vishakha1) {
            m_guna.setText("28");
        }else if (f_dhanisthaA2 && m_anuradha) {
            m_guna.setText("14");
        }else if (f_dhanisthaA2 && m_jestha) {
            m_guna.setText("21");
        }else if (f_dhanisthaA2 && m_mula) {
            m_guna.setText("8");
        }else if (f_dhanisthaA2 && m_pusha1) {
            m_guna.setText("9.18");
        }else if (f_dhanisthaA2 && m_pusha3) {
            m_guna.setText("27.18");
        }else if (f_dhanisthaA2 && m_usha1) {
            m_guna.setText("16");
        }else if (f_dhanisthaA2 && m_usha3) {
            m_guna.setText("26.18");
        }else if (f_dhanisthaA2 && m_shravana) {
            m_guna.setText("27.09");
        }else if (f_dhanisthaA2 && m_dhanisthaA2) {
            m_guna.setText("28");
        }else if (f_dhanisthaA2 && m_dhanisthaB2) {
            m_guna.setText("18.18");
        }else if (f_dhanisthaA2 && m_shatavisha) {
            m_guna.setText("23.18");
        }else if (f_dhanisthaA2 && m_pubha3) {
            m_guna.setText("19");
        }else if (f_dhanisthaA2 && m_pubha1) {
            m_guna.setText("26.18");
        }else if (f_dhanisthaA2 && m_ubha) {
            m_guna.setText("15.18");
        }else if (f_dhanisthaA2 && m_revati) {
            m_guna.setText("22.18");
        }
    }
    public void fDhanistaB2ToFALL(){

        if (f_dhanisthaB2 && m_aswini){
            m_guna.setText("19.18");
        }else if (f_dhanisthaB2 && m_bharani) {
            m_guna.setText("10.18");
        }else if (f_dhanisthaB2 && m_kritika1) {
            m_guna.setText("25.18");
        }else if (f_dhanisthaB2 && m_kritika3) {
            m_guna.setText("30");
        }else if (f_dhanisthaB2 && m_rohini) {
            m_guna.setText("26.18");
        }else if (f_dhanisthaB2 && m_mrigaA2) {
            m_guna.setText("18.18");
        }else if (f_dhanisthaB2 && m_mrigaB2) {
            m_guna.setText("12");
        }else if (f_dhanisthaB2 && m_aadra) {
            m_guna.setText("19");
        }else if (f_dhanisthaB2 && m_punarvasu3) {
            m_guna.setText("18.18");
        }else if (f_dhanisthaB2 && m_punarvasu1) {
            m_guna.setText("13.18");
        }else if (f_dhanisthaB2 && m_tisya) {
            m_guna.setText("4.18");
        }else if (f_dhanisthaB2 && m_ashlesha) {
            m_guna.setText("19.18");
        }else if (f_dhanisthaB2 && m_magha) {
            m_guna.setText("25");
        }else if (f_dhanisthaB2 && m_pufa) {
            m_guna.setText("11");
        }else if (f_dhanisthaB2 && m_ufa1) {
            m_guna.setText("19");
        }else if (f_dhanisthaB2 && m_ufa3) {
            m_guna.setText("17.18");
        }else if (f_dhanisthaB2 && m_hasta) {
            m_guna.setText("21");
        }else if (f_dhanisthaB2 && m_chitraA2) {
            m_guna.setText("18");
        }else if (f_dhanisthaB2 && m_chitraB2) {
            m_guna.setText("19");
        }else if (f_dhanisthaB2 && m_swati) {
            m_guna.setText("22");
        }else if (f_dhanisthaB2 && m_vishakha3) {
            m_guna.setText("25.18");
        }else if (f_dhanisthaB2 && m_vishakha1) {
            m_guna.setText("27");
        }else if (f_dhanisthaB2 && m_anuradha) {
            m_guna.setText("13");
        }else if (f_dhanisthaB2 && m_jestha) {
            m_guna.setText("27");
        }else if (f_dhanisthaB2 && m_mula) {
            m_guna.setText("29.18");
        }else if (f_dhanisthaB2 && m_pusha1) {
            m_guna.setText("16.18");
        }else if (f_dhanisthaB2 && m_pusha3) {
            m_guna.setText("15");
        }else if (f_dhanisthaB2 && m_usha1) {
            m_guna.setText("24.18");
        }else if (f_dhanisthaB2 && m_usha3) {
            m_guna.setText("18");
        }else if (f_dhanisthaB2 && m_shravana) {
            m_guna.setText("20.09");
        }else if (f_dhanisthaB2 && m_dhanisthaA2) {
            m_guna.setText("19.18");
        }else if (f_dhanisthaB2 && m_dhanisthaB2) {
            m_guna.setText("28");
        }else if (f_dhanisthaB2 && m_shatavisha) {
            m_guna.setText("33");
        }else if (f_dhanisthaB2 && m_pubha3) {
            m_guna.setText("28.18");
        }else if (f_dhanisthaB2 && m_pubha1) {
            m_guna.setText("18");
        }else if (f_dhanisthaB2 && m_ubha) {
            m_guna.setText("7");
        }else if (f_dhanisthaB2 && m_revati) {
            m_guna.setText("14");
        }
    }
    public void fShatavishaToFALL(){

        if (f_shatavisha && m_aswini){
            m_guna.setText("14.18");
        }else if (f_shatavisha && m_bharani) {
            m_guna.setText("20.18");
        }else if (f_shatavisha && m_kritika1) {
            m_guna.setText("27.18");
        }else if (f_shatavisha && m_kritika3) {
            m_guna.setText("32");
        }else if (f_shatavisha && m_rohini) {
            m_guna.setText("25");
        }else if (f_shatavisha && m_mrigaA2) {
            m_guna.setText("26.18");
        }else if (f_shatavisha && m_mrigaB2) {
            m_guna.setText("20");
        }else if (f_shatavisha && m_aadra) {
            m_guna.setText("12");
        }else if (f_shatavisha && m_punarvasu3) {
            m_guna.setText("13");
        }else if (f_shatavisha && m_punarvasu1) {
            m_guna.setText("8");
        }else if (f_shatavisha && m_tisya) {
            m_guna.setText("14.18");
        }else if (f_shatavisha && m_ashlesha) {
            m_guna.setText("20.18");
        }else if (f_shatavisha && m_magha) {
            m_guna.setText("27");
        }else if (f_shatavisha && m_pufa) {
            m_guna.setText("21");
        }else if (f_shatavisha && m_ufa1) {
            m_guna.setText("13");
        }else if (f_shatavisha && m_ufa3) {
            m_guna.setText("11.18");
        }else if (f_shatavisha && m_hasta) {
            m_guna.setText("9.18");
        }else if (f_shatavisha && m_chitraA2) {
            m_guna.setText("25");
        }else if (f_shatavisha && m_chitraB2) {
            m_guna.setText("26");
        }else if (f_shatavisha && m_swati) {
            m_guna.setText("20");
        }else if (f_shatavisha && m_vishakha3) {
            m_guna.setText("26");
        }else if (f_shatavisha && m_vishakha1) {
            m_guna.setText("27");
        }else if (f_shatavisha && m_anuradha) {
            m_guna.setText("22");
        }else if (f_shatavisha && m_jestha) {
            m_guna.setText("20");
        }else if (f_shatavisha && m_mula) {
            m_guna.setText("22.18");
        }else if (f_shatavisha && m_pusha1) {
            m_guna.setText("24.18");
        }else if (f_shatavisha && m_pusha3) {
            m_guna.setText("23");
        }else if (f_shatavisha && m_usha1) {
            m_guna.setText("24.18");
        }else if (f_shatavisha && m_usha3) {
            m_guna.setText("18");
        }else if (f_shatavisha && m_shravana) {
            m_guna.setText("18.27");
        }else if (f_shatavisha && m_dhanisthaA2) {
            m_guna.setText("24.18");
        }else if (f_shatavisha && m_dhanisthaB2) {
            m_guna.setText("33");
        }else if (f_shatavisha && m_shatavisha) {
            m_guna.setText("28");
        }else if (f_shatavisha && m_pubha3) {
            m_guna.setText("19");
        }else if (f_shatavisha && m_pubha1) {
            m_guna.setText("8.18");
        }else if (f_shatavisha && m_ubha) {
            m_guna.setText("17");
        }else if (f_shatavisha && m_revati) {
            m_guna.setText("16");
        }
    }
    public void fPubha3ToFALL(){

        if (f_pubha3 && m_aswini){
            m_guna.setText("17.18");
        }else if (f_pubha3 && m_bharani) {
            m_guna.setText("24.18");
        }else if (f_pubha3 && m_kritika1) {
            m_guna.setText("19.18");
        }else if (f_pubha3 && m_kritika3) {
            m_guna.setText("24");
        }else if (f_pubha3 && m_rohini) {
            m_guna.setText("31");
        }else if (f_pubha3 && m_mrigaA2) {
            m_guna.setText("31");
        }else if (f_pubha3 && m_mrigaB2) {
            m_guna.setText("24.18");
        }else if (f_pubha3 && m_aadra) {
            m_guna.setText("17");
        }else if (f_pubha3 && m_punarvasu3) {
            m_guna.setText("18");
        }else if (f_pubha3 && m_punarvasu1) {
            m_guna.setText("13");
        }else if (f_pubha3 && m_tisya) {
            m_guna.setText("20");
        }else if (f_pubha3 && m_ashlesha) {
            m_guna.setText("13.18");
        }else if (f_pubha3 && m_magha) {
            m_guna.setText("19");
        }else if (f_pubha3 && m_pufa) {
            m_guna.setText("25");
        }else if (f_pubha3 && m_ufa1) {
            m_guna.setText("17");
        }else if (f_pubha3 && m_ufa3) {
            m_guna.setText("15.18");
        }else if (f_pubha3 && m_hasta) {
            m_guna.setText("17.18");
        }else if (f_pubha3 && m_chitraA2) {
            m_guna.setText("18.18");
        }else if (f_pubha3 && m_chitraB2) {
            m_guna.setText("19.18");
        }else if (f_pubha3 && m_swati) {
            m_guna.setText("28");
        }else if (f_pubha3 && m_vishakha3) {
            m_guna.setText("21");
        }else if (f_pubha3 && m_vishakha1) {
            m_guna.setText("22.18");
        }else if (f_pubha3 && m_anuradha) {
            m_guna.setText("28.18");
        }else if (f_pubha3 && m_jestha) {
            m_guna.setText("13");
        }else if (f_pubha3 && m_mula) {
            m_guna.setText("15.18");
        }else if (f_pubha3 && m_pusha1) {
            m_guna.setText("30.18");
        }else if (f_pubha3 && m_pusha3) {
            m_guna.setText("29");
        }else if (f_pubha3 && m_usha1) {
            m_guna.setText("30.18");
        }else if (f_pubha3 && m_usha3) {
            m_guna.setText("24");
        }else if (f_pubha3 && m_shravana) {
            m_guna.setText("24.27");
        }else if (f_pubha3 && m_dhanisthaA2) {
            m_guna.setText("20");
        }else if (f_pubha3 && m_dhanisthaB2) {
            m_guna.setText("28.18");
        }else if (f_pubha3 && m_shatavisha) {
            m_guna.setText("19");
        }else if (f_pubha3 && m_pubha3) {
            m_guna.setText("28");
        }else if (f_pubha3 && m_pubha1) {
            m_guna.setText("17.18");
        }else if (f_pubha3 && m_ubha) {
            m_guna.setText("22.18");
        }else if (f_pubha3 && m_revati) {
            m_guna.setText("20");
        }
    }
    public void fPubha1ToFALL(){

        if (f_pubha1 && m_aswini){
            m_guna.setText("15.18");
        }else if (f_pubha1 && m_bharani) {
            m_guna.setText("22.18");
        }else if (f_pubha1 && m_kritika1) {
            m_guna.setText("17.18");
        }else if (f_pubha1 && m_kritika3) {
            m_guna.setText("20");
        }else if (f_pubha1 && m_rohini) {
            m_guna.setText("27");
        }else if (f_pubha1 && m_mrigaA2) {
            m_guna.setText("27");
        }else if (f_pubha1 && m_mrigaB2) {
            m_guna.setText("25.18");
        }else if (f_pubha1 && m_aadra) {
            m_guna.setText("18");
        }else if (f_pubha1 && m_punarvasu3) {
            m_guna.setText("19");
        }else if (f_pubha1 && m_punarvasu1) {
            m_guna.setText("18");
        }else if (f_pubha1 && m_tisya) {
            m_guna.setText("25");
        }else if (f_pubha1 && m_ashlesha) {
            m_guna.setText("18.18");
        }else if (f_pubha1 && m_magha) {
            m_guna.setText("17.18");
        }else if (f_pubha1 && m_pufa) {
            m_guna.setText("23.18");
        }else if (f_pubha1 && m_ufa1) {
            m_guna.setText("15.18");
        }else if (f_pubha1 && m_ufa3) {
            m_guna.setText("16.18");
        }else if (f_pubha1 && m_hasta) {
            m_guna.setText("18.18");
        }else if (f_pubha1 && m_chitraA2) {
            m_guna.setText("19.18");
        }else if (f_pubha1 && m_chitraB2) {
            m_guna.setText("12.18");
        }else if (f_pubha1 && m_swati) {
            m_guna.setText("21");
        }else if (f_pubha1 && m_vishakha3) {
            m_guna.setText("14");
        }else if (f_pubha1 && m_vishakha1) {
            m_guna.setText("21");
        }else if (f_pubha1 && m_anuradha) {
            m_guna.setText("27");
        }else if (f_pubha1 && m_jestha) {
            m_guna.setText("11.18");
        }else if (f_pubha1 && m_mula) {
            m_guna.setText("15");
        }else if (f_pubha1 && m_pusha1) {
            m_guna.setText("30");
        }else if (f_pubha1 && m_pusha3) {
            m_guna.setText("31.18");
        }else if (f_pubha1 && m_usha1) {
            m_guna.setText("30");
        }else if (f_pubha1 && m_usha3) {
            m_guna.setText("29.18");
        }else if (f_pubha1 && m_shravana) {
            m_guna.setText("28.27");
        }else if (f_pubha1 && m_dhanisthaA2) {
            m_guna.setText("25.18");
        }else if (f_pubha1 && m_dhanisthaB2) {
            m_guna.setText("17");
        }else if (f_pubha1 && m_shatavisha) {
            m_guna.setText("7.18");
        }else if (f_pubha1 && m_pubha3) {
            m_guna.setText("16.18");
        }else if (f_pubha1 && m_pubha1) {
            m_guna.setText("28");
        }else if (f_pubha1 && m_ubha) {
            m_guna.setText("33");
        }else if (f_pubha1 && m_revati) {
            m_guna.setText("30.18");
        }
    }
    public void fUbhaToFALL(){

        if (f_ubha && m_aswini){
            m_guna.setText("25.18");
        }else if (f_ubha && m_bharani) {
            m_guna.setText("16.18");
        }else if (f_ubha && m_kritika1) {
            m_guna.setText("19.18");
        }else if (f_ubha && m_kritika3) {
            m_guna.setText("22");
        }else if (f_ubha && m_rohini) {
            m_guna.setText("26");
        }else if (f_ubha && m_mrigaA2) {
            m_guna.setText("18");
        }else if (f_ubha && m_mrigaB2) {
            m_guna.setText("16.18");
        }else if (f_ubha && m_aadra) {
            m_guna.setText("25.18");
        }else if (f_ubha && m_punarvasu3) {
            m_guna.setText("27");
        }else if (f_ubha && m_punarvasu1) {
            m_guna.setText("26");
        }else if (f_ubha && m_tisya) {
            m_guna.setText("19");
        }else if (f_ubha && m_ashlesha) {
            m_guna.setText("20");
        }else if (f_ubha && m_magha) {
            m_guna.setText("18.18");
        }else if (f_ubha && m_pufa) {
            m_guna.setText("16.18");
        }else if (f_ubha && m_ufa1) {
            m_guna.setText("26.18");
        }else if (f_ubha && m_ufa3) {
            m_guna.setText("27.18");
        }else if (f_ubha && m_hasta) {
            m_guna.setText("26.18");
        }else if (f_ubha && m_chitraA2) {
            m_guna.setText("9.18");
        }else if (f_ubha && m_chitraB2) {
            m_guna.setText("2.18");
        }else if (f_ubha && m_swati) {
            m_guna.setText("19.18");
        }else if (f_ubha && m_vishakha3) {
            m_guna.setText("12");
        }else if (f_ubha && m_vishakha1) {
            m_guna.setText("19");
        }else if (f_ubha && m_anuradha) {
            m_guna.setText("20");
        }else if (f_ubha && m_jestha) {
            m_guna.setText("22");
        }else if (f_ubha && m_mula) {
            m_guna.setText("24");
        }else if (f_ubha && m_pusha1) {
            m_guna.setText("22");
        }else if (f_ubha && m_pusha3) {
            m_guna.setText("23.18");
        }else if (f_ubha && m_usha1) {
            m_guna.setText("31");
        }else if (f_ubha && m_usha3) {
            m_guna.setText("30.18");
        }else if (f_ubha && m_shravana) {
            m_guna.setText("28.27");
        }else if (f_ubha && m_dhanisthaA2) {
            m_guna.setText("14.18");
        }else if (f_ubha && m_dhanisthaB2) {
            m_guna.setText("6");
        }else if (f_ubha && m_shatavisha) {
            m_guna.setText("16");
        }else if (f_ubha && m_pubha3) {
            m_guna.setText("21.18");
        }else if (f_ubha && f_pubha1) {
            m_guna.setText("33");
        }else if (f_ubha && m_ubha) {
            m_guna.setText("28");
        }else if (f_ubha && m_revati) {
            m_guna.setText("34");
        }
    }
    public void fRewatiToFALL(){

        if (f_revati && m_aswini){
            m_guna.setText("26");
        }else if (f_revati && m_bharani) {
            m_guna.setText("25.18");
        }else if (f_revati && m_kritika1) {
            m_guna.setText("12.18");
        }else if (f_revati && m_kritika3) {
            m_guna.setText("15");
        }else if (f_revati && m_rohini) {
            m_guna.setText("18");
        }else if (f_revati && m_mrigaA2) {
            m_guna.setText("27");
        }else if (f_revati && m_mrigaB2) {
            m_guna.setText("25.18");
        }else if (f_revati && m_aadra) {
            m_guna.setText("24.18");
        }else if (f_revati && m_punarvasu3) {
            m_guna.setText("26.18");
        }else if (f_revati && m_punarvasu1) {
            m_guna.setText("25.18");
        }else if (f_revati && m_tisya) {
            m_guna.setText("27");
        }else if (f_revati && m_ashlesha) {
            m_guna.setText("14");
        }else if (f_revati && m_magha) {
            m_guna.setText("14");
        }else if (f_revati && m_pufa) {
            m_guna.setText("24.18");
        }else if (f_revati && m_ufa1) {
            m_guna.setText("24.18");
        }else if (f_revati && m_ufa3) {
            m_guna.setText("25.18");
        }else if (f_revati && m_hasta) {
            m_guna.setText("26.18");
        }else if (f_revati && m_chitraA2) {
            m_guna.setText("20.18");
        }else if (f_revati && m_chitraB2) {
            m_guna.setText("13.18");
        }else if (f_revati && m_swati) {
            m_guna.setText("11.18");
        }else if (f_revati && m_vishakha3) {
            m_guna.setText("5.18");
        }else if (f_revati && m_vishakha1) {
            m_guna.setText("12.18");
        }else if (f_revati && m_anuradha) {
            m_guna.setText("27");
        }else if (f_revati && m_jestha) {
            m_guna.setText("22");
        }else if (f_revati && m_mula) {
            m_guna.setText("26.18");
        }else if (f_revati && m_pusha1) {
            m_guna.setText("29");
        }else if (f_revati && m_pusha3) {
            m_guna.setText("30.18");
        }else if (f_revati && m_usha1) {
            m_guna.setText("21");
        }else if (f_revati && m_usha3) {
            m_guna.setText("20.18");
        }else if (f_revati && m_shravana) {
            m_guna.setText("20.27");
        }else if (f_revati && m_dhanisthaA2) {
            m_guna.setText("22.18");
        }else if (f_revati && m_dhanisthaB2) {
            m_guna.setText("14");
        }else if (f_revati && m_shatavisha) {
            m_guna.setText("16");
        }else if (f_revati && m_pubha3) {
            m_guna.setText("18");
        }else if (f_revati && m_pubha1) {
            m_guna.setText("29.18");
        }else if (f_revati && m_ubha) {
            m_guna.setText("34");
        }else if (f_revati && m_revati) {
            m_guna.setText("28");
        }
    }

    public void delayShowInsAds(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                clickCount = 5;
                sharedPref.setIntersCounter(clickCount);
                showIntersAds();
                handler.postDelayed(runnable, 90000);
            }
        };
        handler.post(runnable);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}