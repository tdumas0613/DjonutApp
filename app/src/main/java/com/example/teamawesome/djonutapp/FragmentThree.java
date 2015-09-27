package com.example.teamawesome.djonutapp;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Jit on 9/22/2015.
 * FragmentThree class that displays a grid for the Topping options for the Djonut
 */
public class FragmentThree extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        GridView gridview = (GridView) view.findViewById(R.id.gridview3);
        final ImageAdapter adapter = new ImageAdapter(view.getContext());
        gridview.setAdapter(adapter);
        gridview.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE_MODAL);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                adapter.onItemSelect(parent, v, position, id);

                /*This following code replaces the fragment, not what we want to do.
                But put code here that you want to happen on selection of an item in the grid

                FragmentTwo newFragment = new FragmentTwo();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.fragment_place1, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();*/

            }
        });

        return view;
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<Integer> mSelected = new ArrayList<>();


        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }



        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(251, 251));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setBackgroundResource(R.drawable.imageview_border);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        public void onItemSelect(AdapterView<?> parent, View v, int pos, long id) {
            Integer position = Integer.valueOf(pos);

            if(mSelected.contains(position)) {
                mSelected.remove(position);
                // update view (v) state here
                // eg: remove highlight
                v.setBackgroundResource(R.drawable.imageview_border);
                if(mSelected.isEmpty()){
                    getActivity().findViewById(R.id.tToSBtn).setClickable(false);
                    getActivity().findViewById(R.id.tToSBtn).setAlpha(0.5F);

                }

            }
            else {
                mSelected.add(position);
                // update view (v) state here
                // eg: add highlight
                v.setBackgroundColor(Color.parseColor("#d13339"));
                getActivity().findViewById(R.id.tToSBtn).setClickable(true);
                getActivity().findViewById(R.id.tToSBtn).setAlpha(1);

            }
        }

        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.yellow_btn,R.drawable.yellow_btn,
                R.drawable.yellow_btn,R.drawable.yellow_btn,
                R.drawable.yellow_btn,R.drawable.yellow_btn,
                R.drawable.yellow_btn,R.drawable.yellow_btn,
                R.drawable.yellow_btn,R.drawable.yellow_btn,
                R.drawable.yellow_btn,R.drawable.yellow_btn,
                R.drawable.yellow_btn,R.drawable.yellow_btn,
                R.drawable.yellow_btn,R.drawable.yellow_btn,
                R.drawable.yellow_btn,R.drawable.yellow_btn,
                R.drawable.yellow_btn,R.drawable.yellow_btn,
                R.drawable.yellow_btn,R.drawable.yellow_btn,
                R.drawable.yellow_btn,R.drawable.yellow_btn,
                R.drawable.yellow_btn,R.drawable.yellow_btn,
                R.drawable.yellow_btn
        };
    }
}
