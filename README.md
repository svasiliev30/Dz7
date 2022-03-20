# JavaSchool
Материалы для занятий по Java

Домашнее задание к занятию № 3, 4 

Работу выполняем в созданных репозиториях от первой ДР (копируем из этого проекта нужные пакеты и классы)

1. Написать реализации всех методов в классе MyIOExample (подробности в javadocs над каждым методом);
2. Написать реализации всех методов в классе WorkWithExceptions (подробности в javadocs над каждым методом);
3. Напишите реализацию класса User (создайте класс, добавьте поля, конструкторы, геттеры, переопределите необходимые
   методы).


Домашнее задание к занятию № 5, 6

Продолжаем работать в уже созданных репозиториях

1. Реализовать класс CustomArrayImpl<T>, который представляет динамический массив:
      - Класс CustomArrayImpl реализует интерфейс CustomArray<T>;
      - Класс CustomArrayImpl может хранить объекты любого типа;
      - Класс CustomArrayImpl может динамически расширяться;
      - Добавить кострукторы: ustomArrayImpl(), CustomArrayImpl(int capacity), CustomArrayImpl(Collection<T> c);
2. Написать unit тесты;
3. Написать java docs;
4. Изменять CustomArray<T> нельзя.


Домашнее задание к занятию № 7, 8

Продолжаем работать в уже созданных репозиториях

1. Написать компаратор CustomDigitComparator, который реализует интерфейс Comparator<Integer>.
   Класс CustomDigitComparator определяет следующий порядок:
      - Сначала четные числа, затем нечетные;
      - На вход подаются числа, отличные от null;
   
2. Реализовать класс Person{name, city, age}, определить метод toString.
   Класс Person реализует интерфейс Comparable<Person>, который обеспечивает следующий порядок:
   - Сортировка сначала по полю city, а затем по полю name;
   - Поля name, city отличны от null;
3. Написать unit тесты;
4. Написать java docs.


Домашнее задание к занятию № 9, 10

Продолжаем работать в уже созданных репозиториях

1. Сделать как минимум 3 метода для поиска дубликатов. Метод на вход принимает коллекцию (любой тип данных).
   Исходящие данные - коллекция элементов, имеющих дубликаты.
   
2. Написать unit тесты;
3. Написать java docs;
4. Доп. задание: написать метод, который на вход получает строку, содержащую скобочки (корректный пример "(){}[]").
   Результат работы метода булевое значение: true, если последовательность правильная. Правильная - если скобочки открыты и
   закрыты корректно. Некорректные примеры: "[(])", "{", ")", "({[][({((()))})(])]})". Корректные примеры: "(){}[]",
   "{([({})])}".
   
   
Домашнее задание к занятию № 11, 12

Продолжаем работать в уже созданных репозиториях

1. Написать реализации всех методов в классе MyIOExample с применением NIO2 (подробности в javadocs над каждым методом);
2. Написать unit тесты;
3. Написать java docs;
4. Создать таблицу для хранения данных об Person (из ДЗ 7,8) и реализовать основные CRUD операции для этой таблицы с использованием JDBC;
5. Доп. задание: Необходимо написать класс ArrayIterator который умеет работать с массивами T[][].


Домашнее задание к занятию № 13, 14

Продолжаем работать в уже созданных репозиториях

1. Написать реализацию REST сервиса для работы с CRUD операциями (из ДЗ 11,12). Используем RestTemplate;
2. Написать unit тесты;
3. Написать java docs;
4. Каждый реквест к БД должен отправляться в новом потоке;
5. Доступ к таблице сделать потокобезопасным (синхронизировать доступ);
6. Доп. задание: добавить таблицу со статическими (справочными) данными по персоне и для этих данных в приложении реализовать кэш (чтобы, например, при добавлении новой записи в БД можно было данные подтянуть из кэша, а не из БД). Реализация кэша должна быть своя (готовый нельзя использовать).
