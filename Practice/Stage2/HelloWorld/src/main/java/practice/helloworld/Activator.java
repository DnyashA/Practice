package practice.helloworld;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import practice.helloworld.Implement.HelloWorldImpl;
import practice.helloworld.Interface.SayHello;

public class Activator implements BundleActivator {
    
    private ServiceRegistration serviceRegistration;
    
    public void start(BundleContext context) throws Exception {
        serviceRegistration = context.registerService(SayHello.class.getName(), new HelloWorldImpl(), null);
        System.out.println("Service 'Hello OSGi' registred.");
    }

    public void stop(BundleContext context) throws Exception {
        serviceRegistration.unregister();
    }

}
