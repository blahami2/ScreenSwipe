package cz.blahami2.training_swipeview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePageFragment extends Fragment {

    private View content;
    private int idx;
    TextView tv;

    public static List<View> contents = new ArrayList<View>();
    public static List<Integer> layouts = new ArrayList<Integer>();
    public static List<String> texts = new ArrayList<String>();

    public static ScreenSlidePageFragment newInstance(int idx) {
        ScreenSlidePageFragment f = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt("screenSlidePageFragment_idx", idx);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        ViewGroup rootView = (ViewGroup) inflater.inflate(
//                R.layout.fragment_screen_slide_page, container, false);

        View view = getRootView(inflater, container, savedInstanceState);
        tv = (TextView) view.findViewById(R.id.button);
        Log.d("Fragment", "tv = " + tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newView(v);
            }
        });
//        while(texts.size() < layouts.size()){
//            texts.add("");
//        }
//        texts.set(getIdx() % texts.size(), (String) tv.getText());

        return view;
//        return rootView;

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    public void newView(View view){
        Log.d("Fragment.newView", "clicked");
        Intent intent = new Intent(getActivity(), ViewActivity.class);
        intent.putExtra("LAYOUT", layouts.get(getIdx() % layouts.size()));
        startActivity(intent);
    }

    private final void setContent() {
        int idx = getArguments().getInt("screenSlidePageFragment_idx");
        this.content = ScreenSlidePageFragment.contents.get(idx % contents.size());
    }

    private final View getRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(layouts.get(getIdx() % layouts.size()), container, false);
    }

    private final int getIdx(){
        int idx = getArguments().getInt("screenSlidePageFragment_idx");
        return idx;
    }

}
