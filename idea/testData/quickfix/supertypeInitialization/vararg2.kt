// "Add constructor parameters from Base(Int, IntArray)" "true"
open class Base(p1: Int, vararg p2: Int)

class C(p2: IntArray) : Base<caret>