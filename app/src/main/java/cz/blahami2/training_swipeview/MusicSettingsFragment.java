package cz.blahami2.training_swipeview;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MusicSettingsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MusicSettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicSettingsFragment extends Fragment {
    public static MusicSettingsFragment newInstance() {
        MusicSettingsFragment fragment = new MusicSettingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public MusicSettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_music_settings, container, false);


        return rootView;

    }
}
