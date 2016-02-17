package cn.aft.sample.designpattern.cor;

import cn.aft.tools.Logger;
import cn.aft.tools.Predictor;

/**
 * 16/1/31 by congtaowang.
 * Version 1.0
 */
public abstract class Leader {

    protected String role;
    protected Leader myLeader;
    protected ResolveCallBack callBack;

    public Leader(String role, Leader myLeader, ResolveCallBack callBack) {
        this.role = role;
        this.myLeader = myLeader;
        this.callBack = callBack;
    }

    public void handleAccountRequest(int expense) {
        //是否拥有expense保障金额的权限
        if (canResolve(expense)) {
            resolve(expense);
        } else {
            if (Predictor.isNotNull(myLeader)) {
                myLeader.handleAccountRequest(expense);
            } else {
                Logger.d("无人可以处理当前金额的报账，CEO也不行");
            }
        }
    }

    protected abstract boolean canResolve(int expense);

    protected abstract void resolve(int expense);
}
