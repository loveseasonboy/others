package Obserable;

/**
 * 早报的订阅者
 */
public class MomingObserver implements Observer {

    public MomingObserver(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update() {
        update(null);
    }

    @Override
    public void update(Object object) {
        if (object instanceof MomingNew) {
            MomingNew momingNew = (MomingNew) object;
            System.out.println(momingNew.toString());
        }
    }

    public void readLast(){
        System.out.println("感觉还是不错的新闻！");
    }
}
