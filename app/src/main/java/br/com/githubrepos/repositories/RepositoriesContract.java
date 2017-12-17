package br.com.githubrepos.repositories;

import java.util.List;

import br.com.githubrepos.data.entity.Repository;

public interface RepositoriesContract {

    interface View {
        void setProgressIndicator(boolean isActive);

        void setListProgressIndicator(boolean isActive);

        void showRepositoryList(List<Repository> repositoryList, boolean doRefresh);

        void showPullRequestListUi(String ownerLogin, String repositoryName);
    }

    interface UserActionsListener {

        void loadRepositoryList(int page, boolean doRefresh);

        void openRepository(Repository repository);
    }

}
