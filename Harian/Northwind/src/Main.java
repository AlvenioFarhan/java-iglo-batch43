import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }


    //----------------------------------------------------------------------

    public static void printOrderDetailByCategory(Category category){
        //munculkan tanggal order, nama produk, quantity pembelian di order tersebut.
        //tanggal order  = dd/MM/yyyy
        category.printProductInformation();
    }



    //----------------------------------------------------------------------

//    public static LinkedList<ReportOrder> getLowCostOrder (Customer customer, Double maxLimit){
//
//        /*
//         *
//         * kumpulan order yang totalCost nya dibawah maxLimit
//         *
//         * OrderId , TotalCost
//         * */
//        LinkedList<ReportOrder> reports = new LinkedList<>();
//        for (Order order : customer.getOrders()){
//            if (order.getTotalCost() < maxLimit){
//              reports.add(new OrderReport(order.getId, order.getTotalCost()));
//            }
//        } return reports;
//    }
}