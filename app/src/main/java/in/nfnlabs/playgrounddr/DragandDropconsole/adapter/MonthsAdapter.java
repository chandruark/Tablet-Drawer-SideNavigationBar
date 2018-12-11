package in.nfnlabs.playgrounddr.DragandDropconsole.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.thesurix.gesturerecycler.GestureAdapter;
import com.thesurix.gesturerecycler.GestureViewHolder;

import in.nfnlabs.playgrounddr.DragandDropconsole.RecyclerViewClickListner;
import in.nfnlabs.playgrounddr.DragandDropconsole.model.Month;
import in.nfnlabs.playgrounddr.DragandDropconsole.model.MonthHeader;
import in.nfnlabs.playgrounddr.DragandDropconsole.model.MonthItem;
import in.nfnlabs.playgrounddr.R;

public class MonthsAdapter extends GestureAdapter<MonthItem, GestureViewHolder> {

     final Context mCtx ;
    final int mItemResId ;
    private static final String TAG = "MonthsAdapter";
    private RecyclerViewClickListner mListener;

    public MonthsAdapter(final Context ctx, @LayoutRes final int itemResId,RecyclerViewClickListner listner) {
       this.mCtx = ctx;
        this.mItemResId = itemResId;
        this.mListener =listner;
    }

    public MonthsAdapter(final Context ctx, @LayoutRes final int itemResId) {
        this.mCtx = ctx;
        this.mItemResId = itemResId;

    }


    @Override
    public GestureViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        if (viewType == MonthItem.MonthItemType.MONTH.ordinal()) {
            final View itemView = LayoutInflater.from(parent.getContext()).inflate(mItemResId, parent, false);
            return new MonthViewHolder(itemView);
        } else {
            final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item, parent, false);
            return new HeaderViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(final GestureViewHolder holder, final int position) {

        /**
         * for checking total item size
         */
       /* Log.d(TAG, "onBindViewHolder: "+getItemCount());*/

        Toast.makeText(mCtx, ""+getItemCount(), Toast.LENGTH_SHORT).show();
        super.onBindViewHolder(holder, position);
        final MonthItem monthItem = getItem(position);

        if (monthItem.getType() == MonthItem.MonthItemType.MONTH) {
            final MonthViewHolder monthViewHolder = (MonthViewHolder) holder;
            final Month month = (Month) monthItem;
            monthViewHolder.mMonthText.setText(month.getName());
            Glide.with(mCtx).load(month.getDrawableId()).apply(RequestOptions.centerCropTransform()).into(monthViewHolder.mMonthPicture);
/*
            holder.itemView.setOnClickListener((View.OnClickListener) this);
*/

        } else {

            final HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            final MonthHeader monthHeader = (MonthHeader) monthItem;
            headerViewHolder.mHeaderText.setText(monthHeader.getName());
        }
    }

    @Override
    public int getItemViewType(final int position) {
        return getItem(position).getType().ordinal();
    }


    /**
     * overrided from gesture view holder
     * @return
     */
   /* @Override
    public int getItemCount() {
        return super.getItemCount();
    }*/
}
