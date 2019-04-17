package com.nabenik.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.enterprise.inject.Produces
import javax.enterprise.inject.spi.InjectionPoint

open class LogProducer{

    @Produces
    fun produceLog(injectionPoint: InjectionPoint): Logger =
            LoggerFactory.getLogger(injectionPoint.member.declaringClass.name)
}