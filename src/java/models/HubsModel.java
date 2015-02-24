package models;

import java.util.ArrayList;

public class HubsModel {
    
    public ArrayList<String> title, text;
    
    public HubsModel(){
        title = new ArrayList<String>();
        title.add("Разыменовывание нулевого указателя приводит к неопределённому поведению"); 
        title.add("ЧПУ фрезерный станок с автономным контроллером на STM32");
        title.add("Не CDN единым");
        title.add("Прокачиваем умную зарядку Imax B6");
        title.add("Алгоритм формирования кроссвордов");
        title.add("Откуда берутся бреши в безопасности программ?");
        title.add("Эмуляция банковской карты на телефоне");
        title.add("Небезопасное хранение паролей в IBM WebSphere");
        title.add("Седьмая ежегодная Летняя школа Microsoft Research. На этот раз про машинное обучение и интеллект");
        title.add("Сappasity 3D Scan – 3D сканирование с использованием Intel RealSense. Опыт разработки");
 
        text = new ArrayList<String>();
        text.add("text of hub");
        text.add("text of hub");
        text.add("text of hub");
        text.add("text of hub");
        text.add("text of hub");
        text.add("text of hub");
        text.add("text of hub");
        text.add("text of hub");
        text.add("text of hub");
        text.add("text of hub");
    }
}
