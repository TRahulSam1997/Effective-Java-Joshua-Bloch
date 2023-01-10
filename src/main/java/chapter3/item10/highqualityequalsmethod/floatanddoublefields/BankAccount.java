package chapter3.item10.highqualityequalsmethod.floatanddoublefields;

class BankAccount {
    private String accountNumber;
    private double balance;
    private boolean isActive;

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof BankAccount)) {
            return false;
        }

        BankAccount ba = (BankAccount) o;

        /** Compare primitive fields using == operator. */
        if (isActive != ba.isActive) {
            return false;
        }

        /** Compare object reference fields using the equals() method. */
        if (!accountNumber.equals(ba.accountNumber)) {
            return false;
        }

        /** Compare double fields using the Double.compare() method. */
        if (Double.compare(balance, ba.balance) != 0) {
            return false;
        }

        return true;
    }
}
