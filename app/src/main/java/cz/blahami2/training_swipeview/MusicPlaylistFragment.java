package cz.blahami2.training_swipeview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MusicPlaylistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicPlaylistFragment extends Fragment {
    ListView listView ;

    public static MusicPlaylistFragment newInstance() {
        MusicPlaylistFragment fragment = new MusicPlaylistFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public MusicPlaylistFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_music_playlist, container, false);

        listView = (ListView) rootView.findViewById(R.id.listView);

        // Defined Array values to show in ListView
        String[] values = new String[] { "Playlist1",
                "Playlist2",
                "Playlist3",
                "Playlist4",
                "Playlist5"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(rootView.getContext(), R.layout.list_item, R.id.list_item_text, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


            }

        });

        return rootView;

    }

}
