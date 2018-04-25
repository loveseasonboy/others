package Obserable;

/**
 * 缺点
 *    1、观察者的通知次序是无法确定的，如果在这个上面要确定是比较困难的。（毕竟有订阅和退订的观察者）
 *    2、主题的扩展不是太好，都是继承的（无法实现多继承），jdk的Observable 也是相同的，实现多对多的问题比较复杂
 */
public class ObservableTest {
    public static void main(String[] args) {
        Subject subject = new NewSubject();
        Observer observer = new MomingObserver(subject);

        MomingNew momingNew = new MomingNew();
        momingNew.setHead("jdk1.9 发布了");
        momingNew.setContent("本次的更新内容如下：");
        momingNew.setLast("欢迎各位的关注！");

        subject.notifyMessage(momingNew);
        ((MomingObserver) observer).readLast();
    }
}
