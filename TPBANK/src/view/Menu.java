package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu<T> {

    protected String title;
    protected ArrayList<T> list = new ArrayList<>();

    public Menu(String title, String[] list) {
        this.title = title;
        for (String item : list) {
            this.list.add((T) item);
        }
    }

    public void display() {
        System.out.println(title);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your selection: ");
        return sc.nextInt();
    }

    public abstract void execute(int choice);

    public void run() {
        int choice = list.size() + 1;
        while (choice != list.size()) {
            try {
                display();
                choice = getChoice();
            } catch (InputMismatchException e) {
                choice = list.size() + 1;
            }
            execute(choice);
        }
    }
}