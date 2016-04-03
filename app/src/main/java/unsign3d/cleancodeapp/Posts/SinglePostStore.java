package unsign3d.cleancodeapp.Posts;

import org.greenrobot.eventbus.Subscribe;

import unsigned.fluxify.actions.Action;
import unsigned.fluxify.dispatchers.AbstractDispatcher;
import unsigned.fluxify.stores.AbstractStore;

/**
 * Created by unsigned on 26/03/16.
 *
 */
public class SinglePostStore extends AbstractStore {

    /**
     * Constructor of the class
     *
     * @param dispatcher the dispatcher which you want to connect the store
     */
    public SinglePostStore(AbstractDispatcher dispatcher) {
        super(dispatcher);
    }


    @Override
    public void emitStoreChanged() {
        dispatcher.emitChanges(new SinglePostStoreChangedEvent());
    }

    @Override @Subscribe
    public void onAction(Action action) {
        switch (action.getType()) {
            case "SINGLE_POST_HAS_CHANGED":
                create(action.getPayload());
                emitStoreChanged();
                break;

        }
    }

    public class SinglePostStoreChangedEvent extends StoreChangeEvent{}
}
