package co.davidcasr.wizard.fragments;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.davidcasr.wizard.R;

public class WizardFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    private int mPosition;
    private TextView mIcon;
    private TextView mTitle;
    private TextView mText;

    public static WizardFragment newInstance(int position) {
        WizardFragment f = new WizardFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_wizard,
                container, false);

        mIcon = (TextView) rootView.findViewById(R.id.fragment_wizard_icon);
        mTitle = (TextView) rootView.findViewById(R.id.fragment_wizard_title);
        mText = (TextView) rootView.findViewById(R.id.fragment_wizard_text);

        if (mPosition == 0) {
            mIcon.setText("1");
            mTitle.setText("Fragment Example 1");
            mText.setText("Text for Fragment Example 1 " + getString(R.string.lorem_ipsum_short));
        } else if (mPosition == 1) {
            mIcon.setText("2");
            mTitle.setText("Fragment Example 2");
            mText.setText("Text for Fragment Example 2 " + getString(R.string.lorem_ipsum_short));
        } else {
            mIcon.setText("3");
            mTitle.setText("Fragment Example 3");
            mText.setText("Text for Fragment Example 3 " + getString(R.string.lorem_ipsum_short));
        }

        ViewCompat.setElevation(rootView, 50);
        return rootView;
    }
}
