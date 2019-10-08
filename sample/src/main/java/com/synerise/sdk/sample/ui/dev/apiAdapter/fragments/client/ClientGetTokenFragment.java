package com.synerise.sdk.sample.ui.dev.apiAdapter.fragments.client;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.synerise.sdk.client.Client;
import com.synerise.sdk.core.types.model.Token;
import com.synerise.sdk.core.net.IDataApiCall;
import com.synerise.sdk.sample.R;
import com.synerise.sdk.sample.ui.dev.BaseDevFragment;

public class ClientGetTokenFragment extends BaseDevFragment {

    private IDataApiCall<Token> getTokenCall;

    public static ClientGetTokenFragment newInstance() {
        return new ClientGetTokenFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_client_get_token, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.get_token).setOnClickListener(v -> getToken());
    }

    @Override
    public void onStop() {
        super.onStop();
        if (getTokenCall != null) getTokenCall.cancel();
    }

    @SuppressWarnings("ConstantConditions")
    private void getToken() {
        if (getTokenCall != null) getTokenCall.cancel();
        getTokenCall = Client.getToken();
        getTokenCall.execute(success -> onSuccess(), this::onFailure);
    }
}
