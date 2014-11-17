package cz.blahami2.training_swipeview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by Michael on 16. 11. 2014.
 */
public class SwipeViewPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

//    private MyLinearLayout cur = null;
//    private MyLinearLayout next = null;
//    private MainActivity context;
    private FragmentManager fm;
    private float scale;

    public SwipeViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
//        // make the first pager bigger than others
//        if (position == MainActivity.FIRST_PAGE)
//            scale = MainActivity.BIG_SCALE;
//        else
//            scale = MainActivity.SMALL_SCALE;
//        position = position % MainActivity.PAGES;
//        return MyFragment.newInstance(context, position, scale);
        return null;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        if (positionOffset >= 0f && positionOffset <= 1f)
//        {
//            cur = getRootView(position);
//            next = getRootView(position +1);
//            cur.setScaleBoth(MainActivity.BIG_SCALE
//                    - MainActivity.DIFF_SCALE * positionOffset);
//            next.setScaleBoth(MainActivity.SMALL_SCALE
//                    + MainActivity.DIFF_SCALE * positionOffset);
//        }
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

//    private MyLinearLayout getRootView(int position)
//    {
//        return (MyLinearLayout)
//                fm.findFragmentByTag(this.getFragmentTag(position))
//                        .getView().findViewById(R.id.root);
//    }

    @Override
    public int getCount() {
        return 0;
    }
}
