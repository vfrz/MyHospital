package fr.vfrz.myhospital.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.vfrz.myhospital.R;
import fr.vfrz.myhospital.ServiceActivity;
import fr.vfrz.myhospital.database.HospitalServiceRepository;
import fr.vfrz.myhospital.databinding.ServicesItemBinding;
import fr.vfrz.myhospital.model.HospitalServiceWithBeds;

public class HospitalServiceListAdapter extends RecyclerView.Adapter<HospitalServiceListAdapter.HospitalServiceViewHolder> {

    private List<HospitalServiceWithBeds> servicesWithBeds;

    private Fragment fragment;

    public HospitalServiceListAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public HospitalServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ServicesItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.services_item, parent, false);
        return new HospitalServiceViewHolder(binding, fragment);
    }

    @Override
    public void onBindViewHolder(HospitalServiceViewHolder holder, int position) {
        if (servicesWithBeds != null) {
            HospitalServiceWithBeds current = servicesWithBeds.get(position);
            holder.binding.setService(current);
        } else {
            holder.binding.setService(null);
        }
    }

    public void setServicesWithBeds(List<HospitalServiceWithBeds> service){
        servicesWithBeds = service;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return servicesWithBeds != null ? servicesWithBeds.size() : 0;
    }

    class HospitalServiceViewHolder extends RecyclerView.ViewHolder {

        private ServicesItemBinding binding;

        public HospitalServiceViewHolder(ServicesItemBinding binding, Fragment fragment) {
            super(binding.getRoot());
            this.binding = binding;

            this.binding.getRoot().setOnClickListener(v -> {
                int position = getLayoutPosition();
                HospitalServiceWithBeds selectedService = servicesWithBeds.get(position);
                Intent intent = new Intent(fragment.getContext(), ServiceActivity.class);
                intent.putExtra("serviceId", selectedService.service.id);
                fragment.startActivity(intent);
            });

            this.binding.getRoot().setOnLongClickListener(v -> {
                int position = getLayoutPosition();
                HospitalServiceWithBeds serviceWithBeds = servicesWithBeds.get(position);
                HospitalServiceRepository serviceRepository = new HospitalServiceRepository(fragment.getActivity().getApplication());
                serviceRepository.delete(serviceWithBeds.service);
                return true;
            });
        }
    }

}
