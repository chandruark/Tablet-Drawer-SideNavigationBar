package in.nfnlabs.playgrounddr.LandingActivity.DragandDrop;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import in.nfnlabs.playgrounddr.R;


public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        SectionHeaderViewHolder.HeaderViewHolderCallback {
    private static final int USER_TYPE = 1;
    private static final int HEADER_TYPE = 2;
    private List<User> usersList;
    private List<String> userTypeList;

    private SparseArray<ViewType> viewTypes;
    private SparseIntArray headerExpandTracker;
    private static final String TAG = "UserListAdapter";

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case USER_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_landing_list_item, parent, false);
                return new UserViewHolder(view);
            case HEADER_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_section_header, parent, false);
                return new SectionHeaderViewHolder(view, this);
            default:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_landing_list_item, parent, false);
                return new UserViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        ViewType viewType = viewTypes.get(position);
        if (itemViewType == USER_TYPE) {
            bindUserViewHolder(holder, viewType);
        } else {
            bindHeaderViewHolder(holder, position, viewType);
        }
    }

    private void bindHeaderViewHolder(RecyclerView.ViewHolder holder, int position, ViewType viewType) {
        int dataIndex = viewType.getDataIndex();
        SectionHeaderViewHolder headerViewHolder = (SectionHeaderViewHolder) holder;
        headerViewHolder.sectionTitle.setText(userTypeList.get(dataIndex));
       // headerViewHolder.no_of_patients.setText(viewType.getType());
        if (isExpanded(position)) {
            headerViewHolder.sectionTitle
                    .setCompoundDrawablesWithIntrinsicBounds(null, null, headerViewHolder.arrowUp, null);
        } else {
            headerViewHolder.sectionTitle
                    .setCompoundDrawablesWithIntrinsicBounds(null, null, headerViewHolder.arrowDown, null);
        }
    }

    private void bindUserViewHolder(RecyclerView.ViewHolder holder, ViewType viewType) {
        int dataIndex = viewType.getDataIndex();
        ((UserViewHolder) holder).username.setText(usersList.get(dataIndex).getName());
        Glide.with(holder.itemView).load(usersList.get(dataIndex).getImageUrl()).into(((UserViewHolder) holder).userAvatar);
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (userTypeList != null && usersList != null) {
            viewTypes.clear();
            int collapsedCount = 0;
            for (int i = 0; i < userTypeList.size(); i++) {
                viewTypes.put(count, new ViewType(i, HEADER_TYPE));
                count += 1;
                String userType = userTypeList.get(i);
                int childCount = getChildCount(userType);
                if (headerExpandTracker.get(i) != 0) {
                    // Expanded State
                    for (int j = 0; j < childCount; j++) {
                        viewTypes.put(count, new ViewType(count - (i + 1) + collapsedCount, USER_TYPE));
                        count += 1;
                    }
                } else {
                    // Collapsed
                    collapsedCount += childCount;
                }
            }
        }

        for(int i = 0; i < viewTypes.size(); i++) {
            int key = viewTypes.keyAt(i);
            // get the object by the key.
            Object obj = viewTypes.get(key);
            Log.d(TAG, "getItemCount: "+((ViewType) obj).getType());
        }


        return count;
    }

    @Override
    public int getItemViewType(int position) {
        if (viewTypes.get(position).getType() == HEADER_TYPE) {
            return HEADER_TYPE;
        } else {
            return USER_TYPE;
        }
    }

    private int getChildCount(String type) {
        switch (type) {
            case "Waiting List":
                return viewTypes.keyAt(0);
            case "Appointment (9:00 AM - 2:00 PM)":
                return viewTypes.keyAt(1);
            case "Appointment (5:00 PM - 8:00 PM)":
                return viewTypes.keyAt(2);
            case "Completed Appoinments":
                return viewTypes.keyAt(3);
            default:
                return 0;
        }
    }

    public void setUserListAndType(List<User> usersList, List<String> userTypeList) {
        if (usersList != null && userTypeList != null) {
            this.usersList = usersList;
            this.userTypeList = userTypeList;

            Log.d(TAG, "size "+usersList.size() +" "+ userTypeList.size());

            viewTypes = new SparseArray<>(usersList.size() + userTypeList.size());
            headerExpandTracker = new SparseIntArray(userTypeList.size());
            notifyDataSetChanged();

        }
    }

    @Override
    public void onHeaderClick(int position) {
        ViewType viewType = viewTypes.get(position);
        int dataIndex = viewType.getDataIndex();
        String userType = userTypeList.get(dataIndex);
        int childCount = getChildCount(userType);
        if (headerExpandTracker.get(dataIndex) == 0) {
            // Collapsed. Now expand it
            headerExpandTracker.put(dataIndex, 1);
            notifyItemRangeInserted(position + 1, childCount);
        } else {
            // Expanded. Now collapse it
            headerExpandTracker.put(dataIndex, 0);
            notifyItemRangeRemoved(position + 1, childCount);
        }
    }

    @Override
    public boolean isExpanded(int position) {
        int dataIndex = viewTypes.get(position).getDataIndex();
        return headerExpandTracker.get(dataIndex) == 1;
    }
}
