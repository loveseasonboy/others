package Obserable;

/**
 * 观察者模式（观察者）
 *
 */
public interface Observer {

    void update();

    /**
     * 用于传输数据
     * @param object
     */
    void update(Object object);
}
