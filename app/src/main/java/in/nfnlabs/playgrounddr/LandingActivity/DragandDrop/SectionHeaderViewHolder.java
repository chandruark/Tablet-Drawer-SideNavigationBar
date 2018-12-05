package in.nfnlabs.playgrounddr.LandingActivity.DragandDrop;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import in.nfnlabs.playgrounddr.R;


public class SectionHeaderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView sectionTitle, no_of_patients;
    private final HeaderViewHolderCallback callback;

    Drawable arrowUp;
    Drawable arrowDown;

    public SectionHeaderViewHolder(View itemView, HeaderViewHolderCallback callback) {
        super(itemView);
        sectionTitle = itemView.findViewById(R.id.textview_section_header);
        no_of_patients= itemView.findViewById(R.id.tv_no_patients);
        this.callback = callback;

        arrowUp = ContextCompat.getDrawable(itemView.getContext(), android.R.drawable.arrow_up_float);
        arrowDown = ContextCompat.getDrawable(itemView.getContext(), android.R.drawable.arrow_down_float);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        callback.onHeaderClick(position);
        if (callback.isExpanded(position)) {
            sectionTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, arrowUp, null);
        } else {
            sectionTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, arrowDown, null);
        }
    }

    public interface HeaderViewHolderCallback {
        void onHeaderClick(int position);

        boolean isExpanded(int position);
    }

}
