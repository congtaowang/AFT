package cn.aft.weather.interactor;

import cn.aft.weather.interactor.cities.Loader;

/**
 * 2016/02/25 by congtaowang.
 * Version 1.0
 */
public class InteractorProxy implements Interactor {

    private InteractorProxy() {

    }

    private static class InteractorProxyHolder {
        private static final Interactor INSTANCE = new InteractorProxy();
    }

    public static Interactor getProxy() {
        return InteractorProxyHolder.INSTANCE;
    }

    private Interactor _interactor = new InteractorImpl();

    @Override
    public void loadCities(Loader loader) {
        _interactor.loadCities(loader);
    }
}
