package fr.vfrz.myhospital.database;

import android.os.AsyncTask;

import fr.vfrz.myhospital.model.HospitalModel;

public abstract class HospitalBaseRepository {

    protected static class insertAsyncTask<TModel extends HospitalModel, TDao extends HospitalBaseDao<TModel>>
            extends AsyncTask<TModel, Void, Long> {

        private final TDao dao;

        public insertAsyncTask(TDao dao) {
            this.dao = dao;
        }

        @Override
        protected Long doInBackground(final TModel... params) {
            return dao.insert(params[0]);
        }
    }

    protected static class deleteAsyncTask<TModel extends HospitalModel, TDao extends HospitalBaseDao<TModel>>
            extends AsyncTask<TModel, Void, Void> {

        private final TDao dao;

        public deleteAsyncTask(TDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(final TModel... params) {
            dao.delete(params[0]);
            return null;
        }
    }
}
