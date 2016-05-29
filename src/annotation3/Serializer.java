package annotation3;


import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by WUHamster on 28.05.2016.
 */
public class Serializer {
    static String fileName = "d://work//test.txt";

    public static void serialize(Object o) throws IOException, IllegalAccessException {
        FileOutputStream  fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Class<?> cls = ToSerialize.class;
        Field[] fields = cls.getFields();
        String toSerialize = "";
        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                if (Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }
                String toWrite = field.getName() + ":" + field.getType().getSimpleName() + ":";
                if (field.getType() == int.class) {
                    toWrite += field.getInt(o) + ";";
                }
                else if (field.getType() == double.class) {
                    toWrite += field.getDouble(o) + ";";
                }
                else if (field.getType() == String.class) {
                    toWrite += field.get(o) + ";";
                }
                toSerialize += toWrite;
                System.out.println(toWrite + " is serialized");
            }
        }
        oos.writeObject(toSerialize);
        fos.close();
        oos.close();
    }

   public static ToSerialize deSerialize () throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
       ToSerialize result = new ToSerialize();
       FileInputStream fis = new FileInputStream(fileName);
       ObjectInputStream ois = new ObjectInputStream(fis);
       String toDeserialize = (String) ois.readObject();
       String[] read = toDeserialize.split(";");
       for (String s : read){
           String toRead[] = s.split(":");
           if (toRead[1].equals("String")) {
               result.setText(toRead[2]);
           }
           else if (toRead[1].equals("int")) {
               result.setiNumber(Integer.parseInt(toRead[2]));
           }
           else if (toRead[1].equals("double")) {
               result.setdNumber(Double.parseDouble(toRead[2]));
           }
       }

       fis.close();
       ois.close();
       return result;
   }

}
