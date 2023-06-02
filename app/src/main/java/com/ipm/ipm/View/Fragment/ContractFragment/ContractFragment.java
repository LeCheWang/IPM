package com.ipm.ipm.View.Fragment.ContractFragment;

import static com.ipm.ipm.View.LoginActivity.jwt;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.ipm.ipm.Controller.ApiController;
import com.ipm.ipm.Helper.ErrorHelper;
import com.ipm.ipm.Model.Response.ContractResponse.Contract2;
import com.ipm.ipm.Model.Response.ContractResponse.ContractResponse;
import com.ipm.ipm.R;
import com.ipm.ipm.databinding.FragmentContractBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContractFragment extends Fragment {
    public ContractFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    List<String> kcn;
    String kcnSelect = "All";
    String[] status = {"All", "Chưa thuê", "Chờ duyệt", "Đã thuê"};
    String statusSelect = "All";

    List<Contract2> contract2s;
    ContractAdapter contractAdapter;

    FragmentContractBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contract, container, false);
        contract2s = new ArrayList<>();
        kcn = new ArrayList<>();
        kcn.add(kcnSelect);

        showSpinnerStatus();
        showContracts(1);

        return binding.getRoot();
    }

    private void showContracts(int page) {
        ApiController.apiService.getMyContract("Bearer "+ jwt, page).enqueue(new Callback<ContractResponse>() {
            @Override
            public void onResponse(Call<ContractResponse> call, Response<ContractResponse> response) {
                if (response.isSuccessful()){
                    if (page==1){
                        contract2s = response.body().getContractes();
                        contractAdapter = new ContractAdapter(contract2s, getActivity());
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
                        binding.revContract.setLayoutManager(layoutManager);
                        binding.revContract.setAdapter(contractAdapter);
                    }
                    for (Contract2 c: response.body().getContractes()){
                        kcn.add(c.getIdFactory().getIdIndustrial().getName());
                    }
                    showSpinnerKcn();
                }else {
                    ErrorHelper.toastError(getActivity(), response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ContractResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "network error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showSpinnerStatus() {
        binding.spnStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                statusSelect= status[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter adapterNgay = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_spinner_item, status);
        adapterNgay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spnStatus.setAdapter(adapterNgay);
    }

    private void showSpinnerKcn() {
        binding.spnKCN.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                kcnSelect= kcn.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter adapterNgay = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_spinner_item, kcn);
        adapterNgay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spnKCN.setAdapter(adapterNgay);
    }
}