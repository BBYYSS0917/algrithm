package tree;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;

    // 当前 Priority Queue 中的元素个数
    private int size = 0;

    // 父节点的索引
    public int parent(int root) {
        return root / 2;
    }

    // 左孩子的索引
    public int left(int root) {
        return root * 2;
    }

    // 右孩子的索引
    public int right(int root) {
        return root * 2 + 1;
    }

    public MaxPQ(int cap) {
        pq = (Key[]) new Comparable[cap + 1];
    }

    public Key max() {
        return pq[1];
    }

    public void insert(Key e) {
        size++;
        // 先把新元素加到最后 然后让它上浮到正确的位置
        pq[size]=e;
        swim(size);
    }

    public Key delMax() {
        Key max=pq[1];
        swap(1, size);
        pq[size]=null;
        size--;
        sink(1);
        return max;
    }

    /* 上浮第 x 个元素，以维护最大堆性质 */
    private void swim(int x) {
         // 如果浮到堆顶，就不能再上浮了
        while(x>1 && less(parent(x),x)){
            // 如果第 x 个元素比上层大
            // 将 x 换上去
            swap(parent(x), x);
            x=parent(x);
        }
    }

    /* 下沉第 x 个元素，以维护最大堆性质 */
    private void sink(int x) {
        // 如果沉到堆底，就沉不下去了
        while(left(x)<=size){
            // 先假设左边节点较大
            int max=left(x);
            // 如果右边节点存在，比一下大小
            if (right(x) <= size && less(max, right(x))){
                max=right(x);
            }
            // 结点 x 比俩孩子都大，就不必下沉了
            if(less(max,x)){
                break;
            }
            // 否则，不符合最大堆的结构，下沉 x 结点
            swap(x, max);
            x=max;
        }

    }

    /* 交换数组的两个元素 */
    private void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /* pq[i] 是否比 pq[j] 小？ */
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

}
