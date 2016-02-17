package cn.aft.sample.tools;

import java.util.ArrayList;
import java.util.List;

import cn.aft.sample.AFTApplicatioin;
import cn.aft.sample.R;
import cn.aft.sample.bean.SimpleDisplayer;

/**
 * 16/1/28 by congtaowang.
 * Version 1.0
 */
public class BeanFactory {

    public static List<SimpleDisplayer> createSimpleDisplayer(int size) {

        String[] urls = AFTApplicatioin.getInstance().getResources().getStringArray(R.array.picUrls);
        String[] thumbUrls = AFTApplicatioin.getInstance().getResources().getStringArray(R.array.thumbUrls);

        if (urls.length < 0) {
            throw new IllegalArgumentException("ArrayList size can't less then 0");
        }

        ArrayList<SimpleDisplayer> displayers = new ArrayList<>(size);
        for (int index = 0; index < urls.length; index++) {
            SimpleDisplayer displayer = new SimpleDisplayer();
            displayer.setDesc("This is the " + index + " item");
            displayer.setPic(urls[index]);
            displayer.setThumbPic(thumbUrls[index]);
            displayers.add(displayer);
        }
        return displayers;
    }
}
