//package steps.hooks;
//
//import cucumber.api.java.Before;
//import ui.PageTransporter;
//
///**
// * Created by silvia valencia on 11/10/2015.
// */
//public class GlobalHooks {
//    private static boolean started = false;
//
//    @Before(order=1)
//    public void setUp() throws Exception {
//        if(!started) {
//
//            PageTransporter.getInstance().navigateToLoginPage();
//            started = true;
//        }
//    }
//}
