package in.nfnlabs.playgrounddr.DragandDropconsole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import in.nfnlabs.playgrounddr.DragandDropconsole.fragment.LinearRecyclerFragment;
import in.nfnlabs.playgrounddr.DragandDropconsole.model.Month;
import in.nfnlabs.playgrounddr.DragandDropconsole.model.MonthHeader;
import in.nfnlabs.playgrounddr.DragandDropconsole.model.MonthItem;
import in.nfnlabs.playgrounddr.R;


public class PatientQueueActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_queue);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new LinearRecyclerFragment()).commit();

    }



    public PatientQueueActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }



    protected List<MonthItem> getMonths() {
        final List<MonthItem> monthList = new ArrayList<>();
        monthList.add(new MonthHeader("Waitinglists"));
        monthList.add(new Month("JAN", R.color.indigo_500));
        monthList.add(new Month("FEB", R.drawable.user_profile_male));
        monthList.add(new Month("MAR", R.drawable.user_profile_male));
        monthList.add(new MonthHeader("Appoinments 9-3"));
        monthList.add(new Month("APR", R.drawable.user_profile_female));
        monthList.add(new Month("MAY", R.drawable.user_profile_male));
        monthList.add(new Month("JUN", R.drawable.user_profile_female));
        monthList.add(new MonthHeader("Appoinments 5-8"));
        monthList.add(new Month("JUL", R.drawable.user_profile_male));
        monthList.add(new Month("AUG", R.drawable.user_profile_female));
        monthList.add(new Month("SEP", R.drawable.user_profile_male));
        monthList.add(new MonthHeader("Completed"));
        monthList.add(new Month("OCT", R.drawable.user_profile_male));
        monthList.add(new Month("NOV", R.drawable.user_profile_male));
        monthList.add(new Month("DEC", R.drawable.user_profile_female));

        return monthList;
    }
}
