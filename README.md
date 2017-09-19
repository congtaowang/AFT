AFT
=======================
Android development framework and tools

##Compile
compile 'cn.aft:libs:1.0.3'



##目录
* Framework部分
* 模板部分
* Tools部分


Framework部分
=========================

抽象UI基类BaseMvpActivity和BaseMvpFragment构建界面，在其生命周期中使用抽象主导器BasePresenter派生子类实现内部逻辑。主导器与UI类之间通过接口BaseView（或其子类进行交互）

==========================

#开始使用
##如何扩展BaseMvpActivity

```java
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends BaseMvpActivity<V, P> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //此处可以添加一些相关activity的配置内容
        super.onCreate(savedInstanceState);
    }
}
```
同样，BaseMvpFragment的扩展同理

##如何使用BaseMVPActivity、BasePresenter、BaseView构建一个具有MVP结构的Activity
扩展BaseView接口，最终在对应activity中实现
```java
public interface MainView extends BaseView{
}
```
扩展BasePresenter，在activity调用实际功能
```java
public class MainPresenter extends BasePresenter<MainView> {
}
```
实现Activity
```java
public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView{

    @Override
    protected MainPresenter createPresenterInstance() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewCreated() {
        attachClickListener(R.id.toast);
        attachClickListener(R.id.baseAdapter);
        attachClickListener(R.id.recyclerImageView);
        attachClickListener(R.id.album);
        attachClickListener(R.id.designPattern);
        attachClickListener(R.id.cardView);
    }

    @Override
    protected void onViewClicked(View view, int id) {
        switch (id) {
            case R.id.toast:
                showToastMsg("Toast");
                break;
            case R.id.baseAdapter:
                LauncherManager.getLauncher().launch(getActivity(), SimpleAdapterActivity.class);
                break;
            case R.id.recyclerImageView:
                LauncherManager.getLauncher().launch(getActivity(), SimpleFrescoImageViewsActivity.class);
                break;
            case R.id.album:
                LauncherManager.getLauncher().launch(getActivity(), AlbumActivity.class);
                break;
            case R.id.designPattern:
                LauncherManager.getLauncher().launch(getActivity(), PatternsActivity.class);
                break;
            case R.id.cardView:
                LauncherManager.getLauncher().launch(getActivity(), CardViewActivity.class);
                break;
        }
    }
}

```
在activity中使用_presenter调用Presenter中的实现逻辑，在Presenter中使用getView()方法获取View接口进行界面数据展示
