// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
// NoteBook notebook1 = new NoteBook
// NoteBook notebook2 = new NoteBook
// NoteBook notebook3 = new NoteBook
// NoteBook notebook4 = new NoteBook
// NoteBook notebook5 = new NoteBook

// Например: “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет

// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.

// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

// Класс сделать в отдельном файле

// приветствие
// Выбор параметра
// выбор конкретнее
// вывод подходящих   

// Integer Id,
// String productName,
// Float displaySizeInInches,
// Integer romSize,
// Integer ramSize,
// String osType,
// Float price)

import java.util.TreeSet;
import java.util.Scanner;
import java.util.LinkedList;

public class HW_06_01
{
    public static void main(String[] args) 
    {
        // DataInput
        Laptop laptop1 = new Laptop(
            1,
            "Honor MagicBook 15 BohrM-WDQ9BHNE",
            15.6f,
            512,
            8,
            "нет",
            62299.0f
            );

        Laptop laptop2 = new Laptop(
            2,
            "Lenovo V15 G2 ALC",
            15.6f,
            256,
            8,
            "нет",
            42999.0f
            );

        Laptop laptop3 = new Laptop(
            3,
            "MSI Modern 15 B12M-213XRU",
            15.6f,
            512,
            16,
            "нет",
            57999.0f
            );

        Laptop laptop4 = new Laptop(
            4,
            "HUAWEI MateBook D 15 BOD",
            15.6f,
            256,
            8,
            "Windows 11 Home",
            39999.0f
            );

        Laptop laptop5 = new Laptop(
            5,
            "ASUS TUF Gaming A17 FA706QM-HX029W",
            17.3f,
            1000,
            16,
            "Windows 11 Home",
            134999.0f
            );
        
        Laptop laptop6 = new Laptop(
            6,
            "ASUS VivoBook PRO 14 M3401QA-KM133W",
            14f,
            512,
            16,
            "Windows 11 Home",
            64999.0f
            );

        Laptop laptop7 = new Laptop(
            7,
            "Realme Book QHD",
            14f,
            512,
            8,
            "Windows 11 Home",
            59999.0f
            );
        
        Laptop laptop8 = new Laptop(
            8,
            "Apple MacBook Air",
            13.3f,
            256,
            8,
            "macOS",
            77399.0f
            );

        // Make linked list
        LinkedList<Laptop> llLaptop = new LinkedList<>();  
        llLaptop.add(laptop1);
        llLaptop.add(laptop2);
        llLaptop.add(laptop3);
        llLaptop.add(laptop4);
        llLaptop.add(laptop5);
        llLaptop.add(laptop6);
        llLaptop.add(laptop7);
        llLaptop.add(laptop8);

        // 
        Scanner scan = new Scanner(System.in, "CP866");
        Integer menu;

        System.out.println("Вас приветствует электронный магазин!");
        while(true)
        {
            System.out.printf("\nДоступные фильтры:\n");
            System.out.println(" 1. Объем R0M");
            System.out.println(" 2. Объем RAM");
            System.out.println(" 3. Тип OS ");
            System.out.println(" 0. Выход из программы");
            System.out.printf("> ");

            menu = Integer.parseInt(scan.nextLine());

            switch(menu)
            {
                case 0:
                {
                    System.out.println("До свидания!");
                    break;
                }
                case 1:
                {
                    filtrRom(llLaptop, scan);
                    break;
                }
                case 2:
                {
                    filtrRam(llLaptop, scan);
                    break;
                }
                case 3:
                {
                    filtrOs(llLaptop, scan);
                    break;
                }
                default:
                {
                    System.out.println("Ошибка ввода!");
                }
            }

            if (menu==0)
            {
                 break;
            }
        }
        scan.close();

    }

