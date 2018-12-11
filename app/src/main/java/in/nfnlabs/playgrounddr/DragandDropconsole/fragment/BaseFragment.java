package in.nfnlabs.playgrounddr.DragandDropconsole.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;


import com.thesurix.gesturerecycler.GestureManager;

import java.util.ArrayList;
import java.util.List;

import in.nfnlabs.playgrounddr.DragandDropconsole.model.Month;
import in.nfnlabs.playgrounddr.DragandDropconsole.model.MonthHeader;
import in.nfnlabs.playgrounddr.DragandDropconsole.model.MonthItem;
import in.nfnlabs.playgrounddr.R;

public class BaseFragment extends Fragment {

    protected RecyclerView mRecyclerView;
    protected GestureManager mGestureManager;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        mRecyclerView = new RecyclerView(getActivity());
        return mRecyclerView;
    }



    protected List<MonthItem> getMonths() {
        final List<MonthItem> monthList = new ArrayList<>();
        monthList.add(new MonthHeader("Waitinglists"));
        monthList.add(new Month("1", R.color.indigo_500));
        monthList.add(new Month("2", R.color.indigo_500));
        monthList.add(new Month("3", R.color.indigo_500));
        monthList.add(new MonthHeader("Appoinments 9 AM - 3 PM"));
        monthList.add(new Month("4", R.color.indigo_500));
        monthList.add(new Month("5", R.color.indigo_500));
        monthList.add(new Month("6", R.color.indigo_500));
        monthList.add(new MonthHeader("Appoinments 5 PM - 8 PM"));
        monthList.add(new Month("7", R.color.indigo_500));
        monthList.add(new Month("8", R.color.indigo_500));
        monthList.add(new Month("9", R.color.indigo_500));
        monthList.add(new MonthHeader("Completed Appoinments"));
        monthList.add(new Month("10", R.color.indigo_500));
        monthList.add(new Month("11", R.color.indigo_500));
        monthList.add(new Month("12", R.color.indigo_500));

        return monthList;
    }

}
