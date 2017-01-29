

package com.example.brianofrim.juqe;

        import android.content.Context;
        import android.graphics.Color;
        import android.graphics.PorterDuff;
        import android.support.v4.content.ContextCompat;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.TextView;

        import java.util.ArrayList;

/**
 * Created by jferris on 28/01/17.
 */

public class ResultsListAdapter extends ArrayAdapter<Song> {

    private Context context;
    private ArrayList<Song> songList = new ArrayList<>();


    public ResultsListAdapter(Context context, ArrayList<Song> songList) {
        super(context, 0, songList);
        this.context = context;
        this.songList = songList;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.search_results_listview, parent, false);
        }
        TextView songName = (TextView) convertView.findViewById(R.id.songName);
        TextView songArtist = (TextView) convertView.findViewById(R.id.songArtist);
        final Button addToPoolButton = (Button) convertView.findViewById(R.id.add_to_pool);
        addToPoolButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                VenueController.addSong(songList.get(position));
                addToPoolButton.setEnabled(false);
                addToPoolButton.getBackground().setColorFilter(ContextCompat.getColor(context, R.color.buttonPressed), PorterDuff.Mode.MULTIPLY);
                //notifyDataSetChanged();
            }
            //RelativeLayout listItem = (RelativeLayout) v.getParent();
            //listItem.setBackgroundColor(ContextCompat.getColor(context, R.color.
        });

        Song song = getItem(position);
        //Set color for completion

        songName.setText(song.getName());
        songArtist.setText(song.getArtist());
        return convertView;

    }

    public void setButtonColor(ImageButton button, Song song) {
        if(UserController.getKeyList().contains(song.getHash())) {
            button.getBackground().setColorFilter(ContextCompat.getColor(context, R.color.buttonPressed), PorterDuff.Mode.MULTIPLY);
        } else {
            button.getBackground().setColorFilter(ContextCompat.getColor(context, R.color.tertiary_colour), PorterDuff.Mode.MULTIPLY);
        }
    }
}
