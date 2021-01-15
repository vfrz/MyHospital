package fr.vfrz.myhospital.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.vfrz.myhospital.viewmodel.AddServiceViewModel;
import fr.vfrz.myhospital.R;

public class AddServiceFragment extends Fragment {

    private AddServiceViewModel viewModel;

    public static AddServiceFragment newInstance() {
        return new AddServiceFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_service_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AddServiceViewModel.class);
        // TODO: Use the ViewModel
    }

}