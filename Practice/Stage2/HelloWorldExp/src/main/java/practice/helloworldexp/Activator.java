package practice.helloworldexp;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import practice.helloworld.Interface.SayHello;

public class Activator implements BundleActivator {
    
    private SayHello service;
    public void start(BundleContext context) throws Exception {
        ServiceReference serviceReference = context.getServiceReference(SayHello.class.getName());
        service = (SayHello)context.getService(serviceReference);
        service.greeting();
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
