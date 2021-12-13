//package tech.powerjob.server.web.core.route.strategy;
//
//import com.wugui.datatx.core.biz.model.ReturnT;
//import com.wugui.datatx.core.biz.model.TriggerParam;
//import com.wugui.datax.admin.core.route.ExecutorRouter;
//import tech.powerjob.server.web.model.ReturnT;
//
//import java.util.List;
//
///**
// * Created by xuxueli on 17/3/10.
// */
//public class ExecutorRouteLast extends ExecutorRouter {
//
//    @Override
//    public ReturnT<String> route(TriggerParam triggerParam, List<String> addressList) {
//        return new ReturnT<String>(addressList.get(addressList.size()-1));
//    }
//
//}
