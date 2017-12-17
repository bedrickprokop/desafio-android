package br.com.githubrepos.repositories;

import android.support.annotation.NonNull;

import com.google.common.base.Preconditions;

import br.com.githubrepos.data.entity.RepositoryStatus;
import br.com.githubrepos.data.service.RepositoryServiceApi;

public class RepositoriesPresenter implements RepositoriesContract.UserActionsListener {

    private RepositoryServiceApi mServiceApi;
    private RepositoriesContract.View mView;

    public RepositoriesPresenter(@NonNull RepositoryServiceApi repositoryServiceApi,
                                 @NonNull RepositoriesContract.View repositoriesView) {

        this.mServiceApi = Preconditions.checkNotNull(repositoryServiceApi,
                "mServiceApi cannot be null!");
        this.mView = Preconditions.checkNotNull(repositoriesView,
                "mView cannot be null!");
    }

    @Override
    public void loadRepositoryList(int page, final boolean doRefresh) {
        String language = "language:Java", sort = "stars";

        mView.setProgressIndicator(doRefresh);

        mServiceApi.search(page, language, sort, new RepositoryServiceApi.RepositoryServiceCallback<RepositoryStatus>() {
            @Override
            public void onLoaded(RepositoryStatus data) {
                mView.setProgressIndicator(false);
                mView.showRepositoryList(data.getRepositoryList(), doRefresh);
            }
        });

    }
}
