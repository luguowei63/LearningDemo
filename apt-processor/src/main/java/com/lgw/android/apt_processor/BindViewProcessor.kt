package com.lgw.android.apt_processor

import com.google.auto.service.AutoService
import com.lgw.android.apt_annotation.BindView
import com.squareup.javapoet.JavaFile
import java.io.IOException
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement
import javax.lang.model.util.Elements

/**
 *Created by lgw on 1/20/21
 */
@AutoService(Processor::class)
class BindViewProcessor : AbstractProcessor() {
    private lateinit var elementUtils: Elements

    private val mProxyMap = mutableMapOf<String, BindViewCreatorProxy?>()

    override fun init(pEnvironment: ProcessingEnvironment) {
        super.init(pEnvironment)
        elementUtils = pEnvironment.elementUtils
        println("=============init====================")

    }

    override fun getSupportedSourceVersion(): SourceVersion {
        println("=============getSupportedSourceVersion====================")
        return SourceVersion.latestSupported()
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        val annotationSet = mutableSetOf<String>()
        annotationSet.add(BindView::class.java.canonicalName)
        println("=============getSupportedAnnotationTypes====================")
        return annotationSet
    }


    override fun process(
        mutableSet: MutableSet<out TypeElement>,
        roundEnvironment: RoundEnvironment
    ): Boolean {
        println("=============process====================")
        val bindViewSet = roundEnvironment.getElementsAnnotatedWith(BindView::class.java)
        for (element in bindViewSet) {
            val variableElement = element as VariableElement
            val elementClassName =
                elementUtils.getPackageOf(variableElement).qualifiedName.toString()
            var bindViewCreatorProxy = mProxyMap[elementClassName]
            if (bindViewCreatorProxy == null) {
                bindViewCreatorProxy = BindViewCreatorProxy(
                    elementUtils,
                    variableElement.enclosingElement as TypeElement
                )
                mProxyMap[elementClassName] = bindViewCreatorProxy
            }
            val bindAnnotation = variableElement.getAnnotation(BindView::class.java)
            val value = bindAnnotation.value
            bindViewCreatorProxy.put(value, variableElement)
        }

        for (key in mProxyMap.keys) {
            val proxyInfo = mProxyMap[key]
            val javaFile = JavaFile.builder(
                proxyInfo?.getPackageName(),
                proxyInfo?.generateJavaClass()
            ).build()
            try {
                //　生成文件
                javaFile.writeTo(processingEnv.filer)
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }



        return true
    }
}