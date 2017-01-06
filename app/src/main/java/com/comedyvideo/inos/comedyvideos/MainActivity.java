package com.comedyvideo.inos.comedyvideos;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
;
import android.widget.Button;

import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;



import com.google.android.gms.ads.InterstitialAd;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;




import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;




public  class MainActivity extends AppCompatActivity {


   // public static final String API_KEY = "";
   // String[] Video_id = {"cyk_ht8z6IA", "6CJL-PVmFJ0", "8a6Jy9wyK0U", "Oa-joxlsKJs"};
    //ImageButton button1,button2,button3,button4;
    Video_Activity video_activity = new Video_Activity();
  public   String[] Video_id = null;//{"cyk_ht8z6IA", "6CJL-PVmFJ0", "nOdSARCVYic", "Oa-joxlsKJs"};
  public   static String[] duration = null;
   public String[] description = null;
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;
    LinearLayout linearLayout,linearLayout_2;
   // YouTubeThumbnailView youTubeThumbnailView;


   // YouTubePlayerView youTubePlayerView,youTubePlayerView2,youTubePlayerView3,youTubePlayerView4;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
  //  private GoogleApiClient client;
   static String VideoUrlString ;




    /*Button b;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    VideoAdapter videoAdapter ;
    String [] str= {"cyk_ht8z6IA","6CJL-PVmFJ0","8a6Jy9wyK0U","Oa-joxlsKJs"};
    ListAdapter listAdapter =new ArrayAdapter<String>(this,android.R.layout.activity_list_item,str);
    ListView listView;*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConnectivityManager cn=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NetworkInfo nf=cn.getActiveNetworkInfo();



         linearLayout = (LinearLayout) findViewById(R.id.chech_internet_layout);
        linearLayout_2 = (LinearLayout)findViewById(R.id.progressBar_id);




       // search:
        if(nf != null && nf.isConnected()==true ) {
            linearLayout.setVisibility(View.GONE);






            new Httpcall2().execute();
            Httpcall2 jsonapi = new Httpcall2();
            jsonapi.execute();


            //String exp = jsonapi.setString();
           // Log.e(VideoUrlString, "what");
            //System.out.println(VideoUrlString + " testing");



            // **banner ads
            /*AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);*/

// Prepare the Interstitial Ad
            /*interstitial = new InterstitialAd(MainActivity.this);
// Insert the Ad Unit ID
            interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));


            interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
            interstitial.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    // Call displayInterstitial() function
                    displayInterstitial();
                }
            });*/
          //  MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");

            // Log.e(exp,"what");

/*
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });*/
            // ATTENTION: This was auto-generated to implement the App Indexing API.
            // See https://g.co/AppIndexing/AndroidStudio for more information.
          //  client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


        }
        else{
           // setContentView(R.layout.activity_check_internet);
            linearLayout.setVisibility(View.VISIBLE);
            linearLayout_2.setVisibility(View.GONE);

            Button button = (Button) findViewById(R.id.button_netCheck_Id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    //startActivity(intent);
                    /*Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);*/
                   //break  search;
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });
        }

    }
    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

    public class Httpcall2 extends AsyncTask<String, String, String[]> {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
       // private static String VideoUrlString ;

        public Httpcall2()
        {}


       public Httpcall2(String s)
        {
            VideoUrlString =s;

        }

        // Will contain the raw JSON response as a string.


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(String[] strings) {
            super.onPostExecute(strings);
          //  Log.e(VideoUrlString,"video String");
            ListAdapter videoListAdapter = new VideoAdapter(MainActivity.this,Video_id,duration,description,Video_id);
            ListView listView = (ListView) findViewById(R.id.Video_list);
            listView.setAdapter(videoListAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String video_id_position = String.valueOf(parent.getItemAtPosition(position));
                    String description_text = description[position];
                    video_activity = new Video_Activity(video_id_position,description_text);
                    Intent intent = new Intent(MainActivity.this, Video_Activity.class);
                    startActivity(intent);
                }
            });
            linearLayout_2.setVisibility(View.GONE);
            urlConnection.disconnect();
        }

        @Override
        protected String[] doInBackground(String... params) {
          //  String forecastJsonStr = null;
            //String VideoUrlString ;

            try {
                // Construct the URL for the OpenWeatherMap query
                // Possible parameters are avaiable at OWM's forecast API page, at
                // http://openweathermap.org/API#forecast
                URL url = new URL("http://viralcomedy.sonidentalclinic.com/api.json");
                //  JSONObject jsonObject = new JSONObject(setString());
              //  JSONArray jsonArray = new JSONArray();
             // System.out.println(jsonArray.getJSONArray()+"wats this");


                // Create the request to OpenWeatherMap, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String value =reader.readLine();
                //new com.comedyvideo.inos.comedyvideos.Httpcall(value);
                VideoUrlString = value;

               // System.out.println(" http test " +VideoUrlString);
                JSONObject jsonObject = new JSONObject(value);
                JSONArray jsonArray = jsonObject.getJSONArray("youtube");
               String[] testUrl= new String[jsonArray.length()];
                JSONObject finalObj = null;
                Video_id = new String[jsonArray.length()];
                duration = new String[jsonArray.length()];
                description= new String[jsonArray.length()];

                for(int i =0;i<jsonArray.length();i++) {
                finalObj = jsonArray.getJSONObject(i);
                    Video_id[i] = finalObj.getString("url");
                    duration[i] = finalObj.getString("Duration");
                    description[i] = finalObj.getString("description");

                    //System.out.println(Video_id[i]+" test url"+duration[i]);
               }
                //String testUrl = finalObj.getString("url");
              //System.out.println(testUrl+" test url");




                // Read the input stream into a String
            /*InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }*/
                //String VideoUrlString2 = buffer.toString();
                //Httpcall yo = new  Httpcall(VideoUrlString2);

               // Log.e(VideoUrlString,"video String");
                //Log.v( LOG_TAG ,"Forecast jSON String"+forecastJsonStr)
            } catch (IOException e) {
                //Log.e("PlaceholderFragment", "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attemping
                // to parse it.
                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        //Log.e("PlaceholderFragment", "Error closing stream", e);
                    }
                }
                return null;

            }


            // return rootView;



        }
        public String setString(){

            return VideoUrlString;
            //Log.e(exp,"what");
        }
    }
/*
    public class Urlcall extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... params) {
            URL url
            return null;
        }
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_shareApp) {


            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Get Viral, new and old comedy videos in one place \n https://vt8f7.app.goo.gl/H3Ed");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            sendIntent.setPackage("com.whatsapp");
            //return true;
        }

        if (id == R.id.action_contactUs) {

            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.setType("message/rfc822");
           // sendIntent.setData(Uri.parse("mailto:"));
           sendIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"viralcomedyapp@gmail.com"} );
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, "contact to Viral Comedy Team ");
            //sendIntent.putExtra(Intent.EXTRA_TEXT   , "body of email");
          //  startActivity(sendIntent);
            startActivity(Intent.createChooser(sendIntent, "Send mail..."));

        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    /*@Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }*/






}
