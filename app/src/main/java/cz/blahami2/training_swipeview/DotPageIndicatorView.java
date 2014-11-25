package cz.blahami2.training_swipeview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Michael on 25. 11. 2014.
 */
public class DotPageIndicatorView extends LinearLayout {

    private int mCurrent = 0;
    private ArrayList<DotView> mDots;

    public static ArrayList<View> dotViews = new ArrayList<View>();

    public DotPageIndicatorView(Context context) {
        super(context);
        init();
    }

    public DotPageIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DotPageIndicatorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        mDots = new ArrayList<DotView>();
//        setAdapter(mAdapter = new IndicatorAdapter());
    }

    public final void setCount(int count) {
        mDots.clear();
        for (int i = 0; i < count; i++) {
            DotView dot = new DotView(dotViews.get(i));
            mDots.add(dot);
        }
        invalidate();
        Log.d("DotPageIndicatorView", "width = " + getWidth() + ", height = " + getHeight());
    }

    public void setCurrent(int current) {
        Log.d("PageIndicator", "setting unfilled current = " + current);
        mDots.get(mCurrent).setFilled(false);
        mCurrent = current;
        Log.d("PageIndicator", "setting filled current = " + current);
        mDots.get(mCurrent).setFilled(true);
        invalidate();
    }
}
