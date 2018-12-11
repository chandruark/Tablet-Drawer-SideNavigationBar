package in.nfnlabs.playgrounddr.DragandDropconsole.adapter;

import android.view.View;
import android.widget.TextView;

import com.thesurix.gesturerecycler.GestureViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.nfnlabs.playgrounddr.R;


public class HeaderViewHolder extends GestureViewHolder {

    @BindView(R.id.header_text)
    TextView mHeaderText;

    public HeaderViewHolder(final View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    @Override
    public boolean canDrag() {
        return false;
    }

    @Override
    public boolean canSwipe() {
        return false;
    }
}
