package fr.vfrz.myhospital.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import fr.vfrz.myhospital.R;
import fr.vfrz.myhospital.adapter.HospitalServiceListAdapter;
import fr.vfrz.myhospital.viewmodel.HospitalServiceViewModel;

public class ServicesFragment extends Fragment {

    private HospitalServiceViewModel serviceViewModel;
    private HospitalServiceListAdapter serviceListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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

        serviceViewModel.getServicesWithBeds().observe(getViewLifecycleOwner(), services -> serviceListAdapter.setServicesWithBeds(services));
    }
}