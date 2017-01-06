package com.comedyvideo.inos.comedyvideos;

import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.youtube.player.YouTubeThumbnailView;
import com.squareup.picasso.Picasso;



/**
 * Created by sarvesh on 11/21/2016.
 */

public class VideoAdapter extends ArrayAdapter<String>  {

    public static final String API_KEY ="AIzaSyB9_ZPKklvzfDP2Q7CZCXC8iZSwY6ilLXg";
     String video_position= null ;
    static String[] duration1 ;
    String[] description ;
    String[] video_id;

    TextView duration_text,description_text;
    ImageView share_app;

    public VideoAdapter(Context context, String[]  Video_id,String[] duration,String[] description,String [] video_id) {
        super(context,R.layout.video_view, Video_id);
        duration1 = duration;
        this.description =description;
        this.video_id = video_id;
       // Log.e(duration1[1],"check dur 2");

    }

public void shareApp(View v){

    Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
    sendIntent.setType("text/plain");
    //startActivity(sendIntent);

    sendIntent.setPackage("com.whatsapp");
}




    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.video_view,parent,false);
           video_position = getItem(position);
      // final PostHolder holder = null;

            share_app = (ImageView) customView.findViewById(R.id.shareApp_id);

        share_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "https://www.youtube.com/watch?v="+video_id[position]);
                sendIntent.setType("text/plain");
               getContext().startActivity(sendIntent);
               // Log.e("test","test share button");

                sendIntent.setPackage("com.whatsapp");

            }
        });


       // Log.e(""+position,"num");
        duration_text = (TextView) customView.findViewById(R.id.text_demo) ;
        description_text =(TextView) customView.findViewById(R.id.description_id);
       duration_text.setText(duration1[position]);
        description_text.setText(description[position]);

        //Log.e(duration1[1],"check dur");
       final YouTubeThumbnailView youTubeThumbnailView =(YouTubeThumbnailView) customView.findViewById(R.id.youtubethumbnailviewNew);
       // youTubeThumbnailView.initialize(API_KEY, (YouTubeThumbnailView.OnInitializedListener) this);
        Picasso.with(getContext()).load("http://img.youtube.com/vi/" +
                video_position + "/hqdefault.jpg").resize(1280, 720).centerCrop().into(youTubeThumbnailView);
       // YouTubeThumbnailLoader loader=  video_position.get(youTubeThumbnailView);
       // youTubeThumbnailView.setBackground();
/*

         YouTubeThumbnailLoader loader1= null;
        loader1.setVideo(video_position);
*/

           /* youTubeThumbnailView.initialize(API_KEY, new YouTubeThumbnailView.OnInitializedListener() {



                @Override
                public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
                    //youTubeThumbnailLoader.release();
                    // System.out.println(youTubeThumbnailLoader+"check value");
                    //if (youTubeThumbnailLoader != null) {


                    //youTubeThumbnailLoader.setVideo(video_position);
                    youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                        @Override
                        public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                            youTubeThumbnailLoader.release();
                        }

                        @Override
                        public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

                        }
                    });



                    //}

                    // youTubeThumbnailLoader.setPlaylist(video_position);
                    //System.out.println();
                    Log.e(video_position, "ada check");
                    // youTubeThumbnailLoader.release();


                }

                @Override
                public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

                }

            });*/



        return customView;
    }


    /*private class thumbNailTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] params) {
            return null;
        }
    }*/
}

