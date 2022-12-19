
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManageSystem {
    public StudentManageSystem() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList();

        while(true) {
            System.out.println("------------欢迎来到学生管理系统------------");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5:退出");
            System.out.println("-----------------------------------------");
            System.out.println("请输入您的选择:");
            switch (sc.nextInt()) {
                case 1:
                    list.add(CreateStudent(list));
                    break;
                case 2:
                    list = RemoveStudent(list);
                    break;
                case 3:
                    list = UpdateStudent(list);
                    break;
                case 4:
                    SearchStudent(list);
                    break;
                case 5:
                    System.out.println("退出成功");
                    return;
            }
        }
    }

    public static Student CreateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();
        System.out.println("请输入该生的id");
        String id = sc.next();
        if (IdRepeat(list, id)) {
            stu.setId(id);
            System.out.println("请输入该生的姓名");
            stu.setName(sc.next());
            System.out.println("请输入该生的年龄");
            stu.setAge(sc.nextInt());
            System.out.println("请输入该生的家庭住址");
            stu.setAddress(sc.next());
            System.out.println("添加成功");
            return stu;
        } else {
            System.out.println("id重复！");
            return stu;
        }
    }

    public static boolean IdRepeat(ArrayList<Student> list, String id) {
        for(int i = 0; i < list.size(); ++i) {
            if (id.equals(((Student)list.get(i)).getId())) {
                return false;
            }
        }

        return true;
    }

    public static ArrayList<Student> RemoveStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生id");
        String id = sc.next();
        if (IdRepeat(list, id)) {
            System.out.println("删除失败，没有这id");
            return list;
        } else {
            for(int i = 0; i < list.size(); ++i) {
                if (id.equals(((Student)list.get(i)).getId())) {
                    list.remove(i);
                    break;
                }
            }

            System.out.println("删除成功");
            return list;
        }
    }

    public static ArrayList<Student> UpdateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要修改的学生id");
        String id = sc.next();
        if (IdRepeat(list, id)) {
            System.out.println("没有这个id！");
            return list;
        } else {
            for(int i = 0; i < list.size(); ++i) {
                if (id.equals(((Student)list.get(i)).getId())) {
                    System.out.println("请输入需要修改的id");
                    ((Student)list.get(i)).setId(sc.next());
                    System.out.println("请输入需要修改的姓名");
                    ((Student)list.get(i)).setName(sc.next());
                    System.out.println("请输入需要修改的年龄");
                    ((Student)list.get(i)).setAge(sc.nextInt());
                    System.out.println("请输入需要修改的家庭住址");
                    ((Student)list.get(i)).setAddress(sc.next());
                }
            }

            System.out.println("修改成功");
            return list;
        }
    }

    public static void SearchStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入关键词");
        String search = sc.next();
        ArrayList<Student> search_List = new ArrayList();
        new Student();

        int i;
        for(i = 0; i < list.size(); ++i) {
            if (search.equals(((Student)list.get(i)).getId())) {
                search_List.add((Student)list.get(i));
            }

            if (search.equals(((Student)list.get(i)).getName())) {
                search_List.add((Student)list.get(i));
            }

            if (search.equals(((Student)list.get(i)).getAddress())) {
                search_List.add((Student)list.get(i));
            }
        }

        if (search_List.size() != 0) {
            System.out.println("为您找到" + search_List.size() + "条结果");

            for(i = 0; i < search_List.size(); ++i) {
                PrintStream var10000 = System.out;
                String var10001 = ((Student)search_List.get(i)).getId();
                var10000.println(var10001 + " " + ((Student)search_List.get(i)).getName() + " " + ((Student)search_List.get(i)).getAge() + " " + ((Student)search_List.get(i)).getAddress());
            }
        } else {
            System.out.println("没有学生信息,请插入后再来查询！");
        }

    }
}
