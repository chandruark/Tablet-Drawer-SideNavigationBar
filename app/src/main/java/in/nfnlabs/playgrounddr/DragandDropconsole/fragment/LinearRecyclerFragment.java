package in.nfnlabs.playgrounddr.DragandDropconsole.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.thesurix.gesturerecycler.DefaultItemClickListener;
import com.thesurix.gesturerecycler.GestureAdapter;
import com.thesurix.gesturerecycler.GestureManager;
import com.thesurix.gesturerecycler.RecyclerItemTouchListener;

import in.nfnlabs.playgrounddr.DragandDropconsole.adapter.MonthsAdapter;
import in.nfnlabs.playgrounddr.DragandDropconsole.model.MonthItem;
import in.nfnlabs.playgrounddr.R;
import in.nfnlabs.playgrounddr.TabViewPaneLayoutListActivity;


public class LinearRecyclerFragment extends BaseFragment {

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(manager);

        final MonthsAdapter adapter = new MonthsAdapter(getContext(), R.layout.linear_item);
        adapter.setData(getMonths());

        mRecyclerView.setAdapter(adapter);


        mRecyclerView.addOnItemTouchListener(new RecyclerItemTouchListener<>(new DefaultItemClickListener<MonthItem>() {

            @Override
            public boolean onItemClick(final MonthItem item, final int position) {
                Snackbar.make(view, "Click event on the " + position + " position", Snackbar.LENGTH_SHORT).show();

                if(item.getType()!= MonthItem.MonthItemType.HEADER){
                    startActivity(new Intent(getActivity(), TabViewPaneLayoutListActivity.class));
                }
                return true;
            }

            @Override
            public void onItemLongPress(final MonthItem item, final int position) {
                Snackbar.make(view, "Long press event on the " + position + " position", Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public boolean onDoubleTap(final MonthItem item, final int position) {
                Snackbar.make(view, "Double tap event on the " + position + " position", Snackbar.LENGTH_SHORT).show();
                return true;
            }
        }));

        mGestureManager = new GestureManager.Builder(mRecyclerView)
                .setSwipeEnabled(true)
                .setLongPressDragEnabled(true)
                .setSwipeFlags(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT)
                .setDragFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN)
                .build();
        mGestureManager.setManualDragEnabled(!mGestureManager.isManualDragEnabled());

        adapter.setDataChangeListener(new GestureAdapter.OnDataChangeListener<MonthItem>() {
            @Override
            public void onItemRemoved(final MonthItem item, final int position) {
                Snackbar.make(view, "Month removed from position " + position, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onItemReorder(final MonthItem item, final int fromPos, final int toPos) {

                /**
                 * make api call if state changes in Drag and Drop listner
                 */

                Snackbar.make(view, "Month moved from position " + fromPos + " to " + toPos, Snackbar.LENGTH_SHORT).show();
            }
        });
    }

}


