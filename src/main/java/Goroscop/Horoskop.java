package Goroscop;

public class Horoskop {

    public static void main(String[] args)
    {
        String znak = "Козерог";
        System.out.println(goroscop(znak));
    }

    public static String goroscop(String znak) {

        if(znak.equals("Козерог"))
        {
            return "Вас ждет удачный день.";
        }

        if(znak.equals("Водолей"))
        {
            return "Берегите деньги сегодня.";
        }

        if(znak.equals("Рыбы"))
        {
            return "Вы встретите свою любовь.";
        }

        if(znak.equals("Овен"))
        {
            return "Позвоните маме.";
        }

        if(znak.equals("Телец"))
        {
            return "Вас ждет хорошая новость.";
        }

        if(znak.equals("Близнеци"))
        {
            return "Вас ждет хорошая новость.";
        }

        if(znak.equals("Рак"))
        {
            return "Ваши дела идут хорошо.";
        }

        if(znak.equals("Лев"))
        {
            return "Позвоните другу.";
        }

        if(znak.equals("Дева"))
        {
            return "Не забудьте поздравить друга с денм рождения.";
        }

        if(znak.equals("Весы"))
        {
            return "Вернить долг сотруднику.";
        }

        if(znak.equals("Скорпион"))
        {
            return "Все будет хорошо.";
        }

        if(znak.equals("Стрелец"))
        {
            return "Улыбайтесь чаще.";
        }
        return "Улыбайтесь чаще.";
    }
}
