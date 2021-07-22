package summary;

import java.util.concurrent.atomic.AtomicInteger;

public class Summary {

    private AtomicInteger winsCount = new AtomicInteger(0);

    private AtomicInteger loseCount = new AtomicInteger(0);

    private AtomicInteger tieCount = new AtomicInteger(0);

    public void incWinCount() {
        winsCount.getAndIncrement();
    }

    public void incLooseCount() {
        loseCount.getAndIncrement();
    }

    public void incTieCount() {
        tieCount.getAndIncrement();
    }


    @Override
    public String toString() {
        return " win count : " + winsCount.get() +
                " loseCount : " + loseCount.get() +
                " tie count : " + tieCount.get();
    }
}
