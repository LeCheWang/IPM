package com.ipm.ipm.View.Fragment.ContractFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ipm.ipm.Constant.CurrencyFormatter;
import com.ipm.ipm.Model.Factory;
import com.ipm.ipm.Model.Response.ContractResponse.Contract2;
import com.ipm.ipm.R;
import com.ipm.ipm.View.Fragment.FactoryFragment.FactoryAdapter;
import com.ipm.ipm.View.Fragment.FactoryFragment.IOnClickFactory;

import java.util.List;

public class ContractAdapter extends RecyclerView.Adapter<ContractAdapter.ViewHolder> {
    List<Contract2> contract2s;
    Context context;

    public void setContract2s(List<Contract2> contract2s) {
        this.contract2s = contract2s;
        notifyDataSetChanged();
    }

    public ContractAdapter(List<Contract2> contract2s, Context context) {
        this.contract2s = contract2s;
        this.context = context;
    }

    @NonNull
    @Override
    public ContractAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_contract, parent, false);
        ContractAdapter.ViewHolder viewHolder = new ContractAdapter.ViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ContractAdapter.ViewHolder holder, int position) {
        Contract2 contract2 = contract2s.get(position);
        holder.tvName.setText(contract2.getIdFactory().getName());
        holder.tvAreaName.setText(contract2.getIdFactory().getIdIndustrial().getName());

        switch (contract2.getIdFactory().getStatus()){
            case "0":
                holder.tvStatus.setBackgroundResource(R.drawable.fr_stt_0);
                holder.tvStatus.setTextColor(R.color.text_factory_status_0);
                holder.tvStatus.setText("Chưa thuê");
                break;
            case "1":
                holder.tvStatus.setBackgroundResource(R.drawable.fr_stt_1);
                holder.tvStatus.setTextColor(R.color.text_factory_status_1);
                holder.tvStatus.setText("Chờ duyệt");
                break;
            case "2":
                holder.tvStatus.setBackgroundResource(R.drawable.fr_stt_2);
                holder.tvStatus.setTextColor(R.color.text_factory_status_2);
                holder.tvStatus.setText("Đã thuê");
                break;
            default:
                break;
        }

        holder.tvArea.setText(contract2.getIdFactory().getAcreage()+" m2");
        Glide.with(context).load(contract2.getIdFactory().getImage()).placeholder(R.drawable.icon).into(holder.imgFactory);
    }

    @Override
    public int getItemCount() {
        return contract2s==null?0: contract2s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAreaName, tvName, tvStatus, tvArea, tvStartAt, tvEndAt;
        ImageView imgFactory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAreaName = itemView.findViewById(R.id.tvAreaName);
            tvName = itemView.findViewById(R.id.tvNameFactory);
            tvStatus = itemView.findViewById(R.id.tvStatusFactory);
            tvArea = itemView.findViewById(R.id.tvAreaFactory);
            tvStartAt = itemView.findViewById(R.id.tvStartAt);
            tvEndAt = itemView.findViewById(R.id.tvEndAt);
            imgFactory = itemView.findViewById(R.id.imgFactory);

        }
    }
}
