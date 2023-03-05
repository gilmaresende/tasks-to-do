package com.condelar.todo.app.tools;

public class ToolBase {
    public static Boolean isEquals(Object ob1, Object ob2){
        if (ob1 == null && ob2 == null){
            return true;
        }else if(ob1 != null){
            return ob1.equals(ob2);
        }
        return false;
    }

    public static Boolean isNull(Object ob){
        return ob == null;
    }
}
