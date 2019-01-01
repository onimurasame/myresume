package com.onimurasame.myresume.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import kotlin.system.measureTimeMillis

@Aspect
@Configuration
class LoggableAspect {

    private val log: Logger = LoggerFactory.getLogger(LoggableAspect::class.java)

    @Around("@annotation(com.onimurasame.myresume.configuration.Loggable)")
    fun aroundLogger(proceedingJoinPoint: ProceedingJoinPoint): kotlin.Any? {

        var returningObject: kotlin.Any? = null

        val millis = measureTimeMillis {
            log.info("Calling... ${proceedingJoinPoint.sourceLocation}.${proceedingJoinPoint.target.javaClass}")
            returningObject = proceedingJoinPoint.proceed()
        }
        log.info("Call ended in ${millis}ms")

        return returningObject
    }
}
