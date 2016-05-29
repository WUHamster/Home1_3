package annotation3;

import java.io.IOException;

/**
 * Created by WUHamster on 28.05.2016.
 * 3. Написать код, который сериализирует и десериализирует в/из файла все значения полей класса, которые
 отмечены аннотацией @Save.
 */
public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        ToSerialize test = new ToSerialize();
        test.setdNumber(12.5);
        test.setiNumber(3);
        test.setText("some text");

        Serializer.serialize(test);
        ToSerialize result = Serializer.deSerialize();
        System.out.println(result.getText() + ":" + result.getdNumber() + ":" + result.getiNumber());

    }
}
