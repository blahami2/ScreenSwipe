package cz.blahami2.training_swipeview;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import java.util.Locale;


public class ScreenSlidePagerActivity extends FragmentActivity {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    public static final int NUM_PAGES = 5;
    public static final int LOOPS = 100;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;
    private DotPageIndicatorView mPageIndicator;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide_pager);

        // pages
        ScreenSlidePageFragment.layouts.add(R.layout.fragment_screen_slide_contacts_page);
        ScreenSlidePageFragment.layouts.add(R.layout.fragment_screen_slide_radio_page);
        ScreenSlidePageFragment.layouts.add(R.layout.fragment_screen_slide_music_page);
        ScreenSlidePageFragment.layouts.add(R.layout.fragment_screen_slide_settings_page);
        ScreenSlidePageFragment.layouts.add(R.layout.fragment_screen_slide_page);

        ScreenSlidePageFragment.texts.add("contacts");
        ScreenSlidePageFragment.texts.add("radio");
        ScreenSlidePageFragment.texts.add("music");
        ScreenSlidePageFragment.texts.add("settings");
        ScreenSlidePageFragment.texts.add("blank");

        DotPageIndicatorView.dotViews.add(findViewById(R.id.indi_0));
        DotPageIndicatorView.dotViews.add(findViewById(R.id.indi_1));
        DotPageIndicatorView.dotViews.add(findViewById(R.id.indi_2));
        DotPageIndicatorView.dotViews.add(findViewById(R.id.indi_3));
        DotPageIndicatorView.dotViews.add(findViewById(R.id.indi_4));


        ColorDrawable colorDrawable = (ColorDrawable) getResources().getDrawable(R.color.root_color_dark);
        getActionBar().setBackgroundDrawable(colorDrawable);

        mPageIndicator = (DotPageIndicatorView) findViewById(R.id.indicator);
        mPageIndicator.setCount(NUM_PAGES);
        mPageIndicator.setCurrent(0);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(NUM_PAGES * LOOPS / 2);

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                //Log.d("ChangeListener: ","scrolled:" + i + ", " + v + ", " + i2);
            }

            @Override
            public void onPageSelected(int i) {
                //Log.d("ChangeListener: ", "selected: " + i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE) {
                    int selected = mPager.getCurrentItem();
                    Log.d("ChangeListener: ", "selected: " + selected);
                    if (selected == 0) {
                        mPager.setCurrentItem((NUM_PAGES * LOOPS), false);
                    } else if (selected == (NUM_PAGES * LOOPS) + 1) {
                        mPager.setCurrentItem(1, false);
                    }
                    Log.d("ChangeListener: ", "selected 2: " + mPager.getCurrentItem());
                    View focusedChild = mPager.getFocusedChild();

                    mPageIndicator.setCurrent((mPager.getCurrentItem()) % NUM_PAGES);


                    tts = new TextToSpeech(getApplicationContext(),
                            new TextToSpeech.OnInitListener(){

                                @Override
                                public void onInit(int status) {
                                    if(status != TextToSpeech.ERROR){
                                        tts.setLanguage(Locale.US);
                                    }
                                    if (status == TextToSpeech.SUCCESS) {
                                        int idx = mPager.getCurrentItem() % ScreenSlidePageFragment.texts.size();
                                        String text = ScreenSlidePageFragment.texts.get(idx);
                                        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);

                                    }
                                }
                            });
                }
                Log.d("ChangeListener: ", "state: " + i);
            }
        });
        mPager.setOffscreenPageLimit(3);
        int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 250, getResources().getDisplayMetrics());

        mPager.setPadding(margin, 0, margin, 0);
        mPager.setClipToPadding(false);
//        mPager.setPageMargin(-margin/2);

    }



    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Log.d("PageAdapter: ", "getItem: " + i);
            int item = i;
            i = i % NUM_PAGES;
            Log.d("PageAdapter: ", "getItem2: " + i);
//            return pages.get(i);
            return ScreenSlidePageFragment.newInstance(item);
//            switch (i) {
//                case 0:
//                    return new ScreenSlidePageContactsFragment();
//                case 1:
//                    return new ScreenSlidePageRadioFragment();
//                case 2:
//                    return new ScreenSlidePageMusicFragment();
//                case 3:
//                    return new ScreenSlidePageSettingsFragment();
//                case 4:
//                    return ScreenSlidePageFragment.newInstance(item);
//                default:
//                    return new ScreenSlidePageFragment();
//            }
        }

        @Override
        public int getCount() {
            return (NUM_PAGES * LOOPS) + 2;
        }
    }

}
