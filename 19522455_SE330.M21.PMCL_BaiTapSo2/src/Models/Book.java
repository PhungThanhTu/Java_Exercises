package Models;

import java.util.Scanner;

/**
 * Enum status of books, only 2 status New (mới), Scratched (Trầy xước)
 */
enum BookStatus {
    New,
    Scratched,
}

/**
 * Books in the store, inherited from Product
 */
public class Book extends Product {



    //<editor-fold desc="Fields">
    private String Publisher;
    private int NoOfPages;
    private BookStatus Status;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Book() {
        super();
        Publisher = "Undefined";
        NoOfPages = 1;
        Status = BookStatus.New;
    }

    //</editor-fold>


    //<editor-fold desc="Getters and Setters">
    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public int getNoOfPages() {
        return NoOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        NoOfPages = noOfPages;
    }

    public BookStatus getStatus() {
        return Status;
    }

    public void setStatus(BookStatus status) {
        Status = status;
    }
    //</editor-fold>

    //<editor-fold desc="Methods">
    @Override
    public void print() {
        super.print();
        System.out.println("Nha xuat ban : " + getPublisher());
        System.out.println("So trang : "+ getNoOfPages());
        System.out.println("Trang thai : " + (Status == BookStatus.New ? "Moi" : "Cu"));
        System.out.println("Thanh tien : " + getBills());
    }

    @Override
    public void insert() {
        super.insert();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nha xuat ban : ");
        setPublisher(sc.nextLine());
        System.out.println("So trang : ");
        setNoOfPages(sc.nextInt());
        System.out.println("Trang thai : 0 - moi, so khac - cu");
        int stt = sc.nextInt();
        if (stt == 0) {
            setStatus(BookStatus.New);
        } else {
            setStatus(BookStatus.Scratched);
        }

    }

    @Override
    public int getBills() {

        return (int)(Status == BookStatus.New ? getPrice()*getCount() : getPrice()*getCount()*0.7);
    }

    @Override
    public void displayChangeMenu() {
        super.displayChangeMenu();
        System.out.println("5 - Nha xuat ban");
        System.out.println("6 - So trang");
        System.out.println("7 - Trang thai");
    }

    @Override
    public void dataChangeMenu(int chosen) {
        super.dataChangeMenu(chosen);
        if(chosen > 4) {
            Scanner sc = new Scanner(System.in);
            switch (chosen) {
                case 5 -> {
                    System.out.println("Nhap nha xuat ban :");
                    setPublisher(sc.nextLine());
                }
                case 6 -> {
                    System.out.println("Nhap so trang :");
                    setNoOfPages(sc.nextInt());
                }
                case 7 -> {
                    System.out.println("Nhap trang thai : ");
                    System.out.println("0 - moi ");
                    System.out.println("1 - cu ");
                    System.out.println("So khac - giu nguyen trang thai cu");
                    int choice;
                    choice = sc.nextInt();
                    if (choice == 0)
                        setStatus(BookStatus.New);
                    if (choice == 1)
                        setStatus(BookStatus.Scratched);
                }
                default -> {
                    System.out.println("Lua chon khong hop le, nhap so bat ki de tiep tuc");
                    sc.nextInt();
                }
            }
        }
    }
    //</editor-fold>
}
