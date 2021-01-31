package fr.vfrz.myhospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import java.util.concurrent.Executors;

import fr.vfrz.myhospital.database.HospitalServiceRepository;
import fr.vfrz.myhospital.databinding.ActivityServiceBinding;
import fr.vfrz.myhospital.model.HospitalServiceWithBeds;

public class ServiceActivity extends AppCompatActivity {

    private HospitalServiceRepository serviceRepository;

    private HospitalServiceWithBeds serviceWithBeds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        serviceRepository = new HospitalServiceRepository(getApplication());

        ActivityServiceBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_service);

        long serviceId = getIntent().getExtras().getLong("serviceId");
        Executors.newSingleThreadExecutor().execute(() -> {
            serviceWithBeds = serviceRepository.getByIdWithBeds(serviceId);
            viewDataBinding.setServiceWithBeds(serviceWithBeds);
        });
    }
}