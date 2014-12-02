package cz.blahami2.training_swipeview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MusicMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicMainFragment extends Fragment {

    private SeekBar volumeProgress;
    private SeekBar musicProgress;
    private TextView currentTime;
    private TextView endTime;

    public static MusicMainFragment newInstance() {
        MusicMainFragment fragment = new MusicMainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public MusicMainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_music_main, container, false);

        int end = 240;
        int current = 55;

        endTime = (TextView) rootView.findViewById(R.id.music_end_time);
        currentTime = (TextView) rootView.findViewById(R.id.music_current_time);

        endTime.setText(getTime(end));
        currentTime.setText(getTime(current));

        volumeProgress = (SeekBar) rootView.findViewById(R.id.volume);
        volumeProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        musicProgress = (SeekBar) rootView.findViewById(R.id.music_progress);
        musicProgress.setMax(end);
        musicProgress.setProgress(current);
        musicProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentTime.setText(getTime(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return rootView;

    }

    private String getTime(int progress){
        int hours = progress / 3600;
        progress %= 3600;
        int minutes = progress / 60;
        progress %= 60;
        int seconds = progress;
        String time = "";
        if(hours != 0){
            time += String.format("%02d:", hours);
        }
        time += String.format("%02d:%02d", minutes, seconds);
        return time;
    }

}
