package com.lx.test.common.mvp;

/**
 * 描述了将一个 Model 对象绑定到 View 上的逻辑. Presenter 描述了这个 View 的业务逻辑，
 * 对于业务逻辑，我们采用组合模式来大幅度提升 Presenter 的复用性.
 * <p/>
 * Presenter 的基础类，所有 Presenter 需要继承此类，重写 bind 方法，对 BaseView 和 BaseModel 进行绑定
 *
 * @author liuxu@gotokeep.com (Liu Xu)
 */
public abstract class BasePresenter<V extends BaseView, M> {

    protected V view;

    public BasePresenter(V view) {
        this.view = view;
    }

    /**
     * 在数据到来之前，绑定一些常量到 View 上
     */
    public void preBind() {}

    /**
     * 将 Model 绑定到 View 单元上。
     *
     * @param model model
     */
    public abstract void bind(M model);

    /**
     * 在 Presenter 被遗弃时被调用。
     * <p/>
     * 一些 Presenter，在遇到重用的场景，比如 ListView 或者 RecyclerView 时，
     * 这时旧的Presenter就会被遗弃或者暂时回收，此时这个方法会被调用。
     * <p/>
     * 如果你的 Presenter 在被丢弃时还可能工作(例如反注册listener)，那么你需要重写这个方法，
     * 并保证调用完这个方法能正常的回收或遗弃此 Presenter。
     */
    public void unbind() {}
}
