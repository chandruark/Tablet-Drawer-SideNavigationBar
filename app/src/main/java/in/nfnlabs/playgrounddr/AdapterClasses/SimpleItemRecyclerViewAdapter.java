package in.nfnlabs.playgrounddr.AdapterClasses;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.nfnlabs.playgrounddr.FragmentCategory.TabViewPaneLayoutDetailFragment;
import in.nfnlabs.playgrounddr.R;
import in.nfnlabs.playgrounddr.TabViewPaneLayoutDetailActivity;
import in.nfnlabs.playgrounddr.TabViewPaneLayoutListActivity;
import in.nfnlabs.playgrounddr.model.ListPaneModel;

public class SimpleItemRecyclerViewAdapter
        extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

    private final TabViewPaneLayoutListActivity mParentActivity;
    private final List<ListPaneModel> mValues;
    private final boolean mTwoPane;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ListPaneModel item = (ListPaneModel) view.getTag();
            if (mTwoPane) {
                Bundle arguments = new Bundle();
                arguments.putString(TabViewPaneLayoutDetailFragment.ARG_ITEM_ID, item.id);
                TabViewPaneLayoutDetailFragment fragment = new TabViewPaneLayoutDetailFragment();
                fragment.setArguments(arguments);
                mParentActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.tabviewpanelayout_detail_container, fragment)
                        .commit();
            } else {
                Context context = view.getContext();
                Intent intent = new Intent(context, TabViewPaneLayoutDetailActivity.class);
                intent.putExtra(TabViewPaneLayoutDetailFragment.ARG_ITEM_ID, item.id);

                context.startActivity(intent);
            }
        }
    };

    public SimpleItemRecyclerViewAdapter(TabViewPaneLayoutListActivity parent,
                                         List<ListPaneModel> items,
                                         boolean twoPane) {
        mValues = items;
        mParentActivity = parent;
        mTwoPane = twoPane;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tabviewpanelayout_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mContentView.setText(mValues.get(position).getContent());
        holder.itemView.setTag(mValues.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final TextView mContentView;

        ViewHolder(View view) {
            super(view);

            mContentView = (TextView) view.findViewById(R.id.content);
        }
    }
}