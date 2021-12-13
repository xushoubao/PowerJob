package tech.powerjob.samples.processors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;
import tech.powerjob.worker.log.OmsLogger;

/**
 * DataX 处理器
 */
@Slf4j
@Component
public class DataXProcessor implements BasicProcessor {

    @Override
    public ProcessResult process(TaskContext context) throws Exception {
        OmsLogger omsLogger = context.getOmsLogger();
        omsLogger.info("DataXProcessor start process,context is {}.", context);

        String jobParams = context.getJobParams();
        System.out.println("jobParams is ===="+ jobParams);

        return new ProcessResult(true, context + ": " + "success");
    }
}
