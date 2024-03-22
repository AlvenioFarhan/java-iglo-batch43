public enum MetodePembayaran {
    CC(" Credit Card"),
    AC("Auto Debit/Collection"),
    VP(" Voucher Prabayar");

    private String label;

    MetodePembayaran(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static MetodePembayaran getMetodePembayaranByString(String payment) {
        if (payment.equals("CC")){
            return MetodePembayaran.CC;
        } else if (payment.equals("AC")) {
            return MetodePembayaran.AC;
        }else {
            return MetodePembayaran.VP;
        }
    }
}
