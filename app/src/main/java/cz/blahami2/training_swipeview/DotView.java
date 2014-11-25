package cz.blahami2.training_swipeview;

import android.view.View;

/**
 * Created by Michael on 25. 11. 2014.
 */
public class DotView {
    private boolean filled;
    private View view;

    public DotView(View view) {
        this.view = view;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
        if (view != null) {
            if (filled) {
                view.setBackgroundResource(R.drawable.circle_filled);
            } else {
                view.setBackgroundResource(R.drawable.circle);
            }
        }
    }
}
