package com.comedyvideo.inos.comedyvideos;


import android.content.Intent;

import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class Video_Activity extends YouTubeBaseActivity {

    public static final String API_KEY = "AIzaSyB9_ZPKklvzfDP2Q7CZCXC8iZSwY6ilLXg";
    // String[] Video_id = {"cyk_ht8z6IA", "6CJL-PVmFJ0", "8a6Jy9wyK0U", "Oa-joxlsKJs"};

    YouTubePlayerView youTubePlayerView;
   // YouTubeThumbnailLoader youTubeThumbnailLoader;
    //Button fullscreenButton;
    TextView textView;
    ImageView sharebutton;
  //  private YouTubeThumbnailView youTubeThumbnailView;
    private static String Video_id;
    static String description;
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;


    public Video_Activity() {

    }

    Video_Activity(String str, String des) {

        Video_id = str;
        description = des;
        //Log.e(Video_id, "check");
        //Log.e(description, "check_dec");
    }
    /*YouTubeThumbnailView youTubeThumbnailView =  (YouTubeThumbnailView) findViewById(R.id.button_1);
    youTubeThumbnailView.OnClickListener(new )_*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

       youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player1);
       // youTubeThumbnailView = (YouTubeThumbnailView) findViewById(R.id.youtubethumbnailview2);
        textView = (TextView) findViewById(R.id.text_des);


        textView.setText(description);
       // Log.e(description, "check_dec_2");

       /* MobileAds.initialize(getApplicationContext(), "ca-app-pub-5242081863993909/3120534673");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/
        //fullscreenButton = (Button) findViewById(R.id.fullscreen_btn_id);
        sharebutton = (ImageView) findViewById(R.id.share_button);
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://www.youtube.com/watch?v=" + Video_id);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
              //  Log.e("test", "test share button");

                sendIntent.setPackage("com.whatsapp");
            }
        });
       /* // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(Video_Activity.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));


        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener*/


        youTubePlayerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {
                if (!b)

                    youTubePlayer.cueVideo(Video_id);
                youTubePlayer.setPlaybackEventListener(new YouTubePlayer.PlaybackEventListener() {
                    @Override
                    public void onPlaying() {
                    }

                    @Override
                    public void onPaused() {
                        youTubePlayer.pause();
                       Video_Activity.super.onPause();



                       // Log.e("etst","test2 ");


                    }

                    @Override
                    public void onStopped() {

                    }

                    @Override
                    public void onBuffering(boolean b) {


                    }

                    @Override
                    public void onSeekTo(int i) {

                    }
                });


               /* fullscreenButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        youTubePlayer.setFullscreen(true);
                        youTubePlayer.isPlaying();
                        /*interstitial.setAdListener(new AdListener() {
                            public void onAdLoaded() {
                                // Call displayInterstitial() function
                                displayInterstitial();
                            }
                        });
                    }
                });*/


              //  Log.e(Video_id, "check2");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });





       /* youTubeThumbnailView.initialize(API_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
                youTubeThumbnailLoader.setVideo(Video_id);
                Log.e(Video_id,"check_hum");
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });*/

        // YouTubeThumbnailLoader youTubeThumbnailLoader = (YouTubeThumbnailLoader) findViewById(R.id.youtubethumbnailview2);


    }
    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first

        Log.e("etst","test2 ");

        // Release the Camera because we don't need it when paused
        // and other activities might need to use it.

    }
    /*@Override
    public void onPause() {
        super.onPause();
        youTubePlayerView.

    }*/

    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }


}