    public static void filtrRom(LinkedList<Laptop> llLaptop, Scanner scan)
    {
        // Get unique values of ROMsize
        TreeSet<Integer> set = new TreeSet<>();
        Integer romSize;
        for (int i=0; i<llLaptop.size();i++)
        {
            romSize = llLaptop.get(i).getRomSize();

            if (!set.contains(romSize))
            {   
                set.add(romSize);
            }
        }
        
        // Show unique values of ROMsize them for user's choice
        Object[] romSizeArr = set.toArray();
        System.out.println("Объем ROM, ГБ: ");
        for (int i=0;i<set.size();i++)
        {
            System.out.printf("\t%d\t%d\n",i+1,(Integer)romSizeArr[i]);
        }
        System.out.println("\t0\tВыход из фильтра");
        System.out.printf("> ");
       
        // Get value for filtr and show filtered results
        Integer menu;
        while (true)
        {
            menu = Integer.parseInt(scan.nextLine());
            if (menu == 0)
            {
                return;
            }
            else if (menu<=set.size())
            {
                //System.out.println("Ок!");
                
                romSize =  (Integer)romSizeArr[menu-1];
                for (int i=0; i<llLaptop.size();i++)
                {
                    if (llLaptop.get(i).getRomSize().equals(romSize))
                    {
                        llLaptop.get(i).printInfo();
                    }
                }
                return;
            }
            else
            {
                System.out.println("Ошибка ввода!");
            }
        }

    }

    public static void filtrRam(LinkedList<Laptop> llLaptop, Scanner scan)
    {
        // Get unique values of RAMsize
        TreeSet<Integer> set = new TreeSet<>();
        Integer ramSize;
        for (int i=0; i<llLaptop.size();i++)
        {
            ramSize = llLaptop.get(i).getRamSize();

            if (!set.contains(ramSize))
            {   
                set.add(ramSize);
            }
        }
        
        // Show unique values of ROMsize them for user's choice
        Object[] ramSizeArr = set.toArray();
        System.out.println("Объем RAM, ГБ: ");
        for (int i=0;i<set.size();i++)
        {
            System.out.printf("\t%d\t%d\n",i+1,(Integer)ramSizeArr[i]);
        }
        System.out.println("\t0\tВыход из фильтра");
        System.out.printf("> ");
       
        // Get value for filtr and show filtered results
        Integer menu;
        while (true)
        {
            menu = Integer.parseInt(scan.nextLine());
            if (menu == 0)
            {
                return;
            }
            else if (menu<=set.size())
            {
                //System.out.println("Ок!");
                
                ramSize =  (Integer)ramSizeArr[menu-1];
                for (int i=0; i<llLaptop.size();i++)
                {
                    if (llLaptop.get(i).getRamSize().equals(ramSize))
                    {
                        llLaptop.get(i).printInfo();
                    }
                }
                return;
            }
            else
            {
                System.out.println("Ошибка ввода!");
            }
        }

    }

    public static void filtrOs(LinkedList<Laptop> llLaptop, Scanner scan)
    {
        // Get unique values of RAMsize
        TreeSet<String> set = new TreeSet<>();
        String os;
        for (int i=0; i<llLaptop.size();i++)
        {
            os = llLaptop.get(i).getOsType();

            if (!set.contains(os))
            {   
                set.add(os);
            }
        }
        
        // Show unique values of ROMsize them for user's choice
        Object[] osArr = set.toArray();
        System.out.println("Тип ОС: ");
        for (int i=0;i<set.size();i++)
        {
            System.out.printf("\t%d\t%s\n",i+1,(String)osArr[i]);
        }
        System.out.println("\t0\tВыход из фильтра");
        System.out.printf("> ");
       
        // Get value for filtr and show filtered results
        Integer menu;
        while (true)
        {
            menu = Integer.parseInt(scan.nextLine());
            if (menu == 0)
            {
                return;
            }
            else if (menu<=set.size())
            {
                //System.out.println("Ок!");
                
                os =  (String)osArr[menu-1];
                for (int i=0; i<llLaptop.size();i++)
                {
                    if (llLaptop.get(i).getOsType().equals(os))
                    {
                        llLaptop.get(i).printInfo();
                    }
                }
                return;
            }
            else
            {
                System.out.println("Ошибка ввода!");
            }
        }

    }

}
