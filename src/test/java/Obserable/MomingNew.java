package Obserable;

public class MomingNew extends NewSubject {
    private String head;
    private String content;
    private String last;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "MomingNew{" +
                "head='" + head + '\'' +
                ", content='" + content + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
