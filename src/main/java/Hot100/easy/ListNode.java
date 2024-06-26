package Hot100.easy;

public class ListNode  implements  Cloneable{
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

   public  ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    @Override
    public ListNode clone() {
        try {
            ListNode clone = (ListNode) super.clone();
            // TODO: 复制此处的可变状态，这样此克隆就不能更改初始克隆的内部项
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
