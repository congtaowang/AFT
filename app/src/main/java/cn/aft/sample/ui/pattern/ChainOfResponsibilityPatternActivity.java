package cn.aft.sample.ui.pattern;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import cn.aft.framework.mvp.BaseMvpActivity;
import cn.aft.framework.mvp.BasePresenter;
import cn.aft.framework.mvp.BaseView;
import cn.aft.sample.R;
import cn.aft.sample.designpattern.cor.Boss;
import cn.aft.sample.designpattern.cor.Director;
import cn.aft.sample.designpattern.cor.GroupLeader;
import cn.aft.sample.designpattern.cor.Leader;
import cn.aft.sample.designpattern.cor.Manager;
import cn.aft.sample.designpattern.cor.ResolveCallBack;
import cn.aft.tools.Data;
import cn.aft.tools.Predictor;

/**
 * 16/1/31 by congtaowang.
 * Version 1.0
 */
public class ChainOfResponsibilityPatternActivity extends BaseMvpActivity<BaseView, BasePresenter<BaseView>> implements BaseView {

    @Bind(R.id.expense)
    EditText expense;

    @Bind(R.id.result)
    TextView result;

    private StringBuilder builder = new StringBuilder();

    private Leader groupLeader;
    private Leader director;
    private Leader manager;
    private Leader boss;

    @Override
    protected BasePresenter<BaseView> createPresenterInstance() {
        return new BasePresenter<BaseView>() {
        };
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chainofresponsibility;
    }

    @Override
    protected void onViewCreated() {
        attachClickListener(R.id.submitAccount);
    }

    @Override
    protected void onViewClicked(View view, int id) {
        switch (id) {
            case R.id.submitAccount:
                result.setText("");
                builder.delete(0, builder.length());
                initLeaderIfNecessary();
                groupLeader.handleAccountRequest(getSubmitExpense());
                break;
        }
    }

    private ResolveCallBack callBack = new ResolveCallBack() {
        @Override
        public void onResolve(String msg) {
            builder.append(msg);
            builder.append("\n");
            result.append(builder);
        }
    };

    private void initLeaderIfNecessary() {
        if (Predictor.isNull(boss)) {
            boss = new Boss("Boss", null, callBack);
            manager = new Manager("Manager", boss, callBack);
            director = new Director("Director", manager, callBack);
            groupLeader = new GroupLeader("GroupLeader", director, callBack);
        }
    }

    private int getSubmitExpense() {
        String expense = this.expense.getText().toString();
        if (Predictor.isNull(expense)) {
            showToastMsg("请输入报账金额");
        } else {
            return Data.intValue(expense);
        }
        return 0;
    }
}
