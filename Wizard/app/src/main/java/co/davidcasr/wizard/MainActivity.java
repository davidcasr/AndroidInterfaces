package co.davidcasr.wizard;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import co.davidcasr.wizard.fragments.WizardFragment;

public class MainActivity extends AppCompatActivity {

    private MyPagerAdapter mAdapter;
    private ViewPager mPager;
    private TextView mPreviousButton;
    private TextView mNextButton;
    private TextView mNavigator;
    private int mCurrentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentItem = 0;

        mPager = (ViewPager) findViewById(R.id.activity_wizard_pager);
        mPreviousButton = (TextView) findViewById(R.id.activity_wizard_previous);
        mNextButton = (TextView) findViewById(R.id.activity_wizard_next);
        mNavigator = (TextView) findViewById(R.id.activity_wizard_possition);

        mPreviousButton.setVisibility(View.INVISIBLE);

        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        mPager.setCurrentItem(mCurrentItem);
        setNavigator();

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int position) {
                if (mPager.getCurrentItem() == 0) {
                    mPreviousButton.setVisibility(View.INVISIBLE);
                } else {
                    mPreviousButton.setVisibility(View.VISIBLE);
                }
                if (mPager.getCurrentItem() == (mPager.getAdapter().getCount() - 1)) {
                    mNextButton.setText(getString(R.string.wizard_finish));
                } else {
                    mNextButton.setText(getString(R.string.wizard_next));
                }
                setNavigator();
            }
        });

        mPreviousButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mPager.getCurrentItem() != 0) {
                    mPager.setCurrentItem(mPager.getCurrentItem() - 1);
                }
                setNavigator();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPager.getCurrentItem() != (mPager.getAdapter().getCount() - 1)) {
                    mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                } else {
                    Toast.makeText(MainActivity.this, R.string.wizard_finish,
                            Toast.LENGTH_SHORT).show();
                }
                setNavigator();
            }
        });
    }

    public void setNavigator() {
        String navigation = "";
        for (int i = 0; i < mAdapter.getCount(); i++) {
            if (i == mPager.getCurrentItem()) {
                navigation += "•"
                        + "  ";
            } else {
                navigation += "○"
                        + "  ";
            }
        }
        mNavigator.setText(navigation);
    }

    public void setCurrentSlidePosition(int position) {
        this.mCurrentItem = position;
    }

    public int getCurrentSlidePosition() {
        return this.mCurrentItem;
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return WizardFragment.newInstance(position);
            } else if (position == 1) {
                return WizardFragment.newInstance(position);
            } else {
                return WizardFragment.newInstance(position);
            }
        }
    }

}


