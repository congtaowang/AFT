package cn.aft.sample.designpattern.cor;

/**
 * 16/1/31 by congtaowang.
 * Version 1.0
 */
public class Director extends Leader {

    public Director(String role, Leader myLeader, ResolveCallBack callBack) {
        super(role, myLeader, callBack);
    }

    @Override
    protected boolean canResolve(int expense) {
        return expense <= 10000;
    }

    @Override
    protected void resolve(int expense) {
        callBack.onResolve("我是" + role + ",我可以帮你签" + expense + "元报销单的字");
    }
}
