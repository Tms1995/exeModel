package cn.superid.jpa.util;

/**
 * Created by zp on 2016/7/19.
 */
public class Expr {
    private String left;
    private String op;
    private Object right;

    public Expr(){};

    public Expr(String left,String op,Object right){
        this.left =left;
        this.right = right;
        this.op =op;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Object getRight() {
        return right;
    }

    public void setRight(Object right) {
        this.right = right;
    }

    public String getSql(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(left);
        stringBuilder.append(op);
        stringBuilder.append("?");
        return stringBuilder.toString();
    }

}
