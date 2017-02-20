package practice.lentaparser;

import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        Hashtable params = new Hashtable();
        params.put("osgi.command.scope", "news");
        params.put("osgi.command.function", new String[] { "stats" });
        context.registerService(Exec.class.getName(), new Exec(context, new Parser(context)), params);
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
