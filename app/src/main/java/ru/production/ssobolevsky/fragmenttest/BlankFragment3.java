package ru.production.ssobolevsky.fragmenttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by pro on 18.06.2018.
 */

public class BlankFragment3 extends Fragment {

    public static final String EXTRA_TEXT = "TEXTVIEW";

    private TextView mTextView;

    public BlankFragment3() {
    }

    public static BlankFragment3 newInstance(Bundle bundle) {
        BlankFragment3 fragment = new BlankFragment3();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.blank_fragment3, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = view.findViewById(R.id.tv_text);
        setTextView(getArguments().getString(EXTRA_TEXT));
    }

    public void setTextView(String text) {
        mTextView.setText(text);
    }
}
