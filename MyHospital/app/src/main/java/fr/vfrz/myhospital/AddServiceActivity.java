package fr.vfrz.myhospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import fr.vfrz.myhospital.database.HospitalBedRepository;
import fr.vfrz.myhospital.database.HospitalServiceRepository;
import fr.vfrz.myhospital.databinding.ActivityAddServiceBinding;
import fr.vfrz.myhospital.model.HospitalBed;
import fr.vfrz.myhospital.model.HospitalBedState;
import fr.vfrz.myhospital.model.HospitalService;
import fr.vfrz.myhospital.viewmodel.AddServiceViewModel;

public class AddServiceActivity extends AppCompatActivity {

    private AddServiceViewModel viewModel;

    private HospitalServiceRepository serviceRepository;

    private HospitalBedRepository bedRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddServiceBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_service);
        viewModel = new ViewModelProvider(this).get(AddServiceViewModel.class);
        viewDataBinding.setAddServiceViewModel(viewModel);

        serviceRepository = new HospitalServiceRepository(getApplication());
        bedRepository = new HospitalBedRepository(getApplication());

        findViewById(R.id.addServiceAddBtn).setOnClickListener((btn) -> {
            long serviceId =  serviceRepository.insert(new HospitalService(viewModel.name));
            int bedCount = Integer.parseInt(viewModel.beds);
            for (int i = 0; i < bedCount; i++) {
                bedRepository.insert(new HospitalBed(serviceId, HospitalBedState.Free));
            }
            finish();
        });
    }
}