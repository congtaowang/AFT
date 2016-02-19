package cn.aft.sample.tools;

import java.util.ArrayList;
import java.util.List;

import cn.aft.sample.AFTApplicatioin;
import cn.aft.sample.R;
import cn.aft.sample.bean.Card;
import cn.aft.sample.bean.SimpleDisplayer;
import cn.aft.tools.Data;

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

    public static List<Card> createCards() {
        String[] urls = AFTApplicatioin.getInstance().getResources().getStringArray(R.array.picUrls);
        int size = Data.getSize(urls);

        ArrayList<Card> cards = new ArrayList<>(size);
        for (int index = 0; index < size; index++) {
            Card card = new Card();
            card.setImgUrl(urls[index]);
            card.setTitle("标题" + index);
            card.setContent("内容" + index);
            cards.add(card);
        }

        return cards;
    }
}
