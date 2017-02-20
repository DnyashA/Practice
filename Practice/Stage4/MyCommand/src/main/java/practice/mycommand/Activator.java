package practice.mycommand;

import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        Hashtable params = new Hashtable();
        params.put("osgi.command.scope", "practice");
        params.put("osgi.command.function", new String[] { "hello" });
        context.registerService(Command.class.getName(), new Command(context), params);
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
