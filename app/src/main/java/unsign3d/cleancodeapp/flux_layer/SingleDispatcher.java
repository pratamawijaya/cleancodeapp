package unsign3d.cleancodeapp.flux_layer;

import unsigned.fluxify.dispatchers.AbstractDispatcher;

/**
 * Created by unsigned on 26/03/16.
 *
 * The SingleDispatcher is a singleton based Dispatcher
 *
 */
public class SingleDispatcher extends AbstractDispatcher {
    private static SingleDispatcher __instance = null;

    /**
     * Initializer of the SingleDispather Dispatcher
     * @return an instance of the SingleDispatcher
     */
    public static SingleDispatcher getInstance(){
        if(__instance == null){
            __instance = new SingleDispatcher();
        }

        return __instance;
    }

    /**
     * Let's make the constructor private
     */
    private SingleDispatcher(){
        super();
    }
}
