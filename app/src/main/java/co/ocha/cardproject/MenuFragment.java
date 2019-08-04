package co.ocha.cardproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {
    CardView reg_new,reg_existed,view_card,exit;
    Intent intent;
    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        reg_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),RegisterNewActivity.class);
                startActivity(intent);
            }
        });

        reg_existed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),RegisterExistedPersonActivity.class);
                startActivity(intent);
            }
        });
        view_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getContext(),ViewCardsActivity.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Exits", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void init(View view){
        reg_new = view.findViewById(R.id.register_new_id);
        reg_existed = view.findViewById(R.id.register_existed_id);
        view_card = view.findViewById(R.id.view_cards_id);
        exit = view.findViewById(R.id.exit_id);
    }
}
