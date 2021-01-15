package fr.vfrz.myhospital.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import fr.vfrz.myhospital.R;
import fr.vfrz.myhospital.viewmodel.HospitalBedViewModel;

public class ServiceFragment extends Fragment {

    private HospitalBedViewModel bedViewModel;
    private long serviceId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            serviceId = ServiceFragmentArgs.fromBundle(getArguments()).getServiceId();
        } else {
            serviceId = -1;
        }

        System.out.println(serviceId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.service_fragment, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        bedViewModel = new ViewModelProvider(this).get(HospitalBedViewModel.class);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(v -> {
            NavHostFragment.findNavController(ServiceFragment.this).popBackStack();
        });
    }
}