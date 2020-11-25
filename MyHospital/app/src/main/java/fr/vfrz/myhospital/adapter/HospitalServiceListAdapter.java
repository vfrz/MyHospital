package fr.vfrz.myhospital.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.vfrz.myhospital.R;
import fr.vfrz.myhospital.databinding.ServicesItemBinding;
import fr.vfrz.myhospital.model.HospitalServiceWithBeds;

public class HospitalServiceListAdapter extends RecyclerView.Adapter<HospitalServiceListAdapter.HospitalServiceViewHolder> {

    private List<HospitalServiceWithBeds> servicesWithBeds;

    @Override
    public HospitalServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ServicesItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.services_item, parent, false);
        return new HospitalServiceViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(HospitalServiceViewHolder holder, int position) {
        if (servicesWithBeds != null) {
            HospitalServiceWithBeds current = servicesWithBeds.get(position);
            holder.binding.setService(current);
        } else {
            // Covers the case of data not being ready yet.
            holder.binding.setService(null);
        }
    }

    public void setServicesWithBeds(List<HospitalServiceWithBeds> service){
        servicesWithBeds = service;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        return servicesWithBeds != null ? servicesWithBeds.size() : 0;
    }

    class HospitalServiceViewHolder extends RecyclerView.ViewHolder {

        private ServicesItemBinding binding;

        private HospitalServiceViewHolder(ServicesItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
