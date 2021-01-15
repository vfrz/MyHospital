package fr.vfrz.myhospital.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.vfrz.myhospital.R;
import fr.vfrz.myhospital.adapter.HospitalServiceListAdapter;
import fr.vfrz.myhospital.model.HospitalServiceWithBeds;
import fr.vfrz.myhospital.viewmodel.HospitalServiceViewModel;

public class ServicesFragment extends Fragment {

    private HospitalServiceViewModel serviceViewModel;
    private HospitalServiceListAdapter serviceListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.services_fragment, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.services_list);
        serviceListAdapter = new HospitalServiceListAdapter(this);
        recyclerView.setAdapter(serviceListAdapter);
        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        serviceViewModel = new ViewModelProvider(this).get(HospitalServiceViewModel.class);

        serviceViewModel.getServicesWithBeds().observe(getViewLifecycleOwner(), new Observer<List<HospitalServiceWithBeds>>() {
            @Override
            public void onChanged(@Nullable final List<HospitalServiceWithBeds> services) {
                // Update the cached copy of the words in the adapter.
                serviceListAdapter.setServicesWithBeds(services);
            }
        });

        /*view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ServicesFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });*/
    }
}