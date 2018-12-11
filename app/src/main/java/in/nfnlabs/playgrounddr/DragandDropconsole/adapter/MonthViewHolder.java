package in.nfnlabs.playgrounddr.DragandDropconsole.adapter;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;


import com.thesurix.gesturerecycler.GestureViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.nfnlabs.playgrounddr.DragandDropconsole.RecyclerViewClickListner;
import in.nfnlabs.playgrounddr.R;


public class MonthViewHolder extends GestureViewHolder  {

    @BindView(R.id.month_text)
    TextView mMonthText;

    @BindView(R.id.month_image)
    ImageView mMonthPicture;

    @BindView(R.id.mont_drag)
    ImageView mItemDrag;

    @Nullable
    @BindView(R.id.foreground)
    View mForegroundView;

    @Nullable
    @BindView(R.id.month_background_stub)
    ViewStub mBackgroundView;

    public MonthViewHolder(final View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    private RecyclerViewClickListner mListener;

    @Nullable
    @Override
    public View getDraggableView() {
        return mItemDrag;
    }

    @Override
    public View getForegroundView() {
        return mForegroundView == null ? super.getForegroundView() : mForegroundView;
    }

    @Nullable
    @Override
    public View getBackgroundView() {
        return mBackgroundView;
    }

    @Override
    public void onItemSelect() {
        final int textColorFrom = itemView.getContext().getResources().getColor(android.R.color.white);
        final int textColorTo = itemView.getContext().getResources().getColor(R.color.indigo_500);
        final ValueAnimator textAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), textColorFrom, textColorTo);
        textAnimation.setDuration(itemView.getContext().getResources().getInteger(R.integer.animation_speed_ms));
        textAnimation.addUpdateListener(getTextAnimatorListener(mMonthText, textAnimation));
        textAnimation.start();

        final int backgroundColorFrom = itemView.getContext().getResources().getColor(R.color.indigo_500);
        final int backgroundColorTo = itemView.getContext().getResources().getColor(android.R.color.white);
        final ValueAnimator backgroundAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), backgroundColorFrom, backgroundColorTo);
        backgroundAnimation.setDuration(itemView.getContext().getResources().getInteger(R.integer.animation_speed_ms));
        backgroundAnimation.addUpdateListener(getBackgroundAnimatorListener(mMonthText, backgroundAnimation));
        backgroundAnimation.start();
    }

    @Override
    public void onItemClear() {
        final int textColorFrom = itemView.getContext().getResources().getColor(R.color.indigo_500);
        final int textColorTo = itemView.getContext().getResources().getColor(android.R.color.white);
        final ValueAnimator textAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), textColorFrom, textColorTo);
        textAnimation.setDuration(itemView.getContext().getResources().getInteger(R.integer.animation_speed_ms));
        textAnimation.addUpdateListener(getTextAnimatorListener(mMonthText, textAnimation));
        textAnimation.start();

        final int backgroundColorFrom = itemView.getContext().getResources().getColor(android.R.color.white);
        final int backgroundColorTo = itemView.getContext().getResources().getColor(R.color.indigo_500);
        final ValueAnimator backgroundAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), backgroundColorFrom, backgroundColorTo);
        backgroundAnimation.setDuration(itemView.getContext().getResources().getInteger(R.integer.animation_speed_ms));
        backgroundAnimation.addUpdateListener(getBackgroundAnimatorListener(mMonthText, backgroundAnimation));
        backgroundAnimation.start();
    }

    @Override
    public boolean canDrag() {
        return true;
    }

    @Override
    public boolean canSwipe() {
        return true;
    }

    private ValueAnimator.AnimatorUpdateListener getBackgroundAnimatorListener(final TextView view, final ValueAnimator animator) {
        return new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                view.setBackgroundColor((int) animator.getAnimatedValue());
            }
        };
    }

    private ValueAnimator.AnimatorUpdateListener getTextAnimatorListener(final TextView view, final ValueAnimator animator) {
        return new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(final ValueAnimator valueAnimator) {
                view.setTextColor((int) animator.getAnimatedValue());
            }
        };
    }

}
