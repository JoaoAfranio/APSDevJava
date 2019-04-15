package locadora.diurno.converter;


import java.io.Serializable;
import java.lang.reflect.Field;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.Id;

@FacesConverter(value = "entityConverter", managed = true)
public class EntityConverter implements Converter<Object> {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent component, String string) {
        try {
        	
            String[] split = string.split(":");

            Object instance = Class.forName(split[0]).newInstance();
            Class<? extends Object> clazz = instance.getClass();

            Class<?> type = null;

            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(Id.class)) {
                    f.setAccessible(true);
                    type = f.getType();
                }
            }

            if (type != null) {

                Serializable id = null;

                if (type == Short.class) {
                    id = Short.parseShort(split[2]);
                }

                if (type == Integer.class) {
                    id = Integer.parseInt(split[2]);
                }

                if (type == Long.class) {
                    id = Long.parseLong(split[2]);
                }
                
                if (type == String.class) {
                    id = split[2];
                }
                
                Class<?> classe = Class.forName(split[0]);
                Object objeto =  classe.newInstance();
                
                Field f1 = classe.getDeclaredField(split[1]);
                f1.setAccessible(true);
                f1.set(objeto, id);
              
                return objeto;
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }	

        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent component, Object object) {
        try {
            Class<? extends Object> clazz = object.getClass();
            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(Id.class)) {
                    f.setAccessible(true);
                    return clazz.getCanonicalName() + ":" + f.getName() + ":" + f.get(object).toString();
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException e) {
        	
        }
        return null;
    }

}
