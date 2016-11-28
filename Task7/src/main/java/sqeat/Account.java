package sqeat;

public class Account {
    boolean blocked = false;
    int bound = 1000000;
    int balance = 0;
    int maxCredit = 1000;

    public boolean deposit(int sum) {
        if (blocked)
            return false;
        else if (sum < 0 || sum > bound)
            return false;
        else {
            balance += sum;
            return true;
        }
    }

    public boolean withdraw(int sum) {
        if (blocked)
            return false;
        else if (sum < 0 || sum > bound + maxCredit)
            return false;
        else if (balance + maxCredit < sum)
            return false;
        else {
            balance -= sum;
            return true;
        }
    }

    public int getBalance() {
        return balance;
    }

    public int getMaxCredit() {
        return maxCredit;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void block() {
        blocked = true;
    }

    public boolean unblock() {
        if (balance <= -maxCredit)
            return false;
        else
            blocked = false;

        return true;
    }

    public boolean setMaxCredit(int mc) {
        if (mc < -bound || mc > bound)
            return false;
        else
            maxCredit = mc;

        return true;
    }
}

