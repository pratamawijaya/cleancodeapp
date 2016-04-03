import android.app.Application;
import unsign3d.cleancodeapp.flux_layer.SingleDispatcher;
/**
 * Created by unsigned on 26/03/16.
 *
 */
public class CleanAppApplication extends Application {
    public static final SingleDispatcher dispatcher = SingleDispatcher.getInstance();

    public void onCreate(){
        super.onCreate();

    }

}
