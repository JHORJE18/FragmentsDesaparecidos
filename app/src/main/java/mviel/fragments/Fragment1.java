package mviel.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class Fragment1 extends Fragment {
    private RelativeLayout layoutF1;
    private FragmentManager fm;
    private FragmentTransaction ft;

    public Fragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_main, container, false);
        layoutF1 = (RelativeLayout) v.findViewById(R.id.layoutF1);

        layoutF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getBaseContext(),"Has fet click en Fragment1",Toast.LENGTH_SHORT).show();
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                ft.add(R.id.canto_superior_dret,Fragment2.newInstance("",""));
                ft.commit();
            }
        });

        //Eventos clic largo
        layoutF1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                FragmentTransaction ft;
                FragmentManager fm;

                Fragment3 f3;
                Fragment2 f2;

                if ((f3 = (Fragment3)getFragmentManager().findFragmentById(R.id.canto_inferior_dret)) != null){
                    fm = getFragmentManager();
                    ft = fm.beginTransaction();

                    ft.remove(getFragmentManager().findFragmentById(R.id.canto_inferior_dret));
                    ft.commit();
                }
                if ((f2 = (Fragment2)getFragmentManager().findFragmentById(R.id.canto_superior_dret)) != null){
                    fm = getFragmentManager();
                    ft = fm.beginTransaction();

                    ft.remove(getFragmentManager().findFragmentById(R.id.canto_superior_dret));
                    ft.commit();
                } else {
                    Toast.makeText(getActivity().getBaseContext(),"Ya no hay Fragments",Toast.LENGTH_LONG).show();
                }

                return false;
            }
        });
        return v;
    }
}
