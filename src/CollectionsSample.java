import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CollectionsSample extends JFrame {
    private JPanel jpBottomMenu;


    private class Box {

        private int width;
        private int height;

        Box(int width, int height){
            this.width = width;
            this.height = height;
        }

        int getPerimeter() {
            return width + height;
        }

        @Override
        public String toString() {
            return "Box: " + width + " " + height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Box)) return false;

            Box box = (Box) o;

            if (width != box.width) return false;
            return height == box.height;
        }

        @Override
        public int hashCode() {
            int result = width;
            result = 31 * result + height;
            return result;
        }
    }

    private Box box1 = new Box(1, 1);
    private Box box2 = new Box(2, 2);
    private Box box3 = new Box(3, 3);


    public CollectionsSample() {
        setTitle("CardLayout sample");
        setBounds(100, 100, 1000, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        initMenus();
    }

    private void initMenus() {
        jpBottomMenu = getBottomMenu();
        this.add(jpBottomMenu, BorderLayout.SOUTH);
        //
        JPanel jpMainMenu = getMainMenu();
        jpBottomMenu.add(jpMainMenu, "jpMainMenu");
        ((CardLayout) jpBottomMenu.getLayout()).show(jpBottomMenu, "jpMainMenu");
    }

    private JPanel getBottomMenu() {
        JPanel jpBottom = new JPanel(new CardLayout());
        jpBottom.setPreferredSize(new Dimension(1, 60)); //
        return jpBottom;
    }

    private JPanel getMainMenu() {
        JPanel jpMainMenu = new JPanel(new GridLayout());
        //Button start learning
        JButton jbButton1 = new JButton("Run");
        jbButton1.addActionListener(e -> {
            //
            demoArrayList();
            demoLinkedList();
            demoHashSet();
            demoLinkedHashSet();
            demoTreeSet();
            demoHashMap();
            demoLinkedHashMap();
            demoTreeMap();
        });
        jpMainMenu.add(jbButton1);
        return jpMainMenu;
    }

    private void demoArrayList(){
        System.out.println("ArrayList: ");
        ArrayList<Box> list = new ArrayList<>();
        list.add(box2);
        list.add(box1);
        list.add(box3);

        Iterator<Box> iterator = list.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + "; ");
        System.out.println();
        for(Box box : list) System.out.print(box + "; ");
    }

    private void demoLinkedList(){
        System.out.println();
        System.out.println("LinkedList: ");
        LinkedList<Box> list = new LinkedList<>();
        list.add(box2);
        list.add(box1);
        list.add(box3);
        for(Box box : list) System.out.print(box + "; ");
    }

    private void demoHashSet(){
        System.out.println();
        System.out.println("HashSet: ");
        HashSet<String> set = new HashSet<>();
        set.add("Альфа");
        set.add("Браво");
        set.add("Дельта");
        set.add("Эхо");
        set.add("Фокстрот");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + "; ");
        System.out.println();
        for(String s : set) System.out.print(s + "; ");
    }

    private void demoLinkedHashSet(){
        System.out.println();
        System.out.println("LinkedHashSet: ");
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("Альфа");
        set.add("Браво");
        set.add("Дельта");
        set.add("Эхо");
        set.add("Фокстрот");
        for(String s : set) System.out.print(s + "; ");
    }

    private void demoTreeSet(){
        System.out.println();
        System.out.println("TreeSet: ");
        TreeSet<Box> set = new TreeSet<>(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o1.getPerimeter() - o2.getPerimeter();
            }
        });
        set.add(box3);
        set.add(box1);
        set.add(box2);
        for(Box box : set) System.out.print(box + "; ");
    }

    private void demoHashMap(){
        System.out.println();
        System.out.println("HashMap: ");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Январь", 1);
        map.put("Февраль", 2);
        map.put("Март", 3);
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.print("key=" + entry.getKey() + " value=" + entry.getValue() + "; ");
        }
        System.out.println();
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.print("key=" + entry.getKey() + " value=" + entry.getValue() + "; ");
        }
    }

    private void demoLinkedHashMap(){
        System.out.println();
        System.out.println("LinkedHashMap: ");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Январь", 1);
        map.put("Февраль", 2);
        map.put("Март", 3);
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.print("key=" + entry.getKey() + " value=" + entry.getValue() + "; ");
        }
    }

    private void demoTreeMap(){
        System.out.println();
        System.out.println("TreeHashMap: ");
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Январь", 1);
        map.put("Февраль", 2);
        map.put("Март", 3);
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.print("key=" + entry.getKey() + " value=" + entry.getValue() + "; ");
        }
    }
}
