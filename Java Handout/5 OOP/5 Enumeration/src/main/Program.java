package main;

public class Program {

	public static void main(String[] args) {

        /* Enumeration adalah sebuah tipe data special dimana kita bisa membatasi developer yang menggunakan class ini
        *  untuk memilih value dari field dalam multiple choice atau pilihan ganda.
        * */
        UserAccount anthony = new UserAccount("anthony", "jackal89", Privileges.MODERATOR, Religion.CHRISTIAN, EmployementStatus.PER);
        System.out.println(anthony.getPrivilageLabel());
        System.out.println(anthony.getReligion().getLabelDalamIndonesia());
        System.out.println(anthony.getStatus().getLabel());
        System.out.println(anthony.getStatus().isEmployee());
	}
}
