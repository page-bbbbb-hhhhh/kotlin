// !LANGUAGE: +NewInference
// !DIAGNOSTICS: -UNUSED_VARIABLE -ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE -UNUSED_VALUE -UNUSED_PARAMETER -UNUSED_EXPRESSION
// SKIP_TXT
// FULL_JDK

/*
 * KOTLIN DIAGNOSTICS SPEC TEST (NEGATIVE)
 *
 * SPEC VERSION: 0.1-313
 * PLACE: expressions, when-expression -> paragraph 4 -> sentence 1
 * NUMBER: 1
 * DESCRIPTION:  it is possible to  replace the else condition with an always-true condition
 */

// FILE: JavaEnum.java

enum JavaEnum {
    Val_1,
    Val_2,
}

// FILE: KotlinClass.kt

// TESTCASE NUMBER: 1
fun case1() {
    val z = JavaEnum.Val_1
    val when2 = when (z) {
        JavaEnum.Val_1 -> { }
        JavaEnum.Val_1 -> { }
    }

}

// TESTCASE NUMBER: 2

fun case2() {
    val b = false
    val when2: Any = when (b) {
        false -> { }
        false -> { }
    }
}

// TESTCASE NUMBER: 3

fun case3() {
    val a = false
    val when2: Any = when (a) {
        true -> { }
        true -> { }
    }
}

// TESTCASE NUMBER: 4

fun case4() {
    val x: SClass = SClass.B()
    val when2 = when (x){
        is  SClass.A ->{ }
        is  SClass.B ->{ }
        is  SClass.B ->{ }
    }
}

sealed class SClass {
    class A : SClass()
    class B : SClass()
    class C : SClass()
}