package in.nfnlabs.playgrounddr.FragmentCategory;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import in.nfnlabs.playgrounddr.R;
import in.nfnlabs.playgrounddr.TabViewPaneLayoutDetailActivity;
import in.nfnlabs.playgrounddr.TabViewPaneLayoutListActivity;

/**
 * A fragment_landing representing a single TabViewPaneLayout detail screen.
 * This fragment_landing is either contained in a {@link TabViewPaneLayoutListActivity}
 * in two-pane mode (on tablets) or a {@link TabViewPaneLayoutDetailActivity}
 * on handsets.
 */
public class TabViewPaneLayoutDetailFragment extends Fragment {
    /**
     * The fragment_landing argument representing the item ID that this fragment_landing
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private static final String TAG = "TabViewPaneLayoutDetail";
    /**
     * The dummy content this fragment_landing is presenting.
     */

    /**
     * Mandatory empty constructor for the fragment_landing manager to instantiate the
     * fragment_landing (e.g. upon screen orientation changes).
     */
    public TabViewPaneLayoutDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment_landing
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = null;

        // Show the dummy content as text in a TextView.

            rootView = inflater.inflate(R.layout.tabviewpanelayout_detail, container, false);
            Log.d(TAG, "onCreateView: inside webview");
             WebView wbView = (WebView) rootView.findViewById(R.id.tabwebviewdetail);
            wbView.loadUrl("https://play.google.com/store/apps");
            wbView.measure(100, 100);
            wbView.getSettings().setUseWideViewPort(true);
            wbView.getSettings().setLoadWithOverviewMode(true);


        return rootView;
    }
}
