package com.lx.test.common.mvp;

import android.view.View;

/**
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public interface BaseView {

    /**
     * 提供这个 view 的引用，保护实体 view
     */
    View getView();
}
