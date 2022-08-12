package fr.francoisaudoy.personregister.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
@Aspect
public class RegisterLogger {

    private static final String DEBUG_MSG = "Method {0} called with arguments {1}";
    private static final String INFO_MSG = "Method {0} called";
    private final Logger logger = Logger.getLogger(RegisterLogger.class);

    @Before("@annotation(BeforeLog)")
    public void log(JoinPoint joinPoint) {
        if (logger.isDebugEnabled()) {
            Object[] args = joinPoint.getArgs();
            final String argsValue = Stream.of(args)
                    .map(Objects::toString)
                    .collect(Collectors.joining(","));
            logger.debug(MessageFormat.format(DEBUG_MSG, joinPoint.toLongString(), argsValue));
        } else
            logger.info(MessageFormat.format(INFO_MSG, joinPoint.toShortString()));

    }
}
