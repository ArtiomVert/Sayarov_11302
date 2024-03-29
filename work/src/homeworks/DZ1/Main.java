package homeworks.DZ1;

public class Main {
/*
00. Ввести линейный односвязный список (далее - список) целых чисел размера n.
01. Найти максимум линейного списка размера n.
02. Проверить наличие в линейном списке элемента равного x.
03. Выполнить сортировку линейного списка целых чисел любым известным вам алгоритмом.
04. Ввести линейный односвязный список целых чисел размера n в прямом порядке.
Вопрос: можно сначала создать список как есть, а потом создать нормальный на его основе?
Ответ: нет, нужно сразу создавать список в прямом порядке.
Подсказка: у списка может быть не только head, но и, например, end

05. Удалить первые два элемента линейного списка.
06. Удалить первое упоминание элемента x в списке
07. Удалить из списка все элементы, равные x.
08. В списке после первого элемента, равного x, вставить y.
09. В списке перед первым элементом, равным x, вставить y.
10. В списке после всех x вставить y. Гарантируется, что x не равно y.
*/
    public static void main(String[] args) {
        MyList list = new MyList(new int[]{11, 2, 1, 30, 40, 11, 5, 9, 5, 11, 5, 6, 5, 11, 5, 8, 7, 6, 11});
        //05
        list.remove(0);
        list.remove(0);
        //06-07
        int index = list.getIndex(5);
        while (index!=-1){
            list.remove(index);
            index = list.getIndex(5);
        }
        //08-09
        list.add(99, list.getIndex(1)+1);
        //10
        MyList is = new MyList();
        int[] l2 = list.getAll();
        for (int i = 0; i < l2.length; i++) {
            if(l2[i] == 11){
                is.add(i);
            }
        }
        l2 = is.getAll();
        for (int i = 0; i < list.count(11); i++){
            list.add(88, l2[i]+1+i);
        }
        //
        int[] l = list.getAll();
        for (int i = 0; i < l.length; i++) {
            System.out.print(l[i] + " ");
        }
        System.out.println();
        System.out.println(list.getMax());
        System.out.println(list.have(7));
        System.out.println(list.have(3));
    }
}