package Obserable;

/**
 * 新闻 -早报   -午报   -晚报
 * 观察着的模式（主题内容）
 * 主题的发布
 *
 * 自定义实现观察者模式
 * 1、实现注册用户来订阅新闻
 * 2、新闻一旦有变化就通知订购者
 */
public interface Subject {
    /**
     * 注册用户（订购新闻）
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 删除用户（退订新闻）
     * @param observer
     */
    void deleteObserver(Observer observer);

    /**
     * 发布通知信息
     * @param o
     */
    void notifyMessage(Object o);
    void notifyMessage();
}
