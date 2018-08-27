package ru.production.ssobolevsky.fragmenttest;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by pro on 18.06.2018.
 */

public class BlankFragment2 extends Fragment {

    private Button mButton;

    public BlankFragment2() {
        // Required empty public constructor
    }

    public static BlankFragment2 newInstance() {
        BlankFragment2 fragment = new BlankFragment2();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButton = view.findViewById(R.id.b_button);
        initListeners();
    }

    private void initListeners() {
        mButton.setOnClickListener(new MyButtonClickListener());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private class MyButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putString(BlankFragment3.EXTRA_TEXT, ((MainActivity) getActivity()).getText());
            FragmentManager manager = getChildFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.frame_layout, BlankFragment3.newInstance(bundle), "fragmentThree")
                    .commit();
        }
    }

}
