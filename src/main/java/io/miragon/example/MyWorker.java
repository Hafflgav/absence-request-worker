package io.miragon.example;

import io.miragon.miranum.connect.worker.api.Worker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyWorker {

    @Worker(type = "absence:saveToSAP")
    public DoSomethingResult saveToSAP(DoSomethingCommand doSomethingCommand) {
        log.info("Received command to save to SAP: " + doSomethingCommand);
        var result = doSomethingCommand.getCommand() + " result";
        log.info("Returning result from saving to SAP: " + result);
        return new DoSomethingResult(result);
    }

    @Worker(type = "absence:sendMail")
    public DoSomethingResult sendMail(DoSomethingCommand doSomethingCommand) {
        log.info("Received command so send Mail: " + doSomethingCommand);
        var result = doSomethingCommand.getCommand() + " result";
        log.info("Returning result from sending Mail: " + result);
        return new DoSomethingResult(result);
    }

    @Worker(type = "absence:deleteFromSAP")
    public DoSomethingResult deleteFromSAP(DoSomethingCommand doSomethingCommand) {
        log.info("Received command to delete from SAP: " + doSomethingCommand);
        var result = doSomethingCommand.getCommand() + " result";
        log.info("Returning result from deleting from SAP: " + result);
        return new DoSomethingResult(result);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class DoSomethingCommand {
        private Object command;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class DoSomethingResult {
        private Object result;
    }
}