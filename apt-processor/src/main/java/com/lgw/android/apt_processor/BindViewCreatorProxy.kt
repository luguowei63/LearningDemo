package com.lgw.android.apt_processor

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import javax.lang.model.element.Modifier
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement
import javax.lang.model.util.Elements

/**
 *Created by lgw on 1/20/21
 */
class BindViewCreatorProxy(elementUtils: Elements, classElement: TypeElement) {

    private var mBindingClassName: String? = null
    private var mPackageName: String? = null
    private var mTypeElement: TypeElement = classElement
    private var annotationValueMap = mutableMapOf<Int, VariableElement>()

    init {
        mPackageName = mTypeElement.qualifiedName.toString()
        val packageElement = elementUtils.getPackageOf(mTypeElement)
        this.mPackageName = packageElement.qualifiedName.toString()
        val className = mTypeElement.simpleName.toString()
        mBindingClassName = className + "_ViewBinding"

    }


    fun put(value: Int, variableElement: VariableElement) {
        annotationValueMap[value] = variableElement
    }
    //利用javapoet创建代码

    fun generateJavaClass(): TypeSpec {
        return TypeSpec.classBuilder(mBindingClassName).addModifiers(Modifier.PUBLIC)
            .addMethod(generateJavaMethod()).build()
    }


    private fun generateJavaMethod(): MethodSpec {
        val host = ClassName.bestGuess(mTypeElement.qualifiedName.toString())

        val methodSpecBuilder =
            MethodSpec.methodBuilder("bind").returns(TypeName.VOID).addModifiers(Modifier.PUBLIC)
                .addParameter(host, "host")

        for (key in annotationValueMap.keys) {

            val variableElement = annotationValueMap[key]
            val variableName = variableElement?.simpleName.toString()
            val variableType = variableElement?.asType()
            val strBuilder = StringBuilder()
            strBuilder.append("host.")
            strBuilder.append(variableName)
            strBuilder.append("=(")
            strBuilder.append(variableType.toString())
            strBuilder.append(")(((android.app.Activity)host).findViewById( ")
            strBuilder.append(key.toString())
            strBuilder.append("));")

            methodSpecBuilder.addCode(strBuilder.toString())


        }
        return methodSpecBuilder.build()

    }

    fun getPackageName(): String? {
        return mPackageName
    }
}