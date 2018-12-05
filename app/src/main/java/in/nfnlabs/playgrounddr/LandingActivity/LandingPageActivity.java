package in.nfnlabs.playgrounddr.LandingActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.nfnlabs.playgrounddr.LandingActivity.DragandDrop.User;
import in.nfnlabs.playgrounddr.LandingActivity.DragandDrop.UserListAdapter;
import in.nfnlabs.playgrounddr.LandingActivity.DragandDrop.UsersData;
import in.nfnlabs.playgrounddr.R;

public class LandingPageActivity extends AppCompatActivity {



    @BindView(R.id.rv_draganddrop) RecyclerView rv_landingpage_dnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        ButterKnife.bind(this);

        rv_landingpage_dnd.setLayoutManager(new LinearLayoutManager(this));
        UserListAdapter adapter = new UserListAdapter();
        rv_landingpage_dnd.setAdapter(adapter);

        UsersData usersData = new UsersData();
        List<User> usersList = usersData.getUsersList();
        List<String> userTypeList = usersData.getUserTypeList();
        adapter.setUserListAndType(usersList, userTypeList);
    }
}